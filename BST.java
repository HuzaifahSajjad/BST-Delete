import java.sql.SQLOutput;

public class BST<E extends Comparable<E>> implements Tree<E> {

    // ── Inner node class ─────────────────────────────────────────────────
    protected static class TreeNode<E> {
        E element;
        TreeNode<E> left;
        TreeNode<E> right;

        TreeNode(E e) {
            element = e;
            left  = null;
            right = null;
        }
    }

    // ── Fields ───────────────────────────────────────────────────────────
    protected TreeNode<E> root;
    protected int size;

    // ── Constructor ──────────────────────────────────────────────────────
    public BST() {
        root = null;
        size = 0;
    }

    // ── Search ───────────────────────────────────────────────────────────
    @Override
    public boolean search(E e) {
        TreeNode<E> current = root;
        while (current != null) {
            int cmp = e.compareTo(current.element);
            if (cmp < 0) current = current.left;
            else if (cmp > 0) current = current.right;
            else return true;
        }
        return false;
    }

    // ── Insert ───────────────────────────────────────────────────────────
    @Override
    public boolean insert(E e) {
        if (root == null) {
            root = new TreeNode<>(e);
            size++;
            return true;
        }
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            int cmp = e.compareTo(current.element);
            if (cmp < 0) { parent = current; current = current.left; }
            else if (cmp > 0) { parent = current; current = current.right; }
            else return false;
        }
        if (e.compareTo(parent.element) < 0)
            parent.left = new TreeNode<>(e);
        else
            parent.right = new TreeNode<>(e);
        size++;
        return true;
    }

    // ── Delete ───────────────────────────────────────────────────────────
    @Override
    public boolean delete(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            int cmp = e.compareTo(current.element);
            if (cmp < 0) { parent = current; current = current.left; }
            else if (cmp > 0) { parent = current; current = current.right; }
            else { break; }
        }
        if (current == null) return false;
        if (current.left == null || current.right == null) {
            TreeNode<E> child;
            if (current.left != null) { child = current.left; }
            else { child = current.right; }
            if (parent == null) { root = child; }
            else if (parent.left == current) { parent.left = child; }
            else { parent.right = child; }
        }
        else {
            TreeNode<E> successorParent = current;
            TreeNode<E> successor = current.right;
            while (successor.left != null) { successorParent = successor; successor = successor.left; }
            current.element = successor.element;
            if (successorParent.left == successor) { successorParent.left = successor.right; }
            else { successorParent.right = successor.right; }
        }
        size--;
        return true;
    }

    // ── Traversals ───────────────────────────────────────────────────────
    @Override
    public void inorder() {
        inorder(root);
    }

    private void inorder(TreeNode<E> node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.element + " ");
        inorder(node.right);
    }

    @Override
    public void preorder() {
        preorder(root);
    }

    private void preorder(TreeNode<E> node) {
        if (node == null) return;
        System.out.print(node.element + " ");
        preorder(node.left);
        preorder(node.right);
    }

    @Override
    public void postorder() {
        postorder(root);
    }

    private void postorder(TreeNode<E> node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.element + " ");
    }

    // ── Size / Empty ─────────────────────────────────────────────────────
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
