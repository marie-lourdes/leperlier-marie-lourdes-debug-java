# Project Heme Biotech #

## Overview ##

The company **Heme Biotech** is part of the pharmaceutical industry: the development of drugs and primarily treats blood disorders in humans and animals
To ensure the quality of its products, it collects data from their product: dosages, symptoms, treatment...

The company wants to improve the prediction of drug needs with their customers: doctors and veterinarians using the software.The program:
+ reads a text document which describes the symptoms (these symptoms can be repeated several times in the file),
+ extracts information from the file into a data structure usable in Java,
+ calculates the number of occurrences of these symptoms
+ stores it in alphabetical order 
+ writes and saves the result of this analysis and the various processing of information in an OUT file.

This file is saved and made available to the company's departments concerned to improve its medicines.

## Prerequisites ##

+ an IDE such as Eclipse that compiles and runs Java code including other Java development tools 
+ Knowledge of Java and the command line

## Technologies ##

+ `Java`
+ `openjdk version "1.8.0_352"` 

## Installation ##

+ install the **JDK (Java Development Kit)** with the version specified above on your computer
+ clone repository
+ in your IDE, open the *example-symptoms.txt* file which is located at the root of the project in the repository 
+ fill the file with symptoms as you want by following the sample file content 
+ then save the text document with the title *symptoms* and the extension .txt

## Run the program ##

You have two possibilities :
 - run the code with the IDE like Eclipse which compiles automatically before executing the code, for that click on the button `Run as`> `Java application`
 - or compile the code with the command line with the following command to run in your terminal:
 
 ```java
 "javac com/hemebiotech/analytics/*.java"
 ```
 and run the code with the following command:
 
  ```java
 "java -cp "." com.hemebiotech.analytics.Main"
 ```
 
 After running, a file result.out will be created and will contain the symptoms and the number of occurrences of the symptoms that you indicated previously in the file symptoms .txt and in alphabetical order
 
## More information about the program with Javadoc ##

In the repository, see the **doc** directory following this path:
<br>
=> **doc/com/hemebiotech/analytics/**
<br>
You could consult HTML pages of the technical documentation of the project components generated by **Javadoc**
 
