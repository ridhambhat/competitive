import java.io.*;
import java.util.*;
class ShareChat
{
    static int A[];
    static boolean flag;
    static int N,Q;
    
    public static void main(String args[])throws IOException
    {
        Scanner in=new Scanner(System.in);
        flag=true;
        String a=in.next();
        StringTokenizer line1=new StringTokenizer(a);
        N=Integer.parseInt(line1.nextToken());
        Q=Integer.parseInt(line1.nextToken());
        if((1<=N)&&(1<=Q)&&(N<=100000)&&(Q<=100000)){}
        else flag=false;
        String A[]=new String[N+1];
        A[0]=null;
        for(int i=1;i<=N;i++)
        {
            
        }
        

    }
    
    public static void query(String a)
    {
        StringTokenizer query=new StringTokenizer(a);
        int L=Integer.parseInt(query.nextToken());
        int R=Integer.parseInt(query.nextToken());
        String X=query.nextToken();
        if((1<=L)&&(L<=R)&&(R<=N))
        {
            
        }
        else
        {
            flag=false;
        }
    }
}