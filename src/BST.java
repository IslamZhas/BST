import java.util.Iterator;

public class BST<K extends Comparable<K>, V> {
    private Node root;
    private class Node {
        private K key;
        private V value;
        private Node left, right;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
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
        else return getSize(node.left) + getSize(node.right) + 1;
    }
    public void put(K key, V value){
        Node node = root;
        while(node != null){
            int compare = key.compareTo(node.key);
            if(compare < 0) node = node.left;
            else if(compare > 0) node = node.right;
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


    public void delete(K key){}
    public Iterable<K> iterator(){
        return new MyIterator(root);
    }
    private class MyIterator implements Iterable<K>{
        private Node next;
        public MyIterator(Node root){
            next = root;
            if(next == null) return;
            while(next.left != null) next = next.left;
        }

        @Override
        public Iterator<K> iterator() {
            return null;
        }
        public void inOrder(Node root){
            if (root == null) return;
            inOrder(root.left);
            System.out.println(root.value + " ");
            inOrder(root.right);
        }
    }
}
