public class DataController {
    private BST userTree;
    private BST artTree;
    private BST auctionTree;
    private User loggedInUser;

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

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}
