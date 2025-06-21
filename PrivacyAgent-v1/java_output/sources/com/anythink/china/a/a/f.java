package com.anythink.china.a.a;

/* loaded from: classes12.dex */
public final class f implements android.content.ServiceConnection {
    private android.content.Context a;
    private com.anythink.china.a.a b;

    public f(android.content.Context context) {
        this.a = context;
    }

    public final void a(com.anythink.china.a.a aVar) {
        if (this.a == null) {
            return;
        }
        this.b = aVar;
        try {
            android.content.Intent intent = new android.content.Intent("android.service.action.msa");
            intent.setPackage("com.android.creator");
            this.a.bindService(intent, this, 1);
        } catch (java.lang.Throwable th) {
            th.getMessage();
            aVar.a();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        try {
            com.anythink.china.a.a.e a = com.anythink.china.a.a.e.b.a(iBinder);
            if (a != null) {
                this.b.a(a.b(), false);
            } else {
                this.b.a();
            }
        } catch (java.lang.Throwable th) {
            try {
                com.anythink.china.a.a aVar = this.b;
                if (aVar != null) {
                    th.getMessage();
                    aVar.a();
                }
                try {
                    this.a.unbindService(this);
                } catch (java.lang.Throwable th2) {
                    th2.printStackTrace();
                }
            } finally {
                try {
                    this.a.unbindService(this);
                } catch (java.lang.Throwable th3) {
                    th3.printStackTrace();
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(android.content.ComponentName componentName) {
    }
}
