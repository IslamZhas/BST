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
    public void put(K key, V value){
        Node node = new Node(key,value, 1);

        if(root == null) root = node;
        Node parent;
        Node current = root;

        while(root != null){
            parent = current;
            int compare = key.compareTo(current.key);

            if(compare < 0){
                current = current.left;
                if(current.left == null){
                    parent.left = node;
                    return;
                }
            }
            else if(compare > 0){
                current = current.right;
                if(current.right == null){
                    parent.right = node;
                    return;
                }
            }
            else current.value = value; return;
            current.size = getSize(current.left) + getSize(current.right) + 1;

        }
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


    public void delete(K key){
        Node current = root;
        if(current.key != null) return;
    }
    public Iterable<K> iterator(){
        return (Iterable<K>) new MyIterator(root);
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
