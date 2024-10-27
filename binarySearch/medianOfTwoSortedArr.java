import java.util.*;
//  * medianOfTwoSortedArr
public class medianOfTwoSortedArr {
    public static double findMedian(int arr1[],int arr2[]){
        int n1=arr1.length;
        int n2=arr2.length;
        if(n1>n2)findMedian(arr2, arr1);
        int low=0;
        int high=n1;
        while(low<=high){
            int mid1=(low+high)/2;
            int mid2=(n1+n2+1)/2-mid1;

            int maxLeftn1=(mid1==0)?Integer.MIN_VALUE:arr1[mid1-1];//l1
            int minRightn1=(mid1==n1)?Integer.MAX_VALUE:arr1[mid1];//r1
            int maxLeftn2=(mid2==0)?Integer.MIN_VALUE:arr2[mid2-1];//l2
            int minRightn2=(mid2==n2)?Integer.MAX_VALUE:arr2[mid2];//r2

            if (maxLeftn1 <= minRightn2 && maxLeftn2<=minRightn1){
                if((n1+n2)%2==0){
                    return ((double)(Math.max(maxLeftn1,maxLeftn2)+Math.min(minRightn1,minRightn2))/2);
                }else{
                    return (double)Math.max(maxLeftn1,maxLeftn2);
                }
            }else if(maxLeftn1>minRightn2){
                high=mid1-1;
            }else if(minRightn1<maxLeftn2){
                low=mid1+1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        int[] a1 = new int[n1];
        int[] a2 = new int[n2];
        for (int i=0;i<n1;i++){
            a1[i]=sc.nextInt();
        }for (int i=0;i<n2;i++){
            a2[i]=sc.nextInt();
        }
        System.out.println(findMedian(a1, a2));

    }
}