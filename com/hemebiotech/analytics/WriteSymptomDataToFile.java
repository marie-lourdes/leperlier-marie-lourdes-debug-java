package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
	public WriteSymptomDataToFile() {
		
	}
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		
	}
	public void displayListSymptoms() {
	    symptomsData = new ReadSymptomDataFromFile("symptoms.txt");
		listSymptoms= symptomsData.getSymptoms();
		for( String symptom: listSymptoms) {
			System.out.println(symptom);
		}
			
}