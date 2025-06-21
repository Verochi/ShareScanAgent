package com.xiaomi.push;

/* loaded from: classes19.dex */
final class ac implements java.lang.Runnable {
    final /* synthetic */ android.os.IBinder a;
    final /* synthetic */ com.xiaomi.push.ab.b b;

    public ac(com.xiaomi.push.ab.b bVar, android.os.IBinder iBinder) {
        this.b = bVar;
        this.a = iBinder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            java.lang.String packageName = com.xiaomi.push.ab.this.a.getPackageName();
            java.lang.String c = com.xiaomi.push.ab.this.c();
            com.xiaomi.push.ab.a aVar = new com.xiaomi.push.ab.a(com.xiaomi.push.ab.this, (byte) 0);
            aVar.a = com.xiaomi.push.ab.c.a(this.a, packageName, c, "GUID");
            aVar.b = com.xiaomi.push.ab.c.a(this.a, packageName, c, "OUID");
            aVar.c = com.xiaomi.push.ab.c.a(this.a, packageName, c, "DUID");
            aVar.d = com.xiaomi.push.ab.c.a(this.a, packageName, c, "AUID");
            com.xiaomi.push.ab.this.c = aVar;
            com.xiaomi.push.ab.a(com.xiaomi.push.ab.this);
            com.xiaomi.push.ab.this.b = 2;
            synchronized (com.xiaomi.push.ab.this.d) {
                try {
                    com.xiaomi.push.ab.this.d.notifyAll();
                } catch (java.lang.Exception unused) {
                }
            }
        } catch (java.lang.Exception unused2) {
            com.xiaomi.push.ab.a(com.xiaomi.push.ab.this);
            com.xiaomi.push.ab.this.b = 2;
            synchronized (com.xiaomi.push.ab.this.d) {
                try {
                    com.xiaomi.push.ab.this.d.notifyAll();
                } catch (java.lang.Exception unused3) {
                }
            }
        } catch (java.lang.Throwable th) {
            com.xiaomi.push.ab.a(com.xiaomi.push.ab.this);
            com.xiaomi.push.ab.this.b = 2;
            synchronized (com.xiaomi.push.ab.this.d) {
                try {
                    com.xiaomi.push.ab.this.d.notifyAll();
                } catch (java.lang.Exception unused4) {
                }
                throw th;
            }
        }
    }
}
