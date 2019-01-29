package com.recipebook.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.recipebook.R;
import com.recipebook.model.GeneralModel;

import java.util.ArrayList;
import java.util.Locale;


/**
 * Created by CRAFT BOX on 11/28/2016.
 */

public class GeneralAdapter extends RecyclerView.Adapter<GeneralAdapter.ViewHolder> {

    Context context;
    ArrayList<GeneralModel> data = new ArrayList<>();

    private DisplayImageOptions options;
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    private ArrayList<GeneralModel> arraylist = new ArrayList<>();

    public GeneralAdapter(Context context, ArrayList<GeneralModel> da) {
        this.context = context;
        this.data = da;
        this.arraylist.addAll(data);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vi = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_general, parent,false);
        return new ViewHolder(vi);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        try {
            holder.name.setText("" + data.get(position).getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.general_name);
        }
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        data.clear();
        if (charText.length() == 0) {
            data.addAll(arraylist);
        } else {
            for (GeneralModel wp : arraylist) {
                if (wp.getName().toLowerCase(Locale.getDefault()).contains(charText.toLowerCase())) {
                    data.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}
