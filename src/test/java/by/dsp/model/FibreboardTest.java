package by.dsp.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibreboardTest {
	
	private static final int TEST_THICKNESS = 6;

	@Test
	public void fibreboardConstructorTest(){
		Fibreboard fibreboard1 = new Fibreboard();
		Fibreboard fibreboard2 = new Fibreboard(TEST_THICKNESS);
		assertTrue(fibreboard1.getThickness()==Fibreboard.DEFAULT_THICKNESS);
		assertTrue(fibreboard2.getThickness()==TEST_THICKNESS);
	}
	
	@Test(expected=RuntimeException.class)
	public void setColorWithColorVariableTest(){
		Fibreboard fibreboard = new Fibreboard();
		fibreboard.setColor(new Color());
	}
	
	@Test(expected=RuntimeException.class)
	public void setColorWithStringVariableTest(){
		String color = "color";
		Fibreboard fibreboard = new Fibreboard();
		fibreboard.setColor(color);
	}
	
	@Test
	public void toStringForDefaultConstructorTest(){
		Fibreboard fibreboard = new Fibreboard();
		assertEquals(fibreboard.toString(),Fibreboard.FIBREBOARD+" "+Fibreboard.DEFAULT_THICKNESS+"мм");
	}
	
	@Test
	public void toStringForConstructorTest(){
		Fibreboard fibreboard = new Fibreboard(TEST_THICKNESS);
		assertEquals(fibreboard.toString(),Fibreboard.FIBREBOARD+" "+TEST_THICKNESS+"мм");
	}
	
	@Test
	public void getFullNameTest(){
		Fibreboard fibreboard = new Fibreboard();
		assertEquals(fibreboard.toString(),fibreboard.getFullNameInLine());
	}
	
	public void equalsTest(){
		Fibreboard fibreboard1 = new Fibreboard();
		Fibreboard fibreboard2 = new Fibreboard(Fibreboard.DEFAULT_THICKNESS);
		Fibreboard fibreboard3 = new Fibreboard(TEST_THICKNESS);
		assertEquals(fibreboard1,fibreboard2);
		assertNotEquals(fibreboard1,fibreboard3);
	}
}
