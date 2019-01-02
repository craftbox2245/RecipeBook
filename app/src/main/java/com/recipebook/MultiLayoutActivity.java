package com.recipebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.recipebook.adapter.MultiFunctionAdapter;
import com.recipebook.model.HomeModel;
import com.recipebook.model.HomeMultiModel;

import java.util.ArrayList;

public class MultiLayoutActivity extends AppCompatActivity {

    ArrayList<HomeMultiModel> homeModels = new ArrayList<>();
    MultiFunctionAdapter homeAdapter;
    RecyclerView mainRecycleview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mainRecycleview = (RecyclerView) findViewById(R.id.main_recycleview);

        try {
            HomeMultiModel homeMultiModel = new HomeMultiModel();
            homeMultiModel.setType(1);

            ArrayList<HomeModel> models = new ArrayList<>();
            HomeModel da1 = new HomeModel();
            da1.setId("1");
            da1.setPrice("15,0000");
            da1.setName("Indoor furniture pe wicker sofa");
            da1.setImage_path("https://images-na.ssl-images-amazon.com/images/I/61UwrPEQZUL._SY355_.jpg");
            da1.setRating("2");
            da1.setType("1");
            models.add(da1);

            da1 = new HomeModel();
            da1.setId("1");
            da1.setPrice("15,0000");
            da1.setName("Indoor furniture pe wicker sofa");
            da1.setImage_path("https://assets.mspcdn.net/t_c-desktop-normal,f_auto,q_auto,d_c:noimage.jpg/c/11918-55-1.jpg");
            da1.setRating("2");
            da1.setType("1");
            models.add(da1);

            da1 = new HomeModel();
            da1.setId("1");
            da1.setPrice("15,0000");
            da1.setName("Indoor furniture pe wicker sofa");
            da1.setImage_path("https://images-na.ssl-images-amazon.com/images/I/61UwrPEQZUL._SY355_.jpg");
            da1.setRating("2");
            da1.setType("1");
            models.add(da1);

            da1 = new HomeModel();
            da1.setId("1");
            da1.setPrice("15,0000");
            da1.setName("Indoor furniture pe wicker sofa");
            da1.setImage_path("https://images-na.ssl-images-amazon.com/images/I/61UwrPEQZUL._SY355_.jpg");
            da1.setRating("2");
            da1.setType("1");
            models.add(da1);

            homeMultiModel.setHomeModels(models);
            homeModels.add(homeMultiModel);

            homeMultiModel = new HomeMultiModel();
            homeMultiModel.setType(2);
            homeModels.add(homeMultiModel);

            homeMultiModel = new HomeMultiModel();
            homeMultiModel.setType(2);
            homeModels.add(homeMultiModel);

            homeMultiModel = new HomeMultiModel();
            homeMultiModel.setType(1);

            models = new ArrayList<>();
            da1 = new HomeModel();
            da1.setId("1");
            da1.setPrice("15,0000");
            da1.setName("Indoor furniture pe wicker sofa");
            da1.setImage_path("https://images-na.ssl-images-amazon.com/images/I/61UwrPEQZUL._SY355_.jpg");
            da1.setRating("2");
            da1.setType("1");
            models.add(da1);

            da1 = new HomeModel();
            da1.setId("1");
            da1.setPrice("15,0000");
            da1.setName("Indoor furniture pe wicker sofa");
            da1.setImage_path("https://assets.mspcdn.net/t_c-desktop-normal,f_auto,q_auto,d_c:noimage.jpg/c/11918-55-1.jpg");
            da1.setRating("2");
            da1.setType("1");
            models.add(da1);

            da1 = new HomeModel();
            da1.setId("1");
            da1.setPrice("15,0000");
            da1.setName("Indoor furniture pe wicker sofa");
            da1.setImage_path("https://images-na.ssl-images-amazon.com/images/I/61UwrPEQZUL._SY355_.jpg");
            da1.setRating("2");
            da1.setType("1");
            models.add(da1);

            homeMultiModel.setHomeModels(models);
            homeModels.add(homeMultiModel);

            homeMultiModel = new HomeMultiModel();
            homeMultiModel.setType(2);
            homeModels.add(homeMultiModel);



            homeAdapter = new MultiFunctionAdapter(MultiLayoutActivity.this, homeModels);
            mainRecycleview.setLayoutManager(new LinearLayoutManager(MultiLayoutActivity.this));
            mainRecycleview.setAdapter(homeAdapter);
            mainRecycleview.setHasFixedSize(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

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
}
