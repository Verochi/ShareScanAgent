package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class CPUAggregationRequest {
    private java.util.HashMap<java.lang.String, java.lang.Object> mParameters;

    public static class Builder {
        private java.util.HashMap<java.lang.String, java.lang.Object> mExtras = new java.util.HashMap<>();

        public com.baidu.mobads.sdk.api.CPUAggregationRequest.Builder addExtra(java.lang.String str, java.lang.String str2) {
            if (!android.text.TextUtils.isEmpty(str)) {
                this.mExtras.put(str, str2);
            }
            return this;
        }

        public com.baidu.mobads.sdk.api.CPUAggregationRequest build() {
            return new com.baidu.mobads.sdk.api.CPUAggregationRequest(this, null);
        }

        public com.baidu.mobads.sdk.api.CPUAggregationRequest.Builder setAccessType(int i) {
            this.mExtras.put("accessType", java.lang.Integer.valueOf(i));
            return this;
        }

        public com.baidu.mobads.sdk.api.CPUAggregationRequest.Builder setCity(java.lang.String str) {
            this.mExtras.put(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_CITY, str);
            return this;
        }

        public com.baidu.mobads.sdk.api.CPUAggregationRequest.Builder setCustomUserId(java.lang.String str) {
            this.mExtras.put("outerUid", str);
            return this;
        }

        public com.baidu.mobads.sdk.api.CPUAggregationRequest.Builder setLpDarkMode(boolean z) {
            if (z) {
                this.mExtras.put("preferscolortheme", "dark");
            } else {
                this.mExtras.put("preferscolortheme", "light");
            }
            return this;
        }

        public com.baidu.mobads.sdk.api.CPUAggregationRequest.Builder setLpFontSize(com.baidu.mobads.sdk.api.CpuLpFontSize cpuLpFontSize) {
            this.mExtras.put("prefersfontsize", cpuLpFontSize.getValue());
            return this;
        }

        public com.baidu.mobads.sdk.api.CPUAggregationRequest.Builder setSubChannelId(java.lang.String str) {
            this.mExtras.put("subChannelId", str);
            return this;
        }
    }

    private CPUAggregationRequest(com.baidu.mobads.sdk.api.CPUAggregationRequest.Builder builder) {
        this.mParameters = new java.util.HashMap<>();
        if (builder == null || builder.mExtras == null) {
            return;
        }
        this.mParameters = builder.mExtras;
    }

    public /* synthetic */ CPUAggregationRequest(com.baidu.mobads.sdk.api.CPUAggregationRequest.Builder builder, com.baidu.mobads.sdk.api.CPUAggregationRequest.AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public java.util.HashMap<java.lang.String, java.lang.Object> getExtras() {
        return this.mParameters;
    }
}
