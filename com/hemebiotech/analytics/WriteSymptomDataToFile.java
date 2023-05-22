package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.List;
import java.util.TreeMap;

public class WriteSymptomDataToFile implements ISymptomWriter {
    String filePath;
	
	//Constructor
	public WriteSymptomDataToFile(String filePath) {
		this.filePath= filePath;
		
	}
    // Override the  method writeSymptoms of ISymptomWriter interface with Iterator to iterate and  display key -symptom and value - number of occurrences of each symptom
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
        Iterator<Map.Entry<String, Integer>> iteratorMap = symptoms.entrySet().iterator();
	  
        //@param entrySymptomAndNumberOfOccurrences - type Map.Entry<String,Iteger> as a consumer (parameter of the method forEachRemaining used by the expression lambada)
		//the consumer consume  each entry of the instance iterator
        iteratorMap.forEachRemaining(
			(entrySymptomAndNumberOfOccurrences)->  System.out.println(
                "number of " + entrySymptomAndNumberOfOccurrences.getKey() + ": " + entrySymptomAndNumberOfOccurrences.getValue()
                )
		);
		
	}

							
}