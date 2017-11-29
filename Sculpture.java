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
    private String type;

    public Sculpture(String title, String description, String photoPath, String creatorName, int
                    creationYear, double width, double height, double depth, String mainMaterial,
                     ArrayList<String> morePhotos, String type) {
        this.title = title;
        this.description = description;
        this.photoPath = photoPath;
        this.creatorName = creatorName;
        this.creationYear = creationYear;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.mainMaterial = mainMaterial;
        this.additionalPhotosList = morePhotos;
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

    public double getDepth() {
        return this.depth;
    }

    public String getMainMaterial() {
        return this.mainMaterial;
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

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public void setMainMaterial(String mainMaterial) {
        this.mainMaterial = mainMaterial;
    }

    public ArrayList<String> getAdditionalPhotosList() {
        return additionalPhotosList;
    }

    public void setAdditionalPhotosList(ArrayList<String> additionalPhotosList) {
        this.additionalPhotosList = additionalPhotosList;
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
