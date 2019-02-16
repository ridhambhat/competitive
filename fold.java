class fold
{
    public static void main()
    {
        double l=1189.0;
        double b=841.0;
        int i=0;
        System.out.println("Size of A"+i+" : "+l+" x "+b);
        for(i=1;i<=8;i++)
        {
            if(l>=b)
            {
                l=l/2;//Dividing longer side by 2
            }
            else
            {
                b=b/2;//Dividing longer side by 2
            }
            System.out.println("Size of A"+i+" : "+l+" x "+b);
        } 
    }
}