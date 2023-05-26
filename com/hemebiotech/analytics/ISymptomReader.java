package com.hemebiotech.analytics;

import java.util.List;

/**
 * anything that will read symptom data from a source
 * the important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * 
 * the implementation does not need to order the list
 * 
 */
public interface ISymptomReader {
	/**
	 * if no data is available, return an empty List
	 * 
     * @see           "the implemention of the methode in ReadSymptomDataFromfile for more explanation"
	 */
	List<String> getSymptoms();
}
