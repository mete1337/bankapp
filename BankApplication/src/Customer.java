import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Customer{

	protected String id;
	protected String password;
	protected Account[] accounts = new Account[3];

    public Customer(String id, String password) {
       this.id = id;
       this.password = password;
       this.accounts = new Account[3];
    }


    public void transferMoney(Customer receiverCustomer, double amount) {
        if (receiverCustomer.accounts[0] == null && this.accounts[0] == null) {
        	System.out.println("there is no account");
        }
        else {
        	double senderBalance = this.accounts[0].getBalance();
        	if(senderBalance > amount) {
        	this.accounts[0].setBalance(senderBalance - amount);
        	double receiverBalance = receiverCustomer.accounts[0].getBalance();
        	receiverCustomer.accounts[0].setBalance(receiverBalance + amount);
        	}
        	else {
        		System.out.println("Balance is not enough for transfer");
        	}
        }
    }
	
	
	public void createSavingAccount() {
	
		
		SavingAccount saveacc = new SavingAccount(this.id, 0);
		this.accounts[1] = saveacc;
		
	}
	
	public void createAccount() {
		
		Account acc = new Account(this.id, 0);
		this.accounts[0] = acc;
	}
	
	public void createCurrency(String dovizCinsi) {
		
		CurrencyAccount currencyacc = new CurrencyAccount(this.id, 0, dovizCinsi);
		this.accounts[2] = currencyacc;
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
}
