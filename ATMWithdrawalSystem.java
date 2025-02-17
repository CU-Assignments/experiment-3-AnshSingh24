import java.util.*;
public class ATMWithdrawalSystem
{
    private static final int CORRECT_PIN=1234;
    private static double balance=3000;
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        try
        {
            System.out.print("Enter PIN: ");
            int enteredPIN=sc.nextInt();
            if(enteredPIN!=CORRECT_PIN)
            {
                throw new InvalidPINException("Error: Invalid PIN.");
            }
            System.out.print("Withdraw Amount: ");
            double amount=sc.nextDouble();
            if(amount>balance)
            {
                throw new InsufficientBalanceException("Error: Insufficient balance.");
            }
            balance-=amount;
            System.out.println("Withdrawal successful! Remaining Balance: "+balance);
        }
        catch(InvalidPINException|InsufficientBalanceException e)
        {
            System.out.println(e.getMessage()+"Current Balance: "+balance);
        }
        catch(Exception e)
        {
            System.out.println("Error: Invalid Input");
        }
        finally
        {
            System.out.println("Final Balance: "+balance);
            sc.close();
        }
    }
}