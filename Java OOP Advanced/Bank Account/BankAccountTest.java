import java.util.Random;
public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount firstaccount = new BankAccount(300.00,200.00);
        BankAccount secondaccount = new BankAccount(500.00,900.00);
        // System.out.println(BankAccount.accountcount());
        System.out.println("the Current Account Number is: " + BankAccount.getAccoutCounter());
        System.out.println("Check Balance is :" + firstaccount.getCheckBalance());
        System.out.println("Saving Balance is :" + firstaccount.getSavingBalance());
        System.out.println("Total Balance is :" + firstaccount.gettotalBalance());
        secondaccount.setSavingdepo(888);
        System.out.println("Saving:"+ secondaccount.getSavingBalance());
    }
}