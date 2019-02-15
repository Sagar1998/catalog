package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class finalcheckout extends JFrame {

	private JPanel contentPane;
	private JTextField txtThankyouForPurchase;
	public JTextField tf1;
	private JTextField txtTextWillBe;
	private JTextField txtMobileNumber;
	public JTextField tf2;
	private JTextField txtRegardingShippingDetails;
	private JTextField txtOnYourAddress;
	public JTextField tf3;
	private JTextField txtYouOrdered;
	public JTextField tf4;

	
	
	
public finalcheckout(String msg1 , String msg2 , String msg3 , String msg4) {
		
		
		tf1.setText(msg1);
		tf2.setText(msg2);
		tf3.setText(msg3);
		tf4.setText(msg4);
		
		
		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					finalcheckout frame = new finalcheckout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public finalcheckout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtThankyouForPurchase = new JTextField();
		txtThankyouForPurchase.setEditable(false);
		txtThankyouForPurchase.setText("Thankyou for purchase");
		txtThankyouForPurchase.setBounds(6, 34, 170, 26);
		contentPane.add(txtThankyouForPurchase);
		txtThankyouForPurchase.setColumns(10);
		
		tf1 = new JTextField();
		tf1.setEditable(false);
		tf1.setBounds(173, 34, 107, 26);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		txtTextWillBe = new JTextField();
		txtTextWillBe.setEditable(false);
		txtTextWillBe.setText("text will be sent on your");
		txtTextWillBe.setBounds(274, 34, 170, 26);
		contentPane.add(txtTextWillBe);
		txtTextWillBe.setColumns(10);
		
		txtMobileNumber = new JTextField();
		txtMobileNumber.setEditable(false);
		txtMobileNumber.setText("mobile number");
		txtMobileNumber.setBounds(6, 72, 107, 26);
		contentPane.add(txtMobileNumber);
		txtMobileNumber.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setEditable(false);
		tf2.setBounds(110, 72, 130, 26);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		txtRegardingShippingDetails = new JTextField();
		txtRegardingShippingDetails.setEditable(false);
		txtRegardingShippingDetails.setText("regarding shipping details");
		txtRegardingShippingDetails.setBounds(235, 72, 209, 26);
		contentPane.add(txtRegardingShippingDetails);
		txtRegardingShippingDetails.setColumns(10);
		
		txtOnYourAddress = new JTextField();
		txtOnYourAddress.setEditable(false);
		txtOnYourAddress.setText("on your address");
		txtOnYourAddress.setBounds(6, 121, 130, 26);
		contentPane.add(txtOnYourAddress);
		txtOnYourAddress.setColumns(10);
		
		tf3 = new JTextField();
		tf3.setEditable(false);
		tf3.setBounds(132, 121, 292, 62);
		contentPane.add(tf3);
		tf3.setColumns(10);
		
		JButton btnContinueShopping = new JButton("continue shopping");
		btnContinueShopping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if(e.getSource()==btnContinueShopping)
				
					new catalog().setVisible(true);
				
			}
		});
		btnContinueShopping.setBounds(122, 243, 158, 29);
		contentPane.add(btnContinueShopping);
		
		txtYouOrdered = new JTextField();
		txtYouOrdered.setText("you ordered");
		txtYouOrdered.setBounds(6, 188, 88, 26);
		contentPane.add(txtYouOrdered);
		txtYouOrdered.setColumns(10);
		
		tf4 = new JTextField();
		tf4.setBounds(95, 188, 329, 26);
		contentPane.add(tf4);
		tf4.setColumns(10);
	}
}
