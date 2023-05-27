
public class CurrencyAccount extends Account {
   
	private String currencyUnit;
	private double EURO = 0.0467;
    private double DOLLAR = 0.050;
    private double STERLIN = 0.041;

    public CurrencyAccount(String accountId, double balance, String currencyUnit) {
        super(accountId, balance);
        this.currencyUnit = currencyUnit;
    }

    public String getDovizCinsi() {
        return currencyUnit;
    }
    
    public void depositMoney(double amount) {
    	double balance = this.balance;
    	double addMoney = 0;
    	
    	if(this.currencyUnit.equalsIgnoreCase("euro"))
    		addMoney = amount * EURO;
    	else if(this.currencyUnit.equalsIgnoreCase("dollar"))
    		addMoney = amount * DOLLAR;
    	else if(this.currencyUnit.equalsIgnoreCase("sterlin"))
    		addMoney = amount * STERLIN;
    	
    	this.balance = balance + addMoney;
    }
    public String showBalance() {
    	String balanceLine = null;
    	
    	if(this.currencyUnit.equalsIgnoreCase("euro"))
    		balanceLine = Double.toString(this.balance) + "€";
    	else if(this.currencyUnit.equalsIgnoreCase("dollar"))
    		balanceLine = Double.toString(this.balance) + "$";
    	else if(this.currencyUnit.equalsIgnoreCase("sterlin"))
    		balanceLine = Double.toString(this.balance) + "£";
    	
    	return balanceLine;
  
    }
    
    
    
}