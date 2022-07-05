package com.example.digits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView= findViewById(R.id.imageView);
        anim= AnimationUtils.loadAnimation(this, R.anim.grow_from_center);
        imageView.setAnimation(anim);
        Intent intent=new Intent(this,DigitsList.class);

        //redirect with delay
        final Handler handler = new Handler();
        handler.postDelayed(() -> {
            // Do something after 3s = 3000ms
            startActivity(intent);
            this.finish();
        }, 2500);


    }
}