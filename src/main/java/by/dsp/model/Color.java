package by.dsp.model;

public class Color implements FullName{
	
	private String name;
	private boolean texture;
	public static final String UNDEFINED_COLOR = "undefined";
	public static final String DEFAULT_COLOR = "default";
	
	public Color(){
		this.name = UNDEFINED_COLOR;
	}
	
	public Color(String name){
		this.name = name;
	}
	
	public Color(boolean isDefaultValue){
		if(isDefaultValue){
			this.name = DEFAULT_COLOR;
		}else{
			this.name = UNDEFINED_COLOR;
		}
	}
	
	public Color(String name, boolean texture){
		this.texture = texture;
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setStructure(boolean texture){
		this.texture = texture;
	}
	
	public boolean getStructue(){
		return this.texture;
	}
	
	@Override
	public boolean equals(Object ob){
		if(ob==null)return false;
		if(!ob.getClass().equals(this.getClass()))return false;
		if(((Color)ob).getName().equals(UNDEFINED_COLOR))return false;
		if(((Color)ob).getStructue()==this.texture){
			if(((Color)ob).getName().equals(this.name))return true;
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		int temp = this.name.hashCode();
		if(this.texture)temp++;
		return temp;
	}
	
	@Override
	public String toString(){
		return this.name+", st:"+this.texture;
	}
	
	public boolean isDefaultValue(){
		return(this.name.equals(DEFAULT_COLOR)||this.name.equals(UNDEFINED_COLOR));
	}

	public String getFullNameInLine() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
