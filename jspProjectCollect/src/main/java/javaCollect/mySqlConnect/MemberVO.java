package javaCollect.mySqlConnect;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Vector;

import javaCollect.base.Log;
import javaCollect.mySqlConnect.Dto.MembersTable;
import javaCollect.mySqlConnect.Dto.StatuslistTable;
import javaCollect.mySqlConnect.Dto.StatustypesTable;

public class MemberVO{
	
	//불변 , 사용할 데이터 정리해서 저장해야된다. 
	// 해당 값으 front로 전달해야된다 .
	
	
	
	
	public VO vo = new VO();
	public ArrayList<VO> statusVos = new ArrayList();
	public ArrayList<Project> status = new ArrayList();
	public ArrayList<VO> vos = new ArrayList();
	private Vector ViewCol = new Vector<String>();
	
	Log logclass = new Log();
	String strLog="";
	
	class Project {
		private final int nProject;
		private int nReadLevel =0;
		private int nWriteLevel =0;

		Project(int nProject){this.nProject = nProject;	}
		
		boolean isProject(int projectCode) {	
			return nProject == projectCode;	
			}	
		int getnProject() {	return nProject;}
		
		int getnReadLevel() {	return nReadLevel;}	
		void setnReadLevel(int nRead) {	nReadLevel = nRead;	}
		void changeReadLevel(int nRead) {	
			if(nReadLevel < nRead )
				nReadLevel = nRead;	
		}
		
		int getnWriteLevel() {	return nWriteLevel;	}
		void setnWriteLevel(int nWrite) {	nWriteLevel = nWrite;}
		void changeWriteLevel(int nWrite) {	
			if(nWriteLevel < nWrite )
				nWriteLevel = nWrite;	
		}
		
		public String toString() {
			return "nProject : " + nProject +" / nReadLevel : " + nReadLevel+" / nWriteLevel : " + nWriteLevel;
		}
	}

	
	public MemberVO() {
		setTitle();
	}
	
	public int getWriteLevel(int nNum) { return status.get(nNum).getnWriteLevel();	}
	public int getReadLevel(int nNum) { return status.get(nNum).getnReadLevel();	}
	public int getProject(int nNum) { return status.get(nNum).getnProject();}
	public String getProjectName(int nNum) {
		String ProjectName ="";
		for(int i = 0; i< StatustypesTable.PROJECTCODE.length; i++) 
			if( status.get(nNum).getnProject() == StatustypesTable.PROJECTCODE[i])
				ProjectName = StatustypesTable.PROJECTNAME[i];

		return ProjectName;
	}
	
	public void statusSetting() {
		strLog = "void statusCheck()  \n";
		
		//ip 확인
		InetAddress local;
		String ip = "";
		try {
			local = InetAddress.getLocalHost();
			ip = local.getHostAddress();

			
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		
		A:for(VO vo : this.statusVos) {
			//자신의 읽기 쓰기 권한의 최대값을 찾는다.
			int nRead = vo.getNColumn(StatustypesTable.INT(StatustypesTable.INT_READ));
			int nWrite = vo.getNColumn(StatustypesTable.INT(StatustypesTable.INT_WRITE));
			
			//ip 주소가 동일하다면,
			if(ip.equals(vo.getColumn(StatustypesTable.STR(StatustypesTable.STR_IP)))) {
				int nIpRead = vo.getNColumn(StatustypesTable.INT(StatustypesTable.INT_IPREAD));
				int nIpWrite = vo.getNColumn(StatustypesTable.INT(StatustypesTable.INT_IPWRITE));
				System.out.println("동일 IP : " + ip);
				if(nRead < nIpRead)
					nRead = nIpRead;
				
				if(nWrite < nIpWrite)
					nWrite = nIpWrite;
			}
			
			strLog += "nRead : "+ nRead +"  nWrite : "+nWrite+"\n";
			logclass.LogWrite(strLog, 1);

			for(Project projectCode :this.status) {
				if(projectCode.isProject(vo.getNColumn(StatuslistTable.INT(StatuslistTable.INT_PROJECT)))) {
					System.out.println("nRead : " + nRead);
					System.out.println("nWrite : " + nWrite);
					projectCode.changeReadLevel(nRead); 
					projectCode.changeWriteLevel(nWrite); 
					continue A;
				}
			}


			Project projectCode = new Project(vo.getNColumn(StatuslistTable.INT(StatuslistTable.INT_PROJECT)));		
			projectCode.setnReadLevel(nRead); 
			projectCode.setnWriteLevel(nWrite); 
			
			status.add(projectCode);

			}

	}
	
	void statusCheck(VO Vo) {
		//ip 확인
		InetAddress local;
		String ip;
		try {
			local = InetAddress.getLocalHost();
			ip = local.getHostAddress();
			System.out.println("local ip : "+ip);
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		
		
	}
	
	
	
	void setTitle() {
		String strCol ="";
		strCol = MembersTable.STR(MembersTable.STR_ID);
		ViewCol.add(MembersTable.STR(MembersTable.STR_ID));
		vo.ColumnTitle.put(MembersTable.STR(MembersTable.STR_ID),"아이디");

		ViewCol.add(MembersTable.STR(MembersTable.STR_NAME));
		vo.ColumnTitle.put(MembersTable.STR(MembersTable.STR_NAME),"이름");
		
		ViewCol.add(StatustypesTable.STR(StatustypesTable.STR_NAME));
		vo.ColumnTitle.put(StatustypesTable.STR(StatustypesTable.STR_NAME),"권한");
				
		ViewCol.add(MembersTable.BOOL(MembersTable.BOOL_GENDER));
		vo.ColumnTitle.put(MembersTable.BOOL(MembersTable.BOOL_GENDER),"성별");
		
		ViewCol.add(MembersTable.STR(MembersTable.STR_EMAIL));
		vo.ColumnTitle.put(MembersTable.STR(MembersTable.STR_EMAIL),"이메일");
		
		ViewCol.add(MembersTable.STR(MembersTable.STR_EXPLAN));
		vo.ColumnTitle.put(MembersTable.STR(MembersTable.STR_EXPLAN),"설명");
		
		//VIEW에 출력 x , 내부적으로 사용하는 값
		ViewCol.add(StatuslistTable.INT(StatuslistTable.INT_IDX)); 
		ViewCol.add(StatuslistTable.INT(StatuslistTable.INT_STATUS)); 
	}
	
	void memberReset() {
		for (String col : MembersTable.STR)
			vo.Column.put(col, null);
		for (String col : MembersTable.INT)
			vo.Column.put(col, null);
		for (String col : MembersTable.BOOL)
			vo.Column.put(col, null);
		
		for (String col : StatuslistTable.INT)
			vo.Column.put(col, null);

		for (String col : StatustypesTable.STR)
			vo.Column.put(col, null);
		for (String col : StatustypesTable.INT)
			vo.Column.put(col, null);
	}
	
	public Vector memberList() {
		Vector vDatas = new Vector<>();

		for(VO voData : vos) {
			Vector vData = new Vector<>();
			
			for(int i=0; i< ViewCol.size(); i++) 	{
				System.out.println((String) ViewCol.get(i) + " : "+ voData.getColumn((String) ViewCol.get(i)));
				String data = voData.getColumn((String) ViewCol.get(i));
				if(data =="-999")
					data ="";
				
				vData.add(data);
			}

			vDatas.add(vData);
		}	
		return vDatas;
	}
	
	
	public Vector getTitle() {

		Vector vData = new Vector<>();
			
		for(int i=0; i< vo.ColumnTitle.size(); i++) 			
			vData.add(vo.ColumnTitle.get((String) ViewCol.get(i)));
		
		return vData;
	}

	public void statusSetCheck() {
		for(Project pj : this.status) {
			System.out.println("status : " + pj.toString());			
		}
		
	}

	
	
}
