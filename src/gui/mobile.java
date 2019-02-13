package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JLabel;


public class mobile extends JFrame {
	String iphone="0";
	int value,value1,value2;
	int iph =Integer.parseInt(iphone);
	public JSpinner spinner_1;
	public JSpinner spinner__2;
	public JSpinner spinner_3;
	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tfiph;
	private JTextField tfop6t;
	private JTextField tfs9;
	private JTextField tfmob;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mobile frame = new mobile();
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
	public mobile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIphoneXsMax = new JButton("IPHONE Xs MAX");
		btnIphoneXsMax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
			}
		});
		btnIphoneXsMax.setBounds(130, 23, 163, 29);
		contentPane.add(btnIphoneXsMax);
		
		JButton btnNewButton = new JButton("ONEPLUS 6T");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(130, 87, 163, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SAMSUNG S9+");
		btnNewButton_1.setBounds(130, 155, 163, 29);
		contentPane.add(btnNewButton_1);
		
		tf1 = new JTextField();
		tf1.setEditable(false);
		tf1.setText("79000");
		tf1.setBounds(297, 23, 130, 26);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setEditable(false);
		tf2.setText("39000");
		tf2.setBounds(297, 87, 130, 26);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		tf3 = new JTextField();
		tf3.setEditable(false);
		tf3.setText("69999");
		tf3.setBounds(297, 155, 130, 26);
		contentPane.add(tf3);
		tf3.setColumns(10);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnBack)
				new catalog().setVisible(true);
				
			}
		});
		btnBack.setBounds(27, 226, 117, 29);
		contentPane.add(btnBack);
		
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(48, 23, 34, 26);
		contentPane.add(spinner);
		
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(48, 87, 34, 26);
		contentPane.add(spinner_1);
		
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(48, 155, 34, 26);
		contentPane.add(spinner_2);
		
		try {
		    spinner.commitEdit();
		    spinner_1.commitEdit();
		    spinner_2.commitEdit();
		} catch ( java.text.ParseException e ) {  }
		//value = (Integer)spinner.getValue();
		//value1 = (Integer)spinner_1.getValue();
		//value2 = (Integer)spinner_2.getValue();

		
		JButton btnCheckout = new JButton("CHECKOUT");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				if(e.getSource()==btnCheckout)
				{
					
					
					String msg = tf4.getText();
					String msg11 = tfiph.getText();
					String msg22 = tfop6t.getText();
					String msg33 = tfs9.getText();
					String msg44 = tfmob.getText();
					checkout ob = new checkout();
					ob.tf4.setText(msg);
					ob.tfiph.setText(msg11);
					ob.tfop6t.setText(msg22);
					ob.tfs9.setText(msg33);
					ob.tfmob.setText(msg44);
					if(tf4.getText().equals("") || tf4.getText().equals("0") || tf4.getText().equals("please select your product")|| tf4.getText().equals("no -ve value allowed"))
					{
						tf4.setText("please select your product");
						
						
						
					}
					else
					{
					ob.setVisible(true);
					}
				}
			}
		});
		btnCheckout.setBounds(310, 226, 117, 29);
		contentPane.add(btnCheckout);
		
		tf4 = new JTextField();
		tf4.setEditable(false);
		tf4.setBounds(173, 205, 87, 26);
		contentPane.add(tf4); 
		tf4.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("total");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				value = (Integer)spinner.getValue();
				value1 = (Integer)spinner_1.getValue();
				value2 = (Integer)spinner_2.getValue();
				
				if(e.getSource()==btnNewButton_2)
				{
					int d1 = Integer.parseInt(tf1.getText());
					int i1 = (int)d1;
					int d2 = Integer.parseInt(tf2.getText());
					int i2 = (int)d2;
					int d3 = Integer.parseInt(tf3.getText());
					int i3 = (int)d3;
					
					int temp = ((value*i1)+(value1*i2)+(value2*i3));
					String str1 = String.valueOf(temp); 
					if(value < 0 || value1 <0 || value2 <0 || temp<0)
					{
						tf4.setText("no -ve value allowed");
					}
					else
					tf4.setText(str1);
					
					String i11 =" Iphone XS MAX(";
					String i22 = Integer.toString(value);
					String ipf = i11 + i22;
					
					String op1=") OnePlus 6t("; 
					String op2= Integer.toString(value1);
					String opf= op1+op2;
					
					String s91=") Samsung S9+(";
					String temp1=")";
					String s92=Integer.toString(value);
					String s9f=s91+s92+temp1;
					
					
					tfiph.setText(ipf);
					tfop6t.setText(opf);
					tfs9.setText(s9f);
					
					String ssf=ipf+opf+s9f;
					tfmob.setText(ssf);
					
				}
			}
		});
		btnNewButton_2.setBounds(160, 243, 117, 29);
		contentPane.add(btnNewButton_2);
		
		tfiph = new JTextField();
		tfiph.setEnabled(false);
		tfiph.setEditable(false);
		tfiph.setVisible(false);
		tfiph.setBounds(14, 188, 130, 26);
		contentPane.add(tfiph);
		tfiph.setColumns(10);
		
		tfop6t = new JTextField();
		tfop6t.setEnabled(false);
		tfop6t.setVisible(false);
		tfop6t.setBounds(297, 117, 130, 26);
		contentPane.add(tfop6t);
		tfop6t.setColumns(10);
		
		tfs9 = new JTextField();
		tfs9.setEnabled(false);
		tfs9.setVisible(false);
		tfs9.setBounds(14, 128, 130, 26);
		contentPane.add(tfs9);
		tfs9.setColumns(10);
		
		tfmob = new JTextField();
		tfmob.setBounds(147, 53, 130, 26);
		contentPane.add(tfmob);
		tfmob.setVisible(false);
		tfmob.setColumns(10);
	
	
	
	
	
	}
}
