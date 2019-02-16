import java.io.*;
class fact10
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int fact=1;
        if((n>=1)&&(n<=10))
        {
            for(int i=1;i<=n;i++)
            {
                fact*=i;
            }
        }
        else
        fact=0;
        System.out.println(fact);
    }
}