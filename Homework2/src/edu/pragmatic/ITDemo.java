package edu.pragmatic;

public class ITDemo {
    public static void main(String[] args) {

        SoftwareDeveloper dev = new SoftwareDeveloper();
        dev.buildSoftware();
        dev.makeCodeReview();

        DevOps devOps = new DevOps();
        devOps.buildSoftware();
        devOps.configureMachine();
        devOps.makeCodeReview();
        devOps.supportSoftware();

        AutomationQA automationQA = new AutomationQA();
        automationQA.verifyQuality();
        automationQA.writeAutomationTests();

        CTO cto = new CTO();
        cto.buildSoftware();
        cto.configureMachine();
        cto.makeCodeReview();
        cto.supportSoftware();
        cto.verifyQuality();
        cto.managePeople();


    }
}
