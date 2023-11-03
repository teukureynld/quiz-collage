
import java.util.*;

public class MovieRental {
    private List<Movie> movieList = new ArrayList<>();

    public List<Movie> getMovieList() {
        return movieList;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        MovieRental movieRental = new MovieRental();

        showMenu();

        while (true) {
            System.out.print(">> ");

            int choice = s.nextInt();
            s.nextLine();
            if (choice == 4) {
                break;
            }

            if (choice == 1) {
                Movie movie = new Movie();

                while (movie.getTitle() == null) {
                    System.out.print("Input Movie Title [Length Must be 3 - 20 chars]\t: ");
                    movie.setTitle(s.nextLine());
                }

                while (movie.getGenre() == null) {
                    System.out.print("Input Movie Genre [Horror | Comedy | Action]\t: ");
                    movie.setGenre(s.nextLine());
                }

                while (movie.getRating() == 0) {
                    System.out.print("Input Movie Rating [1-10]\t\t\t: ");
                    movie.setRating(s.nextInt());
                }

                String movieId = generateMovieId();
                movie.setMovieId(movieId);
                System.out.println("Generated MovieID\t\t\t\t: " + movieId);

                movie.setAdditionalPrice(movie.getGenre());
                movie.calculatePrice();

                movieRental.addMovieToList(movie);
                System.out.println();
                System.out.println("Insert Success!");

                // Sort
                List<Movie> movieList = movieRental.getMovieList();
                Collections.sort(movieList);
                movieRental.setMovieList(movieList);
            }

            if (choice == 2) {
                List<Movie> movieList = movieRental.getMovieList();
                if (movieList.size() == 0) {
                    System.out.println("NO MOVIE FOUND");
                    continue;
                }

                movieRental.printMovieList();
            }

            if (choice == 3) {
                List<Movie> movieList = movieRental.getMovieList();
                if (movieList.size() == 0) {
                    System.out.println("NO MOVIE FOUND");
                    continue;
                }

                movieRental.printMovieList();

                int movieIndexInt = 0;
                while (true) {
                    try {
                        System.out.print("Choose Movie index [1-" + movieList.size() + "]: ");
                        String movieIndex = s.nextLine();
                        movieIndexInt = Integer.parseInt(movieIndex);
                        if (movieIndexInt >= 1 && movieIndexInt < (movieList.size() + 1)) {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Input Must be Numeric");
                    }
                }

                int payAmount = 0;
                Movie movie = movieList.get(movieIndexInt - 1);
                while (payAmount < movie.getPrice()) {
                    System.out.print("Input Money to Rent [MIN " + movie.getPrice() + "]: ");
                    payAmount = s.nextInt();
                }

                System.out.println("Pay Rent Successful with " + (payAmount - movie.getPrice()) + " Change");

                movieList.remove(movieIndexInt - 1);

                Collections.sort(movieList);
                movieRental.setMovieList(movieList);
            }
        }

        s.close();
    }

    public void addMovieToList(Movie movie) {
        this.movieList.add(movie);
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public void printMovieList() {
        System.out.println("==============================================================");
        System.out.println("| NO \t| ID\t| Title\t\t| Genre\t| Rating\t| Price\t|");
        System.out.println("==============================================================");
        for (int i = 0; i < movieList.size(); i++) {
            Movie movie = movieList.get(i);
            System.out.println("| " + (i + 1) + "\t| " + movie.getMovieId() + "\t| " + movie.getTitle() + "\t| "
                    + movie.getGenre() + "\t| " + movie.getRating() + "\t| " + movie.getPrice());
        }
    }

    static public String generateMovieId() {
        Random rand = new Random();
        char firstChar = (char) (rand.nextInt(26) + 'A');
        char secondChar = (char) (rand.nextInt(26) + 'A');
        return String.valueOf(firstChar) + String.valueOf(secondChar) + rand.nextInt(10) + rand.nextInt(10)
                + rand.nextInt(10);
    }

    static public void showMenu() {
        System.out.println("===============");
        System.out.println(" MOVIE RENTAL ");
        System.out.println("===============");
        System.out.println("1. Add new Movie");
        System.out.println("2. View Movie (Sort by Title Ascending)");
        System.out.println("3. Rent Movie");
        System.out.println("4. EXIT");
    }
}

class Movie implements Comparable<Movie> {
    private String title;
    private Genre genre;
    private int rating;
    private int additionalPrice;
    private int price;
    private String movieId;

    public Movie() {
        this.title = null;
        this.genre = null;
        this.rating = 0;
        this.price = 0;
        this.movieId = null;
    }

    enum Genre {
        Comedy(3000),
        Action(4000),
        Horror(5000);

        private final int addPrice;

        Genre(int value) {
            this.addPrice = value;
        }

        public int getAdditionalPrice() {
            return addPrice;
        }
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getRating() {
        return rating;
    }

    public int getPrice() {
        return price;
    }

    public int getAdditionalPrice() {
        return additionalPrice;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setTitle(String title) {
        if (title.length() >= 3 && title.length() <= 20) {
            this.title = title;
        }
    }

    public void setGenre(String genre) {
        for (Genre g : Genre.values()) {
            if (g.name().equals(genre)) {
                this.genre = g;
            }
        }
    }

    public void setRating(int rating) {
        if (rating >= 1 && rating <= 10) {
            this.rating = rating;
        }
    }

    public void setAdditionalPrice(Genre genre) {
        this.additionalPrice = genre.getAdditionalPrice();
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public void calculatePrice() {
        this.price = (this.title.length() * 500) + this.additionalPrice;
    }

    public int compareTo(Movie movie) {
        return this.title.compareTo(movie.title);
    }

}