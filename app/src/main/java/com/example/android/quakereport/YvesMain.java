package com.example.android.quakereport;

import android.util.Log;

/**
 * Created by ARINZE on 2017-07-31.
 */
public class YvesMain {
    public static void main(String []arg){
        Yves yves = new Yves();
        Yves yves1 = new Yves(5.7,"Abuja",14000,"www.google.com");

        Log.d("Location ",yves.getLocation());
    }
}
