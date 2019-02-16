import java.io.*;
import java.util.*;
class two_strings
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++)
        {
            StringTokenizer str=new StringTokenizer(br.readLine());
            String a=str.nextToken().toUpperCase();
            String b=str.nextToken().toUpperCase();
            int ac[]=new int[26];
            int bc[]=new int[26];
            for(int j=0;j<26;j++)
            {
                ac[j]=0;
                bc[j]=0;
            }
            for(int j=0;j<a.length();j++)
            {
                ac[(((int)a.charAt(j))-65)]++;   
                bc[(((int)b.charAt(j))-65)]++; 
            }
            boolean y=true;
            for(int j=0;j<26;j++)
            {
                if(ac[j]!=bc[j])y=false;
            }
            if(y)
            System.out.println("YES");
            else
            System.out.println("NO");
        }
    }
}