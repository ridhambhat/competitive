import java.io.*;
import java.util.*;
class XOR
{
    public static void main()
    {
        Scanner sc=new Scanner(System.in);
        XOR obj=new XOR();
        String x="",y="";
        System.out.println("Enter the two numbers");
        int a=sc.nextInt();
        x=obj.binary(a);
        int b=sc.nextInt();
        y=obj.binary(b);
        int xlen=x.length();
        int ylen=y.length();
        if(xlen<ylen)
        {
            String t=x;
            x=y;
            y=t;
            xlen=xlen+ylen;
            ylen=xlen-ylen;
            xlen=xlen-ylen;
        }
        int diff=xlen-ylen;
        String xor="";
        String tt="";
        for(int i=ylen-1;i>=0;i--)
        {
            char ch=y.charAt(i);
            char ch1=x.charAt(i+diff);
            if(ch==ch1)
            {
                tt="0"+tt;
            }
            else
            { 
                xor=tt+xor;
                tt="";
                xor="1"+xor;
            }
        }
        if(diff>0)
        {
            xor=tt+xor;
        }
        
        xor=x.substring(0,diff)+xor;
        int xorr=0;
        int xorlen=xor.length();
        for(int i=0;i<xorlen;i++)
        {
            char ch=xor.charAt(i);
            int no=(int)ch-48;
            xorr=(int)(no*Math.pow(2,(xorlen-1-i)))+ xorr;
        }
        System.out.println("XOR is : "+xorr);
        System.out.println("Its binary is : "+xor);
        
    }
    
    public String binary(int r)
    {
        String m="";
        while(r!=1)
        {
            char ch=(char)((r%2)+48);
            m=ch+m;
            r=r/2;
        }
        m="1"+m;
        System.out.println("Its binary is : "+m);
        return m;    
    }
}
        