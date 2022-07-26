package assembles;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import assembles.ButtonAdapter1;
import assembles.MyPageAdapter1;
import assembles.MyPageAdapter2;
import assembles.MyPageAdapter3;
import assembles.MyPageAdapter4;
import assembles.MyPageAdapter5;
import joins.Join;
import joins.TextAdapter;
import joins.TextAdapter2;

public class Assemble {
	
	public static String locStr = "서울시";
	//몇동인지
	public static String dongnum = "1동";
	//이름
	public static String textname = "ooo";
	//전화번호
	public static String textnumber = "000-000-0000";
	//구
	public static String textgu = "oo구";
	//동
	public static String textdong = "oo동";
	//배달할 동
	static String deli_dong = "1동";
	//보유캐시
	static int textcash = 0;
	//임시 돈 더하는 인자
	static int tempcash = 1000;
	static int tempcash1 = 1000;
	//지불할 돈
	static int paycash = 1000;
	//유저정보를 담은 인자
	//빈 회원가입 방지를 위한 인자
	//아이디
	public static String userinfo = ".";
	//비밀번호
	public static String userinfo1 = ".";
	//전화번호
	public static String userinfo2 = ".";
	
	//라디로버튼을 위한 
	static String radioSize = "";
	static String radiowei = "";
	
	// 송장번호 찾아가기 위한 (로그인 아이디가 담기는 변수)
	static String sname = "";
	
	// 버튼 및 라벨 Background Color.
	static Color btnColor = new Color(255,153,153);
	static Color titleColor = new Color(153, 220, 220);
	static String sjNum;
	
	public static void main(String[] args) {
		
		ArrayList<Character> memo = new ArrayList<>();
		ArrayList<Character> memo2 = new ArrayList<>();
		
		Color gray = Color.gray;
		
		// window
		
		Frame main_before_view = new Frame("BADA"); // 시작 화면
		Frame Login = new Frame("BADA"); // 로그인 화면(임시)
		Frame join = new Frame("BADA"); // 회원가입 화면
		Frame main_after_view = new Frame("BADA"); // 로그인 후 메인 화면
		Frame mypage = new Frame("BADA"); // 마이페이지 화면
		Frame deliver = new Frame("BADA"); // 택배 접수 화면
		Frame deliver_check = new Frame("BADA"); // 배송 조회 화면
		Frame deliver_review = new Frame("BADA"); // 배송완료 리뷰 팝업창 
		Frame map = new Frame("BADA"); // 지도 보기 화면
		Frame delecting = new Frame("BADA");//회원탈퇴화면
		
		//폰트
		Font font = new Font("궁서체",Font.ITALIC,20);
		Font font2 = new Font("궁서체",Font.ITALIC,15);
		Font font3 = new Font("궁서체",Font.ROMAN_BASELINE,12);
		Font font_15 = new Font("", Font.PLAIN, 15);
		Font font_18 = new Font("", Font.PLAIN, 18);
		Font font_20 = new Font("", Font.PLAIN, 20);
		Font font_30 = new Font("", Font.PLAIN, 30);
		Font font_50 = new Font("", Font.PLAIN, 50);
		
		
		// 어플 베이스 화면 초기 설정
		
		// 시작 화면
		main_before_view.setBounds(500, 30, 480, 800);
		main_before_view.setLayout(null);
		main_before_view.setResizable(false);
		
		// 로그인 화면
		Login.setBounds(500, 30, 480, 800);
		Login.setLayout(null); // 자동 배치 끄기
		Login.setResizable(false); // 생성된 프레임의 사이즈 변경을 막는다.
		
		// 회원가입
		join.setBounds(500, 30, 480, 800);
		join.setLayout(null);
		join.setResizable(false);
		
		// 로그인 후 메인 화면
		main_after_view.setBounds(500, 30, 480, 800);
		main_after_view.setLayout(null);
		main_after_view.setResizable(false);
		
		// 마이페이지
		mypage.setBounds(500, 30, 480, 800);
		//프레임의 화면을 가득 채우는 자동배치를 끈다.
		mypage.setLayout(null);
		//프레임 늘리는 거 금지
		mypage.setResizable(false);
		
		//탈퇴화면
		delecting.setBounds(550, 330, 380, 400);
		delecting.setLayout(null);
		delecting.setResizable(false);
		
		// 택배 접수
		deliver.setBounds(500, 30, 480, 800);
		deliver.setLayout(null);
		deliver.setResizable(false);
		
		// 배송 조회
		deliver_check.setBounds(500, 30, 480, 800);
		deliver_check.setLayout(null);
		deliver_check.setResizable(false);
		
		// 배송완료 리뷰 팝업창
		deliver_review.setBounds(550, 330, 380, 400);
		deliver_review.setLayout(null);
		deliver_review.setResizable(false);
		
		
		// 시작 화면
		Label l_main_head1 = new Label("우리동네");
		l_main_head1.setFont(font_20);
		l_main_head1.setBounds(195, 100, 90, 50);
		l_main_head1.setBackground(new Color(153, 220, 220));
		
		Label l_main_head2 = new Label("오늘바다");
		l_main_head2.setFont(new Font("", Font.BOLD, 70));
		l_main_head2.setBounds(100, 160, 290, 80);
		l_main_head2.setBackground(new Color(153, 220, 220));
		
		Button b_main_login = new Button("로그인");
		b_main_login.setFont(font_30);
		b_main_login.setBounds(50, 270, 180, 110);
		b_main_login.setBackground(btnColor);
		b_main_login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				main_before_view.dispose();
				Login.setVisible(true);
			}
		});
		
		Button b_main_join = new Button("회원가입");
		b_main_join.setFont(font_30);
		b_main_join.setBounds(255, 270, 180, 110);
		b_main_join.setBackground(btnColor);
		b_main_join.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				main_before_view.dispose();
				join.setVisible(true);
			}
		});
		
		Button b_main_deliver = new Button("택배 접수");
		b_main_deliver.setBounds(50, 400, 180, 110);
		b_main_deliver.setFont(font_30);
		b_main_deliver.setBackground(btnColor);
		b_main_deliver.addActionListener(new ButtonAdapter1(main_before_view));
		
		Button b_main_deliver_check = new Button("배송 조회");
		b_main_deliver_check.setBounds(255, 400, 180, 110);
		b_main_deliver_check.setFont(font_30);
		b_main_deliver_check.setBackground(btnColor);
		b_main_deliver_check.addActionListener(new ButtonAdapter1(main_before_view));
		
		
		// 시작화면 이미지 애니메이션
		
      	ImageIcon main_img = new ImageIcon("src/bin/imgs/del4.png");
		JLabel mi = new JLabel(main_img);
		Next_Animation next_ani = new Next_Animation(mi);
		Thread thread = new Thread(next_ani);
		thread.start();

		main_before_view.add(mi);
		
		ImageIcon main_img2 = new ImageIcon("src/bin/imgs/del3.png");
		JLabel mi2 = new JLabel(main_img2);
		Next_Animation2 next_ani2 = new Next_Animation2(mi2);
		Thread thread2 = new Thread(next_ani2);
		thread2.start();
		
		main_before_view.add(mi2);
		
		ImageIcon main_img3 = new ImageIcon("src/bin/imgs/del2.png");
		JLabel mi3 = new JLabel(main_img3);
		Next_Animation3 next_ani3 = new Next_Animation3(mi3);
		Thread thread3 = new Thread(next_ani3);
		thread3.start();
		
		main_before_view.add(mi3);
		
		ImageIcon main_img4 = new ImageIcon("src/bin/imgs/del1.png");
		JLabel mi4 = new JLabel(main_img4);
		Next_Animation4 next_ani4 = new Next_Animation4(mi4);
		Thread thread4 = new Thread(next_ani4);
		thread4.start();
		
		main_before_view.add(mi4);
		
		
		
		// 로그인 화면
		
		Label l_main_head3 = new Label("우리동네");
		l_main_head3.setFont(font_20);
		l_main_head3.setBounds(195, 100, 90, 50);
		l_main_head3.setBackground(new Color(153, 220, 220));	

		Label l_main_head4 = new Label("오늘바다");
		l_main_head4.setFont(new Font("", Font.BOLD, 70));
		l_main_head4.setBounds(100, 160, 290, 80);
		l_main_head4.setBackground(new Color(153, 220, 220));
		
		Label j1 = new Label("아이디");
		Label j2 = new Label("비밀번호");
		Label j3 = new Label("로그인 유지");
		
		j1.setFont(font_20);
		j2.setFont(font_20);
		j3.setFont(font_15);
		
		j1.setBounds(100, 280, 70, 40);
		j2.setBounds(100, 340, 90, 40);
		j3.setBounds(230, 400, 90, 20);
		
		j1.setBackground(btnColor);
		j2.setBackground(btnColor);
		j3.setBackground(Color.WHITE);
		
		Checkbox cb = new Checkbox();
		cb.setBounds(210, 400, 30, 20);
		cb.setBackground(Color.WHITE);
		
		TextField ta1 = new TextField();
		TextField ta2 = new TextField();
		ta1.setBounds(210, 280, 180, 40);
		ta2.setBounds(210, 340, 180, 40);
		ta1.setFont(font_20);
		ta2.setFont(font_20);
		ta2.setEchoChar('*');
		
		// 로그인
		Button btn1 = new Button("로그인");
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// "아이디 : value" 가 <arrayList> memo에 "아이디 : value"랑 같아야함
				// ta1 필드에 입력된 아이디와 ta2 필드에 입력된 비밀번호가 String 변수 real_id와 real_pw에 저장되게 해야함

				// String address_field = "비밀번호 : " + ta2.getText();
				// String number_field = "비밀번호 : " + ta2.getText();

				String idname = "/" + ta1.getText() + ".txt";

				String id_field = "아이디 : " + ta1.getText();
				String pw_field = "비밀번호 : " + ta2.getText();
				String jump = "    ";

				try {
					// 파일 객체 생성
		    	File file = new File("C:/bada/userInfo/" + ta1.getText() + "/" + idname); //학원
					// 입력 스트림 생성
		    	if(!file.isFile()){
					JOptionPane.showMessageDialog(Login, "아이디가 존재하지 않습니다");
				}

					FileReader file_reader = new FileReader(file);

					int cur = 0;

					while ((cur = file_reader.read()) != -1) {
						memo.add((char) cur);
					}

					for (int i = 0; i < id_field.length(); i++) {

						memo2.add(id_field.charAt(i));
					}
					for (int i = 0; i < jump.length(); i++) {

						memo2.add(jump.charAt(i));
					}
					for (int i = 0; i < pw_field.length(); i++) {

						memo2.add(pw_field.charAt(i));
					}

	               if (memo.equals(memo2)) // 아이디 비밀번호가 맞아야 로그인 성공
	               {
	                  JOptionPane.showMessageDialog(Login, "로그인 성공");
	                  
	                  //로그인 성공 떴을 때 유저 정보가져오기
	                  
	                  
	                  
	                  new joins.Join().showInfo(Login,ta1);

	                  //파일 인풋 스트림
	                  
	                  //스트링 레스로 정보 읽어오기
//	          		String path = "D:/bada/userInfo/" + ta1.getText() +"/" + ta1.getText() + "2.txt";
//	        		File f = new File(path);
//	        		
//	        		byte[] read = new byte[(int)f.length()];
//
//	        		
//	        		if(f.exists()) {
//	        			try {
//	        				FileInputStream fis = new FileInputStream(f);
//	        				fis.read( read );
//
//	        				
//	        				String res = new String(read);
//	        				
//	        				userinfo = res;
//	        				
//	        				System.out.println(userinfo);
//	        				
//	        				fis.close();
//	        				
//	        			} catch (Exception e4) {
//	        				e4.printStackTrace();
//	        			}
//	        		}
	                  
	        		//캐쉬만이라도 인자화하기
	        		
	                  
	          		String path1 = "C:\\bada\\userInfo\\" + ta1.getText() + "/" + ta1.getText() + "cash.txt";
	        		File f1 = new File(path1);
	        		
	        		byte[] read1 = new byte[(int)f1.length()];

	        		if(f1.exists()) {
	        			try {
	        				FileInputStream fis1 = new FileInputStream(f1);
	        				fis1.read( read1 );

	        				
	        				String res1 = new String(read1);
	        				
	        				fis1.close();
	        				
	        				textcash = 0;
	        				textcash = Integer.parseInt(res1);

	        				
	        			} catch (Exception e4) {
	        				e4.printStackTrace();
	        			}
	        	}
	        		  
	                  
	                  //여기까지 복사붙여놓기함
	                     
	                  Login.dispose();
	                  main_after_view.setVisible(true);
	               } else if (!memo.equals(memo2)){
	                  JOptionPane.showMessageDialog(Login, "비밀번호가 틀렸습니다.");
	                  memo2.clear();
	                  memo.clear();
	               }

					
					file_reader.close();
					
					
				} catch (Exception e1) {
					e1.getStackTrace();
				} // 불러오기
			}
		});
		
		
		btn1.setBackground(btnColor);
		btn1.setBounds(100, 460, 290, 60);
		btn1.setFont(font_30);
		// 버튼
		
				
		
		// 회원가입 화면
		
		Button btnId = new Button("중복확인");
		Button btnPw = new Button("확인");
		Button btnPhone = new Button("인증하기");
		Button btnAddress = new Button("지도보기");//지도보기로 바꿈
		Button btnJoin = new Button("가입하기");
		Button btnQuit = new Button("취소하기");
		btnId.setBounds(350, 200, 85, 30);
		btnPw.setBounds(350, 330, 85, 30);
		btnPhone.setBounds(350, 460, 85, 30);
		btnAddress.setBounds(350, 565, 85, 30);//버튼 위치 수정
		btnJoin.setBounds(40, 710, 160, 50);
		btnQuit.setBounds(280, 710, 160, 50);
		
		btnId.setFont(font_20);
		btnPw.setFont(font_20);
		btnPhone.setFont(font_20);
		btnAddress.setFont(font_20);
		btnJoin.setFont(font_30);
		btnQuit.setFont(font_30);
		
		//회원가입 창 버튼 비활성화
		btnId.setEnabled(false);
		btnPw.setEnabled(false);
		btnPhone.setEnabled(false);	
		btnJoin.setEnabled(false);
		
		Label labelTitle = new Label("회원가입");
		Label labelId = new Label("아이디");
		Label labelPw = new Label("비밀번호");
		Label labelPw2 = new Label("비밀번호 확인");
		Label labelName = new Label("이름");
		Label labelPhone = new Label("휴대전화");
		Label labelAddress = new Label("주소");
		labelTitle.setBounds(130, 80, 220, 60);
		labelId.setBounds(40, 200, 70, 30);
		labelPw.setBounds(40, 265, 100, 30);
		labelPw2.setBounds(40, 330, 130, 30);
		labelName.setBounds(40, 395, 60, 30);
		labelPhone.setBounds(40, 460, 100, 30);
		labelAddress.setBounds(40, 525, 60, 30);
		
		labelTitle.setFont(font_50);
		labelId.setFont(font_20);
		labelPw.setFont(font_20);
		labelPw2.setFont(font_20);
		labelName.setFont(font_20);
		labelPhone.setFont(font_20);
		labelAddress.setFont(font_20);
		
		
		TextField textId = new TextField();
		TextField textPw = new TextField();
		TextField textPw2 = new TextField();
		TextField textName = new TextField();
		TextField textPhone = new TextField();			
		
		
		//주소
		
		//선택상자로 만들기
		//첫째줄
		Choice ori_loc = new Choice();
		ori_loc.add("서울시");
		ori_loc.add("인천/경기");
		ori_loc.add("강원");
		ori_loc.add("세종/대전/충청");
		ori_loc.add("대구/부산/울산/경상");
		ori_loc.add("광주/전라");
		ori_loc.add("제주");
			
			
		ori_loc.setSize(110, 30);
		ori_loc.setLocation(115, 525);
		ori_loc.setFont(font_15);
		
		ori_loc.addItemListener(new MyPageAdapter5(join));
		
		join.add(ori_loc);

		TextField ori_gu = new TextField("구");
		ori_gu.setBounds(235, 525, 105, 30);
		ori_gu.setFont(font_18);

		join.add(ori_gu);		
		
		//둘째줄
		TextField ori_dong = new TextField("동");
		ori_dong.setBounds(115, 565, 110, 30);
		ori_dong.setFont(font_18);
				
			
		//동 항목선택 상자(choice)
		Choice ori_dongnum = new Choice();
		ori_dongnum.setFont(font_15);
		ori_dongnum.add("1동");
		ori_dongnum.add("2동");
		ori_dongnum.add("3동");
		ori_dongnum.add("4동");
		ori_dongnum.add("5동");
		
		ori_dongnum.setSize(105, 30);
		ori_dongnum.setLocation(235, 565);
		
		ori_dongnum.addItemListener(new MyPageAdapter4(join));
		
		join.add(ori_dong);
		join.add(ori_dongnum);
			
		textPw.setEchoChar('*');
		textPw2.setEchoChar('*');
		
		textId.setBounds(180, 200, 160, 30);
		textPw.setBounds(180, 265, 160, 30);
		textPw2.setBounds(180, 330, 160, 30);
		textName.setBounds(180, 395, 160, 30);
		textPhone.setBounds(180, 460, 160, 30);
						
		textId.setFont(font_20);
		textPw.setFont(font_20);
		textPw2.setFont(font_20);
		textName.setFont(font_20);
		textPhone.setFont(font_20);
		
		//약관동의
		Checkbox boxAgree = new Checkbox("약관에 동의합니다.");
		boxAgree.setBounds(40, 630, 140, 30);
		Button btnAgree = new Button("약관 보기");
		btnAgree.setBounds(350, 630, 85, 30);
		
		//회원가입 창 버튼&레이블 색상 설정
		labelTitle.setBackground(btnColor);
		labelId.setBackground(btnColor);
		labelPw.setBackground(btnColor);
		labelPw2.setBackground(btnColor);
		labelName.setBackground(btnColor);
		labelPhone.setBackground(btnColor);
		labelAddress.setBackground(btnColor);
		boxAgree.setBackground(btnColor);
		btnAgree.setBackground(btnColor);
//		textId.setBackground(btnColor);
//		textPw2.setBackground(btnColor);
//		textPhone.setBackground(btnColor);
//		ori_dongnum.setBackground(btnColor);
//		ori_loc.setBackground(btnColor);
		
		textId.setText("");
		textPw.setText("");
		textPw2.setText("");
		textName.setText("");
		textPhone.setText("");
		ori_gu.setText("구");
		ori_dong.setText("동");
		
		// 회원가입
		Button btn2 = new Button("회원가입");
		btn2.addActionListener(new ActionListener() { 
//					
			@Override
			public void actionPerformed(ActionEvent e) {
				
				textId.setText("");
				textPw.setText("");
				textPw2.setText("");
				textName.setText("");
				textPhone.setText("");
				ori_gu.setText("구");
				ori_dong.setText("동");
				Login.dispose();
				join.setVisible(true);
			}
		});
		
		// 뒤로가기
		Button btn3 = new Button("뒤로가기");
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				textId.setText("");
				textPw.setText("");
				textPw2.setText("");
				textName.setText("");
				textPhone.setText("");
				ori_gu.setText("구");
				ori_dong.setText("동");
				Login.dispose();
				main_before_view.setVisible(true);
			}
		});
		
		btn2.setBackground(btnColor);
		btn2.setBounds(100, 540, 290, 60);
		btn2.setFont(font_30);
		btn3.setBackground(btnColor);
		btn3.setBounds(100, 620, 290, 60);
		btn3.setFont(font_30);
		
		//동의 체크시 '가입하기'버튼 활성화
		boxAgree.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				//boolean rt = userinfo.equals(textId.getText().toString())&& userinfo1.equals(textPw.getText().toString()) && userinfo1.equals(textPw2.getText().toString()) && userinfo2.equals(textPhone.toString());
				boolean rt = userinfo.equals(textId.getText().toString());
				boolean rt1 =  userinfo1.equals(textPw.getText().toString());
				boolean rt2 =  userinfo2.equals(textPhone.getText().toString());
				System.out.println(rt);
				System.out.println(rt1);
				System.out.println(rt2);
				System.out.println(userinfo2);
				System.out.println(textPhone.getText().toString());
				
				if (boxAgree.getState() && userinfo.equals(textId.getText().toString())&& userinfo1.equals(textPw.getText().toString()) && userinfo1.equals(textPw2.getText().toString()) && userinfo2.equals(textPhone.getText().toString())) {
					
					
					btnJoin.setEnabled(true);
					
				} else {
					
					btnJoin.setEnabled(false);
					
				}//if
			}
		});
		
		
		//버튼 활성화
		textId.addTextListener(new joins.TextAdapter(textId, btnId));
//		System.out.println(userinfo);
		textPw2.addTextListener(new joins.TextAdapter(textPw2, btnPw));
//		System.out.println(userinfo1);
		textPhone.addTextListener(new joins.TextAdapter(textPhone, btnPhone));
//		System.out.println(userinfo2);
		
		//회원가입 시 '가입하기' -> 로그인 화면으로 이동
		btnJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				textname = textName.getText().toString();
				textnumber = textPhone.getText().toString();
				textgu = ori_gu.getText().toString();
				textdong = ori_dong.getText().toString();
				
				ta1.setText("");
				ta2.setText("");
				join.dispose();
				Login.setVisible(true);
				
			}
		});
		
		
		//회원가입 시 '취소하기' -> 메인화면으로 이동
		btnQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//스테틱인자를 지금 기입한 인자들로 바꾸기
				ta1.setText("");
				ta2.setText("");
				textId.setText("");
				textPw.setText("");
				textPw2.setText("");
				textName.setText("");
				textPhone.setText("");
				ori_gu.setText("구");
				ori_dong.setText("동");
				join.dispose();
				main_before_view.setVisible(true);
				
			}
		});
		
		
		//아이디 중복 확인		
		new joins.Join(textId).checkId(btnId);
		
		//비밀번호 일치 확인
		new joins.Join(textPw, textPw2).checkPw(btnPw);
		
		//인증번호 확인
		new joins.Join(textId, textPw2, textPhone).checkPhone(btnPhone);
		
		//약관 보기
		new joins.Join().showDoc(btnAgree);
		
		//회원가입
		new joins.Join(textId, textPw2, textName, textPhone, ori_gu, ori_loc, ori_dongnum, ori_dong).join(btnJoin);
		
		///지도화면
		map.setBounds(500, 30, 480, 800);
		map.setLayout(null);
		
		//oo동 이라는 제목
		Label map_title = new Label();
		map_title.setBounds(200, 100, 100, 40);
		map_title.setFont(font);
		
		map.add(map_title);
		//지도사진
		ImageIcon back = new ImageIcon("src/bin/imgs/map_dong.png");
		JLabel jl_back = new JLabel(back);
		jl_back.setBounds(0,150,480,500);
		
		//뒤로가기 버튼
		Button btn_mapback = new Button("회원가입으로 돌아가기");
		btn_mapback.setBounds(255, 700, 210, 50);
		
		btn_mapback.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				map.dispose();
				join.setVisible(true);
				
			}
		});
		
		//뒤로가기버튼2
		
		Button btn_mapback2 = new Button("배달로 돌아가기");
		btn_mapback2.setBounds(255, 700, 210, 50);
		
		btn_mapback2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				map.dispose();
				deliver.setVisible(true);
				
			}
		});
		
		map.add(btn_mapback2);
		map.add(jl_back);
		map.add(btn_mapback);
		
		btn_mapback2.setVisible(false);
		
		//지도보기버튼
		btnAddress.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				join.dispose();
				map.setVisible(true);
				map_title.setText(ori_dong.getText().toString());
				btn_mapback2.setVisible(false);
				btn_mapback.setVisible(true);
				
			}
		});
		
		
		// 로그인 후 메인 화면
		Label l_sub_head1 = new Label("우리동네");
		l_sub_head1.setFont(font_20);
		l_sub_head1.setBounds(195, 100, 90, 50);
		l_sub_head1.setBackground(titleColor);
		
		Label l_sub_head2 = new Label("오늘바다");
		l_sub_head2.setFont(new Font("", Font.BOLD, 70));
		l_sub_head2.setBounds(100, 160, 280, 80);
		l_sub_head2.setBackground(titleColor);
		
		Button b_sub_mypage = new Button("마이페이지");
		b_sub_mypage.setFont(font_30);
		b_sub_mypage.setBounds(50, 270, 180, 110);
		b_sub_mypage.setBackground(btnColor);
		
		b_sub_mypage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				main_after_view.dispose();
				mypage.setVisible(true);
				
			}
		});
		
		
		
		Button b_sub_deliver = new Button("택배 접수");
		b_sub_deliver.setBounds(50, 400, 180, 110);
		b_sub_deliver.setFont(font_30);
		b_sub_deliver.setBackground(btnColor);
		
		b_sub_deliver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				main_after_view.dispose();
				deliver.setVisible(true);
				
			}
		});
		
		Button b_sub_deliver_check = new Button("배송 조회");
		b_sub_deliver_check.setBounds(255, 400, 180, 110);
		b_sub_deliver_check.setFont(font_30);
		b_sub_deliver_check.setBackground(btnColor);
		
		b_sub_deliver_check.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				main_after_view.dispose();
				deliver_check.setVisible(true);
				
			}
		});
		
		
		// 마이페이지 화면
		
		//폰트 클래스 new Font("이름",style,size);
		Label q1 = new Label("마이페이지");
		q1.setFont(font_50);
		q1.setBounds(120, 80, 250, 60);
		q1.setBackground(btnColor);
		
		//주소입력창
		//글자와 관련된 클래스
		//폰트 클래스 new Font("이름",style,size);
		Label q2 = new Label("주소입력:");
		q2.setFont(font_20);
		q2.setBounds(50,190,80,25);
		q2.setBackground(btnColor);
		
		//항목선택 상자(choice)
		Choice loc = new Choice();
		loc.add("서울시");
		loc.add("인천/경기");
		loc.add("강원");
		loc.add("세종/대전/충청");
		loc.add("대구/부산/울산/경상");
		loc.add("광주/전라도");
		loc.add("제주도");
		
		loc.setSize(150,0);
		loc.setLocation(318,190);
		
		//선택상자 이벤트감지자 등록
		loc.addItemListener(new MyPageAdapter1(mypage));

		loc.setVisible(false);
		
		
		//유저의 구를 바로 넣기
		TextField tf = new TextField();
		tf.setBounds(135,220,70,25);
		tf.setFont(font_20);
		
		
		//유저정보를 스테틱으로 설정 한 후  동을 넣어놓기
		//동
		TextField tf2 = new TextField();
		tf2.setBounds(205,220,70,25);
		tf2.setFont(font_20);
		
		
		//동 항목선택 상자(choice)
		Choice dongnumber = new Choice();
		dongnumber.add("1동");
		dongnumber.add("2동");
		dongnumber.add("3동");
		dongnumber.add("4동");
		dongnumber.add("5동");
		
		dongnumber.setSize(50,0);
		dongnumber.setLocation(345,220);
		
		dongnumber.addItemListener(new MyPageAdapter2(mypage));
		dongnumber.setVisible(false);	
		
		
		//초이스로 된 인자를 표시하는 상자 서울시 등
		TextField tf7 = new TextField();
		tf7.setBounds(135,190,182,25);
		tf7.setFont(font_15);
		tf7.setEditable(false);
		
		mypage.add(tf7);
		
		//초이스로 된 인자를 표시하는 상자 동넘버
		TextField tf8 = new TextField();
		tf8.setBounds(275,220,70,25);
		tf8.setFont(font_15);
		tf8.setEditable(false);
		
		mypage.add(tf8);
		
		
		//이름
		Label q5 = new Label("이름:"); // + 유저네임(textname)
		q5.setFont(font_20);
		q5.setBounds(50,250,50,25);
		q5.setBackground(btnColor);
		
		//이름 들어갈 필드
		TextField tf5 = new TextField();
		tf5.setBounds(135,250,115,25);
		tf5.setFont(font_20);
		
		
		//전화번호
		
		
		
		Label q6 = new Label("전화번호:"); 
		q6.setFont(font_20);
		q6.setBounds(50,280,85,25);
		q6.setBackground(btnColor);
		
		//전화번호 들어갈 필드
		TextField tf6 = new TextField(textnumber);
		tf6.setText(textnumber);
		tf6.setBounds(135,280,150,25);
		tf6.setFont(font_20);
		
		//TextField에 적힌 값을 넘기는 "확인"버튼
		Button btn_locok = new Button("변경");
		btn_locok.setBounds(350,150,45,30);
		
		btn_locok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dongnumber.setVisible(true);
				loc.setVisible(true);
				tf2.setEditable(true);
				tf.setEditable(true);
				tf6.setEditable(true);
				tf5.setEditable(true);

			}
		});
		
		//전화번호 변경버튼
		Button btn_phonech = new Button("저장");
		btn_phonech.setBounds(395,150,45,30);
		
		btn_phonech.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				textdong = tf2.getText();
				textgu = tf.getText();
				textnumber = tf6.getText();
				textname = tf5.getText();
				
				dongnumber.setVisible(false);
				loc.setVisible(false);
				tf2.setEditable(false);
				tf.setEditable(false);
				tf6.setEditable(false);
				tf5.setEditable(false);

				try {	
					
					System.out.println(ta1.getText()+"");

					String fileURL = "D:\\bada\\userInfo\\" + ta1.getText() + "/" + ta1.getText() + "2.txt";
					OutputStream output1 = new FileOutputStream(fileURL, false);
					String nameField = "이름\n" + textname + "\n";
					String phoneField = "휴대전화\n" + textnumber + "\n";
					String addressField1 = "주소\n" + locStr + "\n";
					String addressField2 = textgu + "\n";	
					String addressField3 = textdong + "\n";
					String addressField4 = dongnum +"\n";
					

					String fileURL1 = "D:\\bada\\userInfo\\" + ta1.getText() + "/" + ta1.getText() + "cash.txt";
					OutputStream output2 = new FileOutputStream(fileURL1, false);
					String addressField5 = textcash +""; 
					
					output1.write(nameField.getBytes());
					output1.write(phoneField.getBytes());
					output1.write(addressField1.getBytes());
					output1.write(addressField2.getBytes());
					output1.write(addressField3.getBytes());
					output1.write(addressField4.getBytes());
					output2.write(addressField5.getBytes());
					output1.close();
					output2.close();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}//try&catch	
				dongnumber.setVisible(false);
				loc.setVisible(false);
			}
		});
		
		
		dongnumber.setVisible(false);
		loc.setVisible(false);
		tf2.setEditable(false);
		tf.setEditable(false);
		tf6.setEditable(false);
		tf5.setEditable(false);
		
		
		//캐시 충전하기
		Label q7 = new Label("캐시충전하기");
		q7.setFont(font_20);
		q7.setBounds(50,340,120,25);
		q7.setBackground(btnColor);
		
		//충전할 만큼 입력
		TextField tf4 = new TextField( textcash + "원");
		tf4.setBounds(240,340,150,25);
		tf4.setFont(font_20);
		
		//현재 충전 금액
		TextField tf3 = new TextField();
		tf3.setBounds(240,370,150,25);
		tf3.setFont(font_20);
		tf3.setEditable(false);
		
		// 로그인 후 메인 화면의 로그아웃 버튼
		Button b_sub_logout = new Button("로그아웃");
		b_sub_logout.setFont(font_30);
		b_sub_logout.setBounds(255, 270, 180, 110);
		b_sub_logout.setBackground(btnColor);
		
		b_sub_logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				tf.setText("");
				tf2.setText("");
				tf5.setText("");
				tf6.setText("");
				tf7.setText("지역: ");
				tf8.setText("몇동: ");
				tf3.setText("원");
				
				ta1.setText("");
				ta2.setText("");
				textId.setText("");
				textPw.setText("");
				textPw2.setText("");
				textName.setText("");
				textPhone.setText("");
				ori_gu.setText("구");
				ori_dong.setText("동");
				main_after_view.dispose();
				main_before_view.setVisible(true);
				
			}
		});

		//캐시 충전 버튼
		Button btn_cashchar = new Button("충전");
		btn_cashchar.setBounds(395,340,45,30);
		
		btn_cashchar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try { 
					
					
					
					int temck = 0;
					temck += Integer.parseInt(tf4.getText());
					
					while(true) {
						String phoneMsg = "카드인증번호를 입력해 주세요.";
						int[] num = new int[6];
						String number = "";
						for (int i = 0; i < num.length; i++) {
							num[i] = new Random().nextInt(9);
						}//for
						for (int j = 0; j < num.length; j++) {
							number += ""+num[j];
						}//for
						String inputNum = JOptionPane.showInputDialog("인증번호 : "+number + "\r\n"+ phoneMsg);
						if(inputNum.equals(number)) {
							JOptionPane.showMessageDialog(mypage, "충전이 완료되었습니다", "카드번호", JOptionPane.PLAIN_MESSAGE);
							
							textcash += Integer.parseInt(tf4.getText());
							System.out.println(textcash);
							tf4.setText("0원");
							tf3.setText(textcash + "원");	
							
							//캐시는 캐시 이벤트가 있을 때 마다 저장해놓기
							String fileURL1 = "D:\\bada\\userInfo\\" + ta1.getText() + "/" + ta1.getText() + "cash.txt";
							OutputStream output2 = new FileOutputStream(fileURL1, false);
							String addressField5 = textcash +""; 
							output2.write(addressField5.getBytes());
							output2.close();
							
							break;
						} else {
							JOptionPane.showMessageDialog(mypage, "일치하지 않습니다.\r\n다시 시도해 주세요.", "카드번호", JOptionPane.ERROR_MESSAGE);
						}//if	
					}//while
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(mypage, "취소되었습니다 \n" + "충전금액은 숫자만 입력바랍니다.");
				};//try & catch
			}
		});
		
		
		//현재 충전된 캐시
		Label q8 = new Label("현재 충전된 캐시");
		q8.setFont(font_20);
		q8.setBounds(50,370,160,25);
		q8.setBackground(btnColor);
		
		
		//충전된 캐시 표시 창은 위에 있음
				
				
		////결제금액제목 가려져서 일단 없앰 
		//Label q12 = new Label("결제금액");
		//q12.setFont(font_15);
		//q12.setBounds(385,430,100,30);
		//mypage.add(q12);
		
		
		//결제내역제목
		Label q9 = new Label("결제내역");
		q9.setFont(font_20);
		q9.setBounds(50,450,80,25);
		q9.setBackground(btnColor);
		
		
		//송장번호제목
		Label q11 = new Label("결제날짜 - 송장번호 - 결제금액");
		q11.setFont(font_15);
		q11.setBounds(50,480,210,25);
		q11.setBackground(btnColor);
		
		
		//결제내역

		
		//결제내역
		//결제내역이 들어갈 창
		TextArea ta = new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);
		ta.setBounds(50,520,385,180);
		ta.setEditable(false);
		ta.setText("");
		
		mypage.add(ta);
		
		
		//결제내역 버튼
		Button btn_paylist = new Button("결제내역불러오기");
		btn_paylist.setBounds(330,480,115,30);
		
		btn_paylist.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
				
				try {		
					File file = new File("D:\\bada\\userInfo\\"+ta1.getText()+"\\songjang");	
					File[] dirName = file.listFiles();
											
					//송장번호 저장경로
					String deliveryNum = "";
					//송장번호 저장변수
					String delNum = "";
					for (int i = 0; i < dirName.length ; i++) {
							deliveryNum += dirName[i].getPath()+",";
							delNum += deliveryNum.substring(deliveryNum.length()-14, deliveryNum.length()-5)+",";
					}//for							
					for (int j = 0; j < dirName.length; j++) {
						System.out.println(dirName[j]);
					}//for
					System.out.println(deliveryNum);
					System.out.println(delNum);
					
					//배열 저장경로와 송장번호 저장
					String[] arDeliveryNum = deliveryNum.split(",");
					String[] arDelNum = delNum.split(",");
					
					for (int i = 0; i < arDeliveryNum.length; i++) {
						File file2 = new File(arDeliveryNum[i]);														
						FileInputStream input = new FileInputStream(file2);	
						int data = 0;	
						String payMoney = "";
						while((data=input.read())!=-1) {
							payMoney += (char)data;	
						}//while		
						DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
						String date_time = date.format(LocalDateTime.now());
						ta.append(date_time+"\t"+arDelNum[i]+"\t"+payMoney+"원 결제\r\n");
						
					input.close();
					}// for					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(mypage, "결제내역이 없습니다.", null, JOptionPane.ERROR_MESSAGE);
				}//try&catch
			}
		});
		
		
		mypage.add(btn_paylist);
		
		//새로고침버튼
		Button btn_renew = new Button("정보불러오기/새로고침");
		btn_renew.setBounds(50,150,150,30);
		
		btn_renew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				tf.setText(textgu);
				tf2.setText(textdong);
				tf5.setText(textname);
				tf6.setText(textnumber);
				tf7.setText("지역: " + locStr);
				tf8.setText("몇동: " + dongnum);
				tf3.setText(textcash + "원");
//				ta_userinfo.setText("이 칸은 로그인 시 불러온 저장된 사용자 정보입니다\n"+ "\n" + userinfo + "\n"+ "\n"+ "읽어보시고 변경사항이 있으면 변경 후 저장해주세요 \n " + "\n"+  "이 칸은 로그아웃 후 갱신되며 새로고침을 누른상태가 현재상태입니다 \n"+ "\n" + "변경사항이 있으시면 각 항목의 변경 버튼을 누른 후 \n" + "\n" + "저장버튼을 눌러주세요 \n" +"\n");
				
			}
		});
		
		mypage.add(btn_renew);
		
		
		//탈퇴버튼
		Button btn_outmem = new Button("회원탈퇴");
		btn_outmem.setBounds(345,710,90,50);
		btn_outmem.setFont(font_20);
		
		btn_outmem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				delecting.setVisible(true);

			}
		});
		
		
		// 로그아웃 버튼
		Button btn_logout = new Button("로그아웃");
		btn_logout.setBounds(140,710,90,50);
		btn_logout.setFont(font_20);
		
		btn_logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//누르면 로그인 창으로 돌아가기
				ta.setText("");
				ta1.setText("");
				ta2.setText("");
				
				
				
				dongnumber.setVisible(false);
				loc.setVisible(false);
				tf.setText("");
				tf2.setText("");
				tf5.setText("");
				tf6.setText("");
				tf7.setText("지역: ");
				tf8.setText("몇동: ");
				tf3.setText("원");


				dongnumber.setVisible(false);
				loc.setVisible(false);
				tf2.setEditable(false);
				tf.setEditable(false);
				tf6.setEditable(false);
				tf5.setEditable(false);
				
//				textId.setText("");
//				textPw.setText("");
//				textPw2.setText("");
//				textName.setText("");
//				textPhone.setText("");
//				ori_gu.setText("구");
//				ori_dong.setText("동");
				mypage.dispose();
				main_before_view.setVisible(true);
				
			}
		});
		
		
		// 뒤로가기 버튼
		Button btn_back = new Button("홈으로");
		btn_back.setBounds(50, 710, 90, 50);
		btn_back.setFont(font_20);
		
		btn_back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btn_back.setVisible(true);
				ta.setText("");
				
				dongnumber.setVisible(false);
				loc.setVisible(false);
				tf2.setText(textdong);//동
				tf.setText(textgu); //구
				tf6.setText(textnumber);//전화번호
				tf5.setText(textname);//이름
				tf7.setText(locStr);//서울시
				tf8.setText(dongnum);//몇동

				dongnumber.setVisible(false);
				loc.setVisible(false);
				tf2.setEditable(false);
				tf.setEditable(false);
				tf6.setEditable(false);
				tf5.setEditable(false);
				
				mypage.dispose();
				main_after_view.setVisible(true);
				
			}
		}); 
		

		//
		// 누르면 로그인 후 메인창으로 돌아가기
		///마이페이지 뒤로가기
		// 뒤로가기 버튼
		
		//탈퇴화면
		Label deleok = new Label("탈퇴 하시겠습니까?");
		deleok.setFont(font_15);
		deleok.setBounds(120, 50, 220, 60);
		
		// 확인버튼
		Button delgo = new Button("네");
		delgo.setBounds(120, 250, 60, 30);
		
		delgo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//회원정보삭제하기

				//////삭제시작
				
				dongnumber.setVisible(false);
				loc.setVisible(false);
				tf.setText("");
				tf2.setText("");
				tf5.setText("");
				tf6.setText("");
				tf7.setText("지역: ");
				tf8.setText("몇동: ");
				tf3.setText("원");

				dongnumber.setVisible(false);
				loc.setVisible(false);
				tf2.setEditable(false);
				tf.setEditable(false);
				tf6.setEditable(false);
				tf5.setEditable(false);
				
				String path_del = "D:\\bada\\userInfo\\" + ta1.getText();
			    deleteFolder(path_del);
			    
			}
			
			public void deleteFolder(String path_del) {
				
			    File folderD = new File(path_del);
			    try {
				if (folderD.exists()) {
		                File[] folder_list = folderD.listFiles(); //파일리스트 얻어오기
						
				for (int i = 0; i < folder_list.length; i++) {
				    if(folder_list[i].isFile()) {
					folder_list[i].delete();
					System.out.println("파일이 삭제되었습니다.");
				    } else {
					deleteFolder(folder_list[i].getPath()); //재귀함수호출
					System.out.println("폴더가 삭제되었습니다.");
				    }//inner if
				    folder_list[i].delete();
				}//for
				 folderD.delete(); //폴더 삭제
				}//outter if
			    } catch (Exception e6) {
				e6.getStackTrace();
			    }//try&catch
				
				//////삭제하는 거 끝
				JOptionPane.showMessageDialog(delecting, "회원정보가 삭제되었습니다.");
				
				ta.setText("");
				ta1.setText("");
				ta2.setText("");
				
				delecting.dispose();
				mypage.dispose();
				main_before_view.setVisible(true);
			}
		});
		
		// 취소버튼
		Button delcan = new Button("아니오");
		delcan.setBounds(190, 250, 60, 30);
		
		delcan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				delecting.dispose();
				
			}
		});
		
		delecting.add(deleok);
		delecting.add(delgo);
		delecting.add(delcan);

		
		
		// 택배접수 화면
		Label l_d_head = new Label("택배 접수");
		l_d_head.setFont(font_50);
		l_d_head.setBounds(130, 80, 220, 60);
		l_d_head.setBackground(btnColor);
		
		Label l_to = new Label("받으시는 분");
		l_to.setFont(font_30);
		l_to.setBounds(40, 160, 170, 40);
		l_to.setBackground(btnColor);

		Label l_name = new Label("이름:");
		l_name.setFont(font_20);
		l_name.setBounds(40, 210, 50, 30);
		l_name.setBackground(btnColor);
		
		Label l_phone = new Label("전화번호:");
		l_phone.setFont(font_20);
		l_phone.setBounds(40, 250, 90, 30);
		l_phone.setBackground(btnColor);
		
		Label l_address = new Label("주소:");
		l_address.setFont(font_20);
		l_address.setBounds(40, 290, 50, 30);
		l_address.setBackground(btnColor);
		
		//주소
		//선택상자로 만들기
		TextField send_address_dong = new TextField();
		send_address_dong.setBounds(170, 290, 100, 30);
		send_address_dong.setFont(font_15);
		send_address_dong.setEditable(false);
			
		//동 항목선택 상자(choice)
		Choice send_address_dongnum = new Choice();
		send_address_dongnum.setFont(font_15);
		send_address_dongnum.add("1동");
		send_address_dongnum.add("2동");
		send_address_dongnum.add("3동");
		send_address_dongnum.add("4동");
		send_address_dongnum.add("5동");
		
		send_address_dongnum.setSize(50,0);
		send_address_dongnum.setLocation(280,290);
		send_address_dongnum.addItemListener(new MyPageAdapter3(deliver));
		
		//동에도 지도보기 넣기
		Button btn_map2 = new Button("지도보기");//검색하기를 지도보기로 변경
		btn_map2.setFont(font_15);
		btn_map2.setBounds(340,288,100,30);
		
		btn_map2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				send_address_dong.setText(textdong);
				map_title.setText(textdong);
				btn_mapback2.setVisible(true);
				btn_mapback.setVisible(false);
				deliver.dispose();
				map.setVisible(true);
				//버튼을 바꾸기
				//뒤로가기 버튼
				
			}
		});

		
		Label l_item = new Label("물품:");
		l_item.setFont(font_20);
		l_item.setBounds(40, 330, 50, 30);
		l_item.setBackground(btnColor);
		
		Label l_item_type = new Label("물품 종류:");
		l_item_type.setFont(font_20);
		l_item_type.setBounds(40, 370, 95, 30);
		l_item_type.setBackground(btnColor);
		
		Label l_item_size = new Label("크기:");
		l_item_size.setFont(font_20);
		l_item_size.setBounds(40, 410, 50, 30);
		l_item_size.setBackground(btnColor);
		
		Label l_item_weight = new Label("무게:");
		l_item_weight.setFont(font_20);
		l_item_weight.setBounds(40, 450, 50, 30);
		l_item_weight.setBackground(btnColor);
		
		Label l_money = new Label("예상금액:");
		l_money.setFont(font_20);
		l_money.setBounds(40, 530, 90, 30);
		l_money.setBackground(btnColor);
		
		TextField tf_name = new TextField();
		tf_name.setFont(font_18);
		tf_name.setBounds(170, 210, 270, 30);
		
		TextField tf_phone = new TextField();
		tf_phone.setFont(font_18);
		tf_phone.setBounds(170, 250, 270, 30);
		
		TextField tf_item = new TextField();
		tf_item.setFont(font_18);
		tf_item.setBounds(170, 330, 270, 30);
		
		
		TextField tf_money = new TextField();
		tf_money.setFont(font_18);
		tf_money.setBounds(170, 530, 210, 30);
		tf_money.setEnabled(false);
		
		CheckboxGroup cg_item_size = new CheckboxGroup();
		Checkbox cg_i_s1 = new Checkbox("80cm 이하",cg_item_size,true);
		Checkbox cg_i_s2 = new Checkbox("80cm ~ 100cm (+1000원)",cg_item_size,false);
		cg_i_s1.setBounds(130, 410, 100, 30);
		cg_i_s2.setBounds(240, 410, 200, 30);
		cg_i_s1.setBackground(Color.CYAN);
		cg_i_s2.setBackground(Color.CYAN);
		cg_i_s1.setFont(font_15);
		cg_i_s2.setFont(font_15);
		
		
		// 크기 감지자 생성
		cg_i_s1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				radioSize = e.getItem().toString();
				
			}
		});

		cg_i_s2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				radioSize = e.getItem().toString();
		        
				JOptionPane.showMessageDialog(deliver, "1000원이 추가되었습니다");
				
			}
		});
		
		
		CheckboxGroup cg_item_weight = new CheckboxGroup();
		Checkbox cg_i_w1 = new Checkbox("5kg 이하",cg_item_weight,true);
		Checkbox cg_i_w2 = new Checkbox("10kg 이하 (+1000원)",cg_item_weight,false);
		cg_i_w1.setBounds(130, 450, 90, 30);
		cg_i_w2.setBounds(240, 450, 170, 30);
		cg_i_w1.setBackground(Color.CYAN);
		cg_i_w2.setBackground(Color.CYAN);
		cg_i_w1.setFont(font_15);
		cg_i_w2.setFont(font_15);
		
		
		// 무게 감지자 생성
		cg_i_w1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				radiowei = e.getItem().toString();
				
			}
		});
		
		cg_i_w2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				radiowei = e.getItem().toString();
		        
				JOptionPane.showMessageDialog(deliver, "1000원이 추가되었습니다");
				
			}
		});
		
		
		Checkbox c1 = new Checkbox("귀중품");
		Checkbox c2 = new Checkbox("깨지기 쉬운 물품");
		c1.setBounds(100, 490, 80, 30);
		c2.setBounds(210, 490, 150, 30);
		c1.setBackground(Color.CYAN);
		c2.setBackground(Color.CYAN);
		c1.setFont(font_15);
		c2.setFont(font_15);
		
		
		Button back_btn = new Button("뒤로가기");
		back_btn.setBounds(40, 710, 160, 50);
		back_btn.setFont(font_30);
		back_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				deliver.dispose();
				main_after_view.setVisible(true);
				
			}
		});
		
		
		// 내가 보유한 캐시
		
		
		TextField mycash = new TextField();
		mycash.setText("내 캐쉬: " + textcash);
		mycash.setFont(font_15);
		mycash.setBounds(40, 570, 180, 30);
		mycash.setBackground(btnColor);
		mycash.setEditable(false);
		
		deliver.add(mycash);
		
		
		Button money_btn = new Button("확인");
		money_btn.setBounds(390, 530, 50, 30);
		money_btn.setFont(font_15);
		
		money_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//이 안에서만 쓰는 임시 인자를 스테틱으로 만들기
				
				send_address_dong.setText(textdong);

				if (dongnum.equals("1동")) {
					switch (deli_dong) {
					case "1동":
						break;
					case "2동": case "3동": case "4동": case "5동":
						tempcash += 1000;
						break; } }
				else if (dongnum.equals("2동")) {
					switch (deli_dong) {
					case "2동":
						break;
					case "1동": case "3동": 
						tempcash += 1000;
						break;
					case "4동": case "5동":
						tempcash += 2000;
						break;} }
				else if (dongnum.equals("3동")) {
					switch (deli_dong) {
					case "3동":
						break;
					case "1동": case "2동": case "4동":
						tempcash += 1000;
						break;
					case "5동":
						tempcash += 2000;
						break;} }
				else if (dongnum.equals("4동")) {
					switch (deli_dong) {
					case "4동":
						break;
					case "1동": case "3동": case "5동":
						tempcash += 1000;
						break;
					case "2동":
						tempcash += 2000;
						break;} }
				else if (dongnum.equals("5동")) {
					switch (deli_dong) {
					case "5동":
						break;
					case "1동": case "4동":
						tempcash += 1000;
						break;
					case "2동": case "3동":
						tempcash += 2000;
						break;} }
				

				if (radioSize.equals("80cm ~ 100cm (+1000원)")) {
					tempcash += 1000;
				} 
				

				if (radiowei.equals("10kg 이하 (+1000원)")) {
					tempcash += 1000;
				} 
				

				JOptionPane.showMessageDialog(deliver, tempcash + "원 입니다.");
				
				tempcash1 = tempcash;
				
				tempcash = 1000;
				
				tf_money.setText(tempcash1 + "원");
				mycash.setText("내 캐쉬: " + textcash);
				
			}
		});
		
		
		// 마이페이지 화면의 뒤로가기 버튼
		//뒤로가기버튼2 이건 택배접수에서 마이페이지로 넘어왔을 때 다시 택배접수로 다시위한 버튼
		Button btn_back1 = new Button("뒤로가기");
		btn_back1.setBounds(20, 750, 90, 30);
		
		btn_back1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dongnumber.setVisible(false);
				loc.setVisible(false);
				tf2.setText(textdong);//동
				tf.setText(textgu); //구
				tf6.setText(textnumber);//전화번호
				tf5.setText(textname);//이름
				tf7.setText(locStr);//서울시
				tf8.setText(dongnum);//몇동

				dongnumber.setVisible(false);
				loc.setVisible(false);
				tf2.setEditable(false);
				tf.setEditable(false);
				tf6.setEditable(false);
				tf5.setEditable(false);
				
				btn_back.setVisible(true);
				btn_back1.setVisible(false);
				
				mycash.setText("내 캐쉬: " + textcash);
				mypage.dispose();
				deliver.setVisible(true);
				
			}
		});
		
		mypage.add(btn_back1);
		//이건 꺼두기
		btn_back1.setVisible(false);
		//////마이페이지에 넣으면 순서때문에 오류나서 여기 넣음
		
		
		//요금표 

		
		Label tmp_reci1 = new Label("기본요금: 1000원 (같은 동)");
		tmp_reci1.setFont(font_15);
		tmp_reci1.setBounds(240, 570, 200, 30);
		tmp_reci1.setBackground(btnColor);
		
		deliver.add(tmp_reci1);
		
		Label tmp_reci4 = new Label("다른 동 거칠때 마다 +1000원");
		tmp_reci4.setFont(font_15);
		tmp_reci4.setBounds(240, 600, 200, 30);
		tmp_reci4.setBackground(btnColor);
		
		deliver.add(tmp_reci4);
		
		Label tmp_reci2 = new Label("크기 추가요금: 1000원");
		tmp_reci2.setFont(font_15);
		tmp_reci2.setBounds(240, 630, 200, 30);
		tmp_reci2.setBackground(btnColor);
		
		deliver.add(tmp_reci2);
		
		Label tmp_reci3 = new Label("무게 추가요금: 1000원");
		tmp_reci3.setFont(font_15);
		tmp_reci3.setBounds(240, 660, 200, 30);
		tmp_reci3.setBackground(btnColor);
		
		deliver.add(tmp_reci3);
		
		
		// 배송 조회 화면
		Label l_dc_head = new Label("배달 상황");
		l_dc_head.setFont(font_50);
		l_dc_head.setBounds(130, 80, 220, 60);
		l_dc_head.setBackground(btnColor);
		
		Label l_dc_number = new Label("송장번호:");
		l_dc_number.setFont(font_20);
		l_dc_number.setBounds(40, 200, 90, 30);
		l_dc_number.setBackground(btnColor);
		
		Label l_dc_accept = new Label("접수중");
		l_dc_accept.setFont(font_20);
		l_dc_accept.setBounds(40, 250, 70, 30);
		l_dc_accept.setBackground(btnColor);
		
		Label l_dc_delivery = new Label("배달중");
		l_dc_delivery.setFont(font_20);
		l_dc_delivery.setBounds(200, 250, 70, 30);
		l_dc_delivery.setBackground(btnColor);
		
		Label l_dc_delivery_end = new Label("배달완료");
		l_dc_delivery_end.setFont(font_20);
		l_dc_delivery_end.setBounds(350, 250, 90, 30);
		l_dc_delivery_end.setBackground(btnColor);
		
		Label l_dc_review = new Label("상품 리뷰");
		l_dc_review.setFont(font_20);
		l_dc_review.setBounds(40, 350, 90, 30);
		l_dc_review.setBackground(btnColor);
		
		Label l_dc_grade = new Label("평점:");
		l_dc_grade.setFont(font_20);
		l_dc_grade.setBounds(340, 350, 45, 30);
		l_dc_grade.setBackground(btnColor);
		
		TextArea dc_ta_ave = new TextArea("",0,0,TextArea.SCROLLBARS_NONE);
		dc_ta_ave.setFont(font_20);
		dc_ta_ave.setBounds(395, 351, 45, 28);
		dc_ta_ave.setEditable(false);

		TextArea dc_ta = new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY); 
		dc_ta.setBounds(40, 400, 400, 210); // 리뷰 내용
		dc_ta.setFont(font_15);
		dc_ta.setEditable(false);
		
		TextField tf_dc_number = new TextField();
		tf_dc_number.setFont(font_18);
		tf_dc_number.setBounds(150, 200, 220, 30);
		
		Button search_btn = new Button("검색");
		search_btn.setBounds(390, 200, 50, 30);
		search_btn.setFont(font_20);
		
		search_btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				File file = new File("D:\\bada\\userInfo\\"+ta1.getText()+"\\songjang");	
				File[] dirName = file.listFiles();
				
				//송장번호 저장경로
				//송장번호 저장경로
				String deliveryNum = "";
				//송장번호 저장변수
				String delNum = "";
				for (int i = 0; i < dirName.length ; i++) {
						deliveryNum += dirName[i].getPath()+",";
						delNum += deliveryNum.substring(deliveryNum.length()-14, deliveryNum.length()-5)+",";
				}//for							
				//배열 저장경로와 송장번호 저장
				String[] arDeliveryNum = deliveryNum.split(",");
				String[] arDelNum = delNum.split(",");
				
				int dcCnt = 0;
				try {
					for (int i = 0; i < arDeliveryNum.length; i++) {
					File file2 = new File(arDeliveryNum[i]);														
					FileInputStream input = new FileInputStream(file2);
					
					System.out.println(arDelNum[i]);
					input.close();
					// 송장번호 입력 후 검색 눌렀을 때 현재 상황만 활성화(if)
					if (tf_dc_number.getText().equals(arDelNum[i])) { // .equals(텍스트에 담겨있는 송장번호)
						// 생성되는 송장번호 인자 불러오기
						dcCnt++;
						}
					}//for문
					if(dcCnt==1) {
						
						JOptionPane.showMessageDialog(deliver_review, "송장번호가 일치합니다.");
						l_dc_delivery_end.setBackground(Color.YELLOW);
						deliver_review.setVisible(true);
					}else {
						System.out.println(dcCnt);
						
						JOptionPane.showMessageDialog(deliver_review, "송장번호가 일치하지 않습니다.");
						l_dc_delivery_end.setBackground(Color.CYAN);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//try&catch문	
			}
		});
		
		// 택배 접수 화면의 결제 버튼
		Button pay_btn = new Button("결제");
		pay_btn.setBounds(280, 700, 150, 50);
		pay_btn.setFont(font_30);
		
		pay_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(tempcash1 > textcash) {
					JOptionPane.showMessageDialog(deliver, (tempcash1 - textcash) + "원 만큼 부족합니다.\n" 
				+ "마이페이지에서 캐시를 충전해주세요");
					
					deliver.dispose();
					mypage.setVisible(true);
					btn_back1.setVisible(true);
					btn_back.setVisible(false);
					
				} else {
				
				paycash = tempcash1;
				JOptionPane.showMessageDialog(deliver, paycash + "원 결제 완료 되었습니다.");
				textcash -= paycash;
				System.out.println("페이캐시:" + paycash);
				System.out.println("충전캐시:" + textcash);
				mycash.setText("내 캐쉬: " + textcash);
				
				Checkin ck = new Checkin();
				
				//결제되었을 때 다시 캐시를 저장
				//결제되었을 때 다시 캐시를 저장
				String fileURL1 = "D:\\bada\\userInfo\\" + ta1.getText() + "/" + ta1.getText() + "cash.txt";
				OutputStream output2;
				
				try {
					output2 = new FileOutputStream(fileURL1, false);
					String addressField5 = textcash +""; 
					output2.write(addressField5.getBytes());
					output2.close();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}//try & catch
				
				try {
					String idname1 = "/" + ta1.getText();
					String idname2 = "/" + ta1.getText() + ".txt";
					
					File file = new File("D:\\bada\\userInfo\\"+ta1.getText()+"\\songjang");
					if(!(file.exists())) {
						file.mkdirs();
					}
					
					OutputStream output = new FileOutputStream(
							"D:\\bada/userInfo/" + ta1.getText() + 
							"\\songjang\\" + ck.Songjang() + ".txt"); 
					
					File file3 = new File("D:\\bada\\userInfo\\"+ta1.getText()+"\\songjang");	
					File[] dirName = file3.listFiles();
					
					//송장번호 저장경로
					String deliveryNum = "";
					//송장번호 저장변수
					String delNum = "";
					for (int i = 0; i < dirName.length ; i++) {
							deliveryNum += dirName[i].getPath()+",";
							delNum += deliveryNum.substring(deliveryNum.length()-14, deliveryNum.length()-5)+",";
					}//for							
					//배열 저장경로와 송장번호 저장
					String[] arDeliveryNum = deliveryNum.split(",");
					String[] arDelNum = delNum.split(",");
					sjNum = arDelNum[0];
					
					String temca = Integer.toString(paycash);
					
					String money = temca; //체크머니 변수를 넣을 자리
					
					byte[] by3 = money.getBytes();
					
					output.write(by3);
					
				} catch (Exception e1) {
					e1.getStackTrace();
				}//try&catch
				
				deliver.dispose();
				System.out.println("결제-배송현황 들어옴");
				tf_dc_number.setText(sjNum);
				deliver_check.setVisible(true);
				
				deliver.dispose();
				deliver_check.setVisible(true);
				
				// 접수중 라벨에 효과
				Animation1 ani1 = new Animation1(l_dc_accept);
				ani1.start();
				// 배송중 라벨에 효과
				Animation2 ani2 = new Animation2(l_dc_delivery);
				ani2.start();
				// 배송완료 라벨에 효과
				Animation3 ani3 = new Animation3(l_dc_delivery_end, deliver_review);
				ani3.start();
				
				}//if
			}
		});
		
		
		Button bc_review_btn = new Button("리뷰하기");
		bc_review_btn.setBounds(40, 640, 160, 50);
		bc_review_btn.setFont(font_30);
		
		bc_review_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				deliver_review.setVisible(true);
				
			}
		});
		
		
		Button bc_back_btn = new Button("홈으로가기");
		bc_back_btn.setBounds(40, 710, 160, 50);
		bc_back_btn.setFont(font_30);
		
		bc_back_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				tf_dc_number.setText("");
				l_dc_delivery_end.setBackground(Color.CYAN);
				deliver_check.dispose();
				deliver_review.dispose();
				main_after_view.setVisible(true);
				
			}
		});
		
		
		Button bc_mypage_btn = new Button("마이페이지");
		bc_mypage_btn.setBounds(280, 640, 160, 50);
		bc_mypage_btn.setFont(font_30);
		
		bc_mypage_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				tf_dc_number.setText("");
				l_dc_delivery_end.setBackground(Color.CYAN);
				btn_back.setVisible(true);
				btn_back1.setVisible(false);
				deliver_check.dispose();
				mypage.setVisible(true);
				ta.setText("");
				
			}
		});
		
		
		Button bc_logout_btn = new Button("로그아웃");
		bc_logout_btn.setBounds(280, 710, 160, 50);
		bc_logout_btn.setFont(font_30);
		
		bc_logout_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				tf_dc_number.setText("");
				l_dc_delivery_end.setBackground(Color.CYAN);
				ta1.setText("");
				ta2.setText("");
				
				tf.setText("");
				tf2.setText("");
				tf5.setText("");
				tf6.setText("");
				tf7.setText("지역: ");
				tf8.setText("몇동: ");
				tf3.setText("원");

				deliver_check.dispose();
				deliver_review.dispose();
				main_before_view.setVisible(true);
				
			}
		});
		
		
		// 배송완료 리뷰 팝업창
		Label dr_head = new Label("별점과 리뷰를 남겨주세요.");
		dr_head.setBounds(20, 50, 300, 30);
		dr_head.setFont(new Font("", Font.BOLD, 20));
		
		Choice dr_star = new Choice(); // 리뷰 별점
		dr_star.add("★");
		dr_star.add("★★");
		dr_star.add("★★★");
		dr_star.add("★★★★");
		dr_star.add("★★★★★");
		dr_star.setBounds(20, 120, 100, 30);
		dr_star.setFont(font_15);
		
		Label l_dr_ta = new Label("제목:");
		l_dr_ta.setBounds(20, 85, 40, 30);
		l_dr_ta.setFont(font_15);
		l_dr_ta.setBackground(Color.CYAN);
		
		TextField dr_ta_head = new TextField(); // 리뷰 제목
		dr_ta_head.setBounds(65, 85, 280, 30);
		dr_ta_head.setFont(font_15);
		
		TextArea dr_ta = new TextArea("상품: \n내용: ",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY); 
		dr_ta.setBounds(20, 155, 340, 190); // 리뷰 내용
		dr_ta.setFont(font_15);
		
		Button dr_cancel = new Button("취소");
		dr_cancel.setBounds(240, 350, 50, 30);
		dr_cancel.setFont(font_15);
		
		dr_cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				deliver_review.dispose();
				
			}
		});
		
		
		Button dr_finish = new Button("완료");
		dr_finish.setBounds(310, 350, 50, 30);
		dr_finish.setFont(font_15);
		
		dr_finish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				deliver_review.dispose();
				
				String head = "/" + dr_ta_head.getText() + ".txt";
				
				String head_text = dr_ta_head.getText();
				String msg = dr_ta.getText();
				String star = dr_star.getSelectedItem();
				String jump = "\n";
				
				int stars = star.length();
				
				// 배송 상황 화면에 텍스처 나오도록 한다.
				dc_ta.append("별점: " + star + "\n");
				dc_ta.append("제목: " + head_text + "\n");
				dc_ta.append( msg + "\n\n");
				
				dr_ta_head.setText("");
				dr_ta.setText("상품: \n내용: ");
				
	            Star star2 = new Star();
	             
	            star2.return_score(stars); // 별점 1점 주기
	            
	            float star3 = star2.return_star(); // 별점 평균
	            
	            String str = Float.toString(star3);
	            
	            dc_ta_ave.setText("");
	            dc_ta_ave.append(str);
	            
			}
		});
		
		dr_ta.addTextListener(new joins.TextAdapter2(dr_ta, dr_finish));
		
		
		
		//만들어진 객체를 frame에 추가
		
		// 배경화면 넣기
		ImageIcon back_gr_m = new ImageIcon("src/bin/imgs/backGround1.jpg");//여기는 사진경로
		
		// 시작 화면
		JLabel back_gr_jl = new JLabel(back_gr_m);
		back_gr_jl.setBounds(0,0,480,800);
		// 로그인 화면
		JLabel back_gr_jl1 = new JLabel(back_gr_m);
		back_gr_jl1.setBounds(0,0,480,800);
		// 회원가입 화면
		JLabel back_gr_jl2 = new JLabel(back_gr_m);
		back_gr_jl2.setBounds(0,0,480,800);
		// 로그인 후 메인 화면
		JLabel back_gr_jl3 = new JLabel(back_gr_m);
		back_gr_jl3.setBounds(0,0,480,800);
		// 마이페이지 화면
		JLabel back_gr_jl4 = new JLabel(back_gr_m);
		back_gr_jl4.setBounds(0,0,480,800);
		// 택배 접수 화면
		JLabel back_gr_jl5 = new JLabel(back_gr_m);
		back_gr_jl5.setBounds(0,0,480,800);
		// 배송 조회 화면
		JLabel back_gr_jl6 = new JLabel(back_gr_m);
		back_gr_jl6.setBounds(0,0,480,800);
		
		// 시작 화면
		main_before_view.add(l_main_head1);
		main_before_view.add(l_main_head2);
		main_before_view.add(b_main_login);
		main_before_view.add(b_main_join);
		main_before_view.add(b_main_deliver);
		main_before_view.add(b_main_deliver_check);
//		main_before_view.add(mi);
		main_before_view.add(back_gr_jl);
		
		// 로그인
		Login.add(l_main_head3);
		Login.add(l_main_head4);
		Login.add(j3);
		Login.add(j2);
		Login.add(j1);
		Login.add(cb);
		Login.add(ta1);
		Login.add(ta2);
		Login.add(btn1);
		Login.add(btn2);
		Login.add(btn3);
		Login.add(back_gr_jl1);
		
		// 회원가입
		join.add(labelTitle);
		join.add(labelId);
		join.add(textId);
		join.add(btnId);
		join.add(labelPw);
		join.add(textPw);
		join.add(labelPw2);
		join.add(textPw2);
		join.add(btnPw);
		join.add(labelName);
		join.add(textName);
		join.add(labelPhone);
		join.add(textPhone);
		join.add(btnPhone);
		join.add(labelAddress);
		join.add(btnAddress);
		join.add(boxAgree);
		join.add(btnAgree);
		join.add(btnJoin);
		join.add(btnQuit);
		join.add(back_gr_jl2);
		
		// 주소 부분
//		join.add(textAddress);
//		join.add(textAddress2);
		
		
		// 로그인 후 메인 화면
		main_after_view.add(l_sub_head1);
		main_after_view.add(l_sub_head2);
		main_after_view.add(b_sub_mypage);
		main_after_view.add(b_sub_logout);
		main_after_view.add(b_sub_deliver);
		main_after_view.add(b_sub_deliver_check);
		main_after_view.add(back_gr_jl3);
		
		
		// 마이페이지
		mypage.add(loc);
		mypage.add(dongnumber);
		mypage.add(tf);
		mypage.add(q1);
		mypage.add(q2);
		mypage.add(tf2);
		mypage.add(btn_locok);
		mypage.add(q5);
		mypage.add(q6);
		mypage.add(btn_phonech);
		mypage.add(q7);
		mypage.add(btn_cashchar);
		mypage.add(q8);
		mypage.add(tf4);
		mypage.add(q9);
		mypage.add(tf5);
		mypage.add(tf6);
		mypage.add(btn_outmem);
		mypage.add(btn_logout);
		mypage.add(btn_back);
		mypage.add(tf3);
		mypage.add(q11);
		mypage.add(back_gr_jl4);
		
		
		// 택배 접수
		deliver.add(l_d_head);
		deliver.add(l_to);
		deliver.add(l_name);
		deliver.add(l_phone);
		deliver.add(l_address);
		deliver.add(l_item);
		deliver.add(l_item_type);
		deliver.add(l_item_size);
		deliver.add(l_item_weight);
		deliver.add(l_money);
		deliver.add(tf_name);
		deliver.add(tf_phone);
		deliver.add(send_address_dong);
		deliver.add(send_address_dongnum);
		deliver.add(btn_map2);
		deliver.add(tf_item);
		deliver.add(tf_money);
		deliver.add(cg_i_s1);
		deliver.add(cg_i_s2);
		deliver.add(cg_i_w1);
		deliver.add(cg_i_w2);
		deliver.add(c1);
		deliver.add(c2);
		deliver.add(back_btn);
		deliver.add(pay_btn);
		deliver.add(money_btn);
		deliver.add(back_gr_jl5);
		
		
		// 택배 조회
		deliver_check.add(l_dc_head);
		deliver_check.add(l_dc_number);
		deliver_check.add(l_dc_accept);
		deliver_check.add(l_dc_delivery);
		deliver_check.add(l_dc_delivery_end);
		deliver_check.add(l_dc_review);
		deliver_check.add(l_dc_grade);
		deliver_check.add(dc_ta_ave);
		deliver_check.add(tf_dc_number);
		deliver_check.add(dc_ta);
		deliver_check.add(search_btn);
		deliver_check.add(bc_review_btn);
		deliver_check.add(bc_back_btn);
		deliver_check.add(bc_mypage_btn);
		deliver_check.add(bc_logout_btn);
		deliver_check.add(back_gr_jl6);
		
		
		// 택배완료 리뷰 팝업창
		deliver_review.add(dr_head);
		deliver_review.add(l_dr_ta);
		deliver_review.add(dr_star);
		deliver_review.add(dr_ta_head);
		deliver_review.add(dr_ta);
		deliver_review.add(dr_cancel);
		deliver_review.add(dr_finish);
		
		
		
		// 어플 종료
		
		// 시작 화면
		main_before_view.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// 로그인 화면
		Login.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// 회원가입 화면
		join.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// 로그인 후 메인 화면
		main_after_view.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// 마이페이지 화면
		mypage.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// 택배 접수 화면
		deliver.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// 배송 조회 화면
		deliver_check.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// 배송완료 리뷰 팝업창
		deliver_review.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				deliver_review.dispose();
			}
		});
		
		//지도화면
		map.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//탈퇴화면
		delecting.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				delecting.dispose();
			}
		});
		
		
		// 어플 초기 온 & 오프 설정
		
		
		// 시작화면
		main_before_view.setVisible(true);
		// 로그인 화면
		Login.setVisible(false);
		// 회원가입 화면
		join.setVisible(false);
		// 로그인 후 메인 화면
		main_after_view.setVisible(false);
		// 마이페이지 화면
		mypage.setVisible(false);
		// 택배 접수 화면
		deliver.setVisible(false);
		// 배송 조회 화면
		deliver_check.setVisible(false);
		// 배송완료 리뷰 팝업창
		deliver_review.setVisible(false);
		//지도화면
		map.setVisible(false);
		//탈퇴화면
		delecting.setVisible(false);

	}//main
}

