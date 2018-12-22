package by.dsp.model;

import java.util.ArrayList;
import java.util.List;

public class Edging implements FullName {
	
	private static final String DIFFERENT_EDGINGS = "РАЗНЫЕ КРОМКИ";
	private Color color;
	private double thickness;
	private int width;
	
	public Edging(){
		this.color = new Color(false);
	}
	
	public Edging(Color color){
		this.color = color;
	}
	
	public Edging(String colorName){
		this.color = new Color(colorName);
	}
	
	public Edging(double thickness, int width){
		if(thickness<0)thickness=0;
		if(width<0)width=0;
		this.color = new Color(true);
		this.thickness = thickness;
		this.width = width;
	}
	
	public Edging(Color color, double thickness, int width){
		if(thickness<0)thickness=0;
		if(width<0)width=0;
		this.color = color;
		this.thickness = thickness;
		this.width = width;
	}
	
	public Edging(String colorName, double thickness, int width){
		this.color = new Color(colorName);
		if(thickness<0)thickness=0;
		if(width<0)width=0;
		this.thickness = thickness;
		this.width = width;
	}
	
	public Color getColor(){
		return this.color;
	}
	
	public String getColorName(){
		return this.color.getName();
	}
	
	public void setColor(Color color){
		this.color = color;
	}
	
	public void setColor(String colorName){
		this.color = new Color(colorName);
	}
	
	public double getThickness(){
		return this.thickness;
	}
	
	public void setThickness(double thickness){
		if(thickness<0)thickness=0;
		this.thickness = thickness;
	}
	
	public int getWidth(){
		return this.width;
	}
	
	public void setWidth(int width){
		if(width<0)width=0;
		this.width = width;
	}
	
	@Override
	public boolean equals(Object ob){
		if(ob==null)return false;
		if(!ob.getClass().equals(this.getClass()))return false;
		if(((Edging)ob).thickness!=this.thickness)return false;
		if(((Edging)ob).width!=this.width)return false;
		if(!((Edging)ob).getColor().equals(this.color))return false;
		return true;
	}
	
	@Override
	public int hashCode(){
		return this.color.hashCode()+((int)this.thickness)*1111+this.width;
	}
	
	@Override
	public String toString(){
		String size;
		if((int)this.thickness-this.thickness==0){
			size = ""+(int)this.thickness+"/"+this.width;
		}else size = String.format("%1$,.1f", this.thickness)+"/"+this.width;
		if(this.color.getName().equals(Color.UNDEFINED_COLOR)||this.color.getName()
				.equals(Color.DEFAULT_COLOR)){
			if(this.thickness==0||this.width==0){
				return "?????????  ?????????";
			}else{
				return size+" default color";
			}
		}else if(this.thickness==0||this.width==0){
			return new String("undefined (color:"+this.color+")");
		}else return size+" "+this.color.getName();
	}

	@Override
	public String getFullNameInLine() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.color.getName());
		sb.append(" ");
		sb.append(Integer.toString(this.width));
		sb.append("/");
		sb.append(Double.toString(this.thickness));
		return sb.toString();
	}
	
	public static boolean arrayEqualsArray(Edging e1[],Edging[] e2){
		if(e1.length!=4)return false;
		if(e1.length!=e2.length)return false;
		if(e1[0]==null&&e1[1]==null&&e1[2]==null&&e1[3]==null){
			if(e2[0]==null&&e2[1]==null&&e2[2]==null&&e2[3]==null)return true;
		}
		boolean result = true;
		
		if(e1[0]!=null&&e2[0]==null)result=false;
		if(result){
			if(e2[0]!=null&&e1[0]==null)result=false;
		}else return false;
		if(result){
			if(e1[0]!=null&&e2[0]!=null){
				result = e1[0].equals(e2[0]);
			}
		}else return false;
		
		if(result){
			if(e1[1]!=null&&e2[1]==null)result=false;
		}else return false;
		if(result){
			if(e2[1]!=null&&e1[1]==null)result=false;
		}else return false;
		if(e1[1]!=null&&e2[1]!=null){
			result = e1[1].equals(e2[1]);
		}
		
		if(result){
			if(e1[2]!=null&&e2[2]==null)result=false;
		}else return false;
		if(result){
			if(e2[2]!=null&&e1[2]==null)result=false;
		}else return false;
		if(e1[2]!=null&&e2[2]!=null){
			result = e1[2].equals(e2[2]);
		}
		
		if(result){
			if(e1[3]!=null&&e2[3]==null)result=false;
		}else return false;
		if(result){
			if(e2[3]!=null&&e1[3]==null)result=false;
		}else return false;
		if(e1[3]!=null&&e2[3]!=null){
			result = e1[3].equals(e2[3]);
		}
		return result;
	}
	
	public static String getContentInLine(Edging[] edgings){
		
		String result = "";
		for(Edging e:edgings){
			if(e!=null){
				if(result.length()>0){
					if(!e.getFullNameInLine().equals(result)){
						result = Edging.DIFFERENT_EDGINGS;
					}
				}else result = e.getFullNameInLine();
			}
		}
		return result;
	}
	
	public static int[] getAmountValues(Edging[]edging){
		int[]result = {0,0};
		if(edging[0]!=null)result[0]++;
		if(edging[1]!=null)result[0]++;
		if(edging[2]!=null)result[1]++;
		if(edging[3]!=null)result[1]++;
		return result;
	}
	
	public boolean isUndefined(){
		return(this.color.getName().equals(Color.UNDEFINED_COLOR)&&this.width==0&&this.thickness==0);
	}
	
	public boolean isDefault(){
		return this.color.isDefaultValue();
	}
	
	public static Edging getLastUsedEdging(int forindex, List<Detail>list) {
		Edging edging = null;
		if(forindex>list.size()-1)forindex=list.size()-1;
		Object material = list.get(forindex).getMaterial();
		for (int i = forindex-1; i >= 0; i--) {
			edging = list.get(i).getUsedEdging();
			if (edging != null&&list.get(i).getMaterial().equals(material)){
				break;
			}
				
		}
		
		return edging;
	}
	
	public static Edging getUsedEdging(Edging[]edgings){
		ArrayList<Edging>temp= new ArrayList<>();
		for(Edging edging:edgings)if(edging!=null)temp.add(edging);
		if(temp.size()!=1)return null;
		return temp.get(0);
	}
	
	

}
