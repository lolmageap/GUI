package assembles;

import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

public class MyPageAdapter4 implements ItemListener {
	Frame f;
	

	public MyPageAdapter4(Frame join) {
		this.f = join;
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		Assemble.dongnum = arg0.getItem().toString();
		JOptionPane.showMessageDialog(f, "동: " + Assemble.dongnum + "으로 변경");

		
	}

}
