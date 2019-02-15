package gui;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import com.mysql.jdbc.Connection;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class admin extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JButton btnCustomerLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
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
	public admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(46, 79, 104, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblAdminLogin = new JLabel("Admin Login");
		lblAdminLogin.setBounds(185, 6, 99, 16);
		contentPane.add(lblAdminLogin);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(46, 109, 104, 16);
		contentPane.add(lblNewLabel);
		
		tf1 = new JTextField();
		tf1.setBounds(162, 74, 130, 26);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setBounds(162, 104, 130, 26);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					try {
				String s1 = tf1.getText();
				String s2 = tf2.getText();

					
					
					String url ="jdbc:mysql://localhost:3306/admin1";
					String uname = "root";
					String pass = "root";
					Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
				Statement stmt =con.createStatement();
				ResultSet st = stmt.executeQuery("select * from admin1 order by username desc");
				//PreparedStatement st = con.prepareStatement("select * from login username=?");
				while(st.next())
				{
					
					
					if(s1.equals(st.getObject(1)) && s2.equals(st.getObject(1)))
					{
					tf3.setText("loggedin");
					new admincatalog().setVisible(true);
					}
					else
					{
						tf3.setText("error");
						
					}
				}
				}

					
					catch(Exception e2)
					{
						System.out.println("invalid");
						
						
					}

					
				
			}
		});
		btnLogin.setBounds(46, 215, 117, 29);
		contentPane.add(btnLogin);
		
		tf3 = new JTextField();
		tf3.setEditable(false);
		tf3.setBounds(46, 177, 130, 26);
		contentPane.add(tf3);
		tf3.setColumns(10);
		
		btnCustomerLogin = new JButton("customer login");
		btnCustomerLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(e.getSource()==btnCustomerLogin)
				{
					new login2().setVisible(true);
				}
			
			}
		});
		btnCustomerLogin.setBounds(269, 215, 161, 29);
		contentPane.add(btnCustomerLogin);
	}
}
