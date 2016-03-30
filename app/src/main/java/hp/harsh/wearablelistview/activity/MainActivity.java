/*
* Copyright 2016 Harsh Patel
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package hp.harsh.wearablelistview.activity;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.support.wearable.view.WearableListView;
import android.widget.Toast;

import java.util.ArrayList;

import hp.harsh.wearablelistview.R;
import hp.harsh.wearablelistview.adapter.WearableListViewAdapter;
import hp.harsh.wearablelistview.model.CountryModel;

public class MainActivity extends Activity implements WearableListView.ClickListener {

    private WearableListView mWearableListView;
    private WearableListViewAdapter mWearableAdapter;

    private String[] mcountryNames;
    private TypedArray mCountryFlags;

    private ArrayList<CountryModel> mCountryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);

        // Get dataset for the list
        mcountryNames = getResources().getStringArray(R.array.country_name);
        mCountryFlags = getResources().obtainTypedArray(R.array.country_flag);

        mCountryList = new ArrayList<>();

        // Add data to preview list
        for (int i = 0; i < mcountryNames.length; i++) {
            mCountryList.add(new CountryModel(mcountryNames[i], mCountryFlags.getResourceId(i, 0)));
        }

        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                // Get the list component from the layout of the activity
                mWearableListView = (WearableListView) stub.findViewById(R.id.wearableListView);

                getCountryList();
            }
        });
    }

    // WearableListView click listener
    @Override
    public void onClick(WearableListView.ViewHolder viewHolder) {
        Toast.makeText(MainActivity.this, "" + mCountryList.get(viewHolder.getLayoutPosition()).getCountryName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTopEmptyRegionClick() {

    }

    // Set adapter for list data
    private void getCountryList() {
        mWearableAdapter = new WearableListViewAdapter(MainActivity.this, mCountryList);
        mWearableListView.setAdapter(mWearableAdapter); // Assign an adapter to the list
        mWearableAdapter.notifyDataSetChanged();

        // Set a click listener
        mWearableListView.setClickListener(this);
    }
}
