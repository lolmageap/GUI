package assembles;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

public class ButtonAdapter1 implements ActionListener {
	
	Frame main_before_view;
	
	public ButtonAdapter1(Frame main_before_view) {
		this.main_before_view = main_before_view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(main_before_view, "로그인 후 이용해주세요.");
	}

}
