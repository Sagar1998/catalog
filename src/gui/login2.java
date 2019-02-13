//package login;
package gui;
import java.awt.*;

import java.sql.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;
import java.awt.event.*;
public class login2 extends Frame implements ActionListener{
	
	
	public void close() {
		
		WindowEvent winclose = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winclose);
		
	}
	
	
Button b1,b2,b3,b4;
TextField tf1,tf2,tf3;
Label l1,l2,l3,l4;
Checkbox c1;
login2(){

Frame f = new Frame("CHECK PAGE");
l3=new Label("");
l4=new Label("");
l3.setBounds(10,10,50,50);
l4.setBounds(90,10,50,50);
b4 = new Button("ADMIN LOGIN");
b4.setBounds(300,300,100,50);
b4.addActionListener(this);
b3 = new Button("SIGNUP");
b3.setBounds(300,200,100,50);
b3.addActionListener(this);
l1=new Label("UserName :");
l2=new Label("PASSWORD :");
tf3=new TextField("");
tf3.setBounds(50,250,300,30);
tf3.setEditable(false);
l1.setBounds(50,100,100,30);
l2.setBounds(50,150,100,30);
b1 = new Button("CHECK");
b2 = new Button("Clear");
b1.setBounds(50,200,50,50);
b2.setBounds(120,200,50,50);
tf1=new TextField("");
tf1.setBounds(150,100,100,30);
tf2 = new TextField("");
tf2.setBounds(150,150,100,30);
b1.addActionListener(this);
b2.addActionListener(this);
c1= new Checkbox("REMEMBER ME");
c1.setBounds(300,50,50,50);
f.add(l4);
f.add(b4);
f.add(l3);
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
	if(e.getSource()==b1){
	try {
String s1 = tf1.getText();
String s2 = tf2.getText();

	
	
	String url ="jdbc:mysql://localhost:3306/login";
	String uname = "root";
	String pass = "12345678";
	Connection con = (Connection) DriverManager.getConnection(url,uname,pass);
Statement stmt =con.createStatement();
ResultSet st = stmt.executeQuery("select * from login order by username desc");
//PreparedStatement st = con.prepareStatement("select * from login username=?");
while(st.next())
{
	
	
	if(s1.equals(st.getObject(2)) && s2.equals(st.getObject(3)))
	{
	tf3.setText("loggedin");
	new catalog().setVisible(true);
	}
	else
	{
		tf3.setText("error");
		
	}
}
}

	
	catch(Exception e1)
	{
		System.out.println("invalid");
		
		
	}

	}
	else if(e.getSource()==b2)
{
tf1.setText("");
tf2.setText("");
tf3.setText("");
}
else if(e.getSource()==b3)
{
	
	new login().setVisible(true);
	
}
else if(e.getSource()==b4)
{
	new admin().setVisible(true);
}
}
public static void main(String [] args){
new login2();
}
}