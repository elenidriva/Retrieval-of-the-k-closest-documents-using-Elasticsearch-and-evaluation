// Δρίβα Ελένη - 3140047
import org.json.XML;
import java.io.File;
import java.io.IOException;
import java.io.*;
import org.json.JSONObject;

public class XMLtoJSON {
	
	public static void main(String[] args) {
     File spamFolder = new File("C:\\Users\\ele_1\\Documents\\Mathimata\\Sustimata Anaktisis\\Project\\Document Collection\\Parsed Files"); 
     File dummy = new File("C:\\Users\\ele_1\\Documents\\Mathimata\\Sustimata Anaktisis\\Project\\Document Collection\\collection.json"); 
     
	//System.out.println("**Parsing the XML files**");
    File[] XMLfiles = spamFolder.listFiles();
	System.out.println("**Parsing the XML files**");
	int index = 1;
        for(File f: XMLfiles) {
        	if(f.isFile()) {
        	
        	
        	//  String fileName = "D:\\temp.json";
              try {           
                 // File file = new File ("C:\\Users\\ele_1\\Documents\\Mathimata\\Sustimata Anaktisis\\Project\\Document Collection\\project-rcn-193157_en.xml");  
                 // InputStream inputStream = new FileInputStream(f);  
                  InputStream inputStream = new FileInputStream(f);  
                  StringBuilder builder =  new StringBuilder();  
                  int ptr = 0;  
                  while ((ptr = inputStream.read()) != -1 ) {  
                      builder.append((char) ptr); 
                    //  System.out.println(ptr);
                  }  

                  String xml  = builder.toString();  
                  JSONObject jsonObj = XML.toJSONObject(xml.toString());   
                  FileWriter fileWriter =
                      new FileWriter(dummy, true);

                  // Always wrap FileWriter in BufferedWriter.
                  BufferedWriter bufferedWriter =
                      new BufferedWriter(fileWriter);
                 
                  
			      
		            String json=jsonObj.toString();
		            bufferedWriter.write("{\"index\":{\"_id\":\""+(index++)+"\"}}");
		            bufferedWriter.newLine();
			        bufferedWriter.write(json);
                  bufferedWriter.newLine();
                  
                  // Always close files.
/*
                  for(int i= 0 ;i < jsonObj.toString().split(",").length; i ++) {
                     System.out.println(jsonObj.toString().split(",")[i]);
                     if(i+1 < jsonObj.toString().split(",").length) {
                     bufferedWriter.write(jsonObj.toString().split(",")[i] +",");
                     }else {
                    	 bufferedWriter.write(jsonObj.toString().split(",")[i]); 
                     }
                  }
*/

                  bufferedWriter.close();
              
                 
              
        	
        	
              
        	
        	
        	
        	
        	
        
              }
              catch(IOException ex) {
                  System.out.println(
                      "Error writing to file");
                  // Or we could just do this:
                  // ex.printStackTrace();
              } catch(Exception e) {  
                  e.printStackTrace();  
              }
        }   
        	else {
        		continue;
        	}
	}
}
}