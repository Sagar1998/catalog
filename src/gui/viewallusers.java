package gui;

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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class viewallusers extends JFrame {
	
	static int i=0;
	static String s = Integer.toString(i);

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewallusers frame = new viewallusers();
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
	public viewallusers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterUsername = new JLabel("Username:");
		lblEnterUsername.setBounds(51, 17, 102, 16);
		contentPane.add(lblEnterUsername);
		
		tf1 = new JTextField();
		tf1.setBounds(151, 12, 130, 26);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setBounds(151, 68, 130, 26);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(51, 73, 61, 16);
		contentPane.add(lblPassword);
		
		JButton btnNext = new JButton("next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if(e.getSource()==btnNext)
				
					++i;
			        if(i>=6)
			        i=5;
			        
			       // tf_id.setText(s);
			       
					try {
						String url ="jdbc:mysql://localhost:3306/login";
						String uname = "root";
						String pass = "root";
						Connection conn = (Connection) DriverManager.getConnection(url,uname,pass);
				        String sql = "SELECT username,password FROM login WHERE id = ?";
				        PreparedStatement pst = conn.prepareStatement(sql);
				        pst.setInt(1,i);

				        ResultSet rs = pst.executeQuery();
				    if(rs.next()) { 
				        String username = rs.getString("username");
				        tf1.setText(username);
				        String password = rs.getString("password");
				        tf2.setText(password);
				        

				    }
				    } catch (SQLException e4 ) {
				    System.out.println("ERROR");

				}
				
			}
		});
		btnNext.setBounds(301, 141, 117, 29);
		contentPane.add(btnNext);
		
		JButton btnPrevious = new JButton("previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if(e.getSource()==btnPrevious)
				
					
					--i;
			        if(i<1)
			        	i=1;
			      //  tf_id.setText(s);
					try {
						String url ="jdbc:mysql://localhost:3306/login";
						String uname = "root";
						String pass = "root";
						Connection conn = (Connection) DriverManager.getConnection(url,uname,pass);
				        String sql = "SELECT username,password FROM login WHERE id = ?";
				        PreparedStatement pst = conn.prepareStatement(sql);
				        pst.setInt(1,i);

				        ResultSet rs = pst.executeQuery();
				    if(rs.next()) { 
				        String username = rs.getString("username");
				        tf1.setText(username);
				        String password = rs.getString("password");
				        tf2.setText(password);
				        
				       

				    }
				    } catch (SQLException e4 ) {
				    System.out.println("ERROR");

				}
				
				
			}
		});
		btnPrevious.setBounds(6, 141, 117, 29);
		contentPane.add(btnPrevious);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if(e.getSource()==btnBack)
				
					new admincatalog().setVisible(true);
				
				
			}
		});
		btnBack.setBounds(151, 232, 117, 29);
		contentPane.add(btnBack);
	}
}
