package Utils;

import java.util.List;

import org.xml.sax.InputSource;

import Activites.Quiz;

public class AnnuaireSource extends InputSource {
	private List<Quiz> quizs;

	public AnnuaireSource(List<Quiz> quizs) {
		super();
		this.quizs = quizs;
	}

	public List<Quiz> getQuizs() {
		return quizs;
	}
	// En fait, contrairement à cet exemple, de nombreuses méthodes
	// d'InputSource travaillent avec des streams.
	// Cela peut vous simplifier le travail sur des fichiers XML existants.
}
