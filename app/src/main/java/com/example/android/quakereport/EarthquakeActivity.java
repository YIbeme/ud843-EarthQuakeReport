/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {


    /**added*/
    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=4&limit=10";

    public static final String LOG_TAG = EarthquakeActivity.class.getName();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);


        /**added*/
        EarthquakeAsyncTask task = new EarthquakeAsyncTask();
        task.execute(USGS_REQUEST_URL);}


        /**placeholder for fake list of earthquaker
        // Create a fake list of earthquake locations.
        final ArrayList<Yves> earthquakes = new ArrayList<Yves>();

        earthquakes.add(new Yves ("7.3", "San Francisco", "Feb 2, 2016"));
        earthquakes.add(new Yves ("4", "London", "Feb 2, 2016"));
        earthquakes.add(new Yves ("8.7", "Tokyo", "Dec 12, 2016"));
        earthquakes.add(new Yves ("4.5", "Mexico", "June 4, 2010"));
        earthquakes.add(new Yves ("5.4", "Brazil", "Feb 2, 2016"));
        earthquakes.add(new Yves ("9.4", "Germany", "Feb 2, 2016"));
        earthquakes.add(new Yves ("6.2", "U.S.A", "Feb 2, 2016"));
         **/

        /**
         *ArrayList<Yves> earthquakes = QueryUtils.extractYves();
         * ORIGINAL CODE*/




        /**
         * ArrayList<Yves> earthquakes = QueryUtils.extractFeatureFromJson(jsonResponse);
         */



    private void updateIU(ArrayList<Yves> earthquakes) {

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        /**
        // Create a new {@link ArrayAdapter} of earthquakes
        YvesAdapter adapter = new YvesAdapter(this, earthquakes,R.color.category_family);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
         **/





        // Create a new adapter that takes the list of earthquakes as input
       /**
        * ORIGINAL CODE
        * final YvesAdapter adapter = new YvesAdapter(this, earthquakes, R.color.category_family);*/

        final YvesAdapter adapter = new YvesAdapter(this, earthquakes, R.color.category_family);



        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current earthquake that was clicked on
                Yves currentEarthquake = adapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());

                // Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });

    }


    /**added*/
    /**
     * Update the UI with the given earthquake information.
     */
    /**
    private void updateUi(Event earthquake) {
        TextView titleTextView = (TextView) findViewById(R.id.title);
        titleTextView.setText(earthquake.title);

        TextView tsunamiTextView = (TextView) findViewById(R.id.number_of_people);
        tsunamiTextView.setText(getString(R.string.num_people_felt_it, earthquake.numOfPeople));

        TextView magnitudeTextView = (TextView) findViewById(R.id.perceived_magnitude);
        magnitudeTextView.setText(earthquake.perceivedStrength);
    }

    */

    /**added*/
    private class EarthquakeAsyncTask extends AsyncTask<String, Void, ArrayList<Yves>> {
        @Override
        protected ArrayList<Yves> doInBackground(String... urls) {

            // Don't perform the request if there are no URLs, or the first URL is null.
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            // Perform the HTTP request for earthquake data and process the response.
           /** ArrayList<Yves> result = QueryUtils.fetchEarthquakeData(urls[0]);
            return result;
            */

            ArrayList<Yves> result = QueryUtils.fetchEarthquakeData(urls[0]);

            return result;
        }

        @Override
        protected void onPostExecute(ArrayList<Yves> result) {

            // If there is no result, do nothing.
            if (result == null) {
                return;
            }

            updateIU(result);
        }

    }


}
