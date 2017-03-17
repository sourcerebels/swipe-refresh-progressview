package com.sourcerebels.swiperefreshprogressview.demo;

import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;

import com.sourcerebels.swiperefreshprogressview.SwipeRefreshProgressView;

import java.lang.ref.WeakReference;

class WaitAndHideProgressViewTask extends AsyncTask<Void, Void, Void> {

    private final WeakReference<SwipeRefreshProgressView> progressRef;
    private final WeakReference<SwipeRefreshLayout> swipeRefreshLayoutRef;
    private final boolean showError;

    WaitAndHideProgressViewTask(SwipeRefreshProgressView progressView,
                                SwipeRefreshLayout swipeRefreshLayout, boolean showError) {
        this.progressRef = new WeakReference<>(progressView);
        this.swipeRefreshLayoutRef = new WeakReference<>(swipeRefreshLayout);
        this.showError = showError;
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            Thread.sleep(2000);
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
                progressView.showErrorMessage(
                        progressView.getContext().getString(R.string.error_message));
            } else {
                progressView.hide();
            }
            swipeRefreshLayout.setRefreshing(false);
        }
    }
}
