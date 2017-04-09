import java.util.*;

import static java.lang.System.in;

/**
 * Created by viraj on 1/9/2017.
 */
public class NumPairSum {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        List<Integer> num = Arrays.asList(7, 14, -3, 12, 78, 22, 8, 18, 5, 22, 19, 9, 10);
        int sum = sc.nextInt(); int pairs = 0;
        HashMap<Integer, Integer> paired = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.size(); i++) {
            int partner = sum - num.get(i);
            if (num.contains(partner) && !(paired.containsKey(partner))) {
                paired.put(num.get(i), partner);
                pairs++;
            }
        }
        System.out.println(pairs);
    }
}
