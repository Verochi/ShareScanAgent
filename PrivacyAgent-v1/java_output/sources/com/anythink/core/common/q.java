package com.anythink.core.common;

/* loaded from: classes12.dex */
public class q {
    public static final java.lang.String a = "q";
    private static volatile com.anythink.core.common.q b;
    private android.content.Context c;

    /* renamed from: com.anythink.core.common.q$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.f.i a;
        final /* synthetic */ int b;
        final /* synthetic */ com.anythink.core.d.a c;

        public AnonymousClass1(com.anythink.core.common.f.i iVar, int i, com.anythink.core.d.a aVar) {
            this.a = iVar;
            this.b = i;
            this.c = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            java.lang.String str;
            try {
                java.lang.System.currentTimeMillis();
                if (com.anythink.core.d.f.a(com.anythink.core.common.b.o.a().f()).a(this.a.b.ac()) == null) {
                    return;
                }
                java.lang.String C = ((com.anythink.core.common.f.h) this.a.b).C();
                if (android.text.TextUtils.isEmpty(C)) {
                    return;
                }
                int i = this.b;
                if (i == 4) {
                    r2 = ((com.anythink.core.common.f.h) this.a.b).y() == 1;
                    str = this.c.U().get("show");
                } else if (i != 6) {
                    switch (i) {
                        case 18:
                        case 19:
                        case 20:
                            r2 = ((com.anythink.core.common.f.h) this.a.b).g() == 1;
                            str = this.c.U().get("dl");
                            break;
                        default:
                            str = null;
                            break;
                    }
                } else {
                    r2 = ((com.anythink.core.common.f.h) this.a.b).z() == 1;
                    str = this.c.U().get(com.anythink.expressad.foundation.d.c.ca);
                }
                java.lang.String str2 = str;
                if (r2 && !android.text.TextUtils.isEmpty(str2)) {
                    org.json.JSONObject a = com.anythink.core.common.o.n.a();
                    java.lang.String str3 = com.anythink.core.common.q.a;
                    a.toString();
                    this.a.a().toString();
                    com.anythink.core.common.q.a(com.anythink.core.common.q.this, this.b, str2, a.toString(), this.a.a().toString(), C, (com.anythink.core.common.f.h) this.a.b);
                }
                java.lang.String str4 = com.anythink.core.common.q.a;
                java.lang.System.currentTimeMillis();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* renamed from: com.anythink.core.common.q$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.d.a a;

        public AnonymousClass2(com.anythink.core.d.a aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (com.anythink.core.common.q.this.c == null) {
                    return;
                }
                java.lang.String packageName = com.anythink.core.common.q.this.c.getPackageName();
                java.lang.String str = "";
                for (int i = 0; i < 2; i++) {
                    str = str + packageName;
                }
                java.lang.String c = com.anythink.core.common.o.g.c(str);
                android.content.Intent intent = new android.content.Intent(c);
                intent.putExtra(c, this.a.P());
                intent.putExtra("data", com.anythink.core.common.o.n.a().toString());
                intent.putExtra(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_CLASS_DENIED, com.anythink.core.common.b.o.a().e());
                intent.setPackage(packageName);
                com.anythink.core.common.b.l.a(com.anythink.core.common.q.this.c).a(intent);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    private q(android.content.Context context) {
        this.c = context.getApplicationContext();
    }

    public static com.anythink.core.common.q a(android.content.Context context) {
        if (b == null) {
            synchronized (com.anythink.core.common.q.class) {
                if (b == null) {
                    b = new com.anythink.core.common.q(context);
                }
            }
        }
        return b;
    }

    private void a(int i, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, com.anythink.core.common.f.h hVar) {
        if (this.c == null) {
            return;
        }
        try {
            android.content.Intent intent = new android.content.Intent(str);
            intent.putExtra("common", str2);
            intent.putExtra("data", str3);
            intent.putExtra("adsourceId", str4);
            intent.putExtra("networkType", java.lang.String.valueOf(hVar.M()));
            intent.putExtra("format", hVar.ae());
            intent.putExtra("showid", hVar.q());
            intent.putExtra("tktype", i);
            intent.setPackage(this.c.getPackageName());
            com.anythink.core.common.b.l.a(this.c).a(intent);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static /* synthetic */ void a(com.anythink.core.common.q qVar, int i, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, com.anythink.core.common.f.h hVar) {
        if (qVar.c != null) {
            try {
                android.content.Intent intent = new android.content.Intent(str);
                intent.putExtra("common", str2);
                intent.putExtra("data", str3);
                intent.putExtra("adsourceId", str4);
                intent.putExtra("networkType", java.lang.String.valueOf(hVar.M()));
                intent.putExtra("format", hVar.ae());
                intent.putExtra("showid", hVar.q());
                intent.putExtra("tktype", i);
                intent.setPackage(qVar.c.getPackageName());
                com.anythink.core.common.b.l.a(qVar.c).a(intent);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public final void a(int i, com.anythink.core.common.f.i iVar, com.anythink.core.d.a aVar) {
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.q.AnonymousClass1(iVar, i, aVar), 13, false);
    }

    public final void a(com.anythink.core.d.a aVar) {
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.q.AnonymousClass2(aVar), 1000L);
    }
}
