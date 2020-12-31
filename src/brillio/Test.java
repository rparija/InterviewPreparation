package brillio;

@FunctionalInterface
	public interface Test<A, B, C> {
		public C apply(A a, B b);
	 
		default void printString() {
			System.out.println("hello world");
		}
	}