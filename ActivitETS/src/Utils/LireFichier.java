package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
import org.xml.sax.helpers.XMLFilterImpl;
import org.xml.sax.helpers.XMLReaderFactory;

public class LireFichier {

	private long dateStart, dateStop;
	
	public LireFichier() {

	}

	public void lireFic(String path) {
		try {
			FileInputStream fis;
			fis = new FileInputStream(path);
			InputSource is = new InputSource(fis);

			//Parse les fichier et récupere les dates
			XMLFilterImpl xr = recupererDates();

			Source src = new SAXSource(xr, is);
			// Création du fichier de sortie
			File file = new File("CreationSAX2.xml");
			Result resultat = new StreamResult(file);

			TransformerFactory.newInstance().newTransformer()
					.transform(src, resultat);
		} catch (TransformerConfigurationException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (TransformerException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (TransformerFactoryConfigurationError e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public XMLFilterImpl recupererDates() {
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
					if (tagName.equals("name")) {
						ch = "testName".toCharArray();
						start = 0;
						length = ch.length;
					}
					
					if(dateOpenElement) {
						dateStart = Long.parseLong(new String(ch, start, length));
						
						System.out.println("date open : " + dateStart);
					}
					if(dateCloseElement) {
						dateStop = Long.parseLong(new String(ch, start, length));
						System.out.println("date open : " + dateStop);
					}
					//super.characters(ch, start, length);
				}
			};
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return xr;
	}

	public long getDateStart() {
		return dateStart;
	}

	public void setDateStart(long dateStart) {
		this.dateStart = dateStart;
	}

	public long getDateStop() {
		return dateStop;
	}

	public void setDateStop(long dateStop) {
		this.dateStop = dateStop;
	}
	
	

}
