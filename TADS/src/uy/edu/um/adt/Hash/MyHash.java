package uy.edu.um.adt.Hash;

public interface MyHash<K, V> {

        public void put(K key, V value);
        public boolean contains(K key);
        public void remove(K clave);
        public int size();
        public V get(K key);

        int getTablesize();
}
