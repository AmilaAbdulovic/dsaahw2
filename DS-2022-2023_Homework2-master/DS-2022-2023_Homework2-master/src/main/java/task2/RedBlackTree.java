package task2;


public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private Node<Key, Value> root;
    private int numSteps;
    private int redLinksCount;

    public RedBlackTree() {
        root = null;
        numSteps = 0;
        redLinksCount = 0;
    }

    public Value get(Key key) {
        numSteps = 0;
        Node<Key, Value> node = get(root, key);
        return (node != null) ? node.getValue() : null;
    }

    private Node<Key, Value> get(Node<Key, Value> node, Key key) {
        if (node == null || key.equals(node.getKey())) {
            return node;
        }

        numSteps++;

        if (key.compareTo(node.getKey()) < 0) {
            return get(node.getLeft(), key);
        } else {
            return get(node.getRight(), key);
        }
    }

    private void flipColors(Node<Key, Value> node) {
        node.setRed(!node.isRed());
        node.getLeft().setRed(!node.getLeft().isRed());
        node.getRight().setRed(!node.getRight().isRed());
    }

    private Node<Key, Value> rotateRight(Node<Key, Value> node) {
        Node<Key, Value> x = node.getLeft();
        node.setLeft(x.getRight());
        x.setRight(node);
        x.setRed(node.isRed());
        node.setRed(true);
        return x;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.setRed(false); // Root should always be black
    }

    private Node<Key, Value> put(Node<Key, Value> node, Key key, Value value) {
        if (node == null) {
            return new Node<>(key, value, true);
        }

        int cmp = key.compareTo(node.getKey());
        if (cmp < 0) {
            node.setLeft(put(node.getLeft(), key, value));
        } else if (cmp > 0) {
            node.setRight(put(node.getRight(), key, value));
        } else {
            node.setValue(value);
        }

        if (isRed(node.getRight()) && !isRed(node.getLeft())) {
            node = rotateLeft(node);
        }
        if (isRed(node.getLeft()) && isRed(node.getLeft().getLeft())) {
            node = rotateRight(node);
        }
        if (isRed(node.getLeft()) && isRed(node.getRight())) {
            flipColors(node);
        }

        if (isRed(node)) {
            redLinksCount++;
        }

        return node;
    }

    private boolean isRed(Node<Key, Value> node) {
        return node != null && node.isRed();
    }

    private Node<Key, Value> rotateLeft(Node<Key, Value> node) {
        Node<Key, Value> x = node.getRight();
        node.setRight(x.getLeft());
        x.setLeft(node);
        x.setRed(node.isRed());
        node.setRed(true);
        return x;
    }

    public int getNumSteps() {
        return numSteps;
    }

    public int getRedLinksCount() {
        return redLinksCount;
    }
}
