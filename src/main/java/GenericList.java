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
        if(length == 0) {
            System.out.println("Empty List");
        }

        Node<T> temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public abstract void add(T data);

    public abstract T delete();

    public ArrayList<T> dumpList() {
        ArrayList<T> list = new ArrayList<>();

        Node<T> temp = head;
        while(temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }

        return list;
    }

    public T get( int index) {
      Node<T> tempNode = head;
        for(int i = 0; i < index; i++) {
            if (tempNode == null) {
                return null;
            }

            tempNode = tempNode.next;
      }
      return tempNode.data;
    }

    public T set( int index, T element) {
        Node<T> tempNode = head;

        for(int i = 0; i < index; i++) {
            if (tempNode == null) {
                return null;
            }

            tempNode = tempNode.next;
        }
        tempNode.data = element;
        return head.data;

    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Iterator<T> descendingIterator() {
        Iterator<T> iterator = new Iterator<T>() {
            private ArrayList<T> list = dumpList();
            private int index = list.size() - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public T next() {
                T next = null;

                if (index >= 0) {
                    next = list.get(index);
                }

                index -= 1;

                return next;
            }
        };

        return iterator;
    }
}
