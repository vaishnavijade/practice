import java.util.*;
public class preSecretCode {
    public static void main(String[] args) {
        String[] symbolMap = {
            "/-", "/---", "/-/-", "/--", "-", "--/", "//-", "----", "--", "-///", 
            "/-/", "-/-/", "//", "/-", "---", "/--/", "//-/", "/-/", "---", "/", 
            "--/", "---/", "/--", "/--/", "/-//", "//--"
        };
        
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] msgs = input.split(" ");  
        Set<String> encodedMsg = new HashSet<>();
        
        for (String word : msgs) {
            StringBuilder encoded = new StringBuilder();
            for (char letter : word.toCharArray()) {
                encoded.append(symbolMap[letter - 'a']);  
            }
            encodedMsg.add(encoded.toString()); 
        }
        
        System.out.println(encodedMsg.size());
    }
}
/*You are tasked with building a communication system where text messages are encoded using 
these symbol sequences. You are developing an encoding system that converts words into a 
secret code using a specific set of predefined symbols. Each letter of the English alphabet 
is mapped to a unique sequence of symbols, where - and / are used to represent different 
elements. The entire alphabet has been mapped to these unique sequences.

Here is the mapping for each letter:
['/-', '/---', '/-/-', '/--', '-', '--/', '//-', '----', '--', '-///', '/-/', '-/-/', '//', 
'/-', '---', '/--/', '//-/', '/-/', '---', '/', '--/', '---/', '/--', '/--/', '/-//', '//--']

Given an array words, messages[], each word can be encoded by converting each letter into its
corresponding symbol sequence and concatenating them together.

For example, the word "data" might transform into a code like /---/--/ where each letter is 
replaced by its corresponding symbol sequence. Your goal is to determine how many distinct 
encoded messages are generated from a list of words.

Input Format:
-------------
space separated strings, messages[].

Output Format:
--------------
An integer, number of distinct encoded messages.


Sample Input-1:
---------------
gin zen gig msg

Sample Output-1:
----------------
2


Sample Input-2:
---------------
abc def ghi

Sample Output-2:
----------------
3
 */

