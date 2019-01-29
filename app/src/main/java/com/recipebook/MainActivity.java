package com.recipebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.recipebook.fragment.HomeFragment;
import com.recipebook.fragment.TabFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", "0");
        fragment.setArguments(bundle);
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Home");
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            fragment = new HomeFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", "0");
            fragment.setArguments(bundle);
        } else if (id == R.id.nav_breakfast) {
            fragment = new HomeFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", "1");
            fragment.setArguments(bundle);
        } else if (id == R.id.nav_appetizers) {
            fragment = new HomeFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", "2");
            fragment.setArguments(bundle);
        } else if (id == R.id.nav_soups) {
            fragment = new HomeFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", "3");
            fragment.setArguments(bundle);
        } else if (id == R.id.nav_search) {
            Intent intent = new Intent(MainActivity.this, SearchActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_viewpager) {
            Intent intent = new Intent(MainActivity.this, ViewPagerActvity.class);
            startActivity(intent);
        } else if (id == R.id.nav_random) {
            Intent intent = new Intent(MainActivity.this, RandomImageActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_swip_to_delete) {
            Intent intent = new Intent(MainActivity.this, SwipToDeleteActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_share) {
            fragment = new TabFragment();
        } else if (id == R.id.nav_send) {
            Intent intent = new Intent(MainActivity.this, MultiLayoutActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_multi_spinner) {
            Intent intent = new Intent(MainActivity.this, MultiSelectionSpinnerActivity.class);
            startActivity(intent);
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Home");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
