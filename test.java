//package hashtable;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//
//
//
//public class test {
//
//    public static <K,V> void main(String[] args) {
//        String DELIMITERS = "[-+=" +
//		        " " +        //space
//		        "\r\n " +    //carriage return line fit
//				"1234567890" + //numbers
//				"’'\"" +       // apostrophe
//				"(){}<>\\[\\]" + // brackets
//				":" +        // colon
//				"," +        // comma
//				"‒–—―" +     // dashes
//				"…" +        // ellipsis
//				"!" +        // exclamation mark
//				"." +        // full stop/period
//				"«»" +       // guillemets
//				"-‐" +       // hyphen
//				"?" +        // question mark
//				"‘’“”" +     // quotation marks
//				";" +        // semicolon
//				"/" +        // slash/stroke
//				"⁄" +        // solidus
//				"␠" +        // space?   
//				"·" +        // interpunct
//				"&" +        // ampersand
//				"@" +        // at sign
//				"*" +        // asterisk
//				"\\" +       // backslash
//				"•" +        // bullet
//				"^" +        // caret
//				"¤¢$€£¥₩₪" + // currency
//				"†‡" +       // dagger
//				"°" +        // degree
//				"¡" +        // inverted exclamation point
//				"¿" +        // inverted question mark
//				"¬" +        // negation
//				"#" +        // number sign (hashtag)
//				"№" +        // numero sign ()
//				"%‰‱" +      // percent and related signs
//				"¶" +        // pilcrow
//				"′" +        // prime
//				"§" +        // section sign
//				"~" +        // tilde/swung dash
//				"¨" +        // umlaut/diaeresis
//				"_" +        // underscore/understrike
//				"|¦" +       // vertical/pipe/broken bar
//				"⁂" +        // asterism
//				"☞" +        // index/fist
//				"∴" +        // therefore sign
//				"‽" +        // interrobang
//				"※" +          // reference mark
//		        "]";
//        BufferedReader read;
//        FileReader fileRead;
//        AbstractHashMap<Key, String> furkanDayar = new DoubleHashMap<Key, String>();
//        int b = 001;
//        boolean nextFile = false;
//        
//       
//        File folder = new File("bbc");
//        File[] listOfFiles = folder.listFiles();
//        
//        
//
//        for (int i = 0; i < listOfFiles.length; i++) {
//            
//           
//           
//            File txtfile = listOfFiles[i];
//            File[] listOfTxtFile = txtfile.listFiles();
//         
//            for (int j = 0; j < listOfTxtFile.length; j++) {
//                
//                
//                try {
//                
//               
//                fileRead = new FileReader( listOfTxtFile[j]);
//             
//                    read = new BufferedReader(fileRead);
//                    String line = null;
//                    String[] words = null;
//		
//                    while((line = read.readLine()) != null) {
//			
//                    
//                            words = line.split(DELIMITERS);
//			
//    
//                        
//                            for(String s : words) {
//                                
//			
//                                if(!s.equals("")) {	
//                                    s = s.toLowerCase();
//                                        
//						
//                                    furkanDayar.put(new Key(s),String.valueOf(listOfTxtFile[j]));
//				}		
//                            }
//                    } 
//
//                
//            
//			 
//	}catch(IOException e) { }
//
//                
//            }
//            
//            
//       
//            
//              }       
//     
//
//       
//
//        furkanDayar.printMap(); 
//        
//        
//        
//
//  
//
//}
//}