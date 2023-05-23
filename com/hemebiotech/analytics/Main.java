package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

// WRITE YOUR CODE HERE
public class main {
    	public static void main(String args[]) throws Exception {
           ISymptomReader reader=new ReadSymptomDataFromFile("symptoms.txt");
           ISymptomWriter writer = new WriteSymptomDataToFile();
           AnalyticsCounter counter = new AnalyticsCounter(reader,writer); 
           readListSymptoms= counter.getSymptoms;
          counter.countSymptoms(readListSymptoms);
           Map<String,Integer>mapSymptomsOccurences= new HashMap<String,Integer>();
             counter.ortSymptoms(mapSymptomsOccurences);
        }
}