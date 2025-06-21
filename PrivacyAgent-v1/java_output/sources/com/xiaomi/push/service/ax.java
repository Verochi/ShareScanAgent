package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class ax implements android.content.ServiceConnection {
    final /* synthetic */ com.xiaomi.push.service.a a;

    public ax(com.xiaomi.push.service.a aVar) {
        this.a = aVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        java.util.List<android.os.Message> list;
        java.util.List list2;
        android.os.Messenger messenger;
        synchronized (this.a) {
            this.a.j = new android.os.Messenger(iBinder);
            com.xiaomi.push.service.a.a(this.a);
            list = this.a.h;
            for (android.os.Message message : list) {
                try {
                    messenger = this.a.j;
                    messenger.send(message);
                } catch (android.os.RemoteException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
            list2 = this.a.h;
            list2.clear();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(android.content.ComponentName componentName) {
        this.a.j = null;
        com.xiaomi.push.service.a.a(this.a);
    }
}
