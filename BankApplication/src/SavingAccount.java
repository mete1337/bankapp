
public class SavingAccount extends Account {
    private double interestRate = 0.1;

    public SavingAccount(String accountId, double balance) {
        super(accountId, balance);
        this.interestRate = 0.1;
    }

    public double getFaizOrani() {
        return interestRate;
    }
    
    
    public void depositMoney(int amount) {
    	double balance = this.balance;
    	this.balance = balance + amount;
    }
    
   
}