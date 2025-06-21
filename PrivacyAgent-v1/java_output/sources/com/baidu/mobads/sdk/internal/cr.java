package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class cr extends android.widget.RelativeLayout {
    public static final java.lang.String a = "ContainerView";
    private com.baidu.mobads.sdk.internal.cr.a b;

    public interface a {
        void dispatchTouchEvent(android.view.MotionEvent motionEvent);

        void onAttachedToWindow();

        @android.annotation.SuppressLint({"MissingSuperCall"})
        void onDetachedFromWindow();

        boolean onKeyDown(int i, android.view.KeyEvent keyEvent);

        void onLayoutComplete(int i, int i2);

        void onWindowFocusChanged(boolean z);

        void onWindowVisibilityChanged(int i);
    }

    public cr(android.content.Context context) {
        super(context);
    }

    public void a(com.baidu.mobads.sdk.internal.cr.a aVar) {
        this.b = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        com.baidu.mobads.sdk.internal.cr.a aVar = this.b;
        if (aVar != null) {
            aVar.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.baidu.mobads.sdk.internal.cr.a aVar = this.b;
        if (aVar != null) {
            aVar.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.mobads.sdk.internal.cr.a aVar = this.b;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        com.baidu.mobads.sdk.internal.cr.a aVar = this.b;
        if (aVar != null) {
            return aVar.onKeyDown(i, keyEvent);
        }
        super.onKeyDown(i, keyEvent);
        return false;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.baidu.mobads.sdk.internal.cr.a aVar;
        super.onLayout(z, i, i2, i3, i4);
        if (!z || (aVar = this.b) == null) {
            return;
        }
        aVar.onLayoutComplete(getWidth(), getHeight());
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.baidu.mobads.sdk.internal.cr.a aVar = this.b;
        if (aVar != null) {
            aVar.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        com.baidu.mobads.sdk.internal.cr.a aVar = this.b;
        if (aVar != null) {
            aVar.onWindowVisibilityChanged(i);
        }
    }
}
