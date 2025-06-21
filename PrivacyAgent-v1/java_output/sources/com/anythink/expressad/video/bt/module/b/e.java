package com.anythink.expressad.video.bt.module.b;

/* loaded from: classes12.dex */
public final class e extends com.anythink.expressad.video.bt.module.b.c {
    private static final java.lang.String a = "ProxyShowRewardListener";
    private com.anythink.expressad.video.bt.module.b.h b;
    private com.anythink.expressad.videocommon.e.d c;
    private java.lang.String d;
    private java.lang.String e;
    private boolean f;
    private android.content.Context g;
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;

    /* JADX WARN: Removed duplicated region for block: B:12:0x004c A[Catch: Exception -> 0x0070, TryCatch #0 {Exception -> 0x0070, blocks: (B:3:0x0016, B:5:0x0026, B:7:0x002f, B:9:0x0038, B:10:0x0042, B:12:0x004c, B:14:0x0052, B:16:0x0058, B:18:0x0062, B:21:0x0066, B:23:0x006a), top: B:2:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0052 A[Catch: Exception -> 0x0070, TryCatch #0 {Exception -> 0x0070, blocks: (B:3:0x0016, B:5:0x0026, B:7:0x002f, B:9:0x0038, B:10:0x0042, B:12:0x004c, B:14:0x0052, B:16:0x0058, B:18:0x0062, B:21:0x0066, B:23:0x006a), top: B:2:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e(android.content.Context context, boolean z, com.anythink.expressad.videocommon.e.d dVar, com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.video.bt.module.b.h hVar, java.lang.String str, java.lang.String str2) {
        long j;
        this.b = hVar;
        this.c = dVar;
        this.d = str2;
        this.e = str;
        this.f = z;
        this.g = context;
        try {
            if (!android.text.TextUtils.isEmpty(com.anythink.expressad.foundation.b.a.b().e())) {
                com.anythink.expressad.d.b.a();
                com.anythink.expressad.d.a b = com.anythink.expressad.d.b.b();
                if (b == null) {
                    com.anythink.expressad.d.b.a();
                    b = com.anythink.expressad.d.b.c();
                }
                if (b != null) {
                    j = b.l() * 1000;
                    com.anythink.expressad.videocommon.e.a b2 = com.anythink.expressad.videocommon.e.c.a().b();
                    long c = b2 != null ? b2.c() : 0L;
                    if (cVar == null) {
                        if (!cVar.a(c, j)) {
                            cVar.e(0);
                            cVar.m(0);
                            return;
                        }
                        cVar.e(1);
                        if (dVar.M() == 1) {
                            cVar.m(1);
                            return;
                        } else {
                            cVar.m(0);
                            return;
                        }
                    }
                    return;
                }
            }
            j = 0;
            com.anythink.expressad.videocommon.e.a b22 = com.anythink.expressad.videocommon.e.c.a().b();
            if (b22 != null) {
            }
            if (cVar == null) {
            }
        } catch (java.lang.Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0036 A[Catch: Exception -> 0x005b, TryCatch #0 {Exception -> 0x005b, blocks: (B:2:0x0000, B:4:0x0010, B:6:0x0019, B:8:0x0022, B:9:0x002c, B:11:0x0036, B:13:0x003c, B:15:0x0043, B:17:0x004d, B:20:0x0051, B:22:0x0055), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c A[Catch: Exception -> 0x005b, TryCatch #0 {Exception -> 0x005b, blocks: (B:2:0x0000, B:4:0x0010, B:6:0x0019, B:8:0x0022, B:9:0x002c, B:11:0x0036, B:13:0x003c, B:15:0x0043, B:17:0x004d, B:20:0x0051, B:22:0x0055), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(com.anythink.expressad.videocommon.e.d dVar, com.anythink.expressad.foundation.d.c cVar) {
        long j;
        try {
            if (!android.text.TextUtils.isEmpty(com.anythink.expressad.foundation.b.a.b().e())) {
                com.anythink.expressad.d.b.a();
                com.anythink.expressad.d.a b = com.anythink.expressad.d.b.b();
                if (b == null) {
                    com.anythink.expressad.d.b.a();
                    b = com.anythink.expressad.d.b.c();
                }
                if (b != null) {
                    j = b.l() * 1000;
                    com.anythink.expressad.videocommon.e.a b2 = com.anythink.expressad.videocommon.e.c.a().b();
                    long c = b2 != null ? b2.c() : 0L;
                    if (cVar == null) {
                        if (!cVar.a(c, j)) {
                            cVar.e(0);
                            cVar.m(0);
                            return;
                        }
                        cVar.e(1);
                        if (dVar.M() == 1) {
                            cVar.m(1);
                            return;
                        } else {
                            cVar.m(0);
                            return;
                        }
                    }
                    return;
                }
            }
            j = 0;
            com.anythink.expressad.videocommon.e.a b22 = com.anythink.expressad.videocommon.e.c.a().b();
            if (b22 != null) {
            }
            if (cVar == null) {
            }
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void a() {
        super.a();
        com.anythink.expressad.video.bt.module.b.h hVar = this.b;
        if (hVar == null || this.h) {
            return;
        }
        this.h = true;
        hVar.a();
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        super.a(cVar);
        com.anythink.expressad.video.bt.module.b.h hVar = this.b;
        if (hVar != null) {
            hVar.a(cVar);
        }
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void a(java.lang.String str) {
        super.a(str);
        com.anythink.expressad.video.bt.module.b.h hVar = this.b;
        if (hVar == null || this.i) {
            return;
        }
        this.i = true;
        hVar.a(str);
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void a(boolean z, int i) {
        super.a(z, i);
        com.anythink.expressad.video.bt.module.b.h hVar = this.b;
        if (hVar == null || this.j) {
            return;
        }
        hVar.a(z, i);
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void a(boolean z, com.anythink.expressad.videocommon.c.c cVar) {
        super.a(z, cVar);
        com.anythink.expressad.video.bt.module.b.h hVar = this.b;
        if (hVar == null || this.j) {
            return;
        }
        this.j = true;
        hVar.a(z, cVar);
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void b() {
        super.b();
        com.anythink.expressad.video.bt.module.b.h hVar = this.b;
        if (hVar != null) {
            hVar.b();
        }
    }

    @Override // com.anythink.expressad.video.bt.module.b.c, com.anythink.expressad.video.bt.module.b.h
    public final void c() {
        super.c();
        com.anythink.expressad.video.bt.module.b.h hVar = this.b;
        if (hVar != null) {
            hVar.c();
        }
    }
}
