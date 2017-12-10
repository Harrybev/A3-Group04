import java.time.LocalDateTime;

public class Bid {
    private double bidAmount;
    private User bidder;
    private LocalDateTime bidTime;

    public Bid(double bidAmount, User bidder, LocalDateTime bidTime) {
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

    public LocalDateTime getBidTime() {
        return bidTime;
    }
}
