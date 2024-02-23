import java.util.*;
class Main
{
    public static void main(String args[])
    {
        int num,sum=0,i;
        System.out.println("Enter number of subjects: ");
        Scanner sc=new Scanner(System.in);
        num=sc.nextInt();
        System.out.println("Enter marks for each subject out of 100: ");
        int[] s=new int[num];
        for(i=0;i<num;i++)
        {
            s[i]=sc.nextInt();
        }
        for(i=0;i<num;i++)
        {
            sum=sum+s[i];
        }
        System.out.println("Total Marks: "+sum);
        int avg=sum/num;
        System.out.println("Average Percentage: "+avg);
        System.out.print("The Student Grade is: ");
        if(avg>=80)
        {
            System.out.print("A");
        }
        else if(avg>=60 && avg<80)
        {
           System.out.print("B");
        } 
        else if(avg>=40 && avg<60)
        {
            System.out.print("C");
        }
        else
        {
            System.out.print("D");
        }
    }
}
