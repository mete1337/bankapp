
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IdAndPasswords idandpassword = new IdAndPasswords();
		LoginPage loginpage = new LoginPage(idandpassword.getLoginInfo());	
		
		Customer e1 = new Customer("221", "123");
		
		e1.createCurrency("dolar");
		e1.accounts[2].getBalance();
		System.out.println(e1.accounts[2].getBalance());
	}

}
