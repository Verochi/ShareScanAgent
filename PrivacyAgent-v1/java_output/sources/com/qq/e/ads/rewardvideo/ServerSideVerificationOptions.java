package com.qq.e.ads.rewardvideo;

/* loaded from: classes19.dex */
public class ServerSideVerificationOptions {
    public static final java.lang.String ACTION = "rewardAction";
    public static final java.lang.String TRANS_ID = "transId";
    private java.lang.String a;
    private java.lang.String b;
    private final org.json.JSONObject c;

    public static class Builder {
        private java.lang.String a;
        private java.lang.String b;

        public com.qq.e.ads.rewardvideo.ServerSideVerificationOptions build() {
            return new com.qq.e.ads.rewardvideo.ServerSideVerificationOptions(this, null);
        }

        public com.qq.e.ads.rewardvideo.ServerSideVerificationOptions.Builder setCustomData(java.lang.String str) {
            this.a = str;
            return this;
        }

        public com.qq.e.ads.rewardvideo.ServerSideVerificationOptions.Builder setUserId(java.lang.String str) {
            this.b = str;
            return this;
        }
    }

    private ServerSideVerificationOptions(com.qq.e.ads.rewardvideo.ServerSideVerificationOptions.Builder builder) {
        this.c = new org.json.JSONObject();
        this.a = builder.a;
        this.b = builder.b;
    }

    public /* synthetic */ ServerSideVerificationOptions(com.qq.e.ads.rewardvideo.ServerSideVerificationOptions.Builder builder, com.qq.e.ads.rewardvideo.ServerSideVerificationOptions.AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public java.lang.String getCustomData() {
        return this.a;
    }

    public org.json.JSONObject getOptions() {
        return this.c;
    }

    public java.lang.String getUserId() {
        return this.b;
    }
}
