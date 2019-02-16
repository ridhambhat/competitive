import java.io.*;
import java.util.*;
class flip_game
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        if((1<=n)&(n<=100000))
        {
            String bin[]=new String[n];
            int maxlen=0;
            for(int i=0;i<n;i++)
            {
                bin[i]=br.readLine();
                int k=bin[i].length();
                if(k>maxlen)
                maxlen=k;
            }
            int arr[]=new int[maxlen];
            for(int i=0;i<maxlen;i++)
            {
                arr[i]=0;
            }
            for(int i=0;i<n;i++)
            {
                int t=bin[i].length();
                int r=0;
                while(r<t)
                {
                    if((((int)(bin[i].charAt(r)))-48)==1)
                    arr[r]++;
                    r++;
                }
            }
            int count=0;
            for(int i=0;i<maxlen;i++)
            {
                if(arr[i]>0)count++;
            }
            if(count%2==0)System.out.println("B");
            else System.out.println("A");
            System.out.println(count);
        }
    }
}