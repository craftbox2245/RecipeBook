package com.recipebook.fragment;

/**
 * Created by Hardip on 24/12/2018.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.recipebook.R;
import com.recipebook.adapter.ProductAdapter;
import com.recipebook.custom.SpacesItemDecoration;
import com.recipebook.model.ProductModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView recycleView;
    ArrayList<ProductModel> data = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        recycleView = (RecyclerView) rootView.findViewById(R.id.recycleView);

        try {
            Bundle bundle = getArguments();
            String id = bundle.getString("id");
            if (id.equals("0")) {
                loadBreakfast();
                Appetizer();
                Soup();
            } else if (id.equals("1")) {
                loadBreakfast();
            } else if (id.equals("2")) {
                Appetizer();
            } else if (id.equals("3")) {
                Soup();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        int spanCount = 2; // 3 columns
        int spacing = 5; // 50px
        boolean includeEdge = false;
        recycleView.addItemDecoration(new SpacesItemDecoration(spanCount, spacing, includeEdge));
        ProductAdapter itemListDataAdapter = new ProductAdapter(getActivity(), data);
        recycleView.setLayoutManager(layoutManager);
        recycleView.setAdapter(itemListDataAdapter);
        // Inflate the layout for this fragment
        return rootView;
    }

    public void loadBreakfast() {
        ProductModel da = new ProductModel();
        da.setId("1");
        da.setName("Baked Biscuits");
        da.setImagePath("http://mock.robotemplates.com/cookbook/biscuits.jpg");
        data.add(da);

        da = new ProductModel();
        da.setId("1");
        da.setName("Belgian Waffle");
        da.setImagePath("http://mock.robotemplates.com/cookbook/waffle.jpg");
        data.add(da);

        da = new ProductModel();
        da.setId("1");
        da.setName("English Breakfast");
        da.setImagePath("http://mock.robotemplates.com/cookbook/english.jpg");
        data.add(da);

        da = new ProductModel();
        da.setId("1");
        da.setName("Perfect Sandwiches");
        da.setImagePath("http://mock.robotemplates.com/cookbook/sandwiches.jpg");
        data.add(da);
    }

    public void Appetizer() {
        ProductModel da = new ProductModel();
        da.setId("1");
        da.setName("Eggs With Crab Dip");
        da.setImagePath("http://mock.robotemplates.com/cookbook/eggs.jpg");
        data.add(da);

        da = new ProductModel();
        da.setId("1");
        da.setName("Hot Gingered Prawns");
        da.setImagePath("http://mock.robotemplates.com/cookbook/prawns.jpg");
        data.add(da);

        da = new ProductModel();
        da.setId("1");
        da.setName("Rings Calamari");
        da.setImagePath("http://mock.robotemplates.com/cookbook/calamari.jpg");
        data.add(da);

        da = new ProductModel();
        da.setId("1");
        da.setName("Sausage Babies");
        da.setImagePath("http://mock.robotemplates.com/cookbook/sausage.jpg");
        data.add(da);

        da = new ProductModel();
        da.setId("1");
        da.setName("Sushi Rolls");
        da.setImagePath("http://mock.robotemplates.com/cookbook/sushi.jpg");
        data.add(da);

        da = new ProductModel();
        da.setId("1");
        da.setName("Tuna Nachos");
        da.setImagePath("http://mock.robotemplates.com/cookbook/nachos.jpg");
        data.add(da);

    }

    public void Soup() {
        ProductModel da = new ProductModel();
        da.setId("1");
        da.setName("Curried Asparagus and Kaffir Lime Soup");
        da.setImagePath("http://mock.robotemplates.com/cookbook/asparagus.jpg");
        data.add(da);

        da = new ProductModel();
        da.setId("1");
        da.setName("Goulash Soup");
        da.setImagePath("http://4.bp.blogspot.com/-B2lTOUQHRZU/Vf8_0RdyJ3I/AAAAAAAAH_g/JFFl0Jc70_U/s1600/goulash-soup.jpg");
        data.add(da);

        da = new ProductModel();
        da.setId("1");
        da.setName("Matzoh Ball Soup");
        da.setImagePath("http://mock.robotemplates.com/cookbook/matzoh.jpg");
        data.add(da);

        da = new ProductModel();
        da.setId("1");
        da.setName("Potato Soup");
        da.setImagePath("http://mock.robotemplates.com/cookbook/potatosoup.jpg");
        data.add(da);

        da = new ProductModel();
        da.setId("1");
        da.setName("Split Pea Soup");
        da.setImagePath("http://mock.robotemplates.com/cookbook/pea.jpg");
        data.add(da);
    }

}
