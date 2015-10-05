package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLFilterImpl;
import org.xml.sax.helpers.XMLReaderFactory;

public class OperationsFichiers {

	private String quizName, quizResume;
	FileInputStream fis;
	private LocalDateTime dateOpen,dateClose;
	private Instant tsOpen, tsClose;
	TimeZone timeZone = TimeZone.getDefault();
	
	public OperationsFichiers() {
		
	}

	public void lireFic(String path) {
		try {
			fis = new FileInputStream(path);
			//InputSource is = new InputSource(fis);

			//	 les fichier et récupere les dates
			//XMLFilterImpl xr = recupererDates();
			
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			
			DefaultHandler handler = new DefaultHandler()  {
				private String tagName = "";
				boolean dateOpenElement = false;
				boolean dateCloseElement = false;
				boolean quizNameBool = false;
				boolean quizResumeBool = false;

				@Override
				public void startElement(String uri, String localName,
						String qName, Attributes atts) throws SAXException {
					if (qName.equals("name")) {
						System.out.println("name : " + qName);
						quizNameBool = true;
					}
					if (qName.equals("intro")) {
						System.out.println("Resume : " + qName);
						quizResumeBool = true;
					}
					if (qName.equals("timeopen")) {
						System.out.println("Time open : " + qName);
						dateOpenElement = true;
					}
					if (qName.equals("timeclose")) {
						System.out.println("Time close : " + qName);
						dateCloseElement = true;
					}
					super.startElement(uri, localName, qName, atts);
				}

				public void endElement(String uri, String localName,
						String qName) throws SAXException {
					if (qName.equals("name")) {
						quizNameBool = false;
					}
					if (qName.equals("intro")) {
						quizResumeBool = false;
					}
					if (qName.equals("timeopen")) {
						dateOpenElement = false;
					}
					if (qName.equals("timeclose")) {
						dateCloseElement = false;
					}
					super.endElement(uri, localName, qName);
				}

				@Override
				public void characters(char[] ch, int start, int length) throws SAXException {
					if(quizNameBool) {
						quizName = new String(ch, start, length);
						System.out.println("name : " + quizName);
					}
					if(quizResumeBool) {
						quizResume += new String(ch, start, length);
						System.out.println("intro : " + quizResume);
					}
					if(dateOpenElement) {
						tsOpen = Instant.ofEpochSecond(Long.parseLong(new String(ch, start, length)));
						dateOpen = LocalDateTime.ofInstant(tsOpen, ZoneId.systemDefault());
						
						System.out.println("date open : " + dateOpen);
					}
					if(dateCloseElement) {
						tsClose = Instant.ofEpochSecond(Long.parseLong(new String(ch, start, length)));
						dateClose = LocalDateTime.ofInstant(tsClose, ZoneId.systemDefault());
						System.out.println("date open : " + dateClose);
					}
					super.characters(ch, start, length);
				}
			};
			
			saxParser.parse(path, handler);

		} catch (TransformerFactoryConfigurationError e2) {
			e2.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ecrireFichier(ArrayList<LocalDateTime> listesNewDates, String path) {
		
		try {			
			//fis = new FileInputStream(path);
			InputSource is = new InputSource(fis);

			//les fichier et récupere les dates
			XMLFilterImpl xr = changeDates(listesNewDates);
			
			
			Source src = new SAXSource(xr, is);
			// Création du fichier de sortie
			File file = new File(path);
			Result resultat = new StreamResult(file);

			TransformerFactory.newInstance().newTransformer().transform(src, resultat);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public XMLFilterImpl changeDates(ArrayList<LocalDateTime> listesNewDates) {
		XMLFilterImpl xr = null;
		try {
			xr = new XMLFilterImpl(XMLReaderFactory.createXMLReader()) {
				private String tagName = "";
				boolean dateOpenElement = false;
				boolean dateCloseElement = false;

				@Override
				public void startElement(String uri, String localName,
						String qName, Attributes atts) throws SAXException {
					
					if (qName.equals("timeopen")) {
						System.out.println("Time open : " + tagName);
						dateOpenElement = true;
					}
					if (qName.equals("timeclose")) {
						System.out.println("Time close : " + tagName);
						dateCloseElement = true;
					}
					super.startElement(uri, localName, qName, atts);
				}

				public void endElement(String uri, String localName,
						String qName) throws SAXException {
					
					if (qName.equals("timeopen")) {
						dateOpenElement = false;
					}
					if (qName.equals("timeclose")) {
						dateCloseElement = false;
					}
					super.endElement(uri, localName, qName);
				}

				@Override
				public void characters(char[] ch, int start, int length) throws SAXException {
					
					if(dateOpenElement) {
						
						ZoneId zoneId = ZoneId.systemDefault(); // or: ZoneId.of("Europe/Oslo");
						long epoch = listesNewDates.get(0).atZone(zoneId).toEpochSecond();
						ch = String.valueOf(epoch).toCharArray();
						start = 0;
						length = ch.length;
					}
					if(dateCloseElement) {
						
						ZoneId zoneId = ZoneId.systemDefault(); // or: ZoneId.of("Europe/Oslo");
						long epoch = listesNewDates.get(1).atZone(zoneId).toEpochSecond();
						ch = String.valueOf(epoch).toCharArray();
						start = 0;
						length = ch.length;
					}
					super.characters(ch, start, length);
				}
			};
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return xr;
	}

	public LocalDateTime getDateOpen() {
		return dateOpen;
	}

	public void setDateOpen(LocalDateTime dateOpen) {
		this.dateOpen = dateOpen;
	}

	public LocalDateTime getDateClose() {
		return dateClose;
	}

	public void setDateClose(LocalDateTime dateClose) {
		this.dateClose = dateClose;
	}

	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	public String getQuizResume() {
		return quizResume;
	}

	public void setQuizResume(String quizResume) {
		this.quizResume = quizResume;
	}
	
	
	
	

}
