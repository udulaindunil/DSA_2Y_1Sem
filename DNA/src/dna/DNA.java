
package dna;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

                BufferedWriter writer = new BufferedWriter(new FileWriter(dnaResult));
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
                                break;
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
                
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Could not find the file Incorrect file path Plz configer the file paths..");
        }
        
    }
    
    
}

