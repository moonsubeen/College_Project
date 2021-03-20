package college_management.my.service;

import java.util.List;

import college_management.my.api.config.Permission;
import college_management.my.db.UserDB;
import college_management.my.db.model.User;
import college_management.my.db.model.UserFamily;

public class UserService {
	private static UserService instance;
	protected static UserDB db = UserDB.getInstance();

	public static UserService getInstance() {
		if (instance == null) {
			instance = new UserService();
		}
		return instance;
	}
	
	public boolean register(String id, String name, String email, String nationality, String phoneNumber, String address, String residentNumber, String birthdate, String sex, String role) {
		Permission p = Permission.valueOfType(role);
		if(p == null)
			return false;
		User user =  db.register(id, name, email, nationality, phoneNumber, address, residentNumber, birthdate, sex, p);
		if(user == null)
			return false;
		return true;
	}
	
	public boolean fregister(String id, String name, String relation, String phonenumber) {
		UserFamily family = db.fregister(id, relation, name, phonenumber);
		if(family == null)
			return false;
		return true;
	}
	
	public boolean update(String id,  String pwd, String name, String email ,String address, String phoneNumber) {
		return db.update(id, pwd, name, email, address, phoneNumber);
	}

	public User read(String id) {
		return db.read(id);
	}
	
	public List<User> readAll() {
		return db.readAll();
	}
}