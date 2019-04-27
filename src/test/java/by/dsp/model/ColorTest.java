package by.dsp.model;


import static org.junit.Assert.*;

import org.junit.Test;


public class ColorTest{
	
	private static String TEST_NAME = "test name";
	private static String ANOTHER = "another";
	
	@Test
	public void undefinedColorTest(){
		Color color1 = new Color();
		Color color2 = new Color(null);
		Color color3 = new Color(null,true);
		assertNotNull(color1.getName());
		assertNotNull(color2.getName());
		assertNotNull(color3.getName());
		assertFalse(color1.isStructure());
		assertFalse(color2.isStructure());
		assertTrue(color3.isStructure());
		assertFalse(color1.isDefaultValue());
		assertFalse(color2.isDefaultValue());
		assertFalse(color3.isDefaultValue());
		assertTrue(color1.isUndefined());
		assertTrue(color2.isUndefined());
		assertTrue(color3.isUndefined());
		assertEquals(color1.getName(),Color.UNDEFINED_COLOR);
		assertEquals(color2.getName(),Color.UNDEFINED_COLOR);
		assertEquals(color3.getName(),Color.UNDEFINED_COLOR);
	}
	
	@Test
	public void colorConstructorTest(){
		Color color1 = new Color(TEST_NAME, true);
		Color color2 = new Color(TEST_NAME, false);
		assertTrue(color1.isStructure());
		assertFalse(color2.isStructure());
		assertFalse(color1.equals(color2));
		assertFalse(color1.equals(null));
		assertEquals(color1.getName(),TEST_NAME);
		assertFalse(color1.isDefaultValue());
		assertFalse(color2.isDefaultValue());
		assertFalse(color1.isUndefined());
		assertFalse(color2.isUndefined());
	}
	
	@Test
	public void defaultColorTest(){
		Color color1 = new Color(true);
		Color color2 = new Color(false);
		assertEquals(color1.getName(),Color.DEFAULT_WITH_STRUCTURE);
		assertEquals(color2.getName(),Color.DEFAULT_WITHOUT_STRUCTURE);
		assertTrue(color1.isStructure());
		assertFalse(color2.isStructure());
		color1.setStructure(false);
		color2.setStructure(true);
		assertEquals(color1.getName(),Color.DEFAULT_WITHOUT_STRUCTURE);
		assertEquals(color2.getName(),Color.DEFAULT_WITH_STRUCTURE);
		assertFalse(color1.isUndefined());
		assertFalse(color2.isUndefined());
	}
	
	@Test
	public void setNameTest(){
		Color color = new Color();
		color.setName(TEST_NAME);
		assertEquals(color.getName(),TEST_NAME);
		assertFalse(color.isUndefined());
		assertFalse(color.isDefaultValue());
	}
	
	@Test
	public void setStructureTest(){
		Color color = new Color();
		color.setStructure(true);
		assertTrue(color.isStructure());
		color.setStructure(false);
		assertFalse(color.isStructure());
	}
	
	@Test
	public void fullNameTest(){
		Color color = new Color(TEST_NAME);
		assertEquals(color.getName(),color.getFullNameInLine());
	}

	@Test
	public void equalsTest(){
		Color color1 = new Color(TEST_NAME, true);
		Color color2 = new Color(TEST_NAME,true);
		Color color3 = new Color(ANOTHER, true);
		assertEquals(color1,color2);
		assertNotEquals(color1,color3);
		color2.setStructure(false);
		assertNotEquals(color1,color2);
		color3.setName(TEST_NAME);
		assertEquals(color1,color3);
	}
}
