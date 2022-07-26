package assembles;

import java.awt.Color;
import java.awt.Label;

public class Animation2 extends Thread {

	Label lb;
	int count=20;

	public Animation2(Label lb) {
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
				if(count%2 == 0 && count<=10) {
					lb.setBackground(Color.yellow);
				}
				else if(count%2 == 1 && count<=10) {
					lb.setBackground(Color.cyan);
				}
				else {
					lb.setBackground(Color.cyan);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
