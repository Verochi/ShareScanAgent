package com.anythink.core.api;

/* loaded from: classes12.dex */
public class ATCustomAdapterConfig {
    private long adCacheTime;
    private int lossNoticePosition;
    private boolean realTimeBidSwitch;

    public static class Builder {
        private boolean realTimeBidSwitch = false;
        private long adCacheTime = 1800000;
        private int lossNoticePosition = -1;

        public com.anythink.core.api.ATCustomAdapterConfig.Builder adCacheTime(long j) {
            this.adCacheTime = j;
            return this;
        }

        public com.anythink.core.api.ATCustomAdapterConfig build() {
            com.anythink.core.api.ATCustomAdapterConfig aTCustomAdapterConfig = new com.anythink.core.api.ATCustomAdapterConfig(null);
            aTCustomAdapterConfig.realTimeBidSwitch = this.realTimeBidSwitch;
            aTCustomAdapterConfig.adCacheTime = this.adCacheTime;
            aTCustomAdapterConfig.lossNoticePosition = this.lossNoticePosition;
            return aTCustomAdapterConfig;
        }

        public com.anythink.core.api.ATCustomAdapterConfig.Builder lossNoticePosition(int i) {
            this.lossNoticePosition = i;
            return this;
        }

        public com.anythink.core.api.ATCustomAdapterConfig.Builder realTimeBidSwitch(boolean z) {
            this.realTimeBidSwitch = z;
            return this;
        }
    }

    private ATCustomAdapterConfig() {
    }

    public /* synthetic */ ATCustomAdapterConfig(com.anythink.core.api.ATCustomAdapterConfig.AnonymousClass1 anonymousClass1) {
        this();
    }

    public long getAdCacheTime() {
        return this.adCacheTime;
    }

    public int getLossNoticePostion() {
        return this.lossNoticePosition;
    }

    public boolean isRealTimeBidSwitch() {
        return this.realTimeBidSwitch;
    }
}
