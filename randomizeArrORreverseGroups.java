import java.util.*;
public class randomizeArrORreverseGroups{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }
        int m=sc.nextInt();
        int i=sc.nextInt();
        int j=sc.nextInt();
        if(i>=j){
            System.out.println(Arrays.toString(arr));
        }
        reverseGroups(arr,m,i,j);
        System.out.println(Arrays.toString(arr));
    }
    public static void reverseGroups(int arr[],int m,int left,int right){
        for(int i=left;i<=right;i+=m){
            int end=Math.min(i+m-1,right);
            reverseSubarr(arr,i,end);
        }
    }
    public static void reverseSubarr(int arr[],int left,int right){
        while(left<right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
}
