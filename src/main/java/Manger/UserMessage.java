package Manger;

import java.util.Date;

public class UserMessage {
    private int id;
    private Date time;
    private String username, admin_name, content;

    public UserMessage(int id, Date time, String username, String admin_name, String content) {
        this.id = id;
        this.time = time;
        this.content = content;
        this.username = username;
        this.admin_name = admin_name;
    }

    public int getId() {
        return id;
    }

    public Date getTime() {
        return time;
    }

    public String getUsername() {
        return username;
    }

    public String getAdminName() {
        return admin_name;
    }

    public String getContent() {
        return content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAdminName(String admin_name) {
        this.admin_name = admin_name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}
