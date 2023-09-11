package entities;

import java.io.Serializable;

public class User implements Serializable {
    protected int userId;
    protected String username;
    protected String password;
    public User(int userId, String username, String password) {
        this.userId=userId;
        this.username = username;
        this.password = password;
    }
    public User(){

    }

}
