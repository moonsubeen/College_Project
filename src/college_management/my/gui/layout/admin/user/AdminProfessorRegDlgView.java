package college_management.my.gui.layout.admin.user;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import college_management.my.db.model.Professor;
import college_management.my.db.model.User;
import college_management.my.gui.layout.common.LecView;

@SuppressWarnings("serial")
public class AdminProfessorRegDlgView extends LecView{
	private JTextField idTxtField = new JTextField();
	private JTextField nameTxtField = new JTextField();
	private JTextField addressTxtField = new JTextField();
	private JTextField phoneTxtField = new JTextField();
	private JTextField countryTxtField = new JTextField();
	private JTextField residentTxtField = new JTextField();
	private JTextField emailTxtField = new JTextField();
	private JTextField birthTxtField = new JTextField();
	private JTextField sexTxtField = new JTextField();
	private JTextField pwdTxtField = new JTextField();
	private JTextField facultyTxtField = new JTextField();
	private JTextField departmentTxtField = new JTextField();
	String states[] = {"없음", "있음", "해당사항 아님"};
	String state2[] = {"없음", "있음"};
	private JComboBox<String> soldierstate = new JComboBox<String>(states);
	private JComboBox<String> disabilitystate = new JComboBox<String>(state2);
	
	public AdminProfessorRegDlgView() {
		super();

		initLayout();
		setBackground(new Color(200, 200, 200));
	}

	private void initLayout() {
		setLayout(new GridBagLayout());

		int row = 0;
		addComboBoxPair(soldierstate, "복무여부", row++);
		addComboBoxPair(disabilitystate, "병여부", row++);
		addTextFieldPair("교수 코드", idTxtField, row++, true);
		addTextFieldPair("이름", nameTxtField, row++, true);
		addTextFieldPair("주소", addressTxtField, row++, true);
		addTextFieldPair("전화번호", phoneTxtField, row++, true);
		addTextFieldPair("국적", countryTxtField, row++, true);
		addTextFieldPair("주민등록번호", residentTxtField, row++, true);
		addTextFieldPair("이메일", emailTxtField, row++, true);
		addTextFieldPair("생년월일", birthTxtField, row++, true);
		addTextFieldPair("성별", sexTxtField, row++, true);
		addTextFieldPair("학부", facultyTxtField, row++, true);
		addTextFieldPair("학적", departmentTxtField, row++, true);
	}

	private void addTextFieldPair(String name, JTextField txtField, int row, boolean isEditable) {
		GridBagConstraints c = new GridBagConstraints();

		JLabel label = new JLabel(name);
		label.setPreferredSize(new Dimension(100, 30));
		c.gridx = 0;
		c.gridy = row;
		add(label, c);
		
		txtField.setEditable(isEditable);
		txtField.setPreferredSize(new Dimension(200, 30));
		c.gridx = 1;
		c.gridy = row;
		add(txtField, c);
	}
	
	private void addComboBoxPair(JComboBox<String> state, String name, int row) {
		GridBagConstraints c = new GridBagConstraints();

		JLabel label = new JLabel(name);
		label.setPreferredSize(new Dimension(100, 30));
		c.gridx = 0;
		c.gridy = row;
		add(label, c);

		c.gridx = 1;
		c.gridy = row;
		add(state, c);
	}

	public JTextField getIdTxtField() {
		return idTxtField;
	}

	public JTextField getNameTxtField() {
		return nameTxtField;
	}

	public JTextField getAddressTxtField() {
		return addressTxtField;
	}

	public JTextField getPhoneTxtField() {
		return phoneTxtField;
	}

	public JTextField getCountryTxtField() {
		return countryTxtField;
	}

	public JTextField getResidentTxtField() {
		return residentTxtField;
	}

	public JTextField getEmailTxtField() {
		return emailTxtField;
	}

	public JTextField getBirthTxtField() {
		return birthTxtField;
	}

	public JTextField getSexTxtField() {
		return sexTxtField;
	}

	public JTextField getPwdTxtField() {
		return pwdTxtField;
	}
	
	public JTextField getFacultyTxtField() {
		return facultyTxtField;
	}

	public JTextField getDepartmentTxtField() {
		return departmentTxtField;
	}

	@Override
	public void setData(Object model) {
		Professor professor = (Professor) model;
		User user = professor.getUser();
		idTxtField.setText(user.getId());
		nameTxtField.setText(user.getName());
		addressTxtField.setText(user.getAddress());
		phoneTxtField.setText(user.getPhoneNumber());
		countryTxtField.setText(user.getNationality());
		residentTxtField.setText(user.getResidentNumber());
		emailTxtField.setText(user.getEmail());
		birthTxtField.setText(user.getBirthdate());
		sexTxtField.setText(user.getSex());
		pwdTxtField.setText(user.getPwd());
		facultyTxtField.setText(professor.getFaculty());
		departmentTxtField.setText(professor.getDepartment());
	}

	@Override
	public Object getData() {
		Professor professor = new Professor();
		User user = new User();
		user.setId(idTxtField.getText());
		user.setName(nameTxtField.getText());
		user.setAddress(addressTxtField.getText());
		user.setPhoneNumber(phoneTxtField.getText());
		user.setNationality(countryTxtField.getText());
		user.setResidentNumber(residentTxtField.getText());
		user.setEmail(emailTxtField.getText());
		user.setBirthdate(birthTxtField.getText());
		user.setSex(sexTxtField.getText());
		professor.setFaculty(facultyTxtField.getText());
		professor.setDepartment(departmentTxtField.getText());
		professor.setUser(user);
		return professor;
	}
	
	@SuppressWarnings("unchecked")
	public JComboBox<String> getSoldierStateComboBox() {
		return soldierstate;
	}
	
	@SuppressWarnings("unchecked")
	public JComboBox<String> getDisabilityStateComboBox() {
		return disabilitystate;
	}
}
