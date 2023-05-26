package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

/**
 *  implementation of the method of the interface ISymptomWriter with annotation @Override 
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
    private String filePath;
    
	// Constructor
	public WriteSymptomDataToFile() {
		this.filePath= "result.out";	
	}
    
/**
 * 
 * @param filepath                    a  path to file to create a file ,to write on it saving symptoms and its number of occurrences 
 *
 * @throws IOException                thrown if there's a problem in reading the file symptoms.txt
 *
 * @throws FileNotFoundException      thrown if the path of the file return null
 *
 * @throws NullPointerException       thrown if the TreeMap symptoms parameter return false with the method isEmpty
 *
 * @throws IOException                thrown  if the error occurs when writing on the file result.out
 *
 * @throws Exceptions                 thrown if other errors occurs  when iterating on the TreeMap and the creating and writing on the file result.out
*/
    // Override the  method writeSymptoms of ISymptomWriter interface with Iterator to iterate and  display key -symptom and value - number of occurrences of each symptom
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
       
        // Check if file exist and if there are content on the map symptoms 
		//and possible error in instruction try and intercept error in a instruction catch and print explanation of error
    
        try {     
            if (filePath != null && !symptoms.isEmpty()) {
                // Create object writer with path of file and second argument to write without remove all previous content 
                // the object writer is used by bufferedReader which write line by line on file indicated in the filePath           
                FileWriter fileWriter = new FileWriter(filePath, false);	
                BufferedWriter writer = new BufferedWriter (fileWriter);

                //Create object Iterator to iterate on each entry of the mapSymptomsOccurencesSorted and write each entry in file
                Iterator<Map.Entry<String, Integer>> iteratorMap = symptoms.entrySet().iterator(); 
                
                // Iteration with a method forEachRemaining  which call the  function lambda to execute instruction for each element of each iteration , so can get a clear and readable code instead of using loop while
                // the parameter entrySymptomAndNumberOfOccurrences - type Map.Entry<String,Integer> as a consumer (parameter of the method forEachRemaining used by the expression lambada)
                // the consumer consume  each entry of the instance iterator
                iteratorMap.forEachRemaining(
                    (entrySymptomAndNumberOfOccurrences)-> { 
                        System.out.println(
                            "number of " + entrySymptomAndNumberOfOccurrences.getKey() + ": " + entrySymptomAndNumberOfOccurrences.getValue()
                        ); 
                        try {
                             writer.write( (String) (entrySymptomAndNumberOfOccurrences.getKey() + " : " + entrySymptomAndNumberOfOccurrences.getValue()));
                             writer.newLine();
                        } catch (IOException e) {
                            System.err.println(" writing symptoms to file result.out failed : " + e.getMessage());
                            e.printStackTrace();
                        }	        			
                    }
                );	
                writer.close();
                System.out.println("The file result.out get all list of symtoms and their number of occurrences after writing in it");		        	     
            }
        }catch(FileNotFoundException e){
            System.err.println("a possible error of path of the file result.out : " + e.getMessage()); 
            e.printStackTrace();

        }catch(NullPointerException e) {
    		System.err.println("mapSymptomsOccurencesSorted is empty: " + e.getMessage());
    		e.printStackTrace();
        }catch (Exception e) {
            System.err.println("No symptoms listed! maybe: \n - a possible error of path of the file result.out \n -or the symptoms.txt file is empty  \n - or there're problems in reading the file symptoms.txt or in displaying symptoms in the mapSymptomOccurrences : " + e.getMessage());              
            e.printStackTrace();
        }       
	}									
}