import java.util.HashMap;
import java.util.Iterator;

public class IdAndPasswords {
	private String[] ids  = new String[5];
	private String[] passwords  = new String[5];
	Customer [] a = new Customer[5];
	private HashMap<String, Customer> loginInfo = new HashMap<String, Customer>();
	public IdAndPasswords(){ 
		ids[0] = "0";
		ids[1] = "1"; // these are for testing
		ids[2] = "2";
		ids[3] = "3";
		ids[4] = "4";
		passwords[0] = "0";
		passwords[1] = "1";
		passwords[2] = "2";
		passwords[3] = "3";
		passwords[4] = "4";
		for(int i = 0; i<4; i++) {
			a[i] = new Customer(ids[i],passwords[i]);
			loginInfo.put(a[i].getId(), a[i]);
		}
		
	}
	public  HashMap getLoginInfo(){
		return loginInfo;
	}
	
}
