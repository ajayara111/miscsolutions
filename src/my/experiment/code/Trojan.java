package my.experiment.code;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Trojan {
	public static int countCompromised(String xml, String infectedFileId) {
		int infected = 0;
		int visited = 0;
		try {
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xml));

			Document doc = db.parse(is);

			NodeList nodes = doc.getElementsByTagName("file");
			for (int i = 0; i < nodes.getLength(); i++) {
				Element element = (Element) nodes.item(i);

				
				if (element.getAttribute("fileId").equals(infectedFileId)) {
					Node fc = element.getParentNode().getFirstChild();
					//To reduce the duplication as fileId id 3 is used again.
					visited++;
					while (fc.getNextSibling() != null) {

						fc = fc.getNextSibling();
						//Has to be element but not folder element
						if (fc.getNodeType() == Node.ELEMENT_NODE) {
							Element element1 = (Element) fc;
							if ((!(element1.getNodeName()).equals("folder")) ) {
								System.out.println("The infected file is " + element1.getAttribute("fileId"));
								System.out.println("The infected file is " + element1.getNodeName());
								System.out.println("The length" + element1.getNodeName().trim().length());
								infected++;
							}
						}

					}
				}
			}
		}

		catch (Exception e) {
			System.out.println("Exception happens");
		}
		return (infected - visited + 1);
	}

	public static String getCharacterDataFromElement(Element e) {
		Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
			CharacterData cd = (CharacterData) child;
			return cd.getData();
		}
		return "";
	}

	public static void main(String[] args) {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<root>" + "   <snapshot>" + "      <folder>"
				+ "         <file fileId=\"1\"/>" + "         <file fileId=\"2\"/>" + "         <folder>"
				+ "            <file fileId=\"3\"/>" + "            <file fileId=\"4\"/>" + "         </folder>"
				+ "      </folder>" + "   </snapshot>" + "   <snapshot>" + "      <file fileId=\"1\"/>"
				+ "      <file fileId=\"3\"/>" + "      <folder>" + "         <file fileId=\"2\"/>"
				+ "         <file fileId=\"4\"/>" + "         <folder>" + "            <file fileId=\"3\"/>"
				+ "            <file fileId=\"4\"/>" + "         </folder>" + "      </folder>" + "   </snapshot>"
				+ "</root>";

		System.out.println(Trojan.countCompromised(xml, "3"));
	}
}