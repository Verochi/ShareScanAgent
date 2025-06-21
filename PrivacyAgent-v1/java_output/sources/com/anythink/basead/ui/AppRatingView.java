package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class AppRatingView extends android.widget.LinearLayout {
    private android.content.Context a;
    private java.util.List<com.anythink.basead.ui.StarLevelView> b;
    private int c;
    private int d;

    public AppRatingView(android.content.Context context) {
        this(context, null, 0);
    }

    public AppRatingView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppRatingView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        setStarSizeInDp(17);
        setStarMargin(8);
    }

    public static int dip2px(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setRating(int i) {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            com.anythink.basead.ui.StarLevelView starLevelView = this.b.get(i2);
            if (i2 < i) {
                starLevelView.setState(true);
            } else {
                starLevelView.setState(false);
            }
        }
    }

    public void setStarMargin(int i) {
        this.d = i;
    }

    public void setStarNum(int i) {
        if (this.b == null) {
            this.b = new java.util.ArrayList();
        }
        this.b.clear();
        removeAllViews();
        setOrientation(0);
        for (int i2 = 0; i2 < i; i2++) {
            com.anythink.basead.ui.StarLevelView starLevelView = new com.anythink.basead.ui.StarLevelView(getContext());
            int i3 = this.c;
            android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(i3, i3);
            if (i2 != i - 1) {
                layoutParams.setMargins(0, 0, dip2px(getContext(), this.d), 0);
            }
            starLevelView.setLayoutParams(layoutParams);
            addView(starLevelView);
            this.b.add(starLevelView);
        }
    }

    public void setStarSizeInDp(int i) {
        this.c = dip2px(this.a, i);
    }
}
