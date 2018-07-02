import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DocumentTest {
	Document myDoc;
	String docName;
	
	@Before
	public void initDocument() {
		myDoc = Document.getInstance();
		docName = "TestDoc";
		myDoc.newDoc(docName);
	}
	
	@After
	public void closDoc() {
		myDoc.close();
	}

	@Test
	public void testDocumentConstructor() {
		assertEquals(docName, myDoc.getDocName());
	}
	
	@Test
	public void testAddGetSection() {
		Section firstSect = new Section();
		Paragraph firstP = new Paragraph("Pygmy Hippos of Africa", Paragraph.ParaStyle.HEADING_1);

		firstSect.addParagraph(firstP);
		myDoc.addSection(firstSect); 
		
		assertEquals(1, myDoc.getSize());
		assertEquals(firstSect, myDoc.getSection(0));
	}
	
	@Test
	public void testRemoveSection() {
		Section firstSect = new Section();
		Paragraph firstP = new Paragraph("Pygmy Hippos of Africa", Paragraph.ParaStyle.HEADING_1);
		firstSect.addParagraph(firstP);
		myDoc.addSection(firstSect); 
		
		Section secondSect = new Section();
		Paragraph secondSectfirstP = new Paragraph("NAMASTE");
		secondSect.addParagraph(secondSectfirstP);
		myDoc.addSection(secondSect); 
		
		assertEquals(2, myDoc.getSize());
		
		myDoc.removeSection(0);
		assertEquals(1, myDoc.getSize());
		assertEquals(secondSect, myDoc.getSection(0));
	}

}
