import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by viraj on 4/3/2017.
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        String[] str = {"rat", "iceman", "abcdefgh", "cramp", "cinema", "art", "tar", "fghbcdea"};
        Comparator<String> stringComparator = (String s1, String s2) -> {
            return ga.sortAnagramGroup(s1).compareTo(ga.sortAnagramGroup(s2));
        };
        Arrays.sort(str, stringComparator);
        for (String s: str) {
            System.out.println(s);
        }
    }

    String sortAnagramGroup(String s) {
        char[] word = s.toCharArray();
        Arrays.sort(word);
        return  new String(word);
    }

}
