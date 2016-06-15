package com.example.android.sunshine.app.recyclerItemClick;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.example.android.sunshine.app.MainActivity;

/**
 * Created by pro on 09/06/16.
 */
public class itemClick implements RecyclerView.OnItemTouchListener {

    private GestureDetector gestureDetector;
    private MainActivity.ClickListener clickListener;

    public itemClick(Context context, final RecyclerView recyclerView, final MainActivity.ClickListener clickListener){
        this.clickListener = clickListener;
        gestureDetector = new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                super.onLongPress(e);
                View view = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if(view != null && clickListener != null)
                    clickListener.onLongClick(view,recyclerView.getChildAdapterPosition(view));
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

        View view = rv.findChildViewUnder(e.getX(),e.getY());

        if(view != null && clickListener != null && gestureDetector.onTouchEvent(e))
            clickListener.onClick(view,rv.getChildAdapterPosition(view));

        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

}
