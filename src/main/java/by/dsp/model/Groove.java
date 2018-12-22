package by.dsp.model;

public class Groove implements FullName {

	private double thickness;
	private double depth;
	private double spacing;
	private boolean faceSide;

	public Groove() {

	}

	public Groove(double spacing, double thickness, double depth,
			boolean faceSide) {
		if (thickness < 0)
			thickness = 0;
		if (depth < 0)
			depth = 0;
		if (spacing < 0)
			depth = 0;
		this.thickness = thickness;
		this.depth = depth;
		this.spacing = spacing;
		this.faceSide = faceSide;
	}

	public double getThickness() {
		return this.thickness;
	}

	public void setThickness(double thickness) {
		if (thickness < 0)
			thickness = 0;
		this.thickness = thickness;
	}

	public double getDepth() {
		return this.depth;
	}

	public void setDepth(double depth) {
		if (depth < 0)
			depth = 0;
		this.depth = depth;
	}

	public double getSpacing() {
		return this.spacing;
	}

	public void setSpacing(double spacing) {
		if (spacing < 0)
			spacing = 0;
		this.spacing = spacing;
	}

	public boolean getFaceSide() {
		return this.faceSide;
	}

	public void setFaceSide(boolean faceSide) {
		this.faceSide = faceSide;
	}

	@Override
	public String toString() {
		if (this.depth == 0 || this.spacing == 0 || this.thickness == 0) {
			return "undefined groove";
		} else
			return new String(this.thickness + "/" + this.depth + "/"
					+ this.spacing + " face:" + this.faceSide);
	}

	@Override
	public int hashCode() {
		int result = (int) (this.depth * 111) + (int) (this.spacing * 333)
				+ (int) (this.thickness * 10);
		if (this.faceSide) {
			return result;
		} else
			return result * 11 + 1;
	}

	@Override
	public boolean equals(Object ob) {
		if (ob == null)
			return false;
		if (ob.getClass().equals(this.getClass())) {
			if (((Groove) ob).getDepth() != 0) {
				if (((Groove) ob).getThickness() != 0) {
					if (((Groove) ob).getSpacing() != 0) {
						if (((Groove) ob).getDepth() == this.depth) {
							if (((Groove) ob).getThickness() == this.thickness) {
								if (((Groove) ob).getSpacing() == this.spacing) {
									if (((Groove) ob).getFaceSide() == this.faceSide)
										return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	public String getFullNameInLine() {

		StringBuilder sb = new StringBuilder();
		sb.append("паз");
		sb.append(line(this.spacing,"a"));
		sb.append("/");
		sb.append(line(this.thickness,"b"));
		sb.append("/");
		sb.append(line(this.depth,"c"));
		if(this.faceSide){
			sb.append(" (с лица)");
		}else sb.append(" (с тыла)");
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