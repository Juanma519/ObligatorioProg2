package uy.edu.um.adt.BinaryTree;

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
        }
        else {
            TreeNode padre = null;
            TreeNode buscar = this.root;
            while (buscar != null) {
                padre = buscar;
                if ( buscar.getKey().compareTo(key)<0) {
                    buscar = buscar.getLeftChild();
                }
                else {
                    buscar = buscar.getRightChild();
                }
            }
            if (padre.getKey().compareTo(key) >0) {
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
        return contains(key,root);
    }

    private boolean contains(K key , TreeNode<K,V> root){
        boolean contains = false;

        if (root != null) {

            int nValue = key.compareTo(root.getKey());

            if (nValue == 0) {

                contains = true;

            } else if (nValue > 0) {

                contains = contains(key, root.getRightChild());

            } else {

                contains = contains(key, root.getLeftChild());

            }

        }

        return contains;
    };


    @Override
    public V find(K key) {
        TreeNode encontrado = null;
        TreeNode buscar = this.root;
        if (buscar.getKey() == key) {
            encontrado = buscar;
        } else {
            while (buscar != null) {
                if (buscar.getKey().compareTo(key) <0) {
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

    //funcion recursiva que recorra el arbol de forma inorder y devuelva una lista (arraylist) con los valores visitados
    @Override
    public ArrayList<V> inOrder() {
        ArrayList<V> lista = new ArrayList<V>();
        inOrder(root, lista);
        return lista;
    }

    private void inOrder(TreeNode<K,V> node, ArrayList<V> lista) {
        if (node != null) {
            inOrder(node.getLeftChild(), lista);
            lista.add(node.getValue());
            inOrder(node.getRightChild(), lista);
        }

    }
 }
