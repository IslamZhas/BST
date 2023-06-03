import java.util.Iterator;

public class BST<K extends Comparable<K>, V> {
    private Node root;
    private class Node {
        private K key;
        private V value;
        private Node left, right;
        int size;
        public Node(K key, V value, int size){
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }
    private Node min(Node node){
        if(node.left == null) return node;
        return min(node.left);
    }
    private Node max(Node node){
        if(node.right == null) return node;
        return(node.right);
    }
    public int getSize(Node node){
        if(node == null) return 0;
        else return node.size + 1;
    }
    public void put(K key, V value) {
        root = putNode(root, key, value);
    }

    private Node putNode(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value, 1);
        }

        int compare = key.compareTo(node.key);

        if (compare < 0) {
            node.left = putNode(node.left, key, value);
        } else if (compare > 0) {
            node.right = putNode(node.right, key, value);
        } else {
            node.value = value; 
        }

        node.size = getSize(node.left) + getSize(node.right) + 1;
        return node;
    }
    public V get(K key){
        Node node = root;
        while(node != null){
            int compare = key.compareTo(node.key);
            if(compare < 0) node = node.left;
            else if(compare > 0) node = node.right;
            else return node.value;
        }
        return null;
    }


    public void delete(K key) {
        root = deleteNode(root, key);
    }

    private Node deleteNode(Node node, K key) {
        if (node == null) {
            return null;
        }

        int compare = key.compareTo(node.key);

        if (compare < 0) {
            node.left = deleteNode(node.left, key);
        } else if (compare > 0) {
            node.right = deleteNode(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            Node mini = min(node.right);
            node.key = mini.key;
            node.value = mini.value;
            node.right = deleteNode(node.right, mini.key);
        }

        node.size = getSize(node.left) + getSize(node.right) + 1;
        return node;
    }
    public Iterator<K> iterator(){
        return new MyIterator(root);
    }
    private class MyIterator implements Iterator<K>{
        private Node next;
        public MyIterator(Node root){
            next = root;
            if(next == null) return;
            while(next.left != null) next = next.left;
        }
        public boolean hasNext(){
            return next != null;
        }

        @Override
        public K next() {
            Node current = next;
            K key = current.key;

            if(current.right != null) current = current.right;

            next = current;
            return key;
        }

        public void inOrder(Node root){
            if (root == null) return;
            inOrder(root.left);
            System.out.println(root.value + " ");
            inOrder(root.right);
        }
    }
}
