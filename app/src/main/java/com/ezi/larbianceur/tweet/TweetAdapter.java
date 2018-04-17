package com.ezi.larbianceur.tweet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;



public class TweetAdapter extends ArrayAdapter<Tweet> {

    public TweetAdapter(Class<MonFragment> context , List<Tweet> tweets)
    {
        super(context,0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        if(convertView == null){convertView = LayoutInflater.from(getContext()).inflate(R.layout.tweet,parent,
                false);
        }

        TweetViewHolder viewHolder = (TweetViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new TweetViewHolder();
            viewHolder.auteur = (TextView) convertView.findViewById(R.id.auteur);
            viewHolder.tweet = (TextView) convertView.findViewById(R.id.tweet);

            convertView.setTag(viewHolder);
        }

        Tweet tweet = getItem(position);

        viewHolder.auteur.setText(tweet.getAuteur());
        viewHolder.tweet.setText(tweet.getTweet());




        return convertView;}


}
