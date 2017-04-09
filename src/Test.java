import sun.reflect.generics.tree.Tree;

import javax.xml.bind.SchemaOutputResolver;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BinaryOperator;

/**
 * Created by viraj on 1/6/2017.
 */
public class Test {
    public static void main(String[] args) {

        double a = 5.5;
        System.out.println(Math.ceil(a));
    }

//9223372036854775808
//15511210043330985984000000
}

/*
* class Solution {
    public int solution(int n) {
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

            int ntemp = Integer.parseInt(temp.toString());
            if (ntemp > max) max = ntemp;
        }
        return max;
    }
}
* */