import java.util.ArrayList;
import java.util.Iterator;

public abstract class GenericList<T> implements Iterable<T> {
    private Node<T> head;
    private int length;

    public static class Node<T> {
        T data;
        int code;
        Node<T> next;
    }

    public GenericList() {

    }

    public void print() {
    //ttttt
    }

    public abstract void add(T data);

    public abstract T delete();

    public ArrayList<T> dumpList() {
        return null;
    }

    public T get( int index) {
        return null;
    }

    public T set( int index, T element) {
        return null;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {

    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(T head) {

    }

    public Iterator<T> descendingIterator() {
        return null;
    }
}
