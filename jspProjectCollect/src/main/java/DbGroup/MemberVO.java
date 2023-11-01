package DbGroup;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Vector;

import DbGroup.table.MemberData;
import DbGroup.table.statusTypes;
import DbGroup.table.statuslist;
import javaCollect.base.Log;

public class MemberVO{
	
	public VO vo = new VO();
	public ArrayList<VO> statusVos = new ArrayList();
	public ArrayList<Project> status = new ArrayList();
	ArrayList<VO> vos = new ArrayList();
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
		for(int i = 0; i< statusTypes.PROJECTCODE.length; i++) 
			if( status.get(nNum).getnProject() == statusTypes.PROJECTCODE[i])
				ProjectName = statusTypes.PROJECTNAME[i];

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
			int nRead = vo.getNColumn(statusTypes.INT(statusTypes.INT_READ));
			int nWrite = vo.getNColumn(statusTypes.INT(statusTypes.INT_WRITE));
			
			//ip 주소가 동일하다면,
			if(ip.equals(vo.getColumn(statusTypes.STR(statusTypes.STR_IP)))) {
				int nIpRead = vo.getNColumn(statusTypes.INT(statusTypes.INT_IPREAD));
				int nIpWrite = vo.getNColumn(statusTypes.INT(statusTypes.INT_IPWRITE));
				System.out.println("동일 IP : " + ip);
				if(nRead < nIpRead)
					nRead = nIpRead;
				
				if(nWrite < nIpWrite)
					nWrite = nIpWrite;
			}
			
			strLog += "nRead : "+ nRead +"  nWrite : "+nWrite+"\n";
			logclass.LogWrite(strLog, 1);

			for(Project projectCode :this.status) {
				if(projectCode.isProject(vo.getNColumn(statuslist.INT(statuslist.INT_PROJECT)))) {
					System.out.println("nRead : " + nRead);
					System.out.println("nWrite : " + nWrite);
					projectCode.changeReadLevel(nRead); 
					projectCode.changeWriteLevel(nWrite); 
					continue A;
				}
			}


			Project projectCode = new Project(vo.getNColumn(statuslist.INT(statuslist.INT_PROJECT)));		
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
		strCol = MemberData.STR(MemberData.STR_ID);
		ViewCol.add(MemberData.STR(MemberData.STR_ID));
		vo.ColumnTitle.put(MemberData.STR(MemberData.STR_ID),"아이디");

		ViewCol.add(MemberData.STR(MemberData.STR_NAME));
		vo.ColumnTitle.put(MemberData.STR(MemberData.STR_NAME),"이름");
		
		ViewCol.add(statusTypes.STR(statusTypes.STR_NAME));
		vo.ColumnTitle.put(statusTypes.STR(statusTypes.STR_NAME),"권한");
				
		ViewCol.add(MemberData.BOOL(MemberData.BOOL_GENDER));
		vo.ColumnTitle.put(MemberData.BOOL(MemberData.BOOL_GENDER),"성별");
		
		ViewCol.add(MemberData.STR(MemberData.STR_EMAIL));
		vo.ColumnTitle.put(MemberData.STR(MemberData.STR_EMAIL),"이메일");
		
		ViewCol.add(MemberData.STR(MemberData.STR_EXPLAN));
		vo.ColumnTitle.put(MemberData.STR(MemberData.STR_EXPLAN),"설명");
		
		//VIEW에 출력 x , 내부적으로 사용하는 값
		ViewCol.add(statuslist.INT(statuslist.INT_IDX)); 
		ViewCol.add(statuslist.INT(statuslist.INT_STATUS)); 
	}
	
	void memberReset() {
		for (String col : MemberData.STR)
			vo.Column.put(col, null);
		for (String col : MemberData.INT)
			vo.Column.put(col, null);
		for (String col : MemberData.BOOL)
			vo.Column.put(col, null);
		
		for (String col : statuslist.INT)
			vo.Column.put(col, null);

		for (String col : statusTypes.STR)
			vo.Column.put(col, null);
		for (String col : statusTypes.INT)
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
