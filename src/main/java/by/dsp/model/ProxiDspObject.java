package by.dsp.model;

public class ProxiDspObject {
	
	private long colorId;
	private String colorName;
	private boolean colorStructure;
	private boolean colorShow;
	private String colorPicture;
	private String item;
	private String articleName;
	private int materialThickness;
	
	public ProxiDspObject(){
		
	}
	
	
	public long getColorId() {
		return colorId;
	}



	public void setColorId(long colorId) {
		this.colorId = colorId;
	}



	public String getColorName() {
		return colorName;
	}



	public void setColorName(String colorName) {
		this.colorName = colorName;
	}



	public boolean isColorStructure() {
		return colorStructure;
	}



	public void setColorStructure(boolean colorStructure) {
		this.colorStructure = colorStructure;
	}



	public boolean isColorShow() {
		return colorShow;
	}



	public void setColorShow(boolean colorShow) {
		this.colorShow = colorShow;
	}



	public String getColorPicture() {
		return colorPicture;
	}



	public void setColorPicture(String colorPicture) {
		this.colorPicture = colorPicture;
	}



	public String getItem() {
		return item;
	}



	public void setItem(String item) {
		this.item = item;
	}



	public String getArticleName() {
		return articleName;
	}



	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}



	public int getMaterialThickness() {
		return materialThickness;
	}
	
	public boolean isColorIsSaved(){
		return this.colorId==0;
	}
	
	public boolean colorNameNotNull(){
		return this.colorName!=null;
	}

	public boolean colorHasPicture(){
		return this.colorPicture!=null;
	}
	
	public boolean articleNameNotNull(){
		return this.articleName!=null;
	}
	
	public boolean itemNotNull(){
		return this.item!=null;
	}
	
	public void setMaterialThickness(int materialThickness) {
		this.materialThickness = materialThickness;
	}



	public static class Builder{
		
		private ProxiDspObject object;
		
		private Builder(){
			this.object = new ProxiDspObject();
		}
		
		public static Builder build(){
			return new Builder();
		}
		
		public ProxiDspObject getObgect(){
			return this.object;
		}
		
		public Builder setColorId(long id){
			this.object.setColorId(id);
			return this;
		}
		public Builder setColorName(String colorName){
			this.object.setColorName(colorName);
			return this;
		}
		
		public Builder setColorStructure(boolean colorStructure){
			this.object.setColorStructure(colorStructure);
			return this;
		}
		
		public Builder setColorShow(boolean colorShow){
			this.object.setColorShow(colorShow);
			return this;
		}
		
		public Builder setColorPicture(String colorPicture){
			this.object.setColorPicture(colorPicture);
			return this;
		}
		
		public Builder setItem(String item){
			this.object.setItem(item);
			return this;
		}
		
		public Builder setArticleName(String articleName){
			this.object.setArticleName(articleName);
			return this;
		}
		
		public Builder setMaterialThickness(int materialThickness){
			this.object.setMaterialThickness(materialThickness);
			return this;
		}
	}

}
