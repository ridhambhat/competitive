import java.io.*;
import java.util.*;
class rect_sq_v4
{
    static int l,b,hc;
    static long area,count,arra[][],min;
    static boolean master;
    static int arr[][];
    static int memo,sum=0;
    static int sml,prod,var=0,mdig=0;
    
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the length and breadth seperated by a space");
        StringTokenizer str=new StringTokenizer(br.readLine());
        
        FileWriter fw=new FileWriter("rectangle_tile.txt");
        BufferedWriter bw=new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(bw);
        
        l=Integer.parseInt(str.nextToken());
        b=Integer.parseInt(str.nextToken());
        master=true;
        if(l<b)
        {
            l=l+b;
            b=l-b;
            l=l-b;
        }
        int k=gcd(b,l);
        l=(int)(l/k);
        b=(int)(b/k);
        hc=k;
        arra=new long[l][b];
       
        for(int i=0;i<l;i++)
        {
            for(int j=0;j<b;j++)
            {
                arra[i][j]=0;
            }
        }
        
        int a=l,i;
        arr=new int[2][100];
    
        prod=a*b;
    
        if(a<b)
        sml=a;
        else
        sml=b;
    
        for(i=1;i<=sml;i++)
        {   
            arr[0][i]=0;
            arr[1][i]=i*i;        
        }
       
        memo=0;  
    
        for(i=1;i<=prod;i++)
        {    
            recur(sml,i); 
        }

    }

    public static void print_ans()throws IOException
    {
        FileWriter fw=new FileWriter("rectangle_tile.txt",true);
        BufferedWriter bw=new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(bw);
        
        int digit[]=new int[memo];
        int k=0;
        for(int x=l;x>=1;x--)
        for(int y=0;y<arr[0][x];y++)
        {
            
            digit[k]=x;
            k++;
        }
        
        if(((digit[0]+digit[1])>l)&&(digit.length>=2));
        else
        {
            for(int sd=0;sd<digit.length;sd++)
            {
                pw.print(digit[sd]+" ");
                pw.flush();
            }  
            pw.println();
            pw.flush();
            master=true;
            calc(digit,0);
        }
    }

    public static int recur(int start,int dig)throws IOException
    {  
        memo++;
        for(int i=start;i>=1;i--)
        {  sum+=arr[1][i];
            arr[0][i]++;
    
            if( ((sum+(dig-memo)*arr[1][i])<prod) )
            {
                sum-=arr[1][i];
                arr[0][i]--;
                memo--;
                return -1;
            }
    
            var=sum+(dig-memo);
    
            if(memo<dig) 
            {
                if(  ( var ) <= prod )
                {
                    recur(i,dig);
                }
    
            } 
     
            else if(sum==prod)
            {
                print_ans();
            }     
    
            sum-=arr[1][i];
            arr[0][i]--;  
   
        }        

        memo--;
        return 0;
    }
    
    public static void print_all()
    {
        mdig=mdig*2+1;
        int m=0;
        for(int i=0;i<l*hc;i++)
        {
            m=i/hc;
            for(int j=0;j<b;j++)
            {
                for(int piko=0;piko<hc;piko++)
                {
                    System.out.print(arra[m][j]*hc);
                    long s=arra[m][j]*hc;
                    int dodo=0;
                    while(s>0)
                    {
                        dodo++;
                        s=s/10;
                    }
                    for(int popo=dodo;popo<mdig;popo++)
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    
    public static void calc(int digit[],int pos)
    {
        int t;
        //master=true;
        boolean k=false;
        int length=digit.length;
        boolean rst=true,mn,zs=false;;
        int lasti=0,lastj=0,lastt=0;
        if((pos<length)&&master)
        {
            t=digit[pos];
            for(int i=0;(i<=l-t);i++)
            {
                for(int j=0;(j<=b-t);j++)
                {
                    rst=square_check(i,j,t);
                    if(rst)
                    {
                        pos++;
                        square_fill(i,j,t);
                        k=true;
                        zs=true;
                        lasti=i;
                        lastj=j;
                        lastt=t;
                        boolean check=false;
                        for(int r=0;r<l;r++)
                        {
                            for(int s=0;s<b;s++)
                            {
                                if(arra[r][s]==(0))check=true;
                            }
                        }
                        if(check)
                        {
                                calc(digit,pos);
                        }
                        else
                        {
                            for(int sksk=0;sksk<length;sksk++)
                            System.out.print((digit[sksk]*hc)+" ");
                            System.out.println("\n"+length);
                            long dh=digit[0];
                            while(dh>0)
                            {
                                dh=dh/10;
                                mdig++;
                            }
                            print_all();
                            System.exit(0);
                        }
                        if(zs)
                        {
                            square_unfill(lasti,lastj,lastt);
                            pos--;;
                        }
                    }
                }
            }
            if(!k)
            {
               //master=false;
            }
        }
    }
    
    public static boolean square_check(int i,int j,int n)
    {
        boolean yes=true;
        for(int x=i;(x<i+n)&&yes;x++)
        {
            for(int y=j;(y<j+n)&&yes;y++)
            {
                if(arra[x][y]==0)
                continue;
                else
                {
                    yes=false;
                }
            }
        }
        return yes;
    }
    
    public static void square_fill(int i,int j,int t)
    {
        for(int r=i;r<i+t;r++)
        {
            for(int s=j;s<j+t;s++)
            {
                arra[r][s]=t;
            }
        }
    }
    
    public static void square_unfill(int i,int j,int t)
    {
        for(int r=i;r<i+t;r++)
        {
            for(int s=j;s<j+t;s++)
            {
                arra[r][s]=0;
            }
        }
    }
    
    public static int gcd(int a,int b)
    {
        int rem=0;
        while((rem=b%a)!=0)
        {
            b=a;
            a=rem;
        }
        return a;
    }
}