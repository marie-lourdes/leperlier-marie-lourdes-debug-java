package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
* The class Main execute a program that get list of symptoms from a file symptoms.txt , count the number of occurence; finally write and save in other file result.out in alphabetical order
*calling the class AnalyticsCounter's methods from an instance of this class
*
*/

public class Main {

	public static void main(String args[]) throws Exception {
        //instantiation of the class ReadSymptomDataFromFile class with the "reader" reference 
	    //to use the ISymptomReader interface method implemented by the class		
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");

        //instantiation of the class WriteSymptomDataToFile class with the "writer" reference 
	    //to use the ISymptomWriter interface method implemented by the class	
        ISymptomWriter writer = new WriteSymptomDataToFile();

        //add instance reader and writer as arguments calling the constructor of the class AnalyticsCounter  and create instance of the class with reference"counter"
        AnalyticsCounter counter = new AnalyticsCounter(reade, writer); 

        //then call the method getSymptoms of interface implemented by the class ReadSymptomDataFromFile and used by the class AnalyticsCounter instancied in "counter" to create List of symptoms readed from symptoms.txt stocked in  "readListSymptoms"
        List<String> readListSymptoms = counter.getSymptoms();

        //then call the method countSymptoms of the class AnalyticsCounter instancied in "counter" to iterate on the ArrayList "readListSymptoms" , get symptoms,
        // the method create a HashMap and  add the symptoms and number of occurrences  calculated  in the HashMap stocked in  "mapSymptomsOccurences" during the iteration of  the ArrayList  "readListSymptoms" 
        Map<String,Integer> mapSymptomsOccurences = counter.countSymptoms(readListSymptoms); 

        //then the the method countSymptoms of the class AnalyticsCounter instancied in "counter" to generate a TreeMap from the previous HashMap "mapSymptomsOccurences"
        //And get the list of symptoms, the number of occurrences of each symtoms in alphabetical order in a TreeMap stocked in  "mapSymptomsOccurencesSorted" 
        Map<String,Integer> mapSymptomsOccurencesSorted = counter.sortSymptoms(mapSymptomsOccurences);

        //after all that process, call the method writeSymptoms of interface  implemented by the class WriteSymptomDataFromFile and used by the class AnalyticsCounter instancied in "counter" to iterate the TreeMap mapSymptomsOccurencesSorted  and in each iteration the method write each entry of the TreeMap mapSymptomsOccurencesSorted on the file "result.out" 
        counter.writeSymptoms(mapSymptomsOccurencesSorted);
    }       
}