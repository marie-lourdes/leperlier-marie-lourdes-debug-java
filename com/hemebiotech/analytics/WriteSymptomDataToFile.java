package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
    String filePath;
	
	// Constructor
	public WriteSymptomDataToFile() {
		this.filePath= "result.out";	
	}
    
    // Override the  method writeSymptoms of ISymptomWriter interface with Iterator to iterate and  display key -symptom and value - number of occurrences of each symptom
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
        // Check if file exist and if there are content on the map symptoms 
		//and possible error in instruction try and intercept error in a instruction catch and print explanation of error
        if (filePath != null && symptoms != null) {
            try {
                // Create object writer with path of file and second argument to write without remove all previous content 
                // the object writer is used by bufferedReader which write line by line on file indicated in the filePath           
                FileWriter fileWriter = new FileWriter(filePath, false);	
                BufferedWriter writer = new BufferedWriter (fileWriter);

                //Create object Iterator to iterate on each entry of the mapSymptomsOccurencesSorted and write each entry in file
                Iterator<Map.Entry<String, Integer>> iteratorMap = symptoms.entrySet().iterator(); 

                // Iteration with a method forEachRemaining  which call the  function lambda to execute instruction for each element of each iteration , so can get a clear and readable code instead of using loop while
                // @param entrySymptomAndNumberOfOccurrences - type Map.Entry<String,Iteger> as a consumer (parameter of the method forEachRemaining used by the expression lambada)
                // the consumer consume  each entry of the instance iterator
                iteratorMap.forEachRemaining(
		        	(entrySymptomAndNumberOfOccurrences)-> { 
		        		System.out.println(
		        			"number of " + entrySymptomAndNumberOfOccurrences.getKey() + ": " + entrySymptomAndNumberOfOccurrences.getValue()
		        		);
		        		//sub-bloc try/catch used to check possible error when the bufferedWriter called "writer" write in the file in each iteration of the map with Iterator interface  "	
		        		try {
							writer.write("number of " + entrySymptomAndNumberOfOccurrences.getKey() + ": " + entrySymptomAndNumberOfOccurrences.getValue());
							writer.newLine();
                           
						} catch (IOException e) {
							e.printStackTrace();
						}	     	        			
		        	}
		        );	
				 writer.close();	     
            } catch (IOException e) {
                e.printStackTrace();
            }
          
		}		
	}							
}