package com.hihonor.push.sdk;

/* loaded from: classes22.dex */
public class l implements android.content.ServiceConnection {
    public static final java.lang.Object e = new java.lang.Object();
    public final com.hihonor.push.sdk.bean.RemoteServiceBean a;
    public final android.content.Context b;
    public com.hihonor.push.sdk.l.a c;
    public android.os.Handler d = null;

    public interface a {
    }

    public l(android.content.Context context, com.hihonor.push.sdk.bean.RemoteServiceBean remoteServiceBean) {
        this.b = context;
        this.a = remoteServiceBean;
    }

    public final void a() {
        synchronized (e) {
            android.os.Handler handler = this.d;
            if (handler != null) {
                handler.removeMessages(1001);
                this.d = null;
            }
        }
    }

    public final void a(int i) {
        com.hihonor.push.sdk.l.a aVar = this.c;
        if (aVar != null) {
            com.hihonor.push.sdk.i iVar = (com.hihonor.push.sdk.i) aVar;
            iVar.a.a.set(i == com.hihonor.push.sdk.common.data.ErrorEnum.ERROR_SERVICE_TIME_OUT.statusCode ? 2 : 1);
            iVar.a.a(i);
            iVar.a.c = null;
        }
    }

    public void b() {
        try {
            com.hihonor.push.sdk.common.logger.Logger.i("AIDLSrvConnection", "trying to unbind service from ".concat(java.lang.String.valueOf(this)));
            this.b.unbindService(this);
        } catch (java.lang.Exception e2) {
            com.hihonor.push.sdk.common.logger.Logger.e("AIDLSrvConnection", "on unBind service exception:" + e2.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(android.content.ComponentName componentName) {
        com.hihonor.push.sdk.common.logger.Logger.e("AIDLSrvConnection", "enter onNullBinding, than unBind.");
        b();
        a();
        com.hihonor.push.sdk.l.a aVar = this.c;
        if (aVar != null) {
            com.hihonor.push.sdk.i iVar = (com.hihonor.push.sdk.i) aVar;
            iVar.a.a.set(1);
            iVar.a.a(com.hihonor.push.sdk.common.data.ErrorCode.BindService.ERROR_SERVICE_NULL_BINDING);
            iVar.a.c = null;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        com.hihonor.push.sdk.common.logger.Logger.i("AIDLSrvConnection", "enter onServiceConnected.");
        a();
        com.hihonor.push.sdk.l.a aVar = this.c;
        if (aVar != null) {
            com.hihonor.push.sdk.i iVar = (com.hihonor.push.sdk.i) aVar;
            iVar.a.c = com.hihonor.push.framework.aidl.IPushInvoke.Stub.asInterface(iBinder);
            if (iVar.a.c == null) {
                com.hihonor.push.sdk.common.logger.Logger.e("PushConnectionClient", "failed to get service as interface, trying to unbind.");
                iVar.a.e.b();
                iVar.a.a.set(1);
                iVar.a.a(com.hihonor.push.sdk.common.data.ErrorCode.BindService.ERROR_BIND_SERVICE);
                return;
            }
            iVar.a.a.set(3);
            com.hihonor.push.sdk.h.a aVar2 = iVar.a.d;
            if (aVar2 != null) {
                com.hihonor.push.sdk.g.a aVar3 = (com.hihonor.push.sdk.g.a) aVar2;
                if (android.os.Looper.myLooper() == com.hihonor.push.sdk.g.this.a.getLooper()) {
                    aVar3.b();
                } else {
                    com.hihonor.push.sdk.g.this.a.post(new com.hihonor.push.sdk.e(aVar3));
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(android.content.ComponentName componentName) {
        com.hihonor.push.sdk.common.logger.Logger.i("AIDLSrvConnection", "enter onServiceDisconnected.");
        com.hihonor.push.sdk.l.a aVar = this.c;
        if (aVar != null) {
            com.hihonor.push.sdk.i iVar = (com.hihonor.push.sdk.i) aVar;
            iVar.a.a.set(1);
            iVar.a.a(com.hihonor.push.sdk.common.data.ErrorCode.BindService.ERROR_SERVICE_DISCONNECTED);
            iVar.a.c = null;
        }
        this.d = null;
        this.c = null;
    }
}
