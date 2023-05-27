
public class SavingAccount extends Account {
    private double faizOrani = 0.1;

    public SavingAccount(String accountId, double balance) {
        super(accountId, balance);
        this.faizOrani = 0.1;
    }

    public double getFaizOrani() {
        return faizOrani;
    }
    
    
    public void depositMoney(int amount) {
    	double balance = this.balance;
    	this.balance = balance + amount;
    }
    
   
}