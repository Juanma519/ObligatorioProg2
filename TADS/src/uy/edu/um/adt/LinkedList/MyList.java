package uy.edu.um.adt.LinkedList;

public interface MyList<T> {

    void add(T value);

    T get(int position);

    boolean contains(T value);

    void remove(T value);

    int size();

}

