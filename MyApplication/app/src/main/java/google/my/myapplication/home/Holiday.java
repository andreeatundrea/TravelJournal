package google.my.myapplication.home;

public class Holiday {

    private String mName;
    private String mDestination;
    private String mRating;
    private String mPicture;



    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDestination() { return mDestination;}

    public void setDestination(String destination) { mDestination = destination; }

    public String getRating() {
        return mRating;
    }

    public void setRating(String rating) {
        mRating = rating;
    }

    public String getPicture() {
        return mPicture;
    }

    public void setPicture(String picture) {
        mPicture = picture;
    }

    public Holiday( String name, String destination, String rating, String picture) {

        mName = name;
        mDestination = destination;
        mRating = rating;
        mPicture = picture;
    }
}
