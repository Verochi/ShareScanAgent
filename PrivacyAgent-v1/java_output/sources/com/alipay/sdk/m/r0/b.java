package com.alipay.sdk.m.r0;

/* loaded from: classes.dex */
public class b {
    public static java.lang.String e = "OpenDeviceId library";
    public static boolean f;
    public com.alipay.sdk.m.q0.a b;
    public android.content.ServiceConnection c;
    public android.content.Context a = null;
    public com.alipay.sdk.m.r0.b.InterfaceC0042b d = null;

    public class a implements android.content.ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            com.alipay.sdk.m.r0.b.this.b = com.alipay.sdk.m.q0.a.AbstractBinderC0040a.a(iBinder);
            if (com.alipay.sdk.m.r0.b.this.d != null) {
                com.alipay.sdk.m.r0.b.this.d.a("Deviceid Service Connected", com.alipay.sdk.m.r0.b.this);
            }
            com.alipay.sdk.m.r0.b.this.b("Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
            com.alipay.sdk.m.r0.b.this.b = null;
            com.alipay.sdk.m.r0.b.this.b("Service onServiceDisconnected");
        }
    }

    /* renamed from: com.alipay.sdk.m.r0.b$b, reason: collision with other inner class name */
    public interface InterfaceC0042b<T> {
        void a(T t, com.alipay.sdk.m.r0.b bVar);
    }

    private void a(java.lang.String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(java.lang.String str) {
    }

    public int a(android.content.Context context, com.alipay.sdk.m.r0.b.InterfaceC0042b<java.lang.String> interfaceC0042b) {
        if (context == null) {
            throw new java.lang.NullPointerException("Context can not be null.");
        }
        this.a = context;
        this.d = interfaceC0042b;
        this.c = new com.alipay.sdk.m.r0.b.a();
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (this.a.bindService(intent, this.c, 1)) {
            b("bindService Successful!");
            return 1;
        }
        b("bindService Failed!");
        return -1;
    }

    public java.lang.String a() {
        android.content.Context context = this.a;
        if (context == null) {
            b("Context is null.");
            throw new java.lang.IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        java.lang.String packageName = context.getPackageName();
        b("liufeng, getAAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            b("input package is null!");
            return null;
        }
        try {
            com.alipay.sdk.m.q0.a aVar = this.b;
            if (aVar == null) {
                return null;
            }
            java.lang.String a2 = aVar.a(packageName);
            return ((a2 == null || "".equals(a2)) && this.b.c(packageName)) ? this.b.a(packageName) : a2;
        } catch (android.os.RemoteException unused) {
            a("getAAID error, RemoteException!");
            return null;
        }
    }

    public void a(boolean z) {
        f = z;
    }

    public java.lang.String b() {
        if (this.a == null) {
            a("Context is null.");
            throw new java.lang.IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            com.alipay.sdk.m.q0.a aVar = this.b;
            if (aVar != null) {
                return aVar.a();
            }
            return null;
        } catch (android.os.RemoteException e2) {
            a("getOAID error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    public java.lang.String c() {
        if (this.a == null) {
            a("Context is null.");
            throw new java.lang.IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            com.alipay.sdk.m.q0.a aVar = this.b;
            if (aVar != null) {
                return aVar.b();
            }
            return null;
        } catch (android.os.RemoteException e2) {
            a("getUDID error, RemoteException!");
            e2.printStackTrace();
            return null;
        } catch (java.lang.Exception e3) {
            a("getUDID error, Exception!");
            e3.printStackTrace();
            return null;
        }
    }

    public java.lang.String d() {
        android.content.Context context = this.a;
        if (context == null) {
            b("Context is null.");
            throw new java.lang.IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        java.lang.String packageName = context.getPackageName();
        b("liufeng, getVAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            b("input package is null!");
            return null;
        }
        try {
            com.alipay.sdk.m.q0.a aVar = this.b;
            if (aVar != null) {
                return aVar.b(packageName);
            }
            return null;
        } catch (android.os.RemoteException e2) {
            a("getVAID error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    public boolean e() {
        try {
            if (this.b == null) {
                return false;
            }
            b("Device support opendeviceid");
            return this.b.c();
        } catch (android.os.RemoteException unused) {
            a("isSupport error, RemoteException!");
            return false;
        }
    }

    public void f() {
        try {
            this.a.unbindService(this.c);
            b("unBind Service successful");
        } catch (java.lang.IllegalArgumentException unused) {
            a("unBind Service exception");
        }
        this.b = null;
    }
}
