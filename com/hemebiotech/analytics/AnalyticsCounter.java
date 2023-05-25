package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * the AnalyticsCounter class regroups all the methods required to get a list
 * of all symptoms duplicated, to count the number of occurrence of its
 * symptoms, to save all symptoms and number of occurrences in file result.out
 * in alphabetical order"
 *
 * @param reader        the type ISymtomReader reader parameter is required to use the
 *                      method of the interface implemented by ReadSymptomDataFromFile
 *                      class in an instance of AnalyticsCounter class
 * 
 * @param writer        the type ISymtomReader reader parameter is required to use the
 *                      method of the interface implemented by WriteSymptomDataToFile
 *                      class in an instance of AnalyticsCounter class
 * <p>
 * the parameters reader and writer will be used to
 * <b>
 * <li>instantiate ReadSymptomDataFromFile with the "reader" reference</li>
 * <li>instantiate WriteSymptomDataToFile with the "writer" reference</li>
 *
 */
public class AnalyticsCounter { 
/**	private static ISymptomReader readerSymptomsData;
	private static List<String> readListSymptoms;
	public   Map<String, Integer> mapSymptomsOccurences; 
    private static Map<String,Integer> mapSymptomsOccurencesSorted; */

    private  ISymptomReader reader;
	private  ISymptomWriter writer;
	
	//constructor with attributes class reader and writer - type interface implemented by  ReadSymptomDataFromFile class and  WriterSymptomDataToFile class
	public  AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader= reader;
		this.writer= writer;	
	} 

  		
    public List<String> getSymptoms() {
		  return this.reader.getSymptoms();    
	}

    public Map<String,Integer> countSymptoms(List<String> symptoms) {
        Map<String,Integer> mapSymptomsOccurences= new HashMap<String,Integer>();
        
            try{
                if(!symptoms.isEmpty()){
                    // loop For Each that adds the listSymptoms key symptom and value number occurrence in a TreeMap
                    // the number of occurrences is incremented if the symptoms is already present in the TreeMap called mapSymptomsOccurences otherwise 1 is added if the symptom does not exist in the TreeMap
                    for( String symptom:symptoms ) {
                        if(!mapSymptomsOccurences.containsKey(symptom)) {
                            mapSymptomsOccurences.put(symptom,1);
                        }else {
                            int numberOfOccurrencesSymptom= mapSymptomsOccurences.get(symptom);
                            mapSymptomsOccurences.put(symptom, numberOfOccurrencesSymptom+1);
                        }							
                    }
                }
            }catch(NullPointerException e) {
                System.err.println("the readListSymptoms is empty: " + e.getMessage());
                e.printStackTrace();
            }catch(Exception e){
                System.err.println("an error occurred when calculating the list of symptoms and occurrences in the table mapSymptomsOccurences" + e.getMessage());
                e.printStackTrace();    
            }    
        
	    return  mapSymptomsOccurences;
	}

    public Map<String,Integer> sortSymptoms(Map<String,Integer> symptoms) {
       // creation of the TreeMap to arrange  the content of mapSymptomsOccurences in alphabetical order
        Map<String,Integer> mapSymptomsOccurencesSorted = new TreeMap<String,Integer>();
        try {    
			if (!symptoms.isEmpty()){
				//used to to put all content of "mapSymptomsOccurences" in TreeMap "mapSymptomsOccurencesSorted" in alphabetical order	
					mapSymptomsOccurencesSorted.putAll(symptoms);	
			}			
		}catch(NullPointerException e) {
			System.err.println(" mapSymptomsOccurences is empty: " + e.getMessage());
			e.printStackTrace();
				
		}catch(Exception e) {
			System.err.println("an error occurred when sorting the mapSymptomsOccurences and adding in the table mapSymptomsOccurencesSorted :" + e.getMessage());
			e.printStackTrace();
		}
       return mapSymptomsOccurencesSorted;     
	}

    public void writeSymptoms(Map<String,Integer> symptoms) { 
       this.writer.writeSymptoms(symptoms);
    }

}