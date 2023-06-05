package.uy.edu.um.adt.Stack;

import uy.edu.um.adt.Queue.EmptyStackException;
import uy.edu.um.adt.LinkedList.Node;


public class MyImplStack<T> implements MyStack<T>{
    private Node<T> top = null;
    private int count;


    @Override
    public T pop() throws EmptyStackException {
        if(this.top == null){
            throw new EmptyStackException("Error la pila es vacía");
        }
        Node<T> devolver = this.top;
        this.top = this.top.getNext();
        this.count -= 1;
        return devolver.getValue();
    }

    @Override
    public void push(T element) {
        Node temp = new Node<T>(element);
        temp.setNext(this.top);
        this.top = temp;

        this.count += 1;
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    @Override
    public T peek() throws EmptyStackException{//devuelve el primero del stack

        if(this.top == null){//isEmpty()
            throw new EmptyStackException("Error la pila es vacía");
        }
        return this.top.getValue();
    }

    @Override
    public int size() {
        return (this.count);
    }
}