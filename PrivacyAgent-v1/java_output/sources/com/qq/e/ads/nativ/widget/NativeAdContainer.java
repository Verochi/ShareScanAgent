package com.qq.e.ads.nativ.widget;

/* loaded from: classes19.dex */
public class NativeAdContainer extends android.widget.FrameLayout {
    private com.qq.e.ads.nativ.widget.ViewStatusListener a;
    private com.qq.e.ads.nativ.widget.NativeAdContainer.ViewStatus b;

    /* renamed from: com.qq.e.ads.nativ.widget.NativeAdContainer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.qq.e.ads.nativ.widget.NativeAdContainer.ViewStatus.values().length];
            a = iArr;
            try {
                iArr[1] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[2] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public enum ViewStatus {
        INIT,
        ATTACHED,
        DETACHED
    }

    public NativeAdContainer(android.content.Context context) {
        super(context);
        this.b = com.qq.e.ads.nativ.widget.NativeAdContainer.ViewStatus.INIT;
    }

    public NativeAdContainer(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = com.qq.e.ads.nativ.widget.NativeAdContainer.ViewStatus.INIT;
    }

    public NativeAdContainer(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = com.qq.e.ads.nativ.widget.NativeAdContainer.ViewStatus.INIT;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        com.qq.e.ads.nativ.widget.ViewStatusListener viewStatusListener = this.a;
        if (viewStatusListener != null) {
            viewStatusListener.onDispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.qq.e.comm.util.GDTLogger.d("NativeAdContainer onAttachedToWindow");
        this.b = com.qq.e.ads.nativ.widget.NativeAdContainer.ViewStatus.ATTACHED;
        com.qq.e.ads.nativ.widget.ViewStatusListener viewStatusListener = this.a;
        if (viewStatusListener != null) {
            viewStatusListener.onAttachToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.qq.e.comm.util.GDTLogger.d("NativeAdContainer onDetachedFromWindow");
        this.b = com.qq.e.ads.nativ.widget.NativeAdContainer.ViewStatus.DETACHED;
        com.qq.e.ads.nativ.widget.ViewStatusListener viewStatusListener = this.a;
        if (viewStatusListener != null) {
            viewStatusListener.onDetachFromWindow();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.qq.e.comm.util.GDTLogger.d("onWindowFocusChanged: hasWindowFocus: " + z);
        com.qq.e.ads.nativ.widget.ViewStatusListener viewStatusListener = this.a;
        if (viewStatusListener != null) {
            viewStatusListener.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        com.qq.e.comm.util.GDTLogger.d("onWindowVisibilityChanged: visibility: " + i);
        com.qq.e.ads.nativ.widget.ViewStatusListener viewStatusListener = this.a;
        if (viewStatusListener != null) {
            viewStatusListener.onWindowVisibilityChanged(i);
        }
    }

    public void setViewStatusListener(com.qq.e.ads.nativ.widget.ViewStatusListener viewStatusListener) {
        this.a = viewStatusListener;
        if (viewStatusListener != null) {
            int ordinal = this.b.ordinal();
            if (ordinal == 1) {
                this.a.onAttachToWindow();
            } else {
                if (ordinal != 2) {
                    return;
                }
                this.a.onDetachFromWindow();
            }
        }
    }
}
