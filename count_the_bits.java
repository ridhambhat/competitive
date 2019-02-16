import java.io.*;
import java.util.*;
class count_the_bits
{
    public static void main(String args[])throws IOException
    {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine())
        {
        long t=(long)sc.nextLong();
        if((0<=t)&&(t<=Math.pow(10,18)))
        {
                int num=number(t);
                int count=0;
                {
                    for(int j=0;j<num;j++)
                    {
                        if(0!=(t&(1<<j)))
                        {
                            count++;
                        }
                    }
                }
                System.out.println(count);
            
        }
        }
    }
    
    public static int number(long r)
    {
        int count=1;
        if(r>1)
        {
            count=(int)(Math.log(r)/Math.log(2))+1;
        }
        return count;
    }
}