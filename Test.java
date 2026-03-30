public class Test {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();

        // Insert
        tree.insert(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(10);
        tree.insert(30);
        tree.insert(60);
        tree.insert(90);

        // Traversals -- predict the output before running
        System.out.print("Inorder:   "); tree.inorder();   System.out.println();
        System.out.print("Preorder:  "); tree.preorder();  System.out.println();
        System.out.print("Postorder: "); tree.postorder(); System.out.println();

        // Search
        System.out.println("Search 30: " + tree.search(30));  // true
        System.out.println("Search 40: " + tree.search(40));  // false

        // Delete leaf
        tree.delete(30);
        System.out.print("After delete 30: "); tree.inorder(); System.out.println();

        // Delete node with one child
        tree.delete(25);
        System.out.print("After delete 25: "); tree.inorder(); System.out.println();

        // Delete node with two children
        tree.delete(75);
        System.out.print("After delete 75: "); tree.inorder(); System.out.println();

        // Size
        System.out.println("Size: " + tree.getSize());  // 4
    }
}