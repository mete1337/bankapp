
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IdAndPasswords idandpassword = new IdAndPasswords();
		LoginPage loginpage = new LoginPage(idandpassword.getLoginInfo());	
		
			// Müşteri oluşturma
	        Customer customer1 = new Customer("Ahmet");

	        // Hesaplarını oluşturma
	        DepositAccount depositAccount1 = new DepositAccount(1, 5000, 0.05);
	        CurrencyAccount currencyAccount1 = new CurrencyAccount(2, 1000, "USD");

	        DepositAccount depositAccount2 = new DepositAccount(3, 3000, 0.03);
	        CurrencyAccount currencyAccount2 = new CurrencyAccount(4, 2000, "EUR");

	        // Hesapları müşteriye ekleme
	        customer1.addAccount(depositAccount1);
	        customer1.addAccount(currencyAccount1);

	        customer1.addAccount(depositAccount2);
	        customer1.addAccount(currencyAccount2);

	        // Para transferi
	        Account senderAccount = customer1.accounts.get(0); // Ahmet'in ilk hesabı
	        Account receiverAccount = customer1.accounts.get(1); // Ahmet'in ikinci hesabı

	        double transferAmount = 1000;
	        customer1.transferMoney(senderAccount, receiverAccount, transferAmount);

	        // Hesap bilgilerini gösterme
	        System.out.println("Account Information for " + customer1.name);
	        for (Account account : customer1.accounts) {
	            System.out.println("Account ID: " + account.getAccountId());
	            System.out.println("Total Assets: " + account.getBalance());
	            System.out.println("Logs: ");
	            for (String log : account.getLoglar()) {
	                System.out.println(log);
	            }
	            System.out.println("-------------------------");
	        }
	}

}
