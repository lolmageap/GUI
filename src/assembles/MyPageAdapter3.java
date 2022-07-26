package assembles;

import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

public class MyPageAdapter3 implements ItemListener {
	Frame f;
	

	public MyPageAdapter3(Frame deliver) {
		this.f = deliver;
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		Assemble.deli_dong = arg0.getItem().toString();
		JOptionPane.showMessageDialog(f, "동: " + Assemble.deli_dong + "으로 변경");

		
	}

}
