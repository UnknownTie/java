package study.test;

public class ArrTest {
	
	public void ArrTest1() {
		//빈 배열 사용 
		String[] strArr = {};
		String[] strArrA = {""};
		//배열 사용 예시
		String ckStrings = ""; 
		strArr = strArrA;
		if(strArr.length > 0 ) {
			for(String ckString : strArr) {
				ckStrings += ckString + "/";
				System.out.println("A : " + strArr.length );
			}
		}
		else {
			System.out.println("B : " + strArr.length);
		}
		
		
	}

}
