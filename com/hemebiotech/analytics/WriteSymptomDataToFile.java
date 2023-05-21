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

    // Override the  method writeSymptoms of ISymptomWriter interface with Iterator to iterate and  display key -symptom and value - number of occurrences of each symptom
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
        Iterator<Map.Entry<String, Integer>> iteratorMap = symptoms.entrySet().iterator();
	  
        //Iteration with a method forEachRemaining  which call the  function lambda to execute instruction for each element of each iteration , so can get a clear and readable code instead of using loop while
		//@param entrySymptomAndNumberOfOccurrences - type Map.Entry<String,Iteger> as a consumer of each entry of the instance iterator
        iteratorMap.forEachRemaining(
			(entrySymptomAndNumberOfOccurrences)->  System.out.println(
                "number of " + entrySymptomAndNumberOfOccurrences.getKey() + ": " + entrySymptomAndNumberOfOccurrences.getValue()
                )
		);
		
	}

							
}