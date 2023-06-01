package uy.edu.um.adt.BinaryTree;

import uy.edu.um.adt.LinkedList.MyList;
import java.lang.Comparable;
import java.util.ArrayList;

public class BinarySearchTreeImpl<K extends Comparable<K>,V> implements BinarySearchTree<K,V>{
    private TreeNode<K,V> root;

    public BinarySearchTreeImpl() {
        this.root = null;
    }

    @Override
    public void add(K key, V value) {
        TreeNode nuevo = new TreeNode(key, value);
        if (this.root == null) {
            this.root = nuevo;
        } else {
            TreeNode padre = null;
            TreeNode buscar = this.root;
            while (buscar != null) {
                padre = buscar;
                if ( buscar.getKey().compareTo(key)<0) {
                    buscar = buscar.getLeftChild();
                } else {
                    buscar = buscar.getRightChild();
                }
            }
            if ((int) key < (int) padre.getKey()) {
                padre.setLeftChild(nuevo);
            } else {
                padre.setRightChild(nuevo);
            }
        }
    }

    @Override
    public void remove(K key) {
        TreeNode eliminar = (TreeNode) find(key);
        while (eliminar.getLeftChild() != null || eliminar.getRightChild() != null) {
            if (eliminar.getLeftChild() != null) {
                eliminar.swapValue(eliminar, eliminar.getLeftChild());
                eliminar = eliminar.getLeftChild();
            } else {
                eliminar.swapValue(eliminar, eliminar.getRightChild());
                eliminar = eliminar.getRightChild();
            }
        }
        eliminar.setKey(null);
        eliminar.setValue(null);
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public V find(K key) {
        TreeNode encontrado = null;
        TreeNode buscar = this.root;
        if (buscar.getKey() == key) {
            encontrado = buscar;
        } else {
            while (buscar != null) {
                if ((int) key < (int) buscar.getKey()) {
                    buscar = buscar.getLeftChild();
                } else {
                    buscar = buscar.getRightChild();
                }
                if (buscar.getKey() == key) {
                    encontrado = buscar;
                }
            }
        }
        return (V) encontrado.getValue();
    }

    //funcion que recorra el arbol de forma inorder y devuelva una lista con los valores visitados
    @Override
    public MyList<K> inOrder() {


        return null;
    }
}