import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		String docName = "HipposText";
		
		Document myDoc = Document.getInstance();
		myDoc.newDoc(docName);
		myDoc.getDocName();

		Section firstSect = new Section();
		Paragraph firstP = new Paragraph("Pygmy Hippos of Africa", Paragraph.ParaStyle.HEADING_1);
		Paragraph secondP = new Paragraph("Pygmy Hippos of Africa", Paragraph.ParaStyle.HEADING_2);
		Paragraph thirdP = new Paragraph("Pygmy Hippos of Africa", Paragraph.ParaStyle.HEADING_3);
		Paragraph fourthP = new Paragraph("Pygmy Hippos of Africa", Paragraph.ParaStyle.HEADING_4);
		Paragraph fifthP = new Paragraph("Pygmy Hippos of Africa", Paragraph.ParaStyle.HEADING_5);
		
		firstSect.addParagraph(firstP);
		firstSect.addParagraph(secondP);
		firstSect.addParagraph(thirdP);
		firstSect.addParagraph(fourthP);
		firstSect.addParagraph(fifthP);
		
		firstSect.addParagraph(new Paragraph("While the hippopotamus exists in various places in Africa..."));
		firstSect.addParagraph(new Paragraph("Hippo facts:"));
		
		String bulletedText = "";
		bulletedText += "The name Hippopotamus comes from the Ancient Greek 'river horse'. \n"; bulletedText += "Hippos secrete an oily red substance; they do not sweat blood. \n"; bulletedText += "An adult Hippo resurfaces every 3 to 5 minutes to breathe.\n"; bulletedText += "They are only territorial while in the water.";
		
		firstSect.addParagraph(new Paragraph(bulletedText, Paragraph.ParaStyle.LIST_BULLETED));
		firstSect.addParagraph(new Paragraph(bulletedText, Paragraph.ParaStyle.LIST_ORDERED));
		firstSect.addParagraph(new Paragraph("I hope you have enjoyed our foray into the world of the pygmy hippo..."));
		
		myDoc.addSection(firstSect); 
//		myDoc.getSection(0).moveParagraphUp(1);
		
		
		Section secondSect = new Section();
		Paragraph secondSectfirstP = new Paragraph("NAMASTE");
		secondSect.addParagraph(secondSectfirstP);
		myDoc.addSection(secondSect); 
		
		myDoc.save(); 
		
//		System.out.println(myDoc.toString());
		myDoc.close();
//		myDoc.open(docName);
		myDoc.saveToHtml();

	}

}
