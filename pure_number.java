import java.io.*;
import java.util.*;
class pure_number
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine());
        while(test>0)
        {
            String ans="";
            long n=Integer.parseInt(br.readLine());
            if(n==1)ans="44";
            else
            {
            long s=(long)((Math.log(n+2)/Math.log(2))-1);
            n=n-(long)(2*(Math.pow(2,(s-1))-1));
            int count=0;
            String jj="";
            for(int i=1;i<=s;i++)
            {
                jj=jj+"4";
            }
            long i=Long.parseLong(jj);
            while(count<n)
            {
                long k=i;
                long size=0;
                long rev=0;
                boolean check=true;
                while((k>0)&&check)
                {
                    int rem=(int)(k%10);
                    if((rem==4)||(rem==5))
                    {rev=rev*10+rem;
                    k=k/10;
                    size++;}
                    else
                    check=false;
                }
                if(check)
                {
                    count++;
                    ans=Long.toString(i)+Long.toString(rev);
                }
                i++;
            }
        }
            System.out.println(ans);
            test--;      
        }
    }
    
    
}