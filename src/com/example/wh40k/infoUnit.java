package com.example.wh40k;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dertkaes on 3/25/2015.
 */
public class infoUnit extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_upgrades);
        W40kUnit unit = getIntent().getParcelableExtra("unit");
        ListView upgrades = (ListView)findViewById(R.id.listView2);
        View header = getLayoutInflater().inflate(R.layout.info_header, null);
        upgrades.addHeaderView(header);
        TextView name = (TextView)findViewById(R.id.textView3);
        name.setText(unit.getName());
        TextView description = (TextView)findViewById(R.id.textView4);
        description.setText(unit.getDescription());
        List<W40kOption> options = unit.getOptions();
        List<Map<String, String>> items = new ArrayList<Map<String, String>>();
        for(W40kOption option : options) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("name", option.getName());
            item.put("description", option.getDescription());
            items.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, items, android.R.layout.simple_list_item_2, new String[]{"name", "description"}, new int[]{android.R.id.text1, android.R.id.text2});
        upgrades.setAdapter(adapter);
        upgrades.requestLayout();
        new DownloadImageTask((ImageView)findViewById(R.id.imageView)).execute(unit.getImagePath());
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            InputStream in = null;
            try {
                in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            } finally {
                if(in != null) {
                    try {
                        in.close();
                    } catch (Exception e) {
                        Log.e("Error", e.getMessage());
                    }
                }
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}