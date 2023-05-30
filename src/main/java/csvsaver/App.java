package csvsaver;

import db.DbTest;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DbTest test = new DbTest("loick", "test");
		
		System.out.println(test.getUser());
		
		
		// cmd de lancement 
		// java -jar target/projet-pablo-loick-0.0.1-SNAPSHOT.jar
		//test commit
	}

}
