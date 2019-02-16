import java.io.*;
import java.util.*;
class pure_number_V2
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
                ans="";
                long s=(long)((Math.log(n+2)/Math.log(2))-1);
                if(n==((long)(2*(Math.pow(2,s)-1))))s--;
                n=n-(long)(2*(Math.pow(2,s)-1));
                long count=0;
                long size=s+1;
                while((n>0)&&(count<size))
                {
                    if(n%2==1)
                    {
                        ans="4"+ans;
                        n=(int)(n/2)+1;
                        count++;
                    }
                    else
                    {
                        ans="5"+ans;
                        n=n/2;
                        count++;
                    }
                }

                String rev="";
                int len=ans.length();
                for(int i=len-1;i>=0;i--)
                {
                  ans=ans+ans.charAt(i);
                }

            }
            System.out.println(ans);
            test--; 
            
        }
    }
}
    
    
