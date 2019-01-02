package by.dsp.model;

public final class Fibreboard extends Material{
	
	public Fibreboard(){
		super.setThickness(4);
	}
	
	@Override
	public int hashCode(){
		return 4;
	}
	
	@Override
	public String toString(){
		return "ДВП 4мм";
	}
	
	@Override
	public boolean equals(Object ob){
		if(ob==null)return false;
		if(!ob.getClass().equals(this.getClass()))return false;
		return true;
	}
	
	@Override
	public String getFullNameInLine(){
		return this.toString();
	}

}
