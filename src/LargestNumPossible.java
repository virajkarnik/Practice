import java.util.Scanner;

/**
 * Created by viraj on 1/9/2017.
 */
public class LargestNumPossible {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        System.out.println(findLargest(n));
    }

    static long findLargest(long n) {
        if (n > -10 && n < 10) return  n;
        long max = n;
        String s = Long.toString(n);
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == '-') continue;
            double a = Character.getNumericValue(s.charAt(i));
            double b = Character.getNumericValue(s.charAt(i+1));
            double avg = Math.ceil((a + b) / 2);
            System.out.println((a+b)/2 + " " + (int)avg);
            StringBuilder temp = new StringBuilder();
            temp.append(s);
            temp.setCharAt(i, Character.forDigit((int)avg, 10)); temp.setCharAt(i+1, Character.forDigit((int)avg, 10));
            long ntemp = Long.parseLong(temp.toString());
            if (ntemp > max) max = ntemp;
        }
        return max;
    }
}
