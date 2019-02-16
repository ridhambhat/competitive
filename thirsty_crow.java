import java.io.*;
import java.util.*;
class thirsty_crow
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine());
        if((1<=test)&&(test<=10))
        {
            while(test>0)
            {
                    StringTokenizer data=new StringTokenizer(br.readLine());
                    int area=Integer.parseInt(data.nextToken())*Integer.parseInt(data.nextToken());
                    int height=Integer.parseInt(data.nextToken());
                    int v=Integer.parseInt(data.nextToken());
                    //double rem=(double)height-((double)v/(double)area);
                    int rem=height-v;
                    int n=Integer.parseInt(br.readLine());
                    int arr[]=new int[n];
                    StringTokenizer arra=new StringTokenizer(br.readLine());
                    for(int i=0;i<n;i++)
                    {
                        arr[i]=Integer.parseInt(arra.nextToken());
                    }
                    for(int i=0;i<n-1;i++)
                    {
                        int max=i;
                        for(int j=i+1;j<n;j++)
                        {
                            if(arr[max]<arr[j])
                            {
                                max=j;
                            }
                            int temp=arr[i];
                            arr[i]=arr[max];
                            arr[max]=temp;
                        }
                    }
                    int count=0;
                    while(rem>0.0)
                    {
                        rem=rem-arr[count];
                        count++;
                    }
                    System.out.println(count);
                    test--; 
            }    
        }
    }
}