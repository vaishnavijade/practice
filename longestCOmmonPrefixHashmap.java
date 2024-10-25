
import java.util.*;

public class longestCOmmonPrefixHashmap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //  strings
        sc.nextLine();  
        
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next(); 
        }
        
        System.out.println(findLongestCommonPrefix(strs));
    }

    public static String findLongestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        HashMap<Integer, Character> map = new HashMap<>();
        StringBuilder commonPrefix = new StringBuilder();
        
        int minLength = strs[0].length();
        
        for (int i = 0; i < minLength; i++) {
            char currentChar = strs[0].charAt(i); 
            map.put(i, currentChar);
            
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != currentChar) {
                    
                    return commonPrefix.toString();
                }
            }
            commonPrefix.append(currentChar);
        }
        
        return commonPrefix.toString();
    }
}

