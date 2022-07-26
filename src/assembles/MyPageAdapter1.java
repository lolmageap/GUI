package assembles;


	import java.awt.Frame;
	import java.awt.event.ItemEvent;
	import java.awt.event.ItemListener;

	import javax.swing.JOptionPane;

	public class MyPageAdapter1 implements ItemListener {

		Frame f;
		

		public MyPageAdapter1(Frame mypage) {
			this.f = mypage;
		}
		
		
		@Override
		public void itemStateChanged(ItemEvent arg0) {
			Assemble.locStr = arg0.getItem().toString();
			JOptionPane.showMessageDialog(f, "µ¿³×: " + Assemble.locStr);

			
		}

	}

