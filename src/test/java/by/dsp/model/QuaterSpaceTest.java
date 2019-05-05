package by.dsp.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuaterSpaceTest {
	
	private static final double DEPTH = 6.0;
	private static final double SPACING = 12.0;
	private static final boolean TRUE = true;
	private static final boolean FALSE = false;
	private static final double ZERO = 0.0;
	
	
	private QuarterSpace quarter;
	
	
	@Before
	public void init(){
		this.quarter = new QuarterSpace();
	}
	
	@Test
	public void constructorTest(){
		QuarterSpace q2 = new QuarterSpace(DEPTH,SPACING,TRUE);
		assertTrue(q2.getDepth()==DEPTH);
		assertTrue(q2.getSpacing()==SPACING);
		assertTrue(q2.isFaceSide());
		assertNotEquals(q2,this.quarter);
		this.quarter.setDepth(DEPTH);
		assertNotEquals(q2,this.quarter);
		this.quarter.setSpacing(SPACING);
		assertNotEquals(q2,this.quarter);
		this.quarter.setFaceSide(TRUE);
		assertEquals(q2,this.quarter);
	}
	
	@Test
	public void depthTest(){
		assertTrue(this.quarter.getDepth()==ZERO);
		this.quarter.setDepth(DEPTH);
		assertTrue(this.quarter.getDepth()==DEPTH);
	}
	
	@Test
	public void spacingTest(){
		assertTrue(this.quarter.getSpacing()==ZERO);
		this.quarter.setSpacing(SPACING);
		assertTrue(this.quarter.getSpacing()==SPACING);
	}
	
	@Test
	public void faceSideTest(){
		assertFalse(this.quarter.isFaceSide());
		this.quarter.setFaceSide(TRUE);
		assertTrue(this.quarter.isFaceSide());
	}

}
