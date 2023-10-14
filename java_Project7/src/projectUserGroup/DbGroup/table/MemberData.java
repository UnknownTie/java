package projectUserGroup.DbGroup.table;

public interface MemberData {
	// 고정 변수
	static final String TABLE = "members";
	
	// Column
	// String

	static final String[] STR = {"members_id", "members_pswd", 
														"members_name", "members_phone", 
														"members_email", "members_explan", 
														"members_lastLoginIpaddress" , "members_lastLoinTime",
														"members_CreateTime" ,"members_birthday"};
	static String STR(int nCheck) {	return STR[nCheck];}
	
	static final int STR_ID = 0;
	static final int STR_PSWD = 1;
	static final int STR_NAME = 2;
	static final int STR_PHONE = 3;
	static final int STR_EMAIL = 4;
	static final int STR_EXPLAN = 5;
	static final int STR_LASTIPADDRESS = 6;
	static final int STR_LASTLOGINTIME = 7;
	static final int STR_CREATETIME = 8;
	static final int STR_BRITHDAY = 9;
	  
	
	//intsert
	static final String[] INT = { "members_idx" };
	//static final String[] INT = { "members_idx", "members_status" };
	static String INT(int nCheck) {	return INT[nCheck];}
	
	static final int INT_IDX = 0;
	//static final int INT_STATUS = 1;
	
	
	static final String[] BOOL = { "members_genderMan"};
	static String BOOL(int nCheck) {	return BOOL[nCheck];}
	
	static final int BOOL_GENDER = 0;

	
	
	
}
