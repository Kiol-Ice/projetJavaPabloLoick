package csvsaver;

import java.io.File;

public class App {

	public static void main(String[] args) {
		
		// cmd de lancement 
		// java -jar target/projet-pablo-loick-0.0.1-SNAPSHOT.jar
		
		File folder = new File("./fileInput/"); // Dossier d'input
		File[] listOfFiles = folder.listFiles(); //Récup le nom de tous les fichiers

		int i = 1;
		for (File file : listOfFiles) {
		    if (file.isFile()) {	
		    	
		    	System.out.println("File number " + i);
		        String filePath = "./fileInput/" + file.getName(); // chemin relatif des .csv
		        
		        CsvReader reader = new CsvReader(filePath); // Instanciation du Reader
		        if (reader.ReadFile()) // Lecture du fichier
		        {
		        	System.out.println(reader.getFileEntries().get(0)); // Affichage de la 1ere ligne du fichier
		        }
		        
		        i++;
		    }
		}
		
		
	}

}
