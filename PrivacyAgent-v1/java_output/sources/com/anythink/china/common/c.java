package com.anythink.china.common;

/* loaded from: classes12.dex */
public final class c implements com.anythink.china.api.CustomAdapterDownloadListener {
    com.anythink.core.api.ATBaseAdAdapter a;
    com.anythink.core.api.BaseAd b;
    com.anythink.core.api.ATAdInfo c;
    java.lang.ref.WeakReference<com.anythink.china.api.ATAppDownloadListener> d;
    long e;
    boolean f;
    boolean g;

    /* renamed from: com.anythink.china.common.c$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ long c;

        public AnonymousClass1(int i, java.lang.String str, long j) {
            this.a = i;
            this.b = str;
            this.c = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.anythink.core.common.f.i iVar = new com.anythink.core.common.f.i();
                com.anythink.china.common.c cVar = com.anythink.china.common.c.this;
                com.anythink.core.api.BaseAd baseAd = cVar.b;
                iVar.b = baseAd != null ? baseAd.getDetail() : cVar.a.getTrackingInfo();
                iVar.a = this.a;
                iVar.c = java.lang.System.currentTimeMillis();
                com.anythink.core.common.f.at atVar = iVar.b;
                if (atVar instanceof com.anythink.core.common.f.h) {
                    ((com.anythink.core.common.f.h) atVar).b(this.b);
                    ((com.anythink.core.common.f.h) iVar.b).b(this.c);
                }
                com.anythink.core.common.q.a(com.anythink.core.common.b.o.a().f()).a(this.a, iVar, com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o()));
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public c(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.api.BaseAd baseAd, com.anythink.core.api.ATEventInterface aTEventInterface) {
        this.a = aTBaseAdAdapter;
        this.b = baseAd;
        if (aTEventInterface == null || !(aTEventInterface instanceof com.anythink.china.api.ATAppDownloadListener)) {
            return;
        }
        this.d = new java.lang.ref.WeakReference<>((com.anythink.china.api.ATAppDownloadListener) aTEventInterface);
    }

    private void a() {
        com.anythink.core.api.BaseAd baseAd = this.b;
        if (baseAd != null) {
            this.c = com.anythink.core.common.b.k.a(baseAd);
        } else {
            this.c = com.anythink.core.common.b.k.a(this.a);
        }
    }

    private void a(int i, long j, java.lang.String str) {
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.china.common.c.AnonymousClass1(i, str, j), 2, true);
    }

    @Override // com.anythink.china.api.CustomAdapterDownloadListener
    public final void onDownloadFail(long j, long j2, java.lang.String str, java.lang.String str2) {
        if (this.c == null) {
            a();
        }
        java.lang.ref.WeakReference<com.anythink.china.api.ATAppDownloadListener> weakReference = this.d;
        com.anythink.china.api.ATAppDownloadListener aTAppDownloadListener = weakReference != null ? weakReference.get() : null;
        if (aTAppDownloadListener != null) {
            aTAppDownloadListener.onDownloadFail(this.c, j, j2, str, str2);
        }
    }

    @Override // com.anythink.china.api.CustomAdapterDownloadListener
    public final void onDownloadFinish(long j, java.lang.String str, java.lang.String str2) {
        if (this.c == null) {
            a();
        }
        if (this.e != 0 && !this.g) {
            this.g = true;
            a(19, android.os.SystemClock.elapsedRealtime() - this.e, str2);
        }
        java.lang.ref.WeakReference<com.anythink.china.api.ATAppDownloadListener> weakReference = this.d;
        com.anythink.china.api.ATAppDownloadListener aTAppDownloadListener = weakReference != null ? weakReference.get() : null;
        if (aTAppDownloadListener != null) {
            aTAppDownloadListener.onDownloadFinish(this.c, j, str, str2);
        }
    }

    @Override // com.anythink.china.api.CustomAdapterDownloadListener
    public final void onDownloadPause(long j, long j2, java.lang.String str, java.lang.String str2) {
        if (this.c == null) {
            a();
        }
        java.lang.ref.WeakReference<com.anythink.china.api.ATAppDownloadListener> weakReference = this.d;
        com.anythink.china.api.ATAppDownloadListener aTAppDownloadListener = weakReference != null ? weakReference.get() : null;
        if (aTAppDownloadListener != null) {
            aTAppDownloadListener.onDownloadPause(this.c, j, j2, str, str2);
        }
    }

    @Override // com.anythink.china.api.CustomAdapterDownloadListener
    public final void onDownloadStart(long j, long j2, java.lang.String str, java.lang.String str2) {
        if (this.c == null) {
            a();
        }
        this.e = android.os.SystemClock.elapsedRealtime();
        a(18, 0L, str2);
        java.lang.ref.WeakReference<com.anythink.china.api.ATAppDownloadListener> weakReference = this.d;
        com.anythink.china.api.ATAppDownloadListener aTAppDownloadListener = weakReference != null ? weakReference.get() : null;
        if (aTAppDownloadListener != null) {
            aTAppDownloadListener.onDownloadStart(this.c, j, j2, str, str2);
        }
    }

    @Override // com.anythink.china.api.CustomAdapterDownloadListener
    public final void onDownloadUpdate(long j, long j2, java.lang.String str, java.lang.String str2) {
        if (this.c == null) {
            a();
        }
        java.lang.ref.WeakReference<com.anythink.china.api.ATAppDownloadListener> weakReference = this.d;
        com.anythink.china.api.ATAppDownloadListener aTAppDownloadListener = weakReference != null ? weakReference.get() : null;
        if (aTAppDownloadListener != null) {
            aTAppDownloadListener.onDownloadUpdate(this.c, j, j2, str, str2);
        }
    }

    @Override // com.anythink.china.api.CustomAdapterDownloadListener
    public final void onInstalled(java.lang.String str, java.lang.String str2) {
        if (this.c == null) {
            a();
        }
        if (!this.f) {
            this.f = true;
            a(20, 0L, str2);
        }
        java.lang.ref.WeakReference<com.anythink.china.api.ATAppDownloadListener> weakReference = this.d;
        com.anythink.china.api.ATAppDownloadListener aTAppDownloadListener = weakReference != null ? weakReference.get() : null;
        if (aTAppDownloadListener != null) {
            aTAppDownloadListener.onInstalled(this.c, str, str2);
        }
    }
}
