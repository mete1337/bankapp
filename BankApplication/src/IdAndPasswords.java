import java.util.HashMap;
import java.util.Iterator;

public class IdAndPasswords {
	HashMap<String, String> loginInfo = new HashMap<String, String>();
	IdAndPasswords(){
		loginInfo.put("Mete", "123");
		loginInfo.put("Ulaþ", "123");
		loginInfo.put("Batuhan", "123");
		
	}
	protected HashMap getLoginInfo(){
		return loginInfo;
	}
}
