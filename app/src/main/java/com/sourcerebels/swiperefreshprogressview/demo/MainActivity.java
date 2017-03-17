package com.sourcerebels.swiperefreshprogressview.demo;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.sourcerebels.swiperefreshprogressview.SwipeRefreshProgressView;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeRefreshLayout;

    private SwipeRefreshProgressView progressView;

    private boolean showError = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        progressView = (SwipeRefreshProgressView) findViewById(R.id.progress_view);

        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter();
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });

        progressView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });

        progressView.showProgress();
        refresh();
    }

    private void refresh() {
        new WaitAndHideProgressViewTask(progressView, swipeRefreshLayout, showError).execute();
        showError = !showError;
    }
}
