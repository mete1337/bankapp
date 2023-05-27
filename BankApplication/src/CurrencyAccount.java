
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
    
    void depositMoney(double amount, String currencyUnit) {
    	double balance = this.balance;
    	double addMoney = 0;
    	
    	if(currencyUnit.equalsIgnoreCase("euro"))
    		addMoney = amount * EURO;
    	else if(currencyUnit.equalsIgnoreCase("dollar"))
    		addMoney = amount * DOLLAR;
    	else if(currencyUnit.equalsIgnoreCase("sterlin"))
    		addMoney = amount * STERLIN;
    	
    	this.balance = balance + addMoney;
    }
}