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
	
	public static String locStr = "�����";
	//�����
	public static String dongnum = "1��";
	//�̸�
	public static String textname = "ooo";
	//��ȭ��ȣ
	public static String textnumber = "000-000-0000";
	//��
	public static String textgu = "oo��";
	//��
	public static String textdong = "oo��";
	//����� ��
	static String deli_dong = "1��";
	//����ĳ��
	static int textcash = 0;
	//�ӽ� �� ���ϴ� ����
	static int tempcash = 1000;
	static int tempcash1 = 1000;
	//������ ��
	static int paycash = 1000;
	//���������� ���� ����
	//�� ȸ������ ������ ���� ����
	//���̵�
	public static String userinfo = ".";
	//��й�ȣ
	public static String userinfo1 = ".";
	//��ȭ��ȣ
	public static String userinfo2 = ".";
	
	//���ι�ư�� ���� 
	static String radioSize = "";
	static String radiowei = "";
	
	// �����ȣ ã�ư��� ���� (�α��� ���̵� ���� ����)
	static String sname = "";
	
	// ��ư �� �� Background Color.
	static Color btnColor = new Color(255,153,153);
	static Color titleColor = new Color(153, 220, 220);
	static String sjNum;
	
	public static void main(String[] args) {
		
		ArrayList<Character> memo = new ArrayList<>();
		ArrayList<Character> memo2 = new ArrayList<>();
		
		Color gray = Color.gray;
		
		// window
		
		Frame main_before_view = new Frame("BADA"); // ���� ȭ��
		Frame Login = new Frame("BADA"); // �α��� ȭ��(�ӽ�)
		Frame join = new Frame("BADA"); // ȸ������ ȭ��
		Frame main_after_view = new Frame("BADA"); // �α��� �� ���� ȭ��
		Frame mypage = new Frame("BADA"); // ���������� ȭ��
		Frame deliver = new Frame("BADA"); // �ù� ���� ȭ��
		Frame deliver_check = new Frame("BADA"); // ��� ��ȸ ȭ��
		Frame deliver_review = new Frame("BADA"); // ��ۿϷ� ���� �˾�â 
		Frame map = new Frame("BADA"); // ���� ���� ȭ��
		Frame delecting = new Frame("BADA");//ȸ��Ż��ȭ��
		
		//��Ʈ
		Font font = new Font("�ü�ü",Font.ITALIC,20);
		Font font2 = new Font("�ü�ü",Font.ITALIC,15);
		Font font3 = new Font("�ü�ü",Font.ROMAN_BASELINE,12);
		Font font_15 = new Font("", Font.PLAIN, 15);
		Font font_18 = new Font("", Font.PLAIN, 18);
		Font font_20 = new Font("", Font.PLAIN, 20);
		Font font_30 = new Font("", Font.PLAIN, 30);
		Font font_50 = new Font("", Font.PLAIN, 50);
		
		
		// ���� ���̽� ȭ�� �ʱ� ����
		
		// ���� ȭ��
		main_before_view.setBounds(500, 30, 480, 800);
		main_before_view.setLayout(null);
		main_before_view.setResizable(false);
		
		// �α��� ȭ��
		Login.setBounds(500, 30, 480, 800);
		Login.setLayout(null); // �ڵ� ��ġ ����
		Login.setResizable(false); // ������ �������� ������ ������ ���´�.
		
		// ȸ������
		join.setBounds(500, 30, 480, 800);
		join.setLayout(null);
		join.setResizable(false);
		
		// �α��� �� ���� ȭ��
		main_after_view.setBounds(500, 30, 480, 800);
		main_after_view.setLayout(null);
		main_after_view.setResizable(false);
		
		// ����������
		mypage.setBounds(500, 30, 480, 800);
		//�������� ȭ���� ���� ä��� �ڵ���ġ�� ����.
		mypage.setLayout(null);
		//������ �ø��� �� ����
		mypage.setResizable(false);
		
		//Ż��ȭ��
		delecting.setBounds(550, 330, 380, 400);
		delecting.setLayout(null);
		delecting.setResizable(false);
		
		// �ù� ����
		deliver.setBounds(500, 30, 480, 800);
		deliver.setLayout(null);
		deliver.setResizable(false);
		
		// ��� ��ȸ
		deliver_check.setBounds(500, 30, 480, 800);
		deliver_check.setLayout(null);
		deliver_check.setResizable(false);
		
		// ��ۿϷ� ���� �˾�â
		deliver_review.setBounds(550, 330, 380, 400);
		deliver_review.setLayout(null);
		deliver_review.setResizable(false);
		
		
		// ���� ȭ��
		Label l_main_head1 = new Label("�츮����");
		l_main_head1.setFont(font_20);
		l_main_head1.setBounds(195, 100, 90, 50);
		l_main_head1.setBackground(new Color(153, 220, 220));
		
		Label l_main_head2 = new Label("���ùٴ�");
		l_main_head2.setFont(new Font("", Font.BOLD, 70));
		l_main_head2.setBounds(100, 160, 290, 80);
		l_main_head2.setBackground(new Color(153, 220, 220));
		
		Button b_main_login = new Button("�α���");
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
		
		Button b_main_join = new Button("ȸ������");
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
		
		Button b_main_deliver = new Button("�ù� ����");
		b_main_deliver.setBounds(50, 400, 180, 110);
		b_main_deliver.setFont(font_30);
		b_main_deliver.setBackground(btnColor);
		b_main_deliver.addActionListener(new ButtonAdapter1(main_before_view));
		
		Button b_main_deliver_check = new Button("��� ��ȸ");
		b_main_deliver_check.setBounds(255, 400, 180, 110);
		b_main_deliver_check.setFont(font_30);
		b_main_deliver_check.setBackground(btnColor);
		b_main_deliver_check.addActionListener(new ButtonAdapter1(main_before_view));
		
		
		// ����ȭ�� �̹��� �ִϸ��̼�
		
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
		
		
		
		// �α��� ȭ��
		
		Label l_main_head3 = new Label("�츮����");
		l_main_head3.setFont(font_20);
		l_main_head3.setBounds(195, 100, 90, 50);
		l_main_head3.setBackground(new Color(153, 220, 220));	

		Label l_main_head4 = new Label("���ùٴ�");
		l_main_head4.setFont(new Font("", Font.BOLD, 70));
		l_main_head4.setBounds(100, 160, 290, 80);
		l_main_head4.setBackground(new Color(153, 220, 220));
		
		Label j1 = new Label("���̵�");
		Label j2 = new Label("��й�ȣ");
		Label j3 = new Label("�α��� ����");
		
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
		
		// �α���
		Button btn1 = new Button("�α���");
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// "���̵� : value" �� <arrayList> memo�� "���̵� : value"�� ���ƾ���
				// ta1 �ʵ忡 �Էµ� ���̵�� ta2 �ʵ忡 �Էµ� ��й�ȣ�� String ���� real_id�� real_pw�� ����ǰ� �ؾ���

				// String address_field = "��й�ȣ : " + ta2.getText();
				// String number_field = "��й�ȣ : " + ta2.getText();

				String idname = "/" + ta1.getText() + ".txt";

				String id_field = "���̵� : " + ta1.getText();
				String pw_field = "��й�ȣ : " + ta2.getText();
				String jump = "    ";

				try {
					// ���� ��ü ����
		    	File file = new File("C:/bada/userInfo/" + ta1.getText() + "/" + idname); //�п�
					// �Է� ��Ʈ�� ����
		    	if(!file.isFile()){
					JOptionPane.showMessageDialog(Login, "���̵� �������� �ʽ��ϴ�");
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

	               if (memo.equals(memo2)) // ���̵� ��й�ȣ�� �¾ƾ� �α��� ����
	               {
	                  JOptionPane.showMessageDialog(Login, "�α��� ����");
	                  
	                  //�α��� ���� ���� �� ���� ������������
	                  
	                  
	                  
	                  new joins.Join().showInfo(Login,ta1);

	                  //���� ��ǲ ��Ʈ��
	                  
	                  //��Ʈ�� ������ ���� �о����
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
	                  
	        		//ĳ�����̶� ����ȭ�ϱ�
	        		
	                  
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
	        		  
	                  
	                  //������� ����ٿ�������
	                     
	                  Login.dispose();
	                  main_after_view.setVisible(true);
	               } else if (!memo.equals(memo2)){
	                  JOptionPane.showMessageDialog(Login, "��й�ȣ�� Ʋ�Ƚ��ϴ�.");
	                  memo2.clear();
	                  memo.clear();
	               }

					
					file_reader.close();
					
					
				} catch (Exception e1) {
					e1.getStackTrace();
				} // �ҷ�����
			}
		});
		
		
		btn1.setBackground(btnColor);
		btn1.setBounds(100, 460, 290, 60);
		btn1.setFont(font_30);
		// ��ư
		
				
		
		// ȸ������ ȭ��
		
		Button btnId = new Button("�ߺ�Ȯ��");
		Button btnPw = new Button("Ȯ��");
		Button btnPhone = new Button("�����ϱ�");
		Button btnAddress = new Button("��������");//��������� �ٲ�
		Button btnJoin = new Button("�����ϱ�");
		Button btnQuit = new Button("����ϱ�");
		btnId.setBounds(350, 200, 85, 30);
		btnPw.setBounds(350, 330, 85, 30);
		btnPhone.setBounds(350, 460, 85, 30);
		btnAddress.setBounds(350, 565, 85, 30);//��ư ��ġ ����
		btnJoin.setBounds(40, 710, 160, 50);
		btnQuit.setBounds(280, 710, 160, 50);
		
		btnId.setFont(font_20);
		btnPw.setFont(font_20);
		btnPhone.setFont(font_20);
		btnAddress.setFont(font_20);
		btnJoin.setFont(font_30);
		btnQuit.setFont(font_30);
		
		//ȸ������ â ��ư ��Ȱ��ȭ
		btnId.setEnabled(false);
		btnPw.setEnabled(false);
		btnPhone.setEnabled(false);	
		btnJoin.setEnabled(false);
		
		Label labelTitle = new Label("ȸ������");
		Label labelId = new Label("���̵�");
		Label labelPw = new Label("��й�ȣ");
		Label labelPw2 = new Label("��й�ȣ Ȯ��");
		Label labelName = new Label("�̸�");
		Label labelPhone = new Label("�޴���ȭ");
		Label labelAddress = new Label("�ּ�");
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
		
		
		//�ּ�
		
		//���û��ڷ� �����
		//ù°��
		Choice ori_loc = new Choice();
		ori_loc.add("�����");
		ori_loc.add("��õ/���");
		ori_loc.add("����");
		ori_loc.add("����/����/��û");
		ori_loc.add("�뱸/�λ�/���/���");
		ori_loc.add("����/����");
		ori_loc.add("����");
			
			
		ori_loc.setSize(110, 30);
		ori_loc.setLocation(115, 525);
		ori_loc.setFont(font_15);
		
		ori_loc.addItemListener(new MyPageAdapter5(join));
		
		join.add(ori_loc);

		TextField ori_gu = new TextField("��");
		ori_gu.setBounds(235, 525, 105, 30);
		ori_gu.setFont(font_18);

		join.add(ori_gu);		
		
		//��°��
		TextField ori_dong = new TextField("��");
		ori_dong.setBounds(115, 565, 110, 30);
		ori_dong.setFont(font_18);
				
			
		//�� �׸��� ����(choice)
		Choice ori_dongnum = new Choice();
		ori_dongnum.setFont(font_15);
		ori_dongnum.add("1��");
		ori_dongnum.add("2��");
		ori_dongnum.add("3��");
		ori_dongnum.add("4��");
		ori_dongnum.add("5��");
		
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
		
		//�������
		Checkbox boxAgree = new Checkbox("����� �����մϴ�.");
		boxAgree.setBounds(40, 630, 140, 30);
		Button btnAgree = new Button("��� ����");
		btnAgree.setBounds(350, 630, 85, 30);
		
		//ȸ������ â ��ư&���̺� ���� ����
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
		ori_gu.setText("��");
		ori_dong.setText("��");
		
		// ȸ������
		Button btn2 = new Button("ȸ������");
		btn2.addActionListener(new ActionListener() { 
//					
			@Override
			public void actionPerformed(ActionEvent e) {
				
				textId.setText("");
				textPw.setText("");
				textPw2.setText("");
				textName.setText("");
				textPhone.setText("");
				ori_gu.setText("��");
				ori_dong.setText("��");
				Login.dispose();
				join.setVisible(true);
			}
		});
		
		// �ڷΰ���
		Button btn3 = new Button("�ڷΰ���");
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				textId.setText("");
				textPw.setText("");
				textPw2.setText("");
				textName.setText("");
				textPhone.setText("");
				ori_gu.setText("��");
				ori_dong.setText("��");
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
		
		//���� üũ�� '�����ϱ�'��ư Ȱ��ȭ
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
		
		
		//��ư Ȱ��ȭ
		textId.addTextListener(new joins.TextAdapter(textId, btnId));
//		System.out.println(userinfo);
		textPw2.addTextListener(new joins.TextAdapter(textPw2, btnPw));
//		System.out.println(userinfo1);
		textPhone.addTextListener(new joins.TextAdapter(textPhone, btnPhone));
//		System.out.println(userinfo2);
		
		//ȸ������ �� '�����ϱ�' -> �α��� ȭ������ �̵�
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
		
		
		//ȸ������ �� '����ϱ�' -> ����ȭ������ �̵�
		btnQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//����ƽ���ڸ� ���� ������ ���ڵ�� �ٲٱ�
				ta1.setText("");
				ta2.setText("");
				textId.setText("");
				textPw.setText("");
				textPw2.setText("");
				textName.setText("");
				textPhone.setText("");
				ori_gu.setText("��");
				ori_dong.setText("��");
				join.dispose();
				main_before_view.setVisible(true);
				
			}
		});
		
		
		//���̵� �ߺ� Ȯ��		
		new joins.Join(textId).checkId(btnId);
		
		//��й�ȣ ��ġ Ȯ��
		new joins.Join(textPw, textPw2).checkPw(btnPw);
		
		//������ȣ Ȯ��
		new joins.Join(textId, textPw2, textPhone).checkPhone(btnPhone);
		
		//��� ����
		new joins.Join().showDoc(btnAgree);
		
		//ȸ������
		new joins.Join(textId, textPw2, textName, textPhone, ori_gu, ori_loc, ori_dongnum, ori_dong).join(btnJoin);
		
		///����ȭ��
		map.setBounds(500, 30, 480, 800);
		map.setLayout(null);
		
		//oo�� �̶�� ����
		Label map_title = new Label();
		map_title.setBounds(200, 100, 100, 40);
		map_title.setFont(font);
		
		map.add(map_title);
		//��������
		ImageIcon back = new ImageIcon("src/bin/imgs/map_dong.png");
		JLabel jl_back = new JLabel(back);
		jl_back.setBounds(0,150,480,500);
		
		//�ڷΰ��� ��ư
		Button btn_mapback = new Button("ȸ���������� ���ư���");
		btn_mapback.setBounds(255, 700, 210, 50);
		
		btn_mapback.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				map.dispose();
				join.setVisible(true);
				
			}
		});
		
		//�ڷΰ����ư2
		
		Button btn_mapback2 = new Button("��޷� ���ư���");
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
		
		//���������ư
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
		
		
		// �α��� �� ���� ȭ��
		Label l_sub_head1 = new Label("�츮����");
		l_sub_head1.setFont(font_20);
		l_sub_head1.setBounds(195, 100, 90, 50);
		l_sub_head1.setBackground(titleColor);
		
		Label l_sub_head2 = new Label("���ùٴ�");
		l_sub_head2.setFont(new Font("", Font.BOLD, 70));
		l_sub_head2.setBounds(100, 160, 280, 80);
		l_sub_head2.setBackground(titleColor);
		
		Button b_sub_mypage = new Button("����������");
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
		
		
		
		Button b_sub_deliver = new Button("�ù� ����");
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
		
		Button b_sub_deliver_check = new Button("��� ��ȸ");
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
		
		
		// ���������� ȭ��
		
		//��Ʈ Ŭ���� new Font("�̸�",style,size);
		Label q1 = new Label("����������");
		q1.setFont(font_50);
		q1.setBounds(120, 80, 250, 60);
		q1.setBackground(btnColor);
		
		//�ּ��Է�â
		//���ڿ� ���õ� Ŭ����
		//��Ʈ Ŭ���� new Font("�̸�",style,size);
		Label q2 = new Label("�ּ��Է�:");
		q2.setFont(font_20);
		q2.setBounds(50,190,80,25);
		q2.setBackground(btnColor);
		
		//�׸��� ����(choice)
		Choice loc = new Choice();
		loc.add("�����");
		loc.add("��õ/���");
		loc.add("����");
		loc.add("����/����/��û");
		loc.add("�뱸/�λ�/���/���");
		loc.add("����/����");
		loc.add("���ֵ�");
		
		loc.setSize(150,0);
		loc.setLocation(318,190);
		
		//���û��� �̺�Ʈ������ ���
		loc.addItemListener(new MyPageAdapter1(mypage));

		loc.setVisible(false);
		
		
		//������ ���� �ٷ� �ֱ�
		TextField tf = new TextField();
		tf.setBounds(135,220,70,25);
		tf.setFont(font_20);
		
		
		//���������� ����ƽ���� ���� �� ��  ���� �־����
		//��
		TextField tf2 = new TextField();
		tf2.setBounds(205,220,70,25);
		tf2.setFont(font_20);
		
		
		//�� �׸��� ����(choice)
		Choice dongnumber = new Choice();
		dongnumber.add("1��");
		dongnumber.add("2��");
		dongnumber.add("3��");
		dongnumber.add("4��");
		dongnumber.add("5��");
		
		dongnumber.setSize(50,0);
		dongnumber.setLocation(345,220);
		
		dongnumber.addItemListener(new MyPageAdapter2(mypage));
		dongnumber.setVisible(false);	
		
		
		//���̽��� �� ���ڸ� ǥ���ϴ� ���� ����� ��
		TextField tf7 = new TextField();
		tf7.setBounds(135,190,182,25);
		tf7.setFont(font_15);
		tf7.setEditable(false);
		
		mypage.add(tf7);
		
		//���̽��� �� ���ڸ� ǥ���ϴ� ���� ���ѹ�
		TextField tf8 = new TextField();
		tf8.setBounds(275,220,70,25);
		tf8.setFont(font_15);
		tf8.setEditable(false);
		
		mypage.add(tf8);
		
		
		//�̸�
		Label q5 = new Label("�̸�:"); // + ��������(textname)
		q5.setFont(font_20);
		q5.setBounds(50,250,50,25);
		q5.setBackground(btnColor);
		
		//�̸� �� �ʵ�
		TextField tf5 = new TextField();
		tf5.setBounds(135,250,115,25);
		tf5.setFont(font_20);
		
		
		//��ȭ��ȣ
		
		
		
		Label q6 = new Label("��ȭ��ȣ:"); 
		q6.setFont(font_20);
		q6.setBounds(50,280,85,25);
		q6.setBackground(btnColor);
		
		//��ȭ��ȣ �� �ʵ�
		TextField tf6 = new TextField(textnumber);
		tf6.setText(textnumber);
		tf6.setBounds(135,280,150,25);
		tf6.setFont(font_20);
		
		//TextField�� ���� ���� �ѱ�� "Ȯ��"��ư
		Button btn_locok = new Button("����");
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
		
		//��ȭ��ȣ �����ư
		Button btn_phonech = new Button("����");
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
					String nameField = "�̸�\n" + textname + "\n";
					String phoneField = "�޴���ȭ\n" + textnumber + "\n";
					String addressField1 = "�ּ�\n" + locStr + "\n";
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
		
		
		//ĳ�� �����ϱ�
		Label q7 = new Label("ĳ�������ϱ�");
		q7.setFont(font_20);
		q7.setBounds(50,340,120,25);
		q7.setBackground(btnColor);
		
		//������ ��ŭ �Է�
		TextField tf4 = new TextField( textcash + "��");
		tf4.setBounds(240,340,150,25);
		tf4.setFont(font_20);
		
		//���� ���� �ݾ�
		TextField tf3 = new TextField();
		tf3.setBounds(240,370,150,25);
		tf3.setFont(font_20);
		tf3.setEditable(false);
		
		// �α��� �� ���� ȭ���� �α׾ƿ� ��ư
		Button b_sub_logout = new Button("�α׾ƿ�");
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
				tf7.setText("����: ");
				tf8.setText("�: ");
				tf3.setText("��");
				
				ta1.setText("");
				ta2.setText("");
				textId.setText("");
				textPw.setText("");
				textPw2.setText("");
				textName.setText("");
				textPhone.setText("");
				ori_gu.setText("��");
				ori_dong.setText("��");
				main_after_view.dispose();
				main_before_view.setVisible(true);
				
			}
		});

		//ĳ�� ���� ��ư
		Button btn_cashchar = new Button("����");
		btn_cashchar.setBounds(395,340,45,30);
		
		btn_cashchar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try { 
					
					
					
					int temck = 0;
					temck += Integer.parseInt(tf4.getText());
					
					while(true) {
						String phoneMsg = "ī��������ȣ�� �Է��� �ּ���.";
						int[] num = new int[6];
						String number = "";
						for (int i = 0; i < num.length; i++) {
							num[i] = new Random().nextInt(9);
						}//for
						for (int j = 0; j < num.length; j++) {
							number += ""+num[j];
						}//for
						String inputNum = JOptionPane.showInputDialog("������ȣ : "+number + "\r\n"+ phoneMsg);
						if(inputNum.equals(number)) {
							JOptionPane.showMessageDialog(mypage, "������ �Ϸ�Ǿ����ϴ�", "ī���ȣ", JOptionPane.PLAIN_MESSAGE);
							
							textcash += Integer.parseInt(tf4.getText());
							System.out.println(textcash);
							tf4.setText("0��");
							tf3.setText(textcash + "��");	
							
							//ĳ�ô� ĳ�� �̺�Ʈ�� ���� �� ���� �����س���
							String fileURL1 = "D:\\bada\\userInfo\\" + ta1.getText() + "/" + ta1.getText() + "cash.txt";
							OutputStream output2 = new FileOutputStream(fileURL1, false);
							String addressField5 = textcash +""; 
							output2.write(addressField5.getBytes());
							output2.close();
							
							break;
						} else {
							JOptionPane.showMessageDialog(mypage, "��ġ���� �ʽ��ϴ�.\r\n�ٽ� �õ��� �ּ���.", "ī���ȣ", JOptionPane.ERROR_MESSAGE);
						}//if	
					}//while
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(mypage, "��ҵǾ����ϴ� \n" + "�����ݾ��� ���ڸ� �Է¹ٶ��ϴ�.");
				};//try & catch
			}
		});
		
		
		//���� ������ ĳ��
		Label q8 = new Label("���� ������ ĳ��");
		q8.setFont(font_20);
		q8.setBounds(50,370,160,25);
		q8.setBackground(btnColor);
		
		
		//������ ĳ�� ǥ�� â�� ���� ����
				
				
		////�����ݾ����� �������� �ϴ� ���� 
		//Label q12 = new Label("�����ݾ�");
		//q12.setFont(font_15);
		//q12.setBounds(385,430,100,30);
		//mypage.add(q12);
		
		
		//������������
		Label q9 = new Label("��������");
		q9.setFont(font_20);
		q9.setBounds(50,450,80,25);
		q9.setBackground(btnColor);
		
		
		//�����ȣ����
		Label q11 = new Label("������¥ - �����ȣ - �����ݾ�");
		q11.setFont(font_15);
		q11.setBounds(50,480,210,25);
		q11.setBackground(btnColor);
		
		
		//��������

		
		//��������
		//���������� �� â
		TextArea ta = new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);
		ta.setBounds(50,520,385,180);
		ta.setEditable(false);
		ta.setText("");
		
		mypage.add(ta);
		
		
		//�������� ��ư
		Button btn_paylist = new Button("���������ҷ�����");
		btn_paylist.setBounds(330,480,115,30);
		
		btn_paylist.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
				
				try {		
					File file = new File("D:\\bada\\userInfo\\"+ta1.getText()+"\\songjang");	
					File[] dirName = file.listFiles();
											
					//�����ȣ ������
					String deliveryNum = "";
					//�����ȣ ���庯��
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
					
					//�迭 �����ο� �����ȣ ����
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
						ta.append(date_time+"\t"+arDelNum[i]+"\t"+payMoney+"�� ����\r\n");
						
					input.close();
					}// for					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(mypage, "���������� �����ϴ�.", null, JOptionPane.ERROR_MESSAGE);
				}//try&catch
			}
		});
		
		
		mypage.add(btn_paylist);
		
		//���ΰ�ħ��ư
		Button btn_renew = new Button("�����ҷ�����/���ΰ�ħ");
		btn_renew.setBounds(50,150,150,30);
		
		btn_renew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				tf.setText(textgu);
				tf2.setText(textdong);
				tf5.setText(textname);
				tf6.setText(textnumber);
				tf7.setText("����: " + locStr);
				tf8.setText("�: " + dongnum);
				tf3.setText(textcash + "��");
//				ta_userinfo.setText("�� ĭ�� �α��� �� �ҷ��� ����� ����� �����Դϴ�\n"+ "\n" + userinfo + "\n"+ "\n"+ "�о�ð� ��������� ������ ���� �� �������ּ��� \n " + "\n"+  "�� ĭ�� �α׾ƿ� �� ���ŵǸ� ���ΰ�ħ�� �������°� ��������Դϴ� \n"+ "\n" + "��������� �����ø� �� �׸��� ���� ��ư�� ���� �� \n" + "\n" + "�����ư�� �����ּ��� \n" +"\n");
				
			}
		});
		
		mypage.add(btn_renew);
		
		
		//Ż���ư
		Button btn_outmem = new Button("ȸ��Ż��");
		btn_outmem.setBounds(345,710,90,50);
		btn_outmem.setFont(font_20);
		
		btn_outmem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				delecting.setVisible(true);

			}
		});
		
		
		// �α׾ƿ� ��ư
		Button btn_logout = new Button("�α׾ƿ�");
		btn_logout.setBounds(140,710,90,50);
		btn_logout.setFont(font_20);
		
		btn_logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//������ �α��� â���� ���ư���
				ta.setText("");
				ta1.setText("");
				ta2.setText("");
				
				
				
				dongnumber.setVisible(false);
				loc.setVisible(false);
				tf.setText("");
				tf2.setText("");
				tf5.setText("");
				tf6.setText("");
				tf7.setText("����: ");
				tf8.setText("�: ");
				tf3.setText("��");


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
//				ori_gu.setText("��");
//				ori_dong.setText("��");
				mypage.dispose();
				main_before_view.setVisible(true);
				
			}
		});
		
		
		// �ڷΰ��� ��ư
		Button btn_back = new Button("Ȩ����");
		btn_back.setBounds(50, 710, 90, 50);
		btn_back.setFont(font_20);
		
		btn_back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btn_back.setVisible(true);
				ta.setText("");
				
				dongnumber.setVisible(false);
				loc.setVisible(false);
				tf2.setText(textdong);//��
				tf.setText(textgu); //��
				tf6.setText(textnumber);//��ȭ��ȣ
				tf5.setText(textname);//�̸�
				tf7.setText(locStr);//�����
				tf8.setText(dongnum);//�

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
		// ������ �α��� �� ����â���� ���ư���
		///���������� �ڷΰ���
		// �ڷΰ��� ��ư
		
		//Ż��ȭ��
		Label deleok = new Label("Ż�� �Ͻðڽ��ϱ�?");
		deleok.setFont(font_15);
		deleok.setBounds(120, 50, 220, 60);
		
		// Ȯ�ι�ư
		Button delgo = new Button("��");
		delgo.setBounds(120, 250, 60, 30);
		
		delgo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//ȸ�����������ϱ�

				//////��������
				
				dongnumber.setVisible(false);
				loc.setVisible(false);
				tf.setText("");
				tf2.setText("");
				tf5.setText("");
				tf6.setText("");
				tf7.setText("����: ");
				tf8.setText("�: ");
				tf3.setText("��");

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
		                File[] folder_list = folderD.listFiles(); //���ϸ���Ʈ ������
						
				for (int i = 0; i < folder_list.length; i++) {
				    if(folder_list[i].isFile()) {
					folder_list[i].delete();
					System.out.println("������ �����Ǿ����ϴ�.");
				    } else {
					deleteFolder(folder_list[i].getPath()); //����Լ�ȣ��
					System.out.println("������ �����Ǿ����ϴ�.");
				    }//inner if
				    folder_list[i].delete();
				}//for
				 folderD.delete(); //���� ����
				}//outter if
			    } catch (Exception e6) {
				e6.getStackTrace();
			    }//try&catch
				
				//////�����ϴ� �� ��
				JOptionPane.showMessageDialog(delecting, "ȸ�������� �����Ǿ����ϴ�.");
				
				ta.setText("");
				ta1.setText("");
				ta2.setText("");
				
				delecting.dispose();
				mypage.dispose();
				main_before_view.setVisible(true);
			}
		});
		
		// ��ҹ�ư
		Button delcan = new Button("�ƴϿ�");
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

		
		
		// �ù����� ȭ��
		Label l_d_head = new Label("�ù� ����");
		l_d_head.setFont(font_50);
		l_d_head.setBounds(130, 80, 220, 60);
		l_d_head.setBackground(btnColor);
		
		Label l_to = new Label("�����ô� ��");
		l_to.setFont(font_30);
		l_to.setBounds(40, 160, 170, 40);
		l_to.setBackground(btnColor);

		Label l_name = new Label("�̸�:");
		l_name.setFont(font_20);
		l_name.setBounds(40, 210, 50, 30);
		l_name.setBackground(btnColor);
		
		Label l_phone = new Label("��ȭ��ȣ:");
		l_phone.setFont(font_20);
		l_phone.setBounds(40, 250, 90, 30);
		l_phone.setBackground(btnColor);
		
		Label l_address = new Label("�ּ�:");
		l_address.setFont(font_20);
		l_address.setBounds(40, 290, 50, 30);
		l_address.setBackground(btnColor);
		
		//�ּ�
		//���û��ڷ� �����
		TextField send_address_dong = new TextField();
		send_address_dong.setBounds(170, 290, 100, 30);
		send_address_dong.setFont(font_15);
		send_address_dong.setEditable(false);
			
		//�� �׸��� ����(choice)
		Choice send_address_dongnum = new Choice();
		send_address_dongnum.setFont(font_15);
		send_address_dongnum.add("1��");
		send_address_dongnum.add("2��");
		send_address_dongnum.add("3��");
		send_address_dongnum.add("4��");
		send_address_dongnum.add("5��");
		
		send_address_dongnum.setSize(50,0);
		send_address_dongnum.setLocation(280,290);
		send_address_dongnum.addItemListener(new MyPageAdapter3(deliver));
		
		//������ �������� �ֱ�
		Button btn_map2 = new Button("��������");//�˻��ϱ⸦ ��������� ����
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
				//��ư�� �ٲٱ�
				//�ڷΰ��� ��ư
				
			}
		});

		
		Label l_item = new Label("��ǰ:");
		l_item.setFont(font_20);
		l_item.setBounds(40, 330, 50, 30);
		l_item.setBackground(btnColor);
		
		Label l_item_type = new Label("��ǰ ����:");
		l_item_type.setFont(font_20);
		l_item_type.setBounds(40, 370, 95, 30);
		l_item_type.setBackground(btnColor);
		
		Label l_item_size = new Label("ũ��:");
		l_item_size.setFont(font_20);
		l_item_size.setBounds(40, 410, 50, 30);
		l_item_size.setBackground(btnColor);
		
		Label l_item_weight = new Label("����:");
		l_item_weight.setFont(font_20);
		l_item_weight.setBounds(40, 450, 50, 30);
		l_item_weight.setBackground(btnColor);
		
		Label l_money = new Label("����ݾ�:");
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
		Checkbox cg_i_s1 = new Checkbox("80cm ����",cg_item_size,true);
		Checkbox cg_i_s2 = new Checkbox("80cm ~ 100cm (+1000��)",cg_item_size,false);
		cg_i_s1.setBounds(130, 410, 100, 30);
		cg_i_s2.setBounds(240, 410, 200, 30);
		cg_i_s1.setBackground(Color.CYAN);
		cg_i_s2.setBackground(Color.CYAN);
		cg_i_s1.setFont(font_15);
		cg_i_s2.setFont(font_15);
		
		
		// ũ�� ������ ����
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
		        
				JOptionPane.showMessageDialog(deliver, "1000���� �߰��Ǿ����ϴ�");
				
			}
		});
		
		
		CheckboxGroup cg_item_weight = new CheckboxGroup();
		Checkbox cg_i_w1 = new Checkbox("5kg ����",cg_item_weight,true);
		Checkbox cg_i_w2 = new Checkbox("10kg ���� (+1000��)",cg_item_weight,false);
		cg_i_w1.setBounds(130, 450, 90, 30);
		cg_i_w2.setBounds(240, 450, 170, 30);
		cg_i_w1.setBackground(Color.CYAN);
		cg_i_w2.setBackground(Color.CYAN);
		cg_i_w1.setFont(font_15);
		cg_i_w2.setFont(font_15);
		
		
		// ���� ������ ����
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
		        
				JOptionPane.showMessageDialog(deliver, "1000���� �߰��Ǿ����ϴ�");
				
			}
		});
		
		
		Checkbox c1 = new Checkbox("����ǰ");
		Checkbox c2 = new Checkbox("������ ���� ��ǰ");
		c1.setBounds(100, 490, 80, 30);
		c2.setBounds(210, 490, 150, 30);
		c1.setBackground(Color.CYAN);
		c2.setBackground(Color.CYAN);
		c1.setFont(font_15);
		c2.setFont(font_15);
		
		
		Button back_btn = new Button("�ڷΰ���");
		back_btn.setBounds(40, 710, 160, 50);
		back_btn.setFont(font_30);
		back_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				deliver.dispose();
				main_after_view.setVisible(true);
				
			}
		});
		
		
		// ���� ������ ĳ��
		
		
		TextField mycash = new TextField();
		mycash.setText("�� ĳ��: " + textcash);
		mycash.setFont(font_15);
		mycash.setBounds(40, 570, 180, 30);
		mycash.setBackground(btnColor);
		mycash.setEditable(false);
		
		deliver.add(mycash);
		
		
		Button money_btn = new Button("Ȯ��");
		money_btn.setBounds(390, 530, 50, 30);
		money_btn.setFont(font_15);
		
		money_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//�� �ȿ����� ���� �ӽ� ���ڸ� ����ƽ���� �����
				
				send_address_dong.setText(textdong);

				if (dongnum.equals("1��")) {
					switch (deli_dong) {
					case "1��":
						break;
					case "2��": case "3��": case "4��": case "5��":
						tempcash += 1000;
						break; } }
				else if (dongnum.equals("2��")) {
					switch (deli_dong) {
					case "2��":
						break;
					case "1��": case "3��": 
						tempcash += 1000;
						break;
					case "4��": case "5��":
						tempcash += 2000;
						break;} }
				else if (dongnum.equals("3��")) {
					switch (deli_dong) {
					case "3��":
						break;
					case "1��": case "2��": case "4��":
						tempcash += 1000;
						break;
					case "5��":
						tempcash += 2000;
						break;} }
				else if (dongnum.equals("4��")) {
					switch (deli_dong) {
					case "4��":
						break;
					case "1��": case "3��": case "5��":
						tempcash += 1000;
						break;
					case "2��":
						tempcash += 2000;
						break;} }
				else if (dongnum.equals("5��")) {
					switch (deli_dong) {
					case "5��":
						break;
					case "1��": case "4��":
						tempcash += 1000;
						break;
					case "2��": case "3��":
						tempcash += 2000;
						break;} }
				

				if (radioSize.equals("80cm ~ 100cm (+1000��)")) {
					tempcash += 1000;
				} 
				

				if (radiowei.equals("10kg ���� (+1000��)")) {
					tempcash += 1000;
				} 
				

				JOptionPane.showMessageDialog(deliver, tempcash + "�� �Դϴ�.");
				
				tempcash1 = tempcash;
				
				tempcash = 1000;
				
				tf_money.setText(tempcash1 + "��");
				mycash.setText("�� ĳ��: " + textcash);
				
			}
		});
		
		
		// ���������� ȭ���� �ڷΰ��� ��ư
		//�ڷΰ����ư2 �̰� �ù��������� ������������ �Ѿ���� �� �ٽ� �ù������� �ٽ����� ��ư
		Button btn_back1 = new Button("�ڷΰ���");
		btn_back1.setBounds(20, 750, 90, 30);
		
		btn_back1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dongnumber.setVisible(false);
				loc.setVisible(false);
				tf2.setText(textdong);//��
				tf.setText(textgu); //��
				tf6.setText(textnumber);//��ȭ��ȣ
				tf5.setText(textname);//�̸�
				tf7.setText(locStr);//�����
				tf8.setText(dongnum);//�

				dongnumber.setVisible(false);
				loc.setVisible(false);
				tf2.setEditable(false);
				tf.setEditable(false);
				tf6.setEditable(false);
				tf5.setEditable(false);
				
				btn_back.setVisible(true);
				btn_back1.setVisible(false);
				
				mycash.setText("�� ĳ��: " + textcash);
				mypage.dispose();
				deliver.setVisible(true);
				
			}
		});
		
		mypage.add(btn_back1);
		//�̰� ���α�
		btn_back1.setVisible(false);
		//////������������ ������ ���������� �������� ���� ����
		
		
		//���ǥ 

		
		Label tmp_reci1 = new Label("�⺻���: 1000�� (���� ��)");
		tmp_reci1.setFont(font_15);
		tmp_reci1.setBounds(240, 570, 200, 30);
		tmp_reci1.setBackground(btnColor);
		
		deliver.add(tmp_reci1);
		
		Label tmp_reci4 = new Label("�ٸ� �� ��ĥ�� ���� +1000��");
		tmp_reci4.setFont(font_15);
		tmp_reci4.setBounds(240, 600, 200, 30);
		tmp_reci4.setBackground(btnColor);
		
		deliver.add(tmp_reci4);
		
		Label tmp_reci2 = new Label("ũ�� �߰����: 1000��");
		tmp_reci2.setFont(font_15);
		tmp_reci2.setBounds(240, 630, 200, 30);
		tmp_reci2.setBackground(btnColor);
		
		deliver.add(tmp_reci2);
		
		Label tmp_reci3 = new Label("���� �߰����: 1000��");
		tmp_reci3.setFont(font_15);
		tmp_reci3.setBounds(240, 660, 200, 30);
		tmp_reci3.setBackground(btnColor);
		
		deliver.add(tmp_reci3);
		
		
		// ��� ��ȸ ȭ��
		Label l_dc_head = new Label("��� ��Ȳ");
		l_dc_head.setFont(font_50);
		l_dc_head.setBounds(130, 80, 220, 60);
		l_dc_head.setBackground(btnColor);
		
		Label l_dc_number = new Label("�����ȣ:");
		l_dc_number.setFont(font_20);
		l_dc_number.setBounds(40, 200, 90, 30);
		l_dc_number.setBackground(btnColor);
		
		Label l_dc_accept = new Label("������");
		l_dc_accept.setFont(font_20);
		l_dc_accept.setBounds(40, 250, 70, 30);
		l_dc_accept.setBackground(btnColor);
		
		Label l_dc_delivery = new Label("�����");
		l_dc_delivery.setFont(font_20);
		l_dc_delivery.setBounds(200, 250, 70, 30);
		l_dc_delivery.setBackground(btnColor);
		
		Label l_dc_delivery_end = new Label("��޿Ϸ�");
		l_dc_delivery_end.setFont(font_20);
		l_dc_delivery_end.setBounds(350, 250, 90, 30);
		l_dc_delivery_end.setBackground(btnColor);
		
		Label l_dc_review = new Label("��ǰ ����");
		l_dc_review.setFont(font_20);
		l_dc_review.setBounds(40, 350, 90, 30);
		l_dc_review.setBackground(btnColor);
		
		Label l_dc_grade = new Label("����:");
		l_dc_grade.setFont(font_20);
		l_dc_grade.setBounds(340, 350, 45, 30);
		l_dc_grade.setBackground(btnColor);
		
		TextArea dc_ta_ave = new TextArea("",0,0,TextArea.SCROLLBARS_NONE);
		dc_ta_ave.setFont(font_20);
		dc_ta_ave.setBounds(395, 351, 45, 28);
		dc_ta_ave.setEditable(false);

		TextArea dc_ta = new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY); 
		dc_ta.setBounds(40, 400, 400, 210); // ���� ����
		dc_ta.setFont(font_15);
		dc_ta.setEditable(false);
		
		TextField tf_dc_number = new TextField();
		tf_dc_number.setFont(font_18);
		tf_dc_number.setBounds(150, 200, 220, 30);
		
		Button search_btn = new Button("�˻�");
		search_btn.setBounds(390, 200, 50, 30);
		search_btn.setFont(font_20);
		
		search_btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				File file = new File("D:\\bada\\userInfo\\"+ta1.getText()+"\\songjang");	
				File[] dirName = file.listFiles();
				
				//�����ȣ ������
				//�����ȣ ������
				String deliveryNum = "";
				//�����ȣ ���庯��
				String delNum = "";
				for (int i = 0; i < dirName.length ; i++) {
						deliveryNum += dirName[i].getPath()+",";
						delNum += deliveryNum.substring(deliveryNum.length()-14, deliveryNum.length()-5)+",";
				}//for							
				//�迭 �����ο� �����ȣ ����
				String[] arDeliveryNum = deliveryNum.split(",");
				String[] arDelNum = delNum.split(",");
				
				int dcCnt = 0;
				try {
					for (int i = 0; i < arDeliveryNum.length; i++) {
					File file2 = new File(arDeliveryNum[i]);														
					FileInputStream input = new FileInputStream(file2);
					
					System.out.println(arDelNum[i]);
					input.close();
					// �����ȣ �Է� �� �˻� ������ �� ���� ��Ȳ�� Ȱ��ȭ(if)
					if (tf_dc_number.getText().equals(arDelNum[i])) { // .equals(�ؽ�Ʈ�� ����ִ� �����ȣ)
						// �����Ǵ� �����ȣ ���� �ҷ�����
						dcCnt++;
						}
					}//for��
					if(dcCnt==1) {
						
						JOptionPane.showMessageDialog(deliver_review, "�����ȣ�� ��ġ�մϴ�.");
						l_dc_delivery_end.setBackground(Color.YELLOW);
						deliver_review.setVisible(true);
					}else {
						System.out.println(dcCnt);
						
						JOptionPane.showMessageDialog(deliver_review, "�����ȣ�� ��ġ���� �ʽ��ϴ�.");
						l_dc_delivery_end.setBackground(Color.CYAN);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//try&catch��	
			}
		});
		
		// �ù� ���� ȭ���� ���� ��ư
		Button pay_btn = new Button("����");
		pay_btn.setBounds(280, 700, 150, 50);
		pay_btn.setFont(font_30);
		
		pay_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(tempcash1 > textcash) {
					JOptionPane.showMessageDialog(deliver, (tempcash1 - textcash) + "�� ��ŭ �����մϴ�.\n" 
				+ "�������������� ĳ�ø� �������ּ���");
					
					deliver.dispose();
					mypage.setVisible(true);
					btn_back1.setVisible(true);
					btn_back.setVisible(false);
					
				} else {
				
				paycash = tempcash1;
				JOptionPane.showMessageDialog(deliver, paycash + "�� ���� �Ϸ� �Ǿ����ϴ�.");
				textcash -= paycash;
				System.out.println("����ĳ��:" + paycash);
				System.out.println("����ĳ��:" + textcash);
				mycash.setText("�� ĳ��: " + textcash);
				
				Checkin ck = new Checkin();
				
				//�����Ǿ��� �� �ٽ� ĳ�ø� ����
				//�����Ǿ��� �� �ٽ� ĳ�ø� ����
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
					
					//�����ȣ ������
					String deliveryNum = "";
					//�����ȣ ���庯��
					String delNum = "";
					for (int i = 0; i < dirName.length ; i++) {
							deliveryNum += dirName[i].getPath()+",";
							delNum += deliveryNum.substring(deliveryNum.length()-14, deliveryNum.length()-5)+",";
					}//for							
					//�迭 �����ο� �����ȣ ����
					String[] arDeliveryNum = deliveryNum.split(",");
					String[] arDelNum = delNum.split(",");
					sjNum = arDelNum[0];
					
					String temca = Integer.toString(paycash);
					
					String money = temca; //üũ�Ӵ� ������ ���� �ڸ�
					
					byte[] by3 = money.getBytes();
					
					output.write(by3);
					
				} catch (Exception e1) {
					e1.getStackTrace();
				}//try&catch
				
				deliver.dispose();
				System.out.println("����-�����Ȳ ����");
				tf_dc_number.setText(sjNum);
				deliver_check.setVisible(true);
				
				deliver.dispose();
				deliver_check.setVisible(true);
				
				// ������ �󺧿� ȿ��
				Animation1 ani1 = new Animation1(l_dc_accept);
				ani1.start();
				// ����� �󺧿� ȿ��
				Animation2 ani2 = new Animation2(l_dc_delivery);
				ani2.start();
				// ��ۿϷ� �󺧿� ȿ��
				Animation3 ani3 = new Animation3(l_dc_delivery_end, deliver_review);
				ani3.start();
				
				}//if
			}
		});
		
		
		Button bc_review_btn = new Button("�����ϱ�");
		bc_review_btn.setBounds(40, 640, 160, 50);
		bc_review_btn.setFont(font_30);
		
		bc_review_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				deliver_review.setVisible(true);
				
			}
		});
		
		
		Button bc_back_btn = new Button("Ȩ���ΰ���");
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
		
		
		Button bc_mypage_btn = new Button("����������");
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
		
		
		Button bc_logout_btn = new Button("�α׾ƿ�");
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
				tf7.setText("����: ");
				tf8.setText("�: ");
				tf3.setText("��");

				deliver_check.dispose();
				deliver_review.dispose();
				main_before_view.setVisible(true);
				
			}
		});
		
		
		// ��ۿϷ� ���� �˾�â
		Label dr_head = new Label("������ ���並 �����ּ���.");
		dr_head.setBounds(20, 50, 300, 30);
		dr_head.setFont(new Font("", Font.BOLD, 20));
		
		Choice dr_star = new Choice(); // ���� ����
		dr_star.add("��");
		dr_star.add("�ڡ�");
		dr_star.add("�ڡڡ�");
		dr_star.add("�ڡڡڡ�");
		dr_star.add("�ڡڡڡڡ�");
		dr_star.setBounds(20, 120, 100, 30);
		dr_star.setFont(font_15);
		
		Label l_dr_ta = new Label("����:");
		l_dr_ta.setBounds(20, 85, 40, 30);
		l_dr_ta.setFont(font_15);
		l_dr_ta.setBackground(Color.CYAN);
		
		TextField dr_ta_head = new TextField(); // ���� ����
		dr_ta_head.setBounds(65, 85, 280, 30);
		dr_ta_head.setFont(font_15);
		
		TextArea dr_ta = new TextArea("��ǰ: \n����: ",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY); 
		dr_ta.setBounds(20, 155, 340, 190); // ���� ����
		dr_ta.setFont(font_15);
		
		Button dr_cancel = new Button("���");
		dr_cancel.setBounds(240, 350, 50, 30);
		dr_cancel.setFont(font_15);
		
		dr_cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				deliver_review.dispose();
				
			}
		});
		
		
		Button dr_finish = new Button("�Ϸ�");
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
				
				// ��� ��Ȳ ȭ�鿡 �ؽ�ó �������� �Ѵ�.
				dc_ta.append("����: " + star + "\n");
				dc_ta.append("����: " + head_text + "\n");
				dc_ta.append( msg + "\n\n");
				
				dr_ta_head.setText("");
				dr_ta.setText("��ǰ: \n����: ");
				
	            Star star2 = new Star();
	             
	            star2.return_score(stars); // ���� 1�� �ֱ�
	            
	            float star3 = star2.return_star(); // ���� ���
	            
	            String str = Float.toString(star3);
	            
	            dc_ta_ave.setText("");
	            dc_ta_ave.append(str);
	            
			}
		});
		
		dr_ta.addTextListener(new joins.TextAdapter2(dr_ta, dr_finish));
		
		
		
		//������� ��ü�� frame�� �߰�
		
		// ���ȭ�� �ֱ�
		ImageIcon back_gr_m = new ImageIcon("src/bin/imgs/backGround1.jpg");//����� �������
		
		// ���� ȭ��
		JLabel back_gr_jl = new JLabel(back_gr_m);
		back_gr_jl.setBounds(0,0,480,800);
		// �α��� ȭ��
		JLabel back_gr_jl1 = new JLabel(back_gr_m);
		back_gr_jl1.setBounds(0,0,480,800);
		// ȸ������ ȭ��
		JLabel back_gr_jl2 = new JLabel(back_gr_m);
		back_gr_jl2.setBounds(0,0,480,800);
		// �α��� �� ���� ȭ��
		JLabel back_gr_jl3 = new JLabel(back_gr_m);
		back_gr_jl3.setBounds(0,0,480,800);
		// ���������� ȭ��
		JLabel back_gr_jl4 = new JLabel(back_gr_m);
		back_gr_jl4.setBounds(0,0,480,800);
		// �ù� ���� ȭ��
		JLabel back_gr_jl5 = new JLabel(back_gr_m);
		back_gr_jl5.setBounds(0,0,480,800);
		// ��� ��ȸ ȭ��
		JLabel back_gr_jl6 = new JLabel(back_gr_m);
		back_gr_jl6.setBounds(0,0,480,800);
		
		// ���� ȭ��
		main_before_view.add(l_main_head1);
		main_before_view.add(l_main_head2);
		main_before_view.add(b_main_login);
		main_before_view.add(b_main_join);
		main_before_view.add(b_main_deliver);
		main_before_view.add(b_main_deliver_check);
//		main_before_view.add(mi);
		main_before_view.add(back_gr_jl);
		
		// �α���
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
		
		// ȸ������
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
		
		// �ּ� �κ�
//		join.add(textAddress);
//		join.add(textAddress2);
		
		
		// �α��� �� ���� ȭ��
		main_after_view.add(l_sub_head1);
		main_after_view.add(l_sub_head2);
		main_after_view.add(b_sub_mypage);
		main_after_view.add(b_sub_logout);
		main_after_view.add(b_sub_deliver);
		main_after_view.add(b_sub_deliver_check);
		main_after_view.add(back_gr_jl3);
		
		
		// ����������
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
		
		
		// �ù� ����
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
		
		
		// �ù� ��ȸ
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
		
		
		// �ù�Ϸ� ���� �˾�â
		deliver_review.add(dr_head);
		deliver_review.add(l_dr_ta);
		deliver_review.add(dr_star);
		deliver_review.add(dr_ta_head);
		deliver_review.add(dr_ta);
		deliver_review.add(dr_cancel);
		deliver_review.add(dr_finish);
		
		
		
		// ���� ����
		
		// ���� ȭ��
		main_before_view.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// �α��� ȭ��
		Login.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// ȸ������ ȭ��
		join.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// �α��� �� ���� ȭ��
		main_after_view.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// ���������� ȭ��
		mypage.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// �ù� ���� ȭ��
		deliver.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// ��� ��ȸ ȭ��
		deliver_check.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// ��ۿϷ� ���� �˾�â
		deliver_review.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				deliver_review.dispose();
			}
		});
		
		//����ȭ��
		map.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//Ż��ȭ��
		delecting.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				delecting.dispose();
			}
		});
		
		
		// ���� �ʱ� �� & ���� ����
		
		
		// ����ȭ��
		main_before_view.setVisible(true);
		// �α��� ȭ��
		Login.setVisible(false);
		// ȸ������ ȭ��
		join.setVisible(false);
		// �α��� �� ���� ȭ��
		main_after_view.setVisible(false);
		// ���������� ȭ��
		mypage.setVisible(false);
		// �ù� ���� ȭ��
		deliver.setVisible(false);
		// ��� ��ȸ ȭ��
		deliver_check.setVisible(false);
		// ��ۿϷ� ���� �˾�â
		deliver_review.setVisible(false);
		//����ȭ��
		map.setVisible(false);
		//Ż��ȭ��
		delecting.setVisible(false);

	}//main
}

