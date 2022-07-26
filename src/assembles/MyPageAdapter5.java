package assembles;

import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

public class MyPageAdapter5 implements ItemListener {
	Frame f;
	

	public MyPageAdapter5(Frame join) {
		this.f = join;
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		Assemble.locStr = arg0.getItem().toString();
		JOptionPane.showMessageDialog(f, "동네: " + Assemble.locStr + "으로 변경");

		
	}

}