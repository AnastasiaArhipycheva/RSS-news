package com.unn.rsslab;

import android.content.Context;
        import android.support.v4.content.ContextCompat;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.TextView;

        import java.text.SimpleDateFormat;
        import java.util.List;

/**
 * Created by Администратор on 14.11.2016.
 */

public class RssListAdapter extends BaseAdapter {

    private List<RssItem> items;
    private LayoutInflater inflater;
    private Context context;

    public RssListAdapter(Context context, List<RssItem> items) {
        this.items = items;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v == null){
            v = inflater.inflate(R.layout.rss_item, parent, false);
        }

        RssItem rssItem = items.get(position);
        ViewHolder holder = new ViewHolder(v);
        holder.titleTextView.setText(rssItem.getTitle());
        holder.descriptionTextView.setText(rssItem.getDescription());
        int color = ContextCompat.getColor(context, R.color.colorTextSecondary);
        holder.descriptionTextView.setTextColor(color);
        holder.dateTextView.setTextColor(color);
        holder.linkTextView.setTextColor(color);
        holder.dateTextView.setText(new SimpleDateFormat("d MMM HH:mm").format(rssItem.getPublishedDate()));
        holder.linkTextView.setText(rssItem.getLink());
        return v;
    }

    public class ViewHolder{

        public TextView linkTextView;

        public TextView titleTextView;

        public TextView descriptionTextView;

        public TextView dateTextView;

        public ViewHolder(View item){
            linkTextView = (TextView) item.findViewById(R.id.linkTextView);
            titleTextView = (TextView) item.findViewById(R.id.titleTextView);
            descriptionTextView = (TextView) item.findViewById(R.id.descriptionTextView);
            dateTextView = (TextView) item.findViewById(R.id.dateTextView);
        }
    }
}
