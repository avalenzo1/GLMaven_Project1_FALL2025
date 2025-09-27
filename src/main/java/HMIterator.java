import java.util.Iterator;

public class HMIterator<T> implements Iterator<T> {
    HMIterator(MyHashMap<T> myHashMap) {

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }
}
