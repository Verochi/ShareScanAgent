package com.aliyun.svideo.common.baseAdapter.provider;

/* loaded from: classes.dex */
public abstract class BaseItemProvider<T, V extends com.aliyun.svideo.common.baseAdapter.BaseViewHolder> {
    public android.content.Context mContext;
    public java.util.List<T> mData;

    public abstract void convert(V v, T t, int i);

    public abstract int layout();

    public void onClick(V v, T t, int i) {
    }

    public boolean onLongClick(V v, T t, int i) {
        return false;
    }

    public abstract int viewType();
}
