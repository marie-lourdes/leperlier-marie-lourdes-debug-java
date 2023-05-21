package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.List;
import java.util.TreeMap;

public class AnalyticsCounter {
    //Variables ajoutés et necessaires à la methode countSymtomsOccurrence implémentés par marie-lourdes
	private static ReadSymptomDataFromFile symptomsData;
	private static List<String> readListSymptoms;
	private static  Map<String, Integer> mapSymptomsOccurences;

    //variables implémentés par Alex ainsi que le code de la fonction main
	private static int headacheCount = 0;	
	private static int rashCount = 0;		
	private static int pupilCount = 0;		
	
	public static void main(String args[]) throws Exception {
        // test the output of listSymptom and count number of occurences in alphabetical order , 
	    //call the method countSymptomsOccurrences() of this class in the instance
		countSymptomsOccurrences();
        //call the method of interface ISymptomWriter implemented by the class WriteSymptomDataToFile  with Iterator to iterate and  display key -symptom and value - number of occurrences of each symptom
        mapSymptomsData.writeSymptoms(mapSymptomsOccurences);
	
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;	
		int headCount = 0;	// headCount int - counts number of headaches added with loop while
		while (line != null) {
			i++;	
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}

    	public static void countSymptomsOccurrences() {
        //instantiation de la class ReadSymptomDtaFromFile et utilisation de la methode de l interface implémenté par la class ReadSymptomDataFromFile
	   // Creation de le TreeMap pour ajouter les symptoms et compter les occurrences des symptoms du fichier symptoms.txt dans l'ordre alphabetique
		symptomsData = new ReadSymptomDataFromFile("symptoms.txt");
		readListSymptoms= symptomsData.getSymptoms();
		mapSymptomsOccurences= new TreeMap<String,Integer>();
       
        // creer une boucle qui ajoute la liste listSymptoms clé symptom et value number occurence dans une TreeMap
		for( String symptom:readListSymptoms ) {
            if(!mapSymptomsOccurences.containsKey(symptom)) {
                mapSymptomsOccurences.put(symptom,1);
            }else {
                int numberOfOccurrencesSymptom= mapSymptomsOccurences.get(symptom);
                mapSymptomsOccurences.put(symptom, numberOfOccurrencesSymptom+1);
            }
								
		}
        
        //La boucle parcourt la mapSymptomsOccurrence et affiche les symptoms et  le nombre d occurrence 
		for( Map.Entry<String, Integer> mapSymptom: mapSymptomsOccurences.entrySet() ) {
			
			System.out.println("Symptome: " + mapSymptom.getKey() + " ,Occurence: " + mapSymptom.getValue());		
			
		}
	}

}