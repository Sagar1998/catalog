package gui;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class checkout extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	public JTextField tf4;
	private JTextField tf5;
	private JTextField tf6;
	private JTextField textField;
	public JTextField tfiph;
	public JTextField tfop6t;
	public JTextField tfs9;
	public JTextField tfmob;
	public JTextField tf_food;
	public JTextField tf_cloth;
	public JTextField tf_all;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { 
			public void run() {
				try {
					checkout frame = new checkout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
public checkout(String msg , String msg11 , String msg22 , String msg33 , String msg44 ,String msg55 ,String msg66 ) {
		
	    tfiph.setText(msg11);
		tf4.setText(msg);
		tfop6t.setText(msg22);
		tfs9.setText(msg33);
		tfmob.setText(msg44);
		tf_food.setText(msg55);
		tf_cloth.setText(msg66);
		tf_all.setText(msg44+msg55+msg66);
		
		
	}

	/**
	 * Create the frame.
	 */
	public checkout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPlaceOrder = new JButton("place order");
		btnPlaceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String msg1 = tf1.getText();
				String msg2 = tf2.getText();
				String msg3 = tf3.getText();
				String msg4 = tf4.getText();
				String msg5 = tf5.getText();
				String msg6 = tf6.getText();
				String msg7 = tfmob.getText();
				String msg8 = tf_food.getText();
				String msg9 = tf_cloth.getText();
				
				
				
				if(tf1.getText().equals("") || tf2.getText().equals("") || tf3.getText().equals("") || tf4.getText().equals("") || tf5.getText().equals("") || tf6.getText().equals("") || textField.getText().equals("please enter the details correctly"))
				{
					textField.setText("please enter the details correctly");
				}
				else
				{
				try
				{
					String url ="jdbc:mysql://localhost:3306/details";
					String uname = "root";
					String pass = "12345678";
					Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
					PreparedStatement stmt=con.prepareStatement("insert into details values(?,?,?,?,?,?,?,?,?,?)");  

					
					
					stmt.setString(1, null);
					stmt.setString(2, msg1);
					stmt.setString(3, msg2);
					stmt.setString(4, msg3);
					stmt.setString(5, msg5);
					stmt.setString(6, msg6);
					stmt.setString(7, msg4);
					stmt.setString(8, msg7); 
					stmt.setString(9, msg8);
					stmt.setString(10, msg9);
					stmt.execute();
				}
				catch(Exception e2) {
					
					System.out.println("ERROR");
					
				}
				finalcheckout ob = new finalcheckout();
				ob.tf1.setText(msg1);
				ob.tf2.setText(msg2);
				ob.tf3.setText(msg3+msg5+msg6);
				ob.tf4.setText(msg7+msg8+msg9);
				ob.setVisible(true);
				}
			}
		});
		btnPlaceOrder.setBounds(310, 243, 117, 29);
		contentPane.add(btnPlaceOrder);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btnBack)
				{
					new mobile().setVisible(true);
				}
			}
		});
		btnBack.setBounds(26, 243, 117, 29);
		contentPane.add(btnBack);
		
		JLabel lblTotal = new JLabel("total");
		lblTotal.setBounds(192, 228, 61, 16);
		contentPane.add(lblTotal);
		
		tf1 = new JTextField();
		tf1.setBounds(159, 26, 130, 26);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(63, 31, 61, 16);
		contentPane.add(lblName);
		
		JLabel lblPhNo = new JLabel("Ph No:");
		lblPhNo.setBounds(63, 59, 61, 16);
		contentPane.add(lblPhNo);
		
		tf2 = new JTextField();
		tf2.setBounds(159, 54, 130, 26);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address 1:");
		lblAddress.setBounds(52, 87, 72, 16);
		contentPane.add(lblAddress);
		
		tf3 = new JTextField();
		tf3.setBounds(159, 82, 130, 26);
		contentPane.add(tf3);
		tf3.setColumns(10);
		
		JLabel lblPaymentMethod = new JLabel("Payment Method:");
		lblPaymentMethod.setBounds(6, 201, 118, 16);
		contentPane.add(lblPaymentMethod);
		
		JRadioButton rdbtnCod = new JRadioButton("COD");
		rdbtnCod.setBounds(112, 198, 141, 23);
		contentPane.add(rdbtnCod);
		
		JRadioButton rdbtnCcdc = new JRadioButton("CC/DC");
		rdbtnCcdc.setBounds(192, 198, 141, 23);
		contentPane.add(rdbtnCcdc);
		
		JRadioButton rdbtnUpipaytm = new JRadioButton("UPI/Paytm");
		rdbtnUpipaytm.setBounds(279, 198, 141, 23);
		contentPane.add(rdbtnUpipaytm);
		
		tf4 = new JTextField();
		tf4.setEditable(false);
		tf4.setBounds(160, 246, 130, 26);
		contentPane.add(tf4);
		tf4.setColumns(10);
		
		JLabel lblAddress_1 = new JLabel("Address 2:");
		lblAddress_1.setBounds(52, 115, 72, 16);
		contentPane.add(lblAddress_1);
		
		tf5 = new JTextField();
		tf5.setBounds(159, 110, 130, 26);
		contentPane.add(tf5);
		tf5.setColumns(10);
		
		JLabel lblState = new JLabel("State");
		lblState.setBounds(52, 143, 61, 16);
		contentPane.add(lblState);
		
		tf6 = new JTextField();
		tf6.setBounds(159, 138, 130, 26);
		contentPane.add(tf6);
		tf6.setColumns(10);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(310, 82, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		tfiph = new JTextField();
		tfiph.setEnabled(false);
		tfiph.setVisible(false);
		tfiph.setBounds(310, 138, 130, 26);
		contentPane.add(tfiph);
		tfiph.setColumns(10);
		
		tfop6t = new JTextField();
		tfop6t.setEditable(false);
		tfop6t.setVisible(false);
		tfop6t.setEnabled(false);
		tfop6t.setBounds(310, 26, 130, 26);
		contentPane.add(tfop6t);
		tfop6t.setColumns(10);
		
		tfs9 = new JTextField();
		tfs9.setEnabled(false);
		tfs9.setVisible(false);
		tfs9.setBounds(310, 176, 130, 26);
		contentPane.add(tfs9);
		tfs9.setColumns(10);
		
		tfmob = new JTextField();
		tfmob.setBounds(13, 163, 130, 26);
		contentPane.add(tfmob);
		tfmob.setVisible(false);
		tfmob.setColumns(10);
		
		tf_food = new JTextField();
		tf_food.setBounds(159, 176, 130, 26);
		contentPane.add(tf_food);
		tf_food.setVisible(false);
		tf_food.setColumns(10);
		
		tf_cloth = new JTextField();
		tf_cloth.setBounds(297, 54, 130, 26);
		contentPane.add(tf_cloth);
		tf_cloth.setVisible(false);
		tf_cloth.setColumns(10);
		
		tf_all = new JTextField();
		tf_all.setBounds(26, 0, 401, 26);
		tf_all.setVisible(false);
		contentPane.add(tf_all);
		tf_all.setColumns(10);
	}
	public JTextField getTextField_3() {
		return tf4;
	}
}
