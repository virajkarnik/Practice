import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by viraj on 1/10/2017.
 */
public class Solution_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        // write your code in Java SE 8
        if (n > -10 && n < 10) return  n;
        int max = 0;
        String s = Long.toString(n);
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == '-') continue;
            double a = Character.getNumericValue(s.charAt(i));
            double b = Character.getNumericValue(s.charAt(i+1));
            double avg = Math.ceil((a + b) / 2);
            System.out.println((a+b)/2 + " " + (int)avg);
            StringBuilder temp = new StringBuilder();
            temp.append(s);
            temp.setCharAt(i, Character.forDigit((int)avg, 10)); temp.deleteCharAt(i+1);
            System.out.println(temp);
            /*for (int k = i+1; k <= temp.length()-1; k++) {
                //if (k == temp.length()-2) continue;
                if (k == temp.length()-1) {
                    temp.deleteCharAt(k); continue;
                }
                temp.setCharAt(k, temp.charAt(k+1));
            }*/
            int ntemp = Integer.parseInt(temp.toString());
            if (ntemp > max) max = ntemp;
        }
        return max;
    }
}
