package rw.rwandamovie.movieinfoservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import rw.rwandamovie.movieinfoservice.models.Movie;
import rw.rwandamovie.movieinfoservice.models.MovieSummary;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/movies")
public class MovieResource {
    private static final String template = "Hello Docker File Uploaded, %s!";
    private final AtomicLong counter = new AtomicLong(100);

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId){

        MovieSummary movieSummary = restTemplate.getForObject(
                "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey, MovieSummary.class);

        return  new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());

    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name",
            defaultValue="World") String name) {

        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
