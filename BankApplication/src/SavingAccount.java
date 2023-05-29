
public class SavingAccount extends Account {
    private double interestRate = 0.1;

    public SavingAccount(String accountId, double balance) {
        super(accountId, balance);
        this.interestRate = 0.1;
    }

    public double getinterestRate() {
        return interestRate;
    }
    
    
    public void depositMoney(int amount) {
    	double balance = this.balance;
    	this.balance = balance + amount;
    }
    
    public void applyInterest() {
    	double balance = this.balance;
    	
    	double newBalance = balance * this.interestRate;
    	
    	this.balance = balance + newBalance;
    }
    
   
}