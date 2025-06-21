package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class AppRatingSmallSizeView extends com.anythink.basead.ui.AppRatingView {
    public AppRatingSmallSizeView(android.content.Context context) {
        this(context, null, 0);
    }

    public AppRatingSmallSizeView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppRatingSmallSizeView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setStarSizeInDp(13);
        setStarMargin(4);
    }
}
