import Utils.XMLParser;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length != 0) {
			System.out.println("Fichier : " + args[0]);
			XMLParser xmlParser = new XMLParser();
			xmlParser.parserDoc(args[0]);
		}
		
	}

}
