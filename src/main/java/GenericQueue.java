import java.util.Iterator;

public class GenericQueue<T> extends GenericList<T> {
     Node<T> tail;

    @Override
    public void add(T data) {
        Node<T> newNode = new Node<T>();
        newNode.data = data;
        if(getLength()==0){
            setHead(newNode);
        }
        else{
            tail.next = newNode;
        }
    }

    @Override
    public T delete() {
        Node<T> tempHead = new Node<T>();

        if(getLength() == 0) {
            return null;
        }
        else{
           tempHead = getHead();
           setHead(tempHead.next);
        }
        return tempHead.data;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public void enqueue(T data){
        add(data);
    }
    public T dequeue(){
        return delete();
    }
}
