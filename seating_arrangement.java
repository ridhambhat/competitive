import java.io.*;
import java.util.*;
class seating_arrangement
{
    public static void main(String args[])throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int n[]=new int[T];
        if((T>=1)&&(T<=100000))
        {
            for(int i=0;i<T;i++)
            {
                n[i]=sc.nextInt();
                if((1<=n[i])&&(n[i]<=108))
                {
                    int r=n[i]%12;
                    if(r==0)r=12;
                    int q=((int)((n[i]-1)/12))*12+(13-r);
                    System.out.print(q+" ");
                    if((r==1)||(r==6)||(r==7)||(r==12))
                    {
                        System.out.println("WS");
                    }
                    if((r==2)||(r==5)||(r==8)||(r==11))
                    {
                        System.out.println("MS");
                    }
                    if((r==3)||(r==4)||(r==9)||(r==10))
                    {
                        System.out.println("AS");
                    }
                }
                else
                {
                    System.out.println();
                }
            }
        }
    }
}