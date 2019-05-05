package by.dsp.model;

public final class Fibreboard extends Material {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String FIBREBOARD = "ДВП";
	public static final int DEFAULT_THICKNESS = 4;

	public Fibreboard() {
		super(FIBREBOARD, DEFAULT_THICKNESS);
	}
	
	public Fibreboard(int thickness){
		super(new Color(),thickness);
	}

	@Override
	public int hashCode() {
		return this.getThickness();
	}

	@Override
	public String toString() {
		return FIBREBOARD + " " + this.getThickness() + "мм";
	}

	@Override
	public boolean equals(Object ob) {
		if (ob == null)
			return false;
		if (!ob.getClass().equals(this.getClass()))
			return false;
		return (((Fibreboard)ob).getThickness()==this.getThickness());
	}

	@Override
	public String getFullNameInLine() {
		return this.toString();
	}

	public void setColor(Color color) {
		throw new RuntimeException();
	}

	public void setColor(String colorName) {
		throw new RuntimeException();
	}

}
