package com.recipebook.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.recipebook.R;
import com.recipebook.model.ProductModel;

import java.util.ArrayList;

/**
 * Created by CRAFT BOX on 11/18/2016.
 */

public class ViewPagerAdapter extends PagerAdapter {
    ArrayList<ProductModel> data;
    Context context;
    LayoutInflater mLayoutInflater;
    private DisplayImageOptions options;
    protected ImageLoader imageLoader = ImageLoader.getInstance();

    public ViewPagerAdapter(Context Context, ArrayList<ProductModel> da) {
        this.context = Context;
        data = da;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(View ssView, Object ssObject) {
        return ssView == ((LinearLayout) ssObject);
    }

    @Override
    public Object instantiateItem(ViewGroup ssContainer, int ssPosition) {

        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = mLayoutInflater.inflate(R.layout.list_viewpage, ssContainer, false);
        ImageView img = (ImageView) itemView.findViewById(R.id.view_img);

        if (data.get(ssPosition).getImagePath().equals("")) {
           // img.setImageResource(R.drawable.banner);
        } else {
            try {
                imageLoader.init(ImageLoaderConfiguration.createDefault(context));
                options = new DisplayImageOptions.Builder()
                        .showImageForEmptyUri(R.drawable.adds)
                        .showImageOnFail(R.drawable.adds)
                        .cacheInMemory(true)
                        .build();
                imageLoader.displayImage(data.get(ssPosition).getImagePath(), img, options);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ssContainer.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup ssContainer, int ssPosition,
                            Object ssObject) {
        ((ViewPager) ssContainer).removeView((LinearLayout) ssObject);
    }
}
