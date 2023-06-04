package uy.edu.um.adt.Hash;
import java.util.ArrayList;
import java.util.Arrays;

public class HashImpl<K,V> implements MyHash<K,V> {
    //implementar todas esas funciones con el hash cerrado usando hashcode()
    private HashNode[] hashTable;
    private int tableSize;

    public HashImpl(int size) {
        this.tableSize = size;
        this.hashTable = new HashNode[size];
    }

    //PUT DE UN HASH CERRADO
    @Override
    public void put(K key, V value) {
        int lugar = key.hashCode() % tableSize;
        HashNode<K, V> node = new HashNode<>(key, value);
        if (hashTable[lugar] == null || hashTable[lugar].isDeleted()) {
            hashTable[lugar] = node;
        } else {
            int i = 1;
            int newPosition = ((key.hashCode() + linearColision(i)) % tableSize);
            while (hashTable[newPosition] != null && !hashTable[newPosition].isDeleted() && i <= tableSize) {
                if (hashTable[newPosition].getKey().equals(key)) {
                    hashTable[newPosition].setValue(value);
                    return;
                }
                i++;
                newPosition = ((key.hashCode() + linearColision(i)) % tableSize);

            }
            if (i > tableSize) {
                doubleSize();
            }
            if(hashTable[newPosition] == null || hashTable[newPosition].isDeleted()) {
                hashTable[newPosition] = node;
            } else{
                this.put(key, value);
            }
        }

    }
    //double the size of the table and rehash all the elements
    private void doubleSize() {
        tableSize *= 2;
        HashNode[] oldTable = hashTable;
        hashTable = new HashNode[tableSize];
        Arrays.fill(hashTable, null);
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null) {
                put((K) oldTable[i].getKey(), (V) oldTable[i].getValue());
            }
        }
    }
    private int linearColision(int i) {
        return i;
    }

    //funcion que a partir de la key busca si el elemento esta en la hashTable
    @Override
    public boolean contains(K key) {
        int lugar = key.hashCode() % tableSize;
        int i = 1;
        if (hashTable[lugar] == null) {
            return false;
        } else if (hashTable[lugar].getKey().equals(key)) {
            if (hashTable[lugar].isDeleted()) {
                return false;
            } else {
                return true;
            }
        } else {
            int newPosition = ((key.hashCode() + linearColision(i)) % tableSize);
            while (i <= tableSize && hashTable[newPosition] != null && !hashTable[newPosition].isDeleted() && !hashTable[newPosition].getKey().equals(key)) {
                i++;
                newPosition = ((key.hashCode() + linearColision(i)) % tableSize);
            }
            if (i <= tableSize && hashTable[newPosition].getKey().equals(key) && !hashTable[newPosition].isDeleted()) {
                return true;
            } else {
                return false;
            }

        }
    }
    @Override
    public void remove(K clave) {
        int lugar = clave.hashCode() % tableSize;
        if (hashTable[lugar] != null && hashTable[lugar].getKey().equals(clave)) {
            hashTable[lugar].setDeleted(true);
        } else {
            int i = 1;
            int newPosition = ((clave.hashCode() + linearColision(i)) % tableSize);
            while (hashTable[newPosition] != null && !hashTable[newPosition].isDeleted() && !hashTable[newPosition].getKey().equals(clave) && i <= tableSize) {
                i++;
                newPosition = ((clave.hashCode() + linearColision(i)) % tableSize);
            }
            if (i <= tableSize) {
                hashTable[newPosition].setDeleted(true);
            }
        }


    }



    @Override
    public int size() {

        int contador = 0;
        for (int i = 0; i < tableSize; i++) {
            if (hashTable[i] != null && !hashTable[i].isDeleted()) {
                contador++;
            }
        }
        return contador;
    }


    @Override
    public V get(K key) {
        int position = key.hashCode() % tableSize;
        int i = 1;
        if(hashTable[position] == null){
            return null;
        }
        else
        if(hashTable[position].getKey().equals(key)){
            if(hashTable[position].isDeleted()){
                return null;
            }
            else {
                return (V) hashTable[position].getValue();
            }
        }
        else {
            int newPosition = ((key.hashCode() + linearColision(i)) % tableSize);
            while (i <= tableSize && hashTable[newPosition] != null && !hashTable[newPosition].isDeleted() && !hashTable[newPosition].getKey().equals(key)) {
                i++;
                newPosition = ((key.hashCode() + linearColision(i)) % tableSize);
            }
            if (hashTable[newPosition] == null || hashTable[newPosition].isDeleted()) {
                return null;
            }

            return (V) hashTable[newPosition].getValue();
        }

    }
}
