package day02;

public class Movie {
    private String title;
    private int yearOfProduction;
    private String producer;

    public Movie(String title, int yearOfProduction, String producer) {
        this.title = title;
        this.yearOfProduction = yearOfProduction;
        this.producer = producer;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public String getProducer() {
        return producer;
    }
}