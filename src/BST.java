import java.util.ArrayList;

public class BST {
    private BSTNode root = null;

    public BST() {
    }

    public void addNode(BSTNode newNode) {

        insertNode(this.root, newNode);

    }

    private void insertNode(BSTNode currentNode, BSTNode newNode) {
        if (root == null) {
        	root = newNode;
        } else if (currentNode.getSortable().compareTo(newNode.getSortable()) >= 0 && currentNode.getLeft() != null) {
                insertNode(currentNode.getLeft(), newNode);
        } else if (currentNode.getSortable().compareTo(newNode.getSortable()) <= 0 && currentNode.getRight() != null) {
                insertNode(currentNode.getRight(), newNode);
        } else if (currentNode.getSortable().compareTo(newNode.getSortable()) >= 0 && currentNode.getLeft() == null){
        	currentNode.setLeft(newNode);
        } else {
        	currentNode.setRight(newNode);
        }
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
