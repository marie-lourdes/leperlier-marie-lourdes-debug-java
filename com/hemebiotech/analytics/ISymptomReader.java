package com.hemebiotech.analytics;

import java.util.List;

/**
 * anything that will read symptom data from a source
 * the important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications 
 * the implementation does not need to order the list.
 * 
 */
public interface ISymptomReader {
  /**
   * used to generate a List of all symptoms from a file.
   *
   * @return    a List unordered of String symptoms,
   *     if no data is available, return an empty List.
   * 
   * @see           "implemention of the method in ReadSymptomDataFromfile"
   */
  List<String> getSymptoms();
}
