import java.io.*;
import java.util.*;
import java.math.BigInteger;
class special_shopv2
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        long test=Integer.parseInt(br.readLine());
        if((1<=test)&&(test<=100000))
        for(int yy=0;yy<test;yy++)
        {
            StringTokenizer str=new StringTokenizer(br.readLine());
            BigInteger n=new BigInteger(str.nextToken());
            BigInteger a=new BigInteger(str.nextToken());
            BigInteger b=new BigInteger(str.nextToken());
            if((a.compareTo(BigInteger.valueOf(1))>=0)&&(b.compareTo(BigInteger.valueOf(1))>=0)&&(n.compareTo(BigInteger.valueOf(1))>=0)&&((a.compareTo(BigInteger.valueOf(100000))<=0))&&(b.compareTo(BigInteger.valueOf(100000))<=0)&&(n.compareTo(BigInteger.valueOf(100000))<=0))
            {
                
                if(a.compareTo(b)<0)
                {
                    BigInteger rr=new BigInteger("1");
                    rr=a;
                    a=b;
                    b=rr;
                }
                BigInteger minimum=new BigInteger("1");
                for(int i=0;n.compareTo(BigInteger.valueOf(i))>=0;i++)
                {
                    BigInteger kk=new BigInteger("1");
                    BigInteger temp=new BigInteger("1");
                    kk=n.subtract(BigInteger.valueOf(i));
                    temp=(a.multiply(BigInteger.valueOf(i*i))).add(b.multiply((kk.multiply(kk))));
                    if(i==0)
                    minimum=temp;
                    else
                    {
                        if(temp.compareTo(minimum)<0)
                        minimum=temp;
                        else break;
                    }
                }
                System.out.println(minimum);
            }
            else continue;
        }
    }
}