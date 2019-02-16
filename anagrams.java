import java.io.*;
import java.util.*;
class anagrams
{
    public static void main(String args[])throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            String a=sc.next();
            a=a.toUpperCase();
            String b=sc.next();
            b=b.toUpperCase();
            int lena=a.length();
            int lenb=b.length();
            if((lena<=10000)&&(lenb<=10000))
            {
                int dis=0;
                
                for(int j=65;j<=90;j++)    
                {
                    int ca=0,cb=0;
                    for(int r=0;r<lena;r++)
                    {
                        if(((int)a.charAt(r))==j)
                        ca++;
                    }
                    for(int r=0;r<lenb;r++)
                    {
                        if(((int)b.charAt(r))==j)
                        cb++;
                    }
                    if(ca>=cb)
                    dis=dis+(ca-cb);
                    else
                    dis=dis+(cb-ca);
                }
                System.out.println(dis);
            }
        }
    }
}
    
