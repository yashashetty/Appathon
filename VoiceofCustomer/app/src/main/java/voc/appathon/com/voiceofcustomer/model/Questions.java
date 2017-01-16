package voc.appathon.com.voiceofcustomer.model;

/**
 * Created by yshetty on 1/16/17.
 */

public class Questions {

    public MultiChoice multichoice;
    public Rating rating;


    public MultiChoice getMultichoice() {
        return multichoice;
    }

    public void setMultichoice(MultiChoice multichoice) {
        this.multichoice = multichoice;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }


}
