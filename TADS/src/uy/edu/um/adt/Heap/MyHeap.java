package uy.edu.um.adt.Heap;

public interface MyHeap<T> {
    void insert(T data);
    T deleteMin();
    int size();
    T get();

}
