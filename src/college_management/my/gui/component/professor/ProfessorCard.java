package college_management.my.gui.component.professor;

import java.awt.Color;

import college_management.my.gui.MainGUI;
import college_management.my.gui.component.common.CardPanel;

@SuppressWarnings("serial")
public class ProfessorCard extends CardPanel{
	public ProfessorCard(MainGUI frame) {
		super(frame);

//		this.setPanel(new ProfessorTab(frame));
		setBackground(new Color(153, 204, 255));
		setPanel(new ProfessorTab(frame));
	}
}

