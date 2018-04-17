package com.ezi.larbianceur.tweet;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Larbi Anceur on 17-Apr-18.
 */

public class MonFragment extends Fragment {
    public MonFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup
            container, Bundle savedInstanceState)
    { ListView mListView =  getActivity().findViewById(R.id.list);;
        List<Tweet> tweets = new ArrayList<Tweet>();

        tweets.add(new Tweet("Larbi","Hello there !!!!"));



        final TweetAdapter adapter = new TweetAdapter(getActivity().getClass(),tweets);

        mListView.setAdapter(adapter);
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                showDial(i,adapter);
                return false;
            }
        });

        return inflater.inflate(R.layout.monfragment,
            container,false);}






    public void showDial(final int i, final TweetAdapter adapter){
        AlertDialog.Builder confirm = new AlertDialog.Builder(getActivity());
        confirm.setTitle("Suppression");
        confirm.setIcon(android.R.drawable.ic_dialog_alert);
        confirm.setMessage("Vous confirmez la suppression ?");

        confirm.setPositiveButton(android.R.string.yes,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int idBtn) {
                        adapter.remove(adapter.getItem(i));
                    }
                });
        confirm.setNegativeButton(android.R.string.no, null);
        confirm.show();
    }


}



