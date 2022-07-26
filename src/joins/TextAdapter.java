package joins;

import java.awt.Button;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class TextAdapter implements TextListener{

	TextField text;
	Button btn;
	
	public TextAdapter(TextField text, Button btn) {
		this.text = text;
		this.btn = btn;
	}
	
	@Override
	public void textValueChanged(TextEvent e) {
		if(text.getText().equals("")) {
			btn.setEnabled(false);
		}else {
			btn.setEnabled(true);
		}
	}
}
