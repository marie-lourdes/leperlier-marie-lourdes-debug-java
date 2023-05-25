package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *implementation of the method of the interface ISymptomReader with annotation @Override 
 *
*/
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
/**
	 * 
	 * @param filepath              a full or partial path to file with symptom strings in it, one per line
     *
     * @throws IOException         thrown if there's a problem in reading the file symptoms.txt
     *
     * @return                     a List of all String Symptoms obtained from a data source symptom.txt with unic and duplicated symptoms
	 */
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
                System.err.println("reading symptoms to file symptoms.txt failed and adding a list of symptoms failed : "+ e.getMessage());
				e.printStackTrace();
			}
		}	
		return result;
	}

}