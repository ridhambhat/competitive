import java.io.*;
class reverse_string
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++)
        {
            String str=br.readLine();
            String arr[]=str.split(" ");
            int len=arr.length;
            for(int j=0;j<=((int)(len/2)-1);j++)
            {
                String temp=arr[j];
                arr[j]=arr[len-1-j];
                arr[len-1-j]=temp;
            }
            for(int j=0;j<len;j++)
            {
                System.out.print(arr[j]+" ");
            }
            System.out.println();
        }
    }
}