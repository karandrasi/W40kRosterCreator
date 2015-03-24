package com.example.wh40k;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Urgak_000 on 23.03.2015.
 */
public class Roster extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roster);

        List<W40kUnit> roster = getIntent().getParcelableArrayListExtra("roster");
        List<String> strings = new ArrayList<String>();
        for(W40kUnit unit : roster) {
            strings.add(unit.toString());
        }

        ListView lw = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strings);
        lw.setAdapter(mAdapter);
    }
}