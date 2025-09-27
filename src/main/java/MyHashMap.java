import java.util.ArrayList;
import java.util.Iterator;

public class MyHashMap<T> implements Iterable<T> {
    ArrayList<GenericQueue<T>> map;

    MyHashMap(String key, T value) {
        map = new ArrayList<>(); // initialize map with 10 spots

        for (int i = 0; i < 10; i++) {
            map.add(new GenericQueue<T>());
        }

        System.out.println(map.size());

        put(key, value);
    }

    void put(String key, T value) {
        int code = key.hashCode();

        GenericQueue<T> gq = map.get(code & 9);

        gq.enqueue(value);
    }

    @Override
    public Iterator<T> iterator() {
        return new HMIterator<>(this);
    }

    // this method will check to see if the given key exists in
    // the HashMap and return true if yes and false if no.
    public boolean contains(String key) {
        int code = key.hashCode();

        GenericQueue<T> gq = map.get(code & 9);

//        gq.get(code);

        return false;
    }

    // this method will return the value at the given key or return null if
    // it does not exist.
    public T get(String key) {
        return null;
    }

    // returns the number of key-value mappings in the map.
    public int size() {
        return 0;
    }

    //  returns true if this map contains no key-value mappings.
    public boolean isEmpty() {
        return false;
    }

    // replaces the entry for the specified key only if it is
    // currently mapped to some value.
    public T replace(String key, T value) {
        return null;
    }

}
