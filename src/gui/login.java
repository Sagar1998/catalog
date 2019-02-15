//package login;
package gui;
import java.sql.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;

//import com.mysql.jdbc.CallableStatement;
//import com.mysql.jdbc.Connection;
public class login extends Frame implements ActionListener{
Button b1,b2,b3;
TextField tf1,tf2,tf3;
Label l1,l2;
Checkbox c1;
public void close() {
	
	WindowEvent winclose = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winclose);
	
}
login(){
	close();
Frame f = new Frame("Sign-Up PAGE");
b3= new Button("LOGIN");
b3.setBounds(350,200,50,50);
l1=new Label("UserName :");
l2=new Label("PASSWORD :");
tf3=new TextField("");
tf3.setBounds(50,250,300,30);
tf3.setEditable(false);
l1.setBounds(50,100,100,30);
l2.setBounds(50,150,100,30);
b1 = new Button("Login");
b2 = new Button("Clear");
b1.setBounds(50,200,50,50);
b2.setBounds(120,200,50,50);
tf1=new TextField();
tf1.setBounds(200,100,100,30);
tf2 = new TextField();
tf2.setBounds(200,150,100,30);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
c1= new Checkbox("REMEMBER ME");
c1.setBounds(300,50,50,50);
f.add(b3);
f.add(c1);
f.add(l1);
f.add(l2);
f.add(tf1);
f.add(tf2);
f.add(tf3);
f.add(b1);
f.add(b2);
f.setSize(400,400);
f.setLayout(null);
f.setVisible(true);
}
public void actionPerformed(ActionEvent e){
String s1 = tf1.getText();
String s2 = tf2.getText();




if(e.getSource()==b1){
	try
	{
		String url ="jdbc:mysql://localhost:3306/login";
		String uname = "root";
		String pass = "root";
		Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
		PreparedStatement stmt=con.prepareStatement("insert into login values(?,?,?)");  

		
		
		stmt.setString(1, null);
		stmt.setString(2, s1);
		stmt.setString(3, s2);
		stmt.execute();
	}
	catch(Exception e1) {
		
		System.out.println("ERROR");
		
	}
	tf3.setText("USERNAME SAVED");
	new catalog().setVisible(true);


}
else if(e.getSource()==b2)
{
tf1.setText("");
tf2.setText("");
tf3.setText("");
}
else if(e.getSource()==b3)
{
	new login2().setVisible(true);
}
}
public static void main(String [] args){
new login();
}
}