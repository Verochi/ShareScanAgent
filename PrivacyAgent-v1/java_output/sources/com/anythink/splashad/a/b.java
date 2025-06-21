package com.anythink.splashad.a;

/* loaded from: classes12.dex */
public abstract class b implements com.anythink.core.common.b.b {
    private java.lang.String mRequestId;
    private volatile boolean mHasReturn = false;
    private volatile boolean isAdTimeout = false;
    private final com.anythink.core.common.m.a timeOutHandler = com.anythink.core.common.m.d.a();
    private final com.anythink.core.common.m.b timeoutRunnable = new com.anythink.splashad.a.b.AnonymousClass1();

    /* renamed from: com.anythink.splashad.a.b$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.m.b {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.splashad.a.b.this.mHasReturn) {
                return;
            }
            com.anythink.splashad.a.b.this.isAdTimeout = true;
            com.anythink.splashad.a.b bVar = com.anythink.splashad.a.b.this;
            bVar.onTimeout(bVar.mRequestId);
        }
    }

    @Override // com.anythink.core.common.b.b
    public void onAdLoadFail(com.anythink.core.api.AdError adError) {
        this.timeOutHandler.b(this.timeoutRunnable);
        if (this.mHasReturn) {
            return;
        }
        this.mHasReturn = true;
        onNoAdError(this.mRequestId, adError);
    }

    @Override // com.anythink.core.common.b.b
    public void onAdLoaded() {
        this.timeOutHandler.b(this.timeoutRunnable);
        if (this.mHasReturn) {
            return;
        }
        this.mHasReturn = true;
        onAdLoaded(this.mRequestId, this.isAdTimeout);
    }

    public abstract void onAdLoaded(java.lang.String str, boolean z);

    public abstract void onNoAdError(java.lang.String str, com.anythink.core.api.AdError adError);

    public abstract void onTimeout(java.lang.String str);

    public void setRequestId(java.lang.String str) {
        this.mRequestId = str;
    }

    public void startCountDown(int i) {
        this.timeOutHandler.a(this.timeoutRunnable, i, false);
    }
}
