import java.io.*;
import java.util.*;
class monk_prob
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine());
        if((1<=test)&&(test<=10))
        {
            for(int ruru=0;ruru<test;ruru++){
            int n=Integer.parseInt(br.readLine());
            long max_prob=0;
            if((2<=n)&&(n<=10000))
            {
                int arr[]=new int[n];
                int c=0;
                int max=0;
                while(n>c)
                {
                    int k=Integer.parseInt(br.readLine());
                    if((0<=k)&&(k<=2147483647))
                    {
                        arr[c]=k;
                        if(c==0)
                        {
                            max=k;
                        }
                        else
                        {
                            if(k>max)
                            {
                                max=k;
                            }
                        }
                        c++;
                    }
                    else
                    n--;
                }
                    int max_bit=number(max);
                    int bitarr[]=new int[max_bit];
                    for(int zz=0;zz<max_bit;zz++)
                    {
                        bitarr[zz]=0;
                    }
                    for(int i=0;i<n;i++)
                    {
                        int pp=number(arr[i]);
                        int kk=0;
                        while(pp>kk)
                        {
                            int r=(arr[i]&(1<<kk));
                            if(r>0)
                            {
                            bitarr[kk]++;}
                            kk++;
                        }
                    }
                    int max_value=0;
                    max_prob=0;
                    for(int tt=0;tt<max_bit;tt++)
                    {
                        if(tt==0)
                        {
                            max_prob=0;
                            max_value=bitarr[0];
                        }
                        else
                        {
                            if(max_value<bitarr[tt])
                            {
                                max_value=bitarr[tt];
                                max_prob=tt;
                            }
                        }
                    }
                }
                System.out.println(max_prob);
            }
        }
    }
    
    
    public static int number(int r)
    {
        int count=1;
        if(r>1)
        {
            count=(int)(Math.log(r)/Math.log(2))+1;
        }
        return count;
    }
}