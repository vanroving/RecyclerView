package com.guoxin.recyclerviewvan;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2016/8/18.
 */
public class ItemDeco extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS = {android.R.attr.listDivider};
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;
    public static final int HORIZONTAL_LISt = LinearLayoutManager.HORIZONTAL;
    private Drawable mDivider;
    private int mOrientation;
    public ItemDeco(Context context, int orientation){
        TypedArray a = context.obtainStyledAttributes(ATTRS);
        mDivider = a.getDrawable(0);
        a.recycle();
        setOrientation(orientation);
    }

    private void setOrientation(int orientation) {
        mOrientation=orientation;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if(mOrientation==VERTICAL_LIST){
            drawVertical(c,parent);
        }else if(mOrientation==HORIZONTAL_LISt){
            drawHorizontal(c,parent);
        }
    }

    private void drawHorizontal(Canvas c, RecyclerView parent) {

    }

    private void drawVertical(Canvas c, RecyclerView parent) {
        final int left=parent.getPaddingLeft();
        final int right=parent.getWidth()-parent.getPaddingRight();
        final int count=parent.getChildCount();
        for(int i=0;i<count;i++){
           final View child= parent.getChildAt(i);
            RecyclerView.LayoutParams params=(RecyclerView.LayoutParams)child.getLayoutParams();
            int top=child.getBottom()+params.bottomMargin;
            int bottom=top+mDivider.getIntrinsicHeight();
            mDivider.setBounds(left,top,right,bottom);
            mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if(mOrientation==VERTICAL_LIST){
            outRect.set(0,0,0,mDivider.getIntrinsicHeight());
        }
    }
}
