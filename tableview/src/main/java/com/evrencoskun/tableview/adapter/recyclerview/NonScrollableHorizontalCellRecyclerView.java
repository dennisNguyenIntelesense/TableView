package com.evrencoskun.tableview.adapter.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.recyclerview.widget.RecyclerView;

public class NonScrollableHorizontalCellRecyclerView extends CellRecyclerView {

    public NonScrollableHorizontalCellRecyclerView(Context context) {
        super(context);
    }

//    public NonScrollableHorizontalCellRecyclerView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    public NonScrollableHorizontalCellRecyclerView(Context context, AttributeSet attrs, int defStyle) {
//        super(context, attrs, defStyle);
//    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        // Intercept only horizontal scroll events
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // Store the initial touch coordinates
                mInitialX = e.getX();
                mInitialY = e.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                float dx = Math.abs(e.getX() - mInitialX);
                float dy = Math.abs(e.getY() - mInitialY);
                if (dx > dy) {
                    // Intercept horizontal scroll events
                    return true;
                }
                break;
        }
        // Do not intercept vertical scroll events
        return super.onInterceptTouchEvent(e);
    }

    private float mInitialX;
    private float mInitialY;
}