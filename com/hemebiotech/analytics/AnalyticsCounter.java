package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class AnalyticsCounter { 
/**	private static ISymptomReader readerSymptomsData;
	private static List<String> readListSymptoms;
	public   Map<String, Integer> mapSymptomsOccurences; 
    private static Map<String,Integer> mapSymptomsOccurencesSorted; */

	//instantiation of the WriteSymptomDataToFile class with the mapSymptomsData reference 
	//to use the ISymptomWriter interface method implemented by the class	
	//public  ISymptomWriter writerSymptomsData;

    public  ISymptomReader reader;
	public  ISymptomWriter writer;
	
	//constructor with attributs class reader and writer - type interface implemented by classes ReadSymptomDataFromFile and class WriterSymptomDataToFile
    //these attributs will refernece and instance of the classes correspondant to use its interfaces
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