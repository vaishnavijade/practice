import java.util.*;
public class secretCodes{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String input=sc.nextLine();
        String[] arr=input.split(" ");
        List<String> validOnes=returnZoneWords(arr);
        System.out.println(validOnes);
    }
    public static List<String> returnZoneWords(String[] arr){
        Set<Character> zone1= new HashSet<>(Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
        Set<Character> zone2= new HashSet<>(Arrays.asList('a','s','d','f','g','h','j','k','l'));
        Set<Character> zone3= new HashSet<>(Arrays.asList('z','x','c','v','b','n','m'));
        List<String> validOnes=new ArrayList<>();
        for(String x:arr){
            String word=x.toLowerCase();
            char firstChar=word.charAt(0);
            Set<Character> zone=getZone(firstChar,zone1,zone2,zone3);
            if(zone==null)continue;
            boolean isValid=true;
            for(char c :word.toCharArray()){
                if(!zone.contains(c)){
                    isValid=false;
                    break;
                }
            }
            if(isValid){
                validOnes.add(x);
            }
            
        }
        return validOnes;
        
    }
    private static Set<Character> getZone(char c,Set<Character> zone1,Set<Character> zone2, Set<Character> zone3){
        if (zone1.contains(c)) return zone1;
        if (zone2.contains(c)) return zone2;
        if (zone3.contains(c)) return zone3;
        return null; 
    }
}/*In a futuristic virtual reality (VR) game world, players are provided with custom VR keypads that are similar to modern American keyboards but have some restrictions. The keypad is divided into three distinct zones, and each zone contains specific letters that the player can use for a task.
	- Zone 1: Letters on the top row: "qwertyuiop"
	- Zone 2: Letters on the middle row: "asdfghjkl"
	- Zone 3: Letters on the bottom row: "zxcvbnm"

Players are given a set of secret codes (words), and they must type these codes using only letters from one zone at a time. If a word uses letters from more than one zone, it will be considered invalid and cannot be typed.

Your task is to help the players by filtering out the valid secret codes (words) that can be typed using letters from only one zone.

Given a list of secret codes (words), return the codes that can be typed using letters from only one zone of the VR keypad.

Constraints:
------------
1 ≤ secretCodes.length ≤ 20
1 ≤ secretCodes[i].length ≤ 100
secretCodes[i] consists of English letters (both lowercase and uppercase).

Input Format:
-------------
Space separated words, secretCodes[]

Output Format:
--------------
A list of codes that can be typed using letters from only one zone.


Sample Input-1:
---------------
Galaxy Mars Venus Sky

Sample Output-1:
----------------
["Mars", "Sky"]

Explanation:
------------
"Mars" can be typed using only Zone 2.
"Sky" can be typed using only Zone 3.
"Galaxy" and "Venus" use letters from multiple zones and are thus invalid.


Sample Input-2:
---------------
keyboard monkey

Sample Output-2:
----------------
[]

Explanation:
------------
None of the words can be typed using letters from only one zone.


Sample Input-3:
---------------
qw er ty

Sample Output-3:
----------------
["qw", "er", "ty"]

Explanation:
------------
All the codes can be typed using only letters from Zone 1.
 */