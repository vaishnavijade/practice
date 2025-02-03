
import java.util.*;
public class RelationChainsDFS{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        // int n=numOfChains(arr);
        System.out.println(numOfChains(arr));
    }
    public static int numOfChains(int[][] arr){
        int n=arr.length;
        boolean visited[]=new boolean[n];
        int relations=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,arr,visited);
                relations++;
            }
        }
        return relations;
    }
    private static void dfs(int person,int[][] arr,boolean[] visited){
        visited[person]=true;
        for(int rel=0;rel<arr.length;rel++){
            if(arr[person][rel]==1 && !visited[rel]){
                dfs(rel,arr,visited);
            }
        }
    }
}

/*There are P people in a Village, some of the people are relatives, others are not.
Their relationship is transitive in nature. 

For example, 
 if A is a direct relative of B, and B is a direct relative of C, 
then A is an indirect relative of C. And we define a Relation Chain is a group 
of people who are direct or indirect relatives.
 
 Given a P*P matrix R representing the relationship between people in the village. 
 If R[i][j] = 1, then the i and j persons are direct relatives with each other, 
 otherwise not. 

Your task is to findout the total number of Relation Chains among all the people.

Input Format:
-------------
Line-1 : An integer P, number of people
Next P lines : P space separated integers.

Output Format:
--------------
Print an integer, the total number of Relation Chains


Sample Input-1:
---------------
3
1 1 0
1 1 0
0 0 1

Sample Output-1:
----------------
 2

 Explanation:
 ------------
 The 0-th and 1-st people are direct relatives, so they are in a relation chain.
 The 2-nd person himself is in a relation chain. So return 2.

Sample Input-2:
---------------
3
 1 1 0
 1 1 1
 0 1 1
 
Sample Output-2:
----------------
 1

Explanation:
------------
The 0-th and 1-st people are direct relatives, 1-st and 2-nd people are direct 
relatives. So, the 0-th and 2-nd people are indirect relatives.
All of them in the same relative chain. So return 1.

 */