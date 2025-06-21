package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class ay {
    private static java.lang.String b;
    private static com.xiaomi.push.service.ay e = new com.xiaomi.push.service.ay();
    com.xiaomi.push.cw.a a;
    private java.util.List<com.xiaomi.push.service.ay.a> c = new java.util.ArrayList();
    private com.xiaomi.push.p.b d;

    public static abstract class a {
        public void a(com.xiaomi.push.cx.b bVar) {
        }
    }

    private ay() {
    }

    public static com.xiaomi.push.service.ay a() {
        return e;
    }

    public static /* synthetic */ void a(com.xiaomi.push.service.ay ayVar) {
        try {
            if (ayVar.a != null) {
                java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(com.xiaomi.push.jc.a().openFileOutput("XMCloudCfg", 0));
                com.xiaomi.push.az azVar = new com.xiaomi.push.az(bufferedOutputStream, new byte[4096]);
                ayVar.a.a(azVar);
                if (azVar.a != null) {
                    azVar.a();
                }
                bufferedOutputStream.close();
            }
        } catch (java.lang.Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("save config failure: " + e2.getMessage());
        }
    }

    public static /* synthetic */ com.xiaomi.push.p.b b(com.xiaomi.push.service.ay ayVar) {
        ayVar.d = null;
        return null;
    }

    public static synchronized java.lang.String e() {
        java.lang.String str;
        synchronized (com.xiaomi.push.service.ay.class) {
            if (b == null) {
                android.content.SharedPreferences sharedPreferences = com.xiaomi.push.jc.a().getSharedPreferences("XMPushServiceConfig", 0);
                java.lang.String string = sharedPreferences.getString("DeviceUUID", null);
                b = string;
                if (string == null) {
                    java.lang.String a2 = com.xiaomi.push.ib.a(com.xiaomi.push.jc.a());
                    b = a2;
                    if (a2 != null) {
                        sharedPreferences.edit().putString("DeviceUUID", b).commit();
                    }
                }
            }
            str = b;
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void f() {
        java.io.BufferedInputStream bufferedInputStream;
        java.lang.Throwable th;
        java.lang.Exception e2;
        try {
            bufferedInputStream = new java.io.BufferedInputStream(com.xiaomi.push.jc.a().openFileInput("XMCloudCfg"));
            try {
                try {
                    this.a = com.xiaomi.push.cw.a.a(com.xiaomi.push.z.a(bufferedInputStream));
                    bufferedInputStream.close();
                } catch (java.lang.Exception e3) {
                    e2 = e3;
                    com.xiaomi.channel.commonutils.logger.b.a("load config failure: " + e2.getMessage());
                    com.xiaomi.push.c.a(bufferedInputStream);
                    if (this.a != null) {
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                com.xiaomi.push.c.a(bufferedInputStream);
                throw th;
            }
        } catch (java.lang.Exception e4) {
            bufferedInputStream = null;
            e2 = e4;
        } catch (java.lang.Throwable th3) {
            bufferedInputStream = null;
            th = th3;
            com.xiaomi.push.c.a(bufferedInputStream);
            throw th;
        }
        com.xiaomi.push.c.a(bufferedInputStream);
        if (this.a != null) {
            this.a = new com.xiaomi.push.cw.a();
        }
    }

    public final void a(com.xiaomi.push.cx.b bVar) {
        com.xiaomi.push.service.ay.a[] aVarArr;
        if (bVar.c && bVar.d > d() && this.d == null) {
            com.xiaomi.push.service.az azVar = new com.xiaomi.push.service.az(this);
            this.d = azVar;
            com.xiaomi.push.fz.a(azVar);
        }
        synchronized (this) {
            java.util.List<com.xiaomi.push.service.ay.a> list = this.c;
            aVarArr = (com.xiaomi.push.service.ay.a[]) list.toArray(new com.xiaomi.push.service.ay.a[list.size()]);
        }
        for (com.xiaomi.push.service.ay.a aVar : aVarArr) {
            aVar.a(bVar);
        }
    }

    public final synchronized void a(com.xiaomi.push.service.ay.a aVar) {
        this.c.add(aVar);
    }

    public final synchronized void b() {
        this.c.clear();
    }

    public final void c() {
        if (this.a == null) {
            f();
        }
    }

    public final int d() {
        c();
        com.xiaomi.push.cw.a aVar = this.a;
        if (aVar != null) {
            return aVar.a;
        }
        return 0;
    }
}
