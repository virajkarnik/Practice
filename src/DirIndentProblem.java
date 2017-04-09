import java.util.Stack;

/**
 * Created by viraj on 1/9/2017.
 */
public class DirIndentProblem {
    public static void main(String[] args) {
        String S = "dir1\n dir1a\n  test1.gif\n dir1b\n  pic1.tif\n  dir1b1\n  test2.gif\ndir2\n pic2.tif";
        String[] A = S.split("\n");

        class Path {
            String D;
            int len;
            Path(String D, int len) {
                this.D = D;
                this.len = len;
            }
        }
        Stack<Path> stkDir = new Stack<Path>();

        int whitespaces = 0;
        //int len =0, maxLen = Integer.MIN_VALUE;
        stkDir.push(new Path(A[0], A[0].length()+1));
        int len = A[0].length()+1;
        boolean isRootDir = true;
        int maxLen = Integer.MIN_VALUE, res = 0;
        for(String V: A) {
            if(isRootDir) {
                isRootDir = false;
                continue;
            }
            if(isDir(V)) {
                if(whiteSpace(V)>whitespaces) {
                    whitespaces = whiteSpace(V);
                    stkDir.push(new Path(V,V.length() + 1 - whiteSpace(V)));
                    len += V.length() + 1 - whiteSpace(V);
                }
                else if(whiteSpace(V)==whitespaces) {
                    len -= stkDir.pop().len;
                    stkDir.push(new Path(V,V.length()+1-whiteSpace(V)));
                    len += V.length() + 1 - whiteSpace(V);
                }
                else {
                    while(whitespaces!=whiteSpace(V)) {
                        whitespaces--;
                        len -= stkDir.pop().len;
                    }
                }
            }
            else {
                if(whiteSpace(V)==whitespaces) {
                    len -= stkDir.pop().len;
                }
                if(maxLen < len+V.length()+1) {
                    maxLen = len+V.length()+1;
                    res = len;
                }
            }
        }
        System.out.println("\n"+res);
    }
    static int whiteSpace(String A) {
        int i=0;
        while(A.charAt(i)==' ')
            i++;
        return i;
    }
    static boolean isDir(String A) {
        if(A.contains("."))
            return false;
        else
            return true;
    }
}
