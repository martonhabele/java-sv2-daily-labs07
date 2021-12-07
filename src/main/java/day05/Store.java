package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> soldProducts = new ArrayList<>();

    public void addProduct(Product product) {
        if (product.getSellDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Sell date is invalid!");
        }
        soldProducts.add(product);
    }

    public Path saveToFileByMonth(Month month, Path testPath) {
        List<String> result = stringListByMonth(month);
        try {
            StringBuilder sb = new StringBuilder().append("soldProducts").append(month.name())
                    .append(".csv");
            Path path = Path.of(sb.toString());
            Files.write(testPath, result);
            return path;
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot write file!", e);
        }
    }

    public List<String> stringListByMonth(Month month) {
        List<String> result = new ArrayList<>();
        for (Product scopedProduct : soldProducts) {
            if (scopedProduct.getSellDate().getMonth() == month) {
                result.add(scopedProduct.toString());
            }
        }
        return result;
    }
}