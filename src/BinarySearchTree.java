public class BinarySearchTree {
    class Node {
        Mahasiswa data;
        Node left, right;

        Node(Mahasiswa mhs) {
            data = mhs;
            left = right = null;
        }
    }

    private Node root;

    public void insert(Mahasiswa mhs) {
        root = insertRec(root, mhs);
    }

    private Node insertRec(Node root, Mahasiswa mhs) {
        if (root == null)
            return new Node(mhs);
        if (mhs.getNama().compareToIgnoreCase(root.data.getNama()) < 0)
            root.left = insertRec(root.left, mhs);
        else
            root.right = insertRec(root.right, mhs);
        return root;
    }

    public Mahasiswa searchByNama(String nama) {
        Node result = searchRec(root, nama);
        return result != null ? result.data : null;
    }

    private Node searchRec(Node root, String nama) {
        if (root == null || root.data.getNama().equalsIgnoreCase(nama))
            return root;
        if (nama.compareToIgnoreCase(root.data.getNama()) < 0)
            return searchRec(root.left, nama);
        return searchRec(root.right, nama);
    }

    public void inorderTraversal() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.data);
            inorderRec(root.right);
        }
    }
}
