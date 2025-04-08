package DesignBookMyShow;

import javax.crypto.Cipher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map<City, List<Movie>> cityWiseMovie;
    List<Movie> allMovies;

    public MovieController() {
        cityWiseMovie=new HashMap<>();
        allMovies=new ArrayList<>();
    }

    void add(Movie movie , City city){
        allMovies.add(movie);
        List<Movie>movies=cityWiseMovie.getOrDefault(city,new ArrayList<>());
        movies.add(movie);
        cityWiseMovie.put(city,movies);
    }

    Movie getMovieByName(String movieName){
        for(Movie movie:allMovies){
            if(movie.getMovieName().equals(movieName)){
                return movie;
            }
        }
        return null;
    }
    List<Movie> getMoviesByCity(City city) {
        return cityWiseMovie.get(city);
    }

}
