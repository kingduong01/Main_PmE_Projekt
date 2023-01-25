package PmE.Kochapp.Domains;

public class CategoryMeatDomain {
    private String titleMeat;
    private String imgeMeat;
    private String cookingTimeMeat;
    private String difficultyMeat;

    public CategoryMeatDomain(String titleMeat, String imgeMeat, String cookingTimeMeat, String difficultyMeat) {
        this.titleMeat = titleMeat;
        this.imgeMeat = imgeMeat;
        this.cookingTimeMeat = cookingTimeMeat;
        this.difficultyMeat = difficultyMeat;
    }

    public String getTitleMeat() {
        return titleMeat;
    }

    public String getImgeMeat() {
        return imgeMeat;
    }

    public String getCookingTimeMeat() {
        return cookingTimeMeat;
    }

    public String getDifficultyMeat() {
        return difficultyMeat;
    }
}
