package com.example.appmoviesontv;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<FilmTmdb> f;
    private Context context;


    public DataAdapter(Context context,ArrayList<FilmTmdb> f) {
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
        viewHolder.tv_emmi_title.setText(f.get(i).getFilm().getTitle());
        viewHolder.tv_emmi_chaine.setText(f.get(i).getFilm().getChaine());
        try {
            viewHolder.tv_emmi_date.setText("Emission: " + dateconverter(f.get(i).getFilm().getDateonair()) +" à "+f.get(i).getFilm().getHourenair());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Picasso.get().load("https://image.tmdb.org/t/p/w500"+ f.get(i).getPoster_path()).into(viewHolder.img_f);
    }

    @Override
    public int getItemCount() {
        return f.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_emmi_title;
        TextView tv_emmi_chaine;
        TextView tv_emmi_date;
        ImageView img_f;
        public ViewHolder(View view) {
            super(view);
            tv_emmi_title=(TextView)view.findViewById(R.id.tv_emmi_title);
            tv_emmi_chaine = (TextView)view.findViewById(R.id.tv_emmi_chaine);
            tv_emmi_date = (TextView)view.findViewById(R.id.tv_emmi_date);
            img_f = (ImageView)view.findViewById(R.id.img_android);
        }
    }


    public String dateconverter(String sdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE);
        Date myDate = sdf.parse(sdate);
        sdf.applyPattern("EEE, d MMM yyyy");
        String sMyDate = sdf.format(myDate);
        return sMyDate;
    }
}
