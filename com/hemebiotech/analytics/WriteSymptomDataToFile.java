package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;

import java.util.HashMap;

public class WriteSymptomDataToFile implements ISymptomWriter {

	static ReadSymptomDataFromFile symptomsData;
	static ArrayList<String> readListSymptoms;
	static Map<String, Integer> mapSymptomsOccurences = new HashMap<String,Integer>();
   
	
	public WriteSymptomDataToFile() {
		
	}
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		
	}
	public void countSymptomsOccurrences() {
       
        //boucle pour compter les occurence de la liste généré par la methode de ReadSymptomDataFromFile
		for( String symptom:readListSymptoms ) {
            if(!mapSymptomsOccurences.containsKey(symptom)) {
                mapSymptomsOccurences.put(symptom,1);
            }else {
                int numberOfOccurrencesSymptom= mapSymptomsOccurences.get(symptom);
                mapSymptomsOccurences.put(symptom, numberOfOccurrencesSymptom+1);
            }
								
		}
		for( Map.Entry<String, Integer> mapSymptom: mapSymptomsOccurences.entrySet() ) {
			
			System.out.println("Symptome: " + mapSymptom.getKey() + " ,Occurence: " + mapSymptom.getValue());		
			
		}
	}							
}