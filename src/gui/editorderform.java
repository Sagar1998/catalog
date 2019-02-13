package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class editorderform extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf_n;
	private JTextField tf_a1;
	private JTextField tf_a2;
	private JTextField tf_phno;
	private JTextField tf_st;
	private JTextField tf_t;
	private JTextField tf_mob;
	private JTextField tf_food;
	private JLabel lblCloth;
	private JTextField tf_cloth;
	private JTextField tfdone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editorderform frame = new editorderform();
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
	public editorderform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOrderNo = new JLabel("Order No:");
		lblOrderNo.setBounds(6, 21, 61, 16);
		contentPane.add(lblOrderNo);
		
		tf1 = new JTextField();
		tf1.setBounds(79, 16, 130, 26);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		JLabel lblName = new JLabel("name:");
		lblName.setBounds(6, 59, 61, 16);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("address1");
		lblAddress.setBounds(6, 98, 61, 16);
		contentPane.add(lblAddress);
		
		JLabel lblAddress_1 = new JLabel("address2");
		lblAddress_1.setBounds(6, 126, 61, 16);
		contentPane.add(lblAddress_1);
		
		JLabel lblPhno = new JLabel("phno");
		lblPhno.setBounds(6, 164, 61, 16);
		contentPane.add(lblPhno);
		
		JLabel lblState = new JLabel("state");
		lblState.setBounds(6, 203, 61, 16);
		contentPane.add(lblState);
		
		JLabel lblCost = new JLabel("total");
		lblCost.setBounds(6, 240, 61, 16);
		contentPane.add(lblCost);
		
		tf_n = new JTextField();
		tf_n.setBounds(79, 54, 130, 26);
		contentPane.add(tf_n);
		tf_n.setColumns(10);
		
		tf_a1 = new JTextField();
		tf_a1.setBounds(79, 93, 130, 26);
		contentPane.add(tf_a1);
		tf_a1.setColumns(10);
		
		tf_a2 = new JTextField();
		tf_a2.setBounds(79, 126, 130, 26);
		contentPane.add(tf_a2);
		tf_a2.setColumns(10);
		
		tf_phno = new JTextField();
		tf_phno.setBounds(79, 164, 130, 26);
		contentPane.add(tf_phno);
		tf_phno.setColumns(10);
		
		tf_st = new JTextField();
		tf_st.setBounds(79, 198, 130, 26);
		contentPane.add(tf_st);
		tf_st.setColumns(10);
		
		tf_t = new JTextField();
		tf_t.setBounds(79, 235, 130, 26);
		contentPane.add(tf_t);
		tf_t.setColumns(10);
		
		JButton btnSubmit = new JButton("submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btnSubmit)
				{
					try
					{
						String url ="jdbc:mysql://localhost:3306/details"; 
						String uname = "root";
						String pass = "12345678";
						Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
						
					    
						PreparedStatement update=con.prepareStatement("insert into details  values(?,?,?,?,?,?,?,?,?,?)");
						String id = tf1.getText();
						String name = tf_n.getText();
						String phno = tf_phno.getText();
						String ad1 = tf_a1.getText();
						String ad2 = tf_a2.getText();
						String state = tf_st.getText();
						String total = tf_t.getText();
						String detail = tf_mob.getText();
						String food = tf_food.getText();
						String cloth = tf_cloth.getText();
						
						update.setString(1, id);
						update.setString(2, name);
						update.setString(3, phno);
						update.setString(4, ad1);
						update.setString(5, ad2);
						update.setString(6, state);
						update.setString(7, total);
						update.setString(8, detail);
						update.setString(9, food);
						update.setString(10,cloth);
						update.executeUpdate();
						
						tfdone.setText("DONE");
					
						
					}
					catch(Exception e2) {
						
						System.out.println("ERROR");
						tfdone.setText("user already presented");
						
					}
				}
				
			}
		});
		btnSubmit.setBounds(239, 235, 117, 29);
		contentPane.add(btnSubmit);
		
		JLabel lblDetails = new JLabel("mobile");
		lblDetails.setBounds(303, 21, 61, 16);
		contentPane.add(lblDetails);
		
		tf_mob = new JTextField();
		tf_mob.setBounds(220, 49, 224, 26);
		contentPane.add(tf_mob);
		tf_mob.setColumns(10);
		
		JLabel lblFood = new JLabel("food");
		lblFood.setBounds(295, 98, 61, 16);
		contentPane.add(lblFood);
		
		tf_food = new JTextField();
		tf_food.setBounds(221, 126, 223, 26);
		contentPane.add(tf_food);
		tf_food.setColumns(10);
		
		lblCloth = new JLabel("cloth");
		lblCloth.setBounds(278, 164, 61, 16);
		contentPane.add(lblCloth);
		
		tf_cloth = new JTextField();
		tf_cloth.setBounds(221, 198, 223, 26);
		contentPane.add(tf_cloth);
		tf_cloth.setColumns(10);
		
		tfdone = new JTextField();
		tfdone.setEditable(false);
		tfdone.setBounds(576, 126, 130, 26);
		contentPane.add(tfdone);
		tfdone.setColumns(10);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btnBack)
				{
					new deleteuser().setVisible(true); 
				}
				
			}
		});
		btnBack.setBounds(368, 235, 117, 29);
		contentPane.add(btnBack);
		
		
	}
}
