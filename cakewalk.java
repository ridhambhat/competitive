import java.io.*;
import java.util.*;
class cakewalk
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine());
        if((test>=1)&&(test<=100))
        {
            while(test>0)
            {
                StringTokenizer nm=new StringTokenizer(br.readLine());
                int n=Integer.parseInt(nm.nextToken());
                int m=Integer.parseInt(nm.nextToken());
                if((10<=n)&&(m<=100)&&((n*m)>=100))
                {
                    int count=0;
                    for(int i=0;i<n;i++)
                    {
                        StringTokenizer line=new StringTokenizer(br.readLine());
                        for(int j=0;j<m;j++)
                        {
                            int r=Integer.parseInt(line.nextToken());
                            if(r<=30)count++;
                        }
                    }
                    if(count>=60)System.out.println("yes");
                    else System.out.println("no");
                }
                test--;
            }
        }
    }
}