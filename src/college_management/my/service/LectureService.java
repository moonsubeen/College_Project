package college_management.my.service;

import java.util.List;

import college_management.my.db.LectureAttendanceDB;
import college_management.my.db.LectureDB;
import college_management.my.db.LectureHistoryDB;
import college_management.my.db.model.Lecture;
import college_management.my.db.model.LectureAttendance;
import college_management.my.db.model.LectureHistory;
import college_management.my.db.model.User;

public class LectureService {
	private static LectureService instance;
	protected static LectureDB db = LectureDB.getInstance();
	protected static LectureHistoryDB hdb = LectureHistoryDB.getInstance();
	protected static LectureAttendanceDB adb = LectureAttendanceDB.getInstance();
	
	public static LectureService getInstance() {
		if (instance == null) {
			instance = new LectureService();
		}
		return instance;
	}
	
	public boolean register(String id, String code, String name,int year, int semester, String day,
			String time, int count, int point, String plan) {
		Lecture lecture = db.register(id, code, name, year, semester, day, time, count, point, plan);
		if(lecture == null)
			return false;
		return true;
	}
	
	public boolean register(String code, String id, int grade, String evaluation, 
			String count) {
		String rank;
		if(grade >= 95)
			rank = "A+";
		else if(grade >= 90)
			rank = "A";
		else if(grade >= 85)
			rank = "B+";
		else if(grade >= 80)
			rank = "B";
		else if(grade >= 75)
			rank = "C+";
		else if(grade >= 70)
			rank = "C";
		else if(grade >= 65)
			rank = "D+";
		else if(grade >= 60)
			rank = "D";
		else
			rank = "F";
		LectureHistory history = hdb.register(code, id, grade, rank);
		if(history == null)
			return false;
		return true;
	}
	
	public boolean problem(String code, String id, String problem) {
		LectureHistory history = hdb.problem(code, id, problem);
		if(history == null)
			return false;
		return true;
	}
	
	public boolean evaluation(String code, String id, String evaluation) {
		LectureHistory history = hdb.evaluation(code, id, evaluation);
		if(history == null)
			return false;
		return true;
	}
	
	public boolean register(String code, String id, int month, int day, String attendance) {
		LectureAttendance attendances = adb.register(code, id, month, day, attendance);
		return true;
	}
	
	public Lecture read(String code) {
		return db.read(code);
	}
	
	public LectureHistory hread(String code) {
		return hdb.read(code);
	}
	
	public List<Lecture> readAll(String id) {
		return db.readAll(id);
	}
}
