package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class admincatalog extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admincatalog frame = new admincatalog();
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
	public admincatalog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminPortal = new JLabel("Admin Portal");
		lblAdminPortal.setBounds(177, 6, 91, 16);
		contentPane.add(lblAdminPortal);
		
		JButton btnCheckOrders = new JButton("Check Orders");
		btnCheckOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if(e.getSource()==btnCheckOrders)
				
					new checkorder().setVisible(true);
				
				
			}
		});
		btnCheckOrders.setBounds(151, 57, 117, 29);
		contentPane.add(btnCheckOrders);
		
		JButton btnDeleteUser = new JButton("edit user");
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if(e.getSource()==btnDeleteUser)
				
					new editordelete().setVisible(true);
					
				
				
			}
		});
		btnDeleteUser.setBounds(151, 138, 117, 29);
		contentPane.add(btnDeleteUser);
		
		JButton btnViewAllUsers = new JButton("View All Users");
		btnViewAllUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if(e.getSource()==btnViewAllUsers)
				
					new viewallusers().setVisible(true);
				
			}
			
			
		});
		btnViewAllUsers.setBounds(151, 227, 117, 29);
		contentPane.add(btnViewAllUsers);
	}

}
