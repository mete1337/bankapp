import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener {
	private JFrame frame = new JFrame();
	private JButton loginButton = new JButton("Login");
	private JButton resetButton = new JButton("Reset");
	private JButton signupButton = new JButton("SignUp");
	private JTextField userIDField = new JTextField();
	private JPasswordField userPasswordField = new JPasswordField();
	private JLabel userIDLabel = new JLabel("userID:");
	private JLabel userPasswordLabel = new JLabel("password:");
	private JLabel messageLabel = new JLabel();
	
	HashMap<String, Customer> loginInfo = new HashMap<String,Customer>();
	
	LoginPage(HashMap<String, Customer> loginInfoOriginal){
		loginInfo = loginInfoOriginal;
		userIDLabel.setBounds(50,100,75,25);
		userPasswordLabel.setBounds(50,150,75,25);
		messageLabel.setBounds(125, 250, 250, 35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		userIDField.setBounds(125, 100, 200, 25);
		userPasswordField.setBounds(125, 150, 200, 25);
		signupButton.setBounds(25, 200, 100, 25);
		signupButton.setFocusable(false);
		signupButton.addActionListener(this);
		loginButton.setBounds(125, 200, 100, 25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		resetButton.setBounds(225, 200, 100, 25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.add(signupButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
		}
		if(e.getSource()==loginButton) {
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			if(loginInfo.containsKey(userID)&&loginInfo.get(userID).getPassword().equals(password)) {
				messageLabel.setForeground(Color.green);
				messageLabel.setText("Login Succesful");
				frame.dispose();
				WelcomePage welcomePage = new WelcomePage(loginInfo,userID);
				
				
			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("ID or Password is not invalid");
			}
				
				
		}
		if(e.getSource()==signupButton) {
			signUpPage signuppage = new signUpPage(this.loginInfo);
			loginInfo = signuppage.getLoginInfo();
			
		}
		
	}
	
}
