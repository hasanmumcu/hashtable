
package hashtable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Management {
    private AbstractHashMap<Key, String> probeHashTable;
    private AbstractHashMap<Key, String> doubleHashTable; 
    private Scanner scan;
    private BufferedReader read;
    private FileReader fileRead;
    private Key key;
    private MapEntry mapEntry;
    
    private static final String DEFAULTFILE = "stop_words_en.txt";
    private String DELIMITERS = "[-+=" +
		        " " +        //space
		        "\r\n " +    //carriage return line fit
				"1234567890" + //numbers
				"’'\"" +       // apostrophe
				"(){}<>\\[\\]" + // brackets
				":" +        // colon
				"," +        // comma
				"‒–—―" +     // dashes
				"…" +        // ellipsis
				"!" +        // exclamation mark
				"." +        // full stop/period
				"«»" +       // guillemets
				"-‐" +       // hyphen
				"?" +        // question mark
				"‘’“”" +     // quotation marks
				";" +        // semicolon
				"/" +        // slash/stroke
				"⁄" +        // solidus
				"␠" +        // space?   
				"·" +        // interpunct
				"&" +        // ampersand
				"@" +        // at sign
				"*" +        // asterisk
				"\\" +       // backslash
				"•" +        // bullet
				"^" +        // caret
				"¤¢$€£¥₩₪" + // currency
				"†‡" +       // dagger
				"°" +        // degree
				"¡" +        // inverted exclamation point
				"¿" +        // inverted question mark
				"¬" +        // negation
				"#" +        // number sign (hashtag)
				"№" +        // numero sign ()
				"%‰‱" +      // percent and related signs
				"¶" +        // pilcrow
				"′" +        // prime
				"§" +        // section sign
				"~" +        // tilde/swung dash
				"¨" +        // umlaut/diaeresis
				"_" +        // underscore/understrike
				"|¦" +       // vertical/pipe/broken bar
				"⁂" +        // asterism
				"☞" +        // index/fist
				"∴" +        // therefore sign
				"‽" +        // interrobang
				"※" +          // reference mark
		        "]";
				

//    private Management management;
  
      
    public static void main(String[] args) {
	
	new Management();
    }
    
    public Management() {
        this(DEFAULTFILE);
   	
	}
    
    public Management(String fileName) {
		
		try {
			 
			 probeHashTable = new ProbeHashMap<Key,String>();
                         doubleHashTable = new DoubleHashMap<Key, String>();
                         mapEntry = new MapEntry<String,Integer>();  
			 fileRead = new FileReader(fileName);
			 read = new BufferedReader(fileRead);
			 scan = new Scanner(System.in);
			 readFile();
			 run();
                         
                         
                         
                         
                         
			 
		}catch(IOException e) { System.out.println("\n\nERROR : Txt file is not found.");}
	}
    
    private void readFile() throws IOException {
  
        File folder = new File("bbc");
        File[] listOfFiles = folder.listFiles();
        
        for (int i = 0; i < listOfFiles.length; i++) {
               
            File txtfile = listOfFiles[i];
            File[] listOfTxtFile = txtfile.listFiles();
         
            for (int j = 0; j < listOfTxtFile.length; j++) {
                      
                try {
                
                fileRead = new FileReader( listOfTxtFile[j]);
             
                    read = new BufferedReader(fileRead);
                    String line = null;
                    String[] words = null;
		
                    while((line = read.readLine()) != null) {
               
                        words = line.split(DELIMITERS);
			
                        for(String s : words) {
                            
                                
			
                            if(!s.equals("")) {	
                                s = s.toLowerCase();
                                        
						
                                probeHashTable.put(new Key(s),String.valueOf(listOfTxtFile[j]));
                                  
				}	
                           
                            }
                        
                        
                    }
			
	}catch(IOException e) { }

                
            }

        }  
        probeHashTable.printMap();
    }
	
    
    private void run() {
		
		Key key = null;
		String input = null;
		
		do {
			System.out.print("\n\nSearch : ");
			input = scan.nextLine().toLowerCase();
			
			
			if(input.contains("ı"))
				input = input.replace("ı", "i");
			
			if(!"-exit".equals(input) && !"-show".equals(input)) {
				
				key = new Key(input);
			
				if(probeHashTable.get(key) != null) {
				
					//printResults(key.hashCode(), probeHashTable.getIndex(key), mapEntry.toString1());
					System.out.println(probeHashTable.get(key));					
											
				}
				else 
					printNotFound(key.toString());
			}
			
		}while(!"-exit".equals(input) && !"-show".equals(input));
		
		
		if("-show".equals(input)) {
			
			show();
			
		}
			
		System.out.println("Program is closed.");
                

	}
    
    private void show(){
		
		int totalWords = 0;
		int i = 0;
	
		for(Entry<Key,String> entry : probeHashTable.entrySet()) {
			
			if(entry != null) {
				printTableLine(i, entry.getKey(), entry.getKey().hashCode());
				
			}
			i++;
		}
	
//		intrface.printTotalValues(totalWords, hashTable.size());
	}
    public void printResults(int key,int index, String listOfTxtFile) {
		
		System.out.println("Key : " + key + "\nIndex : " + index + "\nListOfTxtFiles" + listOfTxtFile ) ;
						  
	}
    public void printNotFound(String search) {
		
		System.out.println(search + " is not found in text file.");
	}
    public void printTableLine(int i, Key key, int hashCode) {
			
		System.out.println(String.format("%d. Key: %-20s HashCode: %-20d Count: %-5d", i, key, hashCode));
			
	}
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
    
    
}
