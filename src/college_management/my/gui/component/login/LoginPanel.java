package college_management.my.gui.component.login;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import college_management.my.auth.UserAuth;
import college_management.my.gui.MainGUI;
import college_management.my.gui.component.common.LecPanel;

public class LoginPanel extends LecPanel{
	private JLabel idLabel, pwdLabel;
	private JTextField idField, pwdField;
	private JButton loginBtn;

	public LoginPanel(MainGUI frame) {
		super(frame);

		idLabel = new JLabel("아이디");
		idField = new JTextField(25);
		idField.setPreferredSize(new Dimension(100, 30));
		pwdLabel = new JLabel("비밀번호");
		pwdField = new JTextField(25);
		pwdField.setPreferredSize(new Dimension(100, 30));
		loginBtn = (new JButton("로그인"));
		loginBtn.setPreferredSize(new Dimension(100, 30));
		loginBtn.addActionListener(loginListener);

		initLayout();
	}

	private void initLayout() {
		setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		add(idLabel, c);

		c.gridx = 1;
		c.gridy = 0;
		add(idField, c);

		c.gridx = 0;
		c.gridy = 1;
		add(pwdLabel, c);

		c.gridx = 1;
		c.gridy = 1;
		add(pwdField, c);

		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 3;
		add(loginBtn, c);
	}

	private ActionListener loginListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String id = idField.getText();
			String password = pwdField.getText();
			if (id == "" || password == "")
				return;

			UserAuth auth = UserAuth.getInstance();

			// 로그인 확인
			if (auth.isLogin()) {
				showMessageBox("it's need to logout");
				return;
			}

			// 로그인
			if (!auth.login(id, password)) {
				showMessageBox("로그인 실패");
			} else {
				showMessageBox("로그인 성공");
				switch (auth.getUser().getRole()) {
				case Student:
					frame.changeStudentTab();
					break;
				case Professor:
					frame.changeProfessorTab();
					break;
				case Admin:
					frame.changeAdminTab();
					break;
				default:
					break;
				}

			}
		}
	};
}
