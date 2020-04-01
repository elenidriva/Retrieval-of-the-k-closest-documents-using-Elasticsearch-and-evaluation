
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
// Δρίβα Ελένη - 3140047
import org.w3c.dom.Element;
import java.io.IOException;

import org.xml.sax.SAXException;
public class XMLParser {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException{
     File spamFolder = new File("C:\\Users\\ele_1\\Documents\\Mathimata\\Συστήματα Ανάκτησης\\Project\\Document Collection\\Parsed files"); 

	//System.out.println("**Parsing the XML files**");
    File[] XMLfiles = spamFolder.listFiles();
	System.out.println("**Parsing the XML files**");

        for(File f: XMLfiles) {
        	
        	//File f = new File("C:\\Users\\ele_1\\Documents\\Mathimata\\Συστήματα Ανάκτησης\\Project\\Document Collection\\Parsed files\\project-rcn-193160_en.xml");
        	System.out.println(f);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(f);
        	
        	String objectiveTagValue = doc.getElementsByTagName("objective").item(0).getTextContent();
        	Node objectiveTagNode = doc.getElementsByTagName("objective").item(0);
        	String titleTagValue = doc.getElementsByTagName("title").item(0).getTextContent();
        	Node titleTagNode = doc.getElementsByTagName("title").item(0);
        	
        	titleTagNode.setTextContent(titleTagValue + " " + objectiveTagValue);
        	
        	 doc.renameNode(titleTagNode, null, "text");
        	 String NewtitleTagValue = doc.getElementsByTagName("text").item(0).getTextContent();
        	//System.out.println("Text Node : " +NewtitleTagValue);
        	
        	Element element = (Element)doc.getElementsByTagName("objective").item(0);
        	objectiveTagNode.getParentNode().removeChild(element);
        	
        	//Write the updates back to the files.
            TransformerFactory transformerFactory = TransformerFactory
                    .newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            String filePath = f.toString();
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);
        	
        }
	}
}

	
	
	
	
	
	
	
	
	
	
	/*
	
		public static void main(String...s) throws JSONException{
			String xml_data = "<student><name>Neeraj</name><age>22</age></student>";
			//converting xml to json
			JSONObject obj = XML.toJSONObject(xml_data);
			System.out.println(obj.toString());
			}
			*/
	
