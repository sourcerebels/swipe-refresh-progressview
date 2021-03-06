package com.sourcerebels.swiperefreshprogressview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.TextViewCompat;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SwipeRefreshProgressView extends RelativeLayout {

    private ProgressBar progressBar;

    private SwipeRefreshLayout swipeRefreshError;

    private TextView errorMessage;

    public SwipeRefreshProgressView(Context context) {
        super(context);
        initialize(context, null);
    }

    public SwipeRefreshProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context, attrs);
    }

    public void hide() {
        swipeRefreshError.setRefreshing(false);
        setVisibility(GONE);
    }

    public void showProgress() {
        if (swipeRefreshError.getVisibility() == VISIBLE) {
            swipeRefreshError.setRefreshing(true);
        }
        //By default progress bar is showing. And it will show only first time.
    }

    public void showErrorMessage(CharSequence message) {
        swipeRefreshError.setRefreshing(false);
        setVisibility(VISIBLE);
        errorMessage.setText(message);
        swipeRefreshError.setVisibility(VISIBLE);
        progressBar.setVisibility(GONE);
    }

    public void setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener listener) {
        swipeRefreshError.setOnRefreshListener(listener);
    }

    public void setColorSchemeResources(int... colorResId) {
        swipeRefreshError.setColorSchemeResources(colorResId);
    }

    private void initialize(Context context, AttributeSet attrs) {
        inflate(context, R.layout.view_swipe_refresh_progress, this);
        progressBar = (ProgressBar) findViewById(R.id.srp_progress_bar);
        swipeRefreshError = (SwipeRefreshLayout) findViewById(R.id.srp_swipe_refresh_error);
        swipeRefreshError.setVisibility(GONE);
        errorMessage = (TextView) findViewById(R.id.srp_error_message);

        if (attrs == null) {
            return;
        }

        final int[] styleable = new int[]{
                android.R.attr.textAppearance
        };

        TypedArray a = context.obtainStyledAttributes(attrs, styleable);
        try {
            for (int attrIndex = 0; attrIndex < styleable.length; attrIndex++) {
                int attribute = styleable[attrIndex];
                switch (attribute) {
                    case android.R.attr.textAppearance:
                        TextViewCompat.setTextAppearance(errorMessage,
                                a.getResourceId(attrIndex, 0));
                        break;
                }

            }
        } finally {
            a.recycle();
        }
    }
}

