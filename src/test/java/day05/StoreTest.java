package day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
    Store store = new Store();

    @TempDir
    File tempFolder;

    @BeforeEach
    void init() {
        store.addProduct(new Product("Scewdriver", LocalDate.of(2010, 10, 11), 500));
        store.addProduct(new Product("Wrench", LocalDate.of(2010, 10, 12), 1000));
        store.addProduct(new Product("Blowtorch", LocalDate.of(2010, 11, 10), 2000));
    }

    @Test
    void testWriteFile() throws IOException {
        Path path = tempFolder.toPath().resolve("test.txt");
        Path resultPath = store.saveToFileByMonth(Month.OCTOBER, path);
        List<String> result = Files.readAllLines(path);
        assertEquals("Scewdriver", result.get(0).split(";")[0]);
    }
}