package entities;

public class User {
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
