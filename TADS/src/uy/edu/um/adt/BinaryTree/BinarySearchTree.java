package uy.edu.um.adt.BinaryTree;
import uy.edu.um.adt.LinkedList.MyList;
public interface BinarySearchTree<K extends Comparable<K>, V> {
    void add(K key, V value);

    void remove(K key);

    boolean contains(K key);

    V find(K key);

    MyList<K> inOrder();

}
