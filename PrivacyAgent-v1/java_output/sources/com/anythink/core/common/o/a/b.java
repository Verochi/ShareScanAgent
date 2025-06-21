package com.anythink.core.common.o.a;

/* loaded from: classes12.dex */
public interface b {
    int getImpressionMinPercentageViewed();

    int getImpressionMinTimeViewed();

    java.lang.Integer getImpressionMinVisiblePx();

    boolean isImpressionRecorded();

    void recordImpression(android.view.View view);

    void setImpressionRecorded();
}
