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

    public Sculpture(String title, String description, String photoPath, String creatorName, int
                    creationYear, double width, double height, double depth, String mainMaterial,
                     String[] additionalPhotos) {
        super(title,description,photoPath,creatorName,creationYear);
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.mainMaterial = mainMaterial;

        for (String s : additionalPhotos) {
            additionalPhotosList.add(s);
        }
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
}
