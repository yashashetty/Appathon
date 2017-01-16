package voc.appathon.com.voiceofcustomer.model;

/**
 * Created by yshetty on 1/16/17.
 */

public class User {

    public String getUserid() {
        return Userid;
    }

    public void setUserid(String userid) {
        Userid = userid;
    }

    String Userid;
    boolean isAdmin;

}
