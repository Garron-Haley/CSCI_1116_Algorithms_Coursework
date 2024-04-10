import java.util.LinkedList;

public class GenericQueue<E> extends LinkedList {

    public void enqueue(E e){
        addLast(e);
    }
    public E dequeue(){
        return (E) removeFirst();
    }
    public int getSize(){
        return size();
    }
    @Override
    public String toString(){
        return "Queue: " + toString();
    }

}
