public class Main {
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();
        tree.put(1, "A");
        tree.put(2, "B");
        tree.put(3, "C");
        tree.put(4, "D");
        tree.put(5, "E");
        tree.put(6, "F");

        for (Integer key : tree) {
            String value = tree.get(key);
            System.out.println("Key is " + key + " and value is " + value);
        }
        System.out.println();



        /*
        tree.delete(3);
        tree.delete(6);
        for (Integer key : tree) {
            String value = tree.get(key);
            System.out.println("Key is " + key + " and value is " + value);
        }
         */
    }
}