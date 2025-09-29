import java.util.Iterator;

public class GenericQueue<T> extends GenericList<T> {
     Node<T> tail;

     // add item to tail of list
    @Override
    public void add(T data) {
        Node<T> newNode = new Node<T>();
        newNode.data = data;

        if (getLength()==0) {
            setHead(newNode);
        }
        else{
            getTail().next = newNode;
        }

        setTail(newNode);

        setLength(getLength()+1);
    }

    // add item to tail of list
    // adds code to node too
    public void add(T data, int code) {
        add(data);
        getTail().code = code;
    }


    // deletes head from gq returns old head
    @Override
    public T delete() {
        Node<T> tempHead = getHead();

        if(getLength() == 0) {
            return null;
        }

        setHead(tempHead.next);
        setLength(getLength()-1);

        return tempHead.data;
    }

    // adds item to head
    public void enqueue(T data){
        add(data);
    }

    // adds item to tail
    public T dequeue(){
        return delete();
    }

    public Node<T> getTail() {
        return tail;
    }
    public void setTail(Node<T> tail) {
        this.tail = tail;
    }
}
