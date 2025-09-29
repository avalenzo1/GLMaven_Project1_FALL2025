import java.util.ArrayList;
import java.util.Iterator;

public class MyHashMap<T> implements Iterable<T> {
    public final ArrayList<GenericQueue<T>> map;
    private int size = 0;

    MyHashMap(String key, T value) {
        map = new ArrayList<>(); // initialize map with 10 empty spots

        for (int i = 0; i < 10; i++) {
            map.add(null);
        }

        put(key, value);
    }

    // Adds key, val pair to map
    void put(String key, T value) {
        int code = key.hashCode();

        // get bucket
        GenericQueue<T> gq = map.get(code & 9);

        if (gq == null) {
            // init GQ if null
            gq = new GenericQueue<>();
        }

        // add item to gq
        gq.add(value, code);

        // set to map
        map.set(code & 9, gq);

        size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new HMIterator<>(this);
    }

    // this method will check to see if the given key exists in
    // the HashMap and return true if yes and false if no.
    public boolean contains(String key) {
        return get(key) != null;
    }

    // this method will return the value at the given key or return null if
    // it does not exist.
    public T get(String key) {
        int code = key.hashCode();

        GenericQueue<T> gq = map.get(code & 9);

        if (gq == null) { return null; }

        // Figure out a way to access the node code since get for generic queue
        // only returns T, not T + code
        // Need code to determine the UNIQUE KEY-VALUE pair in case there are duplicates.

        return gq.getByCode(code);
    }


    // returns the number of key-value mappings in the map.
    public int size() {
        return size;
    }

    //  returns true if this map contains no key-value mappings.
    public boolean isEmpty() {
        return size == 0;
    }

    // replaces the entry for the specified key only if it is
    // currently mapped to some value.
    public T replace(String key, T value) {
        int code = key.hashCode();

        GenericQueue<T> gq = map.get(code & 9);

        if (gq == null) {
            return null;
        }

        return gq.replaceByCode(code, value);
    }


}
