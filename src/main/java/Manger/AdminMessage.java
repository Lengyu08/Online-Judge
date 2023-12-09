package Manger;

import java.util.Date;

public class AdminMessage {
    private int id;
    private String username;
    private String type;
    private String email;
    private Date time;

    // 构造函数
    public AdminMessage(int id, String username, String type, String email, Date time) {
        this.id = id;
        this.username = username;
        this.type = type;
        this.email = email;
        this.time = time;
    }

    // Getter和Setter方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
