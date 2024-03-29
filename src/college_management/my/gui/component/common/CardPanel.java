package college_management.my.gui.component.common;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import college_management.my.gui.MainGUI;

@SuppressWarnings("serial")
public class CardPanel extends LecPanel {
	private JLabel loginNameLbl;
	private JButton logoutBtn;
	private JButton exitBtn;
	
	private CardPanelInterface cardPanel;

	public CardPanel(MainGUI frame, CardPanelInterface cardPanelmpl) {
		super(frame);

		loginNameLbl = new JLabel();
		logoutBtn = new JButton("로그아웃");
		logoutBtn.addActionListener(logoutListener);
		exitBtn = new JButton("종료");
		exitBtn.addActionListener(exitListener);

		initLayout();
		
		cardPanel = cardPanelmpl;
	}

	private void initLayout() {
		setLayout(new BorderLayout());

		Panel header = new Panel();
		header.add(loginNameLbl);
		header.add(logoutBtn);
		header.add(exitBtn);
		add(header, BorderLayout.SOUTH);
	}

	protected void setPanel(Component component) {
		add(component, BorderLayout.CENTER);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
			refresh();
	}

	private void refresh() {
		if (auth.isLogin()) {
			loginNameLbl.setText("로그인 사용자 : " + auth.getLoginName());
			logoutBtn.setVisible(true);
		} else {
			loginNameLbl.setText("");
			logoutBtn.setVisible(false);
		}
	}

	private ActionListener logoutListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (auth.logout()) {
				showMessageBox("로그아웃 성공");
				cardPanel.initView();
				frame.changeLoginTab();
			} else
				showMessageBox("로그아웃 실패");
		}
	};

	private ActionListener exitListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (auth.isLogin()) {
				auth.logout();
			}
//			frame.dispose();
			System.exit(0);
		}
	};
}
