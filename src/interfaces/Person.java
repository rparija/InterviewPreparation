package interfaces;

import java.util.Date;

public class Person implements Cloneable {

	String name;
	Date dob; 
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person (String name, Date dob)
	{
		this.name=name;
		this.dob=dob;
	}
	@Override
	protected Person clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Person p= (Person)super.clone();
		p.dob=(Date) this.dob.clone();
		return p;
	}
	
	@Override
	public String toString() {
		String s="Person Name"+name+"Person Dob"+dob;
		return s;
	}
}
