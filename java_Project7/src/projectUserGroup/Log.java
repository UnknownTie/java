package projectUserGroup;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
//import java.time.ZoneId;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Log {

	public static final int LOG_LEVEL = -99;
	public static String logfolder = "D://Log/"; // LOG 저장 위치
//LEVEL이 높을수록 보이는 양이 적어진다.
//Deg를 위해 필요한 경우, 낮은 숫자를 써야된다.
//-99 : 모든 수준을 나눠서 저장한다. (_0,_1,_2,_3,_4,_5,_All) 
//0 : 수준 지정 X 
//1 : 잡 ( 코드의 시작과 끝을 모두 잡는 위치 )
//2 : Data 통신 ( 주고 받은 명령 , 연결해제 )
//3 : Debug를 위한 위치 
//4 : 
//5 : 중요한 Data값 ( 오류 상황 관련 값 )

	public String GetFutionName() {
		String path;
		path = Thread.currentThread().getStackTrace()[2].getClass().getName();
		path = path + " : " + Thread.currentThread().getStackTrace()[2].getClass().getEnclosingClass().getName(); // 함수

		return path;
	}

	public void FolderCheck(String strFolderPath) {
		// 처음 폴더 존재여부 확인 "
		File file = new File(strFolderPath);

		if (!file.exists()) // 폴더가 없다면 생성한다.
			FolderCreate(strFolderPath, strFolderPath);

	}

	public void FolderCreate(String strOrgFolderPath, String strCheckFolderPath) {

		File file = new File(strCheckFolderPath);

		if (file.exists()) {
			// 폴더 존재 o
			if (strOrgFolderPath.equals(strCheckFolderPath) == false) {
				// 원하는 폴더와 동일한 위치가 아니면 다시 생성한다.
				int npathlength = strCheckFolderPath.length();
				int nFolderF = strOrgFolderPath.indexOf("/", npathlength);

				String strFolderPath = strOrgFolderPath;
				if (nFolderF > 0)
					strFolderPath = strFolderPath.substring(0, (nFolderF + 1));

				FolderCreate(strOrgFolderPath, strFolderPath);
			}

		} else {
			// 폴더 존재 X
			int nFolderF = 0;

			if (strOrgFolderPath.equals(strCheckFolderPath) == true)
				// 원하는 폴더와 동일한 위치면 처음부터 확인한다.
				nFolderF = strCheckFolderPath.indexOf("/");
			else {
				int npathlength = strCheckFolderPath.length();
				nFolderF = strOrgFolderPath.indexOf("/", (npathlength));
			}

			// 폴더를 생성한다.
			file.mkdir();

			String strFolderPath = strOrgFolderPath;
			if (nFolderF > 0) // 정상적으로 위치를 찾았다면, 해당 위치까지 다시 확인
				strFolderPath = strFolderPath.substring(0, (nFolderF));

			FolderCreate(strOrgFolderPath, strFolderPath);

		}

	}

	public void LogWriteError(Exception e, String Path) {

		try {
			// SW테스트용 , 실제 적용시 삭제
			System.out.println("=".repeat(20) + "S");
			e.printStackTrace();
			System.out.println(Path);
			System.out.println("-".repeat(20) + "E");
//    String ClassName = new Object(){}.getClass().getEnclosingClass().getName(); 
//    String MethodName = new Object(){}.getClass().getEnclosingMethod().getName();
//    System.out.println("ClassName :  " + ClassName); // 에러 내용과 원인 출력 
//    System.out.println("MethodName  :  " + MethodName); // 에러 내용과 원인 출력 

			// 1. 폴더
			// 폴더 확인 및 생성
			FolderCheck(logfolder);

			// 2. 파일
			// 시간확인을 현재 주소 그대로 사용
			LocalDate nowDay = LocalDate.now();
			// 시간확인을 특정 주소 기준으로 사용
			// LocalDate nowDay = LocalDate.now(ZoneId.of("Asia/Seoul"));
			// 포맷 변경

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String formatedNowDay = nowDay.format(formatter);
			// 파일 생성
			String logfile = logfolder + "log_" + formatedNowDay + "_Error.log";
			FileWriter fw;

			fw = new FileWriter(logfile, true);

			BufferedWriter bw = new BufferedWriter(fw);

			String Logcontent = "null";

			LocalTime nowTime = LocalTime.now();
			formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
			String formatedNowTime = nowTime.format(formatter);

			Logcontent = "-------------------------------------------------------";
			bw.write(Logcontent);
			bw.newLine();
			// 현재 시간 입력
			Logcontent = formatedNowDay + " " + formatedNowTime;
			bw.write(Logcontent);
			bw.newLine();
			bw.write(Path); // 위치
			bw.newLine();
			bw.newLine();

			// 애러 원인 및 내용 입력
			Logcontent = e.toString();
			bw.write(Logcontent);
			bw.newLine();

			// 에러 발생 위치 내용 입력
			StackTraceElement[] elem = e.getStackTrace();
			for (int i = 0; i < elem.length; i++) {
				Logcontent = "" + elem[i];
				bw.write(Logcontent);
				bw.newLine();
			}
			bw.newLine();

			bw.flush();
			bw.close();
			fw.close();

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void LogWrite(String strLog) {
		try {
			// 1. 폴더
			// 폴더 확인 및 생성
			FolderCheck(logfolder);

			// 2. 파일
			// 시간확인을 현재 주소 그대로 사용
			LocalDate nowDay = LocalDate.now();
			// 시간확인을 특정 주소 기준으로 사용
			// LocalDate nowDay = LocalDate.now(ZoneId.of("Asia/Seoul"));
			// 포맷 변경
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String formatedNowDay = nowDay.format(formatter);
			// 파일 생성
			String logfile = logfolder + "log_" + formatedNowDay + ".log";
			FileWriter fw = new FileWriter(logfile, true);
			BufferedWriter bw = new BufferedWriter(fw);

			String Logcontent = strLog;

			LocalTime nowTime = LocalTime.now();
			formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
			String formatedNowTime = nowTime.format(formatter);

			// 현재 시간 입력 후 log 남김
			Logcontent = formatedNowDay + " " + formatedNowTime + " : " + strLog;

			bw.write(Logcontent);
			bw.newLine();

			bw.flush();
			bw.close();
			fw.close();

		} catch (Exception e) {
			e.printStackTrace(); // 에러의 발생근원지를 찾아서 단계별 애러 출력
		}

	}

	public void LogWrite(String strLog, int nlevel) {
		try {
			System.out.println("=".repeat(20) + "S");
			System.out.println(strLog); // SW테스트용 , 실제 적용시 삭제
			System.out.println("-".repeat(20) + "E");

			if (LOG_LEVEL > nlevel && LOG_LEVEL != -99)
				return;

			// 1. 폴더
			// 폴더 확인 및 생성
			FolderCheck(logfolder);

			// 2. 파일
			// 시간확인을 현재 주소 그대로 사용
			LocalDate nowDay = LocalDate.now();
			// 시간확인을 특정 주소 기준으로 사용
			// LocalDate nowDay = LocalDate.now(ZoneId.of("Asia/Seoul"));
			// 포맷 변경
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String formatedNowDay = nowDay.format(formatter);
			// 파일 생성
			String logfile = "log";

			if (LOG_LEVEL == -99)
				logfile = logfolder + "log_" + formatedNowDay + "_" + nlevel + ".log";
			else
				logfile = logfolder + "log_" + formatedNowDay + ".log";

			FileWriter fw = new FileWriter(logfile, true);
			BufferedWriter bw = new BufferedWriter(fw);

			String Logcontent = strLog;

			LocalTime nowTime = LocalTime.now();
			formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
			String formatedNowTime = nowTime.format(formatter);

			// 현재 시간 입력 후 log 남김
			Logcontent = formatedNowDay + " " + formatedNowTime + "( " + nlevel + " ) : " + strLog;

			bw.write(Logcontent);
			bw.newLine();

			bw.flush();
			bw.close();
			fw.close();

		} catch (Exception e) {
			e.printStackTrace(); // 에러의 발생근원지를 찾아서 단계별 애러 출력
		}

	}

	public void LogWriteType(String strLog, String Type) {
		try {

			// 1. 폴더
			// 폴더 확인 및 생성
			FolderCheck(logfolder);

			// 2. 파일
			// 시간확인을 현재 주소 그대로 사용
			LocalDate nowDay = LocalDate.now();
			// 시간확인을 특정 주소 기준으로 사용
			// LocalDate nowDay = LocalDate.now(ZoneId.of("Asia/Seoul"));
			// 포맷 변경
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String formatedNowDay = nowDay.format(formatter);
			// 파일 생성
			String logfile = logfolder + "log_" + formatedNowDay + "_" + Type + ".log";
			;

			FileWriter fw = new FileWriter(logfile, true);
			BufferedWriter bw = new BufferedWriter(fw);

			String Logcontent = strLog;

			LocalTime nowTime = LocalTime.now();
			formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
			String formatedNowTime = nowTime.format(formatter);

			// 현재 시간 입력 후 log 남김
			Logcontent = formatedNowDay + " " + formatedNowTime + " : " + strLog;

			bw.write(Logcontent);
			bw.newLine();

			bw.flush();
			bw.close();
			fw.close();

		} catch (Exception e) {
			e.printStackTrace(); // 에러의 발생근원지를 찾아서 단계별 애러 출력
		}

	}

	public void LogWriteType(String strLog, String strExplanation, String strType) {
		try {
			// 1. 폴더
			// 폴더 확인 및 생성
			FolderCheck(logfolder);

			// 2. 파일
			// 시간확인을 현재 주소 그대로 사용
			LocalDate nowDay = LocalDate.now();
			// 시간확인을 특정 주소 기준으로 사용
			// LocalDate nowDay = LocalDate.now(ZoneId.of("Asia/Seoul"));
			// 포맷 변경
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String formatedNowDay = nowDay.format(formatter);
			// 파일 생성
			String logfile = logfolder + "log_" + formatedNowDay + "_" + strType + ".log";
			;

			FileWriter fw = new FileWriter(logfile, true);
			BufferedWriter bw = new BufferedWriter(fw);

			String Logcontent = strLog;

			LocalTime nowTime = LocalTime.now();
			formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
			String formatedNowTime = nowTime.format(formatter);

			// 현재 시간 입력 후 log 남김
			Logcontent = formatedNowDay + " " + formatedNowTime + " : " + strExplanation;
			bw.write(Logcontent);
			bw.newLine();
			Logcontent = strLog;

			bw.write(Logcontent);
			bw.newLine();

			bw.flush();
			bw.close();
			fw.close();

		} catch (Exception e) {
			e.printStackTrace(); // 에러의 발생근원지를 찾아서 단계별 애러 출력
		}

	}

}
