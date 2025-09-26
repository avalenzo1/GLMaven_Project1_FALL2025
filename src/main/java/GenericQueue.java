import java.util.Iterator;

public class GenericQueue<T> extends GenericList<T> {
     Node<T> tail;

    @Override
    public void add(T data) {
        Node<T> newNode = new Node<T>();
        newNode.data = data;

        if (getLength()==0) {
            setHead(newNode);
        }
        else{
            tail.next = newNode;
        }

        tail = newNode;

        setLength(getLength()+1);
    }

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

    public void enqueue(T data){
        add(data);
    }
    public T dequeue(){
        return delete();
    }
}
