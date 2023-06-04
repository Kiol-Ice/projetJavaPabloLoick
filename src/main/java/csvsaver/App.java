package csvsaver;
import db.Database;
import java.io.File;
import java.sql.Timestamp;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class App {

	public static void main(String[] args) {
		Database db = new Database();
		boolean dbOK = db.IsConnectionWorking();
		
		if (!dbOK)
		{
			System.out.println("Une erreur est survenue lors de la connection à la base de donnees, vérifier son statut.");
			return;
		}
		
		File folder = new File("./fileInput/"); // Dossier d'input
		File[] listOfFiles = folder.listFiles(); //Récup le nom de tous les fichiers

		int donneeEnvoye = 0;
		for (File file : listOfFiles) {
		    if (file.isFile()) {	
		    	
		    	System.out.println("Fichier : " + file.getName());
		        String filePath = "./fileInput/" + file.getName(); // chemin relatif des .csv
		        
		        CsvReader reader = new CsvReader(filePath); // Instanciation du Reader
		        if (reader.ReadFile()) // Lecture du fichier
		        {
		        	for(int j=0; j< reader.getFileEntries().size(); j++)
		        	{
		        		String[] data = reader.getFileEntries().get(j).split(","); // récupération des colonnes ligne par ligne
		        		Timestamp timestamp = new Timestamp(0);
		        		Date date = new Date(0);
			        	
			        	try {
			        		String timestampString = file.getName().split("_")[1].split("\\.")[0];
			        		timestamp = new Timestamp(new SimpleDateFormat("yyyyMMddHHmmss").parse(timestampString).getTime());
			        		date = new Date( new SimpleDateFormat("dd-MM-yyyy").parse(data[3]).getTime());
			        	}
			        	catch(java.text.ParseException e)
			        	{
			        		e.printStackTrace();	
			        	}
			        	int result = db.EnvoieDonnee(data[0], data[1], data[2], date, data[4], data[5], data[6], data[7], Float.valueOf(data[8]), timestamp);
			        	if (result > 0)
			        	{
			        		donneeEnvoye++;
			        	}
		        	}
		        }
		        
		        System.out.println(donneeEnvoye + " données insérées avec succès depuis le fichier " + file.getName());
		        donneeEnvoye = 0;
		    }
		}
	}

}
