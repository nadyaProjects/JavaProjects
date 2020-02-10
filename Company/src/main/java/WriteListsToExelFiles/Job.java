package WriteListsToExelFiles;

public class Job {

    private String profession;
    private String professionCategory;
    private int yearsOfExperience;
    private String companyName;


    public Job(String profession, String professionCategory, int yearsOfExperience,String companyName) {
        this.profession = profession;
        this.professionCategory = professionCategory;
        this.yearsOfExperience = yearsOfExperience;
        this.companyName = companyName;
    }
public Job(){

}


    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getProfessionCategory() {
        return professionCategory;
    }

    public void setProfessionCategory(String professionCategory) {
        this.professionCategory = professionCategory;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


}
