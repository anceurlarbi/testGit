package com.ezi.larbianceur.tweet;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.twitter, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_setting:
                final Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.dialogue);
                dialog.setTitle("Création");
                Button btnValider = (Button)
                        dialog.findViewById(R.id.dialog_btn_valider);
                dialog.show();
                btnValider.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View v) {
                        Dialog f = (Dialog) dialog;
                        ListView mListView = (ListView) findViewById(R.id.list);
                        EditText tweet = (EditText) f.findViewById(R.id.dialog_libelle) ;
                        List<Tweet> tweets = new ArrayList<Tweet>();
                        TweetAdapter adapter =(TweetAdapter) mListView.getAdapter();
                        adapter.add(new Tweet("Larbi",tweet.getText().toString()));
                        dialog.dismiss();



                    }
                });
                return true;

            default: return super.onOptionsItemSelected(item);
        }


}}
