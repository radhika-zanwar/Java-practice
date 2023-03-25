package com.learning.anonymous.inner.classes;

import java.util.Comparator;

public class GenreSort implements Comparator<DVD> {
    public int compare(DVD o1, DVD o2) {
        return (o1.getGenre().compareTo(o2.getGenre()));

    }
}
