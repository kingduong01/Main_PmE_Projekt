package PmE.Kochapp.Domains;

public class CategoryDomain {
    private String title;
    private String image;

    public CategoryDomain(String title, String image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }
}
