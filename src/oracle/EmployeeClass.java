package oracle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeClass {
	  private int number;
	  private String name;
	  private String desc;
	  
	  public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "EmployeeClass [number=" + number + ", name=" + name + ", desc=" + desc + "]";
	}

	public EmployeeClass(int i, String string, String string2) {
		this.number=i;
		this.name=string;
		this.desc=string2;
	}

	public static void main(String[] args) {
		  List<EmployeeClass> list = new ArrayList<>();
		  list.add(new EmployeeClass(1,"one","onedec"));
		  list.add(new EmployeeClass(2,"two","threedec"));
		  list.add(new EmployeeClass(1,"three","twodec"));
		  
		  list.stream()
	 	  .forEach(e-> e.toString());
		// print employee names order by employee names?
		 Collections.sort(list, new Comparator<EmployeeClass>() {

			@Override
			public int compare(EmployeeClass e1, EmployeeClass e2) {
				// TODO Auto-generated method stub
				
				return e1.getName().compareTo(e2.getName());
			}
		});
		 
		 list.stream()
		 	  .forEach(System.out::println);
		// print employee names order by employee description?
		 Collections.sort(list, new Comparator<EmployeeClass>() {

			@Override
			public int compare(EmployeeClass e1, EmployeeClass e2) {
				// TODO Auto-generated method stub
				return e1.getDesc().compareTo(e2.getDesc());
			}
		});
		 
		 list.stream()
	 	  .forEach(System.out::println);
	}
}






