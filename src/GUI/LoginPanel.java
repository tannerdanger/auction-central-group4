package GUI;

import storage.DataHandler;
import users.AuctionStaff;
import users.Bidder;
import users.ContactPerson;
import users.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creates a panel that allows a user to login to the program.
 * @author Tanner Brown
 * @version 26 May 2018
 */
public class LoginPanel extends JPanel{
	private JTextField usernameField;
	private GUIFrame myMainFrame;
	private DataHandler myData;

	protected LoginPanel(DataHandler theData, GUIFrame tempGUIFrame){
		myMainFrame = tempGUIFrame;
		myData = theData;
		buildPanel(theData);
	}

	private void buildPanel(DataHandler theData) {
		setLayout(new GridLayout(3, 0, 1, 0));

		JPanel topPanel = new JPanel();
		add(topPanel);
		topPanel.setLayout(new GridLayout(2, 3, 0, 0));

		JPanel panel_3 = new JPanel();
		topPanel.add(panel_3);

		JPanel panel_4 = new JPanel();
		topPanel.add(panel_4);

		JPanel panel_5 = new JPanel();
		topPanel.add(panel_5);

		JPanel panel_6 = new JPanel();
		topPanel.add(panel_6);

		JPanel panel_7 = new JPanel();
		topPanel.add(panel_7);

		JLabel lblWelcomeToAuction = new JLabel("Welcome to Auction Central!");
		panel_7.add(lblWelcomeToAuction);

		JPanel ControlsPanel = new JPanel();
		add(ControlsPanel);

		JLabel lblEmail = new JLabel("Email:");
		ControlsPanel.add(lblEmail);

		JTextField usernameField = new JTextField();
		ControlsPanel.add(usernameField);
		usernameField.setColumns(10);

		JButton myLoginButton = new JButton("Login");

		myLoginButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				login(usernameField.getText());

			}
		});
		ControlsPanel.add(myLoginButton);

		JPanel bottomPanel = new JPanel();
		add(bottomPanel);

	}

	public void login(String userName){

		User theUser = myData.getUser(userName);
		if(null != theUser){
			if(Bidder.class.equals(theUser.getClass())){
				myMainFrame.loginBidder((Bidder) theUser);
			}else if(ContactPerson.class.equals(theUser.getClass())){
				myMainFrame.loginContact((ContactPerson) theUser);
			}else if(AuctionStaff.class.equals(theUser.getClass())){
				myMainFrame.loginStaff((AuctionStaff) theUser);
			}
		}

	}
}
