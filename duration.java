import java.io.*;
import java.util.*;
class duration
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++)
        {
            String str=br.readLine();
            StringTokenizer st=new StringTokenizer(str);
            int sh=Integer.parseInt(st.nextToken());
            int sm=Integer.parseInt(st.nextToken());
            int eh=Integer.parseInt(st.nextToken());
            int em=Integer.parseInt(st.nextToken());
            int hh=eh-sh;
            int mm=em-sm;
            if(mm<0)
            {
                hh--;
                mm+=60;
            }
            System.out.println(hh+" "+mm);
        }
    }
}