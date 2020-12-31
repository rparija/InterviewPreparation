
 class A
{
	 int var=2;
	public void display()
	{
		System.out.println("Print A");
	}
}
 class B extends A
{
	 int var=1;
	public void display() throws RuntimeException
	{
		System.out.println("Print B");
	}
}
public class Accolite {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		System.out.println(((A)b).var);
		((A)b).display();
	}
}

