import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.parser.ParseException; 
public class JSONtoTrecEval {
	public static void main(String[] args) throws IOException, ParseException {
		//	     File results = new File("C:\\Users\\ele_1\\Documents\\Mathimata\\Sustimata Anaktisis\\Project\\2i fasi\\QueryResultsfromES\\90%"); 
	     File results = new File("C:\\Users\\ele_1\\Documents\\Mathimata\\Sustimata Anaktisis\\Project\\2i fasi\\QueryMLTResults\\stop_words"); 
	     File dummy = new File("C:\\Users\\ele_1\\Documents\\Mathimata\\Sustimata Anaktisis\\Project\\2i fasi\\QueryResultsfromES"); 

	    File[] QueryResults = results.listFiles();
		System.out.println("**Parsing the Query Results(jSon) files**");
		int index = 1;
	        for(File f: QueryResults) {
	        	if(f.isFile()) {
	        		System.out.println(f);
	        		//int index = 1;
	        		BufferedReader in = new BufferedReader(new FileReader(f));
	        		String _score = "_score";
	        		String rcn = "rcn";
	        		String scoreVal ="";
	        		String rcnVal="";
	        		String lineForTrec_eval="";
	        		String line = in.readLine();
	        		while ((line = in.readLine())!= null) {
		        		//String scoreVal ="";
		        		//String rcnVal ="";
	        			if(line.contains(_score)) {
	        				if(line.contains("max")) continue;
	        				else {
	        				//String scoreVal = line.substring(19, 26);
	        				System.out.println(line);
	        				scoreVal = line.substring(19);
	        				System.out.println(scoreVal);
	        				scoreVal = scoreVal.replace(",", "  ");
	        				scoreVal = scoreVal.replace(".", ",");
	        				System.out.println(scoreVal);
	        				//String lineForTrec_eval = "Q"+index+"\tQ0\t"+ rcnVal + "\t" + scoreVal +"\tBM25" ;
	        				
	        				}
	        			}
	        			if(line.contains(rcn)) {
	        				System.out.println(line);
	        				rcnVal = line.substring(20);
	        				System.out.println(rcnVal);
	        				if(index == 10) {
		            			lineForTrec_eval ="Q"+index+"\tQ0\t"+ rcnVal + "\t0\t" + scoreVal +"\tBM25\n" ;
		            			System.out.println(lineForTrec_eval);
		            			
		                        FileWriter fileWriter =
		                                new FileWriter("stop_words.txt", true);

		                            // Always wrap FileWriter in BufferedWriter.
		                            BufferedWriter bufferedWriter =
		                                new BufferedWriter(fileWriter);
		    
		                     bufferedWriter.write(lineForTrec_eval);
		        	   	     bufferedWriter.close();
	        				}else {
	            			lineForTrec_eval ="Q0"+index+"\tQ0\t"+ rcnVal + "\t0\t" + scoreVal +"\tBM25\n" ;
	            			System.out.println(lineForTrec_eval);
	            			
	                        FileWriter fileWriter =
	                                new FileWriter("stop_words.txt", true);

	                            // Always wrap FileWriter in BufferedWriter.
	                            BufferedWriter bufferedWriter =
	                                new BufferedWriter(fileWriter);
	    
	                     bufferedWriter.write(lineForTrec_eval);
	        	   	     bufferedWriter.close();
	        				}
	        			}
	
	        			}
        			//lineForTrec_eval = lineForTrec_eval +"\nQ"+index+"\tQ0\t"+ rcnVal + "\t" + scoreVal +"\tBM25" ;
        			//System.out.println(lineForTrec_eval);
	        		in.close();
	        		index++;
	        		}
	        	
	        		}

	        	}
	
	
	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
