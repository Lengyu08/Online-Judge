package Manger;

public class User {
    private int id, level;
    private String username, password;

    public User(int id, String username, String password, String level) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.level = Integer.parseInt(level);
    }

    public int getId() {
        return id;
    }

    public String getLevel() {
        if (level == 0) {
            return "超级用户";
        } else if (level == 1) {
            return "管理员";
        } else if (level == 2) {
            return "普通用户";
        } else {
            return "未知用户";
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
