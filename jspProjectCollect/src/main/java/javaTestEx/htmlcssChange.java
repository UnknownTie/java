package javaTestEx;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Stack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





@WebServlet("/HtmlChange")
public class htmlcssChange extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service ()");
		
		request.setCharacterEncoding("utf-8"); //이클립스 console 
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8;");
		// response getWriter로 가져오기전에 char 세팅을 해줘야된다.
		PrintWriter out ;
		out = response.getWriter();
		out.println("service ()<br/><br/>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\""+request.getContextPath()+"/css/test.css\" >\r\n");
		
		String path = request.getParameter("filePath");
		
		if(!path.isEmpty()) {
			htmlchange(request.getParameter("filePath"));
		}

		
		out.println("<p><a href='"+request.getParameter("path")+"'>돌아가기</a></p>");
	}
	
	public static String logfolder = "D://Log/";
	
	public void htmlchange(String strHtmlPath) {
		try {
			System.out.println("strHtmlPath : "+ strHtmlPath);
			
			if(true)
				return;
			String strLog ="aa";
				
			// 2. 파일
			// 파일 생성
			String logfileR = strHtmlPath;
			String logfile = strHtmlPath;
//			File outFile = new File(logfileR);
			FileWriter fw = new FileWriter(logfile, true);
			BufferedReader br = new BufferedReader(new FileReader(logfileR));
//			BufferedReader br = new BufferedReader(fr);
			BufferedWriter bw = new BufferedWriter(fw);
			
			String line;
			int nCnt =0;
			int nTabCnt =0;
			String strTagTypeCk[] = {"img","br","source","hr" ,"input","!--","link" ,"meta","!DOCTYPE"};
			//img , br , source , hr
			while((line = br.readLine()) != null) {
				//초기화
				String strWr ="";
				int ArrMax = 10;
				String strCk[] = new String[ArrMax];
				boolean bCk[]  =  new boolean[ArrMax];
				ArrayList<String> strTag = new ArrayList<String>();
				
				for(int i=0 ; i < ArrMax; i++) {
					strCk[i] ="";
					bCk[i] = false;
				}
				
				//조건 시작
				//<태그    > + /n
				// tabCnt ++ 
				//tab은 태그 와 태그 사이에 한개씩 추가 
				// tabCnt --
				// /n + </태그 > + /n
				//일단 >뒤는 모두 +/n
				//img , br , source , hr
				
				for(int i =0; i<line.length();i++ ) {
//					line.charAt(i);
	
					String strWrSub = "";
		
					
					//1. </ ..... >
					if(line.charAt(i) == '<') {
						
						if((i + 1 )< line.length()) {
							if( line.charAt(i+1) =='/') {		
								//strTag.remove(strTag.size()-1);
								int nSkip = line.indexOf(">",i) +1;
								strWrSub = line.substring(i, nSkip);
//								i += nSkip-1;
								nTabCnt--;
//								strWrSub = "  ".repeat(nTabCnt)+ strWrSub +"\n";
								strWrSub = "\n" +"  ".repeat(nTabCnt)+ strWrSub+"\n" ;
								System.out.println(" 1 : " + strWrSub);
							}
							else {
								int ntagSub;
								int ntagSub1 = line.indexOf(" ",i);
								int ntagSub2 = line.indexOf(">",i);
								String addTag ;
								if(ntagSub1 < ntagSub2)
									ntagSub = ntagSub1;
								else
									ntagSub = ntagSub2;
									
								addTag = line.substring(i+1, ntagSub);
								// <fieldset>
								boolean bTagType = false;
								
								for(String strTagType : strTagTypeCk) {
									if(addTag.contains(strTagType))
										bTagType = true;
								}
								
								int nSkip = ntagSub2 +1;;
								strWrSub = line.substring(i, nSkip);
								System.out.println(" 2sub : " + strWrSub);
//								i += nSkip;
//								strWrSub = "\n" +"  ".repeat(nTabCnt)+ strWrSub +"\n";
								strWrSub = "  ".repeat(nTabCnt)+ strWrSub +"\n";
								System.out.println(" 2 : " + strWrSub);
								if(bTagType == false) {
									nTabCnt++;
									System.out.println(" 2f : " + strWrSub);
								}
			

							}
						}		
					}
					else {
					//	strWrSub = Character.toString(line.charAt(i)) ;

					}



					strWr += strWrSub ;
//					bw.write(strWrSub);
				}
				
				System.out.println("a : "+strWr);
				bw.write(strWr);
				
				bw.newLine();
				
				nCnt++;
			}

			String Logcontent = strLog;




			bw.flush();
			bw.close();
			fw.close();

		} catch (Exception e) {
			e.printStackTrace(); // 에러의 발생근원지를 찾아서 단계별 애러 출력
		}
		
	}
	
}
