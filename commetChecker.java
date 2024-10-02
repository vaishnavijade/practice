import java.util.*; 
import java.util.Stack;
public class commetChecker{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s= sc.nextLine();
        boolean t=isValid(s);
        System.out.println(t);
    }
    public static boolean isValid(String s){
        Stack<String> stack=new Stack<>();
        int i=0;
        while(i<s.length()){
            if(s.charAt(i) == '{'){
                stack.push("{");
                i++;
            }else if(s.charAt(i)=='}'){
                if(stack.isEmpty() || !stack.peek().equals("{")){
                    return false;
                }
                stack.pop();
                i++;
            }
            else if(i<s.length() -1 && s.charAt(i)=='/'&&s.charAt(i+1)=='*'){
                stack.push("/*");
                i+=2;
            }
            else if(i<s.length()-1 && s.charAt(i)=='*' && s.charAt(i+1)=='/'){
                if(stack.isEmpty() || !stack.peek().equals("/*")){
                    return false;
                }
                stack.pop();
                i+=2;
            }
            else if(i<s.length() -1 && s.charAt(i)=='/'&& s.charAt(i+1)=='/'){
                i+=2;
                while(i<s.length()-1 && s.charAt(i)!='\n'){
                    i++;
                }
            }
            else{
                i++;
            }
        }
        return stack.isEmpty();
    }
}