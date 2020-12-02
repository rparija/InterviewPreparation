import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class ComvivaAssignment {

	public static void main(String[] args) {

		EmployeePojo emp = new EmployeePojo(1, "A", 0);
		EmployeePojo emp1 = new EmployeePojo(2, "B", 1);
		EmployeePojo emp2 = new EmployeePojo(3, "C", 1);
		EmployeePojo emp3 = new EmployeePojo(4, "D", 2);
		EmployeePojo emp4 = new EmployeePojo(5, "E", 2);
		EmployeePojo emp5 = new EmployeePojo(6, "F",4);
		EmployeePojo emp6 = new EmployeePojo(7, "G", 4);

		ArrayList<EmployeePojo> empList = new ArrayList<>();
		empList.add(emp);
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		empList.add(emp4);
		empList.add(emp5);
		empList.add(emp6);
		// findHierarchy(empList,1);
		ArrayList<EmployeePojo> tmplist = new ArrayList<>();
		tmplist.addAll(empList);
		ArrayList<EmployeePojo> list = new ArrayList<>();
		list.addAll(findHierarchyRecursion(tmplist,4));
		System.out.println(list);
		empList.removeAll(list);
		System.out.println(empList);
		// list.stream().forEach(System.out::println);
	}

	/* tried recursion but recusrion exit condition i was not able to find */
	private static ArrayList<EmployeePojo> findHierarchyRecursion(ArrayList<EmployeePojo> empList, int id) {
		// empList.stream().forEach(emp -> findHierarchyRecursion(emp, id) );
		ArrayList<EmployeePojo>tempList=new ArrayList<EmployeePojo>();
		tempList.addAll(empList);
		ArrayList<EmployeePojo> employeeHirearchy = new ArrayList<>();
		for (EmployeePojo employeePojo : tempList)
		{
			if (employeePojo.getId() == id) 
			{
				employeeHirearchy.add(employeePojo);
			} else if (employeePojo.getPid() == id) {
				employeeHirearchy.add(employeePojo);
				empList.removeAll(employeeHirearchy);
				findHierarchyRecursion(empList, employeePojo.getId());
			}
		}
		//maintains the list if there is only one parent and no child
		empList.removeAll(employeeHirearchy);
		return empList;
	}

	private static EmployeePojo findHierarchyRecursion(EmployeePojo emp, int id) {
		if (emp.getId() == id)
			return emp;
		// if(emp.getPid()==id)
		return findHierarchyRecursion(emp, emp.getId());
		// return null;
	}

	/*
	 * A- emp5 B- emp emp1 em2 emp3 emp4 D- emp1 emp3 emp4 E- emp2
	 */
	public static void findHierarchy(ArrayList<EmployeePojo> empList, int id) {
		Map<Integer, List<EmployeePojo>> map = new HashMap<Integer, List<EmployeePojo>>();
		for (EmployeePojo emp : empList) {
			List<EmployeePojo> list = new ArrayList<>();
			list.add(emp);
			map.put(emp.getId(), list);
			if (map.containsKey(emp.getPid())) {
				list = map.get(emp.getPid());
				list.add(emp);
				map.put(emp.getPid(), list);
			}

		}

		for (Entry<Integer, List<EmployeePojo>> entry : map.entrySet()) {
			if (entry.getKey() == id) {
				for (EmployeePojo emp : entry.getValue()) {
					System.out.println(emp.toString());
				}
			}
		}
	}
}
