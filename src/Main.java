public class Main {
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();
        tree.put(1, "A");
        tree.put(2, "B");
        tree.put(3, "C");
        tree.put(4, "D");
        tree.put(5, "E");
        tree.put(6, "F");

        for (var elem : tree) {
            System.out.println("key is " + elem.key + " and value is " + elem.value);
        }

    }
}