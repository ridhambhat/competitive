import java.io.*;
import java.util.*;
class tree
{
    static int level;
    static node tree;
    
    public static void main(String args[])throws IOException
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of levels in tree");
        level=sc.nextInt();
        node start;
        int k=1;
        if(level>=1)
        {
            System.out.println("Enter the values");
            tree=new node(sc.nextInt(),null,null);
        }
        if(k<level)
        {
            
        }
        
    }
    
    
}