import java.io.*;
import java.util.*;
class special_shop
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        long test=Integer.parseInt(br.readLine());
        if((1<=test)&&(test<=100000))
        for(int yy=0;yy<test;yy++)
        {
            StringTokenizer str=new StringTokenizer(br.readLine());
            long n=Long.parseLong(str.nextToken());
            long a=Long.parseLong(str.nextToken());
            long b=Long.parseLong(str.nextToken());
            if((1<=a)&&(1<=b)&&(1<=n)&&(a<=100000)&&(b<=100000)&&(n<=100000))
            {
                double y=((double)b*(double)n)/((double)a+(double)b);
                y=y+0.5;
                long x=(long)y;
                System.out.println((a*x*x)+(b*(n-x)*(n-x)));
            }
        }
    }
}