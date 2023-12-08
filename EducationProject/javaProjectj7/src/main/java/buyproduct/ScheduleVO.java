package buyproduct;

public class ScheduleVO {
	private int Idx;
	private int DiviceId;
	private String UserId;
	private String Time;
	private String CreateTime;
	private String Memo;
	
	public int getIdx() {
		return Idx;
	}

	public void setIdx(int idx) {
		Idx = idx;
	}

	public int getDiviceId() {
		return DiviceId;
	}

	public void setDiviceId(int diviceId) {
		DiviceId = diviceId;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

	public String getMemo() {
		return Memo;
	}

	public void setMemo(String memo) {
		Memo = memo;
	}

	@Override
	public String toString() {
		return "ScheduleVO [Idx=" + Idx + ", DiviceId=" + DiviceId + ", UserId=" + UserId + ", Time=" + Time
				+ ", CreateTime=" + CreateTime + ", Memo=" + Memo + "]";
	}
	
	
}
