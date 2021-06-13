import java.util.Random;

public class BankAccount{
    private String account_number;
    private double checking_balance;
    private double savings_balance;
    private static int accountscounter = 0;
    private static double totalnumber = 0;
    public BankAccount(double checkofbalance, double savingsofbalance ) {
        account_number=generateNumber();
        checking_balance=checkofbalance;
        savings_balance=savingsofbalance;
        accountscounter=accountscounter+1;
    }
    private static String generateNumber(){
    Random r = new Random();
    String y = "";
    for(int i=1; i<=10; i++){
        int x=r.nextInt(10);
        y= y.concat(String.valueOf(x));
    }
    return y;
}
public static int getAccoutCounter(){
    return accountscounter;
}

public double getCheckBalance(){
    return checking_balance;
}
public double getSavingBalance(){
    return savings_balance;
}

public void setBalancedepo (double deposite){
    checking_balance=checking_balance+deposite;
}
public void setBalancewith (double withdraw){
    if (checking_balance > withdraw){
    checking_balance=checking_balance-withdraw;
    }
}
public void setSavingdepo (double deposite){
    savings_balance=savings_balance+deposite;
}

public double gettotalBalance(){
    return (checking_balance+savings_balance);
}



    
}