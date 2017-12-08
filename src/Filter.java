import java.lang.reflect.Array;
import java.util.ArrayList;

public class Filter {
    public static ArrayList<Artwork> filterArtwork(BST artTree, String
            artType) {
        ArrayList<Artwork> filteredArtList = new ArrayList<>();

        for (Sortable s: artTree.inOrderList()) {
            Artwork art = (Artwork) s;
            if (art.getType().equals(artType)) {
                if (artType.equals("Sculpture")) {
                    filteredArtList.add((Sculpture) s);
                } else {
                    filteredArtList.add((Painting) s);
                }
            }
        }
        return filteredArtList;
    }

    public static ArrayList<Auction> filterAuctions(BST auctionTree, User
            currentUser) {
        ArrayList<Auction> filterAuctionList = new ArrayList<>();

        for (Sortable s : auctionTree.inOrderList()) {
            Auction auction = (Auction) s;

            if (!auction.getSeller().equals(currentUser)) {
                filterAuctionList.add(auction);
            }

        }
        return filterAuctionList;
    }
}
