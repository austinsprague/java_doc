import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParagraphTest {

	@Test
	void testParagraphConstructor() {
		String text1 = "This is the first P";
		Paragraph p1 = new Paragraph(text1);
		
		String text2 = "This is the 2nd P";
		Paragraph p2 = new Paragraph(text2, Paragraph.ParaStyle.HEADING_1);
		
		assertEquals(text1, p1.getText());
		assertEquals(text2, p2.getText());
		assertEquals(Paragraph.ParaStyle.HEADING_1, p2.getParaStyle());
	}
	
	@Test
	void testaddText() {
		String text1 = "This is the first P";
		String text2 = "This is the 2nd P";
		Paragraph p1 = new Paragraph(text1);
		p1.addText(text2);
		
		assertEquals(text1 + text2, p1.getText());
	}
	
	@Test
	void testClear() {
		String text1 = "This is the first P";
		Paragraph p1 = new Paragraph(text1);
		p1.clearText();
		
		assertNull(p1.getText());
	}
	
	@Test
	void testUpdateParaStyle() {
		String text1 = "This is the first P";
		Paragraph p1 = new Paragraph(text1, Paragraph.ParaStyle.HEADING_1);
		
		p1.updateParaStyle(Paragraph.ParaStyle.LIST_BULLETED);
		assertEquals(Paragraph.ParaStyle.LIST_BULLETED, p1.getParaStyle());
	}
}
