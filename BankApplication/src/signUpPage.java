import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class signUpPage implements ActionListener {
	private JFrame frame = new JFrame();
	private JButton resetButton = new JButton("Reset");
	private JButton signupButton = new JButton("SignUp");
	private JTextField userIDField = new JTextField();
	private JPasswordField userPasswordField = new JPasswordField();
	private JLabel userIDLabel = new JLabel("userID:");
	public HashMap<String, Customer> getLoginInfo() {
		return loginInfo;
	}
	private JLabel userPasswordLabel = new JLabel("password:");
	private JLabel messageLabel = new JLabel();
	HashMap<String, Customer> loginInfo = new HashMap<String,Customer>();
	public signUpPage(HashMap<String, Customer> loginInfoOriginal) {
		loginInfo = loginInfoOriginal;
		userIDLabel.setBounds(50,100,75,25);
		userPasswordLabel.setBounds(50,150,75,25);
		messageLabel.setBounds(125, 250, 250, 35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		userIDField.setBounds(125, 100, 200, 25);
		userPasswordField.setBounds(125, 150, 200, 25);
		signupButton.setBounds(125, 200, 100, 25);
		signupButton.setFocusable(false);
		signupButton.addActionListener(this);
		resetButton.setBounds(225, 200, 100, 25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
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
		if(e.getSource()==signupButton) {
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			Customer newCustomer = new Customer(userID,password);
			loginInfo.put(userID, newCustomer);
			messageLabel.setText("U are registered!");
			frame.dispose();
			
		}
		if(e.getSource()==resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
		}
			
	}
}	
	
