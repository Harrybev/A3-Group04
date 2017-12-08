
import java.util.ArrayList;

public class Sculpture extends Artwork {
    private double width;
    private double height;
    private double depth;
    private String mainMaterial;
    private ArrayList<String> additionalPhotosList;

    /**
     * @param title
     * @param description
     * @param photoPath
     * @param creatorName
     * @param creationYear
     * @param width
     * @param height
     * @param depth
     * @param mainMaterial
     * @param additionalPhotos
     */
    public Sculpture(String title, String type, String description, String
            photoPath, String creatorName, int creationYear, double width,
                     double height, double depth, String mainMaterial,
                     ArrayList<String> additionalPhotos) {
        super(title, type, description,photoPath,creatorName,creationYear);
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.mainMaterial = mainMaterial;
        this.additionalPhotosList = additionalPhotos;

    }

   /**
    * @return The width of the sculpture
    */
    public double getWidth() {
        return this.width;
    }

    /**
     * @return The height of the sculpture
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * @return The depth of the sculpture
     */
    public double getDepth() {
        return this.depth;
    }

    /**
     * @return The material of the sculpture
     */
    public String getMainMaterial() {
        return this.mainMaterial;
    }

    /**
     * @param Set the width of the sculpture
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * @param Set the height of the sculpture
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @param Set the depth of the sculpture
     */
    public void setDepth(double depth) {
        this.depth = depth;
    }

    /**
     * @param Set the material of the sculpture
     */
    public void setMainMaterial(String mainMaterial) {
        this.mainMaterial = mainMaterial;
    }

    /**
     * @return A list of additional photos of the sculpture
     */
    public ArrayList<String> getAdditionalPhotosList() {
        return additionalPhotosList;
    }

    /**
     * @param Sets additional photos for the sculpture
     */
    public void setAdditionalPhotosList(ArrayList<String> additionalPhotosList) {
        this.additionalPhotosList = additionalPhotosList;
    }

    /**
     * @param s
     * @return
     */
    public int compareTo(Sortable s) {
        Artwork otherArtwork = (Artwork) s;
        return this.getTitle().compareTo(((Artwork) s).getTitle());
    }
}
