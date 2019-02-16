import java.io.*;
import java.util.*;
class rect_sq
{
    static int l,b,min;
    static long area,count,arr[][];
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the length and breadth seperated by a space");
        StringTokenizer str=new StringTokenizer(br.readLine());
        l=Integer.parseInt(str.nextToken());
        b=Integer.parseInt(str.nextToken());
        if(l<b)
        {
            l=l+b;
            b=l-b;
            l=l-b;
        }
        arr=new long[l][b];
        for(int k=b;k>=1;k--)
        {
            for(int i=0;i<l;i++)
            {
                for(int j=0;j<b;j++)
                {
                    arr[i][j]=1;
                }
            }
            square_start(k);
        }
        System.out.println(min);
        
    }
    public static void square_start(int n)
    {
        int count=0;
        boolean k=true;
        for(int t=n;(t>=1)&&k;t--)
        {    
            boolean find;
            for(int i=0;(i<=l-t)&&k;i++)
            {
                for(int j=0;(j<=b-t)&&k;j++)
                {
                    find=square_check(i,j,t);
                    if(find)
                    {
                        for(int x=i;(x<i+t);x++)
                        {
                            for(int y=j;(y<j+t);y++)
                            {
                                arr[x][y]=-1;
                            }
                        }
                        count++;
                        if((n<b)&&(count>min))
                        {
                           // k=false;
                        }
                    }
                    else
                    continue;
                }
            }
        }
        System.out.println(count);
        /*if(n==b)
        min=count;
        else
        {
            if(count<min)
            min=count;
        }
        */
    }  
    public static boolean square_check(int i,int j,int n)
    {
        boolean yes=true;
        for(int x=i;(x<i+n)&&yes;x++)
        {
            for(int y=j;(y<j+n)&&yes;y++)
            {
                if(arr[x][y]==1)
                continue;
                else
                {
                    yes=false;
                }
            }
        }
        return yes;
    }
}

