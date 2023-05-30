
public class SavingAccount extends Account {
    private double interestRate = 0.1; // constant interest rate

    public SavingAccount(String accountId, double balance) {
        super(accountId, balance);
        this.interestRate = 0.1;
        
    }

    public double getinterestRate() {
        return interestRate; 
    }
        
    public void applyInterest() { 
    	double balance = this.balance;
    	
    	double newBalance = balance * this.interestRate; // calculates new balance according to interest rate
    	
    	this.balance = balance + newBalance;
    }
    
   
}