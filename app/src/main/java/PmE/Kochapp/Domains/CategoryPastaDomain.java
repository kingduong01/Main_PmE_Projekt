package PmE.Kochapp.Domains;

public class CategoryPastaDomain {
    private String titlePasta;
    private String imgePasta;
    private String cookingTimePasta;
    private String difficultyPasta;
    private String DescriptionPasta;

    public CategoryPastaDomain(String titlePasta, String imgePasta, String cookingTimePasta, String difficultyPasta, String DescriptionPasta ) {
        this.titlePasta = titlePasta;
        this.imgePasta = imgePasta;
        this.cookingTimePasta = cookingTimePasta;
        this.difficultyPasta = difficultyPasta;
        this.DescriptionPasta = DescriptionPasta;
    }

    public String getTitlePasta() {
        return titlePasta;
    }

    public String getImgePasta() {
        return imgePasta;
    }

    public String getCookingTimePasta() {
        return cookingTimePasta;
    }

    public String getDifficultyPasta() {
        return difficultyPasta;
    }

    public String getCookingDescriptionPasta() {return DescriptionPasta; }
}
