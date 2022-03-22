import javafx.util.Pair;

public class MyTreeMap<K extends Comparable<K>, V> implements MyMap<K, V> {
    private MyTreeMap<K, V> left;
    private MyTreeMap<K, V> right;
    private Pair<K, V> pair;

    @Override
    public void add(K key, V value) {
        if (pair == null) {
            pair = new Pair(key, value);
        } else {
            int comp = pair.getKey().compareTo(key);
            if (comp == 0) {
                pair = new Pair(key, value);
            } else if(comp > 0) {// влево
                if (left == null) {
                    MyTreeMap tree = new MyTreeMap();
                    tree.pair = new Pair(key, value);
                    this.left = tree;
                } else {
                    left.add(key, value);
                }
            } else { // вправо
                if (right == null) {
                    MyTreeMap tree = new MyTreeMap();
                    tree.pair = new Pair(key, value);
                    this.right = tree;
                } else {
                    right.add(key, value);
                }
            }
        }
    }

    @Override
    public V get(K key) {
        if (pair.getKey().equals(key)) {
            return pair.getValue();
        }
        int comp = pair.getKey().compareTo(key);
        if (comp == 0) {
            return pair.getValue();
        } else if (comp > 0) {
            if (left == null) return null;
            return left.get(key);
        } else {
            if (right == null) return null;
            return right.get(key);
        }
    }
}
