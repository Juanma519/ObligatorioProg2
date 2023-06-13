package uy.edu.um.adt.Hash;
import java.util.ArrayList;
import java.util.Arrays;

public class HashImpl<K,V> implements MyHash<K,V> {

    private HashNode[] hashTable;
    private int tableSize;
    private int contadorPut=0;

    public HashImpl(int size) {
        this.tableSize = size;
        this.hashTable = new HashNode[size];
    }

    @Override
    public void put(K key, V value) {
        int lugar = key.hashCode() % tableSize;
        if (lugar < 0) {
            lugar = lugar * -1;
        }
        HashNode<K, V> node = new HashNode<>(key, value);
        if (hashTable[lugar] == null || hashTable[lugar].isDeleted()) {
            hashTable[lugar] = node;
            contadorPut++;
        } else {
            int i = 1;
            int newPosition = ((key.hashCode() + linearColision(i)) % tableSize);
            if (newPosition < 0) {
                newPosition = newPosition * -1;
            }
            while (hashTable[newPosition] != null && !hashTable[newPosition].isDeleted() && i <= tableSize) {
                if (hashTable[newPosition].getKey().equals(key)) {
                    hashTable[newPosition].setValue(value);
                    contadorPut++;
                    return;
                }
                i++;
                newPosition = ((key.hashCode() + linearColision(i)) % tableSize);
                if (newPosition < 0) {
                    newPosition = newPosition * -1;
                }

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
    //duplica el tamaño del hash
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
        if (lugar < 0) {
            lugar = lugar * -1;
        }
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
            if (newPosition < 0) {
                newPosition = newPosition * -1;
            }
            while (i <= tableSize && hashTable[newPosition] != null && !hashTable[newPosition].isDeleted() && !hashTable[newPosition].getKey().equals(key)) {
                i++;
                newPosition = ((key.hashCode() + linearColision(i)) % tableSize);
                if (newPosition < 0) {
                    newPosition = newPosition * -1;
                }
            }
            if (hashTable[newPosition] == null) {
                return false;
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
        if (lugar < 0) {
            lugar = lugar * -1;
        }
        if (hashTable[lugar] != null && hashTable[lugar].getKey().equals(clave)) {
            hashTable[lugar].setDeleted(true);
            contadorPut--;
        } else {
            int i = 1;
            int newPosition = ((clave.hashCode() + linearColision(i)) % tableSize);
            if (newPosition < 0) {
                newPosition = newPosition * -1;
            }
            while (hashTable[newPosition] != null && !hashTable[newPosition].isDeleted() && !hashTable[newPosition].getKey().equals(clave) && i <= tableSize) {
                i++;
                newPosition = ((clave.hashCode() + linearColision(i)) % tableSize);
                if (newPosition < 0) {
                    newPosition = newPosition * -1;
                }
            }
            if (i <= tableSize) {
                hashTable[newPosition].setDeleted(true);
                contadorPut--;
            }
        }


    }



    @Override
    public int size() {
        return contadorPut;
    }


    @Override
    public V get(K key) {
        int position = key.hashCode() % tableSize;
        if(position < 0){
            position = position * -1;
        }
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
            if (newPosition < 0) {
                newPosition = newPosition * -1;
            }
            while (i <= tableSize && hashTable[newPosition] != null && !hashTable[newPosition].isDeleted() && !hashTable[newPosition].getKey().equals(key)) {
                i++;
                newPosition = ((key.hashCode() + linearColision(i)) % tableSize);
                if (newPosition < 0) {
                    newPosition = newPosition * -1;
                }
            }
            if (hashTable[newPosition] == null || hashTable[newPosition].isDeleted()) {
                return null;
            }

            return (V) hashTable[newPosition].getValue();
        }

    }
}
