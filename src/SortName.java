import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by viraj on 4/1/2017.
 */

class PersonName {
    String firstName, middleName, lastName;
}

public class SortName {

    ArrayList<PersonName> pname = new ArrayList<PersonName>();
    PersonName pn = new PersonName();
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        SortName sn = new SortName();
        sn.showNames();
    }

    void showNames() {
        for (int i = 0; i < 5; i++) {
            PersonName p = new PersonName();
            p.firstName = sc.next();
            p.middleName = sc.next();
            p.lastName = sc.next();
            this.pname.add(i, p);
        }
        System.out.println(this.pname.size());
        for (PersonName pnintr: pname) {
            System.out.println(pnintr.lastName);
        }

        Comparator<PersonName> pnLastName = (PersonName pn1, PersonName pn2) -> pn1.lastName.compareTo(pn2.lastName);
        Collections.sort(this.pname, pnLastName);
        for (PersonName pnitr: pname) {
            System.out.println(pnitr.lastName+", "+pnitr.firstName+", "+pnitr.middleName);
        }
    }
}
