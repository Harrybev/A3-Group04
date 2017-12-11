import java.util.ArrayList;
/**
*Create a generic binary tree usinf BST Nodes
**/
public class BST {
    private BSTNode root = null;
    /**
    *Empty constructor to initialize tree
    **/
    public BST() {
    }
    /**
    *Adds a nide to the Tree
    *@param newNode is the node being added to the tree.
    **/
    public void addNode(BSTNode newNode) {
        this.root = insertNode(this.root, newNode);
    }
    /**
    *Recuresively calls to enter a node to the tree
    *@param currentNode the parent
    *@param newNode node to be inerted
    **/
    private BSTNode insertNode(BSTNode currentNode, BSTNode newNode) {
        if (root == null) {
            return newNode;
        } else if (currentNode.getSortable().compareTo(newNode.getSortable())
                >= 0) {
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
    /**
    *Returns a InOrder ArrayList of nodes.
    **/
    public ArrayList<Sortable> inOrderList(){
        ArrayList<Sortable> sortedList = new ArrayList<>();

        inOrderTraversal(sortedList, this.root);

        return sortedList;

    }
    /**
    *used to create the list of nodes, this is an in order transversal
    * of a tree.
    **/
    private void inOrderTraversal(ArrayList<Sortable> list, BSTNode node) {
        if (node.getLeft()!= null) {
            inOrderTraversal(list, node.getLeft());
        }
        list.add(node.getSortable());
        if (node.getRight() != null) {
            inOrderTraversal(list, node.getRight());
        }
    }
    /**
    *Searches the binary tree using a search key defined in Sortable
    **/
    public BSTNode searchBST(String searchKey) {
        return recSearchBST(this.root, searchKey);
    }
    /**
    *recSearchBST searches tree recursively to return a BSTNode that fits
    * search paramter.
    **/
    private BSTNode recSearchBST(BSTNode currNode, String searchKey) {
        if (currNode.getSortable().getSearchKey().equals(searchKey)) {
           return currNode;
        } else if (currNode.getSortable().getSearchKey().compareTo(searchKey)
         >= 0) {
            if (currNode.getLeft() == null) {
                return null;
            } else {
                return recSearchBST(currNode.getLeft(), searchKey);
            }
        } else {
            if (currNode.getRight() == null) {
                return null;
            } else {
                return recSearchBST(currNode.getRight(), searchKey);
            }
        }
    }
}
