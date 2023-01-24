package PmE.Kochapp.Domains;

public class CategoryVeganDomain {
    private String titleVegan;
    private String imgeVegan;
    private String cookingTimeVegan;
    private String difficultyVegan;

    public CategoryVeganDomain(String titleVegan, String imgeVegan, String cookingTimeVegan, String difficultyVegan) {
        this.titleVegan = titleVegan;
        this.imgeVegan = imgeVegan;
        this.cookingTimeVegan = cookingTimeVegan;
        this.difficultyVegan = difficultyVegan;
    }

    public String getTitleVegan() {
        return titleVegan;
    }

    public String getImgeVegan() {
        return imgeVegan;
    }

    public String getCookingTimeVegan() {
        return cookingTimeVegan;
    }

    public String getDifficultyVegan() {
        return difficultyVegan;
    }
}
