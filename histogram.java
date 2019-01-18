import java.util.Stack;

public class histogram {
    static int maxArea(int []hist, int len) {
        Stack<Integer>s = new Stack<>();
        int max_area = 0, area = 0, top =0, i = 0;
        while(i < len) {
            if(s.empty() || hist[s.peek()] <= hist[i]){
                s.push(i++);
            }
            else {
                top = s.peek();
                s.pop();

                area = hist[top] * (s.empty() ? i : i-s.peek()-1);
                max_area = Math.max(area, max_area); 
            }
        }
        while(s.empty() == false) {
            top = s.peek();
            s.pop();

            area = hist[top] * (s.empty() ? i : i-s.peek()-1);
            max_area = Math.max(area, max_area);
         }
         return max_area;
    }
    public static void main(String[] args) {
        int []hist = new int[]{6, 2, 5, 4, 5, 1, 6};
        System.out.println(maxArea(hist, hist.length));
    }
}