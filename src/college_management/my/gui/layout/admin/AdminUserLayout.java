package college_management.my.gui.layout.admin;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import college_management.my.gui.layout.common.LecTableView;
import college_management.my.gui.layout.common.LecView;

@SuppressWarnings("serial")
public class AdminUserLayout extends JPanel{
	private LayoutManager layout;

	private JScrollPane scrollPane;
	private LecTableView userList;
	private LecView userInfo;
	private JComboBox<String> roleComboBox;
	private JButton loadBtn;
	private JButton updateBtn;
	private JButton registerBtn;
	private JButton deleteBtn;

	public AdminUserLayout() {

		// 선택된 사용자 정보
		userInfo = new AdminUserInfoView();
		userInfo.setPreferredSize(new Dimension(400, 400));

		// 사용자 리스트
		userList = new LecTableView(userInfo);
		scrollPane = new JScrollPane(userList);
		scrollPane.setPreferredSize(new Dimension(400, 400));

		// 권한 선택
		roleComboBox = new JComboBox<String>();

		loadBtn = (new JButton("사용자 리스트 불러오기"));
		loadBtn.setPreferredSize(new Dimension(200, 30));

		updateBtn = (new JButton("사용자 정보 변경하기"));
		updateBtn.setPreferredSize(new Dimension(200, 30));

		registerBtn = (new JButton("사용자 정보 추가하기"));
		registerBtn.setPreferredSize(new Dimension(200, 30));

//		deleteBtn = (new JButton("사용자 정보 삭제하기"));
//		deleteBtn.setPreferredSize(new Dimension(200, 30));

		initLayout();
	}

	private void initLayout() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.gridx = 0;
		c.gridy = 0;
		add(scrollPane, c);

		c.gridx = 1;
		c.gridy = 0;
		add(userInfo, c);

		c.gridx = 0;
		c.gridy = 1;
		add(roleComboBox, c);

		c.gridx = 1;
		c.gridy = 1;
		add(loadBtn, c);

		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 2;
		add(updateBtn, c);

		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 3;
		add(registerBtn, c);

//		c.gridwidth = 2;
//		c.gridx = 1;
//		c.gridy = 4;
//		add(deleteBtn, c);
	}

	public LayoutManager getLayout() {
		return layout;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public LecTableView getUserList() {
		return userList;
	}

	public LecView getUserInfo() {
		return userInfo;
	}

	public JComboBox<String> getRoleComboBox() {
		return roleComboBox;
	}

	public JButton getLoadBtn() {
		return loadBtn;
	}

	public JButton getUpdateBtn() {
		return updateBtn;
	}

	public JButton getRegisterBtn() {
		return registerBtn;
	}

//	public JButton getDeleteBtn() {
//		return deleteBtn;
//	}
}
