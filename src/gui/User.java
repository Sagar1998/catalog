package gui;

public class User {

	
	public int o_id;
	private String name,phno,address1,address2,state,total,mobile,food,cloth;
	
	public User(int o_id,String name,String phno,String address1,String address2,String state,String total,String mobile,String food,String cloth)
	{
		this.o_id=o_id;
		this.name=name;
		this.phno=phno;
		this.address1=address1;
		this.address2=address2;
		this.state=state;
		this.total=total;
		this.mobile=mobile;
		this.food=food;
		this.cloth=cloth;
	}
	
	public int geto_id()

	{
		return o_id;
	}
	
	public String getname()

	{
		return name;
	}
	public String getphno()

	{
		return phno;
	}
	public String getaddress1()

	{
		return address1;
	}
	public String getaddress2()

	{
		return address2;
	}
	public String getstate()

	{
		return state;
	}
	public String gettotal()

	{
		return total;
	}
	public String getmobile()

	{
		return mobile;
	}
	public String getfood()

	{
		return food;
	}
	public String getcloth()

	{
		return cloth;
	}
}
