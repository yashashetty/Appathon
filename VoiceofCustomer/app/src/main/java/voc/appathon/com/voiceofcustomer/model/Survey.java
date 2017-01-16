package voc.appathon.com.voiceofcustomer.model;

/**
 * Created by tanu.rawal on 1/13/2017.
 */
public class Survey {

    public String surveyName;
    public String surveyTitle;
    public Questions questions;
    public String totalResponse;
    public String likes;
    public String user_name ;
    public String user_choice;



    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public String getSurveyTitle() {
        return surveyTitle;
    }

    public void setSurveyTitle(String surveyTitle) {
        this.surveyTitle = surveyTitle;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    public String getTotalResponse() {
        return totalResponse;
    }

    public void setTotalResponse(String totalResponse) {
        this.totalResponse = totalResponse;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_choice() {
        return user_choice;
    }

    public void setUser_choice(String user_choice) {
        this.user_choice = user_choice;
    }


}
