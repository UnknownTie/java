package dbGrup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import common.Log;

public enum  Conn {
	
  conn(Connjavaprojectj7.getConnection());

  //connection 필드
	private Connection connection;
	
	// 생성자 (싱글톤)
  private Conn(Connection connection) {

    this.connection = connection;
  }
  
	// Getter
  public Connection getConnection() {
      return this.connection;
  }


	static class Connjavaprojectj7 {
		private Connection conn;
		private Connjavaprojectj7() {connOpen();}

		private static final Connjavaprojectj7 instance = new Connjavaprojectj7();

		public static Connection getConnection() {
			return instance.conn;
		}
	
		private void connOpen() {
			Log logclass = new Log();
			String strLogData = "void connOpen() \n";
			final String Url_Driver = "com.mysql.jdbc.Driver";
			final String Url_DB = "jdbc:mysql://localhost:3306/javaprojectj7";
			final String User = "root";
			final String Pswd = "1234";
	
			try {
				// 1. JDBC 드라이버 검색
				Class.forName(Url_Driver);
				logclass.LogWrite("드라이버 검색 성공", 2);
	
				// 2-2 DB 연결
				conn = DriverManager.getConnection(Url_DB, User, Pswd);
	
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

	


}
