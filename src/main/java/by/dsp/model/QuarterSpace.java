package by.dsp.model;

public class QuarterSpace implements FullName{
	
	private double depth;
	private double spacing;
	private boolean faceSide;
	
	public QuarterSpace(){
		
	}
	
	public QuarterSpace(double depth, double spacing,boolean face){
		this.depth = depth;
		this.spacing = spacing;
		this.faceSide = face;
	}
	
	public void setSpacing(double spacing){
		if(spacing<0)spacing=0;
		this.spacing = spacing;
	}
	
	public double getSpacing(){
		return this.spacing;
	}
	
	public void setDepth(double depth){
		if(depth<0)depth=0;
		this.depth = depth;
	}
	
	public double getDepth(){
		return this.depth;
	}
	
	public void setFaceSide(boolean isFaceSide){
		this.faceSide = isFaceSide;
	}
	
	public boolean isFaceSide(){
		return this.faceSide;
	}
	
	@Override
	public String toString(){
		if(this.depth==0||this.spacing==0)return "undefined quarter";
		return new String(this.depth+"/"+this.spacing+" face:"+faceSide);
	}
	
	@Override
	public int hashCode(){
		if(this.faceSide){
			return (int)(this.depth*11+this.spacing*333);
		}else return (int)(this.depth*333+this.spacing*11);
	}
	
	@Override
	public boolean equals(Object ob){
		if(ob==null)return false;
		if(ob.getClass().equals(this.getClass())){
			if(((QuarterSpace)ob).getDepth()!=0&&((QuarterSpace)ob).getDepth()==this.depth){
				if(((QuarterSpace)ob).getSpacing()!=0&&((QuarterSpace)ob).getSpacing()==this.spacing){
					if(((QuarterSpace)ob).faceSide==this.faceSide)return true;
				}
			}
		}
		return false;
	}

	public String getFullNameInLine() {
		StringBuilder sb = new StringBuilder();
		sb.append("четверть ");
		sb.append(line(this.depth,"b"));
		sb.append("/");
		sb.append(line(this.spacing,"a"));
		sb.append("(");
		if(this.isFaceSide()){
			sb.append("с лица)");
		}else sb.append("с тыла)");
		return sb.toString();
	}

	private String line(double parameter, String initial) {
		if (parameter == 0) {
			return initial;
		}
		int temp = (int) parameter;
		if (temp - parameter == 0)
			return Integer.toString(temp);
		int temp2 = (int) ((parameter - (double) temp) * 10);
		return temp + "." + temp2;
	}
}
