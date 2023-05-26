
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IdAndPasswords idandpassword = new IdAndPasswords();
		//LoginPage loginpage = new LoginPage(idandpassword.getLoginInfo());	
		
		Customer e1 = new Customer("2002", "abac");
		
		e1.createAccount();
		
		e1.accounts[0].depositMoney(1000);
		e1.accounts[0].withdrawl(2000);
		
		System.out.println(e1.accounts[0].getBalance());
		
		
			
	}

}
