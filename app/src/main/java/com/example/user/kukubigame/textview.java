package com.example.user.kukubigame;

import android.content.Context;
import android.util.AttributeSet;

public class textview extends android.support.v7.widget.AppCompatTextView {

    public textview(Context context) {
        super(context);
    }

    public textview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public textview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int dai = getMeasuredWidth();
        setMeasuredDimension(dai,dai);
    }
}
