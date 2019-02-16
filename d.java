class d
{
    public static int divisors(int n)
    {
        int count=0;
        int r=(int)Math.sqrt(n);
        for(int i=1;i<=r;i++)
        {
            if(n%i==0)count++;
        }
        count=count*2;
        if((r*r)==n)count--;
        return count;
        
    }
}