package factorialsp;

import java.util.*;
import java.math.*;

public class Factorialsp{
    public static BigInteger factorial(int n)
    {
        BigInteger x = new BigInteger("1");
        for(int i =1; i<=n; i++)
        {
            x= x.multiply(BigInteger.valueOf(i));
        }
        return x;
    }
    public static BigInteger stepen(BigInteger x, int m)
    {
        for(int i = 1; i<m; i++)
        {
            x = x.multiply(x);
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int r,j;
        BigInteger k  = new BigInteger("0");
        BigInteger l, c;
        int n,m;
        n = s.nextInt();
        m = s.nextInt();
        for(int i = 0; i<=n; i++)
        {
            l = factorial(i);
            c = stepen(l,m);
            k =k.add(c);
        }
        String res = (k).toString();
        r = res.length();
        for(j = r-1; j>=0; j--)
        {
            if(res.charAt(j) != '0')
            {
                break;
            }   
        }
        System.out.println(res.charAt(j));
    }
}
