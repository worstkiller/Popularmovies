package com.design.vikas.popularmovies.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.design.vikas.popularmovies.R;
import com.design.vikas.popularmovies.model.ResponseDetailModel;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by vikas kumar on 6/16/2016.
 */

/* picasso is an open source android image library project used for making image cache and handling better way
   hosted here - http://square.github.io/picasso/
 */

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder> {

    private static ClickListener clickListener;
    List<ResponseDetailModel> detailModels ;
    Context context;

    public RecyclerviewAdapter(List<ResponseDetailModel> detailModels, Context context) {
        this.detailModels = detailModels;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ResponseDetailModel detailModel  = detailModels.get(position);
        String url = "https://image.tmdb.org/t/p/w342"+detailModel.getPosterPath();
        Picasso.with(context).load(url).placeholder(R.drawable.placeholder).into(holder.imageView);
    }

    @Override
    public int getItemCount() {

        return detailModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.ivMoviesPoster);
            imageView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition(), view);
        }
    }

    public void setOnItemClickListener(ClickListener onItemClickListener){
        RecyclerviewAdapter.clickListener = onItemClickListener;

    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }
}
