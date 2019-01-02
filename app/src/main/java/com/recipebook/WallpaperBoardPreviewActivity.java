package com.recipebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.chrisbanes.photoview.PhotoView;
import com.kogitune.activitytransition.ActivityTransition;
import com.kogitune.activitytransition.ExitActivityTransition;

public class WallpaperBoardPreviewActivity extends AppCompatActivity {

    PhotoView wallpaper;
    String url="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper_board_preview);
        wallpaper = (PhotoView) findViewById(R.id.wallpaper);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            url = bundle.getString("url");
        }

        ExitActivityTransition mExitTransition = ActivityTransition
                .with(getIntent())
                .to(this, wallpaper, "image")
                .duration(300)
                .start(savedInstanceState);

    }
}
