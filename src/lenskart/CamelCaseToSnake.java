package lenskart;

public class CamelCaseToSnake {

	public static void main(String[] args) {

		String string = "rahulParija";
		StringBuilder stringBuilder = new StringBuilder();
		boolean skipFirst = false;
		if (string.charAt(0) < 90) {
			char tempChar = (char) (string.charAt(0) + 32);
			stringBuilder.append(tempChar);
			skipFirst = true;
		}
		for (char c : string.toCharArray()) {
			if (skipFirst) {
				skipFirst = false;
				continue;
			}
			if (c < 90) {

				stringBuilder.append("_");
				char tempChar = (char) (c + 32);
				stringBuilder.append(tempChar);
			} else {
				stringBuilder.append(c);

			}
		}
		System.out.println(stringBuilder);
	}
}
