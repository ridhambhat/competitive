import java.io.*;
class its_confedential
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        for(int test=0;test<n;test++)
        {
            int len=Integer.parseInt(br.readLine());
            String r=br.readLine();
            System.out.println(decode(r,len));
        }
    }
    
    public static String decode(String str,int len)
    {
        if(len==0)
        {
            return "";
        }
        if(len%2!=0)
        {
            int mid=len/2;
            String m=""+str.charAt(mid);
            String l=str.substring(0,mid);
            String r=str.substring(mid+1);
            return m+decode(l,l.length())+decode(r,r.length());
        }
        else
        {
            int mid=len/2-1;
            String m=""+str.charAt(mid);
            String l=str.substring(0,mid);
            String r=str.substring(mid+1);
            return m+decode(l,l.length())+decode(r,r.length());
        }
    }
}