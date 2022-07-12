package pl.kurs;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        List<Figure> figury = Arrays.asList(Figure.stworzKwadrat(10), Figure.stworzKolo(20), Figure.stworzProstokat(10, 20),
                Figure.stworzKwadrat(15));
        for (Figure f : figury) {
            System.out.println(f);
        }
        System.out.println();
        System.out.println("Figura z największym obwodem " + getLargestPerimeterFigure(figury));
        System.out.println("Figura z największym polem " + getLargestAreaFigure(figury));
        System.out.println(figury.contains(new Square(10)));

        try (
                FileWriter fw = new FileWriter("Figure.txt");
                BufferedWriter bw = new BufferedWriter(fw)
        ) {
            bw.write(String.valueOf(figury));
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("Figury sortowane wg. pola od największego do najmniejszego");

        Collections.sort(figury);
        for (Figure f : figury) {
            System.out.println(f);
        }
        System.out.println();
        System.out.println("Sortowanie najpierw po nazwie klasy, następnie po polu");
        Collections.sort(figury, new FigureComparator());
        for (Figure f : figury) {
            System.out.println(f);
        }


        System.out.println();
        System.out.println("Odczytanie pliku");


        try (
                FileReader fr = new FileReader("Figure.txt");
                BufferedReader br = new BufferedReader(fr);
        ) {
            String nextLine = null;
            while ((nextLine = br.readLine()) != null) {
                System.out.print(nextLine);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }


    public static Figure getLargestAreaFigure(List<Figure> figures) {
        Figure highestArea = figures.get(0);
        for (int i = 0; i < figures.size(); i++) {
            if (figures.get(i) != null) {
                if (figures.get(i).calculateArea() > highestArea.calculateArea())
                    highestArea = figures.get(i);
            }
        }
        return highestArea;

    }


    public static Figure getLargestPerimeterFigure(List<Figure> figures) {
        Figure highestPerimeter = figures.get(0);
        for (int i = 0; i < figures.size(); i++) {
            if (figures.get(i) != null) {
                if (figures.get(i).calculatePerimeter() > highestPerimeter.calculatePerimeter())
                    highestPerimeter = figures.get(i);
            }
        }
        return highestPerimeter;
    }

}

