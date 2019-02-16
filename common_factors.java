import java.io.*;
import java.util.*;
class common_factors
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str=new StringTokenizer(br.readLine());
        long a=Long.parseLong(str.nextToken());
        long b=Long.parseLong(str.nextToken());
        if(a>b)
        {
            a=a+b;
            b=a-b;
            a=a-b;
        }
        if((a>=1)&&(a<=(Math.pow(10,12)))&&(b>=1)&&(b<=(Math.pow(10,12))))
        {
        int count=0;
        long r=0;
        while((r=(b%a))!=0)
        {
            b=a;
            a=r;
        }
        for (int i=1; i<=Math.sqrt(a); i++)
        {
            if (a%i==0)
                {
                    if (a/i == i)
                    count += 1;
                    else
                    count += 2;
                }
        }
        System.out.println(count);
        }
    }
    
}