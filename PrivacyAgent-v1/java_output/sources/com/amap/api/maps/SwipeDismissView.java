package com.amap.api.maps;

@android.annotation.SuppressLint({"ViewConstructor"})
/* loaded from: classes12.dex */
public class SwipeDismissView extends android.widget.RelativeLayout {
    protected com.amap.api.maps.WearMapView.OnDismissCallback onDismissCallback;

    public SwipeDismissView(android.content.Context context, android.util.AttributeSet attributeSet, int i, android.view.View view) {
        super(context, attributeSet, i);
        this.onDismissCallback = null;
        setOnTouchListener(view);
    }

    public SwipeDismissView(android.content.Context context, android.util.AttributeSet attributeSet, android.view.View view) {
        super(context, attributeSet);
        this.onDismissCallback = null;
        setOnTouchListener(view);
    }

    public SwipeDismissView(android.content.Context context, android.view.View view) {
        super(context);
        this.onDismissCallback = null;
        setOnTouchListener(view);
    }

    public void setCallback(com.amap.api.maps.WearMapView.OnDismissCallback onDismissCallback) {
        this.onDismissCallback = onDismissCallback;
    }

    public void setOnTouchListener(android.view.View view) {
        setOnTouchListener(new com.amap.api.maps.SwipeDismissTouchListener(view, new java.lang.Object(), new com.amap.api.maps.SwipeDismissCallBack(this)));
    }
}
