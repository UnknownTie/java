package user;

public class UsersVO {
	private String Id; //usersId
	private String Pswd; //usersPswd
	private String usersCreaterTime; //usersCreaterTime
	private String usersLastTime; //usersLastTime
	private String usersLastIp; //usersLastIp
	private String usersExplain; //usersExplain
	private int idx; //usersIdx
	private int users_buyersIdx; //users_buyersIdx
	
	
	
	public String getUsersCreaterTime() {
		return usersCreaterTime;
	}
	public void setUsersCreaterTime(String usersCreaterTime) {
		this.usersCreaterTime = usersCreaterTime;
	}
	public String getUsersLastTime() {
		return usersLastTime;
	}
	public void setUsersLastTime(String usersLastTime) {
		this.usersLastTime = usersLastTime;
	}
	public String getUsersLastIp() {
		return usersLastIp;
	}
	public void setUsersLastIp(String usersLastIp) {
		this.usersLastIp = usersLastIp;
	}
	public String getUsersExplain() {
		return usersExplain;
	}
	public void setUsersExplain(String usersExplain) {
		this.usersExplain = usersExplain;
	}

	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPswd() {
		return Pswd;
	}
	public void setPswd(String pswd) {
		Pswd = pswd;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getUsers_buyersIdx() {
		return users_buyersIdx;
	}
	public void setUsers_buyersIdx(int status) {
		this.users_buyersIdx = status;
	}

}
