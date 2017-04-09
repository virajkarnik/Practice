/*please test input/output by entering inputs in the box below.*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {
    Stack<Integer> cards = new Stack<Integer>();
    Stack<Integer> aCards = new Stack<Integer>();
    Stack<Integer> bCards = new Stack<Integer>();
    Stack<Integer> cCards = new Stack<Integer>();
    public static void main(String args[] ) throws Exception {
        String thisLine = null;
        Scanner sc = new Scanner(System.in);

        int n= 0;
        int m= 0;
        try {
            n = sc.nextInt();
            while(n <1) { // making sure that n is within given constraints
                n = sc.nextInt();
            } //while
            m = sc.nextInt();
            while(m >100000) {
                m = sc.nextInt();
            } //while
        }
        catch (NoSuchElementException e) {

        }

        Solution sol = new Solution();
        for (int i =n; i >=1; i--) {
            sol.cards.push(i);
        }
        System.out.println("initial stack");
        for (int i = 1; i <= n; i++) {
            System.out.print(sol.cards.peek() + " ");
        }

        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            while (a > n-1) { // Edge Case: make sure that there is at least one card left after first step for user to pick B number of cards in next step
                System.out.print("a: "); a = sc.nextInt();

            }
            int b = sc.nextInt();
            while (b > n-a) { // Edge Case: making sure that only available number of cards are picked and valid number is entered
                System.out.print("b: "); b = sc.nextInt();
            }
            int c = sc.nextInt();
            while (c > n-b) { // Edge Case: making sure that only available number of cards are picked and valid number is entered
                System.out.print("c: "); c = sc.nextInt();
            }
            sol.shuffle(a, b, c);
        }
        System.out.println("final stack");
        for (int i = 1; i <= n; i++) {
            System.out.print(sol.cards.pop() + " ");
        }
    }

    void shuffle(int a, int b, int c) {

        noOrderChange(a);
        orderChange(b);
        for (int i = 1; i <= a; i++) {
            this.cards.push(this.aCards.pop());
        }
        noOrderChange(c);
        for (int i = 1; i <= b; i++) {
            this.cards.push(this.cCards.pop());
        }
        for (int i = 1; i <= c; i++) {
            this.cards.push(this.aCards.pop());
        }
    }

    void noOrderChange (int x) {

        for ( int i = 1; i <= x; i++) {
            this.aCards.push(this.cards.pop());
        }
    }

    void orderChange (int x) {

        for (int i = 1; i <= x; i++) {
            this.bCards.push(this.cards.pop());
        }
        for (int i = 1; i <= x; i++) {
            this.cCards.push(this.bCards.pop());
        }

    }
}














/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((thisLine = br.readLine()) != null) {
            System.out.println(thisLine);
        }*/