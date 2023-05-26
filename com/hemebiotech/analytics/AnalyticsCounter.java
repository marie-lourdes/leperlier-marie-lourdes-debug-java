package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * the AnalyticsCounter class gathers all the methods required to get a list
 * of all symptoms duplicated, to count the number of occurrence of its
 * symptoms, to save all symptoms and number of occurrences in file result.out
 * in alphabetical order
 *<p>the AnalyticsCounter is composed of a reader Interface and a writer Interface 
 * implemented by ReadSymptomDataFromFile and WriteSymptomDataToFile 
 * to analyze and to count all symptoms and its occurrences,
 * the methods of interfaces  and his own methods perform these tasks
 *<br> 
 *<li>first to read</li>
 *<li>then to extract the contents of the file in a List</li>
 *<li>then to reorganize and process the information extracted from the file</li>
 *<li>read and written in a file to save processing this symptom information 
 * and number of occurrences</li></p>
 *
 * @param reader        the type ISymtomReader reader parameter is required to use the
 *                      method of the interface implemented by ReadSymptomDataFromFile
 *                      class in an instance of AnalyticsCounter class
 * 
 * @param writer        the type ISymtomReader reader parameter is required to use the
 *                      method of the interface implemented by WriteSymptomDataToFile
 *                      class in an instance of AnalyticsCounter class
 *
 * the parameters reader and writer will be used to
 *
 *<b>
 *<li>instantiate ReadSymptomDataFromFile with the "reader" reference</li>
 *<li>instantiate WriteSymptomDataToFile with the "writer" reference</li>
 *</b>
 *
 *  @see                "implementation of the method getSymptoms of the Interface ISymtomReader 
                        in ReadSymptomDataFromFile"
 *
 *  @see                "implementation of the method writeSymptoms of the Interface ISymtomWriter 
                        in WriteSymptomDataToFile"
 */
public class AnalyticsCounter {
    private ISymptomReader reader;
    private ISymptomWriter writer; 	

    // constructor with attributes class reader and writer - type interface implemented by ReadSymptomDataFromFile class and WriterSymptomDataToFile class
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;	
	} 

/**
 * used to read the symptom.txt and stock all of symptoms in a List no ordered with duplicated symptom
 * calling the method getSymptoms of the interface ISymptomReader from an instance of ReadSymptomDataFromFile class called reader
 *
 * @throws IOException         if there's a problem in reading the file symptoms.txt  
 *     
 * @see                        "the ISymptomReader Interface and its implementation in ReadSymptomDataFromFile"
 *
*/		
    public List<String> getSymptoms() {
		return this.reader.getSymptoms();    
	}

/**
 * used to iterate on the List String Symptoms to generate a Map using a HashMap mapSymptomsOccurences
 *<li>adding in each iteration  each symptom in a Map</li> 
 *<li>incrementing each new symptoms with value 1 and increments in each iteration the existing symptoms in the HashMap<li>
 * this type Map avoid to keep symptom duplicated ,but keep the total of the integer value of String key symptom added if the loop for each find existing symptom
 * 
 * @param symptoms                  a List of String Symptoms that will be converted in a HashMap 
 *                                  with name of symptoms and the number of occurrences 
 *  
 * @throws NullPointerException     if List String symptoms parameter returns a boolean false with the method isEmpty() 
 * 
 * @throws Exception                if other errors occur when iterating on the List of symptoms, adding symptoms and its value 1 or value incremented of the number of occurrence in the HasMap
 *     
 * @return                          a HashMap "mapSymptomsOccurences" with the name of symptom as String key and Integer value 1 or an Integer value that represents the total of number of occurrences of the symptom
 * 
*/
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        // create a HasMap object
        Map<String, Integer> mapSymptomsOccurences = new HashMap<String, Integer>();
        
        try {
            if (!symptoms.isEmpty()) {
                // loop For Each that adds the listSymptoms key symptom and value number occurrence in a TreeMap
                // the number of occurrences is incremented if the symptoms is already present in the TreeMap called mapSymptomsOccurences otherwise 1 is added if the symptom does not exist in the TreeMap
                for (String symptom:symptoms) {
                    if (!mapSymptomsOccurences.containsKey(symptom)) {
                        mapSymptomsOccurences.put(symptom, 1);
                    } else {
                        int numberOfOccurrencesSymptom= mapSymptomsOccurences.get(symptom);
                        mapSymptomsOccurences.put(symptom, numberOfOccurrencesSymptom + 1);
                    }							
                }
            }
        } catch (NullPointerException e) {
            System.err.println("the readListSymptoms is empty: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("an error occurred when calculating the list of symptoms and occurrences in the table mapSymptomsOccurences" + e.getMessage());
            e.printStackTrace();    
        }    
        
	    return  mapSymptomsOccurences;
	}

/**
 * used to iterate on the precedent HashMap symptoms Symptoms and generate Map of symptoms arranged in alphabetical order using a TreeMap 
 * 
 * @param symptoms                  the HasMap Symptoms that will be converted in a TreeMap 
 *                                  with name of symptoms and the number of occurrences 
 *  
 * @throws NullPointerException     if the HashMap symptoms parameter returns a boolean false with the method isEmpty() 
 * 
 * @throws Exception                if other errors occur when putting the content of the HashMap symptoms in the TreeMap mapSymptomsOccurencesSorted 
 *     
 * @return                          a TreeMap "mapSymptomsOccurencesSorted" with the name of symptom as String key arranged in alphabetical order
 * 
*/
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        // creation of the TreeMap to arrange  the content of mapSymptomsOccurences in alphabetical order
        Map<String, Integer> mapSymptomsOccurencesSorted = new TreeMap<String, Integer>();

        try {    
			if (!symptoms.isEmpty()) {
				// used to put all content of "mapSymptomsOccurences" in TreeMap "mapSymptomsOccurencesSorted" in alphabetical order	
				mapSymptomsOccurencesSorted.putAll(symptoms);	
			}			
		} catch (NullPointerException e) {
			System.err.println(" mapSymptomsOccurences is empty: " + e.getMessage());
			e.printStackTrace();
				
		} catch (Exception e) {
			System.err.println("an error occurred when sorting the mapSymptomsOccurences and adding in the table mapSymptomsOccurencesSorted :" + e.getMessage());
			e.printStackTrace();
		}

       return mapSymptomsOccurencesSorted;     
	}

/**
 * used to get all symptom arranged in alphabetical order 
 *
 *<li>iterating on the TreeMap "mapSymptomsOccurencesSorted" with Iterator Interface</li>
 *<li> writing saving the list of symptoms and its number of occurrences in the file result.out with a BufferedWriter object and FileWriter Object</li>
 * 
 * @see           "the ISymptomReader Interface and its implementation in WriteSymptomDataToFile"
 *
*/
    public void writeSymptoms(Map<String, Integer> symptoms) { 
       this.writer.writeSymptoms(symptoms);
    }
}