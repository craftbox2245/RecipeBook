package com.recipebook;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.recipebook.adapter.ProductAdapter;
import com.recipebook.adapter.ViewPagerAdapter;
import com.recipebook.custom.ViewPagerFixed;
import com.recipebook.model.ProductModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewPagerActvity extends AppCompatActivity {

    ArrayList<ProductModel> data = new ArrayList<>();

    @BindView(R.id.view_pager)
    ViewPagerFixed viewPager;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_actvity);
        ButterKnife.bind(this);

        Mobile();
        loadBreakfast();
        Appetizer();
        Soup();
        flower();
        car();

        adapter = new ViewPagerAdapter(ViewPagerActvity.this, data);
        viewPager.setAdapter(adapter);

    }

    public void Mobile() {
        ProductModel da = new ProductModel();
        da.setId("1");
        da.setName("Baked Biscuits");
        da.setImagePath("https://i.pinimg.com/originals/48/20/b1/4820b1b0cb074261f04538be6eafd0de.jpg");
        data.add(da);

        da = new ProductModel();
        da.setId("1");
        da.setName("Baked Biscuits");
        da.setImagePath("https://i.pinimg.com/originals/e2/b8/2a/e2b82aded815e80351b929a77519adaa.jpg");
        data.add(da);

        da = new ProductModel();
        da.setId("1");
        da.setName("Baked Biscuits");
        da.setImagePath("https://cdn57.androidauthority.net/wp-content/uploads/2018/09/android-authority-google-pixel-3-live-wallpaper-tactile_v12_preview-1.jpg");
        data.add(da);

        da = new ProductModel();
        da.setId("1");
        da.setName("Baked Biscuits");
        da.setImagePath("https://i.pinimg.com/originals/c2/22/18/c222185e6b3b8de4e21d81872c7c9540.jpg");
        data.add(da);

        da = new ProductModel();
        da.setId("1");
        da.setName("Baked Biscuits");
        da.setImagePath("https://www.planwallpaper.com/static/images/apple-iPhone-6-Plus-wallpaper-official1_LpfwS95.jpg");
        data.add(da);

        da = new ProductModel();
        da.setId("1");
        da.setName("Baked Biscuits");
        da.setImagePath("https://i.pinimg.com/originals/dd/c5/13/ddc5138c1cb701dd4bb1a356a8b39c12.jpg");
        data.add(da);

        da = new ProductModel();
        da.setId("1");
        da.setName("Baked Biscuits");
        da.setImagePath("https://wallpaperbrowse.com/media/images/d7150a50365035e908fc375b9a65e07f.jpg");
        data.add(da);

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
