package javaCollect.mySqlConnect;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import javaCollect.mySqlConnect.table.MemberData;
import javaCollect.mySqlConnect.table.statusTypes;
import javaCollect.mySqlConnect.table.statuslist;

public class MemberDAO extends DAO{

	
	public boolean SelectArrListJoin(ArrayList<VO> vos ,String table ,String jointable  , String data ) {
		boolean bRtn = false;
		if (conn.stmtCreate()) {
			// 일단 임시로 사용 
			//String strSQL = SQL.SELECT(table) + SQL.WHERE(column , data) + SQL.JOIN(jointable,column, joinColumn);
			//String strSQL = SQL.SELECT(table) + SQL.JOIN(jointable,column, joinColumn) + SQL.ADDCOL(column, data, jointable, joinColumn);
			String strSQL = String.format("select * from %s A join %s B on A.statusList_status = B.status_id and A.statuslist_useridx = '%s'" , table , jointable , data);
			//String strSQL = String.format("select * from %s A " , table);

			
			logclass.LogWrite("SelectArrListJoin : " + strSQL, 1);
			if (conn.rsQuery(strSQL)) {
				while (true) {
					VO vo = new VO();
					String[] strtable = {table,jointable};
					if(setValues(strtable, vo, conn.getRs())) {
		
//						System.out.println("vo : "+ vo);
						vos.add(vo);
						bRtn = true;
					} else
						break;
				}
			} else
				System.out.println("조회 실패");
		}

		return bRtn;
	}
	

	public MemberVO logIn(String id, String pswd) {
		strLogData = "int isStatus(String id, String pswd) \n";
		String strCol , strData;
		
		MemberVO member = new MemberVO();
		member.vo = SearchData(MemberData.TABLE , MemberData.STR(MemberData.STR_ID) , id);
		if(member.vo == null) {
			strLogData += "ID : " + id +" 존재 X \n";
			logclass.LogWrite(strLogData , 1);
		}
		else {
			if(member.vo.getColumn(MemberData.STR(MemberData.STR_PSWD)).equals(pswd)) {
				//ID 와 PSWD가 맞으면, 등급 출력				

				strData = member.vo.getColumn(MemberData.INT(MemberData.INT_IDX)) ;
				System.out.println("data : "+strData);
				boolean bCheck = SelectArrListJoin(member.statusVos ,statuslist.TABLE , statusTypes.TABLE, strData );
				
				if(bCheck != true) {
					strLogData += id +"님 로그인 권한 LIST 확인 실패 \n";
					logclass.LogWrite(strLogData , 1);
				}


//				for(VO vo : member.statusVos) {			
//					strCol =  statusTypes.INT(statusTypes.INT_ID);
//					strData = vo.getColumn(statuslist.INT(statuslist.INT_STATUS));
//					System.out.println("col : "+strCol);
//					System.out.println("data : "+strData);				
//					bCheck = SelectArrList(member.statusVos ,statusTypes.TABLE ,strCol , strData );
//				}
//
//				
//				if(bCheck != true) {
//					strLogData += id +"님 로그인 권한 타입 확인 실패 \n";
//					logclass.LogWrite(strLogData , 1);
//				}
				

			}
			else {
				strLogData += "PSWD : " + pswd +" 비밀번호가 틀렸습니다. \n";
				logclass.LogWrite(strLogData , 1);
			}
				
		}
		
		return member;
	}

	public Vector getMemberTitleList() {
		MemberVO member = new MemberVO();
		return 	member.getTitle();
	}
	
	public Vector getMemberList() {
		MemberVO member = new MemberVO();
		member.vos = SelectArrList(MemberData.TABLE);

		return 	member.memberList();
	}
	
	public Vector getMemberList(int nCase) {
		MemberVO member = new MemberVO();
		System.out.println("nCase : " + nCase);
		// 권한 종류값부터 가져온다.
		member.vos = SelectArrListOrderby(statuslist.TABLE , statuslist.INT(statuslist.INT_USERIDX));
		
		ArrayList<VO> vos = new ArrayList();
		
		for(VO vo : member.vos ) {
			String strStutes =  vo.getColumn(statuslist.INT(statuslist.INT_STATUS));
			String strStuteIdx =  vo.getColumn(statuslist.INT(statuslist.INT_IDX));
			vo = SearchData(MemberData.TABLE, MemberData.INT(MemberData.INT_IDX) , vo.getColumn(statuslist.INT(statuslist.INT_USERIDX)));
			
			VO statusVO =  SearchData(statusTypes.TABLE, statusTypes.INT(statusTypes.INT_ID) , strStutes);
			
			vo.setColumn(statusTypes.STR(statusTypes.STR_NAME), statusVO.getColumn(statusTypes.STR(statusTypes.STR_NAME)));
			vo.setColumn(statuslist.INT(statuslist.INT_STATUS), strStutes);
			vo.setColumn(statuslist.INT(statuslist.INT_IDX), strStuteIdx);
			System.out.println("strStutes  ::  "+ strStutes);
			if( vo.getColumn(MemberData.STR(MemberData.STR_ID)) != null) {
				if(nCase == 2 && strStutes.equals(statusTypes.BLACKLIST)   )
					vos.add(vo);
				else if(nCase == 0  && strStutes.equals(statusTypes.ASKMEMBER))
					vos.add(vo);
				else if(nCase == 1 && !strStutes.equals(statusTypes.BLACKLIST)  && !strStutes.equals(statusTypes.ASKMEMBER))
					vos.add(vo);
			}

		}	
		member.vos = vos;
		//for(VO vo : member.vos ) {	System.out.println("voString2 : "+ vo);	}
		
		return 	member.memberList();
	}
	
	public Vector getMemberNameList() {
		strLogData = "Vector getMemberList() \n";

		MemberVO member = new MemberVO();

		member.vos = SelectArrList(MemberData.TABLE , MemberData.STR(MemberData.STR_NAME));

		return 	null ;//member.memberList(MemberData.STR(MemberData.STR_NAME));
	}
	
	public String[] getStatusTypeList() {
		strLogData = "Vector getMemberList() \n";

		MemberVO member = new MemberVO();

		member.vos = SelectArrList(statusTypes.TABLE );
		String[] strStatus = new String[member.vos.size()];
		
		//권한 리스트 배열로 출력 
		int nCnt = 0;
		for(VO vo : member.vos) {
			strStatus[nCnt] =  vo.getColumn(statusTypes.STR(statusTypes.STR_NAME));
			nCnt++;
		}
		
		return 	strStatus;//member.memberList(MemberData.STR(MemberData.STR_NAME));
	}

	public boolean isId(String id) {
		strLogData = "boolean isId(String text) \n";
		boolean bRtn = false;
		MemberVO member = new MemberVO();
		
		//member.vo = SearchData(MemberData.TABLE , MemberData.STR(MemberData.STR_ID) , MemberData.STR(MemberData.STR_ID) , id);
		member.vo = SearchData(MemberData.TABLE, MemberData.STR(MemberData.STR_ID) , id);
		
		if(member.vo != null)  // ID가 있으면 True
			bRtn = true;
		
		return bRtn;
	}


	public void memberAdd(VO vo) {
		strLogData = "boolean isId(String text) \n";
		
		//vo
		String strCol = "";	
		String strData = "";
		strCol +=SQL.ADDCOL(MemberData.STR(MemberData.STR_ID), "");
		strData += SQL.ADDDATA(vo.getColumn(MemberData.STR(MemberData.STR_ID)), "");
		
		strCol +=SQL.ADDCOL(MemberData.STR(MemberData.STR_PSWD), ",");
		strData += SQL.ADDDATA(vo.getColumn(MemberData.STR(MemberData.STR_PSWD)), ",");
		
		strCol +=SQL.ADDCOL(MemberData.STR(MemberData.STR_NAME), ",");
		strData += SQL.ADDDATA(vo.getColumn(MemberData.STR(MemberData.STR_NAME)), ",");

		strCol +=SQL.ADDCOL(MemberData.STR(MemberData.STR_EMAIL), ",");
		strData += SQL.ADDDATA(vo.getColumn(MemberData.STR(MemberData.STR_EMAIL)), ",");
		
		strCol +=SQL.ADDCOL(MemberData.STR(MemberData.STR_EXPLAN), ",");
		strData += SQL.ADDDATA(vo.getColumn(MemberData.STR(MemberData.STR_EXPLAN)), ",");
				
		strCol +=SQL.ADDCOL(MemberData.STR(MemberData.STR_BRITHDAY), ",");
		strData += SQL.ADDDATA(vo.getColumn(MemberData.STR(MemberData.STR_BRITHDAY)), ",");
		
		strCol +=SQL.ADDCOL(MemberData.STR(MemberData.STR_LASTIPADDRESS), ",");
		strData += SQL.ADDDATA(vo.getColumn(MemberData.STR(MemberData.STR_LASTIPADDRESS)), ",");
		
		strCol +=SQL.ADDCOL(MemberData.BOOL(MemberData.BOOL_GENDER), ",");
		if(vo.getColumn(MemberData.BOOL(MemberData.BOOL_GENDER)).equals("남자"))
			strData += SQL.ADDDATA("1", ",");
		else
			strData += SQL.ADDDATA("0", ",");
		

		if(setInsert(MemberData.TABLE, strCol, strData)) {
			//가입이 되었으면,
			System.out.println("확인 !!! : "+ "setInsert");
			VO voCheck = SearchData(MemberData.TABLE, MemberData.STR(MemberData.STR_ID) , vo.getColumn(MemberData.STR(MemberData.STR_ID)));

			strCol ="";
			strCol += SQL.ADDCOL(statuslist.INT(statuslist.INT_USERIDX),"");
			strData ="";
			strData += SQL.ADDDATA(voCheck.getColumn(MemberData.INT(MemberData.INT_IDX)), "");
			
			setInsert(statuslist.TABLE, strCol, strData);
			
		}


	}


	public void StatusUpdate(Vector vac , String explan) {
		// selectedValue : 권한 , text : 내용
		//setUpdate
		//System.out.println("vac : "+ vac);
//		System.out.println("statusAAAAA : "+ status);
//		System.out.println("explan : "+ explan);
	
		String changeData = "";
		String whereData = "";
		
		changeData = SQL.SET(statuslist.INT(statuslist.INT_STATUS), (String)vac.get(7));
		whereData = SQL.WHERE( statuslist.INT(statuslist.INT_IDX),(String)vac.get(6));

		setUpdate(statuslist.TABLE, changeData, whereData);

		
		changeData = SQL.SET(MemberData.STR(MemberData.STR_EXPLAN) , explan);
		whereData = SQL.WHERE( MemberData.STR(MemberData.STR_ID),(String)vac.get(0));

		setUpdate(MemberData.TABLE, changeData, whereData);
	}


	@Override
	protected boolean setValues(String table, VO vo, ResultSet rs) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	protected boolean setValues(String[] tableArr, VO vo, ResultSet rs) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	protected boolean setValues(String table, VO vo, ResultSet rs, String col) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	

}
