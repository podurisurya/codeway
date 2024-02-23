import java.util.Scanner;
class BankAccount{
    private double balance;
    public BankAccount(double intialBalance){
        this.balance=intialBalance;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        if(amount>0)
        {
            balance+=amount;
            System.out.println("Deposit successful. New balance: "+balance);
        }else{
            System.out.println("Invalid amount for Deposit.");
        }
    }
    public void withdraw(double amount){
        if(amount>0 && amount<=balance)
        {
            balance-=amount;
            System.out.println("Withdrawal successful. New Balance: "+balance);
        }
        else{
            System.out.println("Insufficient funds or invalid amount for withdrawal. ");
        }
    }
}
class ATM{
    private BankAccount account;
    public ATM(BankAccount account){
        this.account=account;
    }
    public void run(){
        int choice;
        do{
            System.out.println("\n1.Check Balance\n2.Deposit\n3.Withdraw\n4.Exit\n");
            System.out.println("Enter your choice");
            Scanner sc=new Scanner(System.in);
            choice=sc.nextInt();
            switch(choice)
            {
                case 1:checkBalance();
                        break;
                case 2:deposit();
                       break;
                case 3:withdraw();
                       break;
                case 4:System.out.println("ThankYou for using the ATM!");
                       break;
                default:System.out.println("Invalid choice.please select a valid option.");
            }
        }while(choice !=4);
    }
    private void checkBalance(){
        System.out.println("Your Current Balance is: "+account.getBalance());
    }
    private void deposit(){
        System.out.println("Enter the amount Deposit: ");
        Scanner sc=new Scanner(System.in);
        double amount=sc.nextDouble();
        account.deposit(amount);
    }
    private void withdraw(){
        System.out.println("Enter the amount to withdraw: ");
        Scanner sc=new Scanner(System.in);
        double amount=sc.nextDouble();
        account.withdraw(amount);
    }
}
class Main{
    public static void main(String args[]){
        System.out.println("Welcome to the ATM!");
        System.out.println("Enter Your Four Digit PIN: ");
        Scanner sc=new Scanner(System.in);
        int pin=sc.nextInt();
        BankAccount userAccount=new BankAccount(10000.0);
        ATM atm=new ATM(userAccount);
        atm.run();
    }
}