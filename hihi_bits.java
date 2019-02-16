import java.io.*;
import java.util.*;
class hihi_bits
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        long test=Long.parseLong(br.readLine());
        if((1<=test)&&(test<=1000000))
        {
            while(test-->0)
            {
                long n=Long.parseLong(br.readLine());
                if((1<=n)&&(n<=(Math.pow(10,18))))
                {
                    long bits=number(n);
                    long m=bits;
                    boolean flag=true;
                    while((bits>=0)&&flag)
                    {
                        int r=(int)(n&(1<<(m-bits)));
                        if(r==0)
                        {
                            flag=false;
                            n=n^(1<<(m-bits));
                        }
                        bits--;
                    }
                    System.out.println(n);
                }
            }
        }
    }
    
    public static long number(long r)
    {
        long count=1;
        if(r>1)
        {
            count=(long)(Math.log(r)/Math.log(2))+1;
        }
        return count;
    }
}