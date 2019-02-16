import java.io.*;
import java.util.*;
class best_index
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int arr[]=new int[n];
        StringTokenizer str=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
        {
            arr[i]=Integer.parseInt(str.nextToken());
        }
        long maxsum=0;
        for(int i=0;i<n;i++)
        {
            long sum=0;
            int count=1;
            int r=n-i;
            int times=(int)(((Math.sqrt(1+(8*r)))-1)/2);
            int j=(int)(times*(times+1)/2);
            for(int k=i;k<i+j;k++)
            {
                sum+=arr[k];
            }
            if(sum>maxsum)maxsum=sum;
        }
        System.out.println(maxsum);
    }
}
