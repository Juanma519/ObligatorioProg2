package uy.edu.um.adt.BinaryTree;

public class TreeNode<T extends Comparable<T>,E> {


    E value;  /* valor o datos del nodo */
    T key;
    TreeNode leftchild;
    TreeNode rightchild;

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public TreeNode getLeftChild() {
        return leftchild;
    }

    public void setLeftChild(TreeNode leftchild) {
        this.leftchild = leftchild;
    }

    public TreeNode getRightChild() {
        return rightchild;
    }

    public void setRightChild(TreeNode rightchild) {
        this.rightchild = rightchild;
    }
    /* metodos*/

    public TreeNode(T key, E value) {
        this.value = value;
        this.key = key;
    }

}



