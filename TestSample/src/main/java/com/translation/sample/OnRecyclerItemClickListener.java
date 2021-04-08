package com.translation.sample;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;

/**
 * author:       JiaoWenZheng
 * created time: 2018/12/12 10:35
 * description:
 */
public abstract class OnRecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
    private GestureDetectorCompat mGestureDetectorCompat;
    private RecyclerView mRecyclerView;

    public OnRecyclerItemClickListener(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        mGestureDetectorCompat = new GestureDetectorCompat(recyclerView.getContext(),new ItemGestureDetectorListener());
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        mGestureDetectorCompat.onTouchEvent(e);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        mGestureDetectorCompat.onTouchEvent(e);
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    private class ItemGestureDetectorListener extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            View childView = mRecyclerView.findChildViewUnder(e.getX(),e.getY());

            if (childView != null){
                int position = mRecyclerView.getChildLayoutPosition(childView);
                RecyclerView.ViewHolder vh = mRecyclerView.getChildViewHolder(childView);
                onItemClick(vh,position);
                return true;
            }
            return super.onSingleTapUp(e);
        }
    }

    public abstract void onItemClick(RecyclerView.ViewHolder viewHolder, int position);
}
