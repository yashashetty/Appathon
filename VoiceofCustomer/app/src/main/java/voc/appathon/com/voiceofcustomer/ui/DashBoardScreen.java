package voc.appathon.com.voiceofcustomer.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import voc.appathon.com.voiceofcustomer.R;
import voc.appathon.com.voiceofcustomer.utils.StringUtils;
import com.aurelhubert.ahbottomnavigation.*;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import com.google.firebase.database.ValueEventListener;

import voc.appathon.com.voiceofcustomer.R;
import voc.appathon.com.voiceofcustomer.firebase.FirebaseService;
//main

public class DashBoardScreen extends BaseAcitivity {
    public FirebaseAuth mFirebaseAuth;
public class DashBoardScreen extends BaseAcitivity implements View.OnClickListener {
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private DatabaseReference mDatabase;
    public static String mUserId;
    private String mUserId;
    private Bundle bundle;
    private  Button btnCreateSurvey;
    private Button btnViewSurvey;
    private Button btnIncreaseResponse;
    ViewPagerAdapter adapter;
    //ViewPagerAdapter adapter;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.survey);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        if (mFirebaseUser == null) {
            // Not logged in, launch the Log In activity
            loadLogInView();
        }else {
            initViews();
            mUserId = mFirebaseUser.getUid();

            mDatabase.child("VoiceOfCustomer").child("Users").child(mUserId).child("isAdmin").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    System.out.println(dataSnapshot.getValue());
                    if(dataSnapshot.getValue()!= null && Boolean.parseBoolean(dataSnapshot.getValue().toString())){
                        btnCreateSurvey.setVisibility(View.VISIBLE);
                    }else{
                        btnCreateSurvey.setVisibility(View.GONE);
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });



           // Set up ListView
            final ListView listView = (ListView) findViewById(R.id.listView);
            final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1);
            listView.setAdapter(adapter);

            // Add items via the Button and EditText at the bottom of the view.

           /* btnCreateSurvey.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mDatabase.getRoot().getDatabase().getReference("VoiceOfCustomer").child("Users").child(mUserId).push().setValue("users");
               // id = mDatabase.child("VoiceOfCustomer").child("Users").child(z).push().child("title").setValue("test do");
                 //   mDatabase.child("VoiceOfCustomer").child("Users").child(mUserId).push().child("title").
                    //text.setText("");
                }
            });*/

           /* mDatabase.child("voiceofcustomer-214e1").child("Users").child(mUserId).child("items").addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    adapter.add((String) dataSnapshot.child("title").getValue());
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    adapter.remove((String) dataSnapshot.child("title").getValue());
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }


            });*/


        }

        btnCreateSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    /*getFragmentManager().beginTransaction()
                            .add(R.id.container, CardViewFragment.newInstance())
                            .commit();*/
               adapter.addFrag(new CreateSurveyFragment(), "Create Survey");
                adapter.notifyDataSetChanged();
               //// adapter.addFrag(new CreateSurveyFragment(), "Create Survey"); //todo
            ////    adapter.notifyDataSetChanged();//todo
            }
        });

        btnViewSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.addFrag(new ViewSurveyFragment(), "View Survey");
                adapter.notifyDataSetChanged();
            }
        });

        btnIncreaseResponse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseService.getInstance().updateResponse("-KacvOAOACaUr0Q4L6br");
            }
        });

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }


    private void loadLogInView() {
        Intent intent = new Intent(this, LogInActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private void initViews() {
        /*TextView create_survey = (TextView) findViewById(R.id.create_survey);
        TextView add_survey = (TextView) findViewById(R.id.add_survey);
        TextView edit_survey = (TextView) findViewById(R.id.edit_survey);*/
        btnCreateSurvey = (Button)findViewById(R.id.create_survey);
        btnViewSurvey   =(Button)findViewById(R.id.view_survey);
        btnIncreaseResponse = (Button)findViewById(R.id.edit_survey);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
     private void initViews() {
         Button create_survey = (Button) findViewById(R.id.create_survey);
         create_survey.setOnClickListener(this);
         btnCreateSurvey = (Button) findViewById(R.id.create_survey);
         Button add_survey = (Button) findViewById(R.id.add_survey);
         add_survey.setOnClickListener(this);
         Button edit_survey = (Button) findViewById(R.id.edit_survey);
         edit_survey.setOnClickListener(this);
         ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
         setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
    private void setupViewPager(ViewPager viewPager) {
        int i=6;//TODO : come from db
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        //adapter.addFrag(new CompletedSurveyFragment(), StringUtils.getStringfrmRes(R.string.in_progress_Survey, this)+"("+i+")");
        //adapter.addFrag(new InProgressFragment(), StringUtils.getStringfrmRes(R.string.completed_survey, this)+"("+i+")");

        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
