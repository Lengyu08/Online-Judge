package Match;

import java.sql.SQLSyntaxErrorException;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import Match.Room;

public class Pool {
    private static Queue<String> userQueue = new LinkedList<String>();
    private static Queue<String> releaseQueue = new LinkedList<String>();
    private static Map<String, Integer> userRoomMap = new HashMap<String, Integer>();
    private static Map<String, Integer> matchResultMap = new HashMap<String, Integer>();
    public static final Lock lock = new ReentrantLock();

    // 用户入队
    protected int enqueueUser(String username) {
        System.out.println("User " + username + " has been added to the queue.");

        // 添加用户到队列
        userQueue.offer(username);
        while (true) {
            lock.lock();

            if (userQueue.size() >= 2) {
                // 如果队列中有足够用户，进行匹配
                String user1 = userQueue.poll();
                String user2 = userQueue.poll();
                System.out.println("User " + user1 + " and " + user2 + " has been matched.");

                int roomID = assignRoom();
                userRoomMap.put(user1, roomID);
                userRoomMap.put(user2, roomID);
                System.out.println("Match Success!");
            }

            System.out.println("Waiting for match...");

            System.out.println(username + " get Room " + userRoomMap.get(username));
            if (userRoomMap.get(username) != null) {
                // 如果用户已匹配，输出相应信息并返回房间号
                System.out.println("User " + username + "'s Room " + userRoomMap.get(username));
                // 匹配成功时应该及时的释放锁, 否则另一个用户会被锁死
                lock.unlock();
                return userRoomMap.get(username);
            }
            // 等待
            lock.unlock();
        }
    }

    // 为用户分配房间号
    protected int assignRoom() {
        int roomID = 0;
        while (roomID == 0) {
            roomID = Room.getRoomID();
        }
        return roomID;
    }

    // 用户提交结果
    protected String submitResult(String username, String result, String roomID) {
        // 打印 userRoomMap 的所有键值对
        System.out.println("打印所有的 RoomMap:");
        for (String user : userRoomMap.keySet()) {
            System.out.println(user + " " + userRoomMap.get(user));
        }

        matchResultMap.put(username, Integer.parseInt(result));

        // 找到另一个玩家，和 username 的房间号相同但不等于 username
        String anotherUser = null;
        for (String user : userRoomMap.keySet()) {
            if (!user.equals(username) && userRoomMap.get(user).equals(Integer.parseInt(roomID))) {
                anotherUser = user;
                break;
            }
        }

        System.out.println(username + " 找到的另一个玩家是 " + anotherUser);

        // 等待另一个玩家
        while (true) {
            lock.lock();
            int anotherResult = -1;

            // 如果另一个玩家已提交结果，返回结果
            try {
                anotherResult = matchResultMap.get(anotherUser);
            } catch (NullPointerException e) {
                lock.unlock();
                continue;
            }

            if (anotherResult != -1) {
                lock.unlock();
                System.out.println("删除所有用户");
                releaseQueue.offer(username);
                releaseUser();
                Room.releaseRoomID(Integer.parseInt(roomID));

                if (Integer.parseInt(result) > anotherResult) {
                    return "Win";
                } else if (Integer.parseInt(result) < anotherResult) {
                    return "Lose";
                } else {
                    return "Draw";
                }
            }
            lock.unlock();
        }
    }

    // 释放用户
    protected void releaseUser() {
        if (releaseQueue.size() >= 2) {
            String user1 = releaseQueue.poll();
            String user2 = releaseQueue.poll();
            userRoomMap.remove(user1);
            userRoomMap.remove(user2);
            matchResultMap.remove(user1);
            matchResultMap.remove(user2);
        }
    }
}
