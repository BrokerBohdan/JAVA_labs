import java.util.*;

class Actor {
    private String name;
    private List<Movie> movies;

    public Actor(String name) {
        this.name = name;
        this.movies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }
}

class Movie {
    private String title;
    private List<Actor> actors;

    public Movie(String title) {
        this.title = title;
        this.actors = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }
}

class MovieDatabase {
    private List<Movie> movies;
    private List<Actor> actors;

    public MovieDatabase() {
        this.movies = new ArrayList<>();
        this.actors = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    // Task 1: Check if there is any actor who has not acted in any movie
    public boolean hasActorWithoutMovies() {
        for (Actor actor : actors) { 
            if (actor.getMovies().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    // Task 2: Get a list of actors who have acted with the given actor
    public Set<Actor> getCoActors(Actor targetActor) {
        Set<Actor> coActors = new HashSet<>();

        Iterator<Movie> movieIterator = targetActor.getMovies().iterator(); 
        while (movieIterator.hasNext()) {
            Movie movie = movieIterator.next();
            for (Actor actor : movie.getActors()) {
                if (!actor.equals(targetActor)) {
                    coActors.add(actor);
                }
            }
        }
        return coActors;
    }

    // Task 3: Find the movie with the most actors
    public Movie getMovieWithMostActors() {
        Movie maxMovie = null;
        int maxActors = 0;

        Iterator<Movie> iterator = movies.iterator(); 
        while (iterator.hasNext()) {
            Movie movie = iterator.next();
            if (movie.getActors().size() > maxActors) {
                maxActors = movie.getActors().size();
                maxMovie = movie;
            }
        }

        return maxMovie;
    }
}

public class Lab7 {
    public static void main(String[] args) {
        MovieDatabase database = new MovieDatabase();

        Actor actor1 = new Actor("Actor 1");
        Actor actor2 = new Actor("Actor 2");
        Actor actor3 = new Actor("Actor 3");
        Actor actor4 = new Actor("Actor 4");

        Movie movie1 = new Movie("Movie 1");
        Movie movie2 = new Movie("Movie 2");

        movie1.addActor(actor1);
        movie1.addActor(actor2);
        actor1.addMovie(movie1);
        actor2.addMovie(movie1);

        movie2.addActor(actor2);
        movie2.addActor(actor3);
        actor2.addMovie(movie2);
        actor3.addMovie(movie2);

        database.addActor(actor1);
        database.addActor(actor2);
        database.addActor(actor3);
        database.addActor(actor4);
        database.addMovie(movie1);
        database.addMovie(movie2);

        // Task 1
        System.out.println("Is there any actor without movies? " + database.hasActorWithoutMovies());

        // Task 2
        System.out.println("Co-actors of Actor 2:");
        for (Actor coActor : database.getCoActors(actor2)) {
            System.out.println(coActor.getName());
        }

        // Task 3
        Movie movieWithMostActors = database.getMovieWithMostActors();
        System.out.println("Movie with the most actors: " + (movieWithMostActors != null ? movieWithMostActors.getTitle() : "None"));
    }
}