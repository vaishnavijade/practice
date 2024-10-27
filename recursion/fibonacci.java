// package recursion;
import java.util.*;
public class fibonacci{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
        System.out.println(fibonaccii(i)+"");}
    }
    public static int fibonaccii(int n){
        if(n==0)return 0;
        else if (n==1||n==2) return 1;
        return fibonaccii(n-1)+fibonaccii(n-2);}
    }