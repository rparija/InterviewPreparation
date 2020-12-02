package interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Driver class 
class Main {
	public static void main(String[] args) {
		ArrayList<Movie> list = new ArrayList<Movie>();
		list.add(new Movie("Force Awakens", 8.3, 2015));
		list.add(new Movie("Star Wars", 8.7, 1977));
		list.add(new Movie("Empire Strikes Back", 8.8, 1980));
		list.add(new Movie("Return of the Jedi", 8.4, 1983));

		Collections.sort(list);

		System.out.println("Movies after sorting : ");
		for (Movie movie : list) {
			System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
		}

		Collections.sort(list, (Movie m1, Movie m2) -> {
			if (m1.getRating() > m2.getRating()) {
				return 1;
			}
			if (m1.getRating() < m2.getRating()) {
				return -1;
			} else {
				return 0;
			}
		}

		);
		System.out.println("Movies after sorting by Rating: ");
		for (Movie movie : list) {
			System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
		}
		
		Collections.sort(list, new Comparator<Movie>() {

			public int compare(Movie m1, Movie m2) {
				
				return m1.getName().compareTo(m2.getName());
			}
			
		});
		
		System.out.println("Movies after sorting by Name: ");
		for (Movie movie : list) {
			System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
		}
	}
}
