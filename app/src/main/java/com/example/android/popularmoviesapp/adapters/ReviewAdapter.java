package com.example.android.popularmoviesapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.android.popularmoviesapp.R;
import com.example.android.popularmoviesapp.schema.ReviewSchema;

import java.util.ArrayList;

/**
 * Created by Ahmed Mohamed on 24/8/2016.
 */
public class ReviewAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<ReviewSchema> objects;

    public ReviewAdapter(Context context, ArrayList<ReviewSchema> objects) {
        inflater = LayoutInflater.from(context);
        this.objects = objects;
    }

    public int getCount() {
        return objects.size();
    }

    public ReviewSchema getItem(int position) {
        return objects.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.review_items, null);
            holder.textView1 = (TextView) convertView.findViewById(R.id.t1);
            holder.textView2 = (TextView) convertView.findViewById(R.id.t2);
            holder.textView3 = (TextView) convertView.findViewById(R.id.t3);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView1.setText(objects.get(position).getAuthor());
        holder.textView2.setText(objects.get(position).getUrl());
        holder.textView3.setText(objects.get(position).getContent());
        return convertView;
    }

    private class ViewHolder {
        TextView textView1;
        TextView textView2;
        TextView textView3;
    }
}