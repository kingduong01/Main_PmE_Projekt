package PmE.Kochapp.Domains;

public class CategoryVeganDomain {
    private String titleVegan;
    private String imgeVegan;
    private String cookingTimeVegan;
    private String difficultyVegan;
    private String descriptionVegan;

    public CategoryVeganDomain(String titleVegan, String imgeVegan, String cookingTimeVegan, String difficultyVegan , String descriptionVegan) {
        this.titleVegan = titleVegan;
        this.imgeVegan = imgeVegan;
        this.cookingTimeVegan = cookingTimeVegan;
        this.difficultyVegan = difficultyVegan;
        this.descriptionVegan = descriptionVegan;
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

    public String getDescriptionVegan() {return descriptionVegan; }
}
