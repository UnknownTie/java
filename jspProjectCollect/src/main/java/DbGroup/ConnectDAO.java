package DbGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javaCollect.base.Log;

public class ConnectDAO {

	private final Connection conn = Conn.getConnection();
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private Log logclass = new Log();
	private String strLogData = "";

	private void logEorr(String addLogData, Exception e) {
		String path = "File : " + System.getProperty("user.dir") + "\n";
		path = path + addLogData;
		logclass.LogWriteError(e, path);
	}

	// Statement
	boolean stmtCreate() {
		boolean bRtn = false;
		strLogData = "boolean stmtCreate() \n";

		if (conn == null) {
			logclass.LogWrite(strLogData + "conn null ", 2);
			return bRtn;
		}

		try {
			if (stmt != null)
				stmtClose();

			stmt = conn.createStatement();
			bRtn = true;
		} catch (Exception e1) {
			bRtn = false;
			if (stmt != null)
				stmtClose();
			logEorr(strLogData + "stmt 연결 실패", e1);
		}
		return bRtn;
	}

	void stmtClose() {
		strLogData = "void stmtClose() \n";

		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
				logclass.LogWrite(strLogData + "stmt 해제", 2);
			} else
				logclass.LogWrite(strLogData + "stmt : null ", 2);

		} catch (Exception e1) {
			logEorr(strLogData + "stmt 해제 실패", e1);
		}
	}

	// ResulteSet
	ResultSet getRs() {
		return this.rs;
	}

	boolean rsQuery(String sql) {
		boolean bRtn = false;
		strLogData = "boolean rsQuery(String sql) \n";

		if (stmt == null) {
			logclass.LogWrite(strLogData + "stmt null ", 2);
			return bRtn;
		}

		try {
			// conn 연결되어 있어야 처리됨
			if (rs != null)
				rsClose();

			rs = stmt.executeQuery(sql);
			bRtn = true;

		} catch (Exception e1) {
			bRtn = false;
			if (rs != null)
				rsClose();
			strLogData += "sql : " + sql + "\n";
			logEorr(strLogData + "rs Query 생성 실패 ", e1);

		}

		return bRtn;
	}

	boolean Update(String sql) {
		boolean bRtn = false;
		strLogData = "boolean Update(String sql) \n";

		if (stmt == null) {
			logclass.LogWrite(strLogData + "stmt null ", 2);
			return bRtn;
		}

		try {
			if (stmt.executeUpdate(sql) != 0) {
				bRtn = true;
				logclass.LogWrite(strLogData + "stmt Update", 2);
			} else
				logclass.LogWrite(strLogData + "sql : " + sql + "\n stmt Update 실패 ", 2);

		} catch (Exception e1) {
			bRtn = false;
			if (rs != null)
				rsClose();
			strLogData += "sql : " + sql + "\n";
			logEorr(strLogData + "stmt Update 실패 ", e1);
		}

		return bRtn;
	}

	void rsClose() {
		strLogData = "void rsClose() \n";

		try {
			if (rs != null) {
				rs.close();
				rs = null;
				logclass.LogWrite(strLogData + "rs 해제", 2);
			} else
				logclass.LogWrite(strLogData + "rs : null ", 2);

		} catch (Exception e1) {
			logEorr(strLogData + "rs 해제 실패 ", e1);
		}

	}

//	PreparedStatement 생성 필요
	boolean pstmtCreate(String strSQL ,String[] column  ,String[] data) {
		boolean bRtn = false;
		strLogData = "	boolean pstmtCreate(String strSQL ,String[] column  ,String[] data) \n";
		
		if(conn == null) {
			logclass.LogWrite(strLogData + "conn null ", 2);
			return bRtn;
		}
		
		try {	
			if(pstmt !=null) 
				stmtClose();
			String sql = strSQL; 
			for(String colType : column) 
				sql += (colType + "= ? ,");
			sql = sql.substring(0,sql.length()-1); // 맨뒤의 , 은 제거 
			//
			pstmt = conn.prepareStatement(sql);

			for(int i = 1; i<= data.length; i++) 
				pstmt.setString(i, data[i]);

			//pstmt.executeUpdate(sql);
			//pstmt.executeQuery(sql);
			
			bRtn = true;
		} 
		catch (Exception e1) {
			bRtn = false;
			if(stmt !=null) 
				stmtClose();
			logEorr(strLogData + "pstmt 연결 실패", e1);
		}		
		
		return bRtn;		 	
	}
	
//	boolean pstmtCreateJoin(String strSQL ,String[] column  ,String[] data ,String jointable ,String[] joinColumn  ,String[] joinData) {
//		boolean bRtn = false;
//		strLogData = "	boolean pstmtCreateJoin(String strSQL ,String[] column  ,String[] data ,String jointable ,String[] joinColumn  ,String[] joinData) \n";
//		
//		if(conn == null) {
//			logclass.LogWrite(strLogData + "conn null ", 2);
//			return bRtn;
//		}
//		
//		try {	
//			if(pstmt !=null) 
//				stmtClose();
//
//			String sql = strSQL;
//			sql = "update hoiwon set ";
//			
//			for(String colType : column) 
//				sql += (colType + "= ? ,");
//			sql = sql.substring(0,sql.length()-1); // 맨뒤의 , 은 제거 
//			sql += " join " + jointable;
//			
//			pstmt = conn.prepareStatement(sql);
//
//			for(int i = 0; i< data.length; i++) 
//				pstmt.setString(i, data[i]);
//
//			bRtn = true;
//		} 
//		catch (Exception e1) {
//			bRtn = false;
//			if(stmt !=null) 
//				stmtClose();
//			logEorr(strLogData + "pstmt 연결 실패", e1);
//		}		
//		
//		return bRtn;		 	
//	}
	
	
	
	// 전체 Close
	void Close() {
		stmtClose();
		rsClose();
	}

}
