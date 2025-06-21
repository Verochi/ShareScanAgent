package com.aliyun.svideo.editor.effects.caption.adapter;

/* loaded from: classes12.dex */
public class CaptionColorAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener mOnCaptionColorItemClickListener;
    private int model;
    private int mCurrentSelectIndex = -1;
    private java.util.List<java.lang.Integer> mColorList = new java.util.ArrayList();

    /* renamed from: com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        final /* synthetic */ int val$finalPosition;
        final /* synthetic */ java.lang.Integer val$intColor;

        public AnonymousClass1(int i, java.lang.Integer num) {
            this.val$finalPosition = i;
            this.val$intColor = num;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter.this.notifySelectedView(this.val$finalPosition) && com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter.this.mOnCaptionColorItemClickListener != null) {
                com.aliyun.svideosdk.common.AliyunColor aliyunColor = new com.aliyun.svideosdk.common.AliyunColor(this.val$intColor.intValue());
                if (com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter.this.model == 0) {
                    com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter.this.mOnCaptionColorItemClickListener.onCaptionTextColorChanged(aliyunColor);
                } else if (com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter.this.model == 1) {
                    com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter.this.mOnCaptionColorItemClickListener.onCaptionTextStrokeColorChanged(aliyunColor);
                } else if (com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter.this.model == 2) {
                    com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter.this.mOnCaptionColorItemClickListener.onCaptionTextShandowColorChanged(aliyunColor);
                } else if (com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter.this.model == 3) {
                    com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter.this.mOnCaptionColorItemClickListener.onCaptionTextBackgroundColorChanged(aliyunColor);
                }
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static class ColorViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public android.view.View colorView;
        public android.view.View selectedView;

        public ColorViewHolder(android.view.View view) {
            super(view);
            this.colorView = view.findViewById(com.aliyun.svideo.editor.R.id.paint_color_view);
            this.selectedView = view.findViewById(com.aliyun.svideo.editor.R.id.selected_view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean notifySelectedView(int i) {
        int i2 = this.mCurrentSelectIndex;
        if (i == i2) {
            return false;
        }
        this.mCurrentSelectIndex = i;
        notifyItemChanged(i2);
        notifyItemChanged(this.mCurrentSelectIndex);
        return true;
    }

    public java.util.List<java.lang.Integer> getData() {
        return this.mColorList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        java.util.List<java.lang.Integer> list = this.mColorList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter.ColorViewHolder colorViewHolder = (com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter.ColorViewHolder) viewHolder;
        int adapterPosition = viewHolder.getAdapterPosition();
        if (adapterPosition == this.mCurrentSelectIndex) {
            colorViewHolder.selectedView.setVisibility(0);
        } else {
            colorViewHolder.selectedView.setVisibility(8);
        }
        java.lang.Integer num = this.mColorList.get(adapterPosition);
        colorViewHolder.colorView.setBackgroundColor(num.intValue());
        colorViewHolder.colorView.setOnClickListener(new com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter.AnonymousClass1(adapterPosition, num));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.aliyun.svideo.editor.effects.caption.adapter.CaptionColorAdapter.ColorViewHolder(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.aliyun.svideo.editor.R.layout.alivc_editor_caption_item_color, viewGroup, false));
    }

    public void setColorList(java.util.List<java.lang.Integer> list) {
        this.mColorList = list;
        notifyDataSetChanged();
    }

    public void setModel(int i) {
        this.model = i;
    }

    public void setOnCaptionColorItemClickListener(com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener onCaptionChooserStateChangeListener) {
        this.mOnCaptionColorItemClickListener = onCaptionChooserStateChangeListener;
    }

    public void setSelectPosition(int i) {
        notifySelectedView(i);
    }
}
