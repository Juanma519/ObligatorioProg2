package uy.edu.um.adt.priorityqueue;
import uy.edu.um.adt.Queue.EmptyQueueException;
import uy.edu.um.adt.Queue.MyQueue;
import uy.edu.um.adt.Queue.MyPriorityQueue;
import uy.edu.um.adt.Queue.ImplPriorityQueue;
import uy.edu.um.adt.Queue.EmptyQueueException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class ImplPriorityQueueTest {

    private ImplPriorityQueue<Integer> priorityQueue;


    @Test

    public void testEnqueueWithPriority() throws EmptyQueueException {
        priorityQueue = new ImplPriorityQueue<>();
        priorityQueue.enqueueWithPriority(5, 1);
        priorityQueue.enqueueWithPriority(2, 3);
        priorityQueue.enqueueWithPriority(7, 2);

        Assertions.assertEquals(5, priorityQueue.dequeue());
        Assertions.assertEquals(7, priorityQueue.dequeue());
        Assertions.assertEquals(2, priorityQueue.dequeue());
    }
}
