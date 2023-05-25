import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {
	HashMap<String, String> loginInfo = new HashMap<String,String>();
	
	LoginPage(HashMap<String, String> loginInfoOriginal){
		loginInfo = loginInfoOriginal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
