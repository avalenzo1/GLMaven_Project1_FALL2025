import java.util.ArrayList;
import java.util.Iterator;

public abstract class GenericList<T> implements Iterable<T> {
    private Node<T> head;
    private int length;
    public abstract void add(T data);

    public abstract T delete();
    public static class Node<T> {
        T data;
        int code;       // Stores key hashcode
        Node<T> next;
    }

    public GenericList() {

    }

    // Prints all items in list
    public void print() {
        // If empty print empty list
        if(length == 0) {
            System.out.println("Empty List");
        }

        // Print list
        Node<T> temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    // Print list
    public ArrayList<T> dumpList() {
        ArrayList<T> list = new ArrayList<>();

        // Add items to list
        Node<T> temp = head;
        while(temp != null) {
            list.add(temp.data);
            temp = temp.next;
        }

        return list;
    }

    // Replaces item in GL by Node code, returns old item
    public T replaceByCode(int code, T data) {
        Node<T> tempNode = head;

        while (tempNode != null) {
            if (tempNode.code == code) {
                //  If code found store oldVal replace curr node with new data and return old val
                T oldValue = tempNode.data;
                tempNode.data = data;

                return oldValue;
            }

            tempNode = tempNode.next;
        }

        return null;
    }

    // returns node item by code
    public T getByCode(int code) {
        Node<T> tempNode = head;

        while (tempNode != null) {
            if (tempNode.code == code) {
                return tempNode.data;
            }

            tempNode = tempNode.next;
        }

        return null;
    }

    // find item by index
    public T get(int index) {
      Node<T> tempNode = head;

      for(int i = 0; i < index; i++) {
        if (tempNode == null) {
            return null;
        }

        tempNode = tempNode.next;
      }

      return tempNode.data;
    }

    // set existing item in list by index, return old element
    public T set(int index, T element) {
        Node<T> tempNode = head;

        for(int i = 0; i < index; i++) {
            if (tempNode == null) {
                return null;
            }

            tempNode = tempNode.next;
        }

        T oldElement = tempNode.data;
        tempNode.data = element;

        return oldElement;
    }

    public int getLength() {
        return length;
    }

    protected void setLength(int length) {
        this.length = length;
    }

    public Node<T> getHead() {
        return head;
    }

    protected void setHead(Node<T> head) {
        this.head = head;
    }

    // iterates by list
    public Iterator<T> iterator() {
        return new GLLIterator<>(getHead());
    }

    // returns iterator from tail to head
    public Iterator<T> descendingIterator() {
        return new ReverseGLLIterator<T>(getHead());
    }
}
