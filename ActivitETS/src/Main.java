import gui.Gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.xml.parsers.SAXParser;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;

import modele.Modele;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLFilterImpl;
import org.xml.sax.helpers.XMLReaderFactory;

import Utils.AnnuaireSource;
import Utils.SaxParser;
import Utils.XMLParser;
import Activites.Quiz;

import org.xml.sax.Attributes;

import controleur.Controleur;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Modele modele = new Modele();
		JFrame vue = new Gui();
		// View view = new View("-");
		Controleur controller = new Controleur(modele, vue);
		controller.contol();

	}

}
