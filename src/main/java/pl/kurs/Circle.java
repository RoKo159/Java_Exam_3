package pl.kurs;

import java.util.Objects;

public class Circle extends Figure {
    private int r;

    public Circle(int r) {
        this.r = r;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return r == circle.r;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r);
    }

    @Override
    public String toString() {
        return "Figura nr " + figureNumber + ": Koło o promieniu " + r + ".";
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * r;
    }

    @Override
    public double calculateArea() {
        return Math.PI * r * r;
    }

    @Override
    public int compareTo(Figure o) {
        return Double.compare(o.calculateArea(),calculateArea());
    }
}
