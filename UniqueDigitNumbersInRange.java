import java.util.*;
public class UniqueDigitNumbersInRange {
    private static boolean hasUniqueDigits(int num){
        Set<Character> seenDigits = new HashSet<>();
        String numstr=Integer.toString(num);
        for(char digit : numstr.toCharArray()){
            if(seenDigits.contains(digit)){
                return false;
            }
            seenDigits.add(digit);
        }
        return true;
    }
    public static List<Integer> findUniqueDigitNumInRange(int low,int high){
        List<Integer> uniqueNums = new ArrayList<>();
        int count=0;
        for(int i=low;i<=high;i++){
            if(hasUniqueDigits(i)){
                count++;
                uniqueNums.add(i);
            }
        }
        System.out.println("count of unique digits in range: "+count);
        return uniqueNums;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int low=sc.nextInt();
        int high=sc.nextInt();
        List<Integer> uniqueNumbers = findUniqueDigitNumInRange(low, high);
        System.out.println(uniqueNumbers);
    }
}
