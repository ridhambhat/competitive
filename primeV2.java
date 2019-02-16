class primeV2
{
    public static boolean prime(int n)
    {
        boolean k=true;
        if(n<2)return false;
        for(int j=2;j<=Math.sqrt(n);j++)
        {
            if(n%j==0)k=false;
        }
        return k;
    }
}