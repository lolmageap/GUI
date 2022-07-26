package joins;

import java.awt.Button;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.io.FileOutputStream;

public class TextAdapter2 implements TextListener{

	TextArea dr_ta;
	Button dr_finish;
	
	public TextAdapter2 (
			TextArea dr_ta, 
			Button dr_finish ) 
	{
		this.dr_ta = dr_ta;
		this.dr_finish = dr_finish;
	}
	
	@Override
	public void textValueChanged(TextEvent e) {
		if(dr_ta.getText().equals("")) {
			dr_finish.setEnabled(false);
		}else {
			dr_finish.setEnabled(true);
		}
	}
}
