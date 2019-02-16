import java.io.*;
class n_queen
{
    static int arr[][],n,comp;
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        comp=n;
        arr=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=0;
            }
        }
        queen();
        if(!is_possible(n))
        System.out.println("NO");
        else
        {
        System.out.println("YES");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    }
    
    public static void queen()
    {
        if(comp>0)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if((is_empty(i,j))&&(straight_check(i,j))&&(cross_check(i,j)))
                    {
                        arr[i][j]=1;
                        comp--;
                        queen();
                        if(comp>0)
                        {
                            arr[i][j]=0;
                            comp++;
                        }
                    }
                    else
                    {
                        continue;
                    }
                }
            }
        }
    }
    
    public static boolean is_empty(int i,int j)
    {
        boolean flag=true;
        if(arr[i][j]==1)
        flag=false;
        return flag;
    }
    
    public static boolean straight_check(int i,int j)
    {
        boolean flag=true;
        int x=i,y=j-1;
        while(y>=0)
        {
            if(arr[x][y]==1)
            flag=false;
            y--;
        }
        y=j+1;x=i;
        while(y<n)
        {
            if(arr[x][y]==1)
            flag=false;
            y++;
        }
        x=i-1;y=j;
        while(x>=0)
        {
            if(arr[x][y]==1)
            flag=false;
            x--;
        }
        x=i+1;y=j;
        while(x<n)
        {
            if(arr[x][y]==1)
            flag=false;
            x++;
        }
        return flag;
    }
    
    public static boolean cross_check(int i,int j)
    {
        boolean flag=true;
        int x=i+1,y=j+1;
        while((x<n)&&(y<n))
        {
            if(arr[x][y]==1)
            flag=false;
            x++;y++;
        }
        x=i-1;y=j+1;
        while((x>=0)&&(y<n))
        {
            if(arr[x][y]==1)
            flag=false;
            x--;y++;
        }
        x=i-1;y=j-1;
        while((x>=0)&&(y>=0))
        {
            if(arr[x][y]==1)
            flag=false;
            x--;y--;
        }
        x=i+1;y=j-1;
        while((x<n)&&(y>=0))
        {
            if(arr[x][y]==1)
            flag=false;
            x++;y--;
        }
        return flag;
    }
    
    public static boolean is_possible(int k)
    {
        boolean flag=false;
        for(int i=0;(i<k)&&(!flag);i++)
        {
            for(int j=0;(j<k)&&(!flag);j++)
            {
                if(arr[i][j]==1)flag=true;                
            }
        }
        return flag;
    }
}