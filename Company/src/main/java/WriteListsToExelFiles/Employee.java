package WriteListsToExelFiles;


import java.util.Date;

public class Employee {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String profession;
    private String company;
    private Date startDate;

    public Employee() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    public Employee(String firstName, String lastName, String phoneNumber, String profession, String company, Date startDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.profession = profession;
        this.company = company;
        this.startDate = startDate;
    }

    // public Date setStartDate(Date date) throws ParseException {
    //   DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
    // date = (Date)formatter.parse(date.toString());
    //return startDate;
    //}
}

