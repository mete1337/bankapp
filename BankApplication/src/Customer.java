import java.util.ArrayList;
import java.util.HashMap;

public class Customer{

	protected int id;
	protected String password;
	protected DepositAccount depositacc;
	protected Account acc;
	protected CurrencyAccount currencyacc;
	protected String name;
    protected ArrayList<Accounts> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void transferMoney(Account senderAccount, Account receiverAccount, double amount) {
        if (senderAccount.getBalance() >= amount) {
            senderAccount.setBalance(senderAccount.getBalance() - amount);
            receiverAccount.setBalance(receiverAccount.getBalance() + amount);

            String log = "Transfer: " + senderAccount.getAccountId() + " --> " + receiverAccount.getAccountId() +
                    " Amount: " + amount;
            senderAccount.getLoglar().add(log);
            receiverAccount.getLoglar().add(log);

            System.out.println("Transfer successful.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }
	
	Customer(int id, String password){
		
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
}
