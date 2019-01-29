package com.recipebook.fragment;

/**
 * Created by Hardip on 24/12/2018.
 */

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.recipebook.R;
import com.recipebook.adapter.ProductAdapter;
import com.recipebook.custom.EqualSpacingItemDecoration;
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
                flower();
                car();
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
        recycleView.addItemDecoration(new EqualSpacingItemDecoration(10));
        ProductAdapter itemListDataAdapter = new ProductAdapter(getActivity(), data);
        recycleView.setLayoutManager(layoutManager);
        recycleView.setAdapter(itemListDataAdapter);
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
            recycleView.setLayoutManager(layoutManager);
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 4);
            recycleView.setLayoutManager(layoutManager);
        }
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

    public void flower() {
        ProductModel da = new ProductModel();
        da.setId("1");
        da.setName("Rose");
        da.setImagePath("https://images-na.ssl-images-amazon.com/images/I/51D4tIXLo2L._SX425_.jpg");
        data.add(da);

        da = new ProductModel();
        da.setId("1");
        da.setName("Lotus");
        da.setImagePath("https://www.treetopzencenter.org/wp-content/uploads/2010/05/5e94067f43eafbd7cb097cf08ecaa72e_the-leaves-of-a-lotus-flower-lotus_1024-680.jpeg");
        data.add(da);
    }

    public void car() {
        ProductModel da = new ProductModel();
        da.setId("1");
        da.setName("Pourche");
        da.setImagePath("https://www.autocar.co.uk/sites/autocar.co.uk/files/styles/body-image/public/porsche-911_1.jpg");
        data.add(da);

        da = new ProductModel();
        da.setId("1");
        da.setName("Odd");
        da.setImagePath("https://car-images.bauersecure.com/pagefiles/79892/1040x585/electric_car_14.jpg");
        data.add(da);
    }
}
