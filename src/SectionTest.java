import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SectionTest {
	Section section;
	private Paragraph p1;
	private Paragraph p2;
	private Paragraph p3;
	
	@Before
	public void init() {
		section = new Section();
		p1 = new Paragraph("FIRST PARAGRAPH");
		p2 = new Paragraph("SECOND PARAGRAPH");
		p3 = new Paragraph("THIRD PARAGRAPH");
	}
	
	@After
	public void clear() {
		section.clear();
	}

	
	@Test
	public void testSectionConstructor() {
		assertEquals(0, section.getSize());
	}

	@Test
	public void testAddGetParagraph() {
		section.addParagraph(p1);
		assertEquals(p1, section.getParagraph(0));
		
		section.addParagraph(p2);
		assertEquals(p2, section.getParagraph(1));
		
		section.addParagraph(1, p3);
		assertEquals(p3, section.getParagraph(1));
		assertEquals(p2, section.getParagraph(2));
	}

	
	@Test
	public void testMoveParagraphUp() {
		section.addParagraph(p1);
		section.addParagraph(p2);
		section.addParagraph(p3);
		
		section.moveParagraphUp(0);
		
		assertEquals(p2, section.getParagraph(0));
		assertEquals(p1, section.getParagraph(1));
		assertEquals(p3, section.getParagraph(2));
	}
	
	@Test
	public void testMoveParagraphDown() {
		section.addParagraph(p1);
		section.addParagraph(p2);
		section.addParagraph(p3);
		
		section.moveParagraphDown(2);
		
		assertEquals(p1, section.getParagraph(0));
		assertEquals(p3, section.getParagraph(1));
		assertEquals(p2, section.getParagraph(2));
	}
	
	@Test
	public void testMoveParagraph() {
		section.addParagraph(p1);
		section.addParagraph(p2);
		section.addParagraph(p3);
		
		section.moveParagraph(0,2);

		assertEquals(p2, section.getParagraph(0));
		assertEquals(p3, section.getParagraph(1));
		assertEquals(p1, section.getParagraph(2));
	}
	
	@Test
	public void testRemovePara() {
		section.addParagraph(p1);
		section.addParagraph(p2);
		section.addParagraph(p3);
		
		section.removeParagraph(0);
		
		assertEquals(p2, section.getParagraph(0));
		assertEquals(p3, section.getParagraph(1));
		assertEquals(2, section.getSize());
		
	}
}
