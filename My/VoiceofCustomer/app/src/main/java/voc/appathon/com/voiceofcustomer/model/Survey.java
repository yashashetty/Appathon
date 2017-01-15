package voc.appathon.com.voiceofcustomer.model;

/**
 * Created by tanu.rawal on 1/13/2017.
 */
public class Survey {

    public String surveyID;
    public String surveyQ;
    public String surveyAns;
    public String surveyType;
    public String surveyStatus;


    public Survey(String surveyID,String surveyQ,String surveyAns,String surveyType, String surveyStatus )
    {
        this.surveyID=surveyID;
        this.surveyQ=surveyQ;
        this.surveyAns=surveyAns;
        this.surveyType=surveyType;
        this.surveyStatus=surveyStatus;
        this.surveyAns=surveyAns;
    }

    public String getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(String surveyID) {
        this.surveyID = surveyID;
    }

    public String getSurveyQ() {
        return surveyQ;
    }

    public void setSurveyQ(String surveyQ) {
        this.surveyQ = surveyQ;
    }

    public String getSurveyAns() {
        return surveyAns;
    }

    public void setSurveyAns(String surveyAns) {
        this.surveyAns = surveyAns;
    }

    public String getSurveyType() {
        return surveyType;
    }

    public void setSurveyType(String surveyType) {
        this.surveyType = surveyType;
    }

    public String getSurveyStatus() {
        return surveyStatus;
    }

    public void setSurveyStatus(String surveyStatus) {
        this.surveyStatus = surveyStatus;
    }


}
