public abstract class Artwork implements Sortable{
    private String title;
    private String description;
    private String photoPath;
    private String creatorName;
    private int creationYear;
    private double width;
    private double height;
    private String type;

    public abstract String getTitle();
    public abstract String getDescription();
    public abstract String getPhotoPath();
    public abstract String getCreatorName();
    public abstract int getCreationYear();
    public abstract double getWidth();
    public abstract double getHeight();
    public abstract String getType();

    public abstract void setTitle(String title);
    public abstract void setDescription(String description);
    public abstract void setPhotoPath(String photoPath);
    public abstract void setCreatorName(String creatorName);
    public abstract void setCreationYear(int creationYear);
    public abstract void setType(String type);

}
