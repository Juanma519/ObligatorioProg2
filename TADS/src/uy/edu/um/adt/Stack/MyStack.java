package uy.edu.um.adt.Stack;

public interface MyStack<T> {

    void push(T value);

    T pop() throws EmptyStackException;

    T peek() throws EmptyStackException;

    int size();
    boolean isEmpty();

}
