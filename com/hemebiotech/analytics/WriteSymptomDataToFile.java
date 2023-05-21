package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.List;
import java.util.TreeMap;

public class WriteSymptomDataToFile implements ISymptomWriter {

	static ReadSymptomDataFromFile symptomsData;
	static List<String> readListSymptoms;
	static Map<String, Integer> mapSymptomsOccurences;
	
	public WriteSymptomDataToFile() {
		
	}

    // redéfinition de la methode writeSymptoms de l interface ISymptomWriter 
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
        Iterator<Map.Entry<String, Integer>> iterator = symptoms.entrySet().iterator();
	    while (iterator.hasNext()) {
	        Map.Entry<String, Integer> entry = iterator.next();
	        System.out.println(entry.getKey() + ":" + entry.getValue());
	    }
		
	}

							
}