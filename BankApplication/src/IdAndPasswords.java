import java.util.HashMap;

public class IdAndPasswords {
	HashMap<String, String> loginInfo = new HashMap<String, String>();
	IdAndPasswords(){
		loginInfo.put("Mete", "anan");
		loginInfo.put("Ula�", "anan");
	}
	protected HashMap getLoginInfo(){
		return loginInfo;
	}
}
