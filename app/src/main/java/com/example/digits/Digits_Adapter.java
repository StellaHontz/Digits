package com.example.digits;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Digits_Adapter extends RecyclerView.Adapter<Digits_Adapter.DigitViewHolder> {
    ArrayList<String> digits_list;
    Context context;
    TextToSpeech textToSpeech;

    public Digits_Adapter(ArrayList<String> digits_list,Context context,TextToSpeech textToSpeech){
        this.digits_list=digits_list;
        this.context=context;
        this.textToSpeech=textToSpeech;
    }
    public class DigitViewHolder extends RecyclerView.ViewHolder{
        ImageView button;
        TextView digit_text;

        public DigitViewHolder(View itemView) {
            super(itemView);
            button = (ImageView) itemView.findViewById(R.id.playbutton);
            digit_text = (TextView) itemView.findViewById(R.id.digittext);
        }
    }

    @NonNull
    @Override
    public DigitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).
                inflate(R.layout.digit_cards, parent, false);
        DigitViewHolder viewHolder= new DigitViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DigitViewHolder holder, int position) {
        holder.digit_text.setText(digits_list.get(position));
        holder.button.setOnClickListener(v->{
            textToSpeech.speak(String.valueOf(digits_list.get(position)),TextToSpeech.QUEUE_FLUSH,null,"id");
        });
    }

    @Override
    public int getItemCount() {
        return digits_list.size();
    }


}
