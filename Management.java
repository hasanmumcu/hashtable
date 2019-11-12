



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class Management {
    private AbstractHashMap<Key, String> hashTable;
    private Scanner scan;
    private BufferedReader read;
    private BufferedReader readStop;
    private FileReader fileRead;
    private FileReader fileReadStop;
    private ArrayList<String> stopWords;
    private Key.HashMethod hashMethod;
    int bucketPutCounter = 0;
    long startTime = System.currentTimeMillis();

    String DELIMITERS = "[-+=" +
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





    public static void main(String[] args) {

	new Management();
    }


    public Management() {
		try {
                         
			 hashTable = new DoubleHashMap<Key,String>();
                         hashMethod = Key.HashMethod.SSF; 
			 scan = new Scanner(System.in);
                         stopWords  = new ArrayList<String>();
                         stopWords = readStopWords(stopWords);
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
                        

                        for (int k = 0; k < words.length; k++) {
                            words[k] = words[k].toLowerCase(Locale.ENGLISH);
                            words[k] = words[k].replaceAll("ı", "i");
                        
                            if(!fileContainsWord(stopWords, words[k]) && !words[k].equals("")){
                            
                                hashTable.put(new Key(words[k], hashMethod),String.valueOf(listOfTxtFile[j]));
                                bucketPutCounter++;
                            }
                            
                            

                        }
                        

                    }
                  
                 
                    System.out.println(listOfTxtFile[j]);
                    

	                }catch(IOException e) { }
            }                  
        }
        long endTime = System.currentTimeMillis();
        
       
        System.out.println((endTime - startTime)/ 1000 );
        System.out.println(bucketPutCounter);
        
    }

   private boolean fileContainsWord(ArrayList<String> file, String word){

     for(String file_word : file)
        if(file_word.equalsIgnoreCase(word))
            return true;

     return false;
   }
   
  private ArrayList<String> readFile(String fileName) throws Exception{
      
      ArrayList<String> lines = new ArrayList<String>();
      FileReader file = new FileReader(fileName);
      BufferedReader br = new BufferedReader(file);
      String line = null;
      while((line = br.readLine()) != null){
         lines.add(line);
      }
      
      return lines;
  }

   private ArrayList<String> readStopWords(ArrayList<String> stopWords){

        try {

                fileReadStop = new FileReader("stop_words_en.txt");

                    readStop = new BufferedReader(fileReadStop);
                    String line = null;

                    while((line = readStop.readLine()) != null) {


                        stopWords.add(line);

                     }

	}catch(IOException e) { }

        return stopWords;

    }


    private void run() {

		Key key = null;
		String input = null;

		do {
			System.out.print("\n\n> Search : ");
			input = scan.nextLine().toLowerCase();


			if(input.contains("ı"))
				input = input.replace("ı", "i");

			if(!"-exit".equals(input) && !"-show".equals(input) && !"-test".equals(input)) {

				key = new Key(input, hashMethod);

				if(hashTable.get(key) != null) {

					//printResults(key.hashCode(), hashTable.getIndex(key), mapEntry.toString1());
					System.out.println(hashTable.get(key));

				}
				else
					printNotFound(key.toString());
			}
                        
                        else if("-show".equals(input)) { // show degistirilecek!!!

                            hashTable.printMap();

                        }
                        else if("-test".equals(input)) {
                            int count = 0;
                            try{
                                ArrayList<String> searchFile = readFile("1000.txt");
                                for(String str : searchFile){
                                    System.out.println(str + ": " + hashTable.get(new Key(str, hashMethod)));
                                    if(hashTable.get(new Key(str, hashMethod)) != null) count++;
                                }
                                System.out.println("Found: " + count);
                            }
                            catch(Exception ex){}
                        }

		}while(!"-exit".equals(input));


		

		System.out.println("Program is closed.");


	}


    public void printResults(int key,int index, String listOfTxtFile) {

		System.out.println("Key : " + key + "\nIndex : " + index + "\nListOfTxtFiles" + listOfTxtFile ) ;

	}
    public void printNotFound(String search) {

		System.out.println(search + " is not found in text file.");
	}
    public void printTableLine(int i, Key key, int hashCode) {

		System.out.println(String.format("%d. Key: %-20s HashCode: %-20d", i, key, hashCode));

	}



































}
