package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class CPUAdRequest {
    private static final java.lang.String TAG = "NativeCPUAd";
    private java.util.HashMap<java.lang.String, java.lang.Object> mParameters;

    public static class Builder {
        private java.util.HashMap<java.lang.String, java.lang.Object> mExtras = new java.util.HashMap<>();

        public com.baidu.mobads.sdk.api.CPUAdRequest.Builder addExtra(java.lang.String str, java.lang.String str2) {
            if (!android.text.TextUtils.isEmpty(str)) {
                this.mExtras.put(str, str2);
            }
            return this;
        }

        public com.baidu.mobads.sdk.api.CPUAdRequest build() {
            return new com.baidu.mobads.sdk.api.CPUAdRequest(this, null);
        }

        public com.baidu.mobads.sdk.api.CPUAdRequest.Builder setAccessType(int i) {
            this.mExtras.put("accessType", java.lang.Integer.valueOf(i));
            return this;
        }

        public com.baidu.mobads.sdk.api.CPUAdRequest.Builder setBarType(com.baidu.mobads.sdk.api.CpuLpActionBar cpuLpActionBar) {
            this.mExtras.put("customizedBar", cpuLpActionBar.getVlaue());
            return this;
        }

        public com.baidu.mobads.sdk.api.CPUAdRequest.Builder setCityIfLocalChannel(java.lang.String str) {
            this.mExtras.put("listScene", 6);
            this.mExtras.put(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_CITY, str);
            return this;
        }

        public com.baidu.mobads.sdk.api.CPUAdRequest.Builder setCustomUserId(java.lang.String str) {
            this.mExtras.put("outerUid", str);
            return this;
        }

        @java.lang.Deprecated
        public com.baidu.mobads.sdk.api.CPUAdRequest.Builder setDownloadAppConfirmPolicy(int i) {
            this.mExtras.put("downloadAppConfirmPolicy", java.lang.Integer.valueOf(i));
            return this;
        }

        public com.baidu.mobads.sdk.api.CPUAdRequest.Builder setKeyWords(java.lang.String str) {
            this.mExtras.put("keywords", str);
            return this;
        }

        public com.baidu.mobads.sdk.api.CPUAdRequest.Builder setListScene(int i) {
            this.mExtras.put("listScene", java.lang.Integer.valueOf(i));
            return this;
        }

        public com.baidu.mobads.sdk.api.CPUAdRequest.Builder setLpDarkMode(boolean z) {
            if (z) {
                this.mExtras.put("preferscolortheme", "dark");
            } else {
                this.mExtras.put("preferscolortheme", "light");
            }
            return this;
        }

        public com.baidu.mobads.sdk.api.CPUAdRequest.Builder setLpFontSize(com.baidu.mobads.sdk.api.CpuLpFontSize cpuLpFontSize) {
            this.mExtras.put("prefersfontsize", cpuLpFontSize.getValue());
            return this;
        }

        public com.baidu.mobads.sdk.api.CPUAdRequest.Builder setSubChannelId(java.lang.String str) {
            this.mExtras.put("subChannelId", str);
            return this;
        }
    }

    private CPUAdRequest(com.baidu.mobads.sdk.api.CPUAdRequest.Builder builder) {
        this.mParameters = new java.util.HashMap<>();
        if (builder == null || builder.mExtras == null) {
            return;
        }
        this.mParameters = builder.mExtras;
    }

    public /* synthetic */ CPUAdRequest(com.baidu.mobads.sdk.api.CPUAdRequest.Builder builder, com.baidu.mobads.sdk.api.CPUAdRequest.AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public java.util.HashMap<java.lang.String, java.lang.Object> getExtras() {
        return this.mParameters;
    }
}
