package assembles;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Next_Animation3 extends JLabel implements Runnable {
	
	ImageIcon main_img;
	JLabel mi;
	int x = -300;
	
	public Next_Animation3(JLabel mi) {
		this.mi = mi;
	}
	
	public void run() {
		
		try {
		
			while (true) {

				x += 5;	// ���������� 2�� �Ű���
				
				Thread.sleep(40);
				
				//System.out.println(x);
				//System.out.println(width);
				
				mi.setBounds(x, 550, 200, 180);
				
				if(x==1000) {
					x = -300;
				}//if
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		}//try&catch
	}
}