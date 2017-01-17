package voc.appathon.com.voiceofcustomer.firebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import voc.appathon.com.voiceofcustomer.model.Survey;
import voc.appathon.com.voiceofcustomer.model.UserSurvey;

/**
 * Created by yshetty on 1/17/17.
 */

public class FirebaseService {

    private static FirebaseService instance;

    private static FirebaseAuth mFirebaseAuth;
    private static FirebaseUser mFirebaseUser;
    private static DatabaseReference mDatabase;
    private static final String NODE_ROOT = "VoiceOfCustomer";
    private static final String NODE_SURVEY ="Survey";
    private static final String NODE_USERS ="Users";
    private static final String NODE_USERS_SURVEYS ="Surveys";

    public static synchronized FirebaseService getInstance() {
        if (instance == null) {
            instance = new FirebaseService();
            mFirebaseAuth = FirebaseAuth.getInstance();
            mFirebaseUser = mFirebaseAuth.getCurrentUser();
            mDatabase = FirebaseDatabase.getInstance().getReference();
        }
        return instance;
    }

    public String CreateSurvey(Survey survey){

        DatabaseReference data =  mDatabase.child(NODE_ROOT).child(NODE_SURVEY);
        DatabaseReference create_data = data.push();
        create_data.setValue(survey);

        updateUserInfo(survey,create_data.getKey());

        return create_data.getKey();

    }

   public void updateUserInfo(Survey survey,String key){

       DatabaseReference data =  mDatabase.child(NODE_ROOT).child(NODE_USERS).child(survey.getUserID()).child(NODE_USERS_SURVEYS);
       DatabaseReference create_data = data.push();
       UserSurvey userSurvey= new UserSurvey();
       userSurvey.setSurveyID(key);
       create_data.setValue(userSurvey);

   }

    public Query getSurvey(String userID){
        Query recentPostsQuery = mDatabase.child(userID);

    }


}
