import java.util.*;
import java.io.*;
class prime{
    
    public static void main(String args[])throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n>1)
        for(int i=2;i<=n;i++)
        {
            prime(i);
        }
    }
    
    public static void prime(int n)
    {
        int z=(int)Math.sqrt(n);
        int count=0;
        for(int i=2;i<=z;i++)
        {
            if(n%i==0)
            {
                count++;
                break;
            }
        }
        if(count==0)
        System.out.print(n+" ");
    }
    
}