package uy.edu.um.adt.Queue;


import uy.edu.um.adt.LinkedList.Node;

public class ImplPriorityQueue <T> implements MyPriorityQueue<T>{
    private Node primero;
    private Node ultimo;

    public ImplPriorityQueue() {
        primero = null;
        ultimo = null;
    }

    public void enqueue(T element) {
        Node nuevoNodo = new Node(element);
        if (primero==null){
            primero=nuevoNodo;
            ultimo=nuevoNodo;
            nuevoNodo.setNext(null);
        }
        else {
            ultimo.setNext(nuevoNodo);
            ultimo=nuevoNodo;
            nuevoNodo.setNext(null);
        }
    }

    public T dequeue() throws EmptyQueueException {
        if (this.isEmpty()){
            throw new EmptyQueueException();
        }
        T firstIn = (T) primero.getValue();
        primero=primero.getNext();
        return firstIn;
    }

    public boolean isEmpty() { //Metodo de MyStack y Queue
        return (primero==null);
    }
    public void enqueueWithPriority(T element, int priority) {
        Node<T> newNode = new Node<>(element, priority);

        // Si la cola está vacía, el nuevo nodo es tanto la cabeza como la cola
        if (isEmpty()) {
            ultimo =primero = newNode;
            return;
        }

        // Si la prioridad del nuevo nodo es mayor que la cabeza, se convierte en la nueva cabeza
        if (primero.prioridad< priority) {
            newNode.setNext(primero);
            primero = newNode;
        } else {
            Node<T> current = primero;

            // Busca el lugar correcto en la cola y añade el nodo
            while (current.getNext() != null && current.getNext().prioridad >= priority) {
                current = current.getNext();
            }

            newNode.setNext(current.getNext());
            current.setNext(newNode);

            // Si el nodo se añade al final de la cola, actualizar la cola
            if (current == ultimo) {
                ultimo = newNode;
            }
        }
    }


    public void imprimirQueue (){
        Node puntero = primero;
        while (puntero!=null) {
            System.out.println(puntero.getValue());
            puntero=puntero.getNext();
        }
    }
    @Override
    public boolean contains(T value) {
        boolean contains = false;
        Node<T> temp = this.primero;

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
        int size = 0;

        Node<T> temp = this.primero;

        while (temp != null) {

            temp = temp.getNext();
            size++;

        }

        return size;
    }

}

