import java.io.*;
import java.util.*;
class one_and_double
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine());
        while(test>0&&(1<=test)&&(test<=100))
        {
        long t=Long.parseLong(br.readLine());
        if((1<=t)&&(t<=Math.pow(10,9)))
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
        test--;
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