package com.bun.miitmdid.supplier.sumsung;

@androidx.annotation.Keep
/* loaded from: classes.dex */
public class SumsungCore {
    private static boolean DBG = false;
    private static java.lang.String SAMSUNGTAG = "Samsung_DeviceIdService";
    private static java.lang.String TAG = "SumsungCore library";
    private com.bun.miitmdid.c.e.a mCallerCallBack;
    private android.content.ServiceConnection mConnection;
    private android.content.Context mContext;
    private com.samsung.android.deviceidservice.IDeviceIdService mDeviceidInterface;

    public class a implements android.content.ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            com.bun.miitmdid.supplier.sumsung.SumsungCore.this.mDeviceidInterface = com.samsung.android.deviceidservice.IDeviceIdService.Stub.a(iBinder);
            if (com.bun.miitmdid.supplier.sumsung.SumsungCore.this.mCallerCallBack != null) {
                com.bun.miitmdid.supplier.sumsung.SumsungCore.this.mCallerCallBack.a(true);
            }
            com.bun.lib.a.b(com.bun.miitmdid.supplier.sumsung.SumsungCore.TAG, "Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
            com.bun.miitmdid.supplier.sumsung.SumsungCore.this.mDeviceidInterface = null;
            com.bun.lib.a.b(com.bun.miitmdid.supplier.sumsung.SumsungCore.TAG, "Service onServiceDisconnected");
        }
    }

    public SumsungCore(android.content.Context context, com.bun.miitmdid.c.e.a aVar) {
        this.mContext = null;
        this.mCallerCallBack = null;
        if (context == null) {
            throw new java.lang.NullPointerException("Context can not be null.");
        }
        this.mContext = context;
        this.mCallerCallBack = aVar;
        this.mConnection = new com.bun.miitmdid.supplier.sumsung.SumsungCore.a();
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (this.mContext.bindService(intent, this.mConnection, 1)) {
            com.bun.lib.a.b(TAG, "bindService Successful!");
            return;
        }
        this.mContext.unbindService(this.mConnection);
        com.bun.lib.a.b(TAG, "bindService Failed!");
        com.bun.miitmdid.c.e.a aVar2 = this.mCallerCallBack;
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    public java.lang.String getAAID() {
        java.lang.String str;
        java.lang.String str2;
        android.content.Context context = this.mContext;
        if (context == null) {
            com.bun.lib.a.b(TAG, "Context is null.");
            throw new java.lang.IllegalArgumentException("Context is null, must be new SumsungCore first");
        }
        java.lang.String packageName = context.getPackageName();
        com.bun.lib.a.b(TAG, "liufeng, getAAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            str = TAG;
            str2 = "input package is null!";
        } else {
            try {
                if (this.mDeviceidInterface == null) {
                    return null;
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("getAAID Package: ");
                sb.append(packageName);
                return this.mDeviceidInterface.getAAID(packageName);
            } catch (android.os.RemoteException unused) {
                str = TAG;
                str2 = "getAAID error, RemoteException!";
            }
        }
        com.bun.lib.a.b(str, str2);
        return null;
    }

    public java.lang.String getOAID() {
        if (this.mContext == null) {
            com.bun.lib.a.a(TAG, "Context is null.");
            throw new java.lang.IllegalArgumentException("Context is null, must be new SumsungCore first");
        }
        try {
            if (this.mDeviceidInterface != null) {
                return this.mDeviceidInterface.getOAID();
            }
            return null;
        } catch (android.os.RemoteException e) {
            com.bun.lib.a.a(TAG, "getOAID error, RemoteException!");
            e.printStackTrace();
            return null;
        }
    }

    public java.lang.String getUDID() {
        return "";
    }

    public java.lang.String getVAID() {
        android.content.Context context = this.mContext;
        if (context == null) {
            com.bun.lib.a.b(TAG, "Context is null.");
            throw new java.lang.IllegalArgumentException("Context is null, must be new SumsungCore first");
        }
        java.lang.String packageName = context.getPackageName();
        com.bun.lib.a.b(TAG, "liufeng, getVAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            com.bun.lib.a.b(TAG, "input package is null!");
            return null;
        }
        try {
            if (this.mDeviceidInterface == null) {
                return null;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("getVAID Package: ");
            sb.append(packageName);
            return this.mDeviceidInterface.getVAID(packageName);
        } catch (android.os.RemoteException e) {
            com.bun.lib.a.b(TAG, "getVAID error, RemoteException!");
            e.printStackTrace();
            return null;
        }
    }

    public boolean isSupported() {
        try {
            if (this.mDeviceidInterface == null) {
                return false;
            }
            com.bun.lib.a.b(TAG, "Device support opendeviceid");
            return true;
        } catch (java.lang.Exception unused) {
            com.bun.lib.a.b(TAG, "isSupport error, RemoteException!");
            return false;
        }
    }

    public void shutdown() {
        try {
            this.mContext.unbindService(this.mConnection);
            com.bun.lib.a.b(TAG, "unBind Service successful");
        } catch (java.lang.IllegalArgumentException unused) {
            com.bun.lib.a.b(TAG, "unBind Service exception");
        }
        this.mDeviceidInterface = null;
    }
}
