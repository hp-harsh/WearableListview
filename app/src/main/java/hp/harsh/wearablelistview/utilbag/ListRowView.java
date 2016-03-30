
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

package hp.harsh.wearablelistview.utilbag;

import android.content.Context;
import android.support.wearable.view.WearableListView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import hp.harsh.wearablelistview.R;

public class ListRowView extends FrameLayout implements WearableListView.OnCenterProximityListener {

    private ImageView mImgView;
    private TextView mTxtView;

    public ListRowView(Context context) {
        super(context);
        // inflate list item layout
        View.inflate(context, R.layout.view_wearable_list_row, this);

        // Get references to the icon and text in the item layout definition
        mImgView = (ImageView) findViewById(R.id.imgCountry);
        mTxtView = (TextView) findViewById(R.id.txtCountryName);
    }

    // Set animation to show different view in center
    @Override
    public void onCenterPosition(boolean b) {
        mImgView.animate().scaleX(1.2f).scaleY(1.2f).alpha(1).setDuration(200);
        mTxtView.animate().scaleX(1.2f).scaleY(1.2f).alpha(1).setDuration(200);
    }

    // Set normal animation to show original view without center
    @Override
    public void onNonCenterPosition(boolean b) {
        mImgView.animate().scaleX(1f).scaleY(1f).alpha(0.6f).setDuration(200);
        mTxtView.animate().scaleX(1f).scaleY(1f).alpha(0.6f).setDuration(200);
    }

    // Return row item imageview
    public ImageView getCoutryImageView() {
        return mImgView;
    }

    // Return row item textview
    public TextView getCountryTextView() {
        return mTxtView;
    }
}