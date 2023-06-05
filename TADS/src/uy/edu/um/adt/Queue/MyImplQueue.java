package uy.edu.um.adt.Queue;

import uy.edu.um.adt.LinkedList.Node;

public class MyImplQueue<T> implements MyQueue<T>{
    private Node<T> rear = null, front = null;
    private int count = 0;


    @Override
    public void enqueue(T value) {
        Node<T> nodeToAdd = new Node(value);
        if(this.front == null){//caso especial en que la queue estaba vacía
            this.front = nodeToAdd;
            this.rear = nodeToAdd;
        }else{
            this.rear.setNext(nodeToAdd);//conectar
            this.rear = nodeToAdd;
        }
        count += 1;//cantidad de nodos más uno
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if (this.front == null){
            throw new EmptyQueueException();
        }
        T valueToRemove = null;
        valueToRemove = this.front.getValue();
        this.front = this.front.getNext();//pasar front al nodo siguiente
        if (this.front == null) {//si la queue queda vacía
            this.rear = null;
        }
        count -= 1;//cantidad de nodos menos uno
        return valueToRemove;
    }

    @Override
    public boolean contains(T value) {
        boolean contains = false;
        Node<T> temp = this.front;

        while (temp != null && !temp.getValue().equals(value)) {
            temp = temp.getNext();
        }

        if (temp != null) { // Si no se llego al final de la lista, se encontro el valor
            contains = true;
        }

        return contains;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return rear == null && front == null;
    }
}

