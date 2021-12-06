package day01;

import java.time.LocalDate;

public class Human {
    private String name;
    private int yoB;

    public Human(String name, int yoB) {
        if (isNameValid(name) && isYoBValid(yoB)) {
            this.name = name;
            this.yoB = yoB;
        }
        else {
            throw new IllegalArgumentException("Cannot create constructor!");
        }
    }

    public boolean isYoBValid(int yoB) {
        if (LocalDate.now().getYear() - yoB > 120) {
            throw new IllegalArgumentException("Cannot be older than 120!");
        }
        return true;
    }

    public boolean isNameValid(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name invalid!");
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public int getYoB() {
        return yoB;
    }
}