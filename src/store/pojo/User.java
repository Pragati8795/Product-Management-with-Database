package store.pojo;

public class User {
	private String username;
	private String emailId;
	private int superCoins;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getSuperCoins() {
		return superCoins;
	}
	public void setSuperCoins(int superCoins) {
		this.superCoins = superCoins;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
