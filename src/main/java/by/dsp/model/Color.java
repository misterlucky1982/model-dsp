package by.dsp.model;

public class Color implements FullName{
	
	private String name;
	private boolean structure;
	public static final String UNDEFINED_COLOR = "undefined";
	public static final String DEFAULT_WITH_STRUCTURE = "default (with structure)";
	public static final String DEFAULT_WITHOUT_STRUCTURE = "default (without structure)";
	
	public Color(){
		this.name = UNDEFINED_COLOR;
	}
	
	public Color(String name){
		if(name==null)name = Color.UNDEFINED_COLOR;
		this.name = name;
		if(Color.DEFAULT_WITH_STRUCTURE.equals(name))this.structure = true;
	}
	
	public Color(boolean structure){
		if(structure){
			this.name = Color.DEFAULT_WITH_STRUCTURE;
		}else this.name = Color.DEFAULT_WITHOUT_STRUCTURE;
		this.structure = structure;
	}
	
	public Color(String name, boolean structure){
		if(name == null){
			name = Color.UNDEFINED_COLOR;
		}else if((Color.DEFAULT_WITH_STRUCTURE.equals(name)&&structure==false)||Color.DEFAULT_WITHOUT_STRUCTURE.equals(name)&&structure==true)
			throw new ColorException("Color`s name and color`s structure are not matched");
		this.structure = structure;
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
		if(name==null){
			this.name=Color.UNDEFINED_COLOR;
		}
	}
	
	public void setStructure(boolean structure){
		if(structure){
			if(this.name==Color.DEFAULT_WITHOUT_STRUCTURE)
				this.name=Color.DEFAULT_WITH_STRUCTURE;
		}else{
			if(this.name==Color.DEFAULT_WITH_STRUCTURE)
				this.name=Color.DEFAULT_WITHOUT_STRUCTURE;
		}
		this.structure = structure;
	}
	
	@Deprecated
	public boolean getStructue(){
		return this.structure;
	}
	
	public boolean isStructure() {
		return structure;
	}

	@Override
	public boolean equals(Object ob){
		if(ob==null)return false;
		if(!ob.getClass().equals(this.getClass()))return false;
		if(((Color)ob).getName().equals(UNDEFINED_COLOR))return false;
		if(((Color)ob).isStructure()==this.structure){
			if(((Color)ob).getName().equals(this.name))return true;
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		int temp = this.name.hashCode();
		if(this.structure)temp++;
		return temp;
	}
	
	@Override
	public String toString(){
		return this.name+", st:"+this.structure;
	}
	
	public boolean isDefaultValue(){
		return (this.name.equals(Color.DEFAULT_WITH_STRUCTURE)||this.name.equals(Color.DEFAULT_WITHOUT_STRUCTURE));
	}
	
	public boolean isUndefined(){
		return Color.UNDEFINED_COLOR.equals(this.name)||this.name==null;
	}

	public String getFullNameInLine() {
		return this.name;
	}

}
