public class Painting extends Artwork {
    private String title;
    private String description;
    private String photoPath;
    private String creatorName;
    private int creationYear;
    private double width;
    private double height;
    private String type;

    public Painting(String title, String description, String photoPath, String creatorName, int
                    creationYear, double width, double height, String type) {
        this.title = title;
        this.description = description;
        this.photoPath = photoPath;
        this.creatorName = creatorName;
        this.creationYear = creationYear;
        this.width = width;
        this.height = height;
        this.type = type;
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

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
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

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int compareTo(Sortable s) {
        Artwork otherArtwork = (Artwork) s;
        return this.getTitle().compareTo(((Artwork) s).getTitle());
    }

	public String getType() {
		return type;
	}

	@Override
	public void setType(String type) {
		// TODO Auto-generated method stub
		
	}
}
