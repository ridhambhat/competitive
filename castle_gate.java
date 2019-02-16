import java.io.*;
import java.util.*;
class castle_gate
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test= Integer.parseInt(br.readLine());
        if((1<=test)&&(test<=100))
        {
            while(test>0)
            {
                long count=0;
                int n=Integer.parseInt(br.readLine());
                for(int i=1;i<n;i++)
                {
                    for(int j=i+1;j<=n;j++)
                    {
                        if((i^j)<=n)count++;
                    }
                }
                System.out.println(count);
                test--;
            }
        }
    }
}