package com.translation.sample.recycler;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.translation.sample.R;

import java.util.List;

class VerticalAdapter extends BaseQuickAdapter<Entity, BaseViewHolder> {

    public VerticalAdapter(int layoutResId, @Nullable List<Entity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Entity item) {

        helper.setText(R.id.tv_label, item.title);

        RecyclerView recyclerView = helper.getView(R.id.recycler_view);
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(mContext,FlexDirection.ROW, FlexWrap.WRAP){
            @Override
            public void onMeasure(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, int widthSpec, int heightSpec) {
                super.onMeasure(recycler, state, widthSpec, heightSpec);
                Log.i("jiao","onMeasure widthSpec="+widthSpec+" heightSpec="+heightSpec);


            }
        };
        flexboxLayoutManager.setAlignItems(AlignItems.CENTER);
        flexboxLayoutManager.setJustifyContent(JustifyContent.FLEX_START);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(flexboxLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(new LabelAdapter(R.layout.item_label_children_checked,item.innerEntities));


    }

    private class LabelAdapter extends BaseQuickAdapter<Entity.InnerEntity,BaseViewHolder>{

        private int radius;

        public LabelAdapter(int layoutResId, @Nullable List<Entity.InnerEntity> data) {
            super(layoutResId, data);
            this.radius = 18;
        }

        @Override
        protected void convert(BaseViewHolder helper, Entity.InnerEntity item) {
            TextView labelTv = helper.getView(R.id.tv_label);
            labelTv.setText(item.innerTitle);

            GradientDrawable drawable = new GradientDrawable();
            drawable.setStroke(3, Color.BLACK);
            drawable.setCornerRadius(radius);
            labelTv.setBackground(drawable);
        }
    }

}
