package voc.appathon.com.voiceofcustomer.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.Map;

import voc.appathon.com.voiceofcustomer.R;
import voc.appathon.com.voiceofcustomer.firebase.FirebaseService;
import voc.appathon.com.voiceofcustomer.model.MultiChoice;
import voc.appathon.com.voiceofcustomer.model.Questions;
import voc.appathon.com.voiceofcustomer.model.Survey;
/**
 * Created by yshetty on 1/15/17.
 */

public class CreateSurveyFragment extends Fragment{
    private CardView mCardView;
    FirebaseService firebaseService;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.create_survey_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mCardView = (CardView) view.findViewById(R.id.cardview);

        firebaseService = FirebaseService.getInstance();
        AddSurvey();



       // mDatabase.child("users").child(mUserId).child("items").push().child("title").setValue("test do");

    }


    public void AddSurvey(){
        Survey survey = new Survey ();
        survey.setSurveyTitle("Customer Satisfaction Survey");
        Questions questions = new Questions();

        MultiChoice multichoiceQuestion = new MultiChoice();
        multichoiceQuestion.setChoiceType("1");
        multichoiceQuestion.setQuestionName("How satisfied are you with your last metro ride ");
        Map<String,String> choices = new HashMap<>();
        choices.put("Choice1","Very much Satisfied");
        choices.put("Choice2","Not Satisfied");
        multichoiceQuestion.setChoices(choices);
        questions.setMultichoice(multichoiceQuestion);
        survey.setQuestions(questions);

       String key = firebaseService.CreateSurvey(survey);
        Log.d("Key is",key);
        /*mDatabase.child("VoiceOfCustomer").child("Survey").push().setValue(survey);
        mDatabase.goOffline();*/


    }
}
