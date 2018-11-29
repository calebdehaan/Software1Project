package DataBase;

import java.util.Objects;

// Singleton
public class User {
	private long uId;
	private String userName;
	private Player data;
	private static User instance = null;

	private User(){
		this("", 0);
	}

	private User(String userName, long id) {
		this.setUserName(userName);
		this.setuId(id);
		// this.setPlayer() // TODO: Get player from database
	}

	public static User getInstance(){
		return (instance == null? instance = new User() : instance);
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

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return uId == user.uId &&
				Objects.equals(userName, user.userName) &&
				Objects.equals(data, user.data);
	}

	@Override
	public User clone() {
		return User.getInstance(); // Singleton
	}

	@Override
	public String toString() {
		return "User{" +
				"uId=" + uId +
				", userName='" + userName + '\'' +
				", data=" + data +
				'}';
	}
}
