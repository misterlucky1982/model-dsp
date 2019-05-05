package by.dsp.model;

public class Material implements FullName, Comparable, TransferObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color color;
	private int thickness;
	
	public Material(){
		this.color = new Color();
	}
	
	public Material(Color color){
		this.color = color;
	}
	
	public Material(String name){
		this(new Color(name));
	}
	
	public Material(Color color, int thickness){
		this.color = color;
		this.setThickness(thickness);
	}
	
	public Material(String colorName, int thickness){
		this.color = new Color(colorName);
		this.setThickness(thickness);
	}
	
	public void setColor(Color color){
		this.color = color;
	}
	
	public void setColor(String colorName){
		this.color = new Color(colorName);
	}
	
	public Color getColor(){
		return this.color;
	}
	
	public void setThickness(int thickness){
		if(thickness<0)thickness = 0;
		this.thickness = thickness;
	}
	
	public int getThickness(){
		return this.thickness;
	}
	
	
	@Override
	public boolean equals(Object ob){
		if(ob==null)return false;
		if(!ob.getClass().equals(this.getClass()))return false;
		if(!((Material)ob).getColor().equals(this.color))return false;
		if(this.thickness!=((Material)ob).getThickness())return false;
		return true;
	}
	
	@Override
	public int hashCode(){
		return this.color.hashCode()+this.thickness;
	}
	
	@Override
	public String toString(){
		return this.color.getName()+", "+this.thickness+"mm"+", st:"+this.color.getStructue();
	}
	
	public boolean isDefaultValue(){
		if(this.color == null)return true;
		return this.color.isDefaultValue();
	}

	public String getFullNameInLine() {
		return this.color.getName()+" "+this.thickness+"mm";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return this.getFullNameInLine().compareTo(((FullName)o).getFullNameInLine());
	}

}