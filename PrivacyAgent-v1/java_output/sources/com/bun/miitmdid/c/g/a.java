package com.bun.miitmdid.c.g;

/* loaded from: classes.dex */
public class a {
    private static java.lang.String e = "OpenDeviceId library";
    private static boolean f;
    private android.content.Context a;
    private com.zui.deviceidservice.IDeviceidInterface b;
    private android.content.ServiceConnection c;
    private com.bun.miitmdid.c.e.a d;

    /* renamed from: com.bun.miitmdid.c.g.a$a, reason: collision with other inner class name */
    public class ServiceConnectionC0258a implements android.content.ServiceConnection {
        public ServiceConnectionC0258a() {
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            com.bun.miitmdid.c.g.a.this.b = com.zui.deviceidservice.IDeviceidInterface.Stub.a(iBinder);
            if (com.bun.miitmdid.c.g.a.this.d != null) {
                com.bun.miitmdid.c.g.a.this.d.a(true);
            }
            com.bun.miitmdid.c.g.a.this.b("Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
            com.bun.miitmdid.c.g.a.this.b = null;
            com.bun.miitmdid.c.g.a.this.b("Service onServiceDisconnected");
        }
    }

    public a(android.content.Context context, com.bun.miitmdid.c.e.a aVar) {
        this.a = null;
        if (context == null) {
            throw new java.lang.NullPointerException("Context can not be null.");
        }
        this.a = context;
        this.d = aVar;
        this.c = new com.bun.miitmdid.c.g.a.ServiceConnectionC0258a();
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (this.a.bindService(intent, this.c, 1)) {
            b("bindService Successful!");
            return;
        }
        b("bindService Failed!");
        com.bun.miitmdid.c.e.a aVar2 = this.d;
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    private void a(java.lang.String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(java.lang.String str) {
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
            com.zui.deviceidservice.IDeviceidInterface iDeviceidInterface = this.b;
            if (iDeviceidInterface != null) {
                return iDeviceidInterface.getAAID(packageName);
            }
            return null;
        } catch (android.os.RemoteException unused) {
            a("getAAID error, RemoteException!");
            return null;
        }
    }

    public java.lang.String b() {
        if (this.a == null) {
            a("Context is null.");
            throw new java.lang.IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            com.zui.deviceidservice.IDeviceidInterface iDeviceidInterface = this.b;
            if (iDeviceidInterface != null) {
                return iDeviceidInterface.getOAID();
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
            com.zui.deviceidservice.IDeviceidInterface iDeviceidInterface = this.b;
            if (iDeviceidInterface != null) {
                return iDeviceidInterface.getUDID();
            }
            return null;
        } catch (android.os.RemoteException e2) {
            a("getUDID error, RemoteException!");
            e2.printStackTrace();
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
            com.zui.deviceidservice.IDeviceidInterface iDeviceidInterface = this.b;
            if (iDeviceidInterface != null) {
                return iDeviceidInterface.getVAID(packageName);
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
            return this.b.a();
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
