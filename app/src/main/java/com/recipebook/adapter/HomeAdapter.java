package com.recipebook.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.recipebook.R;
import com.recipebook.model.HomeModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by CRAFT BOX on 11/28/2016.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    Context context;
    ArrayList<HomeModel> data = new ArrayList<>();

    private DisplayImageOptions options;
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    int ViewPostion = 0;

    public HomeAdapter(Context context, ArrayList<HomeModel> da) {
        this.context = context;
        this.data = da;
    }

    @Override
    public int getItemViewType(int position) {
        this.ViewPostion = position;
        return position;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vi = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_multi_home, null);
        return new ViewHolder(vi);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        try {
            holder.listHomePrice.setText("₹ " + data.get(position).getPrice());
            holder.listHomeName.setText("" + data.get(position).getName());
            holder.ratingBar.setRating(Float.parseFloat("" + data.get(position).getRating()));

            if (!data.get(position).getImage_path().equals("")) {
                imageLoader.init(ImageLoaderConfiguration.createDefault(context));
                options = new DisplayImageOptions.Builder()
                        .showImageForEmptyUri(R.mipmap.ic_launcher)
                        .showImageOnFail(R.mipmap.ic_launcher)
                        .cacheInMemory(true)
                        .cacheOnDisk(true)
                        .build();
                imageLoader.displayImage(data.get(position).getImage_path(), holder.listHomeImg, options);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.list_home_img)
        ImageView listHomeImg;
        @BindView(R.id.list_home_price)
        TextView listHomePrice;
        @BindView(R.id.list_home_name)
        TextView listHomeName;
        @BindView(R.id.review_rat)
        RatingBar ratingBar;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
