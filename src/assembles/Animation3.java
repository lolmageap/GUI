package assembles;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;

public class Animation3 extends Thread {

	Label lb;
	Frame deliver_review;
	int count=30;

	public Animation3(Label lb, Frame deliver_review) {
		this.lb = lb;
		this.deliver_review = deliver_review;
	}

	public void run() {
		try {
			while(true) {
				Thread.sleep(500);
				
				count--;
				if(count==0) {
					lb.setBackground(Color.yellow);
					deliver_review.setVisible(true);
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
