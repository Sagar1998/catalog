package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class food extends JFrame {
	int value,value1,value2;

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf_pb;
	private JTextField tf_iw;
	private JTextField tf_sha;
	private JTextField tf_food;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					food frame = new food();
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
	public food() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPavBhajhi = new JButton("PAV BHAJHI");
		btnPavBhajhi.setBounds(152, 27, 117, 29);
		contentPane.add(btnPavBhajhi);
		
		JButton btnIdliWada = new JButton("IDLI WADA");
		btnIdliWada.setBounds(152, 82, 117, 29);
		contentPane.add(btnIdliWada);
		
		JButton btnShawrma = new JButton("SHAWRMA");
		btnShawrma.setBounds(152, 139, 117, 29);
		contentPane.add(btnShawrma);
		
		tf1 = new JTextField();
		tf1.setText("90");
		tf1.setBounds(296, 27, 130, 26);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setText("30");
		tf2.setBounds(296, 82, 130, 26);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		tf3 = new JTextField();
		tf3.setText("50");
		tf3.setBounds(296, 139, 130, 26);
		contentPane.add(tf3);
		tf3.setColumns(10);
		
		final JSpinner spinner = new JSpinner();
		spinner.setBounds(43, 27, 34, 26);
		contentPane.add(spinner);
		
		final JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(43, 82, 34, 26);
		contentPane.add(spinner_1);
		
		final JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(43, 142, 34, 26);
		contentPane.add(spinner_2);
		
		try {
		    spinner.commitEdit();
		    spinner_1.commitEdit();
		    spinner_2.commitEdit();
		} catch ( java.text.ParseException e ) {  }
		
		
		
		
		JButton btnTotal = new JButton("total");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				value = (Integer)spinner.getValue();
				value1 = (Integer)spinner_1.getValue();
				value2 = (Integer)spinner_2.getValue();
				//if(e.getSource()==btnTotal)
				
					int d1 = Integer.parseInt(tf1.getText());
					int i1 = (int)d1;
					int d2 = Integer.parseInt(tf2.getText());
					int i2 = (int)d2;
					int d3 = Integer.parseInt(tf3.getText());
					int i3 = (int)d3;
					
					int temp = ((value*i1)+(value1*i2)+(value2*i3));
					String str1 = String.valueOf(temp); 
					if(value<0 || value1<0 || value2<0 || temp<0)
					{
						tf4.setText("no -ve values allowed");
					}
					else
					tf4.setText(str1);
					
					String pb1 =" Pav Bhajhi(";
					String pb2 = Integer.toString(value);
					String pbf = pb1 + pb2;
					
					String iw1=") IDLI WADA("; 
					String iw2= Integer.toString(value1);
					String iwf= iw1+iw2;
					
					String sha1=") SHAWRMA(";
					String temp1=")";
					String sha2=Integer.toString(value);
					String shaf=sha1+sha2+temp1;
					
					
					tf_pb.setText(pbf);
					tf_iw.setText(iwf);
					tf_sha.setText(shaf);
					
					String foodf=pbf+iwf+shaf;
					tf_food.setText(foodf);
				
				
			}
		});
		btnTotal.setBounds(152, 210, 117, 29);
		contentPane.add(btnTotal);
		
		tf4 = new JTextField();
		tf4.setBounds(152, 251, 130, 26);
		contentPane.add(tf4);
		tf4.setColumns(10);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if(e.getSource()==btnBack)
				
					new catalog().setVisible(true);
					
				
			}
		});
		btnBack.setBounds(6, 251, 117, 29);
		contentPane.add(btnBack);
		
		JButton btnCheckout = new JButton("checkout");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if(e.getSource()==btnCheckout)
				
					String msg = tf4.getText();
					String msg55 = tf_food.getText();
					checkout ob = new checkout();
					if(tf4.getText().equals("") || tf4.getText().equals("0") || tf4.getText().equals("please select your product") || tf4.getText().equals("no -ve values allowed") )
					{
						tf4.setText("please select your product");
					}
					else
					{
						ob.tf4.setText(msg);
						ob.tf_food.setText(msg55);
					ob.setVisible(true);
					}
				
			}
		});
		btnCheckout.setBounds(327, 251, 117, 29);
		contentPane.add(btnCheckout);
		
		tf_pb = new JTextField();
		tf_pb.setBounds(6, 180, 130, 26);
		contentPane.add(tf_pb);
		tf_pb.setVisible(false);
		tf_pb.setColumns(10);
		
		tf_iw = new JTextField();
		tf_iw.setBounds(10, 210, 130, 26);
		tf_iw.setVisible(false);
		contentPane.add(tf_iw);
		tf_iw.setColumns(10);
		
		tf_sha = new JTextField();
		tf_sha.setBounds(314, 180, 130, 26);
		contentPane.add(tf_sha);
		tf_sha.setVisible(false);
		tf_sha.setColumns(10);
		
		tf_food = new JTextField();
		tf_food.setBounds(154, 6, 130, 26);
		contentPane.add(tf_food);
		tf_food.setVisible(false);
		tf_food.setColumns(10);
		
		
		
	}
}
