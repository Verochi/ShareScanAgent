package org.repackage.com.zui.opendeviceidlibrary;

/* loaded from: classes26.dex */
public class OpenDeviceId {
    public static boolean e;
    public org.repackage.com.zui.deviceidservice.IDeviceidInterface b;
    public android.content.ServiceConnection c;
    public android.content.Context a = null;
    public org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId.CallBack d = null;

    /* renamed from: org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId$1, reason: invalid class name */
    public class AnonymousClass1 implements android.content.ServiceConnection {
        public AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId.this.b = org.repackage.com.zui.deviceidservice.IDeviceidInterface.Stub.a(iBinder);
            if (org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId.this.d != null) {
                org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId.this.d.a("Deviceid Service Connected", org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId.this);
            }
            org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId.this.d("Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
            org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId.this.b = null;
            org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId.this.d("Service onServiceDisconnected");
        }
    }

    public interface CallBack<T> {
        void a(T t, org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId openDeviceId);
    }

    public int a(android.content.Context context, org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId.CallBack<java.lang.String> callBack) {
        if (context == null) {
            throw new java.lang.NullPointerException("Context can not be null.");
        }
        this.a = context;
        this.d = callBack;
        this.c = new org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId.AnonymousClass1();
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName("org.repackage.com.zui.deviceidservice", "org.repackage.com.zui.deviceidservice.DeviceidService");
        if (this.a.bindService(intent, this.c, 1)) {
            d("bindService Successful!");
            return 1;
        }
        d("bindService Failed!");
        return -1;
    }

    public java.lang.String a() {
        if (this.a == null) {
            f("Context is null.");
            throw new java.lang.IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            org.repackage.com.zui.deviceidservice.IDeviceidInterface iDeviceidInterface = this.b;
            if (iDeviceidInterface != null) {
                return iDeviceidInterface.a();
            }
            return null;
        } catch (android.os.RemoteException e2) {
            f("getOAID error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    public void a(boolean z) {
        e = z;
    }

    public java.lang.String b() {
        if (this.a == null) {
            f("Context is null.");
            throw new java.lang.IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            org.repackage.com.zui.deviceidservice.IDeviceidInterface iDeviceidInterface = this.b;
            if (iDeviceidInterface != null) {
                return iDeviceidInterface.b();
            }
            return null;
        } catch (android.os.RemoteException e2) {
            f("getUDID error, RemoteException!");
            e2.printStackTrace();
            return null;
        } catch (java.lang.Exception e3) {
            f("getUDID error, Exception!");
            e3.printStackTrace();
            return null;
        }
    }

    public boolean c() {
        try {
            if (this.b == null) {
                return false;
            }
            d("Device support opendeviceid");
            return this.b.c();
        } catch (android.os.RemoteException unused) {
            f("isSupport error, RemoteException!");
            return false;
        }
    }

    public java.lang.String d() {
        android.content.Context context = this.a;
        if (context == null) {
            d("Context is null.");
            throw new java.lang.IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        java.lang.String packageName = context.getPackageName();
        d("liufeng, getVAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            d("input package is null!");
            return null;
        }
        try {
            org.repackage.com.zui.deviceidservice.IDeviceidInterface iDeviceidInterface = this.b;
            if (iDeviceidInterface != null) {
                return iDeviceidInterface.a(packageName);
            }
            return null;
        } catch (android.os.RemoteException e2) {
            f("getVAID error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    public final void d(java.lang.String str) {
    }

    public java.lang.String e() {
        android.content.Context context = this.a;
        if (context == null) {
            d("Context is null.");
            throw new java.lang.IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        java.lang.String packageName = context.getPackageName();
        d("liufeng, getAAID package：" + packageName);
        java.lang.String str = null;
        if (packageName == null || packageName.equals("")) {
            d("input package is null!");
            return null;
        }
        try {
            org.repackage.com.zui.deviceidservice.IDeviceidInterface iDeviceidInterface = this.b;
            if (iDeviceidInterface == null) {
                return null;
            }
            str = iDeviceidInterface.b(packageName);
            return ((str == null || "".equals(str)) && this.b.c(packageName)) ? this.b.b(packageName) : str;
        } catch (android.os.RemoteException unused) {
            f("getAAID error, RemoteException!");
            return str;
        }
    }

    public void f() {
        try {
            this.a.unbindService(this.c);
            d("unBind Service successful");
        } catch (java.lang.IllegalArgumentException unused) {
            f("unBind Service exception");
        }
        this.b = null;
    }

    public final void f(java.lang.String str) {
    }
}
