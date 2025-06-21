package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
class as implements android.content.ServiceConnection {
    final /* synthetic */ com.xiaomi.mipush.sdk.ao a;

    public as(com.xiaomi.mipush.sdk.ao aoVar) {
        this.a = aoVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        java.util.List<android.os.Message> list;
        java.util.List list2;
        android.os.Messenger messenger;
        synchronized (this.a) {
            this.a.f31a = new android.os.Messenger(iBinder);
            this.a.c = false;
            list = this.a.f34a;
            for (android.os.Message message : list) {
                try {
                    messenger = this.a.f31a;
                    messenger.send(message);
                } catch (android.os.RemoteException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
            list2 = this.a.f34a;
            list2.clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(android.content.ComponentName componentName) {
        this.a.f31a = null;
        this.a.c = false;
    }
}
