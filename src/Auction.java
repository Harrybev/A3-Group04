import java.util.ArrayList;

public class Auction implements Sortable{
    private User seller;
    private Artwork artwork;
    private int numberOfBids;
    private double reservePrice;
    private ArrayList<Bid> bidList;
    private boolean hasEnded;

    public Auction(User seller, Artwork artwork, int numberOfBids, double reservePrice, boolean hasEnd) {
        this.seller = seller;
        this.artwork = artwork;
        this.numberOfBids = numberOfBids;
        this.reservePrice = reservePrice;
        this.hasEnded = hasEnd;
        this.bidList = new ArrayList<Bid>();
    }

    public User getSeller() {
        return seller;
    }

    public Artwork getArtwork() {
        return artwork;
    }

    public int getNumberOfBids() {
        return numberOfBids;
    }

    public double getReservePrice() {
        return reservePrice;
    }

    public void placeBid(Bid bid) {
        bidList.add(bid);
        numberOfBids--;
        if (numberOfBids == 0) {
            hasEnded = true;
        }
    }

    public ArrayList<Bid> getBidList() {
        return bidList;
    }

    public boolean isHasEnded() {
        return hasEnded;
    }

    public Bid getLatestBid() {
        return this.bidList.get(bidList.size() - 1);
    }

    public double getNewBidMinimum() {
        if (this.bidList.size() == 0) {
            return this.reservePrice;
        } else {
            return this.bidList.get(bidList.size() - 1).getBidAmount();
        }
    }

    public int compareTo(Sortable s) {
        Auction otherAuction = (Auction) s;
        return this.getArtwork().getTitle().compareTo(otherAuction.getArtwork().getTitle());
    }

    public void setBidList(ArrayList<Bid> bidList) {
        this.bidList = bidList;
    }

    public String getSearchKey() {
        return this.artwork.getTitle();
    }
}
