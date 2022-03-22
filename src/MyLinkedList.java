import com.sun.javaws.exceptions.InvalidArgumentException;
import org.w3c.dom.Node;

public class MyLinkedList<T> implements MyList<T> {
    private Node<T> left;
    private Node<T> right;
    private int size = 0;

    @Override
    public void add(T v) {
        size++;
        Node<T> node = new Node<>(v);
        if (left == null) {
            // Список пустой
            left = node;
            right = node;
        } else {
            right.setNext(node);
            node.setPrevious(right);
            right = node;
        }
    }

    @Override
    public T get(int index) {
        return getNode(index).getValue();
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) throw new RuntimeException("Выход за границы списка");
        Node<T> node = left;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) throw new RuntimeException("Выход за границы списка");
        if (size == 1) {
            left = null;
            right = null;
        } else if (index == 0) {
            left.getNext().setPrevious(null);
            Node<T> ne = left.getNext();
            left.setNext(null);
            left = ne;
        } else if(index == size - 1) {
            Node<T> pr = right.getPrevious();
            right.setPrevious(null);
            pr.setNext(null);
            right = pr;
        } else {
            Node<T> node = getNode(index);
            Node<T> nl = node.getPrevious();
            Node<T> nr = node.getNext();
            node.setNext(null);
            node.setPrevious(null);
            nl.setNext(nr);
            nr.setPrevious(nl);
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    private class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> previous;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
        public Node<T> getNext() {
            return next;
        }
        public void setNext(Node<T> next) {
            this.next = next;
        }
        public Node<T> getPrevious() {
            return previous;
        }
        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }
    }
}
