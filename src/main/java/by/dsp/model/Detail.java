package by.dsp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Detail {

	private static int MINIMUM_EDGING_SIZE = 80;
	private static int MINIMUM_SHORT_SIZE_FOR_LONG_EDGING = 80;
	private static int ADDITION_FOR_DOUBLE_LAYERED_DETAIL = 20;
	private static int CUT_WIDTH = 4;
	public static int MAX_HEIGHT = 2800;
	public static int MAX_WIDTH = 2070;

	private Object detailScheme;
	private List<Detail> primaryDetailsForCut;
	private int height;
	private int width;
	private int amount;
	private boolean isOrientationFixed;
	private Material material;
	private Edging[] edgings;
	private Groove[] groovies;
	private QuarterSpace[] quarterSpaces;
	private boolean milling;
	private String remark = "";
	private boolean isDoubleLayer;
	private List<Operation> operations = new ArrayList<>();

	public Detail() {
		this.isOrientationFixed = true;
	}

	public void setSize(int height, int width) {
		this.height = height;
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHeight() {
		return this.height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getWidth() {
		return this.width;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return this.amount;
	}

	public boolean isOrientationFixed() {
		return this.isOrientationFixed;
	}

	public void setOrientation(boolean orientation) {
		this.isOrientationFixed = orientation;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Material getMaterial() {
		return this.material;
	}

	public Color getColor() {
		return this.material.getColor();
	}

	public void setEdging(Edging y1, Edging y2, Edging x1, Edging x2) {
		if (!this.getClass().equals(Detail.class))
			throw new RuntimeException();
		this.edgings = new Edging[4];
		this.edgings[0] = y1;
		this.edgings[1] = y2;
		this.edgings[2] = x1;
		this.edgings[3] = x2;
	}

	public void setEdging(Edging[] edgings) {
		if (this.getClass().equals(Detail.class) && edgings.length != 4)
			throw new RuntimeException();
		this.edgings = new Edging[4];
		this.edgings[0] = edgings[0];
		this.edgings[1] = edgings[1];
		this.edgings[2] = edgings[2];
		this.edgings[3] = edgings[3];
	}

	public void setEdging(Side side, Edging e) {
		if (side == null)
			return;
		if (this.edgings == null)
			this.edgings = new Edging[4];
		switch (side) {
		case Y1:
			this.edgings[0] = e;
			break;
		case Y2:
			this.edgings[1] = e;
			break;
		case X1:
			this.edgings[2] = e;
			break;
		case X2:
			this.edgings[3] = e;
			break;
		}

	}

	public Edging[] getEdging() {
		if (this.edgings == null)
			this.edgings = new Edging[4];
		return this.edgings;
	}

	public Edging getUsedEdging() {
		List<Edging> temp = new ArrayList<>();
		Edging[] edgings = this.getEdging();
		for (Edging e : edgings) {
			if (e != null && !temp.contains(e))
				temp.add(e);
		}
		if (temp.size() != 1)
			return null;
		return temp.get(0);
	}

	public void setGroove(Groove[] gr) {
		if (gr.length != 4)
			throw new RuntimeException();
		this.groovies = new Groove[4];
		this.groovies[0] = gr[0];
		this.groovies[1] = gr[1];
		this.groovies[2] = gr[2];
		this.groovies[3] = gr[3];
	}

	public void setGroove(Groove y1, Groove y2, Groove x1, Groove x2) {
		this.groovies = new Groove[4];
		this.groovies[0] = y1;
		this.groovies[1] = y2;
		this.groovies[2] = x1;
		this.groovies[3] = x2;
	}

	public void setGroove(Side side, Groove groove) {
		if (side == null)
			return;
		if (this.groovies == null)
			this.groovies = new Groove[4];
		switch (side) {
		case Y1:
			this.groovies[0] = groove;
			break;
		case Y2:
			this.groovies[1] = groove;
			break;
		case X1:
			this.groovies[2] = groove;
			break;
		case X2:
			this.groovies[3] = groove;
			break;
		}
	}

	public Groove[] getGroove() {
		if (this.groovies == null)
			this.groovies = new Groove[4];
		return this.groovies;
	}

	public void setQuarterSpace(QuarterSpace y1, QuarterSpace y2, QuarterSpace x1, QuarterSpace x2) {
		this.quarterSpaces = new QuarterSpace[4];
		this.quarterSpaces[0] = y1;
		this.quarterSpaces[1] = y2;
		this.quarterSpaces[2] = x1;
		this.quarterSpaces[3] = x2;
	}

	public void setQuarterSpace(QuarterSpace[] qs) {
		if (qs.length != 4)
			throw new RuntimeException();
		this.quarterSpaces = new QuarterSpace[4];
		this.quarterSpaces[0] = qs[0];
		this.quarterSpaces[1] = qs[1];
		this.quarterSpaces[2] = qs[2];
		this.quarterSpaces[3] = qs[3];
	}

	public void setQuarterSpace(Side side, QuarterSpace qs) {
		if (side == null)
			return;
		if (this.quarterSpaces == null)
			this.quarterSpaces = new QuarterSpace[4];
		switch (side) {
		case Y1:
			this.quarterSpaces[0] = qs;
			break;
		case Y2:
			this.quarterSpaces[1] = qs;
			break;
		case X1:
			this.quarterSpaces[2] = qs;
			break;
		case X2:
			this.quarterSpaces[3] = qs;
			break;
		}
	}

	public QuarterSpace[] getQuarterSpace() {
		if (this.quarterSpaces == null)
			this.quarterSpaces = new QuarterSpace[4];
		return this.quarterSpaces;
	}

	public Object[] getSideContent(Side side) {
		Object[] content = new Object[4];
		switch (side) {
		case Y1:
			content[0] = new Integer(this.height);
			content[1] = this.getEdging()[0];
			content[2] = this.getGroove()[0];
			content[3] = this.getQuarterSpace()[0];
			break;
		case Y2:
			content[0] = new Integer(this.height);
			content[1] = this.getEdging()[1];
			content[2] = this.getGroove()[1];
			content[3] = this.getQuarterSpace()[1];
			break;
		case X1:
			content[0] = new Integer(this.width);
			content[1] = this.getEdging()[2];
			content[2] = this.getGroove()[2];
			content[3] = this.getQuarterSpace()[2];
			break;
		case X2:
			content[0] = new Integer(this.width);
			content[1] = this.getEdging()[3];
			content[2] = this.getGroove()[3];
			content[3] = this.getQuarterSpace()[3];
		}
		return content;
	}

	public void setMilling() {
		this.milling = true;
	}

	public void setMilling(String remark) {
		this.milling = true;
		this.remark.concat(remark);
	}

	public boolean isMillingDetail() {
		return this.milling;
	}

	public void setDoubleLayer() {
		this.isDoubleLayer = true;
	}

	public void setDoubleLayer(boolean doubleLayer) {
		this.isDoubleLayer = doubleLayer;
	}

	public boolean isDoubleLayered() {
		return this.isDoubleLayer;
	}

	public int getThickness() {
		if (this.material == null)
			return 0;
		if (this.isDoubleLayer) {
			return this.material.getThickness() * 2;
		} else
			return this.material.getThickness();
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void appendRemark(String remark) {
		this.remark.concat(remark);
	}
	
	public  void setDetailScheme(Object detailScheme){
		this.detailScheme = detailScheme;
	}
	
	public Object getDetailScheme(){
		return this.detailScheme;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (this.material != null) {
			sb.append(this.material.getColor());
			sb.append(" ");
		}
		sb.append(this.getThickness());
		sb.append("mm ");
		sb.append(height);
		sb.append("x");
		sb.append(width);
		sb.append(" edging:");
		sb.append(getEdgingInLine());
		sb.append("; ");
		addGrooveInformation(sb);
		addQuarterSpaceInformation(sb);
		if (this.milling)
			sb.append("; the part is milled.");
		if (this.isDoubleLayer)
			sb.append("; the part is double-layered.");
		sb.append(" - ");
		sb.append(this.amount);
		sb.append("шт");
		if (this.remark.length() > 0) {
			sb.append("; remark:");
			sb.append(this.remark);
		}
		return sb.toString();

	}

	@Override
	public boolean equals(Object ob) {
		if (ob == null)
			return false;
		if (!ob.getClass().equals(this.getClass()))
			return false;
		Detail temp = (Detail) ob;
		if (temp.material != null) {
			if (!temp.material.equals(this.material))
				return false;
		} else {
			if (this.material != null)
				return false;
		}
		if (temp.height != this.height || temp.width != this.width)
			return false;
		if (temp.amount != this.amount)
			return false;
		if (!edgingCompare(temp))
			return false;
		if (!grooveCompare(temp))
			return false;
		if (!quarterCompare(temp))
			return false;
		if (this.milling != temp.milling)
			return false;
		if (this.isDoubleLayer != temp.isDoubleLayer)
			return false;
		if(this.detailScheme==null&&temp.detailScheme!=null)return false;
		if(this.detailScheme!=null)if(!this.detailScheme.equals(temp.detailScheme))return false;
		return this.remark.equals(temp.remark);
	}

	private boolean edgingCompare(Detail detail) {
		return Arrays.equals(this.getQuarterSpace(), detail.getQuarterSpace());
	}

	private boolean grooveCompare(Detail detail) {
		return Arrays.equals(this.getGroove(), detail.getGroove());
	}

	private boolean quarterCompare(Detail detail) {
		return Arrays.equals(this.getQuarterSpace(), detail.getQuarterSpace());
	}

	@Override
	public int hashCode() {
		int temp = this.amount;
		temp += this.height;
		temp += this.width;
		if (this.material != null)
			temp += this.material.hashCode();
		temp -= (this.remark.hashCode() * this.remark.length());
		if (this.isDoubleLayer)
			temp+=333;
		if (this.milling)
			temp++;
		QuarterSpace[] qs = this.getQuarterSpace();
		Edging[] ed = this.getEdging();
		Groove[] gr = this.getGroove();
		int i = 0;
		while (i < qs.length) {
			if (qs[i] != null)
				temp -= qs[i].hashCode();
			if (ed[i] != null)
				temp += ed[i].hashCode();
			if (gr[i] != null)
				temp += gr[i].hashCode();
		}
		if (temp < 0)
			temp *= -1;
		if(this.detailScheme!=null)temp+=this.detailScheme.hashCode();
		return temp;
	}

	@Deprecated
	private String getEdgingInLine() {
		StringBuilder sb = new StringBuilder();
		if (this.getEdging()[0] == null) {
			sb.append(0);
		} else
			sb.append(1);
		if (this.getEdging()[1] == null) {
			sb.append(0);
		} else
			sb.append(1);
		if (this.getEdging()[2] == null) {
			sb.append(0);
		} else
			sb.append(1);
		if (this.getEdging()[3] == null) {
			sb.append(0);
		} else
			sb.append(1);
		return sb.toString();
	}

	private void addGrooveInformation(StringBuilder sb) {
		if (Arrays.equals(this.getGroove(), new Groove[4])) {
			return;
		} else {
			sb.append("groove:");
			if (this.getGroove()[0] != null) {
				sb.append(1);
			} else
				sb.append(0);
			if (this.getGroove()[1] != null) {
				sb.append(1);
			} else
				sb.append(0);
			if (this.getGroove()[2] != null) {
				sb.append(1);
			} else
				sb.append(0);
			if (this.getGroove()[3] != null) {
				sb.append(1);
			} else
				sb.append(0);
		}
	}

	private void addQuarterSpaceInformation(StringBuilder sb) {
		if (Arrays.equals(this.getQuarterSpace(), new QuarterSpace[4])) {
			return;
		} else {
			sb.append("quarter:");
			if (this.getQuarterSpace()[0] != null) {
				sb.append(1);
			} else
				sb.append(0);
			if (this.getQuarterSpace()[1] != null) {
				sb.append(1);
			} else
				sb.append(0);
			if (this.getQuarterSpace()[2] != null) {
				sb.append(1);
			} else
				sb.append(0);
			if (this.getQuarterSpace()[3] != null) {
				sb.append(1);
			} else
				sb.append(0);
		}
	}
	
	public void setPrimaryDetailsForCut(List<Detail>list){
		this.primaryDetailsForCut = list;
	}
	
	public boolean isPrimaryDetailsListIsChanged(){
		return this.primaryDetailsForCut!=null;
	}
	
	public List<Detail> getPrimaryDetailsForCut(){
		if(this.primaryDetailsForCut!=null){
			return this.primaryDetailsForCut;
		}else{
			List<Detail>temp = new ArrayList<>();
			temp.add(this);
			return Detail.getPrimaryDetailsForCut(temp);
		}
		
	}

	public List<Operation> getOperationList() {
		return this.operations;
	}
	
	public void setOperationsList(List<Operation>list){
		this.operations = list;
	}

	public void copy(Detail detail) {
		this.height = detail.height;
		this.width = detail.width;
		this.amount = detail.amount;
		this.isOrientationFixed = detail.isOrientationFixed;
		this.material = detail.material;
		this.setEdging(detail.getEdging());
		this.setGroove(detail.getGroove());
		this.setQuarterSpace(detail.getQuarterSpace());
		this.milling = detail.milling;
		this.remark = detail.remark;
		this.isDoubleLayer = detail.isDoubleLayer;
		this.detailScheme = detail.detailScheme;
		for (Operation operation : detail.operations)
			this.operations.add(operation);
		if(detail.primaryDetailsForCut!=null){
			this.primaryDetailsForCut = new ArrayList<Detail>();
			for(Detail d:detail.primaryDetailsForCut)this.primaryDetailsForCut.add(d);
		}

	}

	private void copyForSecondLayer(Detail detail) {
		this.height = detail.height;
		this.width = detail.width;
		this.amount = detail.amount;
		this.isOrientationFixed = detail.isOrientationFixed;
		this.material = detail.material;
		this.operations = new ArrayList<>();
		for (Operation operation : detail.operations)
			this.operations.add(operation);
	}

	public boolean edgingNarrowDetail() {
		Edging e[] = this.getEdging();
		if (this.width < Detail.MINIMUM_SHORT_SIZE_FOR_LONG_EDGING && (e[0] != null || e[1] != null))
			return true;
		if (this.height < Detail.MINIMUM_SHORT_SIZE_FOR_LONG_EDGING && (e[2] != null || e[3] != null))
			return true;
		if (this.width < Detail.MINIMUM_EDGING_SIZE && (e[2] != null || e[3] != null))
			return true;
		if (this.height < Detail.MINIMUM_EDGING_SIZE && (e[0] != null || e[1] != null))
			return true;
		return false;
	}

	public boolean hasGrooves() {
		Groove[] gr = this.getGroove();
		for (int i = 0; i < gr.length; i++)
			if (gr[i] != null)
				return true;
		return false;
	}

	public boolean hasQuarterSpaces() {
		QuarterSpace[] qs = this.getQuarterSpace();
		for (int i = 0; i < qs.length; i++)
			if (qs[i] != null)
				return true;
		return false;
	}

	public String getGrooveInformation() {
		int g = 0;
		Groove[] gr = this.getGroove();
		if (gr[0] != null)
			g++;
		if (gr[1] != null)
			g++;
		if (gr[2] != null)
			g++;
		if (gr[3] != null)
			g++;
		if (g == 0)
			return "без четвертей";
		if (g == 1) {
			if (gr[0] != null) {
				return "левая вертикаль: " + gr[0].getFullNameInLine();
			}
			if (gr[1] != null) {
				return "правая вертикаль: " + gr[1].getFullNameInLine();
			}
			if (gr[2] != null) {
				return "верхняя горизонталь: " + gr[2].getFullNameInLine();
			}
			if (gr[3] != null) {
				return "нижняя горизонталь: " + gr[3].getFullNameInLine();
			}
		}
		if (g > 1) {
			StringBuilder sb = new StringBuilder();
			if (gr[0] != null) {
				sb.append("по Y1:");
				sb.append(gr[0].getFullNameInLine());
			}
			if (gr[1] != null) {
				if (sb.length() > 0)
					sb.append("; ");
				sb.append("по Y2:");
				sb.append(gr[1].getFullNameInLine());
			}
			if (gr[2] != null) {
				if (sb.length() > 0)
					sb.append("; ");
				sb.append("по X1: ");
				sb.append(gr[2].getFullNameInLine());
			}
			if (gr[3] != null) {
				if (sb.length() > 0)
					sb.append("; ");
				sb.append("по X2: ");
				sb.append(gr[3].getFullNameInLine());
			}
			return sb.toString();
		}
		return null;
	}

	public String getQuarterSpaceInformation() {
		int qs = 0;
		QuarterSpace[] quarter = this.getQuarterSpace();
		if (quarter[0] != null)
			qs++;
		if (quarter[1] != null)
			qs++;
		if (quarter[2] != null)
			qs++;
		if (quarter[3] != null)
			qs++;
		if (qs == 0)
			return "без четвертей";
		if (qs == 1) {
			if (quarter[0] != null) {
				return "левая вертикаль: " + quarter[0].getFullNameInLine();
			}
			if (quarter[1] != null) {
				return "правая вертикаль: " + quarter[1].getFullNameInLine();
			}
			if (quarter[2] != null) {
				return "верхняя горизонталь: " + quarter[2].getFullNameInLine();
			}
			if (quarter[3] != null) {
				return "нижняя горизонталь: " + quarter[3].getFullNameInLine();
			}
		}
		if (qs > 1) {
			StringBuilder sb = new StringBuilder();
			if (quarter[0] != null) {
				sb.append("по Y1:");
				sb.append(quarter[0].getFullNameInLine());
			}
			if (quarter[1] != null) {
				if (sb.length() > 0)
					sb.append("; ");
				sb.append("по Y2:");
				sb.append(quarter[1].getFullNameInLine());
			}
			if (quarter[2] != null) {
				if (sb.length() > 0)
					sb.append("; ");
				sb.append("по X1: ");
				sb.append(quarter[2].getFullNameInLine());
			}
			if (quarter[3] != null) {
				if (sb.length() > 0)
					sb.append("; ");
				sb.append("по X2: ");
				sb.append(quarter[3].getFullNameInLine());
			}
			return sb.toString();
		}
		return null;
	}

	public String getInformationAboutGroovesEtc() {
		String side = "";
		Groove gr[] = this.getGroove();
		QuarterSpace qs[] = this.getQuarterSpace();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < gr.length; i++) {
			if (gr[i] != null || qs[i] != null) {
				if (i > 0)
					if (sb.length() > 0)
						sb.append("/");
				switch (i) {
				case 0:
					side = Integer.toString(this.height) + "(слева):";
					break;
				case 1:
					side = Integer.toString(this.height) + "(справа):";
					break;
				case 2:
					side = Integer.toString(this.width) + "(верх):";
					break;
				case 3:
					side = Integer.toString(this.width) + "(низ):";
				}
				sb.append("по ");
				sb.append(side);
				if (gr[i] != null) {
					sb.append(gr[i].getFullNameInLine());
					sb.append(";");
				}
				if (qs[i] != null) {
					sb.append(qs[i].getFullNameInLine());
					sb.append(";");
				}
			}
		}
		return sb.toString();
	}

	public String getSideInformation(Side side) {
		Edging[] ed = this.getEdging();
		Groove[] gr = this.getGroove();
		QuarterSpace[] qs = this.getQuarterSpace();

		StringBuilder sb = new StringBuilder();
		switch (side) {
		case Y1:
			if (gr[0] != null)
				sb.append(gr[0].getFullNameInLine());
			if (qs[0] != null)
				sb.append(qs[0].getFullNameInLine());
			if (ed[0] != null) {
				if (sb.length() > 0)
					sb.append(" + ");
				sb.append(ed[0].getFullNameInLine());
			}
			break;
		case Y2:
			if (gr[1] != null)
				sb.append(gr[1].getFullNameInLine());
			if (qs[1] != null)
				sb.append(qs[1].getFullNameInLine());
			if (ed[1] != null) {
				if (sb.length() > 0)
					sb.append(" + ");
				sb.append(ed[1].getFullNameInLine());
			}
			break;
		case X1:
			if (gr[2] != null)
				sb.append(gr[2].getFullNameInLine());
			if (qs[2] != null)
				sb.append(qs[2].getFullNameInLine());
			if (ed[2] != null) {
				if (sb.length() > 0)
					sb.append(" + ");
				sb.append(ed[2].getFullNameInLine());
			}
			break;
		case X2:
			if (gr[3] != null)
				sb.append(gr[3].getFullNameInLine());
			if (qs[3] != null)
				sb.append(qs[3].getFullNameInLine());
			if (ed[3] != null) {
				if (sb.length() > 0)
					sb.append(" + ");
				sb.append(ed[3].getFullNameInLine());
			}
			break;
		}
		return sb.toString();
	}

	public static List<Detail> getPrimaryDetailsForCut(List<Detail> list) {
		List<Detail> result = new ArrayList<>();
		for (Detail detail : list) {
			if(detail.isPrimaryDetailsListIsChanged()){
				List<Detail>changed = detail.getPrimaryDetailsForCut();
				for(Detail det:changed)result.add(det);
				continue;
			}
			Detail temp = new Detail();
			StringBuilder remark = new StringBuilder();
			temp.setSize(detail.height, detail.width);
			temp.setAmount(detail.amount);
			temp.setMaterial(detail.material);
			temp.isOrientationFixed = detail.isOrientationFixed;
			copyEdgings(detail, temp);
			checkingEdgedSidesSize(detail, temp, remark);
			copyGrooves(detail, temp);
			copyQuaterSpaces(detail, temp);
			copyAndCheckingDoubleLayeringAndMilling(detail, temp, remark, result);
			temp.remark = remark.toString();
			result.add(temp);
		}
		return result;
	}

	private static void copyEdgings(Detail first, Detail second) {
		second.setEdging(first.getEdging());
	}

	private static void copyGrooves(Detail first, Detail second) {
		second.setGroove(first.getGroove());
		if (second.hasGrooves())
			second.operations.add(Operation.TO_13);
	}

	private static void copyQuaterSpaces(Detail first, Detail second) {
		second.setQuarterSpace(first.getQuarterSpace());
		if (second.hasQuarterSpaces())
			second.operations.add(Operation.TO_12);
	}

	private static void copyAndCheckingDoubleLayeringAndMilling(Detail detail, Detail temp, StringBuilder remark,
			List<Detail> interim) {
		Detail temp2 = null;
		if (detail.isDoubleLayer) {
			temp.height = detail.height + Detail.ADDITION_FOR_DOUBLE_LAYERED_DETAIL;
			temp.width = detail.width + Detail.ADDITION_FOR_DOUBLE_LAYERED_DETAIL;
			temp2 = new Detail();
			temp2.copyForSecondLayer(temp);
			temp2.operations.clear();
			temp.operations.add(0, Operation.TO_43);
			temp.operations.add(1, Operation.TO_17);
			temp2.operations.add(0, Operation.TO_44);
			temp2.operations.add(1,Operation.TO_17);
		}
		temp.milling = detail.milling;
		if (temp.milling) {
			if (temp2 != null) {
				temp.operations.add(1, Operation.TO_31);
				temp2.operations.add(1, Operation.TO_31);
				temp2.operations.add(Operation.TO_41);
				temp2.remark = remark.toString() + detail.remark;
				interim.add(temp2);
			} else
				temp.operations.add(Operation.TO_31);
			temp.operations.add(Operation.TO_41);
		} else {
			if (temp2 != null)
				interim.add(temp2);
		}
		remark.append(detail.getRemark());
	}

	private static boolean bothLongSidesEdgedWithShortWidth(Detail detail, Detail temp, StringBuilder remark) {
		Edging ed[] = detail.edgings;
		if (detail.height >= detail.width) {
			if (ed[0] != null && ed[1] != null && detail.width < Detail.MINIMUM_SHORT_SIZE_FOR_LONG_EDGING) {
				temp.operations.add(Operation.TO_41);
				temp.width -= ((int) Math.round(ed[0].getThickness() + ed[1].getThickness()));
				return true;
			} else
				return false;
		} else {
			if (ed[2] != null && ed[3] != null && detail.height < Detail.MINIMUM_SHORT_SIZE_FOR_LONG_EDGING) {
				temp.operations.add(Operation.TO_41);
				temp.width -= ((int) Math.round(ed[2].getThickness() + ed[3].getThickness()));
				return true;
			} else
				return false;
		}
	}

	@SuppressWarnings("unused")
	private static void checkingEdgedSidesSize(Detail detail, Detail temp, StringBuilder remark) {
		if (Detail.bothLongSidesEdgedWithShortWidth(detail, temp, remark))
			return;
		Edging ed[] = temp.getEdging();
		if (ed[0] != null || ed[1] != null || ed[2] != null || ed[3] != null)
			temp.operations.add(Operation.TO_21);

		if (Detail.MINIMUM_EDGING_SIZE > Detail.MINIMUM_SHORT_SIZE_FOR_LONG_EDGING) {
			if (!checkingShortEdgedSides(detail, temp, remark))
				checkingShortSidesForLongEdging(detail, temp, remark);
		} else {
			if (!checkingShortSidesForLongEdging(detail, temp, remark))
				checkingShortEdgedSides(detail, temp, remark);
		}
	}

	private static boolean checkingShortSidesForLongEdging(Detail detail, Detail temp, StringBuilder remark) {
		boolean result = false;
		Edging ed[] = temp.getEdging();
		if ((ed[0] != null || ed[1] != null) && temp.width < Detail.MINIMUM_SHORT_SIZE_FOR_LONG_EDGING) {
			result = true;
			if (temp.amount % 2 != 1 && (ed[0] == null || ed[1] == null)) {
				if (ed[0] == null)
					ed[0] = ed[1];
				if (ed[1] == null)
					ed[1] = ed[0];
				temp.width *= 2;
				temp.width += Detail.CUT_WIDTH;
				temp.amount /= 2;
				if (temp.width < Detail.MINIMUM_SHORT_SIZE_FOR_LONG_EDGING)
					temp.width = Detail.MINIMUM_SHORT_SIZE_FOR_LONG_EDGING;
				remark.append("распустить после оклейки ");
				remark.append(detail.height);
				remark.append("x");
				remark.append(detail.width);
				remark.append(" -2шт; ");
			} else {
				temp.width = Detail.MINIMUM_SHORT_SIZE_FOR_LONG_EDGING;
				remark.append("распустить после оклейки ");
				remark.append(detail.height);
				remark.append("x");
				remark.append(detail.width);
			}
			temp.operations.add(Operation.TO_16);
		} else if ((ed[2] != null || ed[3] != null) && temp.height < Detail.MINIMUM_SHORT_SIZE_FOR_LONG_EDGING) {
			if (temp.amount % 2 != 1 && (ed[2] == null || ed[3] == null)) {
				if (ed[2] == null)
					ed[2] = ed[3];
				if (ed[3] == null)
					ed[3] = ed[2];
				temp.height *= 2;
				temp.height += Detail.CUT_WIDTH;
				temp.amount /= 2;
				if (temp.height < Detail.MINIMUM_SHORT_SIZE_FOR_LONG_EDGING)
					temp.height = Detail.MINIMUM_SHORT_SIZE_FOR_LONG_EDGING;
				remark.append("распустить после оклейки ");
				remark.append(detail.height);
				remark.append("x");
				remark.append(detail.width);
				remark.append(" -2шт; ");
			} else {
				temp.height = Detail.MINIMUM_SHORT_SIZE_FOR_LONG_EDGING;
				remark.append("распустить после оклейки ");
				remark.append(detail.height);
				remark.append("x");
				remark.append(detail.width);
			}
			temp.operations.add(Operation.TO_16);
		}
		return result;
	}

	private static boolean checkingShortEdgedSides(Detail detail, Detail temp, StringBuilder remark) {
		boolean result = false;
		Edging[] ed = detail.getEdging();
		if ((ed[2] != null || ed[3] != null) && detail.width < Detail.MINIMUM_EDGING_SIZE) {
			result = true;
			if (temp.amount % 2 != 1 && (ed[0] == null && ed[1] == null)) {
				temp.width *= 2;
				temp.width += Detail.CUT_WIDTH;
				temp.amount /= 2;
				if (temp.width < Detail.MINIMUM_EDGING_SIZE)
					temp.width = Detail.MINIMUM_EDGING_SIZE;
				remark.append("распустить после оклейки ");
				remark.append(detail.height);
				remark.append("x");
				remark.append(detail.width);
				remark.append(" -2шт; ");
			} else {
				temp.width = Detail.MINIMUM_EDGING_SIZE;
				remark.append("распустить после оклейки ");
				remark.append(detail.height);
				remark.append("x");
				remark.append(detail.width);
			}
			temp.operations.add(Operation.TO_16);
		} else if ((ed[0] != null || ed[1] != null) && detail.height < Detail.MINIMUM_EDGING_SIZE) {
			result = true;
			if (temp.amount % 2 != 1 && (ed[2] == null && ed[3] == null)) {
				temp.height *= 2;
				temp.height += Detail.CUT_WIDTH;
				temp.amount /= 2;
				if (temp.height < Detail.MINIMUM_EDGING_SIZE)
					temp.height = Detail.MINIMUM_EDGING_SIZE;
				remark.append("распустить после оклейки ");
				remark.append(detail.height);
				remark.append("x");
				remark.append(detail.width);
				remark.append(" -2шт; ");
			} else {
				temp.height = Detail.MINIMUM_EDGING_SIZE;
				remark.append("распустить после оклейки ");
				remark.append(detail.height);
				remark.append("x");
				remark.append(detail.width);
			}
			temp.operations.add(Operation.TO_16);
		}
		return result;
	}

	public static class Builder {

		private Detail detail;

		private Builder() {
			this.detail = new Detail();
		}

		public static Builder buildDetail() {
			return new Builder();
		}

		public Builder setSize(int height, int width) {
			this.detail.height = height;
			this.detail.width = width;
			return this;
		}

		public Builder setAmount(int amount) {
			this.detail.amount = amount;
			return this;
		}

		public Builder setMaterial(Material material) {
			this.detail.material = material;
			return this;
		}

		public Builder setFixedOrientation(boolean orientationIsFixed) {
			this.detail.isOrientationFixed = orientationIsFixed;
			return this;
		}

		public Builder setEdging(Edging[] edgings) {
			return setEdging(edgings[0], edgings[1], edgings[2], edgings[3]);
		}

		public Builder setEdging(Edging y1, Edging y2, Edging x1, Edging x2) {
			this.detail.setEdging(y1, y2, x1, x2);
			return this;
		}

		public Builder setGroove(Groove y1, Groove y2, Groove x1, Groove x2) {
			this.detail.setGroove(y1, y2, x1, x2);
			return this;
		}

		public Builder setQuarterSpace(QuarterSpace y1, QuarterSpace y2, QuarterSpace x1, QuarterSpace x2) {
			this.detail.setQuarterSpace(y1, y2, x1, x2);
			return this;
		}

		public Builder setDoubleLayer() {
			this.detail.isDoubleLayer = true;
			return this;
		}

		public Builder setDoubleLayer(boolean doubleLayered) {
			this.detail.isDoubleLayer = doubleLayered;
			return this;
		}

		public Builder setRemark(String remark) {
			this.detail.remark = remark;
			return this;
		}

		public Builder milling(boolean milling) {
			this.detail.milling = milling;
			return this;
		}
		
		public Builder setPrymaryDetailsForCut(List<Detail>list){
			this.detail.primaryDetailsForCut = list;
			return this;
		}
		
		public Builder setDetailScheme(Object detailScheme){
			this.detail.detailScheme = detailScheme;
			return this;
		}

		@Deprecated
		public Builder setMilling(String remark) {
			return this;
		}

		public Detail getDetail() {
			return this.detail;
		}

	}

}
