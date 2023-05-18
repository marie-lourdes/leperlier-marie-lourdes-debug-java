package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;

public class WriteSymptomDataToFile implements ISymptomWriter {

    static ReadSymptomDataFromFile symptomsData;
	static ArrayList<String> listSymptoms;
	
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
}