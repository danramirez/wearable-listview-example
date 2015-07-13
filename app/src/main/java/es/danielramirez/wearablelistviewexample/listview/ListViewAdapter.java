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
import android.view.ViewGroup;

import java.util.List;

public class ListViewAdapter extends WearableListView.Adapter  {

    private Context context;
    private List<ListViewItem> listViewItems;

    public ListViewAdapter(Context context, List<ListViewItem> listViewItems) {
        this.context = context;
        this.listViewItems = listViewItems;
    }

    @Override
    public WearableListView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new WearableListView.ViewHolder(new ListViewRowView(context));
    }

    @Override
    public void onBindViewHolder(WearableListView.ViewHolder viewHolder, int i) {
        ListViewRowView listViewRowView = (ListViewRowView) viewHolder.itemView;
        final ListViewItem listViewItem = listViewItems.get(i);

        listViewRowView.getImage().setImageResource(listViewItem.imageRes);
        listViewRowView.getText().setText(listViewItem.text);
    }

    @Override
    public int getItemCount() {
        return listViewItems.size();
    }
}
