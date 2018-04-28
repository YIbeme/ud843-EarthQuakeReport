package com.example.android.quakereport;

/**
 * Created by ARINZE on 2016-09-07.
 */
public class Yves {
    /**
     * Default translation for the word also known as the states of the word class
     * Makes the states private, so other activities would not modify it
     */
    private double mMagnitude;

    /**
     * Miwok translation for the word also one state of the word class
     */
    private String mLocation;


    /** Time of the earthquake */
    private long mTimeInMilliseconds;

    /** Website URL of the earthquake */
    private String mUrl;





    /**
     * Constructs a new {@link Yves} object.
     *
     * @param Magnitude is the magnitude (size) of the earthquake
     * @param Location is the city location of the earthquake
     * @param timeInMilliseconds is the time in milliseconds (from the Epoch) when the
     *                           earthquake happened
     * @param url is the website URL to find more details about the earthquake
     */
    public Yves(double Magnitude,String Location, long timeInMilliseconds, String url) {
        mMagnitude = Magnitude;
        mLocation = Location;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
    }

    public Yves() {
        this(0.0,"",0,"");
    }

    /**
     *      Get method for getting the default translation of the word.
     *      Other activities can call this get method, without modify the ststes themselves
     */
    public double getMagnitude() {
        return mMagnitude;
    }



    /**
     *      * Get the Miwok translation of the word.
     *
     */
    public String getLocation() {
        return mLocation;
    }


    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    /**
     * Returns the website URL to find more information about the earthquake.
     */
    public String getUrl() {
        return mUrl;
    }


    public void setmMagnitude(double mMagnitude) {
        this.mMagnitude = mMagnitude;
    }


    public void setmTimeInMilliseconds(long mTimeInMilliseconds) {
        this.mTimeInMilliseconds = mTimeInMilliseconds;
    }



    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
