package arrays;

import pojo.Student;

public class Array {

	public static void main(String[] args) {
		int[] sampleArray = new int[3];// heap Memory will create a array if int will all the values as zero

		int[] experimentWithArray = { 1, 2, 3, 4 };

		for (int i : experimentWithArray) {
			System.out.println(i);
		}

		Student arrayOfStudents[]= {new Student(11,"RP"),
				new Student(12,"AK"),
				new Student(13,"AG"),
				new Student(14,"AR")};
		
		for(Student s:arrayOfStudents)
		{
			System.out.println(s.toString());
		}
	}
}
