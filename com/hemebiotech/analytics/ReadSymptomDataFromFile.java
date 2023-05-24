package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> getSymptoms() {
		List<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
                System.out.println("successfully read, get all list of symtoms from symptoms.txt and adding in the readListSymptoms");		        	     
			} catch (IOException e) {
                System.err.println("reading symptoms to file symptoms.txt failed and adding a list of symptoms failed");
				e.printStackTrace();
			}
		}else{
            System.err.println("an error has occurred with the path of the file symptoms.txt");
        }
		
		return result;
	}

}