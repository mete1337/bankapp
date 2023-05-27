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
	private JRadioButton radBuyCurrency;
	private JRadioButton radSellCurrency;
	
	//Account Create Buttons
	private JRadioButton radAccount;
	private JRadioButton radSaving;
	private JRadioButton radCurrency;

	// button Group
	private ButtonGroup transGroup;
	private ButtonGroup accountGroup;


	//JPanels
	private JPanel inputPanel;
	private JPanel commandPanel;
	private HashMap<String, Customer> loginInfo = new HashMap<String,Customer>();
	
	
	
	public WelcomePage(HashMap<String, Customer> loginInfoOriginal) {
		// Setup Frame Features
		this.setTitle("ÇiftlikBank");
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
		this.inputPanel.setPreferredSize(new Dimension(550,200));
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
		this.txtAccountNumber.setPreferredSize(new Dimension(130,30));
		this.inputPanel.add(this.txtAccountNumber);
		
		
		this.lblBalance = new JLabel("Account Balance:");
		this.lblBalance.setPreferredSize(new Dimension(120,30));
		this.inputPanel.add(this.lblBalance);
		
		this.txtBalance = new JTextField();
		this.txtBalance.setEditable(false); // no balance changing allower
		this.txtBalance.setPreferredSize(new Dimension(130,30));
		this.inputPanel.add(this.txtBalance);
		
		
		
		this.radWithdraw = new JRadioButton("Withdraw");
		this.radWithdraw.setPreferredSize(new Dimension(90,30));
		this.inputPanel.add(this.radWithdraw);
		this.radWithdraw.setSelected(true);
		
		this.radDeposit = new JRadioButton("Deposit");
		this.radDeposit.setPreferredSize(new Dimension(75,30));
		this.inputPanel.add(this.radDeposit);
		
		this.radBuyCurrency = new JRadioButton("Buy Currency");
		this.radBuyCurrency.setPreferredSize(new Dimension(120,30));
		this.inputPanel.add(this.radBuyCurrency);
		
		this.radSellCurrency = new JRadioButton("Sell Currency");
		this.radSellCurrency.setPreferredSize(new Dimension(120,30));
		this.inputPanel.add(this.radSellCurrency);
		
		this.transGroup = new ButtonGroup();
		this.transGroup.add(radDeposit);
		this.transGroup.add(radWithdraw);
		this.transGroup.add(radBuyCurrency);
		this.transGroup.add(radSellCurrency);
		//Transaction Amount
		this.lblAmount = new JLabel("Transaction Amount:");
		this.lblAmount.setPreferredSize(new Dimension(120,30));
		this.inputPanel.add(this.lblAmount);
		
		this.txtAmonut = new JTextField();
		this.txtAmonut.setEditable(true);
		this.txtAmonut.setPreferredSize(new Dimension(130,30));
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
	private void setupCommands() {
		this.commandPanel = new JPanel();
		this.commandPanel.setPreferredSize(new Dimension(550,200));
		this.commandPanel.setBorder(BorderFactory.createLineBorder(Color.black));	
		
		this.btnCreate = new JButton("Create");
		this.btnCreate.setPreferredSize(new Dimension(120,30));
		this.btnCreate.addActionListener(this);
		this.commandPanel.add(this.btnCreate);
		
		this.btnBalance = new JButton("Balance");
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
		
		this.btnApplyInterest = new JButton("Apply Interest");
		this.btnApplyInterest.setPreferredSize(new Dimension(120,30));
		this.btnApplyInterest.addActionListener(this);
		this.commandPanel.add(this.btnApplyInterest);
		
		this.btnExit = new JButton("Exit");
		this.btnExit.setPreferredSize(new Dimension(120,30));
		this.btnExit.addActionListener(this);
		this.commandPanel.add(this.btnExit);
		
		
		
		this.add(this.commandPanel);
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		Object src = event.getSource();
		
	}
	
}
