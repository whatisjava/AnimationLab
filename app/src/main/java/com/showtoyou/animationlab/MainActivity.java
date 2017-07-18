package com.showtoyou.animationlab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView mListView;
    private MainAdapter mMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        mListView = (ListView) findViewById(R.id.list_view);
        mMainAdapter = new MainAdapter(this);
        mListView.setAdapter(mMainAdapter);
        mListView.setOnItemClickListener(this);
        assign();
    }

    private void assign() {
        ArrayList<String> items = new ArrayList<String>();

        items.add("PropertyAnimation Test");
        items.add("ViewAnimation Test");
        items.add("DrawableAnimation Test");

        mMainAdapter.assign(items);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                startActivity(new Intent(this, PropertyAnimationActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, ViewAnimationActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, DrawableAnimationActivity.class));
                break;
            default:
                break;
        }
    }

}
