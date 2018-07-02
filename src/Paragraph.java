import java.io.Serializable;

/**
 * Represents a single Paragraph in the Section of the Document
 * @author Sprague
 *
 */
public class Paragraph implements Serializable {
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The text of the paragraph
	 */
	private String text;
	/**
	 * Paragraph style i.e Aligns, headers, and lists
	 */
	private ParaStyle paraStyle;
	
	/**
	 * ParaStyle enum of HTML styles for Paragraph
	 *
	 */
	public enum ParaStyle {
		/**
		 * Paragraph right align
		 */
		LEFT_ALIGN, 
		/**
		 * Paragraph right align
		 */
		RIGHT_ALIGN, 
		/**
		 * Unordered list that will show bullets, with indentation
		 */
		LIST_BULLETED, 
		/**
		 * Ordered list that will show numbers, with indentation
		 */
		LIST_ORDERED, 
		/**
		 * Heading with h1 tag, largest size
		 */
		HEADING_1, 
		/**
		 * Heading with h2 tag
		 */
		HEADING_2,
		/**
		 * Heading with h3 tag
		 */
		HEADING_3, 
		/**
		 * Heading with h4 tag
		 */
		HEADING_4,
		/**
		 * Heading with h5 tag, smallest
		 */
		HEADING_5
	}
	
	/**
	 * Paragraph constructor, ParaStyle defaults to null
	 * @param text String of the text for the Paragraph
	 */
	public Paragraph(String text) {
		this.text = text;
	}
	
	/**
	 * Paragraph constructor with ParaStyle param assigned
	 * @param text String of the Paragraph text
	 * @param paraStyle Enum ParaStyle for the Paragraph
	 */
	public Paragraph(String text, ParaStyle paraStyle) {
		this.text = text;
		this.paraStyle = paraStyle;
	}
	
	/**
	 * Get the Text of the Paragraph
	 * @return String of the text of Paragraph
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Get the ParaStyle assigned to Paragraph
	 * @return enum ParaStyle
	 */
	public ParaStyle getParaStyle() {
		return paraStyle;
	}
	
	/**
	 * Concats the Paragraph's text 
	 * @param text String of text to concat
	 */
	public void addText(String text) {
		this.text += text;
	}
	
	/**
	 * Set text of Paragraph to null, clearing contents
	 */
	public void clearText() {
		text = null;
	}
	
	/**
	 * Change the ParaStyle of the paragraph
	 * @param paraStyle Enum ParaStyle
	 */
	public void updateParaStyle(ParaStyle paraStyle) {
		this.paraStyle = paraStyle;
	}
	
	public String toString() {
		String ret = text + " \n";
		return ret;
	}
}
