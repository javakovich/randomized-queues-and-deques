import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created by slazakovich on 9/12/2016.
 */
public class Deque<Item> implements Iterable<Item>{

    private Node pre;     // sentinel before first item
    private Node post;    // sentinel after last item
    private int size;

    // construct an empty deque
    public Deque() {
        pre = new Node();
        post = new Node();
        pre.next = post;
        post.prev = pre;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty(){
        return size == 0;
    }

    // return the number of items on the deque
    public int size(){
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        Node oldFirst = pre.next;
        Node newFirst = new Node();
        newFirst.item = item;
        newFirst.prev = pre;
        newFirst.next = oldFirst;
        pre.next = newFirst;
        oldFirst.prev = newFirst;
        size++;

    }

    // add the item to the end
    public void addLast(Item item){
        if (item == null) {
            throw new NullPointerException();
        }
        Node oldLast = post.prev;
        Node newLast = new Node();
        newLast.item = item;
        newLast.next = post;
        newLast.prev = oldLast;
        post.prev = newLast;
        oldLast.next = newLast;
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node oldFirst = pre.next;
        Node newFirst = pre.next.next;
        pre.next = newFirst;
        newFirst.prev = pre;
        size--;
        return oldFirst.item;
    }

    // remove and return the item from the end
    public Item removeLast(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node oldLast = post.prev;
        Node newLast = post.prev.prev;
        post.prev = newLast;
        newLast.next = post;
        size--;
        return oldLast.item;

    }

    @Override
    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        private Node current = pre.next;

        @Override
        public boolean hasNext() {
            return current != post;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    // linked list node helper data type
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    // unit testing
    public static void main(String[] args) {
        Deque<String> deque = new Deque<String>();
        deque.addFirst("aaa");
        deque.addFirst("bbb");
        deque.addLast("ccc");
        for (String item : deque) {
            StdOut.println(item);
        }
        StdOut.println(deque.size());
        deque.removeFirst();
        deque.removeLast();
        for (String item : deque) {
            StdOut.println(item);
        }
        StdOut.println(deque.size());
        deque.removeLast();
        for (String item : deque) {
            StdOut.println(item);
        }

        StdOut.println(deque.size());

        deque.addFirst("xxx");
        deque.addLast("yyy");
        for (String item : deque) {
            StdOut.println(item);
        }
        StdOut.println(deque.size());

    }
}
