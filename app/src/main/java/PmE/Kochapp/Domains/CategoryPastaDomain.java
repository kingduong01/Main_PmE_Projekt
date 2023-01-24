package PmE.Kochapp.Domains;

public class CategoryPastaDomain {
    private String titlePasta;
    private String imgePasta;
    private String cookingTimePasta;
    private String difficultyPasta;

    public CategoryPastaDomain(String titlePasta, String imgePasta, String cookingTimePasta, String difficultyPasta) {
        this.titlePasta = titlePasta;
        this.imgePasta = imgePasta;
        this.cookingTimePasta = cookingTimePasta;
        this.difficultyPasta = difficultyPasta;
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
}
