package javaCollect.diamond_20231011;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class DiamondPaint {
	
	Scanner scanner = new Scanner(System.in); 
	
	// 폴더 : 프로젝트 폴더 선택 -> src -> package 폴더 생성 
	// 폴더 : 프로젝트 폴더 선택 -> src -> class 
	
	//프로젝트 생성 
	public void CreateDiamondeCodeA() {
		
	}
	
	public  void CreateDiamondeCode() {
		
		ArrayList<String> strDiaCode = new ArrayList<String>();
		String path = System.getProperty("user.dir") + "/src/Diamond/";
		System.out.println(path);
		String strCode ="";
		strCode = "";
		strDiaCode.add(strCode);
		// 파일 이름 생성 
		//시간확인을 현재 주소 그대로 사용
		LocalDate nowDay = LocalDate.now(); 	
		// 포맷 변경
	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    String formatedNowDay = nowDay.format(formatter);
    
    String FileName= "Diamond" + formatedNowDay ;
    formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		//기본 pack 및 import 등록 
		strCode = "package diamond; import java.util.Scanner;";
		strDiaCode.add(strCode);
		//class 생성 및 main 생성 
		strCode = "public class "+FileName+" {	\n  public static void main(String[] args) {";
		strDiaCode.add(strCode);
		strCode = "  System.out.println(\"시작\");";
		strDiaCode.add(strCode);
		strCode = "  //-----------------------\n";
		strDiaCode.add(strCode);
		
		ArrayList<String> strSet = new ArrayList<String>();
		//스케너 생성 
		strCode = "Scanner scanner = new Scanner(System.in);   ";
		strSet.add(strCode);
		//범위 지정 및 중간값 체크
		strCode = "System.out.println(\"다이아몬드 사이즈를 설정하세요(3 ~ 99)\");";
		strSet.add(strCode);
		strCode = "int nMaxLine =  scanner.nextInt(); if(nMaxLine < 3) nMaxLine = 3;	else if(nMaxLine > 99)	nMaxLine = 99;if(nMaxLine % 2 == 0)nMaxLine -= 1; ";
		strSet.add(strCode);
		strCode = "int nCenterLine = (nMaxLine / 2) +1;";
		strSet.add(strCode);
		
		//기본 변수 및 조건 설정
		for(String code : strSet)
			strDiaCode.add("  "+code);
		strDiaCode.add("\n");
		
		ArrayList<String> strFor2Code = new ArrayList<String>();
		//다이아몬드 생성 
		strCode ="for(int nY = 1 ; nY <= nMaxLine ; nY++) {";
		strFor2Code.add(strCode);
		strCode ="  for(int nX = 1 ; nX <= nMaxLine; nX++) {";
		strFor2Code.add(strCode);
		strCode ="    if(nY < nCenterLine) {";
		strFor2Code.add(strCode);
		strCode ="      if(nX <= (nCenterLine - nY) )System.out.print(\" \");";
		strFor2Code.add(strCode);
		strCode ="      else if( nX <= (nCenterLine + nY - 1) )	System.out.print(\"*\");";
		strFor2Code.add(strCode);		
		strCode ="      else break;";
		strFor2Code.add(strCode);
		strCode ="    }";
		strFor2Code.add(strCode);
		strCode ="    else {";
		strFor2Code.add(strCode);	
		strCode ="    if(nX <=  (nY - nCenterLine  ) ) System.out.print(\" \");";
		strFor2Code.add(strCode);
		strCode ="      else if(  nX <= (nMaxLine + (nCenterLine - nY) ) )System.out.print(\"*\"); ";
		strFor2Code.add(strCode);
		strCode ="      else break;";
		strFor2Code.add(strCode);	
		strCode ="    }";
		strFor2Code.add(strCode);
		strCode ="  }";
		strFor2Code.add(strCode);
		strCode ="  System.out.println(\"\");";
		strFor2Code.add(strCode);
		strCode ="}";
		strFor2Code.add(strCode);
		strCode ="System.out.println(\"다이아몬드 생성 완료\");";
		strFor2Code.add(strCode);
		
		//스케너 해제 
		strCode = "scanner.close();  ";
		strFor2Code.add(strCode);
		
		//동작 코드 삽입
		for(String code : strFor2Code)
			strDiaCode.add("  "+code);	
		strDiaCode.add("\n");
		

		//class 생성 및 main 해제 
		strCode = "  //-----------------------";
		strDiaCode.add(strCode);		
		strCode = "  System.out.println(\"종료\");";
		strDiaCode.add(strCode);
		strCode = "  } \n}";
		strDiaCode.add(strCode);

		for(String code : strDiaCode)
			System.out.println(code);
		//System.out.println(code +"\n");
		
		try {	
			// 1. 폴더 생성 
			String strFolderPath = "D:\\Log\\";
//			strFolderPath = path;
//	    File file = new File(strFolderPath);
			
	    // 파일 생성

			String logfile = strFolderPath + FileName + ".java";
			FileWriter fw;
	
			fw = new FileWriter(logfile , false);
			BufferedWriter bw = new BufferedWriter(fw); 
			
			for(String code : strDiaCode) {
				//System.out.println(code);
				bw.write(code);
				bw.newLine(); 
			}
	
			bw.flush(); 
			bw.close(); 
			fw.close();		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
	
	
	
	// *으로 다이아몬드 그리기  : TT 단위  us
	// if 조건 : 비교로 인해서 시간이 벌어진것같다
	// Task3_Diamonde1 : 
	// for{for}
	// for문에 break처리가 안되어있다.
	// 5번 		15회 	: 408,553 us
	// 500번 	4회  	: 29,896,950
	// 5000번 	3회  	: 41,881,833
	// break 추가 후
	// 5000번 	3회	 	: 35,530,166 (10ms차이 )
	
	// Task3_Diamonde2 :
	// for{for{} for{}}
	// 5번 		15회 : 397,300 us
	// 500번 	4회  : 397,776,325
	// 5000번 	3회  : 34,645,767,666
	// 5000번 	3회  : 34,571,227,966
	
	// Task3_Diamonde3 :
	// for{for{} for{}}
	// 5번 		15회  	: 321,986 us
	// 500번 	4회 	 	: 400,571,725
	// 5000번 	3회 		: 34,320,038,333
	// 5000번 	3회 		: 34,244,665,300
	
	void Task3_Diamonde1(int nMaxLine) {
		// 나 : 
		// 5번 15회 : 408,553 us
		// 500번 4회  : 29,896,950
		// 5000번 3회  : 41,881,833
		
		
		// 가장큰 값을 기준으로 다이아몬드형태 
		// 짝수입력시, 홀수의 다이아몬드를 만든다.
		// 홀수의 다이아몬드를 만든다.

		//Scanner scanner = new Scanner(System.in); 
		
		System.out.println("다이아몬드 사이즈를 설정하세요(3 ~ 99)");
		
		//int nMaxLine =  scanner.nextInt();
		if(nMaxLine < 3)
			nMaxLine = 3;
		else if(nMaxLine > 99)
			nMaxLine = 99;
		
		if(nMaxLine % 2 == 0)
			nMaxLine -= 1;
		int nCenterLine = (nMaxLine / 2) +1;
		
		for(int nY = 1 ; nY <= nMaxLine ; nY++)
		{
			for(int nX = 1 ; nX <= nMaxLine; nX++)
			{
				if(nY < nCenterLine)
				{
					if(nX <= (nCenterLine - nY) )
						System.out.print(" ");
					else if( nX <= (nCenterLine + nY - 1) )
						System.out.print("*");
					else
						break;
				}
				else 
				{
					if(nX <=  (nY - nCenterLine  ) )
						System.out.print(" ");
					else if(  nX <= (nMaxLine + (nCenterLine - nY) ) )
						System.out.print("*"); 
					else
						break;
				}				
			}
			System.out.println("");
			//System.out.print("*");	
		}
		//scanner.close();
	}
	
	
	void Task3_Diamonde2(int star) {
		// 신성우님 : 
		// 5번 15회 : 397,300 us
		// 500번 4회  : 397,776,325
		// 5000번 3회  : 34,645,767,666
		
    //Scanner scanner =new Scanner(System.in);
    //int star, half;
    int half;
    System.out.println("숫자를 입력하면 숫자 크기만큼 다이아몬드를 만들어볼게요");
    System.out.print("숫자를 입력해보세요 : ");
    System.out.println();
    //star=scanner.nextInt();
    
    if((star%2)==0)star+=1;
    half=((star+1)/2);
    
    for(int i=1; i<=half; i++) {
        //줄만띄워주는녀석
        for(int j=1; j<=(half-i); j++) {
            //j<= <<찍어주는 갯수(반복횟수)
            // half= 홀수로 입력받은값+1의 절반(2사분면)
            // half에서 -1 만큼 공백을 넣기 시작함(2사분면 채우기)
            
            System.out.print("  ");
        }
        for(int k=1; k<=2*i-1; k++) {
            //*을 찍어주는녀석(반복횟수)
            //행의 수는 1부터 홀수니까 홀수만큼 찍어야함.
            System.out.print(" *");
        }
        System.out.println();
    }
    //반대로 돌려서 만들어야함.
    //12시 지났네...
    for(int i=1; i<=half-1; i++) {
        //줄만 띄워줌
        for(int j=1; j<=i; j++) {
            //공백 넣어줌 1 2 3 4 씩해주니까 뭐 안해도됨
            System.out.print("  ");
        }
        for(int k=1; k<=(star-(2*i)); k++) {
            //입력받은 홀수 개에서 짝수만큼씩 덜 찍혀야하니까
            System.out.print(" *");
        }
        System.out.println();
    }
    
    //scanner.close();
	}
	

	void Task3_Diamonde3(int su)
	{
		// 선생님 :
		// 5번 15회 : 321,986 us
		// 500번 4회  : 400,571,725
		// 5000번 3회  : 34,320,038,333
		//int su ;
		//Scanner scanner = new Scanner(System.in);
		System.out.println("다이아몬드의 중간 최대별의 수를 입력하세요? ");
		//su = scanner.nextInt();
			
		if(su % 2 == 0)su++;
		
		for(int i=1; i<=(su/2 + 1); i++) {
			for(int j=1; j<=(su/2 + 1)-i; j++) 
				System.out.print(" ");
			for(int j=1; j<=(2*i - 1); j++)
				System.out.print("*");
			System.out.println("");
		}

		
		for(int i=1; i<=(su/2); i++) {
			for(int j=1; j<=i; j++) 
				System.out.print(" ");
			for(int j=1; j<=(su-2*i); j++)
				System.out.print("*");
			
			System.out.println("");
		}

		  //scanner.close();
	}

}
