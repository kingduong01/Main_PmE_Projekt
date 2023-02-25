package PmE.Kochapp.Domains;

public class CategoryBreakfastDomain {
    private String titleBreakfast;
    private String imgeBreakfast;
    private String cookingTimeBreakfast;
    private String difficultyBreakfast;
    private String DescriptionBreakfast;

    public CategoryBreakfastDomain(String titleBreakfast, String imgeBreakfast, String cookingTimeBreakfast, String difficultyBreakfast, String DescriptionBreakfast) {
        this.titleBreakfast = titleBreakfast;
        this.imgeBreakfast = imgeBreakfast;
        this.cookingTimeBreakfast = cookingTimeBreakfast;
        this.difficultyBreakfast = difficultyBreakfast;
        this.DescriptionBreakfast = DescriptionBreakfast;
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

    public String getCookingDescriptionBreakfast() { return DescriptionBreakfast; }
}
