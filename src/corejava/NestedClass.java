package corejava;

public class NestedClass {

	int num1=0;
	static int num2=2;
	static class SampleNestedClass
	{
		final int num1=5;
		static int num4=4;

		NestedClass nc = new NestedClass();
		public void print()
		{
			System.out.println("Outer Class num1"+nc.num1);
			System.out.println("Outer Class num2"+NestedClass.num2);

			System.out.println("Nested Class num1"+this.num1);
			System.out.println("Nested Class num4"+SampleNestedClass.num4);
		}
	}
	 class SampleInnerClass
	{
		 //static int i=0; we cannot have static variable in a non static Inner class
		final int i=0;
		int num3=1;
		final int num2=3;
		SampleNestedClass snc= new SampleNestedClass();
		
		public void print()
		{
			System.out.println("Inner Class num3"+num3);
			System.out.println("Outer Class num1"+NestedClass.this.num1);
			System.out.println("Inner Class num2"+this.num2);
			System.out.println("Outer Class num2"+NestedClass.num2);

			System.out.println("Nested Class num1"+snc.num1);
			System.out.println("Nested Class num4"+SampleNestedClass.num4);
		}
		}
	 
	 public void sampleMethod()
	 {
		 NestedClass nc= new NestedClass();
		 //Inner class can also be accessed by creating object of it
		 SampleInnerClass sic= new SampleInnerClass();
		 System.out.println(sic.i);
		 NestedClass.SampleInnerClass sc= nc.new SampleInnerClass();
		 int i=sc.i;
		 sc.print();
		 NestedClass.SampleNestedClass snc= new NestedClass.SampleNestedClass();
		 snc.print();
		 final int j=0;
		 class SampleLocalClass
		 {
			 
		 }
	 }
	 public static void main(String[] args) {
		 NestedClass nc= new NestedClass();
		 nc.sampleMethod();
		 }
}
