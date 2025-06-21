package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class CPUWebAdRequestParam {
    private static final java.lang.String DARK_MODE = "dark";
    private static final java.lang.String LIGHT_MODE = "light";
    private final java.util.Map<java.lang.String, java.lang.Object> mParameters;

    public static class Builder {
        private java.util.HashMap<java.lang.String, java.lang.Object> mExtras = new java.util.HashMap<>();

        public com.baidu.mobads.sdk.api.CPUWebAdRequestParam.Builder addExtra(java.lang.String str, java.lang.String str2) {
            if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
                this.mExtras.put(str, str2);
            }
            return this;
        }

        public com.baidu.mobads.sdk.api.CPUWebAdRequestParam build() {
            return new com.baidu.mobads.sdk.api.CPUWebAdRequestParam(this, null);
        }

        public com.baidu.mobads.sdk.api.CPUWebAdRequestParam.Builder setCityIfLocalChannel(java.lang.String str) {
            this.mExtras.put(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_CITY, str);
            return this;
        }

        public com.baidu.mobads.sdk.api.CPUWebAdRequestParam.Builder setCustomUserId(java.lang.String str) {
            this.mExtras.put("outerId", str);
            return this;
        }

        public com.baidu.mobads.sdk.api.CPUWebAdRequestParam.Builder setLpDarkMode(boolean z) {
            this.mExtras.put("preferscolortheme", z ? com.baidu.mobads.sdk.api.CPUWebAdRequestParam.DARK_MODE : com.baidu.mobads.sdk.api.CPUWebAdRequestParam.LIGHT_MODE);
            return this;
        }

        public com.baidu.mobads.sdk.api.CPUWebAdRequestParam.Builder setLpFontSize(com.baidu.mobads.sdk.api.CpuLpFontSize cpuLpFontSize) {
            this.mExtras.put("prefersfontsize", cpuLpFontSize.getValue());
            return this;
        }

        public com.baidu.mobads.sdk.api.CPUWebAdRequestParam.Builder setSubChannelId(java.lang.String str) {
            this.mExtras.put("scid", str);
            return this;
        }
    }

    private CPUWebAdRequestParam(com.baidu.mobads.sdk.api.CPUWebAdRequestParam.Builder builder) {
        java.util.HashMap hashMap = new java.util.HashMap();
        this.mParameters = hashMap;
        if (builder == null || builder.mExtras == null) {
            return;
        }
        hashMap.putAll(builder.mExtras);
    }

    public /* synthetic */ CPUWebAdRequestParam(com.baidu.mobads.sdk.api.CPUWebAdRequestParam.Builder builder, com.baidu.mobads.sdk.api.CPUWebAdRequestParam.AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public java.util.Map<java.lang.String, java.lang.Object> getParameters() {
        return this.mParameters;
    }
}
