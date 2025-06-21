package com.aliyun.svideo.common.baseAdapter.utils;

/* loaded from: classes.dex */
public abstract class MultiTypeDelegate<T> {
    private static final int DEFAULT_VIEW_TYPE = -255;
    private boolean autoMode;
    private android.util.SparseIntArray layouts;
    private boolean selfMode;

    public MultiTypeDelegate() {
    }

    public MultiTypeDelegate(android.util.SparseIntArray sparseIntArray) {
        this.layouts = sparseIntArray;
    }

    private void addItemType(int i, @androidx.annotation.LayoutRes int i2) {
        if (this.layouts == null) {
            this.layouts = new android.util.SparseIntArray();
        }
        this.layouts.put(i, i2);
    }

    private void checkMode(boolean z) {
        if (z) {
            throw new java.lang.IllegalArgumentException("Don't mess two register mode");
        }
    }

    public final int getDefItemViewType(java.util.List<T> list, int i) {
        T t = list.get(i);
        return t != null ? getItemType(t) : DEFAULT_VIEW_TYPE;
    }

    public abstract int getItemType(T t);

    public final int getLayoutId(int i) {
        return this.layouts.get(i, com.aliyun.svideo.common.baseAdapter.delegate.MultiTypeDelegate.TYPE_NOT_FOUND);
    }

    public com.aliyun.svideo.common.baseAdapter.utils.MultiTypeDelegate registerItemType(int i, @androidx.annotation.LayoutRes int i2) {
        this.selfMode = true;
        checkMode(this.autoMode);
        addItemType(i, i2);
        return this;
    }

    public com.aliyun.svideo.common.baseAdapter.utils.MultiTypeDelegate registerItemTypeAutoIncrease(@androidx.annotation.LayoutRes int... iArr) {
        this.autoMode = true;
        checkMode(this.selfMode);
        for (int i = 0; i < iArr.length; i++) {
            addItemType(i, iArr[i]);
        }
        return this;
    }
}
