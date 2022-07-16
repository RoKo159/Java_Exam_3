package pl.kurs.app;

import pl.kurs.models.Figure;
import pl.kurs.models.Square;

import java.io.*;
import java.util.ArrayList;
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
                FileOutputStream fos = new FileOutputStream("figure.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos)
                ){
            oos.writeObject(figury);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        Figure.ustalDomyslneSortowanie(Figure.KryteriumSortowania.KRYETRIUM_POLE);
        Collections.sort(figury);
        for (Figure f : figury) {
            System.out.println(f);
        }



        System.out.println();
        System.out.println("Odczytanie pliku");


        List<Figure> figureList = null;
        try (
                FileInputStream fis = new FileInputStream("figure.txt");
                ObjectInputStream ois = new ObjectInputStream(fis)
                ){
            figureList = (List<Figure>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (Figure f: figureList) {
            System.out.println(f);
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

