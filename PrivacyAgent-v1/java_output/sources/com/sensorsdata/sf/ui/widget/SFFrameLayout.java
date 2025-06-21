package com.sensorsdata.sf.ui.widget;

/* loaded from: classes19.dex */
public class SFFrameLayout extends android.widget.FrameLayout {
    private boolean isInterceptTouchEvent;

    public SFFrameLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public SFFrameLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setBackgroundDrawable(null);
    }

    public SFFrameLayout(android.content.Context context, org.json.JSONObject jSONObject) {
        this(context, null, -1);
        this.isInterceptTouchEvent = jSONObject == null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.isInterceptTouchEvent) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }
}
