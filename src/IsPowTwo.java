/**
 * Created by viraj on 4/8/2017.
 */
public class IsPowTwo {
    public static void main(String[] args) {
        int n = 16;
        int leadingZeros = Integer.numberOfLeadingZeros(n);
        int trailinngZeros = Integer.numberOfTrailingZeros(n);
        if ((leadingZeros+trailinngZeros+1)==32) {
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }
    }
}
