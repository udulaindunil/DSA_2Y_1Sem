/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dna;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.io.*;
import java.util.LinkedList;

public class DNA {

    public static void main(String[] args) {
        LinkedList<String> QUERY = new LinkedList<>();
        LinkedList<String> DNA = new LinkedList<>();
        LinkedList<String> queryDescription = new LinkedList<>();
        LinkedList<String> dbDescription = new LinkedList<>();
        
       
        try{
            
            
            FileReader dnaFile = new FileReader("C:\\Users\\Indunil\\Desktop\\DNA Database.txt");
            
            FileReader query = new FileReader("C:\\Users\\Indunil\\Desktop\\query.txt");
            
            File dnaResult = new File("C:\\Users\\Indunil\\Desktop\\DnaResult.txt");
            
            Integer cahractersCountOfTestFile=0;
            BufferedReader br1 = new BufferedReader(dnaFile);
                String line1 = br1.readLine();
                int dbDescriptionPosition=0;
                while (line1 != null) {
                        StringBuilder sb1 = new StringBuilder();
                    
                        if(line1.charAt(0)=='>'){
                            sb1.append(line1);
                            dbDescription.add(sb1.toString());
                            line1 = br1.readLine();
                        }else{
                            while(line1.charAt(0)!='>'){
                                    sb1.append(line1);
                                    line1 = br1.readLine();
                                }
                            String dnaString = sb1.toString();
                            DNA.add(dnaString);
                        }
                                           
                    } 
                
                BufferedReader br2 = new BufferedReader(query);
                String line2 = br2.readLine();
                String Description = null;
                while (line2 != null) {
                   // System.out.println(line2);
                    StringBuilder sb2 = new StringBuilder();
                    
                    if(line2.charAt(0)=='>'){
                        sb2.append(line2);
                        queryDescription.add(sb2.toString());
                        line2 = br2.readLine();
                    }else{
                        while(line2.charAt(0)!='>'){
                            sb2.append(line2);
                            line2 = br2.readLine();
                        } 
                        String queryString = sb2.toString();
                        QUERY.add(queryString); 
                    }                  
                    }               

                Integer index = null;
//                PrintWriter writer = null;
//                FileWriter fw = new FileWriter(dnaResult,true);
                BufferedWriter writer = new BufferedWriter(new FileWriter(dnaResult));
//                writer = new PrintWriter(dnaResult);
                for(int numberOfQueries=0;numberOfQueries<QUERY.size();numberOfQueries++){
                    int flag=0;
                    String queryString = QUERY.get(numberOfQueries);
                    System.out.println(queryDescription.get(numberOfQueries));
                    writer.write(queryDescription.get(numberOfQueries));
                    writer.newLine();
                    
                    
                    for(int numberOfDnaPatters=0;numberOfDnaPatters<DNA.size();numberOfDnaPatters++){
                        String dnaString = DNA.get(numberOfDnaPatters);
                     
                        
                        for(Integer count=0;count<(dnaString.length()-queryString.length());count++){
                            int j=0;
                            while(j<queryString.length() && (dnaString.charAt(count+j)==queryString.charAt(j))){
                                    j++;
                                }
                            if(j==queryString.length()){
                                System.out.print(dbDescription.get(numberOfDnaPatters));
                                writer.write(dbDescription.get(numberOfDnaPatters));
                                System.out.printf("   at offset %d \n",count);
                                writer.write("   at offset  ");
                                writer.write(count.toString());
                                writer.newLine();
                                
                                flag=1;
                            }
                            
                        }
                      
                         
                    }
                    if(flag==0){
                        System.out.println("NOT Founded");
                        writer.write("NOT Founded");
                    }
                    System.out.println("");
                    writer.newLine();
                }   
            writer.close();
                
//          
//            BufferedReader br = new BufferedReader(patterFile);
//                StringBuilder sb = new StringBuilder();
//                String line = br.readLine();
//                while (line != null) {
//                    sb.append(line);
//                    sb.append(System.lineSeparator());
//                    line = br.readLine();
//                }
//                String patternString = sb.toString();
//                
//                String[] words=patternString.split("\\s");
//                for(String w:words){  
//                    patterns.add(w);
//                   }
//                Integer numberOfPatterns = patterns.size();
//                
//                PrintWriter writer = null;
                
                
//                if(cahractersCountOfTestFile.equals(0)){
//                        System.out.println("No text contains on file");
//                        
//                }else if(patternString.isEmpty()){
//                        System.out.println("No Ptterns on read file");
//                        
//                }else{
//                    
//                        
//                        writer = new PrintWriter(patternMatchFile);
//                        for(int index=0;index<numberOfPatterns;index++){
//
//                            String patternWord = patterns.get(index);         
//                            int print=-1;
//                            for(int counter=0;counter<(cahractersCountOfTestFile-patternWord.length());counter++) { 
//                                int j=0;
//                                while(j<patternWord.length() && ((textCharArray[counter+j]==patternWord.charAt(j))||(patternWord.charAt(j)=='_'))){
//                                    j++;
//                                }
//                                if(j==patternWord.length()){
//                                    if(print!=index){
//                                       // System.out.printf("The Pattern = %s\n Positions\n",patternWord);
//                                            writer.write("      Pattern = "+patternWord+"");
//                                            writer.write(" Positions  => ");
//
//                                    }
//                                    print=index;
//
//                                   // System.out.printf(" %d\n",counter);
//                                    writer.write("  "+ counter);
//                                }else{
//
//                                }
////                            }
//
//                        }
//                         writer.flush();
//                         writer.close();  
//                }
              
                
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Could not find the file Incorrect file path Plz configer the file paths..");
        }
        
    }
    
    
}

