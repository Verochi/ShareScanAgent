package com.anythink.expressad.video.dynview.widget;

/* loaded from: classes12.dex */
public class ObservableScrollView extends android.widget.HorizontalScrollView {
    private com.anythink.expressad.video.dynview.widget.a a;

    public ObservableScrollView(android.content.Context context) {
        super(context);
        this.a = null;
    }

    public ObservableScrollView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
    }

    public ObservableScrollView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
    }

    @Override // android.widget.HorizontalScrollView
    public void fling(int i) {
        super.fling(i / 4);
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }
}
