package buyproduct;

import java.util.ArrayList;

public class BuyProductsVO {
	private int idx; //buyProductsIdx
	private int productsSerial; //buyProductsSerial
	private int usersIdx; //buyProducts_usersIdx
	private int productsIdx; //buyProducts_productsIdx
	private String address; //buyProductsAddress
	private String photo; //buyProductsPhoto
	private String type; //buyProductsType
	private String explain; //buyProductsExplain
	private String linkTime; //buyProductsLinkTime
	
	private String ckTime; //buyproductsCkTime
	private boolean state; //buyproductsState
	private float temp; //buyproductsTemp
	private float humid; //buyproductsHumid
	private ArrayList<Buyproductids_VO> Chartvos = new ArrayList<Buyproductids_VO>();

	public int getIdx() {
		return idx;
	}


	public void setIdx(int idx) {
		this.idx = idx;
	}


	public int getProductsSerial() {
		return productsSerial;
	}


	public void setProductsSerial(int productsSerial) {
		this.productsSerial = productsSerial;
	}


	public int getUsersIdx() {
		return usersIdx;
	}


	public void setUsersIdx(int usersIdx) {
		this.usersIdx = usersIdx;
	}


	public int getProductsIdx() {
		return productsIdx;
	}


	public void setProductsIdx(int productsIdx) {
		this.productsIdx = productsIdx;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getExplain() {
		return explain;
	}


	public void setExplain(String explain) {
		this.explain = explain;
	}


	public String getLinkTime() {
		return linkTime;
	}


	public void setLinkTime(String linkTime) {
		this.linkTime = linkTime;
	}


	public String getCkTime() {
		return ckTime;
	}


	public void setCkTime(String ckTime) {
		this.ckTime = ckTime;
	}


	public boolean isState() {
		return state;
	}


	public void setState(boolean state) {
		this.state = state;
	}


	public float getTemp() {
		return temp;
	}


	public void setTemp(float temp) {
		this.temp = temp;
	}


	public float getHumid() {
		return humid;
	}


	public void setHumid(float humid) {
		this.humid = humid;
	}


	@Override
	public String toString() {
		return "BuyProductsVO [idx=" + idx + ", productsSerial=" + productsSerial + ", usersIdx=" + usersIdx
				+ ", productsIdx=" + productsIdx + ", address=" + address + ", photo=" + photo + ", type=" + type + ", explain="
				+ explain + ", linkTime=" + linkTime + ", ckTime=" + ckTime + ", state=" + state + ", temp=" + temp + ", humid="
				+ humid + "]";
	}


	public ArrayList<Buyproductids_VO> getChartvos() {
		return Chartvos;
	}


	public void setChartvos(ArrayList<Buyproductids_VO> chartvos) {
		Chartvos = chartvos;
	}
	

	
}
