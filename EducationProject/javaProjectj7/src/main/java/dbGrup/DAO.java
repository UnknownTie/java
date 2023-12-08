package dbGrup;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.Log;

public class DAO {

	protected ConnectDAO conn = new ConnectDAO();
	protected ResultSet rs = null;
	protected PreparedStatement pstmt = null;
	protected String sql = "";
	
	protected Log logclass = new Log();
	protected String strLogData = "";

	private void logEorr(String addLogData, Exception e) {
		String path = "File : " + System.getProperty("user.dir") + "\n";
		path = path + addLogData;
		logclass.LogWriteError(e, path);
	}
	
	// rs 객체 반납
	public void rsClose() {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {}
			finally {
				pstmtClose();
			}
		}
	}
	
	// pstmt 객체 반납
	public void pstmtClose() {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {}
		}
	}
	
	
	//retrun이 값을 
	//db에 값을 저장 
	//존재 여부 확인 
	//개수 확인 
	
	
	void Ex_DBRead(String strTable) {
		strLogData = "void Ex_DBRead(String strTable)  \n";
		String strSQL = "미입력";
		try {
			if (conn.stmtCreate()) {
				
				strSQL = SQL.SELECT(strTable);
				logclass.LogWrite("DBRead : " + strSQL, 1);
				if (conn.rsQuery(strSQL)) {
					if (conn.getRs().next()) {
						System.out.println("getInt : " + conn.getRs().getInt("idx"));
						System.out.println("getString : " + conn.getRs().getString("name"));
					} else
						logclass.LogWrite(strLogData + "결과 X : " + strSQL, 2);
				}
			}
		} catch (Exception e) {
			logEorr(strLogData, e);
		} finally {
			conn.stmtClose();
			conn.rsClose();
		}
	}

	void DBRead(String strTable, String strColumn, String strCondition) {
		strLogData = "void DBRead(String strTable , String strColumn ,String strCondition) \n";
		String strSQL = "미입력";

		try {
			if (conn.stmtCreate()) {
				strSQL = SQL.SELECT(strTable) + SQL.WHERE(strColumn, strCondition);
				logclass.LogWrite("DBRead : " + strSQL, 1);
				if (conn.rsQuery(strSQL)) {
					if (conn.getRs().next()) {
						System.out.println("getInt : " + conn.getRs().getInt("idx"));
						System.out.println("getString : " + conn.getRs().getString("name"));
					} else
						logclass.LogWrite(strLogData + "결과 X : " + strSQL, 2);
				}
			}

		} catch (Exception e) {
			logEorr(strLogData, e);
		} finally {
			conn.stmtClose();
			conn.rsClose();
		}

	}
	
	public boolean setDelete(String table, String Column,String data) {

		boolean bRtn = false;

		if (conn.stmtCreate()) {
			String strSQL = SQL.DELETE(table, Column, data);

			logclass.LogWrite("setDelete : " + strSQL, 1);
			
			if (conn.Update(strSQL))
				bRtn = true;
		}

		return bRtn;
	}

	public boolean setInsert(String table, String Column,String data) {

		boolean bRtn = false;

		if (conn.stmtCreate()) {
			String strSQL = SQL.INSERT(table, Column, data);

			logclass.LogWrite("setDelete : " + strSQL, 1);
			
			if (conn.Update(strSQL))
				bRtn = true;
		}

		return bRtn;
	}

	
	
	public void setUpdate(String table,String newColumn, String newData ,String whereColumn, String whereData) {
		if (conn.stmtCreate()) {
			String strSQL = SQL.UPDATE(table, newColumn, newData) + SQL.WHERE(whereColumn, whereData);
			
			logclass.LogWrite("setUpdate : " + strSQL, 1);

			if (conn.Update(strSQL))
				System.out.println("변경 완료");
			else
				System.out.println("변경 실패");
		}
	}
	
	public void setUpdate(String table,String newColData, String whereColData) {
		if (conn.stmtCreate()) {
			String strSQL = SQL.UPDATE(table, newColData) + whereColData;
			
			logclass.LogWrite("setUpdate : " + strSQL, 1);

			if (conn.Update(strSQL))
				System.out.println("변경 완료");
			else
				System.out.println("변경 실패");

		}

	}
	
	
	
//
//	public ArrayList<VO> SelectArrList(String table) {
//		ArrayList<VO> vos = new ArrayList<VO>();
//		if (conn.stmtCreate()) {
//			String strSQL = SQL.SELECT(table);
//			//logclass.LogWrite("SelectArrList : " + strSQL, 1);
//			if (conn.rsQuery(strSQL)) {
//				while (true) {
//					VO vo = new VO();
//					if (setValues(table, vo, conn.getRs())) {
//						vos.add(vo);
//					} else
//						break;
//				}
//			} else
//				System.out.println("조회 실패");
//		}
//		return vos;
//	}
//
//	public ArrayList<VO> SelectArrList(String table ,String Column) {
//		ArrayList<VO> vos = new ArrayList<VO>();
//		if (conn.stmtCreate()) {
//			String strSQL = SQL.SELECT(table , Column);
//			//logclass.LogWrite("SelectArrList : " + strSQL, 1);
//			if (conn.rsQuery(strSQL)) {
//				while (true) {
//					VO vo = new VO();
//					if (setValues(table, vo, conn.getRs(), Column)) {
//						vos.add(vo);
//					} else
//						break;
//				}
//			} else
//				System.out.println("조회 실패");
//		}
//		return vos;
//	}
//	
//	public ArrayList<VO> SelectArrListOrderby(String table ,String Column) {
//		ArrayList<VO> vos = new ArrayList<VO>();
//		if (conn.stmtCreate()) {
//			String strSQL = SQL.SELECT(table);
//			strSQL += SQL.ORDERBY(Column);
//			logclass.LogWrite("SelectArrListOrderby : " + strSQL, 1);
//			if (conn.rsQuery(strSQL)) {
//				while (true) {
//					VO vo = new VO();
//					if (setValues(table, vo, conn.getRs())) {
//						vos.add(vo);
//					} else
//						break;
//				}
//			} else
//				System.out.println("조회 실패");
//		}
//		return vos;
//	}
//	
//	public ArrayList<VO> SelectArrList(String table ,String WhereCol ,String WhereData ) {
//		ArrayList<VO> vos = new ArrayList<VO>();
//		if (conn.stmtCreate()) {
//			String strSQL = SQL.SELECT(table);
//			strSQL += SQL.WHERE(WhereCol, WhereData);
//			
//			logclass.LogWrite("SelectArrList : " + strSQL, 1);
//			if (conn.rsQuery(strSQL)) {
//				while (true) {
//					VO vo = new VO();
//					if (setValues(table, vo, conn.getRs())) {
//						vos.add(vo);
//					} else
//						break;
//				}
//			} else
//				System.out.println("조회 실패");
//		}
//		return vos;
//	}
//	
//	
//	public boolean SelectArrList(ArrayList<VO> vos ,String table ,String Column) {
//		boolean bRtn = false;
//		if (conn.stmtCreate()) {
//			String strSQL = SQL.SELECT(table , Column);
//			logclass.LogWrite("SelectArrList : " + strSQL, 1);
//			if (conn.rsQuery(strSQL)) {
//				while (true) {
//					VO vo = new VO();
//					if (setValues(table, vo, conn.getRs(), Column)) {
//						vos.add(vo);
//						bRtn = true;
//					} else
//						break;
//				}
//			} else
//				System.out.println("조회 실패");
//		}
//		
//		return bRtn;
//	}
//	public boolean SelectArrList(ArrayList<VO> vos ,String table ,String Column , String Data) {
//		boolean bRtn = false;
//		if (conn.stmtCreate()) {
//			String strSQL = SQL.SELECT(table) + SQL.WHERE(Column , Data);
//			logclass.LogWrite("SelectArrList : " + strSQL, 1);
//			if (conn.rsQuery(strSQL)) {
//				while (true) {
//					VO vo = new VO();
//					if (setValues(table, vo, conn.getRs(), Column)) {
//						vos.add(vo);
//						bRtn = true;
//						System.out.println("SelectArrList : " +strSQL );
//					} else
//						break;
//				}
//			} else
//				System.out.println("조회 실패");
//		}
//		
//		return bRtn;
//	}
//	
//	
//	final public boolean SearchData(VO vo ,String table, String Column , String Data) {
//		//20230925 다시 생성 
//		boolean bRtn = true;
//		if (conn.stmtCreate()) {
//			String strSQL = SQL.SELECT(table) + SQL.WHERE(Column , Data);
//			logclass.LogWrite("SearchData : " + strSQL, 1);
//			System.out.println("SEO SearchData 2 : " + strSQL);
//
//			if (conn.rsQuery(strSQL))
//				if (!setValues(table, vo, conn.getRs())) {
//					bRtn = false;
//					System.out.println("없음");
//				}
//		}
//		return bRtn;
//	}
//	
//	final public VO SearchData(String table, String Column , String Data) {
//		//20230925 다시 생성 
//		VO vo = new VO();
//		
//		if (conn.stmtCreate()) {
//			String strSQL = SQL.SELECT(table) + SQL.WHERE(Column , Data);
//			logclass.LogWrite("SearchData : " + strSQL, 1);
//
//			if (conn.rsQuery(strSQL))
//				if (!setValues(table, vo, conn.getRs())) {
//					vo = null;
//					System.out.println("없음");
//				}
//		}
//		return vo;
//	}
//	
//	final public VO SearchData(String table, String ReadColumn ,String Column , String Data) {
//		// 추가한 column값만 리턴
//		VO vo = new VO();
//		
//		if (conn.stmtCreate()) {
//			String strSQL = SQL.SELECT(table,ReadColumn) + SQL.WHERE(Column , Data);
//
//			logclass.LogWrite("SearchData : " + strSQL, 1);
//			if (conn.rsQuery(strSQL))
//				if (!setValues(table, vo, conn.getRs())) {
//					vo = null;
//					System.out.println("없음");
//				}
//		}
//		return vo;
//	}
//	
//	protected boolean setValues(String table, VO vo, ResultSet rs) {
//		strLogData = "private void setValues(VO vo, ResultSet rs)  \n ";
//		boolean bRtn = false;
//		
//		try {
//			if (conn.getRs().next()) {
//				if (table.equals(MembersTable.TABLE)) {
//
//					for (MembersTable.STR col : MembersTable.STR.values())
//							vo.setColumn(col.getVar(), rs.getString(col.getVar()));
//					
//					for (MembersTable.INT col : MembersTable.INT.values())
//						vo.setColumn(col.getVar(), rs.getString(col.getVar()));
//					
//					for (MembersTable.BOOL col : MembersTable.BOOL.values())
//						vo.setColumn(col.getVar(), rs.getString(col.getVar()));
//					
//					bRtn = true;
//				} 
//				
//				if (table.equals(StatuslistTable.TABLE)) {
//
//					for (StatuslistTable.INT col : StatuslistTable.INT.values())
//						vo.setColumn(col.getVar(), rs.getString(col.getVar()));
//
//					bRtn = true;
//				} 
//				
//				if (table.equals(StatusTypesTable.TABLE)) {
//					System.out.println("statuslist1 : ");
//					
//					for (StatusTypesTable.STR col : StatusTypesTable.STR.values())
//						vo.setColumn(col.getVar(), rs.getString(col.getVar()));
//				
//					for (StatusTypesTable.INT col : StatusTypesTable.INT.values())
//						vo.setColumn(col.getVar(), rs.getString(col.getVar()));
//					
//					bRtn = true;
//				}
//
//			}
//		} catch (SQLException e) {
//			bRtn = false;
//			strLogData += "vo Data Setting \n";
//			logEorr(strLogData, e);
//			e.printStackTrace();
//		}
//
//		return bRtn;
//	}
//
//	protected boolean setValues(String[] tableArr, VO vo, ResultSet rs) {
//		strLogData = "private void setValues(VO vo, ResultSet rs)  \n ";
//		boolean bRtn = false;
//		
//		try {
//			if (conn.getRs().next()) {
//				for(String table : tableArr) {
//					
//					if (table.equals(MembersTable.TABLE)) {
//
//						for (MembersTable.STR col : MembersTable.STR.values())
//								vo.setColumn(col.getVar(), rs.getString(col.getVar()));
//						
//						for (MembersTable.INT col : MembersTable.INT.values())
//							vo.setColumn(col.getVar(), rs.getString(col.getVar()));
//						
//						for (MembersTable.BOOL col : MembersTable.BOOL.values())
//							vo.setColumn(col.getVar(), rs.getString(col.getVar()));
//						
//						bRtn = true;
//					} 
//					
//					if (table.equals(StatuslistTable.TABLE)) {
//
//						for (StatuslistTable.INT col : StatuslistTable.INT.values())
//							vo.setColumn(col.getVar(), rs.getString(col.getVar()));
//
//						bRtn = true;
//					} 
//					
//					if (table.equals(StatusTypesTable.TABLE)) {
//						System.out.println("statuslist1 : ");
//						
//						for (StatusTypesTable.STR col : StatusTypesTable.STR.values())
//							vo.setColumn(col.getVar(), rs.getString(col.getVar()));
//					
//						for (StatusTypesTable.INT col : StatusTypesTable.INT.values())
//							vo.setColumn(col.getVar(), rs.getString(col.getVar()));
//						
//						bRtn = true;
//					}
//				}
//			
//
//			}
//		} catch (SQLException e) {
//			bRtn = false;
//			strLogData += "vo Data Setting \n";
//			logEorr(strLogData, e);
//			e.printStackTrace();
//		}
//
//		return bRtn;
//	}
//
//	
//	private boolean setValues(String table, VO vo, ResultSet rs ,String col) {
//		strLogData = "private void setValues(VO vo, ResultSet rs)  \n ";
//		boolean bRtn = false;
//		
//		try {
//			if (conn.getRs().next()) {
//				
//				if (table.equals(MembersTable.TABLE)) {
//					vo.setColumn(col, rs.getString(col));
//					bRtn = true;
//				}
//				else if (table.equals(StatuslistTable.TABLE)) {
//					vo.setColumn(col, rs.getString(col));
//					bRtn = true;
//				}
//				else if (table.equals(StatusTypesTable.TABLE)) {
//					vo.setColumn(col, rs.getString(col));
//					bRtn = true;
//				}
//				
//			}
//		} catch (SQLException e) {
//			bRtn = false;
//			strLogData += "vo Data Setting \n";
//			logEorr(strLogData, e);
//			e.printStackTrace();
//		}
//
//		return bRtn;
//	}
	



}
