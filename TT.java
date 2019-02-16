import java.io.*;
import java.util.*;
class TT
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine());
        while(test>0){
        StringTokenizer data=new StringTokenizer(br.readLine());
        int points=Integer.parseInt(data.nextToken())+Integer.parseInt(data.nextToken());
        int dec=(int)((double)points/Double.parseDouble(data.nextToken()));
        if(dec%2==0)System.out.println("PRINCE");
        else System.out.println("NAMIT");
        test--;
    }
    }
}