package multithreading;

public class ValueClass {

	int value=0;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	public synchronized int increment()
	{
		return value+1;
	}
}
