import java.util.*;
public class  nonoverlappingSubstring {
    public static void generateCombinations(String s, String current, int index, List<String> result) {
        if (index == s.length()) {
            result.add(current);
            return;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            String sub = s.substring(index, i);
            generateCombinations(s, current + "{" + sub + "}", i, result);
        }
    }
    
    public static void printAllCombinations(String s) {
        List<String> result = new ArrayList<>();
        generateCombinations(s, "", 0, result);
        
         for (int i = result.size() - 1; i >= 0; i--) {
            System.out.println(result.get(i));
         }
    }

    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1 = sc.nextLine();
        printAllCombinations(s1);
        
    }
}
/*Imagine you are working on a string manipulation project, and you need to find all possible ways to split a given string into non-overlapping substrings. 
These substrings should be enclosed in curly braces {}, and you want to list all possible combinations of how the string can be divided.

Write a program that takes a string as input and returns all possible ways to group non-overlapping substrings within curly braces.

Input Format:
---------------
Line-1: A single string s consisting of lowercase or uppercase letters, numbers, or punctuation.

Output Format:
---------------
Line-1 to n: Print all possible combinations of non-overlapping substrings, each combination enclosed in curly braces {}.

Sample Input-1: 
---------------
abcd

Sample Output-1:
----------------
{abcd}
{abc}{d}
{ab}{cd}
{ab}{c}{d}
{a}{bcd}
{a}{bc}{d}
{a}{b}{cd}
{a}{b}{c}{d}

Sample Input-2: 
----------------
kmit

Sample Output-2:
-----------------
{kmit}
{kmi}{t}
{km}{it}
{km}{i}{t}
{k}{mit}
{k}{mi}{t}
{k}{m}{it}
{k}{m}{i}{t}
 */

