package com.example.appmoviesontv;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<String> f;
    private Context context;

    public DataAdapter(Context context,ArrayList<String> f) {
        this.context = context;
        this.f = f;

    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        //viewHolder.tv_android.setText(f.get(i).getAndroid_version_name());
        Picasso.get().load(f.get(i)).into(viewHolder.img_f);
    }

    @Override
    public int getItemCount() {
        return f.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //TextView tv_android;
        ImageView img_f;
        public ViewHolder(View view) {
            super(view);

           // tv_android = (TextView)view.findViewById(R.id.tv_android);
            img_f = (ImageView)view.findViewById(R.id.img_android);
        }
    }
}
