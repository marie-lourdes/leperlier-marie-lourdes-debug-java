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
	public void countSymptomsOccurrences() {
	    symptomsData = new ReadSymptomDataFromFile("symptoms.txt");
		readListSymptoms= symptomsData.getSymptoms();
		Map<String, Integer> mapSymptomsOccurences = new HashMap<String,Integer>();	
        int feverCount=0;
		int dialatedPupilsCount=0;
		int drymouthCount=0;
		int inflamationCount=0;
		int tremorCount =0;
		int stomachPainCount=0;
		int hightBloodPressureCount =0;
		int stiffNeckCount=0;
		int coughCount =0;
		int insomniaCount= 0;
		int headacheCount =0;
		int constrictedPupilsCount=0;
		int nauseaCount = 0;
		int shortnessOfBreathCount=0;
		int blurredVisionCount=0;
		int dizzinessCount =0;
		int lowBloodPressureCount =0;
		int arrhythmiasCount=0;
		int anxietyCount =0;
		int waterRetentionCount=0;
		int blindnessCount=0;
		int rapidHeartRateCount=0;
		int rashCount=0;
		for( String symptom: readListSymptoms ) {
            switch(symptom) {
				case "fever"-> mapSymptomsOccurences.put(symptom, ++feverCount);
				case "dialated pupils"-> mapSymptomsOccurences.put(symptom, ++dialatedPupilsCount);
				case "dry mouth"->	mapSymptomsOccurences.put(symptom, ++drymouthCount);
				case "inflamation"-> mapSymptomsOccurences.put(symptom, ++inflamationCount);
				case "tremor"->	mapSymptomsOccurences.put(symptom, ++tremorCount);
				case "stomach pain"-> mapSymptomsOccurences.put(symptom, ++stomachPainCount);
				case "hight blood pressure"-> mapSymptomsOccurences.put(symptom, ++hightBloodPressureCount);
				case "stiff neck"-> mapSymptomsOccurences.put(symptom,  ++stiffNeckCount);
				case "cough"-> mapSymptomsOccurences.put(symptom, ++coughCount);
				case "insomnia"-> mapSymptomsOccurences.put(symptom, ++insomniaCount);
				case "headache"-> mapSymptomsOccurences.put(symptom, headacheCount++);
				case "constricted pupils"->	mapSymptomsOccurences.put(symptom, ++constrictedPupilsCount);
				case "nausea"->	mapSymptomsOccurences.put(symptom, nauseaCount++);
				case "shortness of breath"-> mapSymptomsOccurences.put(symptom, ++shortnessOfBreathCount);
				case "blurred vision"->	mapSymptomsOccurences.put(symptom, ++blurredVisionCount);
				case "dizziness"->	mapSymptomsOccurences.put(symptom, ++dizzinessCount);
				case "low blood pressure"->	mapSymptomsOccurences.put(symptom, ++lowBloodPressureCount);
				case "arrhythmias"-> mapSymptomsOccurences.put(symptom, ++arrhythmiasCount);
				case "anxiety"-> mapSymptomsOccurences.put(symptom, ++anxietyCount);
				case "water retention"-> mapSymptomsOccurences.put(symptom, ++waterRetentionCount);
				case "blindness"-> mapSymptomsOccurences.put(symptom, ++blindnessCount);
				case "rapid heart rate"-> mapSymptomsOccurences.put(symptom, ++rapidHeartRateCount);
				case "rash"-> mapSymptomsOccurences.put(symptom, ++rashCount);
				//default -> throw new Error("nous avons pas repertorié ce symptome, nous allons le traiter");
				
			}
					
			for( Map.Entry<String, Integer> mapSymptom: mapSymptomsOccurences.entrySet() ) {
				
				System.out.println("Symptome: " + mapSymptom.getKey() + " ,Occurence: " + mapSymptom.getValue());		
				
			}
		}
		
	
	}		
}