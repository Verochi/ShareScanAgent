package com.sensorsdata.sf.ui.widget;

/* loaded from: classes19.dex */
public class SFTextView extends android.widget.TextView {
    private boolean isInterceptTouchEvent;

    public SFTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.sensorsdata.sf.android.sdk.R.style.ViewWithScrollbars);
    }

    public SFTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setBackgroundDrawable(null);
    }

    public SFTextView(android.content.Context context, org.json.JSONObject jSONObject) {
        this(context, null, com.sensorsdata.sf.android.sdk.R.style.ViewWithScrollbars);
        setActionJson(jSONObject);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.isInterceptTouchEvent) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setActionJson(org.json.JSONObject jSONObject) {
        this.isInterceptTouchEvent = jSONObject == null;
    }
}
