package com.example.android.miwok;

/**
 * Created by inco on 2017/2/12.
 */

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * this adapter is for the Word class
 *
 */
public class WordAdapter extends ArrayAdapter<Word>{
    private int mColor = -1;
    public WordAdapter(Activity context, ArrayList<Word> arrayList){
        super(context, 0, arrayList);
    }

    public WordAdapter(Activity context, ArrayList<Word> arrayList, int color){
        super(context, 0, arrayList);
        this.mColor = color;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.words_and_img, parent, false);
        }


        Word word = getItem(position);
        if(mColor != -1)
        {
            int color = ContextCompat.getColor(getContext(), mColor);
            LinearLayout bac = (LinearLayout) listItemView.findViewById(R.id.background_set);
            bac.setBackgroundColor(color);
        }
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.img);
        if(word.isSetImg()) {
            imageView.setImageResource(word.getmImg());
            imageView.setVisibility(View.VISIBLE);
        }
        else
        {
            imageView.setVisibility(View.GONE);
        }
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_word);
        defaultTextView.setText(word.getDefaultWord());

        TextView miworkView = (TextView) listItemView.findViewById(R.id.Miwork_word);
        miworkView.setText(word.getMiworkWord());


        return listItemView;
    }
}
