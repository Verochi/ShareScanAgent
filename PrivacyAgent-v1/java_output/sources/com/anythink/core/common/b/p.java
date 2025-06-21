package com.anythink.core.common.b;

/* loaded from: classes12.dex */
public final class p implements com.anythink.core.api.ATBiddingListener {
    private com.anythink.core.api.ATBiddingListener a;
    private java.util.Map<java.lang.String, java.lang.Object> b;
    private int c;

    /* renamed from: com.anythink.core.common.b.p$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ com.anythink.core.api.BaseAd a;
        final /* synthetic */ com.anythink.core.api.ATBiddingResult b;

        public AnonymousClass1(com.anythink.core.api.BaseAd baseAd, com.anythink.core.api.ATBiddingResult aTBiddingResult) {
            this.a = baseAd;
            this.b = aTBiddingResult;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
            if (com.anythink.core.common.b.p.this.a != null) {
                com.anythink.core.common.b.p.this.a.onC2SBiddingResultWithCache(com.anythink.core.api.ATBiddingResult.fail("load image failed: ".concat(java.lang.String.valueOf(str2))), null);
            }
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (!android.text.TextUtils.equals(str, this.a.getMainImageUrl()) || com.anythink.core.common.b.p.this.a == null) {
                return;
            }
            com.anythink.core.common.b.p.this.a.onC2SBiddingResultWithCache(this.b, new com.anythink.core.common.f.a.e(this.a, com.anythink.core.common.b.p.this.b));
        }
    }

    public p(com.anythink.core.api.ATBiddingListener aTBiddingListener, java.util.Map<java.lang.String, java.lang.Object> map, int i) {
        this.a = aTBiddingListener;
        this.b = map;
        this.c = i;
    }

    @Override // com.anythink.core.api.ATBiddingListener
    public final void onC2SBidResult(com.anythink.core.api.ATBiddingResult aTBiddingResult) {
        com.anythink.core.api.ATBiddingListener aTBiddingListener = this.a;
        if (aTBiddingListener != null) {
            aTBiddingListener.onC2SBidResult(aTBiddingResult);
        }
    }

    @Override // com.anythink.core.api.ATBiddingListener
    public final void onC2SBiddingResultWithCache(com.anythink.core.api.ATBiddingResult aTBiddingResult, com.anythink.core.api.BaseAd baseAd) {
        if (this.c != 0 || !aTBiddingResult.isSuccessWithUseType()) {
            com.anythink.core.api.ATBiddingListener aTBiddingListener = this.a;
            if (aTBiddingListener != null) {
                aTBiddingListener.onC2SBiddingResultWithCache(aTBiddingResult, baseAd);
                return;
            }
            return;
        }
        if (baseAd == null) {
            com.anythink.core.api.ATBiddingListener aTBiddingListener2 = this.a;
            if (aTBiddingListener2 != null) {
                aTBiddingListener2.onC2SBiddingResultWithCache(com.anythink.core.api.ATBiddingResult.fail("load fail with no adObject"), null);
                return;
            }
            return;
        }
        if (!android.text.TextUtils.isEmpty(baseAd.getMainImageUrl())) {
            com.anythink.core.common.res.b.a(com.anythink.core.common.b.o.a().f()).a(new com.anythink.core.common.res.e(2, baseAd.getMainImageUrl()), 0, 0, new com.anythink.core.common.b.p.AnonymousClass1(baseAd, aTBiddingResult));
            return;
        }
        com.anythink.core.api.ATBiddingListener aTBiddingListener3 = this.a;
        if (aTBiddingListener3 != null) {
            aTBiddingListener3.onC2SBiddingResultWithCache(aTBiddingResult, new com.anythink.core.common.f.a.e(baseAd, this.b));
        }
    }
}
