package projectUserGroup.serverView;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import projectUserGroup.DbGroup.MemberDAO;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;

public class WinApUserList {

	private MemberDAO dao = new MemberDAO();
	private JFrame frame;
	private JTable tableMember;
	private JScrollPane spMemberData;

	DefaultTableModel dtm ;
	Vector title ,vData;
	/**
	 * Create the application.
	 */
	public WinApUserList(String strID) {
		initialize(strID);
		
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String strID) {
		frame = new JFrame(strID);
		frame.setResizable(false);
		frame.setBounds(100, 100, 448, 666);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(135, 206, 250));
		p1.setToolTipText("");
		p1.setBounds(0, 0, 432, 46);
		frame.getContentPane().add(p1);
		p1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회 원 관 리");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(12, 0, 190, 46);
		p1.add(lblNewLabel);
		
		JPanel p2 = new JPanel();
		p2.setBounds(0, 45, 432, 497);
		frame.getContentPane().add(p2);
		p2.setLayout(null);
		
		JComboBox comboUserType = new JComboBox();
		comboUserType.setBackground(new Color(248, 248, 255));
		comboUserType.setFont(new Font("굴림", Font.PLAIN, 15));
		comboUserType.setModel(new DefaultComboBoxModel(new String[] {"신규회원", "기존회원", "블랙리스트"}));
		comboUserType.setBounds(12, 10, 192, 23);
		p2.add(comboUserType);
		
		JScrollPane scrollStatusType = new JScrollPane();
		scrollStatusType.setBounds(12, 255, 118, 232);
		p2.add(scrollStatusType);
		
		JList listStatus = new JList();
		listStatus.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	
		listStatus.setFont(new Font("굴림", Font.PLAIN, 15));
		
		
		listStatus.setModel(new AbstractListModel() {			
			String[] values = dao.getStatusTypeList();
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollStatusType.setViewportView(listStatus);
		
		JLabel lblNewLabel_2 = new JLabel("권한 목록");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		scrollStatusType.setColumnHeaderView(lblNewLabel_2);
		
		title = dao.getMemberTitleList();
		vData= dao.getMemberList(comboUserType.getSelectedIndex());
		
		comboUserType.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				title = dao.getMemberTitleList();
				vData= dao.getMemberList(comboUserType.getSelectedIndex());

				dtm.setDataVector(vData,title);
				
				vData= dao.getMemberList(comboUserType.getSelectedIndex());
				
			}
		});
		
		dtm = new DefaultTableModel(vData, title);
		vData= dao.getMemberList(comboUserType.getSelectedIndex());
		tableMember = new JTable(dtm);
		
		spMemberData = new JScrollPane(tableMember);
		spMemberData.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spMemberData.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		spMemberData.setBounds(12, 42, 408, 203);
		p2.add(spMemberData);

//		spMemberData.setViewportView(tableMember);
		
		JLabel lblNewLabel_3 = new JLabel("회원 정보");
		spMemberData.setColumnHeaderView(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(142, 255, 278, 232);
		p2.add(scrollPane);
		
		JTextArea txtExplan = new JTextArea();
		scrollPane.setViewportView(txtExplan);
		
		JLabel lblNewLabel_1 = new JLabel("회원 설명");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblNewLabel_1);
		
		JPanel p3 = new JPanel();
		p3.setBounds(0, 541, 432, 86);
		frame.getContentPane().add(p3);
		p3.setLayout(null);
		
		JButton btnNewButton = new JButton("수정");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dao.StatusUpdate((Vector)vData.get(tableMember.getSelectedRow()) , txtExplan.getText());
			}
		});
		
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 18));
		btnNewButton.setBounds(12, 10, 164, 53);
		p3.add(btnNewButton);
		
	}
}
