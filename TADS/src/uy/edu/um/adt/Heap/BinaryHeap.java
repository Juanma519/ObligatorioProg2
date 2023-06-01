package uy.edu.um.adt.Heap;

public class BinaryHeap<T extends Comparable<T>> implements MyHeap<T> {
    private T[] heap;
    private int size;
    private static final int CAPACITY = 2;


     public BinaryHeap(){
        heap = (T[]) new Comparable[CAPACITY];
        size = 0;
     }
     public boolean isEmpty(){
        return size == 0;
     }

     private void expandHeap(){
        T[] old = heap;
        heap = (T[]) new Comparable[heap.length * 2];
        System.arraycopy(old, 0, heap, 0, size);
     }
     private void swap(int index1, int index2){
        T temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
     }
     private void percolateUp(int index) {
        int parent= (index - 1) / 2;
        while (index > 0 && heap[index].compareTo(heap[parent]) < 0) {
            swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
     }
     private void percolateDown(int index){
         int left=2*index+1;
         int right=2*index+2;
         int min=index;
         if (left<size && heap[left].compareTo(heap[min])<0){
             min=left;
            }
         if (right<size && heap[right].compareTo(heap[min])<0) {
             min = right;
         }
         if (min!=index){
             swap(index,min);
             percolateDown(min);
            }
     }
    @Override
    public void insert(T value) {
         if (size== heap.length-1){
            expandHeap();
         }
        heap[size]=value;
         size++;
         percolateUp(size-1);
    }

    @Override
    public T deleteMin() {
        if (isEmpty()){
            throw new RuntimeException("Empty heap");
        }
        T min=(T)heap[0];
        heap[0]=heap[size-1];
        size--;
        percolateDown(0);
        return min;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get() {
        if (isEmpty()){
            throw new RuntimeException("Empty heap");
        }
        return heap[0];
    }
}




