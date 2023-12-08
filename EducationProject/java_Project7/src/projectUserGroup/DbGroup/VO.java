package projectUserGroup.DbGroup;

import java.util.HashMap;

import projectUserGroup.DbGroup.table.MemberData;

public class VO {

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
		if(Col.equals(MemberData.BOOL(MemberData.BOOL_GENDER))) {
			if(Data = true)
				Column.put(Col, "남자");
			else
				Column.put(Col, "여자");
		}	
		bRtn = true;
		return bRtn;
	}

	public String getColumn(String Col) {
		if( Column.get(Col) == null)
			return "-999";
		return Column.get(Col);
	}
	
	public int getNColumn(String Col) {
		if(Column.get(Col) == null)
			return -999;
		return Integer.parseInt(Column.get(Col));
	}


	@Override
	public String toString() {
		return "VO [Column=" + Column ;
	}

}
