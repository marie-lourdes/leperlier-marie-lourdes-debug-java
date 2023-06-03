package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
* the class Main execute a program that
*<li>get list of symptoms from a file symptoms.txt</li>
*<li>count the number of occurrences
*<li>finally write and save in other file result.out in alphabetical order</li>
* calling the class AnalyticsCounter's methods from an instance of this class.
*
*/

public class Main {
  public static void main(String[] args) throws Exception {
    ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
    ISymptomWriter writer = new WriteSymptomDataToFile();
    AnalyticsCounter counter = new AnalyticsCounter(reader, writer); 
    
    List<String> readListSymptoms = counter.getSymptoms(); 
    Map<String, Integer> mapSymptomsOccurences = counter.countSymptoms(readListSymptoms);
    Map<String, Integer> mapSymptomsOccurencesSorted = counter.sortSymptoms(mapSymptomsOccurences);
    counter.writeSymptoms(mapSymptomsOccurencesSorted); 
  }       
}
