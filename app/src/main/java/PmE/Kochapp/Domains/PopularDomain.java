package PmE.Kochapp.Domains;

public class PopularDomain {
    private String titlePopular;
    private String imagePopular;
    private String cookingTimePopular;
    private String difficultyPopular;

    public PopularDomain ( String titlePopular, String imagePopular, String cookingTimePopular, String difficultyPopular ) {
        this.titlePopular = titlePopular;
        this.imagePopular = imagePopular;
        this.cookingTimePopular = cookingTimePopular;
        this.difficultyPopular = difficultyPopular;
    }

    public String getTitlePopular() {
        return titlePopular;
    }

    public String getImagePopular() {
        return imagePopular;
    }

    public String getCookingTimePopular() {
        return cookingTimePopular;
    }

    public String getDifficultyPopular() {
        return difficultyPopular;
    }
}
