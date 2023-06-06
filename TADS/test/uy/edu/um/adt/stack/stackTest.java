package uy.edu.um.adt.stack;
import org.junit.Test;

import static org.junit.Assert.*;

import uy.edu.um.adt.stack.EmptyStackException;


class MyImplStackTest {

    @Test
    void pop() {
        MyStack<Integer> stack = new MyImplStack<>();
        stack.push(5);
        stack.push(4);
        stack.push(7);
        stack.push(1);

        try {
            assertEquals(1,stack.pop());
            assertEquals(7,stack.pop());
            assertEquals(4,stack.pop());
            assertEquals(5,stack.pop());
        } catch (EmptyStackException e) {

        }
        assertEquals(0,stack.size());
        try {
            assertEquals(1,stack.pop());//salta exception
        } catch (EmptyStackException e) {
            System.out.println("Empty stack");
        }
    }

    @Test
    void push() {
        MyStack<Integer> stack = new MyImplStack<>();
        stack.push(5);
        stack.push(4);
        stack.push(7);
        stack.push(1);

        assertEquals(4,stack.size());
    }

    @Test
    void isEmpty() {
        MyStack<Integer> stack = new MyImplStack<>();
        stack.push(5);
        assertFalse(stack.isEmpty());
        try {
            assertEquals(5,stack.pop());
        } catch (EmptyStackException e) {

        }
        assertTrue(stack.isEmpty());

        MyStack<Integer> stack2 = new MyImplStack<>();
        assertTrue(stack2.isEmpty());
    }

    @Test
    void peek() {
        MyStack<Integer> stack = new MyImplStack<>();
        stack.push(5);
        stack.push(4);
        stack.push(7);
        stack.push(1);

        try {
            assertEquals(1,stack.peek());
        } catch (EmptyStackException e) {

        }
        try {
            assertEquals(1,stack.pop());
        } catch (EmptyStackException e) {

        }
        try {
            assertEquals(7,stack.peek());
        } catch (EmptyStackException e) {
        }
        try {
            assertEquals(7,stack.pop());
            assertEquals(4,stack.pop());
            assertEquals(5,stack.pop());

            assertEquals(7,stack.peek());//salta error
        } catch (EmptyStackException e) {
            System.out.println("empty stack");
        }

    }

    @Test
    void size() {
        MyStack<Integer> stack = new MyImplStack<>();
        stack.push(5);
        stack.push(4);
        stack.push(7);
        stack.push(1);

        assertEquals(4,stack.size());

        MyStack<Integer> stack2 = new MyImplStack<>();
        assertEquals(0,stack2.size());
    }
}