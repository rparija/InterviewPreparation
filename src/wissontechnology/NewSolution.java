package wissontechnology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class NewSolution {

	static int minParkingSpaces(int[][] parkingStartEndTimes) {
		// YOUR CODE HERE
		int maxParkingCount = 0;

		Set<Integer> startTime = new HashSet<Integer>();
		for (int i = 0; i < parkingStartEndTimes.length; i++) {
			startTime.add(parkingStartEndTimes[i][0]);
		}
		return startTime.stream().mapToInt(time -> parkedCarsAtTime(time, parkingStartEndTimes)).max().getAsInt();
	}

	private static int parkedCarsAtTime(int minute, int[][] parkingStartEndTimeList) {
		int carsParked = 0;
		for (int i = 0; i < parkingStartEndTimeList.length; i++) {
			if (minute >= parkingStartEndTimeList[i][0] && minute < parkingStartEndTimeList[i][1]) {
				carsParked++;
			}
		}
		return carsParked;
	}

	// DO NOT MODIFY ANYTHING BELOW THIS LINE!!

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine().trim());
		int[][] parkingStartEndTimeList = new int[n][2];
		String[] parkingStartEndTimes = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			String[] parkingStartEndTime = parkingStartEndTimes[i].split(",");
			for (int j = 0; j < parkingStartEndTime.length; j++) {
				parkingStartEndTimeList[i][j] = Integer.parseInt(parkingStartEndTime[j]);
			}
		}

		int out = minParkingSpaces(parkingStartEndTimeList);
		System.out.println(out);

		wr.close();
		br.close();
	}
}
