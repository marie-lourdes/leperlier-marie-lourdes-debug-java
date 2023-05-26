package com.hemebiotech.analytics;

import java.util.Map;

/**
 * anything the will write symptom data on a valid data output format.
 *
 */
public interface ISymptomWriter {
  /**
   * used to create file result.out 
   * and write and save all symptoms and number of occurrences from a Map
   * 
   * @see    "the implemention of the methode in WriteSymptomDataTofile for more explanation"
   *
   */
  public void writeSymptoms(Map<String, Integer> symptoms);
   
}
