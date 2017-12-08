public abstract class Artwork implements Sortable{
    private String title;
    private String description;
    private String photoPath;
    private String creatorName;
    private int creationYear;

    public Artwork(String title,String description,String photoPath,String creatorName,int creationYear){
      this.title = title;
      this.description = description;
      this.photoPath = photoPath;
      this.creatorName = creatorName;
      this.creationYear = creationYear;
    }

    public String getTitle() {
        return this.title;
    }
    public String getDescription() {
        return this.description;
    }
    public String getPhotoPath() {
        return this.photoPath;
    }
    public String getCreatorName() {
        return this.creatorName;
    }
    public int getCreationYear() {
        return this.creationYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }
    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

}
