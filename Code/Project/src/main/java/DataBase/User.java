package DataBase;

import DataBase.Player;

public class User {
    private long uId;
    private String userName;
    private Player data;
    
    public User(String userName, long id) {
        this.setUserName(userName);
        this.setuId(id);
        //this.setPlayer() // TODO: Get player from database
    }
    
    public long getuId() {
        return uId;
    }
    
    public void setuId(long uId) {
        this.uId = uId;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public Player getData() {
        return data;
    }
    
    public void setData(Player data) {
        this.data = data;
    }
}
