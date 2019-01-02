package com.recipebook.pageAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.recipebook.fragment.HomeFragment;
import com.recipebook.model.GeneralModel;

import java.util.ArrayList;

/**
 * Created by CRAFT BOX on 12/23/2016.
 */

public class TabPagerAdapter extends FragmentPagerAdapter {

    Fragment f;
    ArrayList<GeneralModel> categoryModels = new ArrayList<>();

    public TabPagerAdapter(FragmentManager fm, ArrayList<GeneralModel> topCategoryModels) {
        super(fm);
        this.categoryModels = topCategoryModels;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return categoryModels.get(position).getName();
    }

    @Override
    public int getCount() {
        return categoryModels.size();
    }

    @Override
    public Fragment getItem(int position) {

        f = new HomeFragment();
        Bundle bundle=new Bundle();
        bundle.putString("id",""+categoryModels.get(position).getId());
        f.setArguments(bundle);
        return f;

        /*if (position == 0) {
            f = new HomeFragment();
            Bundle bundle=new Bundle();
            bundle.putString("id","1");
            f.setArguments(bundle);
            return f;
        } else if (position == 1) {
            f = new HomeFragment();
            Bundle bundle=new Bundle();
            bundle.putString("id","2");
            f.setArguments(bundle);
            return f;
        } else {
            f = new HomeFragment();
            Bundle bundle=new Bundle();
            bundle.putString("id","3");
            f.setArguments(bundle);
            return f;
        }*/
    }
}
