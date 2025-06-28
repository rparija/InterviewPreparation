package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.lang.Math.floor;

public class LeetCode2138 {

    public static void main(String[] args) {
        String s = "abcdefghi";
        int k = 3;
        char fill = 'x';
        String[] arr = divideString(s, k, fill);
        System.out.println(Arrays.toString(arr));
    }

    public static String[] divideString(String s, int k, char fill) {

        int l = s.length();
        int arraySize = (l+k-1) / k;
        int i = 0;
        int m = 0;
        String[] arr = new String[arraySize];
        while (i < l) {
            int j = 0;
            StringBuilder sb = new StringBuilder();
            while (j < k && i < l) {
                sb.append(s.charAt(i));
                arr[m] = sb.toString();
                i++;
                j++;
                if (j == k && i < l) {
                    m++;
                }
            }
        }
        if (arr[m].length() == k) {
            List<String> list = Arrays.stream(arr).filter(Objects::nonNull).toList();
            return list.toArray(new String[0]);
        } else {
            StringBuilder sb = new StringBuilder(arr[m]);
            while (arr[m].length() < k) {
                sb.append(fill);
                arr[m] = sb.toString();
            }
            List<String> list = Arrays.stream(arr).filter(Objects::nonNull).toList();
            return list.toArray(new String[0]);
        }
    }
}
