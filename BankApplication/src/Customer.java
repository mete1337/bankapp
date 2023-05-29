import java.util.HashMap;


public class Customer{

	protected String id;
	protected String password;
	protected Account[] accounts = new Account[3];

    public Customer(String id, String password) {
       this.id = id;
       this.password = password;
       this.accounts = new Account[3];
    }
    
    public int transferMoney(Customer reciever, double amount) {
		if(reciever.accounts[0] == null || this.accounts[0] == null) {
			return 1;
		}
		else {
			if(this.accounts[0].getBalance() > amount) {
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
    public boolean sellCurrency(double amount) {
    	double newBalance = 0;
    	
    	if(amount < this.accounts[2].getBalance()) {
	    	if(((CurrencyAccount) this.accounts[2]).getDovizCinsi().equalsIgnoreCase("dollar")) {
	    		newBalance = amount / ((CurrencyAccount) this.accounts[2]).getDOLLAR();
	    		
	    	}
	    	else if(((CurrencyAccount) this.accounts[2]).getDovizCinsi().equalsIgnoreCase("euro")) {
	    		newBalance = amount / ((CurrencyAccount) this.accounts[2]).getEURO();
	    	}
	    	else
	    		newBalance = amount / ((CurrencyAccount) this.accounts[2]).getSTERLIN();
	    	
	    	this.accounts[2].setBalance(this.accounts[2].getBalance() - amount);
	    	this.accounts[0].setBalance(this.accounts[0].getBalance() + newBalance);
	    	return true;
    	}
    	else
    		return false;
    	
    	
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
