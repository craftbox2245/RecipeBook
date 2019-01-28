package com.recipebook;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.recipebook.adapter.ProductAdapter;
import com.recipebook.adapter.RandomAdapter;
import com.recipebook.custom.SpacesItemDecoration;
import com.recipebook.model.RandomModel;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RandomImageActivity extends AppCompatActivity implements RandomAdapter.onClickimage {

    ArrayList<RandomModel> data = new ArrayList<>();
    RandomAdapter adapter;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_image);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Random");

        for (int i = 0; i < 20; i++) {
            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            RandomModel da = new RandomModel();
            da.setId("" + i);
            da.setImageColor(color);
            da.setCount("");
            da.setSelected(false);
            data.add(da);
        }

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(RandomImageActivity.this, 2);
        int spanCount = 2; // 3 columns
        int spacing = 5; // 50px
        boolean includeEdge = false;
        recycleView.addItemDecoration(new SpacesItemDecoration(spanCount, spacing, includeEdge));
        adapter = new RandomAdapter(RandomImageActivity.this, data);
        recycleView.setLayoutManager(layoutManager);
        recycleView.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void clickImage(int position) {
        try {
            int count = 0;
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i).isSelected()) {
                    count++;
                    data.get(i).setCount("" + count);
                }
                else{
                    data.get(i).setCount("");
                }
            }
            adapter.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
