
public class CurrencyAccount extends Account {
   
	private String currencyUnit;
	private double EURO = 0.0467;
    private double DOLLAR = 0.050;
    private double STERLIN = 0.041;

    public CurrencyAccount(String accountId, double balance, String currencyUnit) {
        super(accountId, balance);
        this.currencyUnit = currencyUnit;
    }

    public String getcurrencyUnit() {
        return currencyUnit;
    }
    
    public void depositMoney(double amount) { // deposit money to currency account according to which type of account created
    	double balance = this.balance;
    	double addMoney = 0;
    	
    	if(this.currencyUnit.equalsIgnoreCase("euro")) // calculation according to todays currency
    		addMoney = amount * EURO;
    	else if(this.currencyUnit.equalsIgnoreCase("dollar"))
    		addMoney = amount * DOLLAR;
    	else if(this.currencyUnit.equalsIgnoreCase("sterlin"))
    		addMoney = amount * STERLIN;
    	
    	this.balance = balance + addMoney;
    }
    public double getEURO() {
		return EURO;
	}

	public double getDOLLAR() {
		return DOLLAR;
	}

	public double getSTERLIN() {
		return STERLIN;
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