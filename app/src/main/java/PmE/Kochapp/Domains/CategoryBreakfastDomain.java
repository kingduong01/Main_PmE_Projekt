package PmE.Kochapp.Domains;

public class CategoryBreakfastDomain {
    private String titleBreakfast;
    private String imgeBreakfast;
    private String cookingTimeBreakfast;
    private String difficultyBreakfast;

    public CategoryBreakfastDomain(String titleBreakfast, String imgeBreakfast, String cookingTimeBreakfast, String difficultyBreakfast) {
        this.titleBreakfast = titleBreakfast;
        this.imgeBreakfast = imgeBreakfast;
        this.cookingTimeBreakfast = cookingTimeBreakfast;
        this.difficultyBreakfast = difficultyBreakfast;
    }

    public String getTitleBreakfast() {
        return titleBreakfast;
    }

    public String getImgeBreakfast() {
        return imgeBreakfast;
    }

    public String getCookingTimeBreakfast() {
        return cookingTimeBreakfast;
    }

    public String getDifficultyBreakfast() {
        return difficultyBreakfast;
    }
}
