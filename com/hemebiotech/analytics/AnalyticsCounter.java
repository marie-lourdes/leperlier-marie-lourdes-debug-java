package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;


public class AnalyticsCounter {
    //Variables added and necessary for the countSymtomsOccurrence method implemented by marie-lourdes
	private static ReadSymptomDataFromFile readerSymptomsData;
	private static List<String> readListSymptoms;
	private static  Map<String, Integer> mapSymptomsOccurences; 
    private static Map<String,Integer> mapSymptomsOccurencesSorted; 
	//instantiation of the WriteSymptomDataToFile class with the mapSymptomsData reference 
	//to use the ISymptomWriter interface method implemented by the class	
	private static WriteSymptomDataToFile writerSymptomsData = new WriteSymptomDataToFile();

    //variables implemented by Alex as well as the code of the main function
	private static int headacheCount = 0;	
	private static int rashCount = 0;		
	private static int pupilCount = 0;		
	
	public static void main(String args[]) throws Exception {
        
        mapSymptomsOccurences= new HashMap<String,Integer>();
        // creation of the TreeMap to arrange  the content of mapSymptomsOccurences in alphabetical order
        mapSymptomsOccurencesSorted = new TreeMap<String,Integer>();
	    //call the method countSymptomsOccurrences()
        //Used to add symptoms and count the occurences in a HashMap called mapSymptomsOccurences
		countSymptomsOccurrences(mapSymptomsOccurences);
        //Used to sort the mapSymptomsOccurences and generate a TreeMap called mapSymptomsOccurencesSorted
        sortMapSymptoms(mapSymptomsOccurences);
        //call the method of interface ISymptomWriter implemented by the class WriteSymptomDataToFile 
        //Used to test the output and content of the mapSymptomsOccurrencesSorted generated by the method sortMapSymptoms
        writerSymptomsData.writeSymptoms(mapSymptomsOccurencesSorted);
	
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;	
		int headCount = 0;	// headCount int - counts number of headaches added with loop while
		while (line != null) {
			i++;	
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}

    public static void countSymptomsOccurrences(Map<String,Integer> symptoms) {
		//instantiation of the class ReadSymptomDtaFromFile and use of the method of the interface implemented by the class ReadSymptomDataFromFile
		readerSymptomsData = new ReadSymptomDataFromFile("symptoms.txt");
		readListSymptoms= readerSymptomsData.getSymptoms();
 
		// loop For Each that adds the listSymptoms key symptom and value number occurrence in a TreeMap
		// the number of occurrences is incremented if the symptoms is already present in the TreeMap called mapSymptomsOccurences otherwise 1 is added if the symptom does not exist in the TreeMap
		for( String symptom:readListSymptoms ) {
            if(!mapSymptomsOccurences.containsKey(symptom)) {
                mapSymptomsOccurences.put(symptom,1);
            }else {
                int numberOfOccurrencesSymptom= mapSymptomsOccurences.get(symptom);
                mapSymptomsOccurences.put(symptom, numberOfOccurrencesSymptom+1);
            }
								
		} 
       
	}

    public static void sortMapSymptoms(Map<String,Integer> symptoms) {
		mapSymptomsOccurencesSorted.putAll(symptoms);	
	}

}