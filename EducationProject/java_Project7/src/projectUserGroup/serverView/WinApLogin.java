package projectUserGroup.serverView;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import projectUserGroup.DbGroup.MemberDAO;
import projectUserGroup.DbGroup.MemberVO;
import projectUserGroup.DbGroup.table.MemberData;

public class WinApLogin {

	private JFrame frame;
	private JTextField textId;
	private JTextField textPswd;
	private JTextField textEmail;
	private JTextField textName;
	private JTextField textBirthday;
	
	private MemberDAO dao = new MemberDAO();
	private boolean bIdCheck = true;
	private boolean bMan = true;
	
	private JTextField textPswdCheck;

	/**
	 * Create the application.
	 */
	public WinApLogin() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 453, 688);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(135, 206, 250));
		p1.setBounds(0, 0, 437, 55);
		frame.getContentPane().add(p1);
		p1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("JAVA");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 27));
		lblNewLabel_1.setBounds(12, 10, 294, 35);
		p1.add(lblNewLabel_1);
		
		JPanel p1_1 = new JPanel();
		p1_1.setBounds(0, 56, 437, 516);
		frame.getContentPane().add(p1_1);
		p1_1.setLayout(null);
		
		textId = new JTextField();
		textId.setFont(new Font("굴림", Font.PLAIN, 18));
		textId.setBounds(99, 10, 167, 41);
		p1_1.add(textId);
		textId.setColumns(10);
		
		textId.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {	bIdCheck = true;	}
			@Override
			public void keyPressed(KeyEvent e) {bIdCheck = true;}
			@Override
			public void keyReleased(KeyEvent e) {	bIdCheck = true;	}
		});
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setBounds(46, 11, 41, 41);
		p1_1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBounds(28, 54, 59, 41);
		p1_1.add(lblNewLabel_2);
		
		textPswd = new JTextField();
		textPswd.setFont(new Font("굴림", Font.PLAIN, 18));
		textPswd.setColumns(10);
		textPswd.setBounds(99, 53, 267, 41);
		p1_1.add(textPswd);
		
		JLabel lblNewLabel_2_1 = new JLabel("이메일");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_2_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2_1.setBounds(-55, 145, 142, 41);
		p1_1.add(lblNewLabel_2_1);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("굴림", Font.PLAIN, 18));
		textEmail.setColumns(10);
		textEmail.setBounds(99, 144, 267, 41);
		p1_1.add(textEmail);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("[선택] 비밀번호 분실 시 확인용");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_2_1_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2_1_1.setBounds(99, 184, 244, 29);
		p1_1.add(lblNewLabel_2_1_1);
		
		textName = new JTextField();
		textName.setFont(new Font("굴림", Font.PLAIN, 18));
		textName.setColumns(10);
		textName.setBounds(99, 223, 267, 41);
		p1_1.add(textName);
		
		JLabel lblNewLabel_3 = new JLabel("이름");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_3.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3.setBounds(46, 224, 41, 41);
		p1_1.add(lblNewLabel_3);
		
		textBirthday = new JTextField();
		textBirthday.setFont(new Font("굴림", Font.PLAIN, 18));
		textBirthday.setColumns(10);
		textBirthday.setBounds(99, 270, 267, 41);
		p1_1.add(textBirthday);
		
		JLabel lblNewLabel_3_1 = new JLabel("생년월일");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_3_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3_1.setBounds(-30, 271, 117, 41);
		p1_1.add(lblNewLabel_3_1);
		

		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("8자리 입력     *");
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1_1.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_2_1_1_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2_1_1_1.setBounds(99, 310, 276, 29);
		p1_1.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("예시) 20001231");
		lblNewLabel_2_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1_1_1.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel_2_1_1_1_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2_1_1_1_1.setBounds(179, 321, 196, 29);
		p1_1.add(lblNewLabel_2_1_1_1_1);
		
		JButton btnMale = new JButton("남자");
		btnMale.setBackground(new Color(135, 206, 250));
		btnMale.setBounds(131, 349, 97, 30);
		p1_1.add(btnMale);
		
		JButton btnFemale = new JButton("여자");
		btnFemale.setBounds(233, 349, 97, 30);
		p1_1.add(btnFemale);
		

		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnMale.equals(e.getSource())) {
					bMan = true;
					btnMale.setBackground(new Color(135, 206, 250));
					btnFemale.setBackground(new Color(100, 100, 80));
				}else {
					bMan = false;
					btnFemale.setBackground(new Color(135, 206, 250));
					btnMale.setBackground(new Color(100, 100, 80));
				}

			}		
		};
		
		btnMale.addActionListener(action);
		btnFemale.addActionListener(action);
		
		JButton btnIdCheck = new JButton("중복확인");
		btnIdCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bIdCheck = dao.isId(textId.getText());		
				if(bIdCheck == true ) {
					JOptionPane.showMessageDialog(null, "다른 아이디를 선택해주세요.");
				}else {
					
//					if(textId.getText() )
					JOptionPane.showMessageDialog(null, "회원 가입이 가능합니다.");
				}
					
				
			}
		});
		
		btnIdCheck.setFont(new Font("굴림", Font.PLAIN, 12));
		btnIdCheck.setBounds(278, 10, 88, 41);
		p1_1.add(btnIdCheck);
		
		textPswdCheck = new JTextField();
		textPswdCheck.setFont(new Font("굴림", Font.PLAIN, 18));
		textPswdCheck.setColumns(10);
		textPswdCheck.setBounds(99, 98, 267, 41);
		p1_1.add(textPswdCheck);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("<html><body><center>비밀번호<br>확인</center></body></html>");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_2_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2_2_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2_2_1.setBounds(-10, 98, 97, 41);
		p1_1.add(lblNewLabel_2_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 389, 378, 123);
		p1_1.add(scrollPane);
		
		JTextArea textExplain = new JTextArea();
		scrollPane.setViewportView(textExplain);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		scrollPane.setColumnHeaderView(panel);
		
		JLabel lblNewLabel_4 = new JLabel("가 입 목 적");
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 17));
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("*");
		lblNewLabel_5.setForeground(new Color(255, 0, 0));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_5.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_5.setBounds(56, 5, 41, 41);
		p1_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("*");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5_1.setForeground(Color.RED);
		lblNewLabel_5_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_5_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_5_1.setBounds(56, 48, 41, 41);
		p1_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("*");
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5_2.setForeground(Color.RED);
		lblNewLabel_5_2.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_5_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_5_2.setBounds(56, 92, 41, 41);
		p1_1.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("*");
		lblNewLabel_5_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5_3.setForeground(Color.RED);
		lblNewLabel_5_3.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_5_3.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_5_3.setBounds(56, 217, 41, 41);
		p1_1.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_5_4 = new JLabel("*");
		lblNewLabel_5_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5_4.setForeground(Color.RED);
		lblNewLabel_5_4.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_5_4.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_5_4.setBounds(56, 264, 41, 41);
		p1_1.add(lblNewLabel_5_4);
		
		JPanel p1_1_1 = new JPanel();
		p1_1_1.setBounds(0, 571, 437, 80);
		frame.getContentPane().add(p1_1_1);
		p1_1_1.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("가입 요청");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(bIdCheck == false) {
					//현재 아이디가 존재 X 
					if(textPswd.getText().equals(textPswdCheck.getText()) ) {

							String regexpDay = "^[\\d]{8}$"; 
							regexpDay = "^19+[7-9][0-9]+(1[0-2]|0[1-9])+(0[0-9]|1[0-9]|2[0-9]|3[0-1])+$"; 
							String birthday =  textBirthday.getText();

							System.out.println(birthday);
							if(Pattern.matches(regexpDay , birthday)) {
								
								if(!textEmail.getText().equals("")) {
									String regexpEmail = "^[a-zA-Z0-9_]+@[a-zA-Z0-9]+.[a-z]{2,3}+$"; 
									if(!Pattern.matches(regexpEmail,textEmail.getText())) {
										JOptionPane.showMessageDialog(null, "이메일 형식을 확인해주세요");
										return;
									}
								}

								//가입 

								textExplain.getText();
								
								MemberVO member = new MemberVO();
								
								member.vo.setColumn(MemberData.STR(MemberData.STR_ID), textId.getText());
								member.vo.setColumn(MemberData.STR(MemberData.STR_PSWD), textPswd.getText());
								member.vo.setColumn(MemberData.STR(MemberData.STR_EMAIL), textEmail.getText());
								
								member.vo.setColumn(MemberData.STR(MemberData.STR_NAME), textName.getText());
								
								//LocalDateTime
								String strBirthday = textBirthday.getText();
						    StringBuffer buf = new StringBuffer(strBirthday);
						    buf = buf.insert( 4 ,"-");
						    buf = buf.insert( 7 ,"-");
						    strBirthday = buf.toString()+" 00:00:00";
						    
								
								member.vo.setColumn(MemberData.STR(MemberData.STR_BRITHDAY), strBirthday);
								member.vo.setColumn(MemberData.STR(MemberData.STR_EXPLAN), textExplain.getText());
								
								//ip 확인
								InetAddress local;
								try {
									local = InetAddress.getLocalHost();	
									member.vo.setColumn(MemberData.STR(MemberData.STR_LASTIPADDRESS), local.getHostAddress());
								} catch (UnknownHostException e1) {
									e1.printStackTrace();
								}

								
								member.vo.setColumn(MemberData.BOOL(MemberData.BOOL_GENDER), bMan);

								dao.memberAdd(member.vo);
			
							}
							else
								JOptionPane.showMessageDialog(null, "생년월일을 확인해주세요");	

					}else
						JOptionPane.showMessageDialog(null, "비밀번호를 다시 확인해주세요");
				}else
					JOptionPane.showMessageDialog(null, "아이디 중복을 확인해주세요");
			}
		});
		btnNewButton_2.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton_2.setBounds(130, 10, 196, 53);
		p1_1_1.add(btnNewButton_2);
		
	}
}
