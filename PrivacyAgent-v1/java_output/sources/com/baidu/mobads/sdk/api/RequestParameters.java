package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public final class RequestParameters {
    public static final int ADS_TYPE_DOWNLOAD = 2;
    public static final int ADS_TYPE_OPENPAGE = 1;
    public static final int DOWNLOAD_APP_CONFIRM_ALWAYS = 2;
    public static final int DOWNLOAD_APP_CONFIRM_CUSTOM_BY_APP = 4;
    public static final int DOWNLOAD_APP_CONFIRM_NEVER = 3;
    public static final int DOWNLOAD_APP_CONFIRM_ONLY_MOBILE = 1;
    public static final int MAX_ASSETS_RESERVED = 15;
    public static final java.lang.String TAG = "RequestParameters";
    private int adsType;
    private boolean confirmDownloading;
    private java.util.Map<java.lang.String, java.lang.String> customExt;
    private boolean customSize;
    private int downloadAppConfirmPolicy;
    private java.util.Map<java.lang.String, java.lang.String> extras;
    private int height;
    private java.lang.String mAdPlaceId;
    private int mBidFloor;
    private final java.lang.String mKeywords;
    private int width;

    public static class Builder {
        private java.lang.String adPlaceId;
        private java.lang.String keywords;
        private java.util.Map<java.lang.String, java.lang.String> extras = new java.util.HashMap();
        private java.util.Map<java.lang.String, java.lang.String> customExt = new java.util.HashMap();
        private int adsType = 3;
        private boolean clickConfirm = false;
        private int width = com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH;
        private int height = com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH;
        private int downloadAppConfirmPolicy = 3;
        private boolean customSize = false;
        private int bidFloor = -1;

        public final com.baidu.mobads.sdk.api.RequestParameters.Builder addCustExt(java.lang.String str, java.lang.String str2) {
            this.customExt.put(str, str2);
            return this;
        }

        public final com.baidu.mobads.sdk.api.RequestParameters.Builder addExtra(java.lang.String str, java.lang.String str2) {
            this.extras.put(str, str2);
            return this;
        }

        public final com.baidu.mobads.sdk.api.RequestParameters build() {
            return new com.baidu.mobads.sdk.api.RequestParameters(this, null);
        }

        @java.lang.Deprecated
        public final com.baidu.mobads.sdk.api.RequestParameters.Builder confirmDownloading(boolean z) {
            if (z) {
                downloadAppConfirmPolicy(2);
            } else {
                downloadAppConfirmPolicy(3);
            }
            return this;
        }

        @java.lang.Deprecated
        public final com.baidu.mobads.sdk.api.RequestParameters.Builder downloadAppConfirmPolicy(int i) {
            this.downloadAppConfirmPolicy = i;
            return this;
        }

        public final com.baidu.mobads.sdk.api.RequestParameters.Builder setAdPlaceId(java.lang.String str) {
            this.adPlaceId = str;
            return this;
        }

        public final com.baidu.mobads.sdk.api.RequestParameters.Builder setBidFloor(int i) {
            this.bidFloor = i;
            return this;
        }

        public final com.baidu.mobads.sdk.api.RequestParameters.Builder setHeight(int i) {
            this.height = i;
            this.customSize = true;
            return this;
        }

        public final com.baidu.mobads.sdk.api.RequestParameters.Builder setWidth(int i) {
            this.width = i;
            this.customSize = true;
            return this;
        }
    }

    private RequestParameters(com.baidu.mobads.sdk.api.RequestParameters.Builder builder) {
        this.width = 0;
        this.height = 0;
        this.mBidFloor = -1;
        this.mKeywords = builder.keywords;
        this.adsType = builder.adsType;
        this.width = builder.width;
        this.height = builder.height;
        this.customSize = builder.customSize;
        this.confirmDownloading = builder.clickConfirm;
        this.downloadAppConfirmPolicy = builder.downloadAppConfirmPolicy;
        this.mAdPlaceId = builder.adPlaceId;
        this.mBidFloor = builder.bidFloor;
        setExtras(builder.extras);
        setExt(builder.customExt);
    }

    public /* synthetic */ RequestParameters(com.baidu.mobads.sdk.api.RequestParameters.Builder builder, com.baidu.mobads.sdk.api.RequestParameters.AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public int getAPPConfirmPolicy() {
        return this.downloadAppConfirmPolicy;
    }

    public java.lang.String getAdPlacementId() {
        return this.mAdPlaceId;
    }

    public int getAdsType() {
        return this.adsType;
    }

    public int getBidFloor() {
        return this.mBidFloor;
    }

    public java.util.Map<java.lang.String, java.lang.String> getExt() {
        return this.customExt;
    }

    public java.util.Map<java.lang.String, java.lang.String> getExtras() {
        return this.extras;
    }

    public int getHeight() {
        return this.height;
    }

    public final java.lang.String getKeywords() {
        return this.mKeywords;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isConfirmDownloading() {
        return this.confirmDownloading;
    }

    public boolean isCustomSize() {
        return this.customSize;
    }

    public void setAdsType(int i) {
        this.adsType = i;
    }

    public void setExt(java.util.Map<java.lang.String, java.lang.String> map) {
        this.customExt = map;
    }

    public void setExtras(java.util.Map<java.lang.String, java.lang.String> map) {
        this.extras = map;
    }

    public java.util.HashMap<java.lang.String, java.lang.Object> toHashMap() {
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
        hashMap.put("mKeywords", this.mKeywords);
        hashMap.put("adsType", java.lang.Integer.valueOf(this.adsType));
        hashMap.put("confirmDownloading", java.lang.Boolean.valueOf(this.confirmDownloading));
        java.util.HashMap hashMap2 = new java.util.HashMap();
        java.util.Map<java.lang.String, java.lang.String> map = this.extras;
        if (map != null) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                hashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        hashMap.put("extras", hashMap2);
        java.util.HashMap hashMap3 = new java.util.HashMap();
        java.util.Map<java.lang.String, java.lang.String> map2 = this.customExt;
        if (map2 != null) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry2 : map2.entrySet()) {
                hashMap3.put(entry2.getKey(), entry2.getValue());
            }
        }
        hashMap.put("ext", hashMap3);
        return hashMap;
    }
}
