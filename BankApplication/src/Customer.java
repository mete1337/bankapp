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
