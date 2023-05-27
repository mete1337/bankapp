import java.util.ArrayList;
import java.util.HashMap;

public class Customer{

	protected String id;
	protected String password;
	protected DepositAccount depositacc;
	protected Account acc;
	protected CurrencyAccount currencyacc;
	
	
	Customer(String id, String password){
		
		this.id = id;
		this.password = password;
	}
	
	
	
	public void createDepositAccount() {
	
	}
	
	public void createAccount() {
		
		Account acc = new Account();
	}
	
	public void createCurrency() {
		
		CurrencyAccount currencyacc = new CurrencyAccount();
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
