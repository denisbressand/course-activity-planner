package Utils;

import java.io.IOException;
import java.util.List;

import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.AttributesImpl;

import Activites.Quiz;

public class SaxParser implements XMLReader {
	private ContentHandler handler;
	private AttributesImpl atts = new AttributesImpl();



	public void parse(String systemId) throws IOException, SAXException {
		
	}
	// autres méthodes à implémenter

	@Override
	public ContentHandler getContentHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DTDHandler getDTDHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityResolver getEntityResolver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ErrorHandler getErrorHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getFeature(String arg0) throws SAXNotRecognizedException,
			SAXNotSupportedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getProperty(String arg0) throws SAXNotRecognizedException,
			SAXNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setContentHandler(ContentHandler arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDTDHandler(DTDHandler arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEntityResolver(EntityResolver arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setErrorHandler(ErrorHandler arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFeature(String arg0, boolean arg1)
			throws SAXNotRecognizedException, SAXNotSupportedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setProperty(String arg0, Object arg1)
			throws SAXNotRecognizedException, SAXNotSupportedException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void parse(InputSource input) throws IOException, SAXException {
		// TODO Auto-generated method stub
		
	}
}
