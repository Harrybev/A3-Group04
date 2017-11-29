import java.sql.Time;

public class Bid {
    private double bidAmount;
    private User bidder;
    private Time bidTime;

    public Bid(double bidAmount, User bidder, Time bidTime) {
        this.bidAmount = bidAmount;
        this.bidder = bidder;
        this.bidTime = bidTime;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public User getBidder() {
        return bidder;
    }

    public Time getBidTime() {
        return bidTime;
    }
}
