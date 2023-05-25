package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything the will write symptom data on a valid data output format
 *
 */
public interface ISymptomWriter {
    /**
	 * used to create file result.out and write and save all symptoms and number of occurrences from a TreeMap
	 * 
	 * @see the implemention of the methode in WriteSymptomDataTofile
	 */
    public void writeSymptoms(Map<String, Integer> symptoms);
}
