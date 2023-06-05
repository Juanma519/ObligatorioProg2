package uy.edu.um.adt.BinaryTree;

import java.lang.Comparable;

import uy.edu.um.adt.LinkedList.MyLinkedListImpl;
public class BinarySearchTreeImpl<K extends Comparable<K>,V> implements BinarySearchTree<K,V>{
    private TreeNode<K,V> root;

    public BinarySearchTreeImpl() {
        this.root = null;
    }

    @Override
    public void add(K key, V value) {
        TreeNode<K,V> nuevo = new TreeNode(key, value);
        if (this.root == null) {
            this.root = nuevo;
        }
        else {
            TreeNode<K,V> currentNode = this.root;
            TreeNode<K,V> parentNode = null;
            while (currentNode != null){
                parentNode = currentNode;
                if (currentNode.key.compareTo(key) > 0){
                    currentNode = currentNode.getLeftChild();
                }else{
                    currentNode = currentNode.getRightChild();
                }
            }
            if (parentNode.key.compareTo(key) > 0){
                parentNode.setLeftChild(nuevo);
            }else{
                parentNode.setRightChild(nuevo);
            }
        }

    }

    //funcion que elimine un nodo
    @Override
    public void remove(K key) {
        TreeNode<K,V> currentNode = this.root;
        TreeNode<K,V> parentNode = null;
        while (currentNode != null){
            if (currentNode.key.equals(key)){
                if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null){
                    if (parentNode == null){
                        this.root = null;
                    }else if (parentNode.getLeftChild() == currentNode){
                        parentNode.setLeftChild(null);
                    }else{
                        parentNode.setRightChild(null);
                    }
                }else if (currentNode.getLeftChild() == null){
                    if (parentNode == null){
                        this.root = currentNode.getRightChild();
                    }else if (parentNode.getLeftChild() == currentNode){
                        parentNode.setLeftChild(currentNode.getRightChild());
                    }else{
                        parentNode.setRightChild(currentNode.getRightChild());
                    }
                }else if (currentNode.getRightChild() == null){
                    if (parentNode == null){
                        this.root = currentNode.getLeftChild();
                    }else if (parentNode.getLeftChild() == currentNode){
                        parentNode.setLeftChild(currentNode.getLeftChild());
                    }else{
                        parentNode.setRightChild(currentNode.getLeftChild());
                    }
                }else{
                    TreeNode<K,V> minNode = currentNode.getRightChild();
                    TreeNode<K,V> minNodeParent = currentNode;
                    while (minNode.getLeftChild() != null){
                        minNodeParent = minNode;
                        minNode = minNode.getLeftChild();
                    }
                    currentNode.key = minNode.key;
                    currentNode.setValue( minNode.getValue());
                    if (minNodeParent.getLeftChild() == minNode){
                        minNodeParent.setLeftChild(minNode.getRightChild());
                    }else{
                        minNodeParent.setRightChild(minNode.getRightChild());
                    }
                }
                return;
            }else if (currentNode.key.compareTo(key) > 0){
                parentNode = currentNode;
                currentNode = currentNode.getLeftChild();
            }else{
                parentNode = currentNode;
                currentNode = currentNode.getRightChild();
            }
        }

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
        TreeNode<K, V> currentNode = this.root; //root es el nodo raiz
        while (currentNode != null) {
            if (currentNode.key.equals(key)) { //equals es para comparar objetos
                return currentNode.getValue();
            } else if (currentNode.key.compareTo(key) > 0) { //si es mayor a 0, entonces es mayor
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }
        }
        if (currentNode == null) {
            return null;
        }
        return currentNode.getValue();
    }

    @Override
    public MyLinkedListImpl inOrder() {
        MyLinkedListImpl<K> list = new MyLinkedListImpl<>();
        TreeNode<K,V> currentNode = this.root;
        while (currentNode != null){
            if (currentNode.getLeftChild() == null){
                list.add(currentNode.key);
                currentNode = currentNode.getRightChild();
            }else{
                TreeNode<K,V> predecesor = currentNode.getLeftChild();
                while (predecesor.getRightChild() != null && predecesor.getRightChild() != currentNode){
                    predecesor = predecesor.getRightChild();
                }
                if (predecesor.getRightChild() == null){
                    predecesor.setRightChild(currentNode);
                    currentNode = currentNode.getLeftChild();
                }else{
                    predecesor.setRightChild(null);
                    list.add(currentNode.key);
                    currentNode = currentNode.getRightChild();
                }
            }
        }

        return list;

    }
    //funcion que cuente el numero de nodos
    @Override
    public int size() {
        return contador(this.root);

    }


    public int contador(TreeNode<K, V> currentNode){
        if(currentNode == null) {
            return 0;
        }else{
            int leftSize = contador(currentNode.getLeftChild());
            int rightSize = contador(currentNode.getRightChild());
            return leftSize + rightSize + 1;
        }
    }

}
