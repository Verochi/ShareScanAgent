package com.bytedance.sdk.openadsdk.t.vw.t;

/* loaded from: classes22.dex */
public class wg {

    /* renamed from: com.bytedance.sdk.openadsdk.t.vw.t.wg$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter<java.lang.String> {
        final /* synthetic */ com.bytedance.sdk.openadsdk.AdSlot vw;

        public AnonymousClass1(com.bytedance.sdk.openadsdk.AdSlot adSlot) {
            this.vw = adSlot;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: vw, reason: merged with bridge method [inline-methods] */
        public java.lang.String get() {
            return this.vw.getRewardName();
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.t.vw.t.wg$2, reason: invalid class name */
    public class AnonymousClass2 implements com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter<java.lang.Integer> {
        final /* synthetic */ com.bytedance.sdk.openadsdk.AdSlot vw;

        public AnonymousClass2(com.bytedance.sdk.openadsdk.AdSlot adSlot) {
            this.vw = adSlot;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: vw, reason: merged with bridge method [inline-methods] */
        public java.lang.Integer get() {
            return java.lang.Integer.valueOf(this.vw.getRewardAmount());
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.t.vw.t.wg$3, reason: invalid class name */
    public class AnonymousClass3 implements com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter<java.lang.Boolean> {
        final /* synthetic */ com.bytedance.sdk.openadsdk.AdSlot vw;

        public AnonymousClass3(com.bytedance.sdk.openadsdk.AdSlot adSlot) {
            this.vw = adSlot;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: vw, reason: merged with bridge method [inline-methods] */
        public java.lang.Boolean get() {
            return java.lang.Boolean.valueOf(this.vw.isSupportIconStyle());
        }
    }

    public static final com.bykv.vk.openvk.api.proto.ValueSet vw(com.bytedance.sdk.openadsdk.AdSlot adSlot) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw();
        if (adSlot == null) {
            return null;
        }
        vw.vw(260001, adSlot.getAdId());
        vw.vw(260002, adSlot.getCreativeId());
        vw.vw(260003, adSlot.getExt());
        vw.vw(260004, adSlot.getCodeId());
        vw.vw(260005, adSlot.isAutoPlay());
        vw.vw(260006, adSlot.getImgAcceptedWidth());
        vw.vw(260007, adSlot.getImgAcceptedHeight());
        vw.vw(260008, adSlot.getExpressViewAcceptedWidth());
        vw.vw(260009, adSlot.getExpressViewAcceptedHeight());
        vw.vw(260010, adSlot.isSupportDeepLink());
        vw.vw(260011, adSlot.isSupportRenderConrol());
        vw.vw(2600012, adSlot.getAdCount());
        vw.vw(260013, adSlot.getMediaExtra());
        vw.vw(260014, adSlot.getUserID());
        vw.vw(260015, adSlot.getOrientation());
        vw.vw(260016, adSlot.getNativeAdType());
        vw.vw(260017, adSlot.getExternalABVid());
        vw.vw(260018, adSlot.getAdloadSeq());
        vw.vw(260019, adSlot.getPrimeRit());
        vw.vw(260020, adSlot.getAdType());
        vw.vw(260021, adSlot.getBidAdm());
        vw.vw(260022, adSlot.getUserData());
        vw.vw(260023, adSlot.getAdLoadType());
        vw.vw(260024, new com.bytedance.sdk.openadsdk.t.vw.t.wg.AnonymousClass1(adSlot));
        vw.vw(260025, new com.bytedance.sdk.openadsdk.t.vw.t.wg.AnonymousClass2(adSlot));
        vw.vw(260026, new com.bytedance.sdk.openadsdk.t.vw.t.wg.AnonymousClass3(adSlot));
        return vw.wg();
    }
}
