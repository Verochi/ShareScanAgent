package com.qq.e.ads.nativ.widget;

/* loaded from: classes19.dex */
public interface ViewStatusListener {
    void onAttachToWindow();

    void onDetachFromWindow();

    void onDispatchTouchEvent(android.view.MotionEvent motionEvent);

    void onWindowFocusChanged(boolean z);

    void onWindowVisibilityChanged(int i);
}
