import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by viraj on 12/30/2016.
 */
public class FindDupPairs_Google {
    public static void main(String[] args) {

        int n = 4362365;
        StringBuilder st = new StringBuilder();
        String s = Integer.toString(n);
        st.append(s);
        int tempn = n;
        int div = 10;
        int rem = tempn%10;
        double max = n;
        tempn = (tempn - rem)/10;
        ArrayList<Integer> digits = new ArrayList<Integer>();
        digits.add(0, rem); int i = 1; double tempdiv2;
        while (tempn >= 10) {
            double tempmax = tempn;
            div *= 10;
            if (tempn%10 < rem) {
                double avg = (rem + tempn%10)/2;
                double tempdiv = div;
                tempmax = tempmax*Math.pow(10, digits.size()-1);
/*
                while (tempdiv >= 1) {
                    tempmax = tempmax*tempdiv;
                    tempdiv /= 10;
                }
*/
                tempdiv2 = div/10;
                int j = 0;
                for (int k = digits.size() - 1; k >= 0 ; k--) {
                    tempmax = tempmax + digits.get(k)*Math.pow(10, k);
                }
/*
                while (tempdiv >= 1) {
                    tempmax = tempmax + tempdiv2*digits.get(j++);
                    tempdiv2 = tempdiv2/10;
                }
*/
            }
            rem = tempn%10;
            digits.add(i++, rem);
            tempn = (tempn - rem)/10;
            max = tempmax;
            System.out.println(max);
        }
        System.out.println("Final Max is: " + max);
    }

    int find_dup_pairs(int[] arr) {
        return 0;
    }
}

/*
        for (int i = 0; i <s.length()-1; i++) {
            if (Character.getNumericValue(s.charAt(i)) < Character.getNumericValue(s.charAt(i+1))) {
                double av = Math.ceil((Character.getNumericValue(s.charAt(i)) + Character.getNumericValue(s.charAt(i+1)))/2);
                int avg = (int) av;
                st.setCharAt(i, (char)avg);
                st.setCharAt(i+1, (char)avg);
                break;
            }
        }
        System.out.println(st);

 */