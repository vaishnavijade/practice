import java.util.*;
import java.util.regex.*;
public class Regex {
    public static boolean valid(String phno){
        String exp="^\\+91 \\d{5} \\d{5}$";
        Pattern p=Pattern.compile(exp);
        if(p.matcher(phno).matches()){
            return true;
        }
        String exp2="^0\\d{2}-\\d{4}-\\d{4}$";
        p=Pattern.compile(exp2);
        if(p.matcher(phno).matches()){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String arr[]=new String[1+n];
        for(int i=0;i<n+1;i++){
            arr[i]=sc.nextLine();
        }
        List<String> validNumbers=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            if(valid(arr[i])){
                validNumbers.add(arr[i]);
            }
        }         
        System.out.println(arr);
    }
}
/*You are developing a customer management system for an international
telecom company. The system accepts phone numbers from users in 
specific formats based on their location. The system must validate 
whether the phone numbers entered conform to the required formats 
before they can be stored in the company's database.

The company operates in two regions with different phone number 
conventions:

	- India: Phone numbers must follow the format +91 xxxxx xxxxx, 
	where: The phone number starts with the country code +91.
		   The next part consists of two groups of 5 digits each, 
		   separated by a space.
	- Other regions: For certain regions, phone numbers must follow 
	the format 0xx-xxxx-xxxx, where: The phone number starts with a 0, 
	followed by a 3-digit area code. The next part consists of two 
	groups of 4 digits each, separated by hyphens.

The user can enter N phone numbers, and the system will validate 
each one according to the rules for the two formats mentioned above. 
If a phone number is valid, it will be added to the list; 
if it is invalid, it will be ignored.

Input Format:
-------------
Line-1: An integer N, number of phone numbers.
Next N lines: a phone number, per line.

Output Format:
--------------
List of valid phone numbers.


Sample Input:
-------------
+91 98765 43210
+91 9876543210
012-3456-7890
01-2345-67890
+91 321 456 7890

Sample Output:
--------------
[+91 98765 43210, 012-3456-7890]










import java.util.*;
import java.util.regex.*;
public class test{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String arr[]=new String[1+n];
        for(int i=0;i<n+1;i++){
            arr[i]=sc.nextLine();
        }
        String patternIndia="^\\+91 \\d{5} \\d{5}";
        String otherPattern="0\\d{2}-\\d{4}-\\d{4}";
        Pattern RegexInd=Pattern.compile(patternIndia);
        Pattern Other=Pattern.compile(otherPattern);
        List<String> validNumbers=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            String num=arr[i];
            Matcher india=RegexInd.matcher(num);
            Matcher otherM=Other.matcher(num);
            if(india.matches()|| otherM.matches()){
                validNumbers.add(num);
            }
        }
        System.out.println(validNumbers);
        
    }
    
}
 */
