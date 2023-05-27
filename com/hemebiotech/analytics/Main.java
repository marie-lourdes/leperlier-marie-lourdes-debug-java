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
  /**
   * the method main call the methods needed for execute the program that 
   * count the number of occurrences and save it in a file result.out.
   */
  public static void main(String[] args) throws Exception {
    ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
    ISymptomWriter writer = new WriteSymptomDataToFile();

    /* add instance reader and writer as arguments 
    calling the constructor of the class AnalyticsCounter
    and create instance of the class with reference "counter" */
    AnalyticsCounter counter = new AnalyticsCounter(reader, writer); 

    /* then call the method getSymptoms of interface 
    implemented by the class ReadSymptomDataFromFile 
    to create List of symptoms read from symptoms.txt */
    List<String> readListSymptoms = counter.getSymptoms(); 

    /* then call the method countSymptoms 
    the method create a HashMap and add the symptoms and number of occurrences added */
    Map<String, Integer> mapSymptomsOccurences = counter.countSymptoms(readListSymptoms);

    /* then the the method countSymptoms of the class AnalyticsCounter
    to generate a TreeMap from the previous HashMap "mapSymptomsOccurences"
    and get the list of symptoms, the number of occurrences of each symptoms in alphabetical order */ 
    Map<String, Integer> mapSymptomsOccurencesSorted = counter.sortSymptoms(mapSymptomsOccurences);

    /* after all that process : 
    call the method writeSymptoms of interface implemented by WriteSymptomDataFromFile 
    to iterate the TreeMap mapSymptomsOccurencesSorted  
    and in each iteration the method write each entry of the TreeMap mapSymptomsOccurencesSorted 
    on the file "result.out" */ 
    counter.writeSymptoms(mapSymptomsOccurencesSorted); 
  }       
}