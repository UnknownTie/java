package projectUserGroup.serverView;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import projectUserGroup.Log;
import projectUserGroup.DbGroup.MemberDAO;
import projectUserGroup.DbGroup.MemberVO;

@SuppressWarnings("serial")
public class mainServer extends JFrame {

	private JPanel contentPane;
	private JButton btnRequest, btnExit;
	private JLabel title;
	private JButton btnLogin;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtId;
	private JPasswordField txtPswd;
	
	MemberDAO dao = new MemberDAO();
	Log logclass = new Log();
	String strLogData = "";


	/**
	 * Create the frame.
	 */
	
	public mainServer() {
		
		initialize();
		setVisible(true);
	}
	
	
	private void initialize() {
		setTitle("JAVA Project");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(135, 206, 250));
		pn1.setBounds(0, 0, 784, 75);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		title = new JLabel("JAVA");
		title.setFont(new Font("굴림", Font.BOLD, 25));
		title.setBackground(new Color(135, 206, 250));
		title.setBounds(12, 10, 92, 65);
		pn1.add(title);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 77, 784, 376);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblMain = new JLabel("");
		lblMain.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain.setIcon(new ImageIcon(mainServer.class.getResource("/projectUserGroup/serverView/img/main.jpg")));
		lblMain.setBounds(0, 0, 784, 376);
		pn2.add(lblMain);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 453, 784, 108);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		btnRequest = new JButton("회원가입 신청");

		btnRequest.setForeground(new Color(0, 0, 0));
		btnRequest.setBackground(new Color(173, 216, 230));
		btnRequest.setFont(new Font("굴림", Font.BOLD, 18));
		btnRequest.setBounds(473, 10, 166, 83);
		pn3.add(btnRequest);
		
		btnExit = new JButton("종  료");
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.setFont(new Font("굴림", Font.BOLD, 20));
		btnExit.setBounds(681, 38, 91, 55);
		pn3.add(btnExit);
		
		btnLogin = new JButton("로그인");

		btnLogin.setFont(new Font("굴림", Font.BOLD, 18));
		btnLogin.setBounds(360, 10, 101, 83);
		pn3.add(btnLogin);
		
		lblNewLabel = new JLabel("아이디");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(12, 13, 66, 31);
		pn3.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(12, 60, 66, 31);
		pn3.add(lblNewLabel_1);
		
		txtId = new JTextField();
		txtId.setBounds(90, 10, 236, 36);
		pn3.add(txtId);
		txtId.setColumns(10);
		
		txtPswd = new JPasswordField();
		txtPswd.setColumns(10);
		txtPswd.setBounds(90, 57, 236, 36);
		pn3.add(txtPswd);
		
		//테스트
		txtId.setText("admin");
		txtPswd.setText("1234");
		
		/* ====================================================== */
		
		//로그인
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// dao로 존재 여부 확인 
				// 결과에 따라 접속 영역 분할 			
				strLogData = "btnLogin.addActionListener(new ActionListener() \n";
				String id ,pswd;
				id = txtId.getText();
				pswd = txtPswd.getText();
				
				MemberVO member = dao.logIn(id ,pswd);

				System.out.println("1");
				//member.vo.ge

				
				if(member == null) {
					strLogData += "로그인 실패";
					logclass.LogWrite(strLogData, 1);
					
//					dispose();
//					new WinApUseFunction(member);		
				}
				else {
					strLogData += "로그인 : "+id;
					logclass.LogWrite(strLogData, 1);
					
					dispose();
					new WinApUseFunction(member);		
				}
			}
			
		});
		
		//가입 요청
		btnRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new WinApLogin();
			}
		});
		
		// 종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
