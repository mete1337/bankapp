import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class WelcomePage extends JFrame implements ActionListener {
	//Buttons
	private JButton btnWithdraw;
	private JButton btnDeposit;
	private JButton btnCalcInterest;
	private JButton btnApplyInterest;
	private JButton btnExit;
	private JButton btnCreate;
	private JButton btnBalance;
	private JButton btnTransferMoney;
	

	//Labels
	private JLabel lblAccountNumber;
	private JLabel lblBalance;
	private JLabel lblAmount;
	private JLabel lblMessage;
	// Text Fields
	private JTextField txtAccountNumber;
	private JTextField txtAmonut;
	private JTextField txtBalance;
	//Operations
	private JRadioButton radWithdraw;
	private JRadioButton radDeposit;
	private JRadioButton radSellCurrency;
	private JRadioButton radTransferMoney;
	private JRadioButton radEuro;
	private JRadioButton radDollar;
	private JRadioButton radSterlin;
	
	//Account Create Buttons
	private JRadioButton radAccount;
	private JRadioButton radSaving;
	private JRadioButton radCurrency;

	// button Group
	private ButtonGroup transGroup;
	private ButtonGroup accountGroup;
	private String nameBank = "ÇiftlikBank- "+"ID: ";

	//JPanels
	private JPanel inputPanel;
	private JPanel commandPanel;
	private HashMap<String, Customer> loginInfo = new HashMap<String,Customer>();
	private String currentId;
	private Customer currentCustomer;
	private String generalCurrency = "₺";
	
	
	public WelcomePage(HashMap<String, Customer> loginInfoOriginal,String idOfCustomer) { // holds every customer inside of a hash map 
		// Setup Frame Features
		this.currentId = idOfCustomer;
		this.loginInfo = loginInfoOriginal;
		
		this.currentCustomer = loginInfo.get(currentId);
		this.setTitle(nameBank+currentId);
		this.setSize(750,500);
		this.setPreferredSize(new Dimension(750,500));
		this.setLocation(200, 300);
		this.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Setup Inputs
		setupInputs();
		//setup Commands
		setupCommands();
		// pack UI
		pack();
		
		
	}
	
	
	private void setupInputs() {
		this.inputPanel = new JPanel();
		this.inputPanel.setPreferredSize(new Dimension(670,200));
		this.inputPanel.setBorder(BorderFactory.createTitledBorder("Inputs"));
		
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		top.setPreferredSize(new Dimension(640,40));
		this.inputPanel.add(top);
		
		this.lblAccountNumber = new JLabel("Account Number:");
		this.lblAccountNumber.setPreferredSize(new Dimension(120,30));
		this.inputPanel.add(this.lblAccountNumber);
		
		this.txtAccountNumber = new JTextField();
		this.txtAccountNumber.setEditable(true); // no balance changing allower
		this.txtAccountNumber.setPreferredSize(new Dimension(150,30));
		this.inputPanel.add(this.txtAccountNumber);
		
		this.lblMessage = new JLabel("");
		this.lblMessage.setPreferredSize(new Dimension(120,30));
		this.add(lblMessage);
		
		this.lblBalance = new JLabel("Account Balance:");
		this.lblBalance.setPreferredSize(new Dimension(120,30));
		this.inputPanel.add(this.lblBalance);
		
		this.txtBalance = new JTextField();
		this.txtBalance.setEditable(false); // no balance changing allower
		this.txtBalance.setPreferredSize(new Dimension(150,30));
		this.inputPanel.add(this.txtBalance);
		
		this.radWithdraw = new JRadioButton("Withdraw");
		this.radWithdraw.setPreferredSize(new Dimension(120,30));
		this.inputPanel.add(this.radWithdraw);
		this.radWithdraw.setSelected(true);
		
		this.radDeposit = new JRadioButton("Deposit");
		this.radDeposit.setPreferredSize(new Dimension(120,30));
		this.inputPanel.add(this.radDeposit);
		
		
		this.radSellCurrency = new JRadioButton("Sell Currency");
		this.radSellCurrency.setPreferredSize(new Dimension(150,30));
		this.inputPanel.add(this.radSellCurrency);
		
		this.radTransferMoney = new JRadioButton("Transfer Money");
		this.radTransferMoney.setPreferredSize(new Dimension(170,30));
		this.inputPanel.add(this.radTransferMoney);

		
		this.transGroup = new ButtonGroup();
		this.transGroup.add(radDeposit);
		this.transGroup.add(radWithdraw);
		this.transGroup.add(radSellCurrency);
		this.transGroup.add(radTransferMoney);
		//Transaction Amount
		
		
		this.radEuro = new JRadioButton("Euro");
		this.radEuro.setPreferredSize(new Dimension(90,30));
		this.inputPanel.add(this.radEuro);
		this.radEuro.setSelected(true);
		
		this.radDollar = new JRadioButton("Dollar");
		this.radDollar.setPreferredSize(new Dimension(90,30));
		this.inputPanel.add(this.radDollar);
		
		this.radSterlin = new JRadioButton("Sterlin");
		this.radSterlin.setPreferredSize(new Dimension(90,30));
		this.inputPanel.add(this.radSterlin);
		
		this.transGroup = new ButtonGroup();
		this.transGroup.add(radEuro);
		this.transGroup.add(radDollar);
		this.transGroup.add(radSterlin);
		
		this.lblAmount = new JLabel("Transaction Amount:");
		this.lblAmount.setPreferredSize(new Dimension(120,30));
		this.inputPanel.add(this.lblAmount);
		
		this.txtAmonut = new JTextField();
		this.txtAmonut.setEditable(true);
		this.txtAmonut.setPreferredSize(new Dimension(120,30));
		this.inputPanel.add(this.txtAmonut);
		
		
		
		
		
		//
		JLabel lblTyple = new JLabel("Select Account Type");
		top.add(lblTyple);
		
		this.radAccount = new JRadioButton("Account");
		this.radAccount.setPreferredSize(new Dimension(90,30));
		top.add(this.radAccount);
		this.radAccount.setSelected(true);
		
		this.radSaving = new JRadioButton("Saving");
		this.radSaving.setPreferredSize(new Dimension(75,30));
		top.add(radSaving);
		
		this.radCurrency = new JRadioButton("Currency");
		this.radCurrency.setPreferredSize(new Dimension(120,30));
		top.add(radCurrency);
		
		this.accountGroup = new ButtonGroup();
		this.accountGroup.add(radAccount);
		this.accountGroup.add(radSaving);
		this.accountGroup.add(radCurrency);		
		
		
		
		// add to frame
		this.add(this.inputPanel);
	}
	private void setupCommands() {  // functions for main screen implementations
		this.commandPanel = new JPanel();
		this.commandPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
		this.commandPanel.setPreferredSize(new Dimension(550,170));
		this.commandPanel.setBorder(BorderFactory.createLineBorder(Color.black));	
		
		this.btnCreate = new JButton("Create");
		this.btnCreate.setPreferredSize(new Dimension(120,30));
		this.btnCreate.addActionListener(this);
		this.commandPanel.add(this.btnCreate);
		
		this.btnBalance = new JButton("Show Balance");
		this.btnBalance.setPreferredSize(new Dimension(120,30));
		this.btnBalance.addActionListener(this);
		this.commandPanel.add(this.btnBalance);
		
		this.btnWithdraw = new JButton("Withdraw");
		this.btnWithdraw.setPreferredSize(new Dimension(120,30));
		this.btnWithdraw.addActionListener(this);
		this.commandPanel.add(this.btnWithdraw);
		
		this.btnDeposit = new JButton("Deposit");
		this.btnDeposit.setPreferredSize(new Dimension(120,30));
		this.btnDeposit.addActionListener(this);
		this.commandPanel.add(this.btnDeposit);
		
		this.btnCalcInterest = new JButton("Show Interest");
		this.btnCalcInterest.setPreferredSize(new Dimension(120,30));
		this.btnCalcInterest.addActionListener(this);
		this.commandPanel.add(this.btnCalcInterest);
		
		this.btnApplyInterest = new JButton("Apply Interest For 1 Year");
		this.btnApplyInterest.setPreferredSize(new Dimension(190,30));
		this.btnApplyInterest.addActionListener(this);
		this.commandPanel.add(this.btnApplyInterest);	
		
		this.btnTransferMoney = new JButton("Transfer Money");
		this.btnTransferMoney.setPreferredSize(new Dimension(150,30));
		this.btnTransferMoney.addActionListener(this);
		this.commandPanel.add(this.btnTransferMoney);
		
		this.btnExit = new JButton("Exit");
		this.btnExit.setPreferredSize(new Dimension(120,30));
		this.btnExit.addActionListener(this);
		this.commandPanel.add(this.btnExit);
		
		this.add(this.commandPanel);
	}
	@Override
	public void actionPerformed(ActionEvent event) { // these if else methods are for which button used and what they will do
		Object src = event.getSource();
		if(src.equals(this.btnCreate)) { // if create button used
			createAccount();
			checkBalance();
		}
		else if(src.equals(btnExit)) {
			LoginPage loginPage = new LoginPage(loginInfo);
			dispose();
		}
		else if(src.equals(btnBalance)) {
			checkBalance();
		}
		else if(src.equals(btnDeposit)) {
			try {
				deposit(Double.parseDouble(txtAmonut.getText()));
				checkBalance();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Your Amount is 0!!", nameBank, JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(src.equals(btnCalcInterest)) {
			showInterest();
		}
		else if(src.equals(btnTransferMoney)) {		
			try {
				transferMoney(txtAccountNumber.getText(), Double.parseDouble(txtAmonut.getText()));
				checkBalance();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Please enter valid transfer amount!!", nameBank, JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(src.equals(btnApplyInterest)) {
			applyInterest();
		}
		else if(src.equals(btnWithdraw)) {
			try {
				if(this.radSellCurrency.isSelected()) {
					sellCurrency(Double.parseDouble(txtAmonut.getText()));
					checkBalance();
				}
				else {
				withdraw(Double.parseDouble(txtAmonut.getText()));
				checkBalance();
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Your Amount is 0!!", nameBank, JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	private void showInterest() {
		if(this.radSaving.isSelected()) {
			if(checkAccount(1)) {
				JOptionPane.showMessageDialog(null, "Interest Rate is " + ((SavingAccount) currentCustomer.accounts[1]).getinterestRate(), nameBank, JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	private void deposit(double Amount) { // calls deposit functions
		if(this.radDeposit.isSelected()) {
			if(this.radAccount.isSelected()) { //Control which account type selected
				if(checkAccount(0)) {
					currentCustomer.accounts[0].depositMoney(Amount);
					checkBalance();
				}			
			}
			else if(this.radSaving.isSelected()) {
				if(checkAccount(1)) { 
					currentCustomer.accounts[1].depositMoney(Amount);
					checkBalance();}
			}
			else {
				if(checkAccount(2)) { 
					currentCustomer.accounts[2].depositMoney(Amount);;	
					checkBalance();
				}
			}
		}
		else
			JOptionPane.showMessageDialog(null, "Please select deposit option", nameBank, JOptionPane.ERROR_MESSAGE);
			
	}
	private void  checkBalance() { // calls check getbalance functions according to the selected account types
		if(this.radAccount.isSelected()) {
			if(checkAccount(0)) {
				this.txtBalance.setText(Double.toString(currentCustomer.accounts[0].getBalance()) + generalCurrency);				
			}	
		}
		else if(this.radSaving.isSelected()) {
			if(checkAccount(1)) 
				this.txtBalance.setText(Double.toString(currentCustomer.accounts[1].getBalance()) + generalCurrency);					
		}
		else {
			if(checkAccount(2)) 
				this.txtBalance.setText(((CurrencyAccount)currentCustomer.accounts[2]).showBalance());
				//this.txtBalance.setText(currentCustomer.accounts[2].showBalance());	
		}
	}
	private boolean checkAccount(int accountType) { // this is a shortcut for controlling if that account exist
		if(currentCustomer.accounts[accountType]==null) {
			JOptionPane.showMessageDialog(null, "you dont have this account", nameBank, JOptionPane.ERROR_MESSAGE);
			return false;	
		}
		else
			return true;
	}
	private void createAccount() { // this function creates account according to which type of account selected
		if(this.radAccount.isSelected()) {
			if(currentCustomer.accounts[0]==null) {
				currentCustomer.createAccount();
				//this.lblMessage.setText("you have created");
				JOptionPane.showMessageDialog(null, "you have created", nameBank, JOptionPane.INFORMATION_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(null, "you have already this account type", nameBank, JOptionPane.ERROR_MESSAGE);
		}
		else if(this.radSaving.isSelected()) {
			if(currentCustomer.accounts[1]==null) {
				currentCustomer.createSavingAccount();
				JOptionPane.showMessageDialog(null, "you have created", nameBank, JOptionPane.INFORMATION_MESSAGE);}
			else
				JOptionPane.showMessageDialog(null, "you have already this account type", nameBank, JOptionPane.ERROR_MESSAGE);
			
		}
		else {
			if(currentCustomer.accounts[2]==null) {
				if(this.radDollar.isSelected())
					currentCustomer.createCurrency("dollar");
				else if(this.radEuro.isSelected()) {
					currentCustomer.createCurrency("euro");
				}
				else
					currentCustomer.createCurrency("sterlin");
				JOptionPane.showMessageDialog(null, "you have created", nameBank, JOptionPane.INFORMATION_MESSAGE);}
			else				
				JOptionPane.showMessageDialog(null, "you have already this account type", nameBank, JOptionPane.ERROR_MESSAGE);

		}
				
	}
	
	private void transferMoney(String recieverId, double amount) { // this funtions transfer money to another account
		
		if(this.radAccount.isSelected() && this.radTransferMoney.isSelected()) {
			Customer reciever = loginInfo.get(recieverId);
			if(reciever == null) {
				JOptionPane.showMessageDialog(null, "This account is not found", nameBank, JOptionPane.ERROR_MESSAGE);
			}
			else
			if(reciever.accounts[0] == null) {
				JOptionPane.showMessageDialog(null, "This account is not found", nameBank, JOptionPane.ERROR_MESSAGE);
			}
			else if(recieverId.equals(currentCustomer.getId())){
				JOptionPane.showMessageDialog(null, "You can not transfer money current account", nameBank, JOptionPane.ERROR_MESSAGE);
			}
			else {
				if(amount <= currentCustomer.accounts[0].getBalance())
					currentCustomer.transferMoney(reciever, amount);
				else
					JOptionPane.showMessageDialog(null, "Amount is not enough for transfer", nameBank, JOptionPane.ERROR_MESSAGE);
			checkBalance();
			}
		}
		else if(!this.radAccount.isSelected())
			JOptionPane.showMessageDialog(null, "Only 'Account' can make money transfer", nameBank, JOptionPane.ERROR_MESSAGE);
		else if(!this.radTransferMoney.isSelected())
			JOptionPane.showMessageDialog(null, "Please select transfer money option", nameBank, JOptionPane.ERROR_MESSAGE);
	}
	
	private void applyInterest() { // applies interest
		if(this.radSaving.isSelected()) {
			if(checkAccount(1))
			((SavingAccount) currentCustomer.accounts[1]).applyInterest();
			checkBalance();
			JOptionPane.showMessageDialog(null, "New balance is " + currentCustomer.accounts[1].getBalance(), nameBank, JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, "Please select 'Saving' account type", nameBank, JOptionPane.ERROR_MESSAGE);
		}
	}
	private void withdraw(double amount) {  // calls withdraws functions inside of account class
		if(this.radWithdraw.isSelected()) {
			
			
			if(this.radAccount.isSelected() && checkAccount(0)) { //controls which accoun type selected
				if(currentCustomer.accounts[0].getBalance() >= amount) {
					currentCustomer.accounts[0].withdraw(amount); // calls withdraw function from account class
					JOptionPane.showMessageDialog(null, "Withdraw is done!", nameBank, JOptionPane.INFORMATION_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null, "Amount is not enough", nameBank, JOptionPane.ERROR_MESSAGE);
				
			}		
			else if(this.radSaving.isSelected() && checkAccount(1)){
				if(currentCustomer.accounts[1].getBalance() >= amount) {
					currentCustomer.accounts[1].withdraw(amount);
					JOptionPane.showMessageDialog(null, "Withdraw is done!", nameBank, JOptionPane.INFORMATION_MESSAGE);
					
				}
				else
					JOptionPane.showMessageDialog(null, "Amount is not enough", nameBank, JOptionPane.ERROR_MESSAGE);
			}		
			}
		else
			JOptionPane.showMessageDialog(null, "Please select withdraw option", nameBank, JOptionPane.ERROR_MESSAGE);
		
	}
	private void sellCurrency(double amount) { // this function calls sellcurrency method from currency account
		if(checkAccount(0) && checkAccount(2)) {
			if(this.radSellCurrency.isSelected()) {
				if(currentCustomer.sellCurrency(amount)) { 
					JOptionPane.showMessageDialog(null, "Work is done!", nameBank, JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Amount is not enough!", nameBank, JOptionPane.ERROR_MESSAGE);
				}	
			}
			else
				JOptionPane.showMessageDialog(null, "Please select sellCurrency option", nameBank, JOptionPane.ERROR_MESSAGE);
		}
	}
}
