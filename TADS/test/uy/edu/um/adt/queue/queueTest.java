package uy.edu.um.adt.queue;
import org.junit.Test;
import static org.junit.Assert.*;

import uy.edu.um.adt.queue.EmptyQueueException;


class MyImplQueueTest {

    @Test
    void enqueue() {
        MyQueue<Integer> queue = new MyImplQueue<>();
        queue.enqueue(5);
        queue.enqueue(7);
        queue.enqueue(2);

        assertTrue(queue.contains(2));
    }

    @Test
    void dequeue() {
        MyQueue<Integer> queue = new MyImplQueue<>();
        queue.enqueue(5);
        queue.enqueue(7);
        queue.enqueue(2);

        try{
            assertEquals(5,queue.dequeue());
        } catch (EmptyQueueException e) {

        }
    }

    @Test
    void contains() {
        MyQueue<Integer> queue = new MyImplQueue<>();
        queue.enqueue(5);
        queue.enqueue(7);
        queue.enqueue(2);

        assertTrue(queue.contains(5));
        assertFalse(queue.contains(12));
    }

    @Test
    void size() {
        MyQueue<Integer> queue = new MyImplQueue<>();
        queue.enqueue(5);
        queue.enqueue(7);
        queue.enqueue(2);

        assertEquals(3,queue.size());
    }

    @Test
    void isEmpty() {
        MyQueue<Integer> queue = new MyImplQueue<>();
        queue.enqueue(5);
        queue.enqueue(7);
        queue.enqueue(2);

        MyQueue<Integer> queue2 = new MyImplQueue<>();

        assertTrue(queue2.isEmpty());
        assertFalse(queue.isEmpty());
    }
}