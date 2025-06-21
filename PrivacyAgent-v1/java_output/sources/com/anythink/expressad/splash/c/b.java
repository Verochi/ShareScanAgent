package com.anythink.expressad.splash.c;

/* loaded from: classes12.dex */
public final class b {
    private static java.lang.String a = "ResManager";
    private static int b = 1;
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> c = new java.util.concurrent.ConcurrentHashMap<>();

    /* renamed from: com.anythink.expressad.splash.c.b$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.foundation.g.d.c {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;
        final /* synthetic */ com.anythink.expressad.splash.view.a b;
        final /* synthetic */ com.anythink.expressad.splash.view.ATSplashView c;

        public AnonymousClass1(com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.splash.view.a aVar, com.anythink.expressad.splash.view.ATSplashView aTSplashView) {
            this.a = cVar;
            this.b = aVar;
            this.c = aTSplashView;
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
            com.anythink.expressad.splash.c.b.c.put(this.a.be(), java.lang.Boolean.TRUE);
            com.anythink.expressad.splash.view.a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
            com.anythink.expressad.splash.view.ATSplashView aTSplashView = this.c;
            if (aTSplashView != null) {
                aTSplashView.setImageReady(true);
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
            com.anythink.expressad.splash.c.b.c.put(this.a.be(), java.lang.Boolean.FALSE);
            com.anythink.expressad.splash.view.a aVar = this.b;
            if (aVar != null) {
                aVar.b();
            }
            com.anythink.expressad.splash.view.ATSplashView aTSplashView = this.c;
            if (aTSplashView != null) {
                aTSplashView.setImageReady(false);
            }
        }
    }

    /* renamed from: com.anythink.expressad.splash.c.b$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.expressad.foundation.g.d.c {
        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
        }
    }

    public static void a(com.anythink.expressad.splash.view.ATSplashView aTSplashView, com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.splash.view.a aVar) {
        com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).a(cVar.be(), new com.anythink.expressad.splash.c.b.AnonymousClass1(cVar, aVar, aTSplashView));
        if (android.text.TextUtils.isEmpty(cVar.bd())) {
            return;
        }
        com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).a(cVar.bd(), new com.anythink.expressad.splash.c.b.AnonymousClass2());
    }

    private static void a(com.anythink.expressad.splash.view.ATSplashView aTSplashView, java.lang.String str, com.anythink.expressad.foundation.d.c cVar, java.lang.String str2, java.lang.String str3, boolean z, int i, boolean z2) {
        com.anythink.expressad.splash.c.e.c cVar2 = new com.anythink.expressad.splash.c.e.c();
        cVar2.c(str3);
        cVar2.b(str2);
        cVar2.a(cVar);
        cVar2.a(str);
        cVar2.b(z);
        cVar2.a(i);
        cVar2.a(z2);
        com.anythink.expressad.splash.c.e.a.a.a(aTSplashView, cVar2, null);
    }

    public static void a(java.lang.String str) {
        c.remove(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(com.anythink.expressad.foundation.d.c cVar) {
        boolean z;
        android.graphics.Bitmap a2;
        if (!android.text.TextUtils.isEmpty(cVar.S())) {
            com.anythink.expressad.videocommon.b.a.a();
            java.lang.String a3 = com.anythink.expressad.videocommon.b.a.a(cVar.S());
            if (com.anythink.expressad.foundation.h.w.a(a3) || new java.io.File(a3).length() <= 0) {
                z = false;
                if (z && android.text.TextUtils.isEmpty(cVar.c()) && android.text.TextUtils.isEmpty(cVar.d())) {
                    z = false;
                }
                return !cVar.j() ? (android.text.TextUtils.isEmpty(cVar.be()) || (a2 = com.anythink.expressad.foundation.g.d.a.a(com.anythink.expressad.foundation.h.s.a(cVar.be()))) == null || a2.isRecycled()) ? false : true : z;
            }
        }
        z = true;
        if (z) {
            z = false;
        }
        if (!cVar.j()) {
        }
    }

    public static boolean a(com.anythink.expressad.splash.view.ATSplashView aTSplashView, com.anythink.expressad.foundation.d.c cVar) {
        if (aTSplashView == null) {
            return false;
        }
        boolean isVideoReady = !android.text.TextUtils.isEmpty(cVar.S()) ? aTSplashView.isVideoReady() : true;
        if (isVideoReady && !android.text.TextUtils.isEmpty(cVar.c())) {
            isVideoReady = aTSplashView.isH5Ready();
        }
        if (isVideoReady && android.text.TextUtils.isEmpty(cVar.c()) && !android.text.TextUtils.isEmpty(cVar.d())) {
            isVideoReady = aTSplashView.isH5Ready();
        }
        if (android.text.TextUtils.isEmpty(cVar.c()) && android.text.TextUtils.isEmpty(cVar.d())) {
            isVideoReady = false;
        }
        if (!cVar.j()) {
            return isVideoReady;
        }
        if (android.text.TextUtils.isEmpty(cVar.be())) {
            return false;
        }
        return aTSplashView.isImageReady();
    }

    private static com.anythink.expressad.foundation.d.c b(com.anythink.expressad.foundation.d.c cVar) {
        if (!android.text.TextUtils.isEmpty(cVar.c()) || (!android.text.TextUtils.isEmpty(cVar.d()) && cVar.d().contains("<MBTPLMARK>"))) {
            cVar.a(true);
            cVar.b(false);
        } else {
            cVar.a(false);
            cVar.b(true);
        }
        return cVar;
    }

    private static java.lang.String b(java.lang.String str) {
        try {
            java.io.File file = new java.io.File(str);
            if (!file.exists()) {
                return "";
            }
            return "file:///" + file.getAbsolutePath();
        } catch (java.lang.Throwable th) {
            try {
                throw th;
            } catch (java.lang.Exception e) {
                e.getMessage();
                return "";
            }
        }
    }
}
