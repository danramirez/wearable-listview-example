
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

package es.danielramirez.wearablelistviewexample.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WearableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import es.danielramirez.wearablelistviewexample.R;
import es.danielramirez.wearablelistviewexample.listview.ListViewAdapter;
import es.danielramirez.wearablelistviewexample.listview.ListViewItem;

public class MainActivity extends Activity implements WearableListView.ClickListener{

    private List<ListViewItem> viewItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_list_activity);

        WearableListView wearableListView = (WearableListView) findViewById(R.id.wearable_list_view);

        viewItemList.add(new ListViewItem(R.drawable.ic_basketball, "Basketball"));
        viewItemList.add(new ListViewItem(R.drawable.ic_baseball, "Baseball"));
        viewItemList.add(new ListViewItem(R.drawable.ic_running, "Running"));
        viewItemList.add(new ListViewItem(R.drawable.ic_skateboard, "Skateboard"));

        wearableListView.setAdapter(new ListViewAdapter(this, viewItemList));
        wearableListView.setClickListener(this);
    }

    @Override
    public void onClick(WearableListView.ViewHolder viewHolder) {
        Toast.makeText(this, "Click on " + viewItemList.get(viewHolder.getLayoutPosition()).text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTopEmptyRegionClick() {

    }
}
