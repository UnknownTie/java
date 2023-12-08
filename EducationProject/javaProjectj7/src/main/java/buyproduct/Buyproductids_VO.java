package buyproduct;

public class Buyproductids_VO {
	int idx;				//buyProductIdsIdx
	float temp;			//buyProductIdsTemp
	float Humid;		//buyProductIdsHumid
	boolean state;	//buyProductIdsState
	String ckTime;	//buyProductIdsCkTime
	int menagersIdx;//buyProductIds_menagersIdx
	String key;			//buyProductIdsKey
	String explain;	//buyProductIdsExplain
	String photo;	//buyproductidsPhoto
	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public float getTemp() {
		return temp;
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}

	public float getHumid() {
		return Humid;
	}

	public void setHumid(float humid) {
		Humid = humid;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getCkTime() {
		return ckTime;
	}

	public void setCkTime(String ckTime) {
		this.ckTime = ckTime;
	}

	public int getMenagersIdx() {
		return menagersIdx;
	}

	public void setMenagersIdx(int menagersIdx) {
		this.menagersIdx = menagersIdx;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Buyproductids_VO [idx=" + idx + ", temp=" + temp + ", Humid=" + Humid + ", state=" + state + ", ckTime="
				+ ckTime + ", menagersIdx=" + menagersIdx + ", key=" + key + ", explain=" + explain + ", photo=" + photo + "]";
	}

	
}
