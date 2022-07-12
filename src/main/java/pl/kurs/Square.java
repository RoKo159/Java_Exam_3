package pl.kurs;

import java.util.Objects;

public class Square extends Figure {
    private int a;

    public Square(int a) {
        super();
        this.a = a;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return a == square.a;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }

    @Override
    public String toString() {
        return "Figura nr " + figureNumber + ": Kwadrat o boku " + a + ".";
    }

    @Override
    public double calculatePerimeter() {
        return 4 * a;
    }

    @Override
    public double calculateArea() {
        return a * a ;
    }


    @Override
    public int compareTo(Figure o) {
        return Double.compare(o.calculateArea(),calculateArea());
    }
}
