package college_management.my.gui.layout.student;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JTextField;

import college_management.my.db.model.User;
import college_management.my.gui.layout.common.LecView;

public class StudentUserInfoView extends LecView{
		private HashMap<String, JTextField> infoMap = new HashMap<String, JTextField>();

		public StudentUserInfoView() {
			super();

			initLayout();
		}

		private void initLayout() {
			setLayout(new GridBagLayout());

			int row = 0;
			genInfoPair("id", "ID", row++);
			genInfoPair("name", "이름", row++);
			genInfoPair("address", "주소", row++);
			genInfoPair("phone", "전화번호", row++);
			genInfoPair("country", "국적", row++);
			genInfoPair("regdent", "주민등록번호", row++);
			genInfoPair("email", "이메일", row++);
			genInfoPair("birth", "생년월일", row++);
			genInfoPair("pwd", "비밀번호", row++);
			genInfoPair("role", "권한", row++);
		}

		private void genInfoPair(String id, String name, int row) {
			GridBagConstraints c = new GridBagConstraints();

			JLabel label = new JLabel(name);
			label.setPreferredSize(new Dimension(100, 30));
			c.gridx = 0;
			c.gridy = row;
			add(label, c);

			JTextField field = new JTextField();
			field.setPreferredSize(new Dimension(200, 30));
			c.gridx = 1;
			c.gridy = row;
			add(field, c);

			infoMap.put(id, field);
		}

		@Override
		public void setData(Object model) {
			User user = (User) model;
			infoMap.get("id").setText(user.getId());
			infoMap.get("name").setText(user.getName());
			infoMap.get("address").setText(user.getAddress());
			infoMap.get("phone").setText(user.getPhoneNumber());
			infoMap.get("country").setText(user.getNationality());
			infoMap.get("regdent").setText(user.getResidentNumber());
			infoMap.get("email").setText(user.getEmail());
			infoMap.get("birth").setText(user.getBirthdate());
			infoMap.get("pwd").setText(user.getPwd());
			infoMap.get("role").setText(user.getRole().getValue());
		}

		@Override
		public Object getData() {
			return null;
		}
}
