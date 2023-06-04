package csvsaver;
import db.Database;
import java.io.File;
import java.sql.Timestamp;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class App {

	public static void main(String[] args) {
		Database db = new Database();
		
		// cmd de lancement 
		// java -jar target/projet-pablo-loick-0.0.1-SNAPSHOT.jar
		
		File folder = new File("./fileInput/"); // Dossier d'input
		File[] listOfFiles = folder.listFiles(); //Récup le nom de tous les fichiers

		int i = 1;
		for (File file : listOfFiles) {
		    if (file.isFile()) {	
		    	
		    	System.out.println("File number " + i);
		        String filePath = "./fileInput/" + file.getName(); // chemin relatif des .csv
	        	String timestampString = file.getName().split("_")[1].split("\\.")[0];
		        
		        CsvReader reader = new CsvReader(filePath); // Instanciation du Reader
		        if (reader.ReadFile()) // Lecture du fichier
		        {
		        	String[] data = reader.getFileEntries().get(0).split(","); // récupération de la 1ere ligne du fichier
	        		Timestamp timestamp = new Timestamp(0);
	        		Date date = new Date(0);
		        	
		        	try {
		        		timestamp = new Timestamp(new SimpleDateFormat("yyyyMMddHHmmss").parse(timestampString).getTime());
		        		date = new Date( new SimpleDateFormat("dd-MM-yyyy").parse(data[3]).getTime());
		        	}
		        	catch(java.text.ParseException e)
		        	{
		        		e.printStackTrace();	
		        	}
		        	db.EnvoieDonnee(Integer.parseInt(data[0].replaceAll(" ", "").replaceAll("\"", "")), data[1], data[2], date, data[4].replaceAll(" ", "").replaceAll("\"", ""), data[5], data[6], data[7], Float.valueOf(data[8]), timestamp);
		        }
		        
		        i++;
		    }
		}
		
		
	}

}
