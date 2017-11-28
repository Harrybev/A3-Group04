public class BSTNode {
    private BSTNode left = null;
    private BSTNode right = null;
    private Sortable s;

    public BSTNode(Sortable s) {
        this.s = s;
    }

    public Sortable getSortable() {
        return this.s;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }


//    public void setSortable(Sortable s) {
//        this.s = s;
//    }
}
