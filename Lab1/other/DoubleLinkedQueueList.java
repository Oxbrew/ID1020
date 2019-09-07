import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedQueueList<Item> implements Iterable<Item> {

    protected Node head;
    protected Node foot;
    protected int size;

    protected class Node {

        Item item;
        Node next = null;
        Node prev = null;

        public Node(Item item) {
            this.item = item;
        }
    }

    public DoubleLinkedQueueList() {
        head = null;
        foot = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void pushNode(Item item) {

        Node newNode = new Node(item);

        if (isEmpty()) {
            head = newNode;
            foot = newNode;
            size++;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
        }
        System.out.println("After push Operation: " + toString());
    }

    public void removeNode() {

        if (isEmpty()) {
            throw new NoSuchElementException("Empty collection");
        } else if (size == 1) {
            head = null;
            foot = null;
            System.out.println("No items in the List");
            size--;
            return;
        } else {
            foot = foot.prev;
            foot.next.prev = null;
            foot.next = null;
            size--;
        }
        System.out.println("After remove Operation: " + toString());
    }

    @Override
    public Iterator<Item> iterator() {

        return new Iterator<Item>() {

            Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                if (current == null) {
                    throw new NoSuchElementException();
                } else {
                    Node next = current;
                    current = current.next;
                    return next.item;
                }
            }
        };
    }

    public String toString() {

        if (isEmpty()) {
            System.out.println("Empty collection");
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (Item element : this) {
            stringBuilder.append("[" + element + "] , ");
        }
        return new String(stringBuilder);
    }

    public static void main(String[] args) {



    }
}
