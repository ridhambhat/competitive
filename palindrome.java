import java.io.*;
import java.util.*;
class palindrome
{
    public static void main(String args[])throws IOException
    {
        Scanner sc=new Scanner(System.in);
        String check=sc.next();
        int len=check.length();
        int ch=(int)(len/2);
        boolean y=true;
        for(int i=0;i<ch;i++)
        {
            if((check.charAt(i))!=(check.charAt(len-1-i)))
            {
                y=false;
                break;
            }
        }
        if(y)
        System.out.println("YES");
        else
        System.out.println("NO");
    }
}