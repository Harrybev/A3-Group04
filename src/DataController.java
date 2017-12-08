public class DataController {
    private BST userTree;
    private BST artTree;
    private BST auctionTree;

    public DataController(BST userTree, BST artTree, BST auctionTree) {
        this.userTree = userTree;
        this.artTree = artTree;
        this.auctionTree = auctionTree;
    }

    public BST getUserTree() {
        return userTree;
    }

    public BST getArtTree() {
        return artTree;
    }

    public BST getAuctionTree() {
        return auctionTree;
    }
}
