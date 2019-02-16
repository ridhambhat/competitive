import java.io.*;
import java.util.*;
class binary_strng
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine());
        if((1<=test)&&(test<=100))
        {
            while(test>0)
            {
                int len=Integer.parseInt(br.readLine());
                String str=br.readLine();
                int count=0;
                if((1<=len)&&(len<=100000))
                {
                    for(int i=0;i<len;i++)
                    if(((int)(str.charAt(i)))==48)count++;
                    System.out.println(count);
                }
                test--;
            }
        }
    }
    
   
}