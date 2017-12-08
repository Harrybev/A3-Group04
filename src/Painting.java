
public class Painting extends Artwork {
    private double width;
    private double height;

    /**
     *
     * @param title
     * @param description
     * @param photoPath
     * @param creatorName
     * @param creationYear
     * @param width
     * @param height
     */
    public Painting(String title, String description, String photoPath, String
            creatorName, int creationYear, double width, double height) {
        super(title,description,photoPath,creatorName,creationYear);
        this.width = width;
        this.height = height;
    }

    /**
     * @return The width of the painting
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * @return The height of the painting
     */
    public double getHeight() {
        return this.height;
    }



    /**
     * @param Set the width of the painting
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @param Set the height of the painting
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     *
     * @param s
     * @return
     */
    public int compareTo(Sortable s) {
        Artwork otherArtwork = (Artwork) s;
        return this.getTitle().compareTo(((Artwork) s).getTitle());
    }
}
