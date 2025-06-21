package com.tanx.onlyid.api.impl;

/* loaded from: classes19.dex */
class OAIDService implements android.content.ServiceConnection {
    public final android.content.Context n;
    public final com.tanx.onlyid.api.IGetter t;
    public final com.tanx.onlyid.api.impl.OAIDService.RemoteCaller u;

    @java.lang.FunctionalInterface
    public interface RemoteCaller {
        java.lang.String callRemoteInterface(android.os.IBinder iBinder) throws com.tanx.onlyid.api.OAIDException, android.os.RemoteException;
    }

    public OAIDService(android.content.Context context, com.tanx.onlyid.api.IGetter iGetter, com.tanx.onlyid.api.impl.OAIDService.RemoteCaller remoteCaller) {
        if (context instanceof android.app.Application) {
            this.n = context;
        } else {
            this.n = context.getApplicationContext();
        }
        this.t = iGetter;
        this.u = remoteCaller;
    }

    public static void a(android.content.Context context, android.content.Intent intent, com.tanx.onlyid.api.IGetter iGetter, com.tanx.onlyid.api.impl.OAIDService.RemoteCaller remoteCaller) {
        new com.tanx.onlyid.api.impl.OAIDService(context, iGetter, remoteCaller).b(intent);
    }

    public final void b(android.content.Intent intent) {
        try {
            if (!this.n.bindService(intent, this, 1)) {
                throw new com.tanx.onlyid.api.OAIDException("Service binding failed");
            }
            com.tanx.onlyid.api.OAIDLog.print("Service has been bound: " + intent);
        } catch (java.lang.Exception e) {
            this.t.oaidError(e);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        com.tanx.onlyid.api.OAIDLog.print("Service has been connected: " + componentName.getClassName());
        try {
            try {
                try {
                    java.lang.String callRemoteInterface = this.u.callRemoteInterface(iBinder);
                    if (callRemoteInterface == null || callRemoteInterface.length() == 0) {
                        throw new com.tanx.onlyid.api.OAIDException("OAID/AAID acquire failed");
                    }
                    com.tanx.onlyid.api.OAIDLog.print("OAID/AAID acquire success: " + callRemoteInterface);
                    this.t.oaidSucc(callRemoteInterface);
                    this.n.unbindService(this);
                    com.tanx.onlyid.api.OAIDLog.print("Service has been unbound: " + componentName.getClassName());
                } catch (java.lang.Exception e) {
                    com.tanx.onlyid.api.OAIDLog.print(e);
                }
            } catch (java.lang.Exception e2) {
                com.tanx.onlyid.api.OAIDLog.print(e2);
                this.t.oaidError(e2);
                this.n.unbindService(this);
                com.tanx.onlyid.api.OAIDLog.print("Service has been unbound: " + componentName.getClassName());
            }
        } catch (java.lang.Throwable th) {
            try {
                this.n.unbindService(this);
                com.tanx.onlyid.api.OAIDLog.print("Service has been unbound: " + componentName.getClassName());
            } catch (java.lang.Exception e3) {
                com.tanx.onlyid.api.OAIDLog.print(e3);
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(android.content.ComponentName componentName) {
        com.tanx.onlyid.api.OAIDLog.print("Service has been disconnected: " + componentName.getClassName());
    }
}
