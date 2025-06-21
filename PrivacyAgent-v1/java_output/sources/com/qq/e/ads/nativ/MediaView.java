package com.qq.e.ads.nativ;

/* loaded from: classes19.dex */
public final class MediaView extends android.widget.FrameLayout {
    public MediaView(android.content.Context context) {
        super(context);
    }

    public MediaView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    @android.annotation.SuppressLint({"NewApi"})
    public void onAttachedToWindow() {
        com.qq.e.comm.util.GDTLogger.d("onAttachedToWindow");
        super.onAttachedToWindow();
        if (isHardwareAccelerated()) {
            return;
        }
        com.qq.e.comm.util.GDTLogger.w("硬件加速未开启");
    }
}
