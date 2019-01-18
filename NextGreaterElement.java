import java.util.Stack;

public class NextGreaterElement {
    static void printGreaterElement(int []a, int len, int []res) {
        Stack<Integer>s = new Stack<>();
        s.push(a[0]);
        int k = 0;
        for(int i = 1; i < len; i++) {
            while(!s.empty() && a[i] > s.peek()) {
                res[k++] = a[i];
                s.pop();
            }
            s.push(a[i]);
        }
        while(!s.empty()) {
            res[k++] = -1;
            s.pop();
        }
        for(int i = 0; i < len; i++) {
            System.out.println(res[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int []a = new int[]{11, 13, 21, 3};
        int []res = new int[a.length];
        printGreaterElement(a, a.length, res);

        int []b = new int[]{9, 7, 5, 3};
        int []res1 = new int[b.length];
        printGreaterElement(b, b.length, res1);

    }
}