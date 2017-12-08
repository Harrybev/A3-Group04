
import java.util.ArrayList;

public class Sculpture extends Artwork {
    private String title;
    private String description;
    private String photoPath;
    private String creatorName;
    private int creationYear;
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
    public Sculpture(String title, String description, String photoPath, String creatorName, int
                    creationYear, double width, double height, double depth, String mainMaterial,
                     ArrayList<String> additionalPhotos) {
        this.title = title;
        this.description = description;
        this.photoPath = photoPath;
        this.creatorName = creatorName;
        this.creationYear = creationYear;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.mainMaterial = mainMaterial;
        this.additionalPhotosList = additionalPhotos;

    }
    
    /**
     * @return The title of the sculpture
     * (non-Javadoc)
     * @see Artwork#getTitle()
     */
    public String getTitle() {
        return this.title;
    }
    
    /**
     * @return The description of the sculpture
     * (non-Javadoc)
     * @see Artwork#getDescription()
     */
    public String getDescription() {
        return this.description;
    }
    
    /**
     * @return The photo path of the sculpture 
     * (non-Javadoc)
     * @see Artwork#getPhotoPath()
     */
    public String getPhotoPath() {
        return this.photoPath;
    }
    
    /**
     * @return The creator name of the sculpture
     * (non-Javadoc)
     * @see Artwork#getCreatorName()
     */
    public String getCreatorName() {
        return this.creatorName;
    }
    
    /**
     * @return The creation year of the sculpture 
     * (non-Javadoc)
     * @see Artwork#getCreationYear()
     */
    public int getCreationYear() {
        return this.creationYear;
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
     * @param Set the title of the sculpture 
     * (non-Javadoc)
     * @see Artwork#setTitle(java.lang.String)
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * @param Set the description of the sculpture
     * (non-Javadoc)
     * @see Artwork#setDescription(java.lang.String)
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * @param Set the photo path of the sculpture
     * (non-Javadoc)
     * @see Artwork#setPhotoPath(java.lang.String)
     */
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
    
    /**
     * @param Set the creator name of the sculpture
     * (non-Javadoc)
     * @see Artwork#setCreatorName(java.lang.String)
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }
    
    /**
     * @param Set the creation year of the sculpture
     * (non-Javadoc)
     * @see Artwork#setCreationYear(int)
     */
    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
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

    public String getSearchKey() {
        return this.title;
    }
}