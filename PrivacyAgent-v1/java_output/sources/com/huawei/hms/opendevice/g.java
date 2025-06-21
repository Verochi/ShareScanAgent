package com.huawei.hms.opendevice;

/* loaded from: classes22.dex */
public class g implements android.content.ServiceConnection {
    public final /* synthetic */ android.os.Bundle a;
    public final /* synthetic */ android.content.Context b;
    public final /* synthetic */ com.huawei.hms.opendevice.h c;

    public g(com.huawei.hms.opendevice.h hVar, android.os.Bundle bundle, android.content.Context context) {
        this.c = hVar;
        this.a = bundle;
        this.b = context;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        android.content.ServiceConnection serviceConnection;
        android.os.Messenger messenger;
        com.huawei.hms.support.log.HMSLog.i("RemoteService", "remote service onConnected");
        this.c.b = new android.os.Messenger(iBinder);
        android.os.Message obtain = android.os.Message.obtain();
        obtain.setData(this.a);
        try {
            messenger = this.c.b;
            messenger.send(obtain);
        } catch (android.os.RemoteException unused) {
            com.huawei.hms.support.log.HMSLog.i("RemoteService", "remote service message send failed");
        }
        com.huawei.hms.support.log.HMSLog.i("RemoteService", "remote service unbindservice");
        android.content.Context context = this.b;
        serviceConnection = this.c.a;
        context.unbindService(serviceConnection);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(android.content.ComponentName componentName) {
        com.huawei.hms.support.log.HMSLog.i("RemoteService", "remote service onDisconnected");
        this.c.b = null;
    }
}
