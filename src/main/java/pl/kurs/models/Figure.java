package pl.kurs.models;


public abstract class Figure implements Comparable<Figure> {

    public enum KryteriumSortowania {
        KRYETRIUM_POLE,
        KRYETRIUM_NAZWA
    }


    public static KryteriumSortowania AKTUALNY_SPOSOB_SORTOWANIA = KryteriumSortowania.KRYETRIUM_POLE;

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

    public static void ustalDomyslneSortowanie(KryteriumSortowania kryteriumSortowania) {
        AKTUALNY_SPOSOB_SORTOWANIA = kryteriumSortowania;
    }


    public abstract double calculatePerimeter();

    public abstract double calculateArea();

    @Override
    public int compareTo(Figure o) {
        int result = 0;
        if (AKTUALNY_SPOSOB_SORTOWANIA == KryteriumSortowania.KRYETRIUM_POLE)
            result = Double.compare(calculateArea(), o.calculateArea());
        else if (AKTUALNY_SPOSOB_SORTOWANIA == KryteriumSortowania.KRYETRIUM_NAZWA) {
            result = getClass().getSimpleName().compareTo(o.getClass().getSimpleName());
            if (result == 0)
                result = Double.compare(calculateArea(), o.calculateArea());
        }
        return result;
    }

}