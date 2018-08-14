package org.superbiz.moviefun;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    private final MoviesBean moviesBean;
    public HomeController(MoviesBean moviesBean) {
        this.moviesBean = moviesBean;
    }

    private List<Movie> getInitialData(){
        List<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Wedding Crashers", "David Dobkin", "Comedy", 7, 2005));
        list.add(new Movie("Starsky & Hutch", "Todd Phillips", "Action", 6, 2004));
        list.add(new Movie("Shanghai Knights", "David Dobkin", "Action", 6, 2003));
        list.add(new Movie("I-Spy", "Betty Thomas", "Adventure", 5, 2002));
        list.add(new Movie("The Royal Tenenbaums", "Wes Anderson", "Comedy", 8, 2001));
        list.add(new Movie("Zoolander", "Ben Stiller", "Comedy", 6, 2001));
        list.add(new Movie("Shanghai Noon", "Tom Dey", "Comedy", 7, 2000));
        return list;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/setup")
    public String setup(Map<String, Object> model) {
        for (Movie movie : getInitialData()) {
            moviesBean.addMovie(movie);
        }
        model.put("movies",moviesBean.getMovies());
        return "setup";
    }
}
