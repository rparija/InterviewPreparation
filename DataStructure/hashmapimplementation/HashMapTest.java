package hashmapimplementation;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap hashmap= new HashMap(2);
		hashmap.put("first", 1);
		hashmap.put("second", 2);
		hashmap.put("third", 3);
		hashmap.put("fourth", 4);
		hashmap.put(null, 1);
		System.out.println(hashmap.get("fourth"));
		hashmap.put("fourth", 5);
		System.out.println(hashmap.contains("fourth"));
		System.out.println(hashmap.get("fourth"));
		System.out.println(hashmap.get("third"));
		System.out.println(hashmap.contains(null));

	}
}
