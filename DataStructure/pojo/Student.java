package pojo;

public class Student {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + rollNumber;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (rollNumber != other.rollNumber)
			return false;
		return true;
	}
	int rollNumber;
	String Name;
	public Student(int rollNumber, String name) {
		super();
		this.rollNumber = rollNumber;
		Name = name;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", Name=" + Name + "]";
	}
	
	public Student getInstance()
	{
		return new Student();
	}
}
