package javaCollect.mySqlConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javaCollect.base.Log;



public class Conn {
	private static Connection CONN;

//생글톤 생성 
	// 1. 객체를 외부에서 생성이 안되도록 private 접근제한자로 사용
	private Conn() {
		connOpen();
	}
	// 2. 정적 필드를 선언하면서 객체를 생성

	private static final Conn SINGLETONDAO = new Conn();

	// 3. 외부에서 호출하는 정적 Geter 메소드 생성
	public static Connection getConnection() {
		return SINGLETONDAO.CONN;
	}

	private static void connOpen() {
		Log logclass = new Log();
		String strLogData = "void connOpen() \n";
		final String Url_Driver = "com.mysql.jdbc.Driver";
		final String Url_DB = "jdbc:mysql://localhost:3306/javaproject7";
		final String User = "root";
		//final String User = "atom";
		final String Pswd = "1234";

		try {
			// 1. JDBC 드라이버 검색
			Class.forName(Url_Driver);
			logclass.LogWrite("드라이버 검색 성공", 2);

			// 2-2 DB 연결
			CONN = DriverManager.getConnection(Url_DB, User, Pswd);

			strLogData += "DB 연결 연결 \n";
			strLogData += "URL_DRIVER : " + Url_Driver + "\n";
			strLogData += "URL : " + Url_DB + "\n";
			strLogData += "USER : " + User + "\n";
			logclass.LogWrite(strLogData, 2);

		} catch (ClassNotFoundException e) {

			strLogData += "File : " + System.getProperty("user.dir") + "\n";
			strLogData += "드라이버 검색 실패 \n";
			strLogData += "URL_DRIVER : " + Url_Driver;
			logclass.LogWriteError(e, strLogData);
		} catch (SQLException e) {
			strLogData += "File : " + System.getProperty("user.dir") + "\n";
			strLogData += "DB 연결 실패 \n";
			strLogData += "URL : " + Url_DB + "\n";
			strLogData += "USER : " + User + "\n";
			strLogData += "PSWD : " + Pswd;
			logclass.LogWriteError(e, strLogData);
		} catch (Exception e) {
			strLogData += "File : " + System.getProperty("user.dir") + "\n";
			strLogData += "";
			logclass.LogWriteError(e, strLogData);
		}

		logclass = null;
	}

}
