import java.io.*;
class power
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int x=Integer.parseInt(br.readLine());
        int y=Integer.parseInt(br.readLine());
        System.out.println(pow(x,y));
    }
    
    public static int pow(int a, int b)
    {
        if(b==1)
        return a;
        
        if(b%2==1)
        return(a*pow(a,b-1));

        if(b%2==0)
        return(pow((a*a),(b/2)));
        
        return 1;
    }
}