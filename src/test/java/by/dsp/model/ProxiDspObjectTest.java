package by.dsp.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProxiDspObjectTest {
	
	private static final String ARTICLE_NAME_TEST = "article";
	private static final long COLOR_ID = 1L;
	private static final String COLOR_NAME = "color name";
	private static final String COLOR_PICTURE = "color picture";
	private static final boolean COLOR_SHOW = true;
	private static final boolean COLOR_STRUCTURE = true;
	private static final String ITEM = "item";
	private static final int MATERIAL_THICKNESS = 18;
	
	private ProxiDspObject object;
	
	@Before
	public void init(){
		this.object = new ProxiDspObject();
	}
	
	@Test
	public void articleNameTest(){
		assertNull(this.object.getArticleName());
		assertFalse(this.object.articleNameNotNull());
		this.object.setArticleName(ARTICLE_NAME_TEST);
		assertEquals(ARTICLE_NAME_TEST,this.object.getArticleName());
		assertTrue(this.object.articleNameNotNull());
	}
	
	@Test
	public void colorIdTest(){
		assertFalse(this.object.isColorIsSaved());
		this.object.setColorId(COLOR_ID);
		assertTrue(this.object.isColorIsSaved());
		assertEquals(COLOR_ID,this.object.getColorId());
	}
	
	@Test
	public void colorNameTest(){
		assertNull(this.object.getColorName());
		assertFalse(this.object.colorNameNotNull());
		this.object.setColorName(COLOR_NAME);
		assertEquals(COLOR_NAME,this.object.getColorName());
		assertTrue(this.object.colorNameNotNull());
	}
	
	@Test
	public void colorPictureTest(){
		assertNull(this.object.getColorPicture());
		assertFalse(this.object.colorHasPicture());
		this.object.setColorPicture(COLOR_PICTURE);
		assertEquals(COLOR_PICTURE,this.object.getColorPicture());
		assertTrue(this.object.colorHasPicture());
	}

	@Test
	public void colorShowTest(){
		assertFalse(this.object.isColorShow());
		this.object.setColorShow(true);
		assertTrue(this.object.isColorShow());
	}
	
	@Test
	public void colorStructureTest(){
		assertFalse(this.object.isColorStructure());
		this.object.setColorStructure(true);
		assertTrue(this.object.isColorStructure());
	}
	
	@Test
	public void itemTest(){
		assertNull(this.object.getItem());
		assertFalse(this.object.itemNotNull());
		this.object.setItem(ITEM);
		assertNotNull(this.object.getItem());
		assertTrue(this.object.itemNotNull());
	}
	
	@Test
	public void materialThicknessTest(){
		assertEquals(0,this.object.getMaterialThickness());
		this.object.setMaterialThickness(MATERIAL_THICKNESS);
		assertEquals(MATERIAL_THICKNESS,this.object.getMaterialThickness());
	}
	
	@Test
	public void builderTest(){
		ProxiDspObject dsp = ProxiDspObject.Builder.build()
				.setArticleName(ARTICLE_NAME_TEST)
				.setColorId(COLOR_ID)
				.setColorName(COLOR_NAME)
				.setColorPicture(COLOR_PICTURE)
				.setColorShow(COLOR_SHOW)
				.setColorStructure(COLOR_STRUCTURE)
				.setItem(ITEM)
				.setMaterialThickness(MATERIAL_THICKNESS)
				.getObgect();
		assertFalse(dsp.equals(object));
		this.object.setArticleName(ARTICLE_NAME_TEST);
		this.object.setColorId(COLOR_ID);
		this.object.setColorName(COLOR_NAME);
		this.object.setColorPicture(COLOR_PICTURE);
		this.object.setColorShow(COLOR_SHOW);
		this.object.setColorStructure(COLOR_STRUCTURE);
		this.object.setItem(ITEM);
		this.object.setMaterialThickness(MATERIAL_THICKNESS);
		assertEquals(dsp,this.object);
	}
}
