public class Account {
    protected String accountId;
    protected double balance;

    public Account(String accountId, double balance) {
        this.accountId = accountId; // account id
        this.balance = balance; // account balance
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void depositMoney(double amount) { // deposit money to accounts
    	double balance = this.balance;
    	this.balance = balance + amount;
    }
    
   
    public void withdraw(double amount) { // withdraws money from account
    	double balance = this.balance; 
    	if(balance >= amount)
    		this.balance = balance - amount; // changes balance 
    	else
    		System.out.println("not enough money");
    }

}
