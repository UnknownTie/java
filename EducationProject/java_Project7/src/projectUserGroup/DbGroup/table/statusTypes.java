package projectUserGroup.DbGroup.table;

public interface statusTypes {
	
	static final String TABLE = "statustypes";
	static final int nBLACKLIST = -9;
	static final String BLACKLIST = "-1009";
	static final String NEWMEMBER = "-1000";
	static final String ASKMEMBER = "-1001";
	
	static final String[] PROJECTNAME = {"회원", "서버","블랙리스트 화면"};
	static final int[] PROJECTCODE = {1000, 2000,3000};
	
	
	static final String[] STR = {"status_explain", "status_ip","status_name"};
	
	static String STR(int nCheck) {	return STR[nCheck];}
	
	static final int STR_EXPLAIN = 0;
	static final int STR_IP = 1;
	static final int STR_NAME = 2;

	
	
	//intsert
	static final String[] INT = { "status_id", "status_ProjectNum",
																 "status_readLevel", "status_writeLevel",
																 "status_ipReadLevel", "status_ipWriteLevel"};
	
	static String INT(int nCheck) {	return INT[nCheck];}
	
	static final int INT_ID = 0;
	static final int INT_PROJECT = 1;
	
	static final int INT_READ = 2;
	static final int INT_WRITE = 3;
	
	static final int INT_IPREAD = 4;
	static final int INT_IPWRITE = 5;

	
	
}
