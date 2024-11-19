package 队列;
//FIFO
public interface Queue<E> {
      void enqueue(E e);
      E dequeue();
      E getFront();
      int getSize();
      boolean isEmpty();
}
