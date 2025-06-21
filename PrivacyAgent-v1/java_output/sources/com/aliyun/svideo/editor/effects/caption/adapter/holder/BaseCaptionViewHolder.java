package com.aliyun.svideo.editor.effects.caption.adapter.holder;

/* loaded from: classes12.dex */
public abstract class BaseCaptionViewHolder {
    private final android.content.Context mContext;
    private android.view.View mItemView;
    private com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener mOnCaptionChooserStateChangeListener;
    private java.lang.String mTitle;

    public BaseCaptionViewHolder(android.content.Context context, java.lang.String str, com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener onCaptionChooserStateChangeListener) {
        this.mContext = context;
        this.mTitle = str;
        this.mOnCaptionChooserStateChangeListener = onCaptionChooserStateChangeListener;
        this.mItemView = onCreateView(context);
    }

    public com.aliyun.svideo.editor.effects.caption.listener.OnCaptionChooserStateChangeListener getCaptionChooserStateChangeListener() {
        return this.mOnCaptionChooserStateChangeListener;
    }

    public android.content.Context getContext() {
        return this.mContext;
    }

    public android.view.View getItemView() {
        return this.mItemView;
    }

    public java.lang.String getTitle() {
        return this.mTitle;
    }

    public void notifyDataSetChanged() {
    }

    public abstract void onBindViewHolder();

    public abstract android.view.View onCreateView(android.content.Context context);

    public void onTabClick() {
    }

    public void resourceChanged() {
    }
}
