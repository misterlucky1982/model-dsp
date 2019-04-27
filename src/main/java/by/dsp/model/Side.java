package by.dsp.model;

public enum Side {

	Y1,Y2,X1,X2;
	
	public boolean isHorizontalSide(){
		if(this.name().equals(X1)||this.name().equals(X2)){
			return true;
		}return false;
	}
	
	public Side opposide(){
		if(this.name().equals(X1))return Side.X2;
		if(this.name().equals(X2))return Side.X1;
		if(this.name().equals(Y1))return Side.Y1;
		if(this.name().equals(Y2))return Side.Y2;
		return null;
	}
	
	
}
