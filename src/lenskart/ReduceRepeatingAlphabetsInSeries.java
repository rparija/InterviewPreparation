package lenskart;

public class ReduceRepeatingAlphabetsInSeries {

	public static void main(String[] args) {
		String string = "aabcccabba";
		int count=findMinlength(string);
		System.out.println(count);
	}
	
	 public static int findMinlength(String input){

	        int length = input.length();
	        int mid = length/2;
	        char prevChar = '0';
	        int i= length -1, j = 0;

	        while( i > mid && j <=mid){
	            if(input.charAt(i) != input.charAt(j)){
	                break;
	            }
	            if(input.charAt(i) == input.charAt(j)){
	                prevChar = input.charAt(i);
	                i--; j++;
	            }
	            if(input.charAt(i) == prevChar){
	                i--;
	            }
	            if(input.charAt(j) == prevChar){
	                j++;
	            }
	        }

	        return (i-j)+1;
	    }
}
