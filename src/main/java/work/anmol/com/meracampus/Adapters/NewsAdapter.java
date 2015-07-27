package work.anmol.com.meracampus.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import work.anmol.com.meracampus.Models.News;
import work.anmol.com.meracampus.R;

/**
 * Created by anmol on 7/21/2015.
 */
public class NewsAdapter extends ArrayAdapter {
    LayoutInflater inflater;

    public NewsAdapter(Context context, List<News> n) {
        super(context, R.layout.news_item, n);

    }

    public NewsAdapter(Context context, int resource, LayoutInflater inflater) {
        super(context, resource);
        this.inflater = inflater;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());

        View rootView = inflater.inflate(R.layout.news_item, parent, false);
        News events = (News) getItem(position);

        TextView tvNews = (TextView) rootView.findViewById(R.id.tvNewsAndEvents);
        TextView tvDate = (TextView) rootView.findViewById(R.id.tvDate);
        tvNews.setHighlightColor(Color.BLACK);
        tvNews.setTextColor(Color.BLUE);
        tvNews.setText(events.getNews());
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/yy");
        tvDate.setText(sdf.format(events.getDate()));

        return rootView;
    }

}
