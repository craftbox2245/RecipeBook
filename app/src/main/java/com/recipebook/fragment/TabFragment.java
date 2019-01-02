package com.recipebook.fragment;

/**
 * Created by Hardip on 24/12/2018.
 */

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.recipebook.R;
import com.recipebook.model.GeneralModel;
import com.recipebook.pageAdapter.TabPagerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TabFragment extends Fragment {

    @BindView(R.id.wishlist_tab)
    TabLayout wishlistTab;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    Unbinder unbinder;

    ArrayList<GeneralModel> data = new ArrayList<>();
    TabPagerAdapter pagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab, container, false);

        unbinder = ButterKnife.bind(this, rootView);
        GeneralModel da = new GeneralModel();
        da.setId("1");
        da.setName("Breakfast");
        data.add(da);

        da = new GeneralModel();
        da.setId("2");
        da.setName("Appetizers");
        data.add(da);

        da = new GeneralModel();
        da.setId("3");
        da.setName("Soups");
        data.add(da);

        pagerAdapter = new TabPagerAdapter(getActivity().getSupportFragmentManager(), data);
        viewPager.setAdapter(pagerAdapter);
        pagerAdapter.notifyDataSetChanged();
        wishlistTab.setupWithViewPager(viewPager);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
