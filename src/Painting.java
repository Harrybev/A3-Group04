
public class Painting extends Artwork {
    private String title;
    private String description;
    private String photoPath;
    private String creatorName;
    private int creationYear;
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
    public Painting(String title, String description, String photoPath, String creatorName, int
                    creationYear, double width, double height) {
        this.title = title;
        this.description = description;
        this.photoPath = photoPath;
        this.creatorName = creatorName;
        this.creationYear = creationYear;
        this.width = width;
        this.height = height;
    }

    /**
     * @return The title of the painting
     */
    public String getTitle() {
        return this.title;
    }
    
    /**
     * @return The description of the painting 
     */
    public String getDescription() {
        return this.description;
    }
    
    /**
     * @return The photo path of the painting 
     */
    public String getPhotoPath() {
        return this.photoPath;
    }
    
    /**
     * @return The creator name of the painting 
     */
    public String getCreatorName() {
        return this.creatorName;
    }
    
    /**
     * @return The creation year of the painting
     */
    public int getCreationYear() {
        return this.creationYear;
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
     * @param Set the title of the painting
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * @param Set the description of the painting
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * @param Set the photo path for the painting 
     */
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
    
    /**
     * @param Set the creator name of the painting
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }
    
    /**
     * @param Set the creation year of the painting
     */
    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
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