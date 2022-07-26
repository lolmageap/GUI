package assembles;


import java.awt.Color;
import java.awt.Label;


public class Animation1 extends Thread{

	Label lb;
	int count = 10;

	public Animation1(Label lb) {
		this.lb = lb;
	}

	public void run() {
		try {
			while(true) {
				Thread.sleep(500);
				
				count--;
				if(count==0) {
					break;
				}
				if(count%2 == 0) {
					lb.setBackground(Color.yellow);
				}
				else if(count%2 == 1) {
					lb.setBackground(Color.cyan);
				}
				else {
					lb.setBackground(Color.cyan);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
