package com.anythink.core.api;

/* loaded from: classes12.dex */
public class ATSharedPlacementConfig {
    java.util.Map<java.lang.String, java.lang.Object> bannerLocalExtra;
    java.util.Map<java.lang.String, java.lang.Object> interstitialLocalExtra;
    java.util.Map<java.lang.String, java.lang.Object> nativeLocalExtra;
    java.util.Map<java.lang.String, java.lang.Object> rewardVideoLocalExtra;
    java.util.Map<java.lang.String, java.lang.Object> splashLocalExtra;

    public static class Builder {
        java.util.Map<java.lang.String, java.lang.Object> bannerLocalExtra;
        java.util.Map<java.lang.String, java.lang.Object> interstitialLocalExtra;
        java.util.Map<java.lang.String, java.lang.Object> nativeLocalExtra;
        java.util.Map<java.lang.String, java.lang.Object> rewardVideoLocalExtra;
        java.util.Map<java.lang.String, java.lang.Object> splashLocalExtra;

        public com.anythink.core.api.ATSharedPlacementConfig.Builder bannerLocalExtra(java.util.Map<java.lang.String, java.lang.Object> map) {
            this.bannerLocalExtra = map;
            return this;
        }

        public com.anythink.core.api.ATSharedPlacementConfig build() {
            return new com.anythink.core.api.ATSharedPlacementConfig(this, null);
        }

        public com.anythink.core.api.ATSharedPlacementConfig.Builder interstitialLocalExtra(java.util.Map<java.lang.String, java.lang.Object> map) {
            this.interstitialLocalExtra = map;
            return this;
        }

        public com.anythink.core.api.ATSharedPlacementConfig.Builder nativeLocalExtra(java.util.Map<java.lang.String, java.lang.Object> map) {
            this.nativeLocalExtra = map;
            return this;
        }

        public com.anythink.core.api.ATSharedPlacementConfig.Builder rewardVideoLocalExtra(java.util.Map<java.lang.String, java.lang.Object> map) {
            this.rewardVideoLocalExtra = map;
            return this;
        }

        public com.anythink.core.api.ATSharedPlacementConfig.Builder splashLocalExtra(java.util.Map<java.lang.String, java.lang.Object> map) {
            this.splashLocalExtra = map;
            return this;
        }
    }

    private ATSharedPlacementConfig(com.anythink.core.api.ATSharedPlacementConfig.Builder builder) {
        this.rewardVideoLocalExtra = builder.rewardVideoLocalExtra;
        this.interstitialLocalExtra = builder.interstitialLocalExtra;
        this.splashLocalExtra = builder.splashLocalExtra;
        this.bannerLocalExtra = builder.bannerLocalExtra;
        this.nativeLocalExtra = builder.nativeLocalExtra;
    }

    public /* synthetic */ ATSharedPlacementConfig(com.anythink.core.api.ATSharedPlacementConfig.Builder builder, com.anythink.core.api.ATSharedPlacementConfig.AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public java.util.Map<java.lang.String, java.lang.Object> getBannerLocalExtra() {
        return this.bannerLocalExtra;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getInterstitialLocalExtra() {
        return this.interstitialLocalExtra;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getNativeLocalExtra() {
        return this.nativeLocalExtra;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getRewardVideoLocalExtra() {
        return this.rewardVideoLocalExtra;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getSplashLocalExtra() {
        return this.splashLocalExtra;
    }

    public java.lang.String toString() {
        return "ATSharedPlacementConfig{rewardVideoLocalExtra=" + this.rewardVideoLocalExtra + ", interstitialLocalExtra=" + this.interstitialLocalExtra + ", splashLocalExtra=" + this.splashLocalExtra + ", bannerLocalExtra=" + this.bannerLocalExtra + ", nativeLocalExtra=" + this.nativeLocalExtra + '}';
    }
}
