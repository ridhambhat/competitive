import java.io.*;
import java.util.*;
class profile_picture
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int l=Integer.parseInt(br.readLine());
        int n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++)
        {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            
            if((a<l)||(b<l))
            {
                System.out.println("UPLOAD ANOTHER");
            }
            else
            {
                if(a==b)
                {
                    System.out.println("ACCEPTED");
                }
                else
                {
                    System.out.println("CROP IT");
                }
            }
        }
        
    }
}