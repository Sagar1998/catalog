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

public class deleteuser extends JFrame {

	private JPanel contentPane;
	private JTextField tf_n;
	private JTextField tf_phno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteuser frame = new deleteuser();
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
	public deleteuser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterName = new JLabel("Enter Name:");
		lblEnterName.setBounds(6, 26, 97, 16);
		contentPane.add(lblEnterName);
		
		tf_n = new JTextField();
		tf_n.setBounds(136, 21, 130, 26);
		contentPane.add(tf_n);
		tf_n.setColumns(10);
		
		JLabel lblYourPhoneNumber = new JLabel("Phone Number");
		lblYourPhoneNumber.setBounds(6, 83, 130, 16);
		contentPane.add(lblYourPhoneNumber);
		
		tf_phno = new JTextField();
		tf_phno.setEditable(false);
		tf_phno.setBounds(136, 78, 130, 26);
		contentPane.add(tf_phno);
		tf_phno.setColumns(10);
		
		JButton btnCheck = new JButton("check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if(e.getSource()==btnCheck)
				
					try { 
						String url ="jdbc:mysql://localhost:3306/details";
						String uname = "root";
						String pass = "root";
						Connection conn = (Connection) DriverManager.getConnection(url,uname,pass);
				        String sql = "SELECT phno FROM details WHERE name = ?";
				        PreparedStatement pst = conn.prepareStatement(sql);
				        pst.setString(1,tf_n.getText());

				        ResultSet rs = pst.executeQuery();
				    if(rs.next()) { 
				       
				        String phno = rs.getString("phno");
				        tf_phno.setText(phno);
				       
				        

				    }
				    } catch (SQLException e4 ) {
				    System.out.println("ERROR");

				}
				
			}
		});
		btnCheck.setBounds(303, 21, 117, 29);
		contentPane.add(btnCheck);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if(e.getSource()==btnBack)
				
					new editordelete().setVisible(true);
				
				
				
			}
		});
		btnBack.setBounds(303, 196, 117, 29);
		contentPane.add(btnBack);
		
		JButton btnEdit1 = new JButton("edit");
		btnEdit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if(e.getSource()==btnEdit1)
				
					try { 
						String url ="jdbc:mysql://localhost:3306/details";
						String uname = "root";
						String pass = "root";
						Connection conn = (Connection) DriverManager.getConnection(url,uname,pass);
				        String sql = "DELETE from details where name=?";
				        PreparedStatement pst = conn.prepareStatement(sql);
				        pst.setString(1,tf_n.getText());

				        pst.executeUpdate();
				    
				        

				    
				    } catch (SQLException e4 ) {
				    System.out.println("ERROR");

				    }
					new editorderform().setVisible(true);
				
			}
		});
		btnEdit1.setBounds(19, 196, 117, 29);
		contentPane.add(btnEdit1);
	}
}
