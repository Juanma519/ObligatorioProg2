package uy.edu.um.adt.Hash;
import java.util.ArrayList;

public class Hash<K,V> implements MyHash<K,V> {
    //implementar todas esas funciones con el hash cerrado usando hashcode()
    private ArrayList<V> hashTable;
    private int tableSize;

    public Hash(int size) {
        this.tableSize = size;
        this.hashTable = new ArrayList<>(size);
    }

    //PUT DE UN HASH CERRADO
    @Override
    public void put(K key, V value) {
        int position = key.hashCode() % tableSize;
        if (hashTable.get(position) == null) {
            hashTable.set(position, value);
        } else {
            int i = 1;
            while (hashTable.get(position) != null) {
                position = (key.hashCode() + i) % tableSize;
                i++;
            }
            hashTable.set(position, value);
        }

    }

    //funcion que a partir de la key busca si el elemento esta en la hashTable
    @Override
    public boolean contains(K key) {
        int position = key.hashCode() % tableSize;
        if (hashTable.get(position) == null) {
            return false;
        } else {//FALTA ALGO

        }

        return false;
    }

    @Override
    public void remove(K clave) {
        int position = clave.hashCode() % tableSize;
        if (hashTable.get(position) == null) {
            System.out.println("No se encontro el elemento");//MIRAR ACA
        } else {
            hashTable.set(position, null);
        }

    }

    @Override
    public int size() {
        return tableSize;
    }

    @Override
    public V get(K key) {
        int position = key.hashCode() % tableSize;
        if (hashTable.get(position) == null) {
            return null;
        } else { //algo esta mal aca
            return hashTable.get(position);
        }

    }
}