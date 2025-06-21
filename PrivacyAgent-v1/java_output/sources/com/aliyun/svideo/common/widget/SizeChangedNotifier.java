package com.aliyun.svideo.common.widget;

/* loaded from: classes.dex */
public interface SizeChangedNotifier {

    public interface Listener {
        void onSizeChanged(android.view.View view, int i, int i2, int i3, int i4);
    }

    void setOnSizeChangedListener(com.aliyun.svideo.common.widget.SizeChangedNotifier.Listener listener);
}
