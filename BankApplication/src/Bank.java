import java.util.HashMap;

public class Bank{

	protected HashMap<String, Customer> customers = new HashMap<String, Customer>();
	
	Bank(HashMap<String, Customer> customers){
		
		this.customers = customers;
	}
	
	
	public void createCustomer(Customer customer) {
		customers.put(customer.getId(), customer);
	}
	
	public int transferMoney(String senderId ,String recieverId, double amount) {
		if(customers.get(recieverId).accounts[0] == null || customers.get(senderId).accounts[0] == null) {
			return 2;
		}
		else {
			if(customers.get(senderId).accounts[0].getBalance() > amount) {
				double senderBalance = customers.get(senderId).accounts[0].getBalance();
				customers.get(senderId).accounts[0].setBalance(senderBalance - amount); 
				double recieverBalance = customers.get(recieverId).accounts[0].getBalance();
				customers.get(recieverId).accounts[0].setBalance(recieverBalance + amount); 
				return 1;	
			}
			else
				return 3;
		}
		
		
	}
	
	
}
