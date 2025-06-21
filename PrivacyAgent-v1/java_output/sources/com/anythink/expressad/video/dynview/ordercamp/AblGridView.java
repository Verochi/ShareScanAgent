package com.anythink.expressad.video.dynview.ordercamp;

/* loaded from: classes12.dex */
public class AblGridView extends android.widget.GridView {
    public AblGridView(android.content.Context context) {
        super(context);
    }

    public AblGridView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AblGridView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, android.view.View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
