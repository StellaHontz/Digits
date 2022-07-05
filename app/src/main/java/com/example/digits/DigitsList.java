
package com.example.digits;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;

import java.util.ArrayList;
import java.util.Locale;

public class DigitsList extends AppCompatActivity {

    LinearLayoutManager linearLayoutManager;
    Digits_Adapter digits_adapter;
    ArrayList<String> digits_list;
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digits_list);
        textToSpeech =new TextToSpeech(this, i -> {
            if(i==TextToSpeech.SUCCESS){
                textToSpeech.setLanguage(Locale.getDefault());
            }

        });

        RecyclerView recyclerView= findViewById(R.id.recyclerView);
        linearLayoutManager=new LinearLayoutManager(this);
        digits_list = new ArrayList<>();
        digits_list.add(getString(R.string.zero));
        digits_list.add(getString(R.string.one));
        digits_list.add(getString(R.string.two));
        digits_list.add(getString(R.string.three));
        digits_list.add(getString(R.string.four));
        digits_list.add(getString(R.string.five));
        digits_list.add(getString(R.string.six));
        digits_list.add(getString(R.string.seven));
        digits_list.add(getString(R.string.eight));
        digits_list.add(getString(R.string.nine));

        digits_adapter=new Digits_Adapter(digits_list,this,textToSpeech);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(digits_adapter);

    }

    @Override
    protected void onDestroy() {
        if(textToSpeech!=null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }
}