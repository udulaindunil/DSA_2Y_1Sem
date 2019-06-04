
package main;

import java.io.*;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> patterns = new LinkedList<>(); 
        try{
           
            FileReader textFile = new FileReader("C:\\Users\\Indunil\\Desktop\\text1.txt");
            
            FileReader patterFile = new FileReader("C:\\Users\\Indunil\\Desktop\\pattern1.txt");
            
            File patternMatchFile = new File("C:\\Users\\Indunil\\Desktop\\patternmatch.txt");
            
            Integer cahractersCountOfTestFile=0;
            BufferedReader br1 = new BufferedReader(textFile);
                StringBuilder sb1 = new StringBuilder();
                String line1 = br1.readLine();
                
                while (line1 != null) {
                        sb1.append(line1);
                        sb1.append(System.lineSeparator());
                        line1 = br1.readLine();
                    }
                String textString = sb1.toString();
                char[] textCharArray = textString.toCharArray();
                cahractersCountOfTestFile= textCharArray.length;
                
                
          
            BufferedReader br = new BufferedReader(patterFile);
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();
                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                String patternString = sb.toString();
                
                String[] words=patternString.split("\\s");
                for(String w:words){  
                    patterns.add(w);
                   }
                Integer numberOfPatterns = patterns.size();
                
                PrintWriter writer = null;
                
                
                if(cahractersCountOfTestFile.equals(0)){
                        System.out.println("No text contains on file");
                        
                }else if(patternString.isEmpty()){
                        System.out.println("No Ptterns on read file");
                        
                }else{
                    
                        
                        writer = new PrintWriter(patternMatchFile);
                        for(int index=0;index<numberOfPatterns;index++){

                            String patternWord = patterns.get(index);         
                            int print=-1;
                            for(int counter=0;counter<(cahractersCountOfTestFile-patternWord.length());counter++) { 
                                int j=0;
                                while(j<patternWord.length() && ((textCharArray[counter+j]==patternWord.charAt(j))||(patternWord.charAt(j)=='_'))){
                                    j++;
                                }
                                if(j==patternWord.length()){
                                    if(print!=index){
                                        System.out.printf("The Pattern = %s\n Positions\n",patternWord);
                                            writer.write("      Pattern = "+patternWord+"");
                                            writer.write(" Positions  => ");

                                    }
                                    print=index;

                                    System.out.printf(" %d\n",counter);
                                    writer.write("  "+ counter);
                                }else{

                                }
                            }

                        }
                         writer.flush();
                         writer.close();  
                }
              
                
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Could not find the file Incorrect file path Plz configer the file paths..");
        }
        
    }
    
    
}
