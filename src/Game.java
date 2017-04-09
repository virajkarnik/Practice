import java.util.*;

/**
 * Created by viraj on 3/29/2017.
 */

/*
class TicTacToe {

}
*/

public class Game {

    class Grid {
        int x, y;
    }

    HashMap<Integer, ArrayList<Integer>> p1 = new HashMap<Integer, ArrayList<Integer>>();
    HashMap<Integer, ArrayList<Integer>> p2 = new HashMap<Integer, ArrayList<Integer>>();
    ArrayList<String> player1 = new ArrayList<String>();
    ArrayList<String> player2 = new ArrayList<String>();
    static Game g = new Game();
    int size;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter tic-tac-toe board size: "); g.size = sc.nextInt();
        while (g.size < 3) {
            g.size = sc.nextInt();
        }
        boolean user1 = true; int ctr = 0;
        while (ctr < g.size*g.size){ //iterate through to let players play (size*size) times at the most
            System.out.println("Enter two coordinates: ");

            int coord[] = new int[2];
            for (int i = 0; i<2; i++){ //taking x, y coordinates
                coord[i] = sc.nextInt();
            }

            if (coord[0] > g.size || coord[1] > g.size) { //ensure that given coordinates are within the size of game board
                continue;
            }
            boolean inp = g.takeInput(coord[0], coord[1], user1);

            if (!inp) { // check if cell is already marked
                System.out.println("Field already marked! Please choose different value"); continue;
            }

            if (g.horizontal(coord[0], user1) || g.vertical(coord[1], user1) || g.diagonal(user1)) { // check for winning condition
                if (user1) {
                    System.out.println("Player 1 is the Winner!");
                    break;
                } else {
                    System.out.println("Player 2 is the Winner!");
                    break;
                }
            }

            user1 = !user1; ctr++;
            System.out.println("change to user " + user1);
        }

        System.out.println("Game Drawn!");
    }


    boolean takeInput(int x, int y, boolean user1) {
        //Grid temp = new Grid(); temp.x = x; temp.y = y;
        if (this.player1.contains(Integer.toString(x)+" "+Integer.toString(y)) || this.player2.contains(Integer.toString(x)+" "+Integer.toString(y))) {
            System.out.println("already entered");
            return  false;
        }
        if(user1)
            this.player1.add(Integer.toString(x)+" "+Integer.toString(y));
        else
            this.player2.add(Integer.toString(x)+" "+Integer.toString(y));
        System.out.println("new val");
        return true;
    }

    boolean horizontal(int x, boolean player1) {
        //System.out.println("inside horizontal check");
        boolean win = true;
        if (player1) {
          //  System.out.println("player 1 horizontal");
            for (int i = 1; i <= this.size; i++) {
                //System.out.println(this.player1.contains(Integer.toString(x)+" "+Integer.toString(i)));
                if (!this.player1.contains(Integer.toString(x)+" "+Integer.toString(i))) {
            //        System.out.println("next move player 2");
                    win = false;
                }
            }
        }

        if (!player1) {
            //System.out.println("player 2 horizontal");
            for (int i = 1; i <= this.size; i++) {
                //System.out.println(this.player2.contains(Integer.toString(x)+" "+Integer.toString(i)));
                if (!this.player2.contains(Integer.toString(x)+" "+Integer.toString(i))) {
              //      System.out.println("next move player 1");
                    win = false;
                }
            }
        }
        //System.out.println("horizontal win of a player");
        return win;
    }

    boolean vertical (int y, boolean player1) {

        boolean win = true;
        if (player1) {
            for (int i = 1; i <= this.size; i++) {
                if (!this.player1.contains(Integer.toString(i)+" "+Integer.toString(y))) {
                    win = false;
                }
            }
        }

        if (!player1) {
            for (int i = 1; i <= this.size; i++) {
                if (!this.player2.contains(Integer.toString(i)+" "+Integer.toString(y))) {
                    win = false;
                }
            }
        }

        return win;
    }

    boolean diagonal (boolean player1) {
        //System.out.println("inside diagonal check");
        boolean win = true;
        if (player1) {
            for (int i = 1; i <= this.size; i++) {
                if (!this.player1.contains(Integer.toString(i)+" "+Integer.toString(i))) {
                    win = false;
                }
            }
        }

        if (!player1) {
            for (int i = 1; i <= this.size; i++) {
                if (!this.player2.contains(Integer.toString(i)+" "+Integer.toString(i))) {
                    win = false;
                }
            }
        }

        return  win;
    }

}








/*    boolean takeInput(int x, int y, boolean user1) {
        if (this.p1.containsKey(x) || this.p2.containsKey(x)) { // check if entered cell is already occupied
            if (this.p1.get(x).contains(y) || this.p2.get(x).contains(y)) {
                return  false;
            }
        }

        ArrayList<Integer> temp = new ArrayList<Integer>();
        if (user1) {                                        // assign entry to player 1
            if (!this.p1.containsKey(x)) this.p1.put(x, new ArrayList<Integer>());
            temp.addAll(this.p1.get(x));    //temp = this.p1.get(x);
            temp.add(y);
            this.p1.put(x, temp);
        }
        if (!user1) {                                       // assign entry to player 2
            if (!this.p1.containsKey(x)) this.p1.put(x, new ArrayList<Integer>());
            temp.addAll(this.p2.get(x));
            temp.add(y);
            this.p2.put(x, temp);
        }
        return true;
    }*/
