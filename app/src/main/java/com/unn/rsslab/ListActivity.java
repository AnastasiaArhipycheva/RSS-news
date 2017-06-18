package com.unn.rsslab;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    ListView lvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lvMain = (ListView) findViewById(R.id.lvMain);
        String theme = getIntent().getStringExtra("theme");
        new RSSDownloader().execute(theme);
    }

    private class RSSDownloader extends AsyncTask<String, Void, List<RssItem>> {

        @Override
        protected List<RssItem> doInBackground(String... str) {
            List<RssItem> items = new ArrayList<>();
            SyndFeedInput input = new SyndFeedInput();
            try {
                URL url = new URL("http://news.yandex.ru/" + str[0] + ".rss");
                SyndFeed feed = input.build(new XmlReader(url));
                List<SyndEntry> entries = feed.getEntries();
                for (SyndEntry entry : entries) {
                    String title = entry.getTitle();
                    Date publishedDate = entry.getPublishedDate();
                    String link = entry.getLink();
                    String description = entry.getDescription().getValue();
                    RssItem item = new RssItem(title, link, description.replaceAll("&quot;", "'").replaceAll("Читать подробнее", "."), publishedDate);
                    items.add(item);
                }
            } catch (FeedException | IOException e) {
                e.printStackTrace();
            }
            System.out.println(items);
            return items;
        }

        @Override
        protected void onPostExecute(List<RssItem> feedItems) {
            super.onPostExecute(feedItems);
            RssListAdapter adapter = new RssListAdapter(ListActivity.this, feedItems);
            lvMain.setAdapter(adapter);
        }
    }
}
