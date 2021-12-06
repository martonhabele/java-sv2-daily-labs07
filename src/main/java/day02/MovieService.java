package day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MovieService {
    private List<Movie> movieList = new ArrayList<>();

    public MovieService(Path path) {
        try {
            List<String> itemLines = Files.readAllLines(path);
            addMoviesList(itemLines);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file!", e);
        }
    }

    private void addMoviesList(List<String> itemLines) {
        for (String scopedLine : itemLines) {
            String[] temporary = scopedLine.split(";");
            movieList.add(new Movie(temporary[0], Integer.parseInt(temporary[1]), temporary[2]));
        }
    }

    public List<Movie> getMovieList() {
        return movieList;
    }
}