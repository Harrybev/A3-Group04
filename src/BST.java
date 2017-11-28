import java.util.ArrayList;

public class BST {
    private BSTNode root = null;

    public BST() {
    }

    public void addNode(BSTNode newNode) {

        this.root = insertNode(this.root, newNode);

    }

    private BSTNode insertNode(BSTNode currentNode, BSTNode newNode) {
        if (root == null) {
            return newNode;
        } else if (currentNode.getSortable().compareTo(newNode.getSortable()) >= 0) {
            if (currentNode.getLeft() == null) {
                currentNode.setLeft(newNode);
            } else {
                insertNode(currentNode.getLeft(), newNode);
            }
        } else {
            if (currentNode.getRight() == null) {
                currentNode.setRight(newNode);
            } else {
                insertNode(currentNode.getRight(), newNode);
            }
        }
        return currentNode;
    }

    public ArrayList<Sortable> inOrderList(){
        ArrayList<Sortable> sortedList = new ArrayList<>();

        inOrderTraversal(sortedList, this.root);

        return sortedList;

    }

    private void inOrderTraversal(ArrayList<Sortable> list, BSTNode node) {
        if (node.getLeft()!= null) {
            inOrderTraversal(list, node.getLeft());
        }
        list.add(node.getSortable());
        if (node.getRight() != null) {
            inOrderTraversal(list, node.getRight());
        }


    }
}
