package interfaces;

import java.util.Date;

public class Program {
	public static void main(String[] args) {

		try {
			Person p1 = new Person("Raul", new Date(1991, 03, 26));
			Person p2 = p1.clone();
			System.out.println(p1);
			System.out.println(p2);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
