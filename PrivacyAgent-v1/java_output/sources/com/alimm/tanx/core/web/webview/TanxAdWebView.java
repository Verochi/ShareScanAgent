package com.alimm.tanx.core.web.webview;

/* loaded from: classes.dex */
public class TanxAdWebView extends android.webkit.WebView {
    private boolean clickable;
    private com.alimm.tanx.core.web.webview.OnScrollChangedCallback mOnScrollChangedCallback;

    public TanxAdWebView(android.content.Context context) {
        super(context);
        this.clickable = true;
    }

    public TanxAdWebView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clickable = true;
    }

    public TanxAdWebView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.clickable = true;
    }

    public TanxAdWebView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.clickable = true;
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        com.alimm.tanx.core.web.webview.OnScrollChangedCallback onScrollChangedCallback = this.mOnScrollChangedCallback;
        if (onScrollChangedCallback != null) {
            onScrollChangedCallback.onScroll(i, i2);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.clickable) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setOnScrollChangedCallback(com.alimm.tanx.core.web.webview.OnScrollChangedCallback onScrollChangedCallback) {
        this.mOnScrollChangedCallback = onScrollChangedCallback;
    }

    public void setWebClickable(boolean z) {
        this.clickable = z;
    }
}
