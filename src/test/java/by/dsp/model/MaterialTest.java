package by.dsp.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaterialTest {
	
	private Material material;
	
	private static final String COLOR_NAME = "color name";
	private static final String ANOTHER_COLOR_NAME = "another color";
	private static final int THICKNESS_18 = 18;
	private static final int THICKNESS_16 = 16;
	private static final Color COLOR = new Color();
	private static final Color DEFINED_COLOR = new Color(COLOR_NAME);
	
	
	@Before
	public void init(){
		this.material = new Material();
	}

	@Test
	public void defaultConstructorTest(){
		assertTrue(this.material.getThickness()==0);
		assertNotNull(this.material.getColor());
		assertEquals(COLOR,this.material.getColor());
	}
	
	@Test
	public void constructorTest(){
		Color color = new Color(ANOTHER_COLOR_NAME);
		Material m1 = new Material(ANOTHER_COLOR_NAME);
		assertTrue(m1.getThickness()==0);
		assertEquals(color,m1.getColor());
		Material m2 = new Material(color);
		assertEquals(m1,m2);
		m1 = new Material(color,THICKNESS_16);
		m2 = new Material(ANOTHER_COLOR_NAME,THICKNESS_16);
		assertEquals(m1,m2);
		m2.setThickness(THICKNESS_18);
		assertNotEquals(m1,m2);
	}
	
	@Test
	public void colorTest(){
		assert DEFINED_COLOR.getName()==COLOR_NAME;
		this.material.setColor(COLOR);
		assertEquals(COLOR,this.material.getColor());
		this.material.setColor(COLOR_NAME);
		assertNotEquals(COLOR,this.material.getColor());
		assertEquals(DEFINED_COLOR,this.material.getColor());
	}
	
	@Test
	public void thicknessTest(){
		assertFalse(this.material.getThickness()==THICKNESS_16);
		this.material.setThickness(THICKNESS_16);
		assertTrue(this.material.getThickness()==THICKNESS_16);
		this.material.setThickness(-1);
		assertTrue(this.material.getThickness()==0);
		Material material = new Material(COLOR,-1);
		assertTrue(material.getThickness()==0);
		material = new Material(COLOR_NAME);
		assertTrue(this.material.getThickness()==0);
	}
	
}
