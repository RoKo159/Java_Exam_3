package pl.kurs;

import java.util.Comparator;

public class FigureComparator implements Comparator<Figure> {

    @Override
    public int compare(Figure o1, Figure o2) {
        int result = o1.getClass().getSimpleName().compareTo(o2.getClass().getSimpleName());
        if (result == 0)
            result = Double.compare(o1.calculateArea(),o2.calculateArea());
        return result;
    }
}
