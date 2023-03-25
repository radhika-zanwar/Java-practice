package com.learning.anonymous.inner.classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<DVD> dvdList = new ArrayList<DVD>();
        dvdList.add(new DVD("Jani Dushman","Horror"));
        dvdList.add(new DVD("Harry Potter","Fiction"));
        dvdList.add(new DVD("Avengers","Sci-Fi"));
        dvdList.add(new DVD("Conjuring","Horror"));

        //GenreSort genreSortComparator = new GenreSort();
        Comparator<DVD> comparator = new Comparator<DVD>() {
            @Override
            public int compare(DVD o1, DVD o2) {
                return (o1.getGenre().compareTo(o2.getGenre()));
            }
        };
        dvdList.sort(comparator);

        System.out.println(dvdList);

    }
}
