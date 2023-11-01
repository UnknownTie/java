package DbGroup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import DbGroup.table.MemberData;
import DbGroup.table.statusTypes;
import DbGroup.table.statuslist;
import javaCollect.base.Log;

public class DAO {

	protected ConnectDAO conn = new ConnectDAO();
	protected Log logclass = new Log();
	protected String strLogData = "";
	protected HashMap<String, String> Column = new HashMap<String, String>();
	
	private void logEorr(String addLogData, Exception e) {
		String path = "File : " + System.getProperty("user.dir") + "\n";
		path = path + addLogData;
		logclass.LogWriteError(e, path);
	}

	void setCol(VO vo, String Col, String Data) {
		if (Data != null)
			vo.setColumn(Col, Data);
		else
			System.out.println("setCol data null");
	}

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

	public ArrayList<VO> SelectArrList(String table) {
		ArrayList<VO> vos = new ArrayList<VO>();
		if (conn.stmtCreate()) {
			String strSQL = SQL.SELECT(table);
			//logclass.LogWrite("SelectArrList : " + strSQL, 1);
			if (conn.rsQuery(strSQL)) {
				while (true) {
					VO vo = new VO();
					if (setValues(table, vo, conn.getRs())) {
						vos.add(vo);
					} else
						break;
				}
			} else
				System.out.println("조회 실패");
		}
		return vos;
	}

	public ArrayList<VO> SelectArrList(String table ,String Column) {
		ArrayList<VO> vos = new ArrayList<VO>();
		if (conn.stmtCreate()) {
			String strSQL = SQL.SELECT(table , Column);
			//logclass.LogWrite("SelectArrList : " + strSQL, 1);
			if (conn.rsQuery(strSQL)) {
				while (true) {
					VO vo = new VO();
					if (setValues(table, vo, conn.getRs(), Column)) {
						vos.add(vo);
					} else
						break;
				}
			} else
				System.out.println("조회 실패");
		}
		return vos;
	}
	
	public ArrayList<VO> SelectArrListOrderby(String table ,String Column) {
		ArrayList<VO> vos = new ArrayList<VO>();
		if (conn.stmtCreate()) {
			String strSQL = SQL.SELECT(table);
			strSQL += SQL.ORDERBY(Column);
			logclass.LogWrite("SelectArrListOrderby : " + strSQL, 1);
			if (conn.rsQuery(strSQL)) {
				while (true) {
					VO vo = new VO();
					if (setValues(table, vo, conn.getRs())) {
						vos.add(vo);
					} else
						break;
				}
			} else
				System.out.println("조회 실패");
		}
		return vos;
	}
	
	public ArrayList<VO> SelectArrList(String table ,String WhereCol ,String WhereData ) {
		ArrayList<VO> vos = new ArrayList<VO>();
		if (conn.stmtCreate()) {
			String strSQL = SQL.SELECT(table);
			strSQL += SQL.WHERE(WhereCol, WhereData);
			
			logclass.LogWrite("SelectArrList : " + strSQL, 1);
			if (conn.rsQuery(strSQL)) {
				while (true) {
					VO vo = new VO();
					if (setValues(table, vo, conn.getRs())) {
						vos.add(vo);
					} else
						break;
				}
			} else
				System.out.println("조회 실패");
		}
		return vos;
	}
	
	
	public boolean SelectArrList(ArrayList<VO> vos ,String table ,String Column) {
		boolean bRtn = false;
		if (conn.stmtCreate()) {
			String strSQL = SQL.SELECT(table , Column);
			logclass.LogWrite("SelectArrList : " + strSQL, 1);
			if (conn.rsQuery(strSQL)) {
				while (true) {
					VO vo = new VO();
					if (setValues(table, vo, conn.getRs(), Column)) {
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
	public boolean SelectArrList(ArrayList<VO> vos ,String table ,String Column , String Data) {
		boolean bRtn = false;
		if (conn.stmtCreate()) {
			String strSQL = SQL.SELECT(table) + SQL.WHERE(Column , Data);
			logclass.LogWrite("SelectArrList : " + strSQL, 1);
			if (conn.rsQuery(strSQL)) {
				while (true) {
					VO vo = new VO();
					if (setValues(table, vo, conn.getRs(), Column)) {
						vos.add(vo);
						bRtn = true;
						System.out.println("SelectArrList : " +strSQL );
					} else
						break;
				}
			} else
				System.out.println("조회 실패");
		}
		
		return bRtn;
	}
	
	
	final public boolean SearchData(VO vo ,String table, String Column , String Data) {
		//20230925 다시 생성 
		boolean bRtn = true;
		if (conn.stmtCreate()) {
			String strSQL = SQL.SELECT(table) + SQL.WHERE(Column , Data);
			logclass.LogWrite("SearchData : " + strSQL, 1);
			System.out.println("SEO SearchData 2 : " + strSQL);

			if (conn.rsQuery(strSQL))
				if (!setValues(table, vo, conn.getRs())) {
					bRtn = false;
					System.out.println("없음");
				}
		}
		return bRtn;
	}
	
	final public VO SearchData(String table, String Column , String Data) {
		//20230925 다시 생성 
		VO vo = new VO();
		
		if (conn.stmtCreate()) {
			String strSQL = SQL.SELECT(table) + SQL.WHERE(Column , Data);
			logclass.LogWrite("SearchData : " + strSQL, 1);

			if (conn.rsQuery(strSQL))
				if (!setValues(table, vo, conn.getRs())) {
					vo = null;
					System.out.println("없음");
				}
		}
		return vo;
	}
	
	final public VO SearchData(String table, String ReadColumn ,String Column , String Data) {
		// 추가한 column값만 리턴
		VO vo = new VO();
		
		if (conn.stmtCreate()) {
			String strSQL = SQL.SELECT(table,ReadColumn) + SQL.WHERE(Column , Data);

			logclass.LogWrite("SearchData : " + strSQL, 1);
			if (conn.rsQuery(strSQL))
				if (!setValues(table, vo, conn.getRs())) {
					vo = null;
					System.out.println("없음");
				}
		}
		return vo;
	}
	
	protected boolean setValues(String table, VO vo, ResultSet rs) {
		strLogData = "private void setValues(VO vo, ResultSet rs)  \n ";
		boolean bRtn = false;
		
		try {
			if (conn.getRs().next()) {
				if (table.equals(MemberData.TABLE)) {

					for (String col : MemberData.STR)
						if (rs.getString(col) != null)
							vo.setColumn(col, rs.getString(col));

					for (String col : MemberData.INT)
						if (rs.getString(col) != null)
							vo.setColumn(col, rs.getInt(col));
					
					for (String col : MemberData.BOOL)
						if (rs.getString(col) != null)
							vo.setColumn(col, rs.getBoolean(col));
					bRtn = true;
				} 
				
				if (table.equals(statuslist.TABLE)) {

					for (String col : statuslist.INT) {
						System.out.println("statuslist1 : "+col);
						if (rs.getString(col) != null)
							vo.setColumn(col, rs.getInt(col));
					}

					bRtn = true;
				} 
				
				if (table.equals(statusTypes.TABLE)) {
					System.out.println("statuslist1 : ");
					for (String col : statusTypes.STR) {
						System.out.println("statuslist1 : "+col);
						if (rs.getString(col) != null)
							vo.setColumn(col, rs.getString(col));
					
					}

					for (String col : statusTypes.INT) {
						System.out.println("statusTypes2 : "+col);
						if (rs.getString(col) != null)
							vo.setColumn(col, rs.getInt(col));
					}			
					bRtn = true;
				}

			}
		} catch (SQLException e) {
			bRtn = false;
			strLogData += "vo Data Setting \n";
			logEorr(strLogData, e);
			e.printStackTrace();
		}

		return bRtn;
	}

	protected boolean setValues(String[] tableArr, VO vo, ResultSet rs) {
		strLogData = "private void setValues(VO vo, ResultSet rs)  \n ";
		boolean bRtn = false;
		
		try {
			if (conn.getRs().next()) {
				for(String table : tableArr) {
					if (table.equals(MemberData.TABLE)) {

						for (String col : MemberData.STR)
							if (rs.getString(col) != null)
								vo.setColumn(col, rs.getString(col));

						for (String col : MemberData.INT)
							if (rs.getString(col) != null)
								vo.setColumn(col, rs.getInt(col));
						
						for (String col : MemberData.BOOL)
							if (rs.getString(col) != null)
								vo.setColumn(col, rs.getBoolean(col));
						bRtn = true;
					} 
					
					if (table.equals(statuslist.TABLE)) {

						for (String col : statuslist.INT) {
							if (rs.getString(col) != null)
								vo.setColumn(col, rs.getInt(col));
						}

						bRtn = true;
					} 
					
					if (table.equals(statusTypes.TABLE)) {
						for (String col : statusTypes.STR) {
							if (rs.getString(col) != null)
								vo.setColumn(col, rs.getString(col));
						
						}

						for (String col : statusTypes.INT) {
							if (rs.getString(col) != null)
								vo.setColumn(col, rs.getInt(col));
						}			
						bRtn = true;
					}
				}
			

			}
		} catch (SQLException e) {
			bRtn = false;
			strLogData += "vo Data Setting \n";
			logEorr(strLogData, e);
			e.printStackTrace();
		}

		return bRtn;
	}

	
	private boolean setValues(String table, VO vo, ResultSet rs ,String col) {
		strLogData = "private void setValues(VO vo, ResultSet rs)  \n ";
		boolean bRtn = false;
		
		try {
			if (conn.getRs().next()) {
				if (table.equals(MemberData.TABLE)) {
					vo.setColumn(col, rs.getString(col));
					bRtn = true;
				}
				else if (table.equals(statuslist.TABLE)) {
					vo.setColumn(col, rs.getString(col));
					bRtn = true;
				}
				else if (table.equals(statusTypes.TABLE)) {
					vo.setColumn(col, rs.getString(col));
					bRtn = true;
				}
				
			}
		} catch (SQLException e) {
			bRtn = false;
			strLogData += "vo Data Setting \n";
			logEorr(strLogData, e);
			e.printStackTrace();
		}

		return bRtn;
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

}
