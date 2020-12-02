
package wissontechnology;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Solution {

	public static class RatingStatisticsCollectorImpl implements RatingStatisticsCollector {

		Map<String, List<Integer>> ratingsMap = new ConcurrentHashMap<>();

		@Override
		public void putNewRating(String app, int rating) {
			// YOUR CODE HERE
			if (!ratingsMap.containsKey(app)) {
				List ratingList = new ArrayList<>();
				ratingList.add((double) rating);
				ratingList.add(1);
				ratingsMap.put(app, ratingList);
			} else {
				List ratingList = ratingsMap.get(app);
				int count = (int) ratingList.get(1);
				double ratings = (double) (ratingList.get(0)) * count;
				int ratingsCount = (int) ratingList.get(1) + 1;
				double newRatings = (ratings + rating) / ratingsCount;
				ratingList = new ArrayList<>();
				ratingList.add(newRatings);
				ratingList.add(ratingsCount);
				ratingsMap.put(app, ratingList);
			}
		}

		@Override
		public double getAverageRating(String app) {
			// YOUR CODE HERE
			if (ratingsMap.containsKey(app)) {
				List ratingList = ratingsMap.get(app);
				double averageRating = (double) ratingList.get(0);
				return averageRating;
			}
			return 0.0;
		}

		@Override
		public int getRatingsCount(String app) {
			// YOUR CODE HERE
			if (ratingsMap.containsKey(app)) {
				List ratingList = ratingsMap.get(app);
				int ratingsCount = (int) ratingList.get(1);
				return ratingsCount;
			}
			return 0;
		}
	}

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface RatingStatisticsCollector {
		// Ratings feed will call this method when new app rating information is
		// received. This is input to your class. ratings is a non negative integer
		// between 0 to 10.
		public void putNewRating(String app, int rating);

		// Report the average rating of the app.
		public double getAverageRating(String app);

		// Report the total number of rating for an app.
		public int getRatingsCount(String app);
	}

	public static void main(String[] args) {

		Solution sol = new Solution();
		RatingStatisticsCollectorImpl r = new RatingStatisticsCollectorImpl();
		r.putNewRating("Gmail", 2);
		r.putNewRating("Gmail", 4);
		r.putNewRating("Gmail", 7);
		System.out.println(r.getAverageRating("Gmail"));
		r.getRatingsCount("Gmail");
	}
}
