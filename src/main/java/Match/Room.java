package Match;

public class Room {
    // boolean 数组
    // 0 代表房间未被占用
    // 1 代表房间已被占用
    private static boolean[] roomMap = new boolean[101];

    protected static int getRoomID() {
        // 找到一个空闲的房间
        for (int i = 1; i <= 100; i++) {
            if (!roomMap[i]) {
                roomMap[i] = true;
                return i;
            }
        }
        return 0;
    }

    // 查询房间状态
    protected static boolean queryRoomStatus(int roomID) {
        return roomMap[roomID];
    }

    // 释放房间号
    protected static void releaseRoomID(int roomID) {
        roomMap[roomID] = false;
    }
}
