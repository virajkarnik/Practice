/**
 * Created by viraj on 4/4/2017.
 */
public class MinimalTree {

    class Node {
        Node left, right; int data;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}; // length = 12
        MinimalTree mintree = new MinimalTree();
        mintree.binMinTree(arr);
    }

    void binMinTree(int[] arr) {
        Node head = new Node();
        //head.data = arr[arr.length/2];
        head = binMinTree(head, arr, 0, arr.length-1);
    }

    Node binMinTree(Node n, int[] arr, int start, int end) {
        System.out.println(start +" "+end);
        if (start > end) return null;
        if (start == end) {
            n.data = arr[start];
            return n;
        }
        int mid = (int)Math.floor(start+end)/2;
        System.out.println(mid);
        System.out.println(n.data);
        n.data = arr[mid];
        n.left = binMinTree(n.left, arr, start, mid-1);
        n.right = binMinTree(n.right, arr, mid+1, end);

        return n;
    }
}
