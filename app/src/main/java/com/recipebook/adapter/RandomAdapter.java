package com.recipebook.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.recipebook.R;
import com.recipebook.model.ProductModel;
import com.recipebook.model.RandomModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by CRAFT BOX on 11/28/2016.
 */

public class RandomAdapter extends RecyclerView.Adapter<RandomAdapter.ViewHolder> {

    Context context;
    ArrayList<RandomModel> data = new ArrayList<>();

    public interface onClickimage {
        public void clickImage(int position);
    }

    public RandomAdapter(Context context, ArrayList<RandomModel> da) {
        this.context = context;
        this.data = da;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vi = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_random, null);
        return new ViewHolder(vi);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        try {
            holder.countTxt.setText("" + data.get(position).getCount());
            holder.listHomeImg.setBackgroundColor(data.get(position).getImageColor());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        if (data.get(position).isSelected()) {
                            data.get(position).setSelected(false);
                        } else {
                            data.get(position).setSelected(true);
                        }
                        onClickimage clickimage = (onClickimage) context;
                        clickimage.clickImage(position);
                    } catch (Exception e) {
                        e.printStackTrace();
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

        @BindView(R.id.list_home_img)
        ImageView listHomeImg;
        @BindView(R.id.count_txt)
        TextView countTxt;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
