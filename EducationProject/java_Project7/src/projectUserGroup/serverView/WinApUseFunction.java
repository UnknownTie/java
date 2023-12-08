package projectUserGroup.serverView;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import projectUserGroup.Log;
import projectUserGroup.DbGroup.MemberVO;
import projectUserGroup.DbGroup.table.MemberData;
import projectUserGroup.DbGroup.table.statusTypes;

public class WinApUseFunction  {

	private JFrame frame;
	private JTabbedPane tabbedPane;

	private String strLogData ="";
	private Log logclass = new Log();
	
	public WinApUseFunction(MemberVO memberVo) {
		initialize(memberVo);
		frame.setVisible(true);
	}

	
	private void tabCreate(MemberVO member , JPanel pn) {
		

		//tabbedPane.setTabPlacement(JTabbedPane.TOP);	
		boolean bCk = false;
		//JPanel[] pnTab = new JPanel [member.status.size()];
		tabbedPane =  new JTabbedPane(JTabbedPane.TOP);
		pn.add(tabbedPane);

		for(int i=0; i < member.status.size() ; i++) {			
			JPanel pnTab = new JPanel();

			tabbedPane.addTab(member.getProjectName(i), null , pnTab ,null);	
			pnTab.setBounds(10, 10,  pn.getWidth()  , pn.getHeight());
			pnTab.setLayout(null);
			
			if(member.getReadLevel(i) == statusTypes.nBLACKLIST) // 블랙 리스트 
				blackListView(pnTab);
			else
				btnSet(member, i , pnTab );
		}
		
	}
	private void blackListView(JPanel pn ) {
		
	}

	private void btnSet(MemberVO member ,int nProjcetNum,JPanel pn ) {
		System.out.println(pn.hashCode());
		int nRead , nWrite ; 
		String strID;
		strID = member.vo.getColumn(MemberData.STR(MemberData.STR_ID));
		nRead = member.getReadLevel(nProjcetNum);
		nWrite = member.getWriteLevel(nProjcetNum);
		
		if(member.getProject(nProjcetNum) == statusTypes.PROJECTCODE[0]) {

		P1_ReadBtnCreate(strID ,nRead , pn);
		P1_WriteBtnCreate(strID ,nWrite , pn);

		}
		else if(member.getProject(nProjcetNum) == statusTypes.PROJECTCODE[1]) {

		P2_ReadBtnCreate(strID ,nRead , pn);
		P2_WriteBtnCreate(strID ,nWrite , pn);
		}
		else if(member.getProject(nProjcetNum) == statusTypes.PROJECTCODE[2]) {

		P2_ReadBtnCreate(strID ,nRead , pn);
		P2_WriteBtnCreate(strID ,nWrite , pn);
		}

	}


	private void P2_WriteBtnCreate(String Id ,int nRead, JPanel pn) {
		JPanel pnWrite = new JPanel();
		pnWrite.setBounds(0, pn.getHeight()/2 ,pn.getWidth() - 20, pn.getHeight()/2 - 10);
		pnWrite.setLayout(null);	
		pn.add(pnWrite);
		
		JPanel pnWriteBtn = new JPanel();
		pnWriteBtn.setLayout(new GridLayout(2,5 ));
		pnWriteBtn.setBounds(10, 30 ,  pnWrite.getWidth() - 10, pnWrite.getHeight() - 50);
		pnWrite.add(pnWriteBtn);
	
		
		switch (nRead) {	
			case 5: 
				JButton jBtn5 = new JButton("2-5");
				pnWriteBtn.add(jBtn5);
			case 4:
				JButton jBtn4 = new JButton("2-4");
				pnWriteBtn.add(jBtn4);
			case 3:
				JButton jBtn3 = new JButton("2-3");
				pnWriteBtn.add(jBtn3);
				JButton jBtn33 = new JButton("2-3");
				pnWriteBtn.add(jBtn33);
				JButton jBtn31 = new JButton("2-3");
				pnWriteBtn.add(jBtn31);
			case 2:
				JButton jBtn2 = new JButton("2-2");
				pnWriteBtn.add(jBtn2);
			case 1:
				JButton jBtn1 = new JButton("1");
				pnWriteBtn.add(jBtn1);
				
				JLabel lblNewLabel = new JLabel(" 수 정 ");
				lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
				lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
				lblNewLabel.setBounds(0, 0, 100, 34);
				
				pnWrite.add(lblNewLabel );
			default:
	
		}
	}


	private void P2_ReadBtnCreate(String Id ,int nRead, JPanel pn) {
		JPanel pnRead = new JPanel();
		pnRead.setBounds(0, 0,  pn.getWidth() - 20 , pn.getHeight()/2 - 10);
		pnRead.setLayout(null);
		pn.add(pnRead);
		
		JPanel pnReadBtn = new JPanel();
		pnReadBtn.setLayout(new GridLayout(2,5 ));
		pnReadBtn.setBounds(10, 30,  pnRead.getWidth() - 10, pnRead.getHeight() - 50);
		pnRead.add(pnReadBtn);

		switch (nRead) {	
			case 5: 
				JButton jBtn5 = new JButton("2-5");
				pnReadBtn.add(jBtn5);
			case 4:
				JButton jBtn4 = new JButton("2-4");
				pnReadBtn.add(jBtn4);
			case 3:
				JButton jBtn3 = new JButton("2-3");
				pnReadBtn.add(jBtn3);
			case 2:
				JButton jBtn2 = new JButton("2-2");
				pnReadBtn.add(jBtn2);
			case 1:
				JButton jBtn1 = new JButton("2-1");
				pnReadBtn.add(jBtn1);
				
				JLabel lblNewLabel = new JLabel(" 확 인 ");
				lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
				lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
				lblNewLabel.setBounds(0, 0, 100, 34);
				
				pnRead.add(lblNewLabel );
			default:
	
		}
		
		
		
	}


	private void P1_WriteBtnCreate(String Id ,int nRead, JPanel pn) {

		JPanel pnWrite = new JPanel();
		pnWrite.setBounds(0, pn.getHeight()/2 ,pn.getWidth() - 20, pn.getHeight()/2 - 10);
		pnWrite.setLayout(null);	
		pn.add(pnWrite);
		
		JPanel pnWriteBtn = new JPanel();
		pnWriteBtn.setLayout(new GridLayout(2,5 ));
		pnWriteBtn.setBounds(10, 30 ,  pnWrite.getWidth() - 10, pnWrite.getHeight() - 50);
		pnWrite.add(pnWriteBtn);
	
		switch (nRead) {	
			case 5: 
				JButton jBtn5 = new JButton("1-5");
				pnWriteBtn.add(jBtn5);
				
				jBtn5.addActionListener( new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						new WinApUserList(Id);
					}
				});
				
				
			case 4:
				JButton jBtn4 = new JButton("1-4 회원관리");
				pnWriteBtn.add(jBtn4);
				
				jBtn4.addActionListener( new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						new WinApUserList(Id);
					}
				});
			case 3:
				JButton jBtn3 = new JButton("1-3");
				pnWriteBtn.add(jBtn3);
				JButton jBtn33 = new JButton("1-3");
				pnWriteBtn.add(jBtn33);
				JButton jBtn31 = new JButton("1-3");
				pnWriteBtn.add(jBtn31);
			case 2:
				JButton jBtn2 = new JButton("1-2");
				pnWriteBtn.add(jBtn2);
			case 1:
				JButton jBtn1 = new JButton("1-1");
				pnWriteBtn.add(jBtn1);
				
				JLabel lblNewLabel = new JLabel(" 수 정 ");
				lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
				lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
				lblNewLabel.setBounds(0, 0, 100, 34);
				
				pnWrite.add(lblNewLabel );
			default:
	
		}
		
	}


	private void P1_ReadBtnCreate(String Id ,int nRead, JPanel pn) {

		JPanel pnRead = new JPanel();
		pnRead.setBounds(0, 0,  pn.getWidth() - 20 , pn.getHeight()/2 - 10);
		pnRead.setLayout(null);
		pn.add(pnRead);
		
		JPanel pnReadBtn = new JPanel();
		pnReadBtn.setLayout(new GridLayout(2,5 ));
		pnReadBtn.setBounds(10, 30,  pnRead.getWidth() - 10, pnRead.getHeight() - 50);
		pnRead.add(pnReadBtn);

		switch (nRead) {	
			case 5: 
				JButton jBtn5 = new JButton("1-5");
				pnReadBtn.add(jBtn5);
			case 4:
				JButton jBtn4 = new JButton("1-4");
				pnReadBtn.add(jBtn4);
			case 3:
				JButton jBtn3 = new JButton("1-3");
				pnReadBtn.add(jBtn3);
			case 2:
				JButton jBtn2 = new JButton("1-2");
				pnReadBtn.add(jBtn2);
			case 1:
				JButton jBtn1 = new JButton("1-1");
				pnReadBtn.add(jBtn1);
				
				JLabel lblNewLabel = new JLabel(" 확 인 ");
				lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
				lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
				lblNewLabel.setBounds(0, 0, 100, 34);
				
				pnRead.add(lblNewLabel );
			default:
		}

	}


	
	
	private void initialize(MemberVO memberVo) {
		frame = new JFrame("JAVA");
				

		frame.setBounds(100, 100, 739, 527);
		frame.getContentPane().setLayout(null);
		//setLocationRelativeTo(null); 
		
		JButton btnNewButton = new JButton("로그아웃");
		btnNewButton.setBounds(584, 425, 127, 53);
		frame.getContentPane().add(btnNewButton);
		
		JPanel pn = new JPanel();
		pn.setBounds(10, 10, 699, 405);
		pn.setLayout(new GridLayout(1, 0, 0, 0));
		
		frame.getContentPane().add(pn);
		
		memberVo.statusSetting();
		memberVo.statusSetCheck();
		
		tabCreate(memberVo,pn);

		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new mainServer();
				frame.dispose();
			}
		});
		

		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
