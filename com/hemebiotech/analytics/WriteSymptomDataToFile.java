package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import java.util.TreeMap;

public class WriteSymptomDataToFile implements ISymptomWriter {

	static ReadSymptomDataFromFile symptomsData;
	static ArrayList<String> readListSymptoms;
	static Map<String, Integer> mapSymptomsOccurences;
	
	public WriteSymptomDataToFile() {
		
	}

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		
	}

	public void countSymptomsOccurrences() {
        //instantiation de la class ReadSymptomDtaFromFile et utilisation de la methode de l interface implémenté par la class ReadSymptomDataFromFile
	   // Creation de le TreeMap pour ajouter les symptoms et compter les occurrences des symptoms du fichier symptoms.txt
		symptomsData = new ReadSymptomDataFromFile("symptoms.txt");
		readListSymptoms= symptomsData.getSymptoms();
		mapSymptomsOccurences= new TreeMap<String,Integer>();
       
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