import java.util.HashMap;


public class Customer{

	protected String id;
	protected String password;
	protected Account[] accounts = new Account[3];

    public Customer(String id, String password) {
       this.id = id;
       this.password = password;
       this.accounts = new Account[3]; // this array holds possible arrays for customer
    }
    
    public int transferMoney(Customer reciever, double amount) { // this function transfer money to another account
		if(reciever.accounts[0] == null || this.accounts[0] == null) { // checks if both customer has account
			return 1;
		}
		else {
			if(this.accounts[0].getBalance() >= amount) { // checks balance
				double senderBalance = this.accounts[0].getBalance();
				this.accounts[0].setBalance(senderBalance - amount);  
				double recieverBalance = reciever.accounts[0].getBalance();
				reciever.accounts[0].setBalance(recieverBalance + amount); 
				return 2;	
			}
			else
				return 3;
			}
		}
    public boolean sellCurrency(double amount) { // this method sells from currency account and convert money and add to normal account
    	double newBalance = 0;
    	
    	if(amount < this.accounts[2].getBalance()) {
	    	if(((CurrencyAccount) this.accounts[2]).getcurrencyUnit().equalsIgnoreCase("dollar")) {
	    		newBalance = amount / ((CurrencyAccount) this.accounts[2]).getDOLLAR(); // calculate new balance if it is dollar account
	    		
	    	}
	    	else if(((CurrencyAccount) this.accounts[2]).getcurrencyUnit().equalsIgnoreCase("euro")) {
	    		newBalance = amount / ((CurrencyAccount) this.accounts[2]).getEURO();// calculate new balance if it is euro account
	    	}
	    	else
	    		newBalance = amount / ((CurrencyAccount) this.accounts[2]).getSTERLIN();// calculate new balance if it is pound account
	    	
	    	this.accounts[2].setBalance(this.accounts[2].getBalance() - amount);
	    	this.accounts[0].setBalance(this.accounts[0].getBalance() + newBalance); // transfer new amount to the normal account
	    	return true;
    	}
    	else
    		return false;
    	
    	
    }
  	
	
	public void createSavingAccount() {
		
		SavingAccount saveacc = new SavingAccount(this.id, 0); // creates an saving account
		this.accounts[1] = saveacc; // insert saving account to arrays second element
		
	}
	
	public void createAccount() {
		
		Account acc = new Account(this.id, 0);
		this.accounts[0] = acc;// insert saving account to arrays first element
	}
	
	public void createCurrency(String dovizCinsi) {
		
		CurrencyAccount currencyacc = new CurrencyAccount(this.id, 0, dovizCinsi);
		this.accounts[2] = currencyacc;// insert saving account to arrays third element
		
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
