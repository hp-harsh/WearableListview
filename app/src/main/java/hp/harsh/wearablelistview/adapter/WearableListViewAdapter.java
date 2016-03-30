
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

package hp.harsh.wearablelistview.adapter;

import android.content.Context;
import android.support.wearable.view.WearableListView;
import android.view.ViewGroup;

import java.util.ArrayList;

import hp.harsh.wearablelistview.model.CountryModel;
import hp.harsh.wearablelistview.utilbag.ListRowView;

public class WearableListViewAdapter extends WearableListView.Adapter {

    private Context mContext;
    private ArrayList<CountryModel> mCountryList;

    // Provide a suitable constructor
    public WearableListViewAdapter(Context context, ArrayList<CountryModel> countryList) {
        this.mContext = context;
        this.mCountryList = countryList;
    }

    // Create new views for list items
    // (invoked by the WearableListView's layout manager)
    @Override
    public WearableListView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WearableListView.ViewHolder(new ListRowView(mContext));
    }

    // Replace the contents of a list item
    // Instead of creating new views, the list tries to recycle existing ones
    // (invoked by the WearableListView's layout manager)
    @Override
    public void onBindViewHolder(WearableListView.ViewHolder holder, int position) {
        ListRowView listRowView = (ListRowView) holder.itemView;
        CountryModel model = mCountryList.get(position);

        listRowView.getCoutryImageView().setImageResource(model.getCountryFlag());
        listRowView.getCountryTextView().setText(model.getCountryName());
    }

    // Return the size of your dataset
    // (invoked by the WearableListView's layout manager)
    @Override
    public int getItemCount() {
        return mCountryList.size();
    }
}
