package csvsaver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvReader {
	
	private String path;
	
	private ArrayList<String> fileEntries;
	
	public CsvReader(String filePath) {
		path = filePath;
		
		fileEntries = new ArrayList<String>();
	}
	
	public boolean ReadFile() {
		
		String line;
		boolean lectureOK = true;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			while((line = br.readLine()) != null) {
				fileEntries.add(line);
			}
			
			fileEntries.remove(0);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			lectureOK = false;
		}
		catch (IOException e) {
			e.printStackTrace();
			lectureOK = false;
		}
		
		return lectureOK;
		
	}

	public ArrayList<String> getFileEntries() {
		return fileEntries;
	}

}
