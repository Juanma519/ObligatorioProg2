package uy.edu.um.adt.LinkedList;

public class Node<T>{
    private T value;
    public int prioridad;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }
    public Node(T value, int prioridad){
        this.value=value;
        this.prioridad=prioridad;
        this.next=null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}

