package pl.kurs;


public abstract class Figure implements Comparable<Figure> {

    private static int counter;
    protected int figureNumber;


    public Figure() {
        figureNumber = ++counter;
    }

    public static Square stworzKwadrat(int a) {
        if (a <= 0) throw new IllegalArgumentException("The number cannot be negative or be zero");
        return new Square(a);
    }

    public static Circle stworzKolo(int r) {
        if (r <= 0) throw new IllegalArgumentException("The number cannot be negative or be zero");
        return new Circle(r);
    }

    public static Rectangle stworzProstokat(int a, int b) {
        if (a <= 0 || b <= 0) throw new IllegalArgumentException("The number cannot be negative or be zero");
        return new Rectangle(a, b);
    }


    public abstract double calculatePerimeter();

    public abstract double calculateArea();

}