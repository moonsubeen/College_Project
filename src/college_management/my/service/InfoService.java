package college_management.my.service;

import college_management.my.db.DisabilityDB;
import college_management.my.db.SoldierDB;
import college_management.my.db.model.Student;
import college_management.my.db.model.UserDisability;
import college_management.my.db.model.UserSoldier;

public class InfoService {
	private static InfoService instance;
	protected static DisabilityDB ddb = DisabilityDB.getInstance();
	protected static SoldierDB sdb = SoldierDB.getInstance();
	
	public static InfoService getInstance() {
		if (instance == null) {
			instance = new InfoService();
		}
		return instance;
	}
	
	public boolean register(String id, boolean state, String disability, String document) {
		UserDisability disabilities = ddb.register(id, state, disability, document);
		if(state == false) {
			disability = null;
			document = null;
			System.out.println("장애가 없습니다.");
		}
		if(disabilities == null)
			return false;
		return true;
	}
	
	public boolean register(String id, boolean state, String militaryNumber, String type, String classification, String branch, String rank, String joinDate, String dischageDate) {
		UserSoldier soldier = sdb.register(id, state, militaryNumber, type, classification, branch, rank, joinDate, dischageDate);
		if(state == false) {
			militaryNumber = null;
			type = null;
			classification = null;
			branch = null;
			rank = null;
			joinDate = null;
			dischageDate = null;
			System.out.println("군복무를 하지 않았습니다.");
		}
		if(soldier == null)
			return false;
		return true;
	}
	
	public UserDisability read(String id) {
		return ddb.read(id);
	}
	
	public UserSoldier sread(String id) {
		return sdb.read(id);
	}
}
