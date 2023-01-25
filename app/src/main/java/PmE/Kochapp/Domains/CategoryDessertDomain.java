package PmE.Kochapp.Domains;

public class CategoryDessertDomain {
    private String titleDessert;
    private String imgeDessert;
    private String cookingTimeDessert;
    private String difficultyDessert;

    public CategoryDessertDomain(String titleDessert, String imgeDessert, String cookingTimeDessert, String difficultyDessert) {
        this.titleDessert = titleDessert;
        this.imgeDessert = imgeDessert;
        this.cookingTimeDessert = cookingTimeDessert;
        this.difficultyDessert = difficultyDessert;
    }

    public String getTitleDessert() {
        return titleDessert;
    }

    public String getImgeDessert() {
        return imgeDessert;
    }

    public String getCookingTimeDessert() {
        return cookingTimeDessert;
    }

    public String getDifficultyDessert() {
        return difficultyDessert;
    }
}
