package com.xiaomi.push;

/* renamed from: com.xiaomi.push.do, reason: invalid class name */
/* loaded from: classes19.dex */
public final class Cdo {
    private static com.xiaomi.push.Cdo.a a;
    private static java.util.Map<java.lang.String, com.xiaomi.push.gu> b;

    /* renamed from: com.xiaomi.push.do$a */
    public interface a {
        void uploader(android.content.Context context, com.xiaomi.push.go goVar);
    }

    public static int a(java.lang.Enum r1) {
        if (r1 != null) {
            if (r1 instanceof com.xiaomi.push.gk) {
                return r1.ordinal() + 1001;
            }
            if (r1 instanceof com.xiaomi.push.gu) {
                return r1.ordinal() + 2001;
            }
            if (r1 instanceof com.xiaomi.push.dx) {
                return r1.ordinal() + 3001;
            }
        }
        return -1;
    }

    public static com.xiaomi.a.a.b a(java.lang.String str, java.lang.String str2, int i, long j, java.lang.String str3) {
        com.xiaomi.a.a.b bVar = new com.xiaomi.a.a.b();
        bVar.e = 1000;
        bVar.g = 1001;
        bVar.f = str;
        bVar.a = str2;
        bVar.b = i;
        bVar.c = j;
        bVar.d = str3;
        return bVar;
    }

    public static com.xiaomi.a.a.c a(int i, long j) {
        com.xiaomi.a.a.c cVar = new com.xiaomi.a.a.c();
        cVar.e = 1000;
        cVar.g = 1000;
        cVar.f = "P100000";
        cVar.a = i;
        cVar.b = 1L;
        cVar.c = j;
        return cVar;
    }

    public static com.xiaomi.push.gu a(java.lang.String str) {
        if (b == null) {
            synchronized (com.xiaomi.push.gu.class) {
                if (b == null) {
                    b = new java.util.HashMap();
                    for (com.xiaomi.push.gu guVar : com.xiaomi.push.gu.values()) {
                        b.put(guVar.ah.toLowerCase(), guVar);
                    }
                }
            }
        }
        com.xiaomi.push.gu guVar2 = b.get(str.toLowerCase());
        return guVar2 != null ? guVar2 : com.xiaomi.push.gu.Invalid;
    }

    public static java.lang.String a(int i) {
        return i == 1000 ? "E100000" : i == 3000 ? "E100002" : i == 2000 ? "E100001" : i == 6000 ? "E100003" : "";
    }

    public static void a(android.content.Context context) {
        com.xiaomi.a.a.a b2 = b(context);
        if (b2 != null) {
            com.xiaomi.a.b.b a2 = com.xiaomi.a.b.b.a(context);
            boolean z = b2.b;
            boolean z2 = b2.c;
            long j = b2.e;
            long j2 = b2.f;
            com.xiaomi.a.a.a aVar = a2.e;
            if (aVar != null) {
                if (z == aVar.b && z2 == aVar.c && j == aVar.e && j2 == aVar.f) {
                    return;
                }
                long j3 = aVar.e;
                long j4 = aVar.f;
                com.xiaomi.a.a.a.C0531a c0531a = new com.xiaomi.a.a.a.C0531a();
                c0531a.d = com.xiaomi.push.as.a(a2.d);
                com.xiaomi.a.a.a.C0531a b3 = c0531a.a(a2.e.a).b(z);
                b3.f = j;
                com.xiaomi.a.a.a.C0531a c = b3.c(z2);
                c.g = j2;
                com.xiaomi.a.a.a a3 = c.a(a2.d);
                a2.e = a3;
                if (!a3.b) {
                    com.xiaomi.push.m.a(a2.d).a("100886");
                } else if (j3 != a3.e) {
                    com.xiaomi.channel.commonutils.logger.b.c(a2.d.getPackageName() + "reset event job " + a3.e);
                    a2.b();
                }
                if (!a2.e.c) {
                    com.xiaomi.push.m.a(a2.d).a("100887");
                    return;
                }
                if (j4 != a3.f) {
                    com.xiaomi.channel.commonutils.logger.b.c(a2.d.getPackageName() + " reset perf job " + a3.f);
                    a2.c();
                }
            }
        }
    }

    public static void a(android.content.Context context, com.xiaomi.a.a.a aVar) {
        com.xiaomi.a.b.a.a(context, aVar, new com.xiaomi.push.dm(context), new com.xiaomi.push.dn(context));
    }

    public static void a(android.content.Context context, java.util.List<java.lang.String> list) {
        com.xiaomi.push.go goVar;
        if (list == null) {
            return;
        }
        try {
            for (java.lang.String str : list) {
                boolean z = true;
                if (android.text.TextUtils.isEmpty(str)) {
                    goVar = null;
                } else {
                    com.xiaomi.push.go goVar2 = new com.xiaomi.push.go();
                    goVar2.g = "category_client_report_data";
                    goVar2.a = "push_sdk_channel";
                    goVar2.a(1L);
                    goVar2.b = str;
                    goVar2.a(true);
                    goVar2.b(java.lang.System.currentTimeMillis());
                    goVar2.k = context.getPackageName();
                    goVar2.h = "com.xiaomi.xmsf";
                    goVar2.i = com.xiaomi.push.service.bc.a();
                    goVar2.c = "quality_support";
                    goVar = goVar2;
                }
                if (!com.xiaomi.push.service.bc.a(goVar, false)) {
                    android.content.Context applicationContext = context.getApplicationContext();
                    if (applicationContext == null || android.text.TextUtils.isEmpty(applicationContext.getPackageName()) || !"com.xiaomi.xmsf".equals(applicationContext.getPackageName())) {
                        z = false;
                    }
                    if (z) {
                        com.xiaomi.push.service.be.a(context.getApplicationContext(), goVar);
                    } else {
                        com.xiaomi.push.Cdo.a aVar = a;
                        if (aVar != null) {
                            aVar.uploader(context, goVar);
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.d(th.getMessage());
        }
    }

    public static void a(com.xiaomi.push.Cdo.a aVar) {
        a = aVar;
    }

    public static int b(int i) {
        if (i > 0) {
            return i + 1000;
        }
        return -1;
    }

    public static com.xiaomi.a.a.a b(android.content.Context context) {
        boolean a2 = com.xiaomi.push.service.ad.a(context).a(com.xiaomi.push.gp.PerfUploadSwitch.bw, false);
        boolean a3 = com.xiaomi.push.service.ad.a(context).a(com.xiaomi.push.gp.EventUploadNewSwitch.bw, false);
        int a4 = com.xiaomi.push.service.ad.a(context).a(com.xiaomi.push.gp.PerfUploadFrequency.bw, 86400);
        int a5 = com.xiaomi.push.service.ad.a(context).a(com.xiaomi.push.gp.EventUploadFrequency.bw, 86400);
        com.xiaomi.a.a.a.C0531a b2 = new com.xiaomi.a.a.a.C0531a().b(a3);
        b2.f = a5;
        com.xiaomi.a.a.a.C0531a c = b2.c(a2);
        c.g = a4;
        return c.a(context);
    }
}
