package gui;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import com.mysql.jdbc.Connection;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class checkorder extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf_n;
	private JLabel lblName;
	private JLabel lblAddress;
	private JLabel lblAddress_1;
	private JTextField tf_a1;
	private JTextField tf_a2;
	private JLabel lblPhno;
	private JTextField tf_phno;
	private JLabel lblTotal;
	private JTextField tf_st;
	private JLabel lblTotal_1;
	private JTextField tf_t;
	private JButton btnBack;
	private JLabel lblNewLabel;
	private JTextField tf_det;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkorder frame = new checkorder();
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
	public checkorder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterYourOrder = new JLabel("Enter your order ID:");
		lblEnterYourOrder.setBounds(6, 6, 139, 16);
		contentPane.add(lblEnterYourOrder);
		
		tf1 = new JTextField();
		tf1.setBounds(157, 1, 130, 26);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf_n = new JTextField();
		tf_n.setEditable(false);
		tf_n.setBounds(6, 72, 124, 29);
		contentPane.add(tf_n);
		tf_n.setColumns(10);
		
		JButton btnCheck = new JButton("check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if(e.getSource()==btnCheck)
				
					try { 
						String url ="jdbc:mysql://localhost:3306/details";
						String uname = "root";
						String pass = "root";
						Connection conn = (Connection) DriverManager.getConnection(url,uname,pass);
				        String sql = "SELECT name,phno,address1,address2,state,total,mobile,food,cloth FROM users WHERE o_id = ?";
				        PreparedStatement pst = conn.prepareStatement(sql);
				        pst.setString(1,tf1.getText());

				        ResultSet rs = pst.executeQuery();
				    if(rs.next()) { 
				        String name = rs.getString("name");
				        tf_n.setText(name);
				        String phno = rs.getString("phno");
				        tf_phno.setText(phno);
				        String a1 = rs.getString("address1");
				        tf_a1.setText(a1);
				        String a2 = rs.getString("address2");
				        tf_a2.setText(a2);
				        String state = rs.getString("state");
				        tf_st.setText(state);
				        String total = rs.getString("total");
				        tf_t.setText(total);
				        String details =rs.getString("mobile");
				        String details1 =rs.getString("food");
				        String details2 = rs.getString("cloth");
				      tf_det.setText(details+details1+details2);

				    }
				    } catch (SQLException e4 ) {
				    System.out.println("ERROR");

				}
				
			}
		});
		btnCheck.setBounds(167, 24, 117, 29);
		contentPane.add(btnCheck);
		
		lblName = new JLabel("name");
		lblName.setBounds(34, 48, 61, 16);
		contentPane.add(lblName);
		
		lblAddress = new JLabel("address1");
		lblAddress.setBounds(192, 48, 61, 16);
		contentPane.add(lblAddress);
		
		lblAddress_1 = new JLabel("address2");
		lblAddress_1.setBounds(352, 48, 61, 16);
		contentPane.add(lblAddress_1);
		
		tf_a1 = new JTextField();
		tf_a1.setBounds(157, 73, 130, 26);
		contentPane.add(tf_a1);
		tf_a1.setColumns(10);
		
		tf_a2 = new JTextField();
		tf_a2.setBounds(314, 73, 130, 26);
		contentPane.add(tf_a2);
		tf_a2.setColumns(10);
		
		lblPhno = new JLabel("phno");
		lblPhno.setBounds(34, 114, 61, 16);
		contentPane.add(lblPhno);
		
		tf_phno = new JTextField();
		tf_phno.setBounds(6, 142, 130, 26);
		contentPane.add(tf_phno);
		tf_phno.setColumns(10);
		
		lblTotal = new JLabel("state");
		lblTotal.setBounds(192, 111, 61, 16);
		contentPane.add(lblTotal);
		
		tf_st = new JTextField();
		tf_st.setBounds(157, 142, 130, 26);
		contentPane.add(tf_st);
		tf_st.setColumns(10);
		
		lblTotal_1 = new JLabel("total");
		lblTotal_1.setBounds(352, 111, 61, 16);
		contentPane.add(lblTotal_1);
		
		tf_t = new JTextField();
		tf_t.setBounds(314, 142, 130, 26);
		contentPane.add(tf_t);
		tf_t.setColumns(10);
		
		btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btnBack)
				{
					new admincatalog().setVisible(true);
				}
			}
		});
		btnBack.setBounds(156, 243, 117, 29);
		contentPane.add(btnBack);
		
		lblNewLabel = new JLabel("Details");
		lblNewLabel.setBounds(192, 180, 61, 16);
		contentPane.add(lblNewLabel);
		
		tf_det = new JTextField();
		tf_det.setBounds(6, 200, 438, 44);
		contentPane.add(tf_det);
		tf_det.setColumns(10);
	}

}
