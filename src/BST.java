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
        return(node.left);
    }
    private Node max(Node node){
        if(node.right == null) return node;
        return(node.right);
    }
    public int getSize(Node node){
        if(node == null) return 0;
        else return getSize(node.left) + getSize(node.right) + 1;
    }
    public void put(K key, V value){}
    public V get(K key){return get(root, key);}
    public V get(Node node, K key){
     if(node == null) return null;
     int result = key.compareTo(node.key);

    }
    private V get(Node x, K key){
        
    }
    public void delete(K key){}
    public Iterable<K> iterator(){
        return new MyIterator();
    }
    private class MyIterator implements Iterable<K>{
        private Node next;
        public MyIterator(Node root){
            next = root;
            
        }
        @Override
        public Iterator<K> iterator() {
            return null;
        }
    }
}
