package com.anythink.china.a.a;

/* loaded from: classes12.dex */
public final class r {
    com.anythink.china.a.a.q a;
    android.content.ServiceConnection b = new com.anythink.china.a.a.r.AnonymousClass1();
    private android.content.Context c;

    /* renamed from: com.anythink.china.a.a.r$1, reason: invalid class name */
    public class AnonymousClass1 implements android.content.ServiceConnection {
        public AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            com.anythink.china.a.a.r.this.a = new com.anythink.china.a.a.q.a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
        }
    }

    public r(android.content.Context context) {
        this.c = context;
    }

    public final void a(com.anythink.china.a.a aVar) {
        com.anythink.china.a.a.q qVar;
        try {
            android.content.Intent intent = new android.content.Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (!this.c.bindService(intent, this.b, 1) || (qVar = this.a) == null) {
                aVar.a();
            } else {
                aVar.a(qVar.a(), false);
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
            aVar.a();
        }
    }
}
