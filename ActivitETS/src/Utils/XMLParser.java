package Utils;

/*import java.io.File;
 import java.io.IOException;
 import java.util.ArrayList;
 import java.util.Date;
 import java.util.List;

 import javax.xml.parsers.DocumentBuilder;
 import javax.xml.parsers.DocumentBuilderFactory;
 import javax.xml.parsers.ParserConfigurationException;

 import org.w3c.dom.Document;
 import org.w3c.dom.Element;
 import org.w3c.dom.Node;
 import org.w3c.dom.NodeList;
 import org.xml.sax.SAXException;

 import Activites.Quiz;

 public class XMLParser {

 public void parserDoc(String fic) {

 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
 DocumentBuilder builder;
 try {
 builder = factory.newDocumentBuilder();
 // Load the input XML document, parse it and return an instance of
 // the
 // Document class.
 Document document;
 document = builder.parse(new File(fic));

 List<Quiz> quizs = new ArrayList<Quiz>();
 NodeList nodeList = document.getDocumentElement().getChildNodes();
 for (int i = 0; i < nodeList.getLength(); i++) {
 Node node = nodeList.item(i);

 if (node.getNodeType() == Node.ELEMENT_NODE) {
 Element elem = (Element) node;

 // Get the value of the ID attribute.
 String id = node.getAttributes().getNamedItem("quiz")
 .getNodeValue();

 // Get the value of all sub-elements.
 String nom = elem.getElementsByTagName("name").item(0)
 .getChildNodes().item(0).getNodeValue();

 String resume = elem.getElementsByTagName("Lastname")
 .item(0).getChildNodes().item(0).getNodeValue();

 int dateStart = Integer.parseInt(elem
 .getElementsByTagName("timeopen").item(0)
 .getChildNodes().item(0).getNodeValue());

 int dateStop = Integer.parseInt(elem
 .getElementsByTagName("timeclose").item(0)
 .getChildNodes().item(0).getNodeValue());

 System.out.println(id + " //nom : " + nom + " //resume : "
 + resume + " //start : " + dateStart + " //stop : "
 + dateStop);

 // employees
 // .add(new Quiz(Integer.parseInt(id), nom, resume,
 // dateStart, dateStop));
 }
 }

 // Print all employees.
 for (Quiz quiz : quizs)
 System.out.println(quiz.toString());

 } catch (ParserConfigurationException e1) {
 // TODO Auto-generated catch block
 e1.printStackTrace();
 } catch (SAXException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 } catch (IOException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }

 }
 }*/

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import Activites.Quiz;

public class XMLParser extends DefaultHandler {

	private static List<Quiz> quizs = new ArrayList<Quiz>();
	private static Quiz quiz = null;
	private static String text = null;

	@Override
	// A start tag is encountered.
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		switch (qName) {
		// Create a new Employee.
		case "quiz": {
			quiz = new Quiz();
			quiz.setId(Integer.valueOf(attributes.getValue("id")));
			break;
		}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		switch (qName) {
		case "quiz": {
			// The end tag of an employee was encountered, so add the employee
			// to the list.
			quizs.add(quiz);
			break;
		}
		case "name": {
			quiz.setNom(text);
			break;
		}
		case "intro": {
			quiz.setResume(text);
			break;
		}
		case "timeopen": {
			quiz.setDateStart(text);
			break;
		}
		case "timeclose": {
			quiz.setDateStop(text);
			break;
		}
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		text = String.copyValueOf(ch, start, length).trim();
	}

	public void parserDoc(String fic) {

		try {
			SAXParserFactory parserFactor = SAXParserFactory.newInstance();
			SAXParser parser;
			parser = parserFactor.newSAXParser();
			XMLParser handler = new XMLParser();
			
			System.out.println("path : " + fic);
			parser.parse(new File(fic), handler);
		} catch (ParserConfigurationException | SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Print all quizs.
		for (Quiz quiz : quizs)
			System.out.println(quiz.toString());
	}

}
