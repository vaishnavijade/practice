import java.util.*;
public class spAlphaBeta{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        String alpha=input[0];
        String beta=input[1];
        boolean res=canTranslate(alpha,beta);
        System.out.println(res);
    }
    public static boolean canTranslate(String alpha,String beta){
        if(alpha.length()!=beta.length())return false;
        char[] alphaa=alpha.toCharArray();
        char[] betaa=beta.toCharArray();
        Map<Character,Character> atob=new HashMap<>();
        Map<Character,Character> btoa=new HashMap<>();
        for(int i=0;i<alphaa.length;i++){
            char as=alphaa[i];
            char bs=betaa[i];
            if(atob.containsKey(as)){
                if(!atob.get(as).equals(bs)){
                    return false;
                }
            }
            else{
                atob.put(as,bs);
            }
            if(btoa.containsKey(bs)){
                if(!btoa.get(bs).equals(as)){
                    return false;
                }
            }
            else{
                btoa.put(bs,as);
            }
        }
            
        return true;
    }
}
        
    

/*In a secret code system, two distinct ancient civilizations, `Alpha` and `Beta`,
used their own unique symbols to encode messages. However, these symbols 
represent the same meanings in their respective languages. 

Given two encoded messages, one from Alpha and one from Beta, determine 
if these messages are translatable — meaning that the symbols used in Alpha's 
message can be uniquely translated to the symbols in Beta's message. 

The translation must follow these rules:
    - Each symbol in Alpha's message must map to exactly one symbol in Beta's 
      message, and vice versa.
    - No two symbols from Alpha's message can map to the same symbol in Beta's 
      message.
    - The order of symbols must be preserved in the translation.
    - A symbol may map to itself if needed.

Your task is to determine whether these ancient messages from two different 
civilizations can be translated perfectly while maintaining their symbolic 
structure. If yes print "true", otherwise, "false".

Input Format:
-------------
Space separated strings, Alpha and Beta messages.

Output Format:
--------------
Boolean value.


Sample Input-1:
---------------  
star moon

Sample Output-1:
----------------  
false

Explanation:  
------------
In this case, 's' would need to map to 'm', and 't' would need to map to 'o', 
but then 'a' and 'r' would both need to map to 'n', which violates the rule 
that no two symbols may map to the same symbol.


Sample Input-2:
---------------
sun day

Sample Output-2:
----------------
true

Explanation:
------------  
Here, each symbol in the Alpha message has a unique mapping to the Beta message, 
preserving the order and meaning: 's' -> 'd', 'u' -> 'a', and 'n' -> 'y'.

Constraints:
------------
	- 1 ≤ length of Alpha's message ≤ 50,000
	- The length of Beta's message is equal to the length of Alpha's message.
	- Both messages consist of any valid ASCII characters.
 */