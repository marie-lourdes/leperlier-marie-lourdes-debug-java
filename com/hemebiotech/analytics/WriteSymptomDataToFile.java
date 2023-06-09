package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * implementation of the method of the interface ISymptomWriter with annotation @Override. 
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
  private String filepath;

  public WriteSymptomDataToFile() {
    this.filepath = "result.out";
  }
    
  /**
   * used to create and to write in file result.out.
   *
   * @param symptoms    a TreeMap to iterate on it and write the content in file 
   *    
   * @exception IOException    if there's a problem in reading the file symptoms.txt
   *
   * @exception FileNotFoundException    if the path of the file return null
   *
   * @exception NullPointerException    if the TreeMap symptoms parameter 
         return false with the method isEmpty
   *
   * @exception IOException    if the error occurs when writing on the file result.out
   *
   * @exception Exception    if other errors occurs when iterating on the TreeMap 
         and  creating and writing on the file result.out
   *
   * @see    #writeSymptoms()
   *
   */
  // override the method writeSymptoms of ISymptomWriter  interface with Iterator 
  // to iterate and display key - symptom and value - number of occurrences of each symptom 
  @Override
  public void writeSymptoms(Map<String, Integer> symptoms) {
       
    /* check if file exist and if there are content on the map symptoms 
    and possible error in instruction try 
    and intercept error in a instruction catch and print explanation of error */
    
    try { 
      /** @param filepath    path to file to create a file,
       * to write on it saving symptoms and its number of occurrences   
       */ 
      if (filepath != null && !symptoms.isEmpty()) {
        /* create object writer with path of file 
        and second argument to write without remove all previous content 
        the object writer is used by bufferedReader 
        which write line per line on file indicated in the filePath */           
        FileWriter fileWriter = new FileWriter(filepath, false);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        /* create object Iterator to iterate on each entry of the mapSymptomsOccurencesSorted 
        and write each entry in file */
        Iterator<Map.Entry<String, Integer>> iteratorMap = symptoms.entrySet().iterator(); 
                
        /* iteration with a method forEachRemaining which call the function lambda 
        to execute instruction for each element of each iteration,
        so can get a clear and readable code instead of using loop while
        the parameter entrySymptomAndNumberOfOccurrences is a consumer 
        that consume each entry of the instance iterator */
        iteratorMap.forEachRemaining(
            (entrySymptomAndNumberOfOccurrences) -> { 
              System.out.println(
                  "number of " 
                  + entrySymptomAndNumberOfOccurrences.getKey() 
                  + " : " 
                  + entrySymptomAndNumberOfOccurrences.getValue()
              ); 
              try {
                writer.write(entrySymptomAndNumberOfOccurrences.getKey() 
                    + " : " 
                    + entrySymptomAndNumberOfOccurrences.getValue());
                writer.newLine();
              } catch (IOException e) {
                System.err.println(" writing symptoms to file result.out failed : " 
                    + e.getMessage());
                e.printStackTrace();
              }
            });

        writer.close();
        System.out.println("The file result.out get all list of symtoms," 
            + "the number of occurrences after writing in it");
      }
    } catch (FileNotFoundException e) {
      System.err.println("a possible error of path of the file result.out : " + e.getMessage()); 
      e.printStackTrace();
    } catch (NullPointerException e) {
      System.err.println("mapSymptomsOccurencesSorted is empty : " + e.getMessage());
      e.printStackTrace();
    } catch (Exception e) {
      System.err.println("an error has occured" + e.getMessage());              
      e.printStackTrace();
    }       
  }
}