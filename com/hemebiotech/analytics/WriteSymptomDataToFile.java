package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;

public class WriteSymptomDataToFile implements ISymptomWriter {

    static ReadSymptomDataFromFile symptomsData;
	static ArrayList<String> listSymptoms;
    static Map<String, Integer> mapSymptomsOccurences = new HashMap<String,Integer>();
	
	public WriteSymptomDataToFile() {
		
	}
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		
	}
	public void countSymptomsOccurrences() {
        symptomsData = new ReadSymptomDataFromFile("symptoms.txt");
		readListSymptoms= symptomsData.getSymptoms();		
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
        //boucle pour compter les occurence de la liste généré par la methode de ReadSymptomDataFromFile
		for( String symptom: readListSymptoms ) {
		
			switch(symptom) {
				case "fever": mapSymptomsOccurences.put(symptom, ++feverCount);
                break;
				case "dialated pupils": mapSymptomsOccurences.put(symptom, ++dialatedPupilsCount);
                break;
				case "dry mouth":	mapSymptomsOccurences.put(symptom, ++drymouthCount);
                break;
				case "inflamation": mapSymptomsOccurences.put(symptom, ++inflamationCount);
                break;
				case "tremor":	mapSymptomsOccurences.put(symptom, ++tremorCount);
                break;
				case "stomach pain": mapSymptomsOccurences.put(symptom, ++stomachPainCount);
                break;
				case "hight blood pressure": mapSymptomsOccurences.put(symptom, ++hightBloodPressureCount);
                break;
				case "stiff neck": mapSymptomsOccurences.put(symptom,  ++stiffNeckCount);
                break;
				case "cough": mapSymptomsOccurences.put(symptom, ++coughCount);
                break;
				case "insomnia": mapSymptomsOccurences.put(symptom, ++insomniaCount);
                break;
				case "headache": mapSymptomsOccurences.put(symptom, headacheCount++);
                break;
				case "constricted pupils": mapSymptomsOccurences.put(symptom, ++constrictedPupilsCount);
                break;
				case "nausea":	mapSymptomsOccurences.put(symptom, nauseaCount++);
                break;
				case "shortness of breath": mapSymptomsOccurences.put(symptom, ++shortnessOfBreathCount);
                break;
				case "blurred vision": mapSymptomsOccurences.put(symptom, ++blurredVisionCount);
                break;
				case "dizziness": mapSymptomsOccurences.put(symptom, ++dizzinessCount);
                break;
				case "low blood pressure": mapSymptomsOccurences.put(symptom, ++lowBloodPressureCount);
                break;
				case "arrhythmias": mapSymptomsOccurences.put(symptom, ++arrhythmiasCount);
                break;
				case "anxiety": mapSymptomsOccurences.put(symptom, ++anxietyCount);
                break;
				case "water retention": mapSymptomsOccurences.put(symptom, ++waterRetentionCount);
                break;
				case "blindness": mapSymptomsOccurences.put(symptom, ++blindnessCount);
                break;
				case "rapid heart rate": mapSymptomsOccurences.put(symptom, ++rapidHeartRateCount);
                break;
				case "rash": mapSymptomsOccurences.put(symptom, ++rashCount);
                break;
				//default -> throw new Error("nous avons pas repertorié ce symptome, nous allons le traiter");
			
			}
			
		}
		for( Map.Entry<String, Integer> mapSymptom: mapSymptomsOccurences.entrySet() ) {
			
			System.out.println("Symptome: " + mapSymptom.getKey() + " ,Occurence: " + mapSymptom.getValue());		
			
		}
		
	
	}						
			
	
}