package db;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Database {
	
	private static final String url = "jdbc:mariadb://localhost:3306/projet_java";
	
	private static final String username = "root";
	
	private static final String password = "test";
	
	public Connection ConnectionBase() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, username, password);
		}
		catch (SQLException e) {
		    e.printStackTrace();
		}
		return conn;
	}
	
	public boolean FermetureBase(Connection conn) {
		boolean result = true;
		
		try {
			conn.close();	
		}
		catch (SQLException e) {
		    e.printStackTrace();
		    result = false;
		}
		return result;
	}
	
	public int EnvoieDonnee(String Numero_Securite_Sociale, String Nom, String Prenom, Date Date_Naissance, String Numero_Telephone, String E_Mail, String ID_Remboursement, String Code_Soin, Float Montant_Remboursement, Timestamp Timestamp_Fichier)
	{
		int rowsInserted = 0;
		
		try {
			// Chargement du pilote JDBC
		    Class.forName("org.mariadb.jdbc.Driver");
	
		    // Création de la connexion à la base de données
		    Connection conn = ConnectionBase();
		    
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
			rowsInserted = statement.executeUpdate();
			
			//Fermeture de la connexion
			statement.close();
			FermetureBase(conn);
		}
		catch (ClassNotFoundException erreurClasse) {
			erreurClasse.printStackTrace();
		} catch (SQLException e) {
		    e.printStackTrace();
		}

		return rowsInserted;
	}
	
	public boolean IsConnectionWorking() {
		boolean result = true;
		
		Connection conn = ConnectionBase();
		if (conn == null)
		{
			result = false;
		}
		else
		{
			FermetureBase(conn);
		}
		return result;
	}
}