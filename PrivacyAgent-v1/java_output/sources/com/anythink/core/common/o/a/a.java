package com.anythink.core.common.o.a;

/* loaded from: classes12.dex */
public abstract class a implements com.anythink.core.common.o.a.b {
    private static final int DEFAULT_IMPRESSION_MIN_PERCENTAGE_VIEWED = 50;
    private static final int DEFAULT_IMPRESSION_MIN_TIME_VIEWED_MS = 500;
    private boolean mImpressionRecorded;
    private int mImpressionMinTimeViewed = 500;
    private int mImpressionMinPercentageViewed = 50;
    private java.lang.Integer mImpressionMinVisiblePx = null;

    @Override // com.anythink.core.common.o.a.b
    public int getImpressionMinPercentageViewed() {
        return this.mImpressionMinPercentageViewed;
    }

    @Override // com.anythink.core.common.o.a.b
    public int getImpressionMinTimeViewed() {
        return this.mImpressionMinTimeViewed;
    }

    @Override // com.anythink.core.common.o.a.b
    public final java.lang.Integer getImpressionMinVisiblePx() {
        return this.mImpressionMinVisiblePx;
    }

    @Override // com.anythink.core.common.o.a.b
    public final boolean isImpressionRecorded() {
        return this.mImpressionRecorded;
    }

    @Override // com.anythink.core.common.o.a.b
    public abstract void recordImpression(android.view.View view);

    @Override // com.anythink.core.common.o.a.b
    public final void setImpressionRecorded() {
        this.mImpressionRecorded = true;
    }
}
