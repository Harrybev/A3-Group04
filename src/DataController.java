public class DataController {
    private static BST userTree;
    private static BST artTree;
    private static BST auctionTree;
    private static User loggedInUser;
    private static Auction selectedAuction;

    public static BST getUserTree() {
        return userTree;
    }

    public static BST getArtTree() {
        return artTree;
    }

    public static BST getAuctionTree() {
        return auctionTree;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User newLogin) {
        loggedInUser = newLogin;
    }

    public static void setUserTree(BST newUserTree) {
        userTree = newUserTree;
    }

    public static void setArtTree(BST newArtTree) {
        artTree = newArtTree;
    }

    public static void setAuctionTree(BST newAuctionTree) {
        auctionTree = newAuctionTree;
    }

    public static void setSelectedAuction(Auction selectedAuction) {
        selectedAuction = selectedAuction;
    }

    public static Auction getSelectedAuction() {
        return selectedAuction;
    }
}
