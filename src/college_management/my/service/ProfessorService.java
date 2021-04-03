package college_management.my.service;

import college_management.my.db.ProfessorDB;
import college_management.my.db.UserDB;
import college_management.my.db.model.Professor;

public class ProfessorService {
	private static ProfessorService instance;
	protected static ProfessorDB db = ProfessorDB.getInstance();
	
	public static ProfessorService getInstance() {
		if (instance == null) {
			instance = new ProfessorService();
		}
		return instance;
	}
	
	public boolean register(String id, String faculty, String department) {
		Professor professor = db.register(id, faculty, department);
		if(professor == null)
			return false;
		return true;
	}
}
