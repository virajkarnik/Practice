/**
 * Created by viraj on 1/9/2017.
 */
public class AddWithoutArithmetic {
    public static void main(String[] args) {
        int a = 954, b = 413;
        System.out.println(findSumWOarith(a, b));
    }

    static int findSumWOarith(int a, int b) {
        if (b == 0) return a;
        if (a == 0) return b;
        int sumWOcarry = a^b;
        int carry = (a&b) << 1;
//        int sum = sumWOcarry | carry;
        return findSumWOarith(sumWOcarry, carry);
    }
}
