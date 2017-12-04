
public abstract class Artwork implements Sortable{
    private String title;
    private String description;
    private String photoPath;
    private String creatorName;
    private int creationYear;
    
    /**
     * @return The title of the art work 
     */
    public abstract String getTitle();
    
    /**
     * @return The description of the artwork
     */
    public abstract String getDescription();
    
    /**
     * @return The photo path of the artwork
     */
    public abstract String getPhotoPath();
    
    /**
     * @return The creator name of the artwork
     */
    public abstract String getCreatorName();
    
    /**
     * @return The creation year of the artwork
     */
    public abstract int getCreationYear();

    /**
     * @param Set the title of the artwork
     */
    public abstract void setTitle(String title);
    
    /**
     * @param Set the description of the artwork
     */
    public abstract void setDescription(String description);
    
    /**
     * @param Set the photo path of the artwork
     */
    public abstract void setPhotoPath(String photoPath);
    
    /**
     * @param Set the creator name of the art work
     */
    public abstract void setCreatorName(String creatorName);
    
    /**
     * @param Set the creation name of the artwork
     */
    public abstract void setCreationYear(int creationYear);

}