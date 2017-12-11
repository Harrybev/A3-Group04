import java.util.ArrayList;
/**
*Auction is used to store the auction inforamtion
**/
public class Auction implements Sortable{
  private User seller;
  private Artwork artwork;
  private int numberOfBids;
  private double reservePrice;
  private ArrayList<Bid> bidList;
  private boolean hasEnded;
  /**
  *Constructor to create and auction object
  **/
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
  /**
  *placeBid removes a counter of bid each time and check to see if the Auction
  *is complete or not
  **/
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
  /**
  *Returns the last bid item for the Artwork
  **/
  public Bid getLatestBid() {
    return this.bidList.get(bidList.size() - 1);
  }
  /**
  *@returns the minimum for what the next bid should be.
  **/
  public double getNewBidMinimum() {
    if (this.bidList.size() == 0) {
      return this.reservePrice;
    } else {
      return this.bidList.get(bidList.size() - 1).getBidAmount();
    }
  }
  /**
  *Used for generic binary tree implementation.
  **/
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
