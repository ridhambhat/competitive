import java.io.*;
import java.util.*;
class number_love
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine());
        if((1<=test)&&(test<=1000000))
        {
            while(test>0)
            {
                StringTokenizer lr=new StringTokenizer(br.readLine());
                int l=Integer.parseInt(lr.nextToken());
                int r=Integer.parseInt(lr.nextToken());
                if((1<=l)&&(1<=r)&&(l<=1000000)&&(r<=1000000))
                {
                    if(l>r)
                    {
                        int temp=l;
                        l=r;
                        r=temp;
                    }
                    int count=0;
                    if(l==2)count++;
                    if((l%2==0))  l=l+1;
                    for(int i=l;i<=r;i=i+2)
                    {
                        if(prime(i))count++;
                    }
                    System.out.println(count);
                }
                test--;
            }
        }
    }
    
    public static boolean prime(int n)
    {
        if(n<2)return false;
        for(int j=2;j<=(int)Math.sqrt(n);j++)
        {
            if(n%j==0)return false;
        }
        return true;
    }
    
    
}