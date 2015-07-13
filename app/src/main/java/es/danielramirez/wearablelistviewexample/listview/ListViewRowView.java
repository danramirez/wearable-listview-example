/*
 * Copyright 2015. Daniel Ramírez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package es.danielramirez.wearablelistviewexample.listview;

import android.content.Context;
import android.support.wearable.view.WearableListView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import es.danielramirez.wearablelistviewexample.R;

public class ListViewRowView extends FrameLayout implements WearableListView.OnCenterProximityListener {

    private ImageView image;
    private TextView text;

    public ListViewRowView(Context context) {
        super(context);
        View.inflate(context, R.layout.wearablelistview_image_text_item, this);
        image = (ImageView) findViewById(R.id.image);
        text = (TextView) findViewById(R.id.text);
    }

    @Override
    public void onCenterPosition(boolean b) {
        image.animate().scaleX(1.2f).scaleY(1.2f).alpha(1).setDuration(200);;
        text.animate().scaleX(1.2f).scaleY(1.2f).alpha(1).setDuration(200);;
    }

    @Override
    public void onNonCenterPosition(boolean b) {
        image.animate().scaleX(1f).scaleY(1f).alpha(0.6f).setDuration(200);
        text.animate().scaleX(1f).scaleY(1f).alpha(0.6f).setDuration(200);
    }

    public ImageView getImage() {
        return image;
    }

    public TextView getText() {
        return text;
    }
}
