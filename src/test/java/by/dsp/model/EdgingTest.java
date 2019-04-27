package by.dsp.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EdgingTest {
	
	private static final int WIDTH = 22;
	private static final int ANOTHER_WIDTH = 34;
	private static final double THICKNESS = 0.8;
	private static final double ANOTHER_THICKNESS = 1.0;
	private static final String COLOR_NAME = "some color";
	private static final Color COLOR = new Color(COLOR_NAME);
	private static final String ANOTHER_COLOR_NAME = "another color";
	private static final Color ANOTHER_COLOR = new Color(ANOTHER_COLOR_NAME);
	
	private Edging edging;
	
	@Before
	public void init(){
		this.edging = new Edging();
	}
	
	@Test
	public void emptyConstructorTest(){
		Edging edging2 = new Edging();
		assertEquals(0,edging2.getWidth());
		assertTrue(edging2.getThickness()==0.0);
		assertEquals(this.edging,edging2);
	}
	
	@Test
	public void constructorWithStingTest(){
		Edging edging = new Edging(COLOR_NAME);
		Edging edging2 = new Edging(COLOR_NAME);
		Edging edging3 = new Edging(ANOTHER_COLOR_NAME);
		assertEquals(edging,edging2);
		assertNotEquals(edging,edging3);
		assertEquals(COLOR_NAME,edging.getColor().getName());
		assertTrue(edging.getThickness()==this.edging.getThickness());
		assertTrue(edging.getWidth()==this.edging.getThickness());
	}
	
	@Test
	public void constuctorWithWidthAndThicknessTest(){
		Edging edging2 = new Edging(-0.5,-1);
		assertEquals(this.edging,edging2);
	}
	
	@Test
	public void constructorTest(){
		Edging edging1 = new Edging(COLOR_NAME,THICKNESS,WIDTH);
		Edging edging2 = new Edging(COLOR,THICKNESS,WIDTH);
		assertEquals(edging1,edging2);
		assertEquals(COLOR,edging1.getColor());
		assertTrue(edging1.getWidth()==WIDTH);
		assertTrue(edging1.getThickness()==THICKNESS);
		edging2 = new Edging(COLOR,-2.0,-1);
		assertTrue(edging2.getWidth()==0);
		assertTrue(edging2.getThickness()==0.0);
		String line = null;
		Color color = null;
		edging1 = new Edging(color,THICKNESS,WIDTH);
		edging2 = new Edging(line,THICKNESS,WIDTH);
		assertEquals(edging1,edging2);
	}

	@Test
	public void colorTest(){
		String line = null;
		Edging edging1 = new Edging();
		edging1.setColorName(line);
		this.edging.setColor(null);
		assertEquals(edging1,this.edging);
		this.edging.setColor(COLOR);
		assertEquals(COLOR,this.edging.getColor());
		assertNotEquals(this.edging,edging1);
	}
	
	@Test
	public void widthTest(){
		this.edging.setWidth(WIDTH);
		assertTrue(this.edging.getWidth()==WIDTH);
	}
	
	@Test
	public void thicknessTest(){
		this.edging.setThickness(THICKNESS);
		assertTrue(this.edging.getThickness()==THICKNESS);
	}
	
	@Test
	public void getContentInLineTest(){
		Edging edging1 = new Edging(COLOR,THICKNESS,WIDTH);
		Edging edging2 = new Edging(ANOTHER_COLOR,ANOTHER_THICKNESS,ANOTHER_WIDTH);
		Edging[]edgings = {edging1,edging1,edging1,edging1};
		for(int i=3;i>-1;i--){
			assertEquals(edging1.getFullNameInLine(),Edging.getContentInLine(edgings));
			edgings[i] = null;
		}
		assertEquals(Edging.EMPTY_EDGINGS,Edging.getContentInLine(edgings));
		edgings[0] = edging2;
		edgings[1] = edging1;
		assertEquals(Edging.DIFFERENT_EDGINGS,Edging.getContentInLine(edgings));
	}
	
	@Test
	public void defaultValueTest(){
		Edging edging2 = new Edging();
		Edging edging3 = new Edging();
		assertTrue(this.edging.isDefaultValue());
		this.edging.setColor(COLOR);
		edging2.setWidth(WIDTH);
		edging3.setThickness(THICKNESS);
		this.edging.setColor(COLOR);
		assertFalse(this.edging.isDefaultValue());
		assertFalse(edging2.isDefaultValue());
		assertFalse(edging3.isDefaultValue());
	}
}
