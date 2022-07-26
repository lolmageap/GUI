package assembles;

import java.nio.file.Files;
import java.nio.file.Paths;

public class User {

	public int rowNum = 0;
	private static String id;
	private static String password;
	private static String name;
	private static String phone;
	private static String[] userInfo;
	
	public User() {}	
	
	public static String[] getUserInfo() {
		return userInfo;
	}
	public static void setUserInfo(String[] userInfo) {
		User.userInfo = userInfo;
	}
	public static String getId() {
		return id;
	}
	public static void setId(String id) {
		User.id = id;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		User.password = password;
	}
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		User.name = name;
	}
	public static String getPhone() {
		return phone;
	}
	public static void setPhone(String phone) {
		User.phone = phone;
	}
}
