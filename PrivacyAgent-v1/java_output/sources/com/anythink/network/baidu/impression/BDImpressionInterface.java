package com.anythink.network.baidu.impression;

/* loaded from: classes12.dex */
public interface BDImpressionInterface {
    int getImpressionMinPercentageViewed();

    int getImpressionMinTimeViewed();

    java.lang.Integer getImpressionMinVisiblePx();

    boolean isImpressionRecorded();

    void recordImpression(android.view.View view);

    void setImpressionRecorded();
}
