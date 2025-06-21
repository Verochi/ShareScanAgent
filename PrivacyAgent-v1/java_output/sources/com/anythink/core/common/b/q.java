package com.anythink.core.common.b;

/* loaded from: classes12.dex */
public final class q implements com.anythink.core.api.ATCustomLoadListener {
    com.anythink.core.api.ATCustomLoadListener a;
    java.util.Map<java.lang.String, java.lang.Object> b;
    int c;

    /* renamed from: com.anythink.core.common.b.q$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ com.anythink.core.api.BaseAd a;

        public AnonymousClass1(com.anythink.core.api.BaseAd baseAd) {
            this.a = baseAd;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
            com.anythink.core.api.ATCustomLoadListener aTCustomLoadListener = com.anythink.core.common.b.q.this.a;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdLoadError("10011", "load image fail:".concat(java.lang.String.valueOf(str2)));
            }
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            com.anythink.core.common.b.q qVar;
            com.anythink.core.api.ATCustomLoadListener aTCustomLoadListener;
            if (!android.text.TextUtils.equals(str, this.a.getMainImageUrl()) || (aTCustomLoadListener = (qVar = com.anythink.core.common.b.q.this).a) == null) {
                return;
            }
            aTCustomLoadListener.onAdCacheLoaded(new com.anythink.core.common.f.a.e(this.a, qVar.b));
        }
    }

    public q(com.anythink.core.api.ATCustomLoadListener aTCustomLoadListener, java.util.Map<java.lang.String, java.lang.Object> map, int i) {
        this.a = aTCustomLoadListener;
        this.b = map;
        this.c = i;
    }

    @Override // com.anythink.core.api.ATCustomLoadListener
    public final void onAdCacheLoaded(com.anythink.core.api.BaseAd... baseAdArr) {
        if (this.c != 0) {
            com.anythink.core.api.ATCustomLoadListener aTCustomLoadListener = this.a;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdCacheLoaded(new com.anythink.core.api.BaseAd[0]);
                return;
            }
            return;
        }
        if (baseAdArr.length <= 0) {
            com.anythink.core.api.ATCustomLoadListener aTCustomLoadListener2 = this.a;
            if (aTCustomLoadListener2 != null) {
                aTCustomLoadListener2.onAdLoadError("10011", "load fail with no adObject");
                return;
            }
            return;
        }
        com.anythink.core.api.BaseAd baseAd = baseAdArr[0];
        if (android.text.TextUtils.isEmpty(baseAd.getMainImageUrl())) {
            this.a.onAdCacheLoaded(new com.anythink.core.common.f.a.e(baseAd, this.b));
        } else {
            com.anythink.core.common.res.b.a(com.anythink.core.common.b.o.a().f()).a(new com.anythink.core.common.res.e(2, baseAd.getMainImageUrl()), 0, 0, new com.anythink.core.common.b.q.AnonymousClass1(baseAd));
        }
    }

    @Override // com.anythink.core.api.ATCustomLoadListener
    public final void onAdDataLoaded() {
        com.anythink.core.api.ATCustomLoadListener aTCustomLoadListener = this.a;
        if (aTCustomLoadListener != null) {
            aTCustomLoadListener.onAdDataLoaded();
        }
    }

    @Override // com.anythink.core.api.ATCustomLoadListener
    public final void onAdLoadError(java.lang.String str, java.lang.String str2) {
        com.anythink.core.api.ATCustomLoadListener aTCustomLoadListener = this.a;
        if (aTCustomLoadListener != null) {
            aTCustomLoadListener.onAdLoadError(str, str2);
        }
    }
}
