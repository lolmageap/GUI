package joins;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;

import assembles.Assemble;
import assembles.User;


public class Join extends ButtonAdapter{	
	TextField textId;
	TextField textPw;
	TextField textPw2;
	TextField textName;
	TextField textPhone;
	TextField ori_gu;
	TextField ori_dong;
	Button btnPw;
	Button btnId;
	Button btnPhone;
	Button btnAgree;
	Button btnJoin;
	Choice ori_loc;
	Choice ori_dongnum;
	Frame f;
	
	
	static String title = "BADA";
	
	public Join() {}
	
	public Join(TextField textId, TextField textPw, TextField textName, TextField textPhone, TextField ori_gu,
			Choice ori_loc, Choice ori_dongnum, TextField ori_dong) {
		this.textId = textId;
		this.textPw = textPw;
		this.textName = textName;
		this.textPhone = textPhone;
		this.ori_loc = ori_loc;
		this.ori_gu = ori_gu;
		this.ori_dong = ori_dong;
		this.ori_dongnum = ori_dongnum;
		}
	
	public Join(Frame join) {
		this.f = join;
	}

	public Join(TextField textId) {
		this.textId = textId;
		}		
	
	public Join(TextField textPw, TextField textPw2) {
		this.textPw = textPw;
		this.textPw2 = textPw2;
		}
	
	public Join(TextField textId, TextField textPw, TextField textPhone) {
		this.textId = textId;
		this.textPhone = textPhone;
		this.textPw = textPw;
	}	
	
	
	//���̵� �ߺ�Ȯ��
	public void checkId(Button btnId){
		this.btnId = btnId;		
		
		btnId.addActionListener(new ActionListener() {		
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(textId.getText().equals(null)) {
					textId.setText("����");
				}
				
				String fileURL = "C:\\bada\\userInfo\\" + textId.getText() + "/" + textId.getText()+".txt";
				File file = new File(fileURL);
				try {
					FileReader fr = new FileReader(file);
					if(file.exists()&&file.isFile()) {
						JOptionPane.showMessageDialog(f, "�ߺ��� ���̵��Դϴ�.", title, JOptionPane.ERROR_MESSAGE);
					}
					fr.close();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(f, "��� ������ ���̵��Դϴ�.", title, JOptionPane.PLAIN_MESSAGE);
					
					//���� �ؽ�Ʈ �ʵ忡 �ִ� ������ �ƴϸ� ���� ���ϰ� �ϱ�
					Assemble.userinfo = textId.getText().toString();
					System.out.println(Assemble.userinfo);
					
				}
			}
		});
	}
	
	
	//��й�ȣ Ȯ��
	public void checkPw(Button btnPw) {
		this.btnPw = btnPw;
		btnPw.addActionListener(new ActionListener() {
			
		@Override
		public void actionPerformed(ActionEvent e) {
			if(textPw2.getText().equals(textPw.getText())) {
				JOptionPane.showMessageDialog(f, "��й�ȣ�� ��ġ�մϴ�.", 
						title, JOptionPane.PLAIN_MESSAGE);
				Assemble.userinfo1 = textPw.getText().toString();
				System.out.println(Assemble.userinfo1);
				btnPw.setEnabled(false);
			}else {
				JOptionPane.showMessageDialog(f, "��й�ȣ�� ��ġ���� �ʽ��ϴ�", 
						title, JOptionPane.PLAIN_MESSAGE);
			}
			
			}
		});
	}



	//�޴��� ����
	public void checkPhone(Button btnPhone) {
		this.btnPhone = btnPhone;
		
		btnPhone.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textPhone.getText().length() > 11) {
					JOptionPane.showMessageDialog(f,"��ȭ��ȣ�� 11�ڸ� �Ʒ��� �ٽ� �Է����ּ���");
					textPhone.setText("");
					
				} else if (textPhone.getText().length() < 12) {
				while (true) {
					String phoneMsg = "������ȣ�� �Է��� �ּ���.";
					int[] num = new int[6];
					String number = "";
					for (int i = 0; i < num.length; i++) {
						num[i] = new Random().nextInt(9);
					}
					for (int j = 0; j < num.length; j++) {
						number += ""+num[j];
					}
					String inputNum = JOptionPane.showInputDialog("������ȣ : " + number + "\r\n"+ phoneMsg);
					if (inputNum.equals(number)) {
						JOptionPane.showMessageDialog(f, "������ �Ϸ�Ǿ����ϴ�", title, JOptionPane.PLAIN_MESSAGE);
						Assemble.userinfo2 = textPhone.getText().toString();
						System.out.println(Assemble.userinfo2);
						btnPhone.setEnabled(false);
						break;
					} else {
						JOptionPane.showMessageDialog(f, "��ġ���� �ʽ��ϴ�.\r\n�ٽ� �õ��� �ּ���.", title, JOptionPane.ERROR_MESSAGE);
					}	
				}//else if
				}
			}
		});
	}
	
	//��� ����
	public void showDoc(Button btnAgree) {
		this.btnAgree = btnAgree;
		
		String agreeMsg = "��1�� (����)\r\n" + 
				"�� ����� �ù����ڿ� ��(��ȭ��) ���� ������ �ù�ŷ��� ���Ͽ�\r\n�� ��������� ������ �������� �մϴ�.\r\n"+
				"��2�� (������� ��)\r\n" + 
				"�� ����� �������� ���� ���׿� ���Ͽ��� ȭ���ڵ�����������, ��� ����\r\n���Կ� ������ �Ϲݰ����� �����ϴ�.\r\n"+
				"��3�� (����� ����)\r\n" + 
				" - ������ : �̸��� ���Ե� ��(�������� ����)\r\n"+
				" - ������ : ���ڰ� ���Ե� ��\r\n"+
				"��4�� (�����)\r\n" + 
				"����ڴ� ����� ü���ϴ� ���� ���� �� ȣ�� ������ ������ �������\r\n�����Ͽ� ��(��ȭ��)���� �����մϴ�.\r\n" + 
				" - ������� ��ȣ, ��ǥ�ڸ�, �ּ� �� ��ȭ��ȣ, ����� �̸�, ����� ��ȣ\r\n"+
				"��5�� (������ û���� ��ġ��)\r\n" + 
				" - ���� �� ������� -\r\n"+
				"���� ������ �ȿ����� ��� �����մϴ�.\r\n"+
				"�⺻���� : 1000��(��)����1��->����1���� ��)\r\n"+ 
				"�߰����� : ���������� �̿�/ 1000�� (�������� ��ĥ ������ �ΰ�)\r\n"+
				" - ���Կ� ũ�⿡ ���� �� �׸� �� 1000���� �߰����� �ο��˴ϴ�.\r\n";
		btnAgree.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f, agreeMsg, title, JOptionPane.PLAIN_MESSAGE);
			}
		});
	}
		
	//�����ϱ�
	public void join(Button btnJoin) {
		this.btnJoin = btnJoin;
		btnJoin.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {	
				File file = new File("C:/bada/userInfo/"+ textId.getText());
				file.mkdirs();
				
				String fileURL = "C:\\bada\\userInfo\\" + textId.getText() + "/" + textId.getText()+".txt";
				OutputStream output = new FileOutputStream(fileURL, true);
				String idField = "���̵� : " + textId.getText() + "    ";
				String pwField = "��й�ȣ : " + textPw.getText();
				output.write(idField.getBytes());
				output.write(pwField.getBytes());
				
				fileURL = "C:\\bada\\userInfo\\" + textId.getText() + "/" + textId.getText() + "2.txt";
				OutputStream output1 = new FileOutputStream(fileURL, true);
				String nameField = "�̸�\n" + textName.getText() + "\n";
				String phoneField = "�޴���ȭ\n" + textPhone.getText() + "\n";
				String addressField1 = "�ּ�\n" + ori_loc.getSelectedItem() + "\n";
				String addressField2 = ori_gu.getText() + "\n";	
				String addressField3 = ori_dong.getText() + "\n";
				String addressField4 = ori_dongnum.getSelectedItem()+"\n";
				
				output1.write(nameField.getBytes());
				output1.write(phoneField.getBytes());
				output1.write(addressField1.getBytes());
				output1.write(addressField2.getBytes());
				output1.write(addressField3.getBytes());
				output1.write(addressField4.getBytes());
				output.close();
				output1.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(f, "��ȸ������ ������", title, JOptionPane.PLAIN_MESSAGE);
			}
		});
	}
	
	//�ּ�2 ���� ��������
	public void showInfo(Frame f, TextField textId) {
		this.f = f;
		this.textId = textId;
		File file = new File("C:\\bada\\userInfo\\" + textId.getText() + "/" + textId.getText() + "2.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line1 = br.readLine();//�̸�
			String line2 = br.readLine();//��¥�̸�
			String line3 = br.readLine();//��ȭ��ȣ
			String line4 = br.readLine();//5454
			String line5 = br.readLine();//�ּ�
			String line6 = br.readLine();//��
			String line7 = br.readLine();//��
			String line8 = br.readLine();//������
			String line9 = br.readLine();//������			
			String[] arData = {line2, line4, line6, line7, line8, line9};
			User.setUserInfo(arData);
			System.out.println("����");
			
			Assemble.textname  = arData[0];
			Assemble.textnumber = arData[1];
			Assemble.locStr = arData[2];
			Assemble.textgu = arData[3];
			Assemble.textdong = arData[4];
			Assemble.dongnum = arData[5];
			
			
			br.close();
		} catch (Exception e) {
			System.out.println("������");
		}
		
	}
	
	
	
}