import java.util.*;
public class mobileKeypad{
    private static final String[] keypad={
        "","","abc","def",
        "ghi","jkl","mno",
        "pqrs","tuv","wxyz"
    };
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String S=sc.next();
        List<String> res=new ArrayList<>();
        if(S==null || S.isEmpty()){
            System.out.println(res);
            return;
        }
        backtrack(S,0,new StringBuilder(),res);//index is ex 24 lo 2 wwhiv is abc
        System.out.println(res);
    }
    private static void backtrack(String dig,int index,StringBuilder path,List<String> res){
        if(index==dig.length()){//path reached length of dig
            res.add(path.toString());
            return;
        }
        int digit=dig.charAt(index)-'0';//converts char to int value
        String letters=keypad[digit];
        
        for(char ch:letters.toCharArray()){
            path.append(ch);
            backtrack(dig,index+1,path,res);
            path.deleteCharAt(path.length()-1);
        }
    }
}
/*Given a classic mobile phone, and the key pad of the phone looks like below.
	1		2		3
           abc	   def
		 
	4		5		6
    ghi    jkl     mno
  
	7		8		9
    pqrs    tuv     wxyz
	
	*		0		#


You are given a string S contains digits between [2-9] only, 
For example: S = "2", then the possible words are "a", "b", "c".

Now your task is to find all possible words that the string S could represent.
and print them in a lexicographical order. 

Input Format:
-------------
A string S, consist of digits [2-9]

Output Format:
--------------
Print the list of words in lexicographical order.


Sample Input-1:
---------------
2

Sample Output-1:
----------------
[a, b, c]


Sample Input-2:
---------------
24

Sample Output-2:
----------------
[ag, ah, ai, bg, bh, bi, cg, ch, ci]
 */