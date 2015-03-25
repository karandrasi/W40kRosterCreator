package com.example.wh40k;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Urgak_000 on 23.03.2015.
 */
public class Roster extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roster);

        List<W40kUnit> roster = getIntent().getParcelableArrayListExtra("roster");
        List<Map<String, String>> items = new ArrayList<Map<String, String>>();
        for(W40kUnit unit : roster) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("name", unit.toString());
            item.put("options", unit.getOptions().toString());
            items.add(item);
        }

        ListView lw = (ListView)findViewById(R.id.listView);
        SimpleAdapter mAdapter = new SimpleAdapter(this, items, android.R.layout.simple_list_item_2, new String[]{"name", "options"}, new int[]{android.R.id.text1, android.R.id.text2});
        lw.setAdapter(mAdapter);
        lw.setOnItemClickListener(new OnItemClickListener(){


            @Override
            public void onItemClick(AdapterView<?>adapter,View v, int position){

                ItemClicked item = adapter.getItem(position);
                Intent intent = new Intent(Roster.this,infoUnit.class);
                startActivity(intent);

            }

        });
    }
}