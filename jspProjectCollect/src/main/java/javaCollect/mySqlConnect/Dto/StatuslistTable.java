package javaCollect.mySqlConnect.Dto;

public interface StatuslistTable {
	
	static final String TABLE = "statuslist";
	static final int BLACKLIST = -9;
	static final int NEWMEMBER = -100;
	
	static final String[] STR = {"statusList_projectName", "members_pswd", 
			"members_name", "members_phone", 
			"members_email", "members_explan", 
			"members_lastLoginIpaddress" , "members_lastLoinTime",
			"members_CreateTime" ,"members_birthday"};
static String STR(int nCheck) {	return STR[nCheck];}

static final int STR_ID = 0;
	
	static final String[] INT = { "statusList_idx", "statusList_userIdx", "statusList_project","statusList_status" };

	static String INT(int nCheck) {	return INT[nCheck];}
	
	static final int INT_IDX = 0;
	static final int INT_USERIDX = 1;
	static final int INT_PROJECT = 2;
	static final int INT_STATUS = 3;
	
	
}
