package com.sourcerebels.swiperefreshprogressview;

import android.content.Context;
import android.support.annotation.StringRes;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SwipeRefreshProgressView extends RelativeLayout {

    private static final String TAG = "SwipeRefreshPV";

    private ProgressBar progressBar;

    private SwipeRefreshLayout swipeRefreshError;

    private TextView errorMessage;

    public SwipeRefreshProgressView(Context context) {
        super(context);
        initialize(context);
    }

    public SwipeRefreshProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public void hide() {
        swipeRefreshError.setRefreshing(false);
        setVisibility(GONE);
    }

    public void show() {
        swipeRefreshError.setRefreshing(false);
        setVisibility(VISIBLE);
    }

    public void showProgress() {
        show();
        progressBar.setVisibility(VISIBLE);
        swipeRefreshError.setVisibility(GONE);
    }

    public void showErrorMessage(@StringRes int message) {
        errorMessage.setText(message);
        show();
        swipeRefreshError.setVisibility(VISIBLE);
        swipeRefreshError.setRefreshing(false);
        progressBar.setVisibility(GONE);
    }

    public void setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener listener) {
        Log.d(TAG, "setOnRefreshListener: initializing refresh listener");
        swipeRefreshError.setOnRefreshListener(listener);
    }

    private void initialize(Context context) {
        Log.d(TAG, "initialize");
        inflate(context, R.layout.view_swipe_refresh_progress, this);
        progressBar = (ProgressBar) findViewById(R.id.srp_progress_bar);
        swipeRefreshError = (SwipeRefreshLayout) findViewById(R.id.srp_swipe_refresh_error);
        errorMessage = (TextView) findViewById(R.id.srp_error_message);
    }
}

