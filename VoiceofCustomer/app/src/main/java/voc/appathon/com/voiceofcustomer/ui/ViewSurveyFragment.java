package voc.appathon.com.voiceofcustomer.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

import voc.appathon.com.voiceofcustomer.R;
import voc.appathon.com.voiceofcustomer.firebase.FirebaseService;
import voc.appathon.com.voiceofcustomer.model.Survey;

/**
 * Created by yshetty on 1/17/17.
 */

public class ViewSurveyFragment extends Fragment{
    private FirebaseService firebaseService;
    private ArrayList<Survey>Surveys;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.create_survey_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        firebaseService = FirebaseService.getInstance();
        Query surveyIDOfUserid= firebaseService.getSurveyOfUserid(DashBoardScreen.mUserId);
        surveyIDOfUserid.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<HashMap<String,String>> typeIndicator = new GenericTypeIndicator<HashMap<String, String>>() {};
                HashMap<String,String> SurveyID = dataSnapshot.getValue(typeIndicator);
                Log.d("Size is",Integer.toString(SurveyID.size()));

                for(int i=0; i<SurveyID.size();i++){
                    

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
