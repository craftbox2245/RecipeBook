package com.recipebook.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kogitune.activitytransition.ActivityTransitionLauncher;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.recipebook.R;
import com.recipebook.WallpaperBoardPreviewActivity;
import com.recipebook.model.ProductModel;

import java.util.ArrayList;


/**
 * Created by CRAFT BOX on 11/28/2016.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    Context context;
    ArrayList<ProductModel> data = new ArrayList<>();

    private DisplayImageOptions options;
    protected ImageLoader imageLoader = ImageLoader.getInstance();

    public ProductAdapter(Context context, ArrayList<ProductModel> da) {
        this.context = context;
        this.data = da;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vi = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_home, null);
        return new ViewHolder(vi);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        try {
            holder.name.setText("" + data.get(position).getName());
            if (!data.get(position).getImagePath().equals("")) {
                imageLoader.init(ImageLoaderConfiguration.createDefault(context));
                options = new DisplayImageOptions.Builder()
                        .showImageForEmptyUri(R.drawable.placeholder_photo)
                        .showImageOnFail(R.drawable.placeholder_photo)
                        .cacheInMemory(true)
                        .cacheOnDisk(true)
                        .build();
                imageLoader.displayImage(data.get(position).getImagePath(), holder.homeImg, options);
            }

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        Bitmap bitmap = null;
                        if (holder.homeImg.getDrawable() != null) {
                            bitmap = ((BitmapDrawable) holder.homeImg.getDrawable()).getBitmap();
                        }
                        final Intent intent = new Intent(context, WallpaperBoardPreviewActivity.class);
                        intent.putExtra("url", data.get(position).getImagePath());
                        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        ActivityTransitionLauncher.with((AppCompatActivity) context)
                                .from(holder.homeImg, "image")
                                .image(bitmap)
                                .launch(intent);
                    } catch (Exception e) {
                        //WallpaperBoardApplication.sIsClickable = true;
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView homeImg;
        TextView name;
        public ViewHolder(View itemView) {
            super(itemView);
            homeImg = (ImageView) itemView.findViewById(R.id.list_home_img);
            name = (TextView) itemView.findViewById(R.id.name);
        }
    }
}
