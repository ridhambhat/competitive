import java.io.*;
class char_sum
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        int sum=0;
        if((s.length()>=0)&&(s.length()<1000))
        {
            for(int i=0;i<s.length();i++)
            {
                sum+=(int)(s.charAt(i))-96;                
            }
        }
        System.out.println(sum);
    }
    
}