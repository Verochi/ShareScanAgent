package com.bytedance.sdk.openadsdk.t.vw.t;

/* loaded from: classes22.dex */
public class vw {

    /* renamed from: com.bytedance.sdk.openadsdk.t.vw.t.vw$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter<java.lang.Integer> {
        final /* synthetic */ com.bytedance.sdk.openadsdk.AdConfig vw;

        public AnonymousClass1(com.bytedance.sdk.openadsdk.AdConfig adConfig) {
            this.vw = adConfig;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: vw, reason: merged with bridge method [inline-methods] */
        public java.lang.Integer get() {
            return java.lang.Integer.valueOf(this.vw.getPluginUpdateConfig());
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.t.vw.t.vw$2, reason: invalid class name */
    public class AnonymousClass2 implements com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter<java.lang.Integer> {
        final /* synthetic */ com.bytedance.sdk.openadsdk.AdConfig vw;

        public AnonymousClass2(com.bytedance.sdk.openadsdk.AdConfig adConfig) {
            this.vw = adConfig;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: vw, reason: merged with bridge method [inline-methods] */
        public java.lang.Integer get() {
            return java.lang.Integer.valueOf(this.vw.getAgeGroup());
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.t.vw.t.vw$3, reason: invalid class name */
    public class AnonymousClass3 implements com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter<java.lang.Integer> {
        final /* synthetic */ com.bytedance.sdk.openadsdk.AdConfig vw;

        public AnonymousClass3(com.bytedance.sdk.openadsdk.AdConfig adConfig) {
            this.vw = adConfig;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: vw, reason: merged with bridge method [inline-methods] */
        public java.lang.Integer get() {
            return java.lang.Integer.valueOf(this.vw.getThemeStatus());
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.t.vw.t.vw$4, reason: invalid class name */
    public class AnonymousClass4 implements com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter<java.util.Map> {
        final /* synthetic */ com.bytedance.sdk.openadsdk.AdConfig vw;

        public AnonymousClass4(com.bytedance.sdk.openadsdk.AdConfig adConfig) {
            this.vw = adConfig;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: vw, reason: merged with bridge method [inline-methods] */
        public java.util.Map get() {
            return this.vw.getInitExtra();
        }
    }

    public static final com.bykv.vk.openvk.api.proto.ValueSet vw(com.bytedance.sdk.openadsdk.AdConfig adConfig) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw();
        if (adConfig == null) {
            return null;
        }
        vw.vw(261001, adConfig.getAppId());
        vw.vw(261002, adConfig.getAppName());
        vw.vw(261003, adConfig.isPaid());
        vw.vw(261004, adConfig.getKeywords());
        vw.vw(261005, adConfig.getData());
        vw.vw(261006, adConfig.getTitleBarTheme());
        vw.vw(261007, adConfig.isAllowShowNotify());
        vw.vw(261008, adConfig.isDebug());
        vw.vw(261009, adConfig.getDirectDownloadNetworkType());
        vw.vw(261011, adConfig.isSupportMultiProcess());
        vw.vw(261012, adConfig.getCustomController() != null ? com.bytedance.sdk.openadsdk.t.vw.t.v.vw(adConfig.getCustomController()) : null);
        vw.vw(261013, new com.bytedance.sdk.openadsdk.t.vw.t.vw.AnonymousClass1(adConfig));
        vw.vw(261014, new com.bytedance.sdk.openadsdk.t.vw.t.vw.AnonymousClass2(adConfig));
        vw.vw(261015, new com.bytedance.sdk.openadsdk.t.vw.t.vw.AnonymousClass3(adConfig));
        vw.vw(261018, new com.bytedance.sdk.openadsdk.t.vw.t.vw.AnonymousClass4(adConfig));
        return vw.wg();
    }
}
