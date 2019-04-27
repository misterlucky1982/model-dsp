package by.dsp.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GrooveTest {

	private static final double THICKNESS = 4.0;
	private static final double ANOTHER_THICKNESS = 5.0;
	private static final double DEPTH = 6.0;
	private static final double ANOTHER_DEPTH = 5.0;
	private static final double SPACING = 10.0;
	private static final double ANOTHER_SPACING = 8.0;
	private static final boolean TRUE = true;
	private static final boolean FALSE = false;
	
	private Groove groove;
	
	@Before
	public void init(){
		this.groove = new Groove();
	}
	
	@Test
	public void defaultConstructorTest(){
		assertTrue(this.groove.getDepth()==0.0);
		assertTrue(this.groove.isFaceSide()==FALSE);
		assertTrue(this.groove.getSpacing()==0.0);
		assertTrue(this.groove.getThickness()==0.0);
	}
	
	@Test
	public void constructorTestandPropertiesTest(){
		Groove groove2 = new Groove(-1,-1,-1,FALSE);
		assertTrue(groove2.getDepth()==0.0);
		assertTrue(groove2.getThickness()==0.0);
		assertTrue(groove2.getSpacing()==0.0);
		groove2 = new Groove(SPACING,THICKNESS,DEPTH,TRUE);
		this.groove.setDepth(DEPTH);
		this.groove.setFaceSide(TRUE);
		this.groove.setSpacing(SPACING);
		this.groove.setThickness(THICKNESS);
		assertEquals(groove2,this.groove);
		this.groove.setDepth(ANOTHER_DEPTH);
		assertNotEquals(groove2,this.groove);
		this.groove.setDepth(DEPTH);
		this.groove.setFaceSide(FALSE);
		assertNotEquals(groove2,this.groove);
		this.groove.setFaceSide(TRUE);
		this.groove.setSpacing(ANOTHER_SPACING);
		assertNotEquals(groove2,this.groove);
		this.groove.setSpacing(ANOTHER_SPACING);
		this.groove.setThickness(ANOTHER_THICKNESS);
		assertNotEquals(groove2,this.groove);
		
		
	}
	
	@Test
	public void faceSideTest(){
		this.groove.setFaceSide(TRUE);
		assertTrue(this.groove.isFaceSide());
		this.groove.setFaceSide(FALSE);
		assertTrue(!this.groove.isFaceSide());
	}
	
	@Test
	public void thicknessTest(){
		assertFalse(this.groove.getThickness()==THICKNESS);
		this.groove.setThickness(THICKNESS);
		assertTrue(this.groove.getThickness()==THICKNESS);
		this.groove.setThickness(-1);
		assertTrue(this.groove.getThickness()==0.0);
	}
	
	@Test
	public void depthTest(){
		assertFalse(this.groove.getDepth()==DEPTH);
		this.groove.setDepth(DEPTH);
		assertTrue(this.groove.getDepth()==DEPTH);
		this.groove.setDepth(-1);
		assertTrue(this.groove.getDepth()==0.0);
	}
	
	@Test
	public void spacingTest(){
		assertFalse(this.groove.getSpacing()==SPACING);
		this.groove.setSpacing(SPACING);
		assertTrue(this.groove.getSpacing()==SPACING);
		this.groove.setSpacing(-1);
		assertTrue(this.groove.getSpacing()==0.0);
	}
}
