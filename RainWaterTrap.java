import java.util.*;

public class RainWaterTrap
{
    public  int waterTrapped(int []a, int n)
    {
        int l = 0, r = n - 1, res =0;
        int r_max = 0, l_max = 0;

        while(l <= r)
        {
            if(a[l] <= a[r])
            {
                if(a[l] >= l_max)
                {
                    l_max = a[l];
                }
                else
                {
                    res = res + l_max - a[l];
                }
                l++;
            }
            else
            {
                if(a[r] >= r_max)
                {
                    r_max = a[r];
                }
                else
                {
                    res = res + r_max - a[r];
                }
                r--;
            }
        }
        return res;
    }
    public static void main(String[] args) 
    {
        int []a = new int [12];
        Scanner ip = new Scanner(System.in);
        RainWaterTrap r = new RainWaterTrap();
        for(int i = 0; i < 12; i++) 
        {
            a[i] = ip.nextInt();
        }
        int x = r.waterTrapped(a, 12);
        System.out.println(x);
        ip.close();
    }
}