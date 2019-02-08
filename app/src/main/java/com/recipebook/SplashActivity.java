package com.recipebook;

import android.Manifest;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.recipebook.netUtils.RuntimePermissionsActivity;

public class SplashActivity extends RuntimePermissionsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SplashActivity.super.requestAppPermissions(new
                                String[]{Manifest.permission.CAMERA
                        }, R.string.runtime_permissions_txt
                        , 20);

            }
        }, 1000);


    }

    @Override
    public void onPermissionsGranted(int requestCode) {
        if (requestCode == 20) {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
			
			/*try {
                        FirebaseApp.initializeApp(LoginActivity.this);
                        FirebaseInstanceId.getInstance().getInstanceId()
                                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
// Get new Instance ID token
                                        String token = task.getResult().getToken();
// Toast.makeText(LoginActivity.this, token, Toast.LENGTH_SHORT).show();
                                    }
                                });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }*/
        }
    }
}
