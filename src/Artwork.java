
public abstract class Artwork implements Sortable{
    private String title;
    private String description;
    private String photoPath;
    private String creatorName;
    private int creationYear;

    public Artwork(String title, String description, String photoPath, String
            creatorName, int creationYear){
        this.title = title;
        this.description = description;
        this.photoPath = photoPath;
        this.creatorName = creatorName;
        this.creationYear = creationYear;
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

        public String getSearchKey() {
            return this.getTitle();
        }

}
