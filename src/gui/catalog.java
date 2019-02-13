package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class catalog extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					catalog frame = new catalog();
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
	public catalog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("electronics");
		btnNewButton.setIcon(new ImageIcon("/Users/sagarkuvar/Downloads/laptop1.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton)
				{
					new mobile().setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(6, 6, 203, 180);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("clothing");
		btnNewButton_1.setIcon(new ImageIcon("/Users/sagarkuvar/Downloads/cloths.jpeg"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btnNewButton_1)
				{
					new clothing().setVisible(true);
					
				}
				
				
			}
		});
		btnNewButton_1.setBounds(265, 6, 185, 180);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("food");
		btnNewButton_2.setIcon(new ImageIcon("/Users/sagarkuvar/Downloads/food.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btnNewButton_2)
				{
					new food().setVisible(true);
				}
			}
		});
		btnNewButton_2.setBounds(175, 186, 117, 86);
		contentPane.add(btnNewButton_2);
	}

}
