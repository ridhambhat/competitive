import java.io.*;
import java.util.*;
class micro_arr
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int ss=0;
        for(int i=0;i<n;i++)
        {
            StringTokenizer abc=new StringTokenizer(br.readLine());
            int no=Integer.parseInt(abc.nextToken());
            int k=Integer.parseInt(abc.nextToken());
            if(no>=1)
            {
                StringTokenizer str=new StringTokenizer(br.readLine());
                int min=Integer.parseInt(str.nextToken());
            for(int j=1;j<no;j++)
            {
                if(min>(ss=Integer.parseInt(str.nextToken())))
                {
                    min=ss;
                }
            }
            if((k-min)>=0)System.out.println(k-min);
            else System.out.println("0");
            }
        }
    }
}