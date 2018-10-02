package assignement1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	String FILENAME ;

	public ReadFile(String FILENAME) {
		this. FILENAME= FILENAME ;
	}
	
	public String getData() {
		
		String sCurrentLine = "";
		String content = "";
		
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

			while ((sCurrentLine = br.readLine()) != null) {
				content += sCurrentLine;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}
}
