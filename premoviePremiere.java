import java.util.*;
public class premoviePremiere {
    public static boolean canServeAll(int[] notes) {
        int count25 = 0, count50 = 0; // To store the count of $25 and $50 bills we have
        
        for (int note : notes) {
            if (note == 25) {
                // If the person gives a $25 bill, no change needed
                count25++;
            } else if (note == 50) {
                // If the person gives a $50 bill, we need to return one $25 bill as change
                if (count25 > 0) {
                    count25--; // Give one $25 as change
                    count50++; // Increase the count of $50 bills
                } else {
                    return false; // Not enough $25 bills for change
                }
            } else if (note == 100) {
                // If the person gives a $100 bill, we need to return $75 as change
                if (count50 > 0 && count25 > 0) {
                    // Prefer giving one $50 and one $25 bill as change
                    count50--; // Give one $50 bill
                    count25--; // Give one $25 bill
                } else if (count25 >= 3) {
                    // Otherwise, give three $25 bills as change
                    count25 -= 3;
                } else {
                    return false; // Not enough bills to give change
                }
            }
        }
        
        return true; // All customers successfully served
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Reading input
        int N = sc.nextInt(); // Number of persons
        int[] notes = new int[N]; // Array to store the notes
        
        for (int i = 0; i < N; i++) {
            notes[i] = sc.nextInt(); // Reading each note value
        }
        
        // Calling the function and printing the result
        System.out.println(canServeAll(notes));
        
        sc.close();
    }
}
/*For a Movie Premiere in US, advance booking is opened,
At Quad Cinema theater, each ticket costs $25.
And issue only one ticket per head. 

People are standing in a queue to buy from Quad Cinema counter, 
and order one at a time. And they are paying with either a $25, $50, or $100 notes.

You will be given, an array of notes[], the people are carrying with them.
Your task is to issue ticket and settle the balance to each person, 
If a person given a $50 note, Issue the ticket worth $25 and settle the balance $25.

Print true, if and only if you can provide tickets and settle the balance 
for all the people in the queue. Otherwise, false.

Note: Initially you don't have any amount in hand.

Input Format:
-------------
Line-1: An integer N, number of persons
Line-2: N space separated integers, notes with the persons.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
5
25 25 25 50 100

Sample Output-1:
----------------
true

Explanation:
-----------
- The first three people pay with $25, so no change is needed.
- The fourth person pays with $50, and you return $25 as change.
- The fifth person pays with $100, and you return $75 as change ($50 + $25).
- Since every person gets their ticket and correct change, the answer is true.

Sample Input-2:
---------------
5
25 25 50 50 100

Sample Output-2:
----------------
false

Explanation:
-----------
- The first two people pay with $25, so no change is needed.
- The third and fourth people pay with $50, and you return $25 as change.
- The fifth person pays with $100, but you cannot return $75 as change 
(you only have $50 bills).
Since not everyone can receive their correct change, the answer is false.
 */