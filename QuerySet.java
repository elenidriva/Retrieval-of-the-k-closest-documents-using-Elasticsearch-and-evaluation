import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class QuerySet {
	
	public static void main(String[] args) throws IOException {
	     File query = new File("C:\\Users\\ele_1\\Documents\\Mathimata\\Sustimata Anaktisis\\Project\\10 Queries in txt format"); 
	     //File dummy = new File("C:\\Users\\ele_1\\Documents\\Mathimata\\Sustimata Anaktisis\\Project\\10 Queries in txt format\\30%"); 
	     
	    File[] Q = query.listFiles();
		System.out.println("**Parsing the Query files**");
		int index = 1;
	    for(File f: Q) {
	        if(f.isFile()) {
	            BufferedReader in = new BufferedReader(new FileReader(f));
	            String str;
	        	int lines = 0;
	        	System.out.println(lines);	        	
	        	while ((str = in.readLine())!= null) {
	        			lines++;
	        	}	        
	        	System.out.println(lines);
	   	     	double percentage = 0.9;
	   	     	int linesKept = (int) Math.ceil(percentage*lines);	
	            BufferedReader inToW = new BufferedReader(new FileReader(f));
	            System.out.println(linesKept);
	   	     	int counter = 0;
	   	     //	FileOutputStream fos = new FileOutputStream("Q0"+index+".txt", true);	    	 
	   	     //	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
 	
                FileWriter fileWriter =
                        new FileWriter("Q0"+index+".txt", true);
                    // Always wrap FileWriter in BufferedWriter.
                BufferedWriter bufferedWriter =
                        new BufferedWriter(fileWriter);

	   	     	String line;
	   	     	while(counter < linesKept) {
	   	     		line = inToW.readLine();
	   	     		System.out.println(line);
	   	     	bufferedWriter.write(line);
	   	     	bufferedWriter.newLine();
	   	     		counter++;
	   	     	}
	   	     bufferedWriter.close();
	        index++;
	        }
	    }       
	}	
}