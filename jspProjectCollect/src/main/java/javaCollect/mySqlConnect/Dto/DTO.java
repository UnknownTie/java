package javaCollect.mySqlConnect.Dto;

import java.util.HashMap;

public class DTO {

	final String strNullcheck = "미입력";
	final int nNullcheck = -666;
	// bool 저장시 기본 저장명칭
	final String strTrue = "참";
	final String strFalse = "거짓";
	
	protected HashMap<String, String> Column = new HashMap<String, String>();
	protected HashMap<String, String> ColumnTitle = new HashMap<String, String>();
	
	HashMap<String, String> getStrCol(String col) {
		HashMap<String, String> hRtn = new HashMap<String, String>();
		hRtn.put(col, this.Column.get(col));
		return hRtn;
	}


	public boolean setColumn(String Col, String Data) {
		boolean bRtn = false;
		Column.put(Col, Data);
		bRtn = true;
		return bRtn;
	}

	public boolean setColumn(String Col, Integer Data) {
		boolean bRtn = false;
		Column.put(Col, Integer.toString(Data));
		bRtn = true;
		return bRtn;
	}
	
	public boolean setColumn(String Col, boolean Data) {
		boolean bRtn = false;
//		if(Col.equals(MemberData.BOOL(MemberData.BOOL_GENDER))) {		}
		if(Data = true)
			Column.put(Col, strTrue);
		else
			Column.put(Col, strFalse);
		
		bRtn = true;
		return bRtn;
	}

	public String getColumn(String Col) {
		if( Column.get(Col) == null)
			return strNullcheck;
		return Column.get(Col);
	}
	
	public int getNColumn(String Col) {
		if(Column.get(Col) == null)
			return nNullcheck;
		return Integer.parseInt(Column.get(Col));
	}
	
	@Override
	public String toString() {
		return "VO [Column = " + Column +" ]" ;
	}

}
