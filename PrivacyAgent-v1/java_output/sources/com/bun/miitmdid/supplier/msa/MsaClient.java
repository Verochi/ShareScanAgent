package com.bun.miitmdid.supplier.msa;

@androidx.annotation.Keep
/* loaded from: classes.dex */
public class MsaClient {
    private static java.lang.String TAG = "MSA Client library";
    private static java.lang.String TARGET_PACKAGE = "com.mdid.msa";
    private com.bun.miitmdid.c.e.a _BindService;
    private android.content.ServiceConnection mConnection;
    private android.content.Context mContext;
    private com.bun.lib.d mDeviceidInterface;

    public class a implements android.content.ServiceConnection {
        final /* synthetic */ com.bun.miitmdid.c.e.a a;

        public a(com.bun.miitmdid.c.e.a aVar) {
            this.a = aVar;
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            com.bun.miitmdid.supplier.msa.MsaClient.this.mDeviceidInterface = com.bun.lib.d.a.a(iBinder);
            new com.bun.miitmdid.supplier.msa.a(com.bun.miitmdid.supplier.msa.MsaClient.this.mDeviceidInterface, this.a).executeOnExecutor(android.os.AsyncTask.THREAD_POOL_EXECUTOR, new java.lang.Void[0]);
            com.bun.lib.a.b(com.bun.miitmdid.supplier.msa.MsaClient.TAG, "Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
            com.bun.miitmdid.supplier.msa.MsaClient.this.mDeviceidInterface = null;
            com.bun.lib.a.b(com.bun.miitmdid.supplier.msa.MsaClient.TAG, "Service onServiceDisconnected");
            com.bun.miitmdid.supplier.msa.MsaClient.this.mDeviceidInterface = null;
        }
    }

    public MsaClient(android.content.Context context, com.bun.miitmdid.c.e.a aVar) {
        if (context == null) {
            throw new java.lang.NullPointerException("Context can not be null.");
        }
        this.mContext = context;
        this._BindService = aVar;
        this.mConnection = new com.bun.miitmdid.supplier.msa.MsaClient.a(aVar);
    }

    public static boolean CheckService(android.content.Context context) {
        try {
            context.getPackageManager().getPackageInfo(TARGET_PACKAGE, 0);
            return true;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void StartMsaKlService(android.content.Context context, java.lang.String str) {
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName(TARGET_PACKAGE, "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            if (context.startService(intent) == null) {
                com.bun.lib.a.a(TAG, "start msa kl service error");
            }
        } catch (java.lang.Exception e) {
            com.bun.lib.a.a(TAG, "start msa kl service exception", e);
        }
    }

    public void BindService(java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3;
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        if (this.mContext.bindService(intent, this.mConnection, 1)) {
            str2 = TAG;
            str3 = "bindService Successful!";
        } else {
            com.bun.miitmdid.c.e.a aVar = this._BindService;
            if (aVar != null) {
                aVar.b();
            }
            str2 = TAG;
            str3 = "bindService Failed!";
        }
        com.bun.lib.a.b(str2, str3);
    }

    public java.lang.String getAAID() {
        try {
            com.bun.lib.d dVar = this.mDeviceidInterface;
            return dVar != null ? dVar.getAAID() : "";
        } catch (android.os.RemoteException unused) {
            com.bun.lib.a.b(TAG, "getAAID error, RemoteException!");
            return "";
        }
    }

    public java.lang.String getOAID() {
        try {
            com.bun.lib.d dVar = this.mDeviceidInterface;
            return dVar != null ? dVar.getOAID() : "";
        } catch (android.os.RemoteException e) {
            com.bun.lib.a.a(TAG, "getOAID error, RemoteException!");
            e.printStackTrace();
            return "";
        }
    }

    public java.lang.String getUDID() {
        return "";
    }

    public java.lang.String getVAID() {
        try {
            com.bun.lib.d dVar = this.mDeviceidInterface;
            return dVar != null ? dVar.getVAID() : "";
        } catch (android.os.RemoteException unused) {
            com.bun.lib.a.b(TAG, "getVAID error, RemoteException!");
            return "";
        }
    }

    public boolean isSupported() {
        try {
            if (this.mDeviceidInterface == null) {
                return false;
            }
            com.bun.lib.a.b(TAG, "Device support opendeviceid");
            return this.mDeviceidInterface.isSupported();
        } catch (java.lang.Exception unused) {
            com.bun.lib.a.b(TAG, "isSupport error, RemoteException!");
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void shutdown() {
        com.bun.lib.d dVar = this.mDeviceidInterface;
        if (dVar == null) {
            return;
        }
        try {
            try {
                dVar.shutDown();
                android.content.ServiceConnection serviceConnection = this.mConnection;
                if (serviceConnection != null) {
                    this.mContext.unbindService(serviceConnection);
                }
                com.bun.lib.a.b(TAG, "unBind Service successful");
            } catch (java.lang.Exception unused) {
                com.bun.lib.a.b(TAG, "unBind Service exception");
            }
        } finally {
            this.mConnection = null;
            this.mDeviceidInterface = null;
        }
    }
}
