package corejava.override;

public class B extends A{

	
	@Override
	public void sum(int x, int y)
	{
		System.out.println("sum: "+(x+y));
	}
}
