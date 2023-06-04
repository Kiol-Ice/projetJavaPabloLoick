package db;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Database {
	
	public void EnvoieDonnee(String Numero_Securite_Sociale, String Nom, String Prenom, Date Date_Naissance, String Numero_Telephone, String E_Mail, String ID_Remboursement, String Code_Soin, Float Montant_Remboursement, Timestamp Timestamp_Fichier)
	{
		try {
			// Chargement du pilote JDBC
		    Class.forName("org.mariadb.jdbc.Driver");
	
		    // Création de la connexion à la base de données
		    String url = "jdbc:mariadb://localhost:3306/projet_java";
		    String username = "root";
		    String password = "test";
		    Connection conn = DriverManager.getConnection(url, username, password);
		    
		    //Préparation de la requêtes SQL
			String sql = "INSERT INTO users (Numero_Securite_Sociale, Nom, Prenom, Date_Naissance, Numero_Telephone, E_Mail, ID_Remboursement, Code_Soin, Montant_Remboursement, Timestamp_Fichier) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, Numero_Securite_Sociale);
			statement.setString(2, Nom);
			statement.setString(3, Prenom);
			statement.setDate(4, Date_Naissance);
			statement.setString(5, Numero_Telephone);
			statement.setString(6, E_Mail);
			statement.setString(7, ID_Remboursement);
			statement.setString(8, Code_Soin);
			statement.setFloat(9, Montant_Remboursement);
			statement.setTimestamp(10, Timestamp_Fichier);
			
			//Insertion des données
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
			}
			
			//Fermeture de la connexion
			statement.close();
			conn.close();	
		}
		catch (ClassNotFoundException erreurClasse) {
			erreurClasse.printStackTrace();
		} catch (SQLException e) {
		    e.printStackTrace();
		}

	}
}