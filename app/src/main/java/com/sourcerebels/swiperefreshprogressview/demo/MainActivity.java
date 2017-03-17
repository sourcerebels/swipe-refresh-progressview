package com.sourcerebels.swiperefreshprogressview.demo;

import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.sourcerebels.swiperefreshprogressview.SwipeRefreshProgressView;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;

    private SwipeRefreshProgressView progressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        progressView = (SwipeRefreshProgressView) findViewById(R.id.progress_view);

        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter();
        recyclerView.setAdapter(adapter);

        new WaitAndHideProgressViewTask(progressView, swipeRefreshLayout, false).execute();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new WaitAndHideProgressViewTask(progressView, swipeRefreshLayout, true).execute();
            }
        });

        progressView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new WaitAndHideProgressViewTask(progressView, swipeRefreshLayout, false).execute();
            }
        });
    }


    private static class WaitAndHideProgressViewTask extends AsyncTask<Void, Void, Void> {

        private WeakReference<SwipeRefreshProgressView> progressRef;
        private WeakReference<SwipeRefreshLayout> swipeRefreshLayoutRef;
        private boolean showError;

        WaitAndHideProgressViewTask(SwipeRefreshProgressView progressView, SwipeRefreshLayout swipeRefreshLayout, boolean showError) {
            this.progressRef = new WeakReference<>(progressView);
            this.swipeRefreshLayoutRef = new WeakReference<>(swipeRefreshLayout);
            this.showError = showError;
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                //Do nothing
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            SwipeRefreshProgressView progressView = progressRef.get();
            SwipeRefreshLayout swipeRefreshLayout = swipeRefreshLayoutRef.get();
            if (progressView != null && swipeRefreshLayout != null) {
                Log.d("MainActivity", "onPostExecute: " + showError);
                if (showError) {
                    progressView.showErrorMessage("Some error message\nPull to refresh");
                } else {
                    progressView.hide();
                }
                swipeRefreshLayout.setRefreshing(false);
            }
        }
    }
}
