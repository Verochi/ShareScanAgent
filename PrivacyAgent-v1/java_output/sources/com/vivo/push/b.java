package com.vivo.push;

/* loaded from: classes19.dex */
public final class b implements android.content.ServiceConnection {
    private static final java.lang.Object a = new java.lang.Object();
    private static java.util.Map<java.lang.String, com.vivo.push.b> b = new java.util.HashMap();
    private boolean c;
    private java.lang.String d;
    private android.content.Context e;
    private volatile com.vivo.vms.IPCInvoke g;
    private java.lang.String i;
    private android.os.Handler j;
    private java.lang.Object h = new java.lang.Object();
    private java.util.concurrent.atomic.AtomicInteger f = new java.util.concurrent.atomic.AtomicInteger(1);

    private b(android.content.Context context, java.lang.String str) {
        this.d = null;
        this.j = null;
        this.e = context;
        this.i = str;
        this.j = new android.os.Handler(android.os.Looper.getMainLooper(), new com.vivo.push.c(this));
        java.lang.String b2 = com.vivo.push.util.t.b(context);
        this.d = b2;
        if (!android.text.TextUtils.isEmpty(b2) && !android.text.TextUtils.isEmpty(this.i)) {
            this.c = com.vivo.push.util.z.a(context, this.d) >= 1260;
            b();
            return;
        }
        com.vivo.push.util.p.c(this.e, "init error : push pkgname is " + this.d + " ; action is " + this.i);
        this.c = false;
    }

    public static com.vivo.push.b a(android.content.Context context, java.lang.String str) {
        com.vivo.push.b bVar = b.get(str);
        if (bVar == null) {
            synchronized (a) {
                bVar = b.get(str);
                if (bVar == null) {
                    bVar = new com.vivo.push.b(context, str);
                    b.put(str, bVar);
                }
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.f.set(i);
    }

    private void b() {
        int i = this.f.get();
        com.vivo.push.util.p.d("AidlManager", "Enter connect, Connection Status: ".concat(java.lang.String.valueOf(i)));
        if (i == 4 || i == 2 || i == 3 || i == 5 || !this.c) {
            return;
        }
        a(2);
        if (c()) {
            d();
        } else {
            a(1);
            com.vivo.push.util.p.a("AidlManager", "bind core service fail");
        }
    }

    private boolean c() {
        android.content.Intent intent = new android.content.Intent(this.i);
        intent.setPackage(this.d);
        try {
            return this.e.bindService(intent, this, 1);
        } catch (java.lang.Exception e) {
            com.vivo.push.util.p.a("AidlManager", "bind core error", e);
            return false;
        }
    }

    private void d() {
        this.j.removeMessages(1);
        this.j.sendEmptyMessageDelayed(1, 3000L);
    }

    private void e() {
        this.j.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            this.e.unbindService(this);
        } catch (java.lang.Exception e) {
            com.vivo.push.util.p.a("AidlManager", "On unBindServiceException:" + e.getMessage());
        }
    }

    public final boolean a() {
        java.lang.String b2 = com.vivo.push.util.t.b(this.e);
        this.d = b2;
        if (android.text.TextUtils.isEmpty(b2)) {
            com.vivo.push.util.p.c(this.e, "push pkgname is null");
            return false;
        }
        boolean z = com.vivo.push.util.z.a(this.e, this.d) >= 1260;
        this.c = z;
        return z;
    }

    public final boolean a(android.os.Bundle bundle) {
        b();
        if (this.f.get() == 2) {
            synchronized (this.h) {
                try {
                    this.h.wait(2000L);
                } catch (java.lang.InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            int i = this.f.get();
            if (i != 4) {
                com.vivo.push.util.p.d("AidlManager", "invoke error : connect status = ".concat(java.lang.String.valueOf(i)));
                return false;
            }
            this.j.removeMessages(2);
            this.j.sendEmptyMessageDelayed(2, 30000L);
            this.g.asyncCall(bundle, null);
            return true;
        } catch (java.lang.Exception e2) {
            com.vivo.push.util.p.a("AidlManager", "invoke error ", e2);
            int i2 = this.f.get();
            com.vivo.push.util.p.d("AidlManager", "Enter disconnect, Connection Status: ".concat(java.lang.String.valueOf(i2)));
            if (i2 == 2) {
                e();
            } else if (i2 != 3) {
                if (i2 != 4) {
                    return false;
                }
                a(1);
                f();
                return false;
            }
            a(1);
            return false;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(android.content.ComponentName componentName) {
        com.vivo.push.util.p.b("AidlManager", "onBindingDied : ".concat(java.lang.String.valueOf(componentName)));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        e();
        this.g = com.vivo.vms.IPCInvoke.Stub.asInterface(iBinder);
        if (this.g == null) {
            com.vivo.push.util.p.d("AidlManager", "onServiceConnected error : aidl must not be null.");
            f();
            this.f.set(1);
            return;
        }
        if (this.f.get() == 2) {
            a(4);
        } else if (this.f.get() != 4) {
            f();
        }
        synchronized (this.h) {
            this.h.notifyAll();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(android.content.ComponentName componentName) {
        this.g = null;
        a(1);
    }
}
