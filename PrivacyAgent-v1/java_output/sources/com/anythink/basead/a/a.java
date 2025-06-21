package com.anythink.basead.a;

/* loaded from: classes12.dex */
public final class a {
    public static final int A = 27;
    public static final int B = 28;
    public static final int C = 29;
    public static final int D = 30;
    public static final int E = 31;
    public static final int F = 32;
    public static final int G = 33;
    public static final int H = 34;
    public static final int I = 35;
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 6;
    public static final int g = 7;
    public static final int h = 8;
    public static final int i = 9;
    public static final int j = 10;
    public static final int k = 11;
    public static final int l = 12;
    public static final int m = 13;
    public static final int n = 14;
    public static final int o = 15;
    public static final int p = 16;
    public static final int q = 17;
    public static final int r = 18;

    /* renamed from: s, reason: collision with root package name */
    public static final int f141s = 19;
    public static final int t = 20;
    public static final int u = 21;
    public static final int v = 22;
    public static final int w = 23;
    public static final int x = 24;
    public static final int y = 25;
    public static final int z = 26;

    /* renamed from: com.anythink.basead.a.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.f.l a;
        final /* synthetic */ android.content.Context b;

        public AnonymousClass1(com.anythink.core.common.f.l lVar, android.content.Context context) {
            this.a = lVar;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.a instanceof com.anythink.core.common.f.ai) {
                com.anythink.basead.a.g.a(this.b).a();
                com.anythink.basead.a.g.a(this.b).a(this.a.s(), this.a);
            }
        }
    }

    /* renamed from: com.anythink.basead.a.a$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.f.l a;
        final /* synthetic */ int b;
        final /* synthetic */ com.anythink.basead.c.i c;

        public AnonymousClass2(com.anythink.core.common.f.l lVar, int i, com.anythink.basead.c.i iVar) {
            this.a = lVar;
            this.b = i;
            this.c = iVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.f.l lVar = this.a;
            if (lVar instanceof com.anythink.core.common.f.z) {
                com.anythink.core.common.f.z zVar = (com.anythink.core.common.f.z) lVar;
                boolean a = lVar.n() != null ? com.anythink.basead.a.a.a(this.b, this.a.n()) : false;
                if (this.b == 8) {
                    new com.anythink.basead.g.c(zVar.W(), this.c.a, a).a(0, (com.anythink.core.common.h.k) null);
                }
                com.anythink.basead.g.b bVar = new com.anythink.basead.g.b(this.b, zVar, this.c.a);
                bVar.a(this.c.b);
                bVar.a(0, (com.anythink.core.common.h.k) null);
            } else {
                com.anythink.basead.a.i.a(this.b, (com.anythink.core.common.f.ai) lVar, this.c);
            }
            if (this.b == 21) {
                com.anythink.core.common.f.l lVar2 = this.a;
                if (lVar2 instanceof com.anythink.core.common.f.j) {
                    com.anythink.core.common.f.j jVar = (com.anythink.core.common.f.j) lVar2;
                    if (jVar.c() == 1) {
                        if (!com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f().getApplicationContext(), jVar.E())) {
                            jVar.aa();
                            jVar.E();
                        } else {
                            jVar.aa();
                            jVar.E();
                            com.anythink.core.common.a.c.a().c(jVar);
                        }
                    }
                }
            }
        }
    }

    public static void a(int i2, com.anythink.core.common.f.l lVar, @androidx.annotation.NonNull com.anythink.basead.c.i iVar) {
        if (lVar.O()) {
            return;
        }
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.basead.a.a.AnonymousClass2(lVar, i2, iVar), 13);
    }

    private static void a(com.anythink.core.common.f.l lVar) {
        if (lVar instanceof com.anythink.core.common.f.j) {
            com.anythink.core.common.f.j jVar = (com.anythink.core.common.f.j) lVar;
            if (jVar.c() == 1) {
                if (!com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f().getApplicationContext(), jVar.E())) {
                    jVar.aa();
                    jVar.E();
                } else {
                    jVar.aa();
                    jVar.E();
                    com.anythink.core.common.a.c.a().c(jVar);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0021, code lost:
    
        if (r4.j() == 1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002b, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002d, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0028, code lost:
    
        if (r4.i() == 1) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(int i2, com.anythink.core.common.f.n nVar) {
        boolean z2 = true;
        if (i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4 && i2 != 5 && i2 != 8) {
            if (i2 != 9) {
                if (i2 != 35) {
                    return false;
                }
            }
        }
    }

    public static boolean a(android.content.Context context, com.anythink.core.common.f.l lVar) {
        if (!android.text.TextUtils.isEmpty(lVar.C()) && com.anythink.core.basead.a.a.a(context, lVar.C(), false)) {
            return true;
        }
        if (android.text.TextUtils.isEmpty(lVar.E())) {
            return false;
        }
        return com.anythink.basead.a.b.a(context, lVar.E());
    }

    public static boolean a(android.content.Context context, com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar, com.anythink.basead.c.d dVar, java.lang.String str, com.anythink.core.common.g.b bVar) {
        try {
            com.anythink.core.api.IExHandler b2 = com.anythink.core.common.b.o.a().b();
            java.lang.String str2 = (dVar == null || android.text.TextUtils.isEmpty(dVar.c)) ? "" : dVar.c;
            if (b2 != null) {
                android.content.Context applicationContext = context.getApplicationContext();
                b2.handleOfferClick(applicationContext, mVar, lVar, str, str2, new com.anythink.basead.a.a.AnonymousClass1(lVar, applicationContext), bVar);
                return true;
            }
        } catch (java.lang.Throwable unused) {
        }
        return false;
    }

    public static boolean a(android.content.Context context, java.lang.String str) {
        if (context != null && !android.text.TextUtils.isEmpty(str)) {
            try {
                context.getPackageManager().getApplicationInfo(str, 8192);
                return true;
            } catch (java.lang.Throwable unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001d, code lost:
    
        if (((com.anythink.core.common.f.z) r3).V() == 1) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0010, code lost:
    
        if (((com.anythink.core.common.f.aj) r4).at() == 1) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0020, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(com.anythink.core.common.f.l lVar, com.anythink.core.common.f.n nVar) {
        boolean z2 = true;
        if (lVar instanceof com.anythink.core.common.f.j) {
            if (!(nVar instanceof com.anythink.core.common.f.aj)) {
                return false;
            }
        } else if (!(lVar instanceof com.anythink.core.common.f.z)) {
            return false;
        }
    }
}
