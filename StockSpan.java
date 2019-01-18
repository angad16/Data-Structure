import java.util.Stack;

public class StockSpan{
    static void findSpan(int span[], int len, int res[]) {
        Stack<Integer>s = new Stack<>();
        s.push(0);
        res[0] = 1;
        for(int i = 1; i < len; i++) {
            while(!s.empty() && span[s.peek()] <= span[i]) {
                s.pop();
            }

            res[i] = s.empty() ? i + 1 : i - s.peek();

            s.push(i);
        }

    }
    public static void main(String[] args) {
        int span[] = new int[]{10, 4, 5, 90, 120, 80};
        int len = span.length;
        int res[] = new int[len];
        findSpan(span, len, res);
        for(int i = 0; i < len; i++){
            System.out.println(res[i] + " ");
        }
    }
}