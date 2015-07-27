package work.anmol.com.meracampus.ContentActivities.NavDrawerActivities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import work.anmol.com.meracampus.Adapters.NewsAdapter;
import work.anmol.com.meracampus.DrawerActivity;
import work.anmol.com.meracampus.Models.News;
import work.anmol.com.meracampus.R;


public class NewsAndEventsActivity extends DrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_and_events);

        ListView listView = (ListView) findViewById(R.id.lvNewsFeed);
        News news = new News();

        List<News> m = new ArrayList<>();
        m.add(news);
        m.add(new News("Avenis Coming", new Date(2015, 7, 14)));
        m.add(new News("Enva Coming", new Date(2015, 5, 3)));
        m.add(new News("IEEE round table conference is on the way", new Date(2015, 11, 19)));
        m.add(new News("Result Declared", new Date(2015, 1, 21)));
        m.add(new News("Sessionals ahead", new Date(2015, 3, 16)));
        m.add(new News("MSIT summer training by OSAHUB", new Date(2014, 5, 6)));
        NewsAdapter adapt = new NewsAdapter(getApplicationContext(), m);
        listView.setAdapter(adapt);
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences prefs = getSharedPreferences("meraCampus", MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("activity_type", "navDrawer");
        edit.apply();
    }
}
