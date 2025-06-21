package com.anythink.core.common.b;

/* loaded from: classes12.dex */
public class j {
    private static volatile com.anythink.core.common.b.j b;
    private final java.lang.String a = getClass().getSimpleName();
    private java.lang.String c;
    private java.lang.String d;
    private java.lang.String e;
    private boolean f;
    private boolean g;

    public static com.anythink.core.common.b.j a() {
        if (b == null) {
            synchronized (com.anythink.core.common.b.j.class) {
                if (b == null) {
                    b = new com.anythink.core.common.b.j();
                }
            }
        }
        return b;
    }

    private boolean e() {
        return (android.text.TextUtils.isEmpty(this.c) || android.text.TextUtils.isEmpty(this.d) || android.text.TextUtils.isEmpty(this.e)) ? false : true;
    }

    public final void a(int i, com.anythink.core.common.f.h hVar) {
        if (hVar != null) {
            if (i == 4 || i == 6) {
                com.anythink.core.d.a b2 = com.anythink.core.d.b.a(com.anythink.core.common.b.o.a().f()).b(com.anythink.core.common.b.o.a().o());
                if (com.anythink.core.common.b.o.a().H()) {
                    a(b2);
                    if (e()) {
                        java.lang.String str = "";
                        try {
                            java.util.Map<java.lang.String, java.lang.Object> l = com.anythink.core.common.b.o.a().l();
                            if (l != null) {
                                str = l.get("user_id").toString();
                            }
                        } catch (java.lang.Throwable unused) {
                        }
                        try {
                            if (b2.p() == 1 && i == 4) {
                                com.reyun.mobdna.MobDNA.dna_event_ad(str, hVar.M(), hVar.p(), java.lang.String.valueOf(hVar.B()), 2);
                            } else if (b2.n() == 1 && i == 6) {
                                com.reyun.mobdna.MobDNA.dna_event_ad(str, hVar.M(), hVar.p(), java.lang.String.valueOf(hVar.B()), 3);
                            }
                        } catch (java.lang.Throwable unused2) {
                        }
                    }
                }
            }
        }
    }

    public final synchronized boolean a(com.anythink.core.d.a aVar) {
        if (this.g) {
            return true;
        }
        if (aVar == null || aVar.l() != 1) {
            return false;
        }
        try {
            if (android.text.TextUtils.isEmpty(this.c) || android.text.TextUtils.isEmpty(this.d) || android.text.TextUtils.isEmpty(this.e)) {
                com.reyun.mobdna.MobClientInfo clientInfo = com.reyun.mobdna.MobDNA.getClientInfo(com.anythink.core.common.b.o.a().f());
                if (clientInfo == null) {
                    return false;
                }
                this.c = clientInfo.oid;
                this.d = clientInfo.appkey;
                this.e = clientInfo.rdid;
            }
        } catch (java.lang.Throwable unused) {
        }
        boolean e = e();
        this.g = e;
        if (!this.f && e) {
            this.f = true;
            com.anythink.core.common.n.c.b(this.c, this.d, this.e);
        }
        return this.g;
    }

    public final java.lang.String b() {
        return this.c;
    }

    public final java.lang.String c() {
        return this.d;
    }

    public final java.lang.String d() {
        return this.e;
    }
}
