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
	
	
	//아이디 중복확인
	public void checkId(Button btnId){
		this.btnId = btnId;		
		
		btnId.addActionListener(new ActionListener() {		
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(textId.getText().equals(null)) {
					textId.setText("없음");
				}
				
				String fileURL = "C:\\bada\\userInfo\\" + textId.getText() + "/" + textId.getText()+".txt";
				File file = new File(fileURL);
				try {
					FileReader fr = new FileReader(file);
					if(file.exists()&&file.isFile()) {
						JOptionPane.showMessageDialog(f, "중복된 아이디입니다.", title, JOptionPane.ERROR_MESSAGE);
					}
					fr.close();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(f, "사용 가능한 아이디입니다.", title, JOptionPane.PLAIN_MESSAGE);
					
					//현재 텍스트 필드에 있는 내용이 아니면 가입 못하게 하기
					Assemble.userinfo = textId.getText().toString();
					System.out.println(Assemble.userinfo);
					
				}
			}
		});
	}
	
	
	//비밀번호 확인
	public void checkPw(Button btnPw) {
		this.btnPw = btnPw;
		btnPw.addActionListener(new ActionListener() {
			
		@Override
		public void actionPerformed(ActionEvent e) {
			if(textPw2.getText().equals(textPw.getText())) {
				JOptionPane.showMessageDialog(f, "비밀번호가 일치합니다.", 
						title, JOptionPane.PLAIN_MESSAGE);
				Assemble.userinfo1 = textPw.getText().toString();
				System.out.println(Assemble.userinfo1);
				btnPw.setEnabled(false);
			}else {
				JOptionPane.showMessageDialog(f, "비밀번호가 일치하지 않습니다", 
						title, JOptionPane.PLAIN_MESSAGE);
			}
			
			}
		});
	}



	//휴대폰 인증
	public void checkPhone(Button btnPhone) {
		this.btnPhone = btnPhone;
		
		btnPhone.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textPhone.getText().length() > 11) {
					JOptionPane.showMessageDialog(f,"전화번호를 11자리 아래로 다시 입력해주세요");
					textPhone.setText("");
					
				} else if (textPhone.getText().length() < 12) {
				while (true) {
					String phoneMsg = "인증번호를 입력해 주세요.";
					int[] num = new int[6];
					String number = "";
					for (int i = 0; i < num.length; i++) {
						num[i] = new Random().nextInt(9);
					}
					for (int j = 0; j < num.length; j++) {
						number += ""+num[j];
					}
					String inputNum = JOptionPane.showInputDialog("인증번호 : " + number + "\r\n"+ phoneMsg);
					if (inputNum.equals(number)) {
						JOptionPane.showMessageDialog(f, "인증이 완료되었습니다", title, JOptionPane.PLAIN_MESSAGE);
						Assemble.userinfo2 = textPhone.getText().toString();
						System.out.println(Assemble.userinfo2);
						btnPhone.setEnabled(false);
						break;
					} else {
						JOptionPane.showMessageDialog(f, "일치하지 않습니다.\r\n다시 시도해 주세요.", title, JOptionPane.ERROR_MESSAGE);
					}	
				}//else if
				}
			}
		});
	}
	
	//약관 보기
	public void showDoc(Button btnAgree) {
		this.btnAgree = btnAgree;
		
		String agreeMsg = "제1조 (목적)\r\n" + 
				"이 약관은 택배사업자와 고객(송화인) 간의 공정한 택배거래를 위하여\r\n그 계약조건을 정함을 목적으로 합니다.\r\n"+
				"제2조 (적용법규 등)\r\n" + 
				"이 약관에 규정되지 않은 사항에 대하여는 화물자동차운수사업법, 상법 등의\r\n법규와 공정한 일반관습에 따릅니다.\r\n"+
				"제3조 (용어의 정의)\r\n" + 
				" - 법정동 : 이름이 포함된 동(행정동을 포함)\r\n"+
				" - 행정동 : 숫자가 포함된 동\r\n"+
				"제4조 (운송장)\r\n" + 
				"사업자는 계약을 체결하는 때에 다음 각 호의 사항을 기재한 운송장을\r\n마련하여 고객(송화인)에게 교부합니다.\r\n" + 
				" - 사업자의 상호, 대표자명, 주소 및 전화번호, 담당자 이름, 운송장 번호\r\n"+
				"제5조 (운임의 청구와 유치권)\r\n" + 
				" - 운임 및 할증요금 -\r\n"+
				"같은 법정동 안에서만 배송 가능합니다.\r\n"+
				"기본운임 : 1000원(예)부평1동->부평1동일 때)\r\n"+ 
				"추가운임 : 지정행정동 이외/ 1000원 (행정동을 거칠 때마다 부과)\r\n"+
				" - 무게와 크기에 따라 각 항목 당 1000원의 추가금이 부여됩니다.\r\n";
		btnAgree.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f, agreeMsg, title, JOptionPane.PLAIN_MESSAGE);
			}
		});
	}
		
	//가입하기
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
				String idField = "아이디 : " + textId.getText() + "    ";
				String pwField = "비밀번호 : " + textPw.getText();
				output.write(idField.getBytes());
				output.write(pwField.getBytes());
				
				fileURL = "C:\\bada\\userInfo\\" + textId.getText() + "/" + textId.getText() + "2.txt";
				OutputStream output1 = new FileOutputStream(fileURL, true);
				String nameField = "이름\n" + textName.getText() + "\n";
				String phoneField = "휴대전화\n" + textPhone.getText() + "\n";
				String addressField1 = "주소\n" + ori_loc.getSelectedItem() + "\n";
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
			JOptionPane.showMessageDialog(f, "★회원가입 성공★", title, JOptionPane.PLAIN_MESSAGE);
			}
		});
	}
	
	//주소2 정보 가져오기
	public void showInfo(Frame f, TextField textId) {
		this.f = f;
		this.textId = textId;
		File file = new File("C:\\bada\\userInfo\\" + textId.getText() + "/" + textId.getText() + "2.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line1 = br.readLine();//이름
			String line2 = br.readLine();//진짜이름
			String line3 = br.readLine();//전화번호
			String line4 = br.readLine();//5454
			String line5 = br.readLine();//주소
			String line6 = br.readLine();//시
			String line7 = br.readLine();//구
			String line8 = br.readLine();//법정동
			String line9 = br.readLine();//행정동			
			String[] arData = {line2, line4, line6, line7, line8, line9};
			User.setUserInfo(arData);
			System.out.println("들어옴");
			
			Assemble.textname  = arData[0];
			Assemble.textnumber = arData[1];
			Assemble.locStr = arData[2];
			Assemble.textgu = arData[3];
			Assemble.textdong = arData[4];
			Assemble.dongnum = arData[5];
			
			
			br.close();
		} catch (Exception e) {
			System.out.println("에러뜸");
		}
		
	}
	
	
	
}