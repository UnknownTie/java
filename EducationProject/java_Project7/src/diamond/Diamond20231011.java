
package diamond; import java.util.Scanner;
public class Diamond20231011 {	
  public static void main(String[] args) {
  System.out.println("시작");
  //-----------------------

  Scanner scanner = new Scanner(System.in);   
  System.out.println("다이아몬드 사이즈를 설정하세요(3 ~ 99)");
  int nMaxLine =  scanner.nextInt(); if(nMaxLine < 3) nMaxLine = 3;	else if(nMaxLine > 99)	nMaxLine = 99;if(nMaxLine % 2 == 0)nMaxLine -= 1; 
  int nCenterLine = (nMaxLine / 2) +1;


  for(int nY = 1 ; nY <= nMaxLine ; nY++) {
    for(int nX = 1 ; nX <= nMaxLine; nX++) {
      if(nY < nCenterLine) {
        if(nX <= (nCenterLine - nY) )System.out.print(" ");
        else if( nX <= (nCenterLine + nY - 1) )	System.out.print("*");
        else break;
      }
      else {
      if(nX <=  (nY - nCenterLine  ) ) System.out.print(" ");
        else if(  nX <= (nMaxLine + (nCenterLine - nY) ) )System.out.print("*"); 
        else break;
      }
    }
    System.out.println("");
  }
  System.out.println("다이아몬드 생성 완료");
  scanner.close();  


  //-----------------------
  System.out.println("종료");
  } 
}
