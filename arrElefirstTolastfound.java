import java.util.*;
public class arrElefirstTolastfound{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] arr=s.split(",");
        String n=sc.nextLine();
        int[] arrres=new int[2];
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(n)){
                arrres[0]=i;
                break;
            } else{
                arrres[0]=-1;
            }
        }
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i].equals(n)){
                arrres[1]=i;
                break;
            }else{
                arrres[1]=-1;
            }
        }
        System.out.println(Arrays.toString(arrres));
    }
}