package college_management.my.gui.layout.admin.user;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;

import college_management.my.api.config.Permission;
import college_management.my.db.model.User;
import college_management.my.gui.layout.common.LecView;

@SuppressWarnings("serial")
public class AdminUserInfoRegDlgView extends LecView{
	private AdminStudentRegDlgView student = new AdminStudentRegDlgView();
	private AdminProfessorRegDlgView professor = new AdminProfessorRegDlgView(); 
//	private JComponent studentview = student;
//	private JComponent professorview = professor;
	private JComboBox<Permission> comboBox = new JComboBox<Permission>();

	public AdminUserInfoRegDlgView() {
		super();

		initLayout();
		setBackground(new Color(200, 200, 200));

		changeToStudent();
	}

	private void initLayout() {
		setLayout(new GridBagLayout());

		int row = 0;
		addComboBoxPair(comboBox, "권한", row++);
		addView(student, row);
		addView(professor, row);
	}

	private void addView(JComponent view, int row) {
		GridBagConstraints c = new GridBagConstraints();

		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = row;
		add(view, c);
	}

	private void addComboBoxPair(JComboBox<Permission> comboBox, String name, int row) {
		GridBagConstraints c = new GridBagConstraints();

		JLabel label = new JLabel(name);
		label.setPreferredSize(new Dimension(100, 30));
		c.gridx = 0;
		c.gridy = row;
		add(label, c);

		c.gridx = 1;
		c.gridy = row;
		add(comboBox, c);
	}

	@Override
	public void setData(Object model) {
	}	

	@Override
	public Object getData() {
		getStudent().getData();
//		User user = new User();
//		student.getData();
		return null;
	}

	@SuppressWarnings("unchecked")
	public JComboBox<Permission> getRoleComboBox() {
		return comboBox;
	}

	public AdminStudentRegDlgView getStudent() {
		return student;
	}

	public AdminProfessorRegDlgView getProfessor() {
		return professor;
	}

	public void changeToStudent() {
		professor.setVisible(false);
		student.setVisible(true);
	}

	public void changeToProfessor() {
		professor.setVisible(true);
		student.setVisible(false);
	}
}
