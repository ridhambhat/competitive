import java.io.*;
import java.util.*;
class compress_string
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine());
        while(test>0)
        {
            int len=Integer.parseInt(br.readLine());
            String str=br.readLine();
            str=str.toLowerCase();
            String p=(""+(str.charAt(0))).toUpperCase();
            str=p+str.substring(1);
            String ans="";
            if(len>=1)
            {
                int j=1;
                ans=ans+(str.charAt(0));
                ans=ans.toUpperCase();
                int count=0;
                while(len>j)
                {
                    char ch=str.charAt(j);
                    if((ch=='a')||(ch=='e')||(ch=='i')||(ch=='o')||(ch=='u'))
                    {
                        if(count>0)
                        ans=ans+Integer.toString(count)+ch;
                        else
                        {
                            if(str.charAt(j-1)!=ch)
                            ans=ans+ch;
                        }
                        count=0;
                    }
                    else
                    {
                        count++;
                    }
                    j++;
                }
                if(count>0)
                ans=ans+Integer.toString(count);
            }
            System.out.println(ans);
            test--;
        }
    }
}