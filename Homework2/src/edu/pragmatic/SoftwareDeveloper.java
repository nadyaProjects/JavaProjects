package edu.pragmatic;

public class SoftwareDeveloper implements Developer {


    @Override
    public void buildSoftware() {
        System.out.println("Developer builds software.");
    }

    @Override
    public void makeCodeReview() {
        System.out.println("Developer makes code reviews.");
    }
}
