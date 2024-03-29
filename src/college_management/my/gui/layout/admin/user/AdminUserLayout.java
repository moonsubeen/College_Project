package college_management.my.gui.layout.admin.user;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

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
	private JButton familyBtn;
	private JButton deleteBtn;
	private JButton searchBtn;
	private JTextField searchTxtField = new JTextField();
	private JLabel label = new JLabel("아이디 입력");
	
	public AdminUserLayout() {
		initLayout();
	}
	public void initLayout() {
		// 선택된 사용자 정보
		userInfo = new AdminUserInfoView();
		userInfo.setPreferredSize(new Dimension(400, 400));

		// 사용자 리스트
		userList = new LecTableView(userInfo);
		userList.setAutoCreateRowSorter(true);
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(userList.getModel());
		userList.setRowSorter(sorter);
		
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
		
		familyBtn = (new JButton("사용자 가족정보 추가하기"));
		familyBtn.setPreferredSize(new Dimension(200, 30));
		
		label.setPreferredSize(new Dimension(100, 30));
		
		searchBtn = (new JButton("검색"));
		searchBtn.setPreferredSize(new Dimension(60, 30));
		
		searchTxtField.setPreferredSize(new Dimension(200, 30));
		
		removeAll();
		setLayout();
	}
	private void setLayout() {
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
		
		c.gridx = 0;
		c.gridy = 2;
		add(label, c);
		
		c.gridx = 0;
		c.gridy = 4;
		add(searchBtn, c);
		
		c.gridx = 0;
		c.gridy = 3;
		add(searchTxtField, c);
		
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

		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 4;
		add(familyBtn, c);
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

	public JButton getSearchBtn() {
		return searchBtn;
	}
	
	public JButton getFamilyBtn() {
		return familyBtn;
	}
	
	public JTextField getSearchTxtField() {
		return searchTxtField;
	}
	
	public JLabel getLabel() {
		return label;
	}
}
