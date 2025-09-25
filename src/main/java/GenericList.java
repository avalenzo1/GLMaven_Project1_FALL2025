import java.util.ArrayList;
import java.util.Iterator;

public abstract class GenericList<T> implements Iterable<T> {
    private Node<T> head;
    private int length;
    public abstract void add(T data);

    public abstract T delete();
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

    public T set(int index, T element) {
        Node<T> tempNode = head;
        T oldElement = tempNode.data;

        for(int i = 0; i < index; i++) {
            if (tempNode == null) {
                return null;
            }

            tempNode = tempNode.next;
        }

        tempNode.data = element;

        return oldElement;
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
        return new ReverseGLLIterator<T>(getHead());
    }
}
