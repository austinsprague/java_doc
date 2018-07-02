import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Document that build the instance of Document and HTML templates
 * @author Sprague
 *
 */
public class Document {
	/**
	 * Private Document instance, should only have one instance and will be instatiated with getInstance
	 */
	private static Document instance = null;
	/**
	 * LinkedList of Sections
	 */
	private LinkedList<Section> sectionList;
	/**
	 * String of the document file name used for HMTL and File name templates
	 */
	private String docName;
	
	/**
	 * private constructor to restrict one document instance
	 */
	private Document() {
		//private constructor
	}
	
	/**
	 * Method to retrieve or instantiate one Document instance
	 * @return Document instance
	 */
	public  static Document getInstance() {
		if(instance == null) {
			instance = new Document();
		}
		return instance;
	}
	
	/**
	 * Initialized Sections list and assigns document name
	 * @param name String to assign the Document name
	 */
	public void newDoc(String name) {
		docName = name;
		sectionList = new LinkedList<Section>();
	}
	
	/**
	 * Get the size of the Sections in the Document
	 * @return Integer of size of Sections list
	 */
	public int getSize() {
		return sectionList.size();
	}
	
	/**
	 * Get the Document Name
	 * @return String of the Document name
	 */
	public String getDocName() {
		return docName;
	}
	
	/**
	 * Add a new Section to the Sections list in the Document
	 * @param section Section to add to the SectionList in the Document
	 */
	public void addSection(Section section) {
		sectionList.add(section);
	}
	
	/**
	 * Add a Section to the Section list at a particular index of the list
	 * @param index Integer of the index of the SectionList
	 * @param section Section to add to the SectionList
	 */
	public void addSection(int index, Section section) {
		sectionList.add(index, section);
	}
	
	/**
	 * Get the Section from the SectionList
	 * @param index Integer of the index from the SectionList
	 * @return Section of the index in the SectionList
	 */
	public Section getSection(int index) {
		return sectionList.get(index);
	}
	
	/**
	 * Remove the Section from the SectionList
	 * @param index Integer of the index from the SectionList to remove
	 */
	public void removeSection(int index) {
		sectionList.remove(index);
	}
	
	/**
	 * Serialize and save SectionsList of the Document to a file created using the Document Name that was assigned with newDoc, to the folder /DocFiles in current directory. It will make folder if does not exist.
	 * @throws IOException Exception thrown if error with IO
	 */
	public void save() throws IOException {
		Path folderPath = Paths.get(System.getProperty("user.dir") + "/DocFiles");
		Files.createDirectories(folderPath);
		File fileName = new File(folderPath + "/" + docName + ".wpd");
		
	    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
	    out.writeObject(sectionList);
	    out.close();
	}
	
	/**
	 * Retrieve the file from the folder /DocFiles with the FileName without extension, appends .wpd
	 * @param fileName String, not including file extension. String should match the Document Name that was assigned, no need for file extension
	 * @throws IOException Errors if IO
	 * @throws ClassNotFoundException Object Errors
	 */
	@SuppressWarnings("unchecked")
	public void open(String fileName) throws IOException, ClassNotFoundException {
		Path folderPath = Paths.get(System.getProperty("user.dir") + "/DocFiles");
		File fileN = new File(folderPath + "/" + fileName + ".wpd");
		
		FileInputStream fi = new FileInputStream(fileN);
		ObjectInputStream oi = new ObjectInputStream(fi);
		sectionList = (LinkedList<Section>)oi.readObject();
		oi.close();
	}
	
	/**
	 * Close the file, removing all data from SectionList and document name
	 */
	public void close() {
		docName = "";
		sectionList.clear();
		
	}
	
	/**
	 * Saves an HTML file of the Sections and Paragraphs to folder /HtmlFiles to render nicely
	 * @throws FileNotFoundException Errors if there is no file found
	 * @throws IOException Errors IO
	 */
	public void saveToHtml() throws FileNotFoundException, IOException {
		
		// BUILD OR GET THE HTML FILE WITH THE CORRESPONDING DOCNAME
		Path folderPath = Paths.get(System.getProperty("user.dir") + "/HtmlFiles");
		Files.createDirectories(folderPath);
		File f = new File(folderPath + "/" + docName + ".html");
			
		BufferedWriter bw = new BufferedWriter( new FileWriter(f));
		
		// BUILD HTML TEMPLATE
		String tab = "  ";
		bw.write("<!DOCTYPE html> \n "
				+ "<link href=\"https://stackpath.bootstrapcdn.com/bootswatch/4.1.1/lux/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-4KIc2mnKfAA7VjirNLk2Sqp7jxFNq1q8+FhYGxhW2l52lt4HJsfksL+hjswHfbl/\" crossorigin=\"anonymous\"> \n"
				+ "<html> \n" + tab + "<body class=\"container\"> \n");
		
		
		// BUILD THE HTML TAGS FOR THE SECTIONS AND PARAGRAPHS
		for(int i = 0; i < sectionList.size(); i++) {
			Section section = sectionList.get(i);
			
			// ITERATE THROUGH THE SECTIONS AND THE SECTION'S PARAGRAPHS TO BUILD HTML ELEMENTS
			for(int j= 0; j< section.getSize(); j++) {
				Paragraph paragraph = section.getParagraph(j);
				Paragraph.ParaStyle style = paragraph.getParaStyle();
				
				// IF THE STYLE INCLUDES HEADINGS, LISTS, OR STYLE ALIGNS, BUILD TAG WITH TEXT, ELSE BUILD WITH ONLY P TAG
				if(style != null) {
					String tag = getHtmlTag(style);
					String openTag = "<" + tag + ">";
					String closeTag = "</" + tag + ">";
					
					if( style == Paragraph.ParaStyle.LIST_BULLETED || 
						style == Paragraph.ParaStyle.LIST_ORDERED) {
						
						bw.write(tab + tab + openTag + " \n");
						String[] para = paragraph.getText().split("\n");
						
						for(String p:para) {
							bw.write(
									tab + tab + tab + "<li> \n" 
									+ tab + tab + tab + tab + p + "\n" 
									+ tab + tab + tab + "</li> \n");
						}
						bw.write(tab + tab + closeTag + " \n");
					} 
					
					else if(style == Paragraph.ParaStyle.HEADING_1 || 
							style == Paragraph.ParaStyle.HEADING_2 || 
							style == Paragraph.ParaStyle.HEADING_3 || 
							style == Paragraph.ParaStyle.HEADING_4 || 
							style == Paragraph.ParaStyle.HEADING_5) {
						bw.write(	 tab + openTag + " \n" 
									+ tab + tab + paragraph + "\n" 
									+ tab + closeTag +" \n"
								);
					} 
					else if(style == Paragraph.ParaStyle.RIGHT_ALIGN ||
							style == Paragraph.ParaStyle.LEFT_ALIGN ) {
						
						bw.write(tab + tab + "<p style=\"" + tag + "\"> \n" 
								+ tab + tab + tab + paragraph + "\n"
								+ tab + tab + "</p> \n");
						
					}
				} else {
					bw.write(tab + tab + "<p> \n" 
								+ tab + tab + tab + paragraph + "\n"
								+ tab + tab + "</p> \n");
				}
			}
		}
		
		// END THE HTML TEMPLATE
		bw.write(tab + "</body> \n" + "</html>");
		bw.close();
		
	}	
	
	/**
	 * Get the HTML tag needed for template for each of the Paragraph Styles
	 * @param paraStyle Enum of Paragraph.ParaStyle
	 * @return String of the HTML tag for template
	 */
	private String getHtmlTag(Paragraph.ParaStyle paraStyle) {
		String tag;
		switch (paraStyle) {
        	case HEADING_5:
            tag = "h5";
            break;
        	case HEADING_4:
            tag = "h4";
            break;
        	case HEADING_3:
        		tag = "h3";
        		break;
        case HEADING_2:
        		tag = "h2";
        		break;  
        case HEADING_1:
    			tag = "h1";
    			break;
        case LIST_BULLETED:
			tag = "ul";
			break; 
        case LIST_ORDERED:
			tag = "ol";
			break; 
        case RIGHT_ALIGN:
        		tag = "text-align:right";
        		break;
        case LEFT_ALIGN:
    			tag = "text-align:left";
    			break;
        default:
        		tag = "p";
            break;
		}
		return tag;
	}
	
	public String toString() {
		String sections = "DOCUMENT \n______________________________ \n";
		
		for(int i = 0; i< sectionList.size(); i++) {
			String s = sectionList.get(i).toString();
			sections += "[" + i + "] " + s + "\n";	
		}
		return sections;
	}
}
