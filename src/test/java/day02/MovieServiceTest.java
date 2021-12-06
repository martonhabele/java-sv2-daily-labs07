package day02;

import org.junit.jupiter.api.Test;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {
    @Test
    void testFillMovies() {
        MovieService movieService = new MovieService(Path.of("src/main/java/day02/resources/movies.csv"));
        assertEquals(5, movieService.getMovieList().size());
        assertEquals("Steven Spielberg", movieService.getMovieList().get(0).getProducer());
    }

    @Test
    void testFileNotFound() {
        IllegalStateException ise = assertThrows(IllegalStateException.class, () -> new MovieService(Path.of("valami.txt")));
        assertEquals("Cannot read file!", ise.getMessage());
        assertEquals(NoSuchFileException.class, ise.getCause().getClass());
    }
}