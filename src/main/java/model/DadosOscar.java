package model;

public class DadosOscar {

//    Index; Year; Age; Name; Movie
    private int year;
    private int age;
    private String name;
    private String movie;
    private Sex sex;

    public DadosOscar(int year, int age, String name, String movie, Sex sex) {
        this.year = year;
        this.age = age;
        this.name = name;
        this.movie = movie;
        this.sex = sex;
    }

    public int getYear() {
        return year;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getMovie() {
        return movie;
    }

    public Sex getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "DadosOscar{" +
                "year=" + year +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", movie='" + movie + '\'' +
                ", sex=" + sex +
                '}';
    }
}
