import java.util.Iterator;

public class GLLIterator<T> implements Iterator<T> {
    GenericList.Node<T> current;

    public GLLIterator(GenericList.Node<T> head) {
        this.current = head;
    }

    @Override
    public boolean hasNext() {
        // if current is null,
        // there's no next
        return current != null;
    }

    // Stores current item
    // Move to the next one
    // returns stored item
    @Override
    public T next() {
        GenericList.Node<T> temp = current;

        current = current.next;

        return temp.data;
    }
}
