/**
 * Created by viraj on 1/9/2017.
 */
public class LargestSum {
    public static void main(String[] args) {
        int[] arr = {2, -8, 3, -2, 4, -10};
        int max = arr[0] + arr[1];
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                temp = temp + arr[j];
                if (temp > max) {
                    max = temp;
                }
            }
           // System.out.println(temp + " " + max);

        }
        System.out.println(max);
    }
}
