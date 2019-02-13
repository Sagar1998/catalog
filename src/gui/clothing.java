package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class clothing extends JFrame {
	
	int value,value1,value2;

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf_cloth;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clothing frame = new clothing();
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
	public clothing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLecooper = new JLabel("Le-Cooper");
		lblLecooper.setBounds(173, 22, 100, 16);
		contentPane.add(lblLecooper);
		
		JLabel lblNike = new JLabel("Nike");
		lblNike.setBounds(173, 77, 61, 16);
		contentPane.add(lblNike);
		
		JLabel lblAddidas = new JLabel("Addidas");
		lblAddidas.setBounds(173, 123, 61, 16);
		contentPane.add(lblAddidas);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(64, 17, 34, 26);
		//int value = (Integer)spinner.getValue();
		contentPane.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(64, 72, 34, 26);
		//int value1= (Integer)spinner_1.getValue();
		contentPane.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(64, 118, 34, 26);
		//int value2= (Integer)spinner_2.getValue();
		contentPane.add(spinner_2);
		
		try {
		    spinner.commitEdit();
		    spinner_1.commitEdit();
		    spinner_2.commitEdit();
		} catch ( java.text.ParseException e ) {  }
		
		tf1 = new JTextField();
		tf1.setEditable(false);
		tf1.setText("590");
		tf1.setBounds(295, 17, 130, 26);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setEditable(false);
		tf2.setText("1200");
		tf2.setBounds(295, 72, 130, 26);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		tf3 = new JTextField();
		tf3.setEditable(false);
		tf3.setText("800");
		tf3.setBounds(295, 118, 130, 26);
		contentPane.add(tf3);
		tf3.setColumns(10);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnBack)
				{
					new catalog().setVisible(true);
				}
			}
		});
		btnBack.setBounds(24, 191, 117, 29);
		contentPane.add(btnBack);
		
		tf4 = new JTextField();
		tf4.setEditable(false);
		tf4.setBounds(153, 233, 130, 26);
		contentPane.add(tf4);
		tf4.setColumns(10);
		
		JButton btnTotal = new JButton("total");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				value = (Integer)spinner.getValue();
				value1 = (Integer)spinner_1.getValue();
				value2 = (Integer)spinner_2.getValue();
				if(e.getSource()==btnTotal)
				{
					int d1 = Integer.parseInt(tf1.getText());
					int i1 = (int)d1;
					int d2 = Integer.parseInt(tf2.getText());
					int i2 = (int)d2;
					int d3 = Integer.parseInt(tf3.getText());
					int i3 = (int)d3;
					
					int temp = ((value*i1)+(value1*i2)+(value2*i3));
					String str1 = String.valueOf(temp); 
					if(value<0 || value1 <0 || value2<0 || temp <0)
					{
						tf4.setText("no -ve values allowed");
						
					}
					else
					tf4.setText(str1);
					String le1 ="Lee-Cooper (";
					String le2=Integer.toString(value);
					String lef=le1+le2;
					
					String nike1=")	Nike (";
					String nike2=Integer.toString(value1);
					String nikef=nike1+nike2;
					
					
					String add1=") Addidas (";
					String add2=Integer.toString(value2);
					String temp3=")";
					String addf=add1+add2+temp3;
					
					String clothfinal=lef+nikef+addf;
					tf_cloth.setText(clothfinal);
				}
			}
		});
		btnTotal.setBounds(161, 191, 100, 29);
		contentPane.add(btnTotal);
		
		JButton btnCheckout = new JButton("checkout");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnCheckout)
				{
					String msg = tf4.getText();
					String msg66 = tf_cloth.getText();
					checkout ob = new checkout();
					if(tf4.getText().equals("") || tf4.getText().equals("0") || tf4.getText().equals("please select your product") || tf4.getText().equals("no -ve values allowed"))
					{
					tf4.setText("please select your product");
					}
					else
					{
					ob.tf4.setText(msg);
					ob.tf_cloth.setText(msg66);
					ob.setVisible(true);
					}
					}
			}
		});
		btnCheckout.setBounds(308, 191, 117, 29);
		contentPane.add(btnCheckout);
		
		tf_cloth = new JTextField();
		tf_cloth.setBounds(6, 153, 130, 26);
		contentPane.add(tf_cloth);
		tf_cloth.setVisible(false);
		tf_cloth.setColumns(10);
	}

}
