package wayfair;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LargeNumberAddition {

    public static void main(String[] args) {
        String s1="11,239";
        String s2="12,331";
        String answer= largeNumberAddition(s1,s2);
        System.out.println("LargeNumberAddition: "+answer);
        System.out.println("123 + 456 = " + largeNumberAddition("123", "456"));      // Expected: 579
        System.out.println("99 + 1 = " + largeNumberAddition("99", "1"));            // Expected: 100
        System.out.println("1 + 99 = " + largeNumberAddition("1", "99"));            // Expected: 100
        System.out.println("12345678901234567890 + 98765432109876543210 = " +
                largeNumberAddition("12345678901234567890", "98765432109876543210"));
        // Expected: 111111111011111111100

        System.out.println("0 + 0 = " + largeNumberAddition("0", "0"));              // Expected: 0
        System.out.println("12345 + 0 = " + largeNumberAddition("12345", "0"));      // Expected: 12345
        System.out.println("0 + 67890 = " + largeNumberAddition("0", "67890"));      // Expected: 67890

        // Test with different lengths
        System.out.println("5 + 5 = " + largeNumberAddition("5", "5"));              // Expected: 10
        System.out.println("9999 + 1 = " + largeNumberAddition("9999", "1"));        // Expected: 10000


    }

    private static String largeNumberAddition(String s1, String s2) {
        StringBuilder sum=new StringBuilder();
        if(s1.isBlank() || s2.isBlank())
        {
            return "";
        }
        String [] firstNumberArray=s1.split(",");
        String [] secondNumberArray=s2.split(",");
        StringBuilder firstNumber= new StringBuilder(Arrays.stream(firstNumberArray).collect(Collectors.joining("")));
        StringBuilder secondNumber= new StringBuilder(Arrays.stream(secondNumberArray).collect(Collectors.joining("")));
        int firstSize=firstNumber.length()-1;
        int secondSize=secondNumber.length()-1;

        int carry=0;
        while(firstSize>=0||secondSize>=0 || carry>0)
        {
            int firstNum=firstSize>=0?Character.getNumericValue(firstNumber.charAt(firstSize)):0;
            int secondNum=secondSize>=0?Character.getNumericValue(secondNumber.charAt(secondSize)):0;

            int add=firstNum+secondNum+carry;
            carry=add/10;
            sum.append(String.valueOf(add%10));
            firstSize--;
            secondSize--;
        }
        return sum.reverse().toString();
    }
}
