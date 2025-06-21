package com.anythink.network.baidu.impression;

/* loaded from: classes12.dex */
public abstract class BDImpressionController implements com.anythink.network.baidu.impression.BDImpressionInterface {
    private static final int a = 0;
    private static final int b = 50;
    private boolean c;
    private int d = 0;
    private int e = 50;
    private java.lang.Integer f = null;

    @Override // com.anythink.network.baidu.impression.BDImpressionInterface
    public final int getImpressionMinPercentageViewed() {
        return this.e;
    }

    @Override // com.anythink.network.baidu.impression.BDImpressionInterface
    public final int getImpressionMinTimeViewed() {
        return this.d;
    }

    @Override // com.anythink.network.baidu.impression.BDImpressionInterface
    public final java.lang.Integer getImpressionMinVisiblePx() {
        return this.f;
    }

    @Override // com.anythink.network.baidu.impression.BDImpressionInterface
    public final boolean isImpressionRecorded() {
        return this.c;
    }

    @Override // com.anythink.network.baidu.impression.BDImpressionInterface
    public abstract void recordImpression(android.view.View view);

    @Override // com.anythink.network.baidu.impression.BDImpressionInterface
    public final void setImpressionRecorded() {
        this.c = true;
    }
}
