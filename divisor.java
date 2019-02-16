import java.io.*;
import java.util.*;
class divisor
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str=new StringTokenizer(br.readLine());
        int l=Integer.parseInt(str.nextToken());
        int r=Integer.parseInt(str.nextToken());
        int k=Integer.parseInt(str.nextToken());
        int count=0;
        if((1<=l)&&(1<=r)&&(l<=r)&&(l<=1000)&&(r<=1000)&&(1<=k)&&(k<=1000))
        {
            int a=l/k;
            if(l%k==0)a--;
            int b=r/k;
            System.out.println(b-a);    
        }
            
    }
}