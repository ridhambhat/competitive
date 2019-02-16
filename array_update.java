import java.io.*;
import java.util.*;
class array_update
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int t=n;
        StringTokenizer str=new StringTokenizer(br.readLine());
        long sum=0;
        while(t-->0)
        {
            sum+=Integer.parseInt(str.nextToken());
        }
        System.out.println((sum/n)+1);
    }
}