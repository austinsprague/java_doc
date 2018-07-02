import java.io.Serializable;

/**
 * Represents one Section of the Document
 * @author Sprague
 *
 */
public class Section implements Serializable{
	/**
	 * Private Serial ID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * List of Paragraphs in the Section
	 */
	private LinkedList<Paragraph> paragraphList;
	
	/**
	 * Section constructor, initializing the List of Paragraphs
	 */
	public Section() {
		paragraphList = new LinkedList<Paragraph>();
	}
	
	/**
	 * Get the Section's size of Paragraph list
	 * @return Integer of the size
	 */
	public int getSize() {
		return paragraphList.size();
	}
	
	/**
	 * Get the Paragraph of the Section from the ParagraphList
	 * @param index Integer of the index of the Paragraph in the paragraphList
	 * @return Paragraph from the ParagraphList
	 */
	public Paragraph getParagraph(int index) {
		return paragraphList.get(index);
	}
	
	/**
	 * Add a paragraph to the ParagraphList
	 * @param paragraph Paragraph to add to the Paragraph List
	 */
	public void addParagraph(Paragraph paragraph) {
		paragraphList.add(paragraph);
	}
	
	/**
	 * Add a paragraph to the ParagraphList at a given index
	 * @param index Integer of the index to which to add the Paragraph in the list
	 * @param paragraph Paragraph to add to the list
	 */
	public void addParagraph(int index, Paragraph paragraph) {
		paragraphList.add(index, paragraph);
	}
	
	/**
	 * Move the paragraph it's index + 1
	 * @param index Integer of the index of the paragraph to move index+1
	 */
	public void moveParagraphUp(int index) {
		moveParagraph(index, index+1);
	}
	
	/**
	 * Move the paragraph it's index - 1
	 * @param index Integer of the index of the paragraph to move index-1
	 */
	public void moveParagraphDown(int index) {
		moveParagraph(index, index - 1);
	}
	
	/**
	 * Move the paragraph at a given index to a given index in the ParagraphList
	 * @param currentParagraphIndex Integer of the current index of the paragraph wanting to move
	 * @param toParagraphIndex Integer of the index which to move the paragraph
	 */
	public void moveParagraph(int currentParagraphIndex, int toParagraphIndex) {
		Paragraph pCurrent = paragraphList.get(currentParagraphIndex);
		paragraphList.remove(currentParagraphIndex);
		paragraphList.add(toParagraphIndex, pCurrent);
	}
	
	/**
	 * Remove a paragraph from the ParagraphList
	 * @param index Integer of the paragraph index of ParagraphList
	 */
	public void removeParagraph(int index) {
		paragraphList.remove(index);
	}
	
	/**
	 * Clear contents of the section, making paragraphList empty
	 */
	public void clear() {
		paragraphList = null;
	}
	
	public String toString() {
		String paragraphs = "SECTION \n";
		
		for(int i = 0; i< paragraphList.size(); i++) {
			String p = paragraphList.get(i).toString();
			paragraphs += "paragraph [" + i + "] \n" + p + "\n";
			
		}
		return paragraphs;
	}
	
}
