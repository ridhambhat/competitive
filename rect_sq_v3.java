import java.io.*;
import java.util.*;
class rect_sq_v3
{
    static int l,b;
    static long area,count,arr[][],min;
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
        int k=gcd(b,l);
        l=(int)(l/k);
        b=(int)(b/k);
        arr=new long[l][b];
        for(int i=0;i<l;i++)
        {
            for(int j=0;j<b;j++)
            {
                arr[i][j]=1;
            }
        }
        min=l*l;
        calc();
        System.out.println(min);
    }
    
    public static void calc()
    {
        int t=b;
        boolean rst=true,mn,zs=false;
        int rec=0;
        int lasti=0,lastj=0,lastt=0;
        while((t>0)&&(count<min))
        {
            mn=true;
            zs=false;
            for(int i=0;(i<=l-t)&&(mn);i++)
            {
                for(int j=0;(j<=b-t)&&(mn);j++)
                {
                    rst=square_check(i,j,t);
                    if(rst)
                    {
                        count++;
                        mn=false;
                        square_fill(i,j,t);
                        zs=true;
                        lasti=i;
                        lastj=j;
                        lastt=t;
                        boolean check=false;
                        for(int r=0;r<l;r++)
                        {for(int s=0;s<b;s++)
                            {if(arr[r][s]==(1))check=true;}
                        }
                        if(check)
                        {calc();}
                        else 
                        {
                                if(count<min)
                                {
                                    min=count;                                    
                                }
                        }
                        
                    }
                    
                }
            }
            if(zs)
            {square_unfill(lasti,lastj,lastt);
            count--;}
            t--;
        }
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
    
    public static void square_fill(int i,int j,int t)
    {
        for(int r=i;r<i+t;r++)
        {
            for(int s=j;s<j+t;s++)
            {
                arr[r][s]=-1;
            }
        }
    }
    
    public static void square_unfill(int i,int j,int t)
    {
        for(int r=i;r<i+t;r++)
        {
            for(int s=j;s<j+t;s++)
            {
                arr[r][s]=1;
            }
        }
    }
    
    public static int gcd(int a,int b)
    {
        int rem=0;
        while((rem=b%a)!=0)
        {
            b=a;
            a=rem;
        }
        return a;
    }
}