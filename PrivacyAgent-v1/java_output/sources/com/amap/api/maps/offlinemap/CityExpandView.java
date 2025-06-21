package com.amap.api.maps.offlinemap;

/* loaded from: classes12.dex */
public class CityExpandView extends android.widget.ExpandableListView {
    public CityExpandView(android.content.Context context) {
        this(context, null);
    }

    public CityExpandView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet, -1);
        setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        java.lang.System.currentTimeMillis();
        super.onMeasure(i, android.view.View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        java.lang.System.currentTimeMillis();
    }
}
