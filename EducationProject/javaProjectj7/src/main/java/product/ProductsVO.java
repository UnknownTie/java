package product;

public class ProductsVO {
	@Override
	public String toString() {
		return "ProductsVO [Idx=" + Idx + ", Name=" + Name + ", Ver=" + Ver + ", createTime=" + createTime + ", Explain="
				+ Explain + ", Photo=" + Photo + "]";
	}
	private int Idx; // productsIdx
	private String Name; //productsName
	private float Ver; // productscVer
	private String createTime; //productsTime
	private String Explain; //productsExplain
	private String Photo; //productsPhoto
	
	public String getPhoto() {
		return Photo;
	}
	public void setPhoto(String photo) {
		Photo = photo;
	}
	public int getIdx() {
		return Idx;
	}
	public void setIdx(int idx) {
		Idx = idx;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public float getVer() {
		return Ver;
	}
	public void setVer(float ver) {
		Ver = ver;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getExplain() {
		return Explain;
	}
	public void setExplain(String explain) {
		Explain = explain;
	}
	
}
