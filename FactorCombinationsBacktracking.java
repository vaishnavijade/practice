import java.util.*;
public class FactorCombinationsBacktracking{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> res=generateCombinations(n);
        System.out.println(res);
    }
    public static List<List<Integer>> generateCombinations(int n){
        List<List<Integer>> res=new ArrayList<>();
        backtrack(res,new ArrayList<>(),n,2);
        return res;
    }
    private static void backtrack(List<List<Integer>> res,List<Integer> curr,int target,int start){
        if(target==1){
            if(curr.size()>1){//checks for the curr to have atleats 2 ele to avoid the n being repreated as factor
                res.add(new ArrayList<>(curr));
            }return;
        }
        for(int i=start;i<=target;i++){
            if(target%i==0){
                curr.add(i);
                backtrack(res,curr,target/i,i);
                curr.remove(curr.size()-1);
            }
        }
    }
}
/*Ms Manasa is working on numbers; she is fascinated by number factors.
She is given a number N, she wants to find out all possible ways of 
obtaining N as multiple of its factors.
For example given N =12
can be written as multiple of 2,3 and 4.
and the ways to obtains 12 from ots factors are: 2*2*3, 2*6, 3*4

Your task is to help Ms Manasa to find the all possible ways of obtaining N 
from its factors and return all the possible ways as shown in the samples.

Input Format:
-------------
An integer N, value of N.

Output Format:
--------------
Print the list of possiblilties.


Sample Input-1:
---------------
12

Sample Output-1:
----------------
[[2, 2, 3], [2, 6], [3, 4]]


Sample Input-2:
---------------
16

Sample Output-2:
----------------
[[2, 2, 2, 2], [2, 2, 4], [2, 8], [4, 4]]


Sample Input-3:
---------------
32

Sample Output-3:
----------------
[[2, 2, 2, 2, 2], [2, 2, 2, 4], [2, 2, 8], [2, 4, 4], [2, 16], [4, 8]]
 */